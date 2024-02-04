package pagePackageCashOnPick;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackageCashOnPick.BaseClass;
import utilities.Commonutils;

/**
 * This class describes WebElements and their Corresponding methods in Login
 * Page of the Project
 * 
 * @author Cuckoo George , Feb2,2024
 */
public class pageLogin {
	WebDriver dr;

	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/div/a[2]")
	WebElement loginLink;
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement emailTextBox;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement passwordTextBox;
	@FindBy(xpath = "/html/body/div[7]/div[2]/div/div/div/div[2]/div[2]/div[2]/div/form/div[3]/input")
	// body/div[7]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[4]/input[1]
	WebElement loginButton;
	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/i")
	WebElement registerOrsignUpIcon;
	@FindBy(xpath = "//body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/a[2]")
	WebElement logOutLink;

	public pageLogin(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}

	public void registerIconHover() {
		Actions act = new Actions(dr);
		act.click(registerOrsignUpIcon).perform();
	}

	public void loginLinkClick() {
		Commonutils.clickOnWebElement(dr, loginLink, Duration.ofSeconds(20));
	}

	public void setValuesOnLoginPage(String emaiID, String password) {
		emailTextBox.clear();
		Commonutils.sendKeysonElement(dr, emailTextBox, Duration.ofSeconds(20), emaiID);
		passwordTextBox.clear();
		Commonutils.sendKeysonElement(dr, passwordTextBox, Duration.ofSeconds(20), password);
	}

	public void loginButtonClick() {
		Commonutils.clickOnWebElement(dr, loginButton, Duration.ofSeconds(20));
	}

	public void logoutBtnClick() {
		Commonutils.clickOnWebElement(dr, logOutLink, Duration.ofSeconds(20));
	}

}
