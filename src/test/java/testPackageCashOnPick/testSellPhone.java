package testPackageCashOnPick;

import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackageCashOnPick.BaseClass;
import pagePackageCashOnPick.pageSellPhone;
import utilities.Commonutils;
/**
 * This class describes Test method of the Selling Old Phone Module
 * @author Cuckoo George , Feb2,2024
 */
public class testSellPhone extends BaseClass {


	@Test
	public void sellPhoneTest() throws IOException, InterruptedException, InvocationTargetException {
		pageSellPhone ob = new pageSellPhone(dr);
		extentTest = extent.createTest("Apple iPhone 13 128GB SellTest");

		ob.registerIconHover();
		ob.loginLinkClick();
		ob.setValues();
		ob.loginButtonClick();
		ob.sellHover();
		ob.selectanItem();
		ob.yesButtonClick();
		ob.issueCheck();
		ob.continueButtonClick();
		ob.accessoriesCheck();
		ob.accessoriesContinueButtonClick();
		ob.ageListButtonClick();
		ob.deviceConditionListClick();
		ob.setValuesPhoneNumber("1234567890");
		ob.continueButtonDevicePriceUnlockClick();
		Thread.sleep(2000);
		ob.datePickerNextButtonClick("27","FEBRUARY", "2024");
		ob.termsOfServiceChecked();
		ob.checkOutBtnClicked();
		ob.registerIconHover();
		ob.logoutBtnClick();
	}
}
