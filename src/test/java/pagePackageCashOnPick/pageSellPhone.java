package pagePackageCashOnPick;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonutils;

/**
 * This class describes WebElements and their Corresponding methods in Selling
 * an Old phone module of the Project
 * 
 * @author Cuckoo George , Feb2,2024
 */
public class pageSellPhone {
	WebDriver dr;
	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/div/a[2]")
	WebElement loginLink;
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement EmailID;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement PassWord;
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;
	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/i")
	WebElement registerOrsignUpIcon;
	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[2]/ul[1]/li[1]/a")
	WebElement sellHover;
	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[2]/ul[1]/li[1]/ul/li[1]/a")
	WebElement sellPhoneHover;
	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[2]/ul[1]/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement sellPhoneAppleHover;
	@FindBy(xpath = "/html/body/div[7]/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div[1]/a")
	WebElement ApplePhoneItem;
	@FindBy(xpath = "//body/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[6]/dl[1]/dt[1]/dl[1]/dd[1]/ul[1]/li[1]")
	WebElement yesButton;
	@FindBy(xpath = "//*[@id=\"product_attribute_input_44000\"]/ul/li[1]")
	WebElement issue1;
	@FindBy(xpath = "//*[@id=\"product_attribute_input_44000\"]/ul/li[2]")
	WebElement issue2;
	@FindBy(xpath = "//*[@id=\"product_attribute_input_44000\"]/ul/li[10]")
	WebElement issue10;
	@FindBy(xpath = "//*[@id=\"nextbutton\"]")
	WebElement continueButton;
	@FindBy(xpath = "//body/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[6]/dl[1]/dt[1]/dl[5]/dd[1]/ul[1]/li[1]")
	WebElement accessories1;
	@FindBy(xpath = "//body/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[6]/dl[1]/dt[1]/dl[6]/dd[1]/ul[1]/li[1]")
	WebElement accessories2;
	@FindBy(xpath = "//body/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[6]/dl[1]/dt[1]/dl[7]/dd[1]/ul[1]/li[1]")
	WebElement accessories3;
	@FindBy(xpath = "//*[@id=\"nextbutton\"]")
	WebElement accessoriesContinueButton;
	@FindBy(xpath = "//body/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[6]/dl[1]/dt[1]/dl[8]/dd[1]/ul[1]/li[1]")
	WebElement ageList;
	@FindBy(xpath = "//body/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[6]/dl[1]/dt[1]/dl[10]/dd[1]/ul[1]/li[1]")
	WebElement deviceConditionList;
	@FindBy(xpath = "//input[@id='product_attribute_44009']")
	WebElement phoneNumber;
	@FindBy(xpath = "//input[@id='nextbutton']")
	WebElement continuePhNumber;
	@FindBy(xpath = "//body/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/dl[1]/dd[1]/div[1]/div[1]/div[1]/a[2]")
	WebElement datePickerNextButton;
	@FindBy(xpath = "/html[1]/body[1]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/dl[1]/dd[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement monthDisplayed;
	@FindBy(xpath = "//body/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/dl[1]/dd[1]/div[1]/div[1]/div[1]/div[1]/span[2]")
	WebElement yearDisplayed;
	@FindBy(xpath = "/html/body/div[7]/div[2]/div/div/div/div/form/div/div/div[2]/div[1]/dl/dd/div[1]/div/table/tbody/tr/td/a")
	List<WebElement> dates;
	@FindBy(xpath = "//tbody/tr[3]/td[5]/a[1]")
	WebElement date;
	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement termsOfServiceCheckBox;
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutButton;
	@FindBy(xpath = "//body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/a[2]")
	WebElement logOutLink;

	public pageSellPhone(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}

	public void registerIconHover() {
		Actions act = new Actions(dr);
		act.click(registerOrsignUpIcon).perform();

	}

	public void sellHover() {
		Actions act = new Actions(dr);
		act.moveToElement(sellHover).perform();
		act.moveToElement(sellPhoneHover).perform();
		act.click(sellPhoneAppleHover).perform();
	}

	public void loginLinkClick() {
		Commonutils.clickOnWebElement(dr, loginLink, Duration.ofSeconds(20));
	}

	public void setValues() throws IOException {
		String emailID = Commonutils.readProperty("loginEmailID");
		String pass = Commonutils.readProperty("loginPWD");
		Commonutils.sendKeysonElement(dr, EmailID, Duration.ofSeconds(20), emailID);
		Commonutils.sendKeysonElement(dr, PassWord, Duration.ofSeconds(20), pass);
	}

	public void loginButtonClick() {
		Commonutils.clickOnWebElement(dr, loginButton, Duration.ofSeconds(20));
	}

	public void selectanItem() {

		Commonutils.clickOnWebElement(dr, ApplePhoneItem, Duration.ofSeconds(20));
	}

	public void yesButtonClick() {
		Commonutils.clickOnWebElement(dr, yesButton, Duration.ofSeconds(20));
	}

	public void issueCheck() {
		Commonutils.clickOnWebElement(dr, issue1, Duration.ofSeconds(20));
		Commonutils.clickOnWebElement(dr, issue2, Duration.ofSeconds(20));
	}

	public void continueButtonClick() {
		Commonutils.clickOnWebElement(dr, continueButton, Duration.ofSeconds(20));
	}

	public void accessoriesCheck() {
		Commonutils.clickOnWebElement(dr, accessories1, Duration.ofSeconds(20));
		Commonutils.clickOnWebElement(dr, accessories2, Duration.ofSeconds(20));
		Commonutils.clickOnWebElement(dr, accessories3, Duration.ofSeconds(20));
	}

	public void accessoriesContinueButtonClick() {
		Commonutils.clickOnWebElement(dr, accessoriesContinueButton, Duration.ofSeconds(20));
	}

	public void ageListButtonClick() {
		Commonutils.clickOnWebElement(dr, ageList, Duration.ofSeconds(20));
	}

	public void deviceConditionListClick() {
		Commonutils.clickOnWebElement(dr, deviceConditionList, Duration.ofSeconds(20));
	}

	public void setValuesPhoneNumber(String phNumber) {
		Commonutils.sendKeysonElement(dr, phoneNumber, Duration.ofSeconds(20), phNumber);
	}

	public void continueButtonDevicePriceUnlockClick() {
		Commonutils.clickOnWebElement(dr, continuePhNumber, Duration.ofSeconds(20));
	}

	public void datePickerNextButtonClick(String expDate, String expMonth, String expYear)
			throws InterruptedException, InvocationTargetException {

		List<WebElement> listOFDates;
		try {
			while (true) {
				String actualMonth = monthDisplayed.getText();
				String actualYear = yearDisplayed.getText();
				if (actualMonth.equals(expMonth) && (actualYear.equalsIgnoreCase(expYear))) {
					break;
				} else {
					Commonutils.clickOnWebElement(dr, datePickerNextButton, Duration.ofSeconds(20));
				}
			}
			listOFDates = dates;
			for (WebElement e : listOFDates) {
				String date = e.getText();
				if (date.equals(expDate)) {
					Commonutils.clickOnWebElement(dr, e, Duration.ofSeconds(20));
					break;
				}
			}
		} catch (StaleElementReferenceException exp) {
			listOFDates = dates;
			for (WebElement e : listOFDates) {
				String date = e.getText();
				if (date.equals(expDate)) {
					Commonutils.clickOnWebElement(dr, e, Duration.ofSeconds(20));
					break;
				}
			}
		}
	}

	public void termsOfServiceChecked() {
		Commonutils.clickOnWebElement(dr, termsOfServiceCheckBox, Duration.ofSeconds(20));
	}

	public void checkOutBtnClicked() {
		Commonutils.clickOnWebElement(dr, checkoutButton, Duration.ofSeconds(20));
	}

	public void logoutBtnClick() {
		Commonutils.clickOnWebElement(dr, logOutLink, Duration.ofSeconds(20));
	}
}
