package testPackageCashOnPick;

import org.testng.annotations.Test;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackageCashOnPick.BaseClass;
import pagePackageCashOnPick.pageRegister;
import utilities.Commonutils;
import utilities.Excelutils;
/**
 * This class describes Test method of the Register Module
 * @author Cuckoo George , Feb2,2024
 */
public class testRegister extends BaseClass {

	@Test
	public void registerTest() throws InterruptedException, IOException {
		pageRegister ob = new pageRegister(dr);
		extentTest = extent.createTest("registerTest");
		String Sheet = "Input";
		String Sheet2 = "Output";
		String Sheet3 = "BugReport-Register Page";
		String actualStatus = null;
		int BugIDCount = 0;
		String xlLocation = Commonutils.readProperty("RegisterPageTestDataLocation");
		String xlNametoRead = (System.getProperty("user.dir") + xlLocation);
		System.out.println("xlNametoRead " + xlNametoRead);
		int rowCount = Excelutils.getRowCount(xlNametoRead, "Input");
		ob.registerIconHover();
		ob.registerButtonClick();
		for (int i = 1; i <= rowCount; i++) {
			String TestCaseID = Excelutils.getCellValue(xlNametoRead, Sheet, i, 0);
			String TestDesc = Excelutils.getCellValue(xlNametoRead, Sheet, i, 1);
			String firstName = Excelutils.getCellValue(xlNametoRead, Sheet, i, 2);
			Commonutils.dummyEmailCreation(xlNametoRead, Sheet, firstName, i, 4);
			String lastName = Excelutils.getCellValue(xlNametoRead, Sheet, i, 3);
			String email = Excelutils.getCellValue(xlNametoRead, Sheet, i, 4);
			String City = Excelutils.getCellValue(xlNametoRead, Sheet, i, 5);
			String Phone = Excelutils.getCellValue(xlNametoRead, Sheet, i, 6);
			String Password = Excelutils.getCellValue(xlNametoRead, Sheet, i, 7);
			String ConfirmPassword = Excelutils.getCellValue(xlNametoRead, Sheet, i, 8);
			String ExpectedStatus = Excelutils.getCellValue(xlNametoRead, Sheet, i, 9);

			ob.setValuesforSignInPage(firstName, lastName, email, City, Phone, Password, ConfirmPassword);

			ob.registerationButtonClick();

			String expectedUrl = Commonutils.readProperty("RegisterPageSuccessURL");
			String actualUrl = dr.getCurrentUrl();
			System.out.println("actualUrl " + actualUrl);
			System.out.println("exp stat :" + ExpectedStatus);
			String BugID = Integer.toString(i);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 0, TestCaseID);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 1, TestDesc);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 3, firstName);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 4, lastName);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 5, email);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 6, City);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 7, Phone);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 8, Password);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 9, ConfirmPassword);
			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 10, ExpectedStatus);

			boolean opinion = expectedUrl.equalsIgnoreCase(actualUrl);
			if (opinion) {
				actualStatus = "Pass";
				ob.registerIconHover();
				ob.logoutBtnClick();
				ob.registerIconHover();
				ob.registerButtonClick();

			} else {
				actualStatus = "Fail";
				ob.registerIconHover();
				ob.registerButtonClick();
			}

			Excelutils.putCellValue(xlNametoRead, Sheet2, i, 11, actualStatus);
			boolean option = ExpectedStatus.equalsIgnoreCase(actualStatus);
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
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 0, TestCaseID);
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 1, BugIDCountString);
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 2, TestDesc);
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 3, "Minor");
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 4, "3");
				Excelutils.putCellValue(xlNametoRead, Sheet3, BugIDCount, 5, "Open");
			}
		}
	}
}
