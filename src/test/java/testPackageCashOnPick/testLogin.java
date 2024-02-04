package testPackageCashOnPick;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import basePackageCashOnPick.BaseClass;
import pagePackageCashOnPick.pageLogin;
import utilities.Commonutils;
import utilities.Excelutils;

/**
 * This class describes Test method of the Login Module
 * 
 * @author Cuckoo George , Feb2,2024
 */
public class testLogin extends BaseClass {
	@Test
	public void loginTest() throws IOException {
		
		pageLogin ob = new pageLogin(dr);
		extentTest = extent.createTest("loginTest");
		ob.registerIconHover();
		ob.loginLinkClick();
		String Sheet = "Input";
		String Sheet2 = "Output";
		String Sheet3 = "BugReport-Login Page";
		String xlLocation = Commonutils.readProperty("LoginPageTestDataLocation");
		String xlNametoRead = (System.getProperty("user.dir") + xlLocation);
		int rowCount = Excelutils.getRowCount(xlNametoRead, Sheet);
		int BugIDCount = 0;
		for (int i = 1; i <= rowCount; i++) {
			String testCaseID = Excelutils.getCellValue(xlNametoRead, Sheet, i, 0);
			String testDesc = Excelutils.getCellValue(xlNametoRead, Sheet, i, 1);
			String Email = Excelutils.getCellValue(xlNametoRead, Sheet, i, 2);
			String Password = Excelutils.getCellValue(xlNametoRead, Sheet, i, 3);
			String expcStatus = Excelutils.getCellValue(xlNametoRead, Sheet, i, 4);
			ob.setValuesOnLoginPage(Email, Password);
			ob.loginButtonClick();

			String expectedUrl = Commonutils.readProperty("LoginPageSuccessURL");
			String actualUrl = dr.getCurrentUrl();

			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 0, testCaseID);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 1, testDesc);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 3, Email);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 4, Password);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 5, expcStatus);
			String actualStatus = null;
			boolean opinion = expectedUrl.equalsIgnoreCase(actualUrl);
			if (opinion) {
				actualStatus = "Pass";
				ob.registerIconHover();
				ob.logoutBtnClick();
				ob.registerIconHover();
				ob.loginLinkClick();
			} else {
				actualStatus = "Fail";
				ob.registerIconHover();
				ob.loginLinkClick();
			}
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 6, actualStatus);
			boolean option = expcStatus.equalsIgnoreCase(actualStatus);
			if (option) {
				Excelutils.putCellValue(xlNametoRead, Sheet2, i, 2, "Test Passed");
				Excelutils.putCellValue(xlNametoRead, Sheet3, i, 0, null);
				Excelutils.putCellValue(xlNametoRead, Sheet3, i, 1, null);
				Excelutils.putCellValue(xlNametoRead, Sheet3, i, 2, null);
				Excelutils.putCellValue(xlNametoRead, Sheet3, i, 3, null);
				Excelutils.putCellValue(xlNametoRead, Sheet3, i, 4, null);
			} else {
				BugIDCount = BugIDCount + 1;
				String BugIDCountString = null;
				if (BugIDCount < 10) {
					BugIDCountString = "BR_COP_00" + Integer.toString(BugIDCount);
				} else {
					BugIDCountString = "BR_COP_0" + Integer.toString(BugIDCount);
				}
				Excelutils.putCellValue(xlNametoRead, Sheet2, i, 2, "Test Failed");
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 0, testCaseID);
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 1, BugIDCountString);
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 2, testDesc);
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 3, "Minor");
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 4, "3");
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 5, "Open");
			}

		}
	}
}
