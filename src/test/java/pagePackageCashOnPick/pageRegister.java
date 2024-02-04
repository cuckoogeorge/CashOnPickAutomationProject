package pagePackageCashOnPick;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Commonutils;

/**
 * This class describes WebElements and their Corresponding methods in Register
 * Page of the Project
 * 
 * @author Cuckoo George , Feb2,2024
 */
public class pageRegister {
	WebDriver dr;
	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/i")
	WebElement registerOrsignUpIcon;
	@FindBy(xpath = "//*[@class='ico-register']")
	WebElement registerButtonfromDropDown;
	@FindBy(xpath = "//*[@id=\"FirstName\"]")
	WebElement firstName;
	@FindBy(xpath = "//*[@id=\"LastName\"]")
	WebElement lastName;
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement eMail;
	@FindBy(xpath = "//*[@id=\"City\"]")
	WebElement City;
	@FindBy(xpath = "//*[@id=\"Phone\"]")
	WebElement Phone;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement Password;
	@FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
	WebElement confirmPassword;
	@FindBy(xpath = "//*[@id=\"register-button\"]")
	WebElement registerationButton;
	@FindBy(xpath = "//body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/a[2]")
	WebElement logOutLink;

	public pageRegister(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}

	public void registerIconHover() {
		Actions act = new Actions(dr);
		act.click(registerOrsignUpIcon).perform();
	}

	public void registerButtonClick() {
		Commonutils.clickOnWebElement(dr, registerButtonfromDropDown, Duration.ofSeconds(20));

	}

	public void setValuesforSignInPage(String FName, String lName, String email, String city, String phone,
			String password, String confirmpassword) {
		firstName.clear();
		Commonutils.sendKeysonElement(dr, firstName, Duration.ofSeconds(20), FName);
		lastName.clear();
		Commonutils.sendKeysonElement(dr, lastName, Duration.ofSeconds(20), lName);
		eMail.clear();
		Commonutils.sendKeysonElement(dr, eMail, Duration.ofSeconds(20), email);
		City.clear();
		Commonutils.sendKeysonElement(dr, City, Duration.ofSeconds(20), city);
		Phone.clear();
		Commonutils.sendKeysonElement(dr, Phone, Duration.ofSeconds(20), phone);
		Password.clear();
		Commonutils.sendKeysonElement(dr, Password, Duration.ofSeconds(20), password);
		confirmPassword.clear();
		Commonutils.sendKeysonElement(dr, confirmPassword, Duration.ofSeconds(20), confirmpassword);
	}

	public void registerationButtonClick() {
		Commonutils.clickOnWebElement(dr, registerationButton, Duration.ofSeconds(20));

	}
	public void logoutBtnClick() {
		Commonutils.clickOnWebElement(dr, logOutLink, Duration.ofSeconds(20));
	}

}
