package utilities;

/**
 * This class describes Common functionalities in the Project
 * @author Cuckoo George , Feb2,2024
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basePackageCashOnPick.BaseClass;

public class Commonutils extends BaseClass {

	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[3]/div[1]/div[4]/i")
	public static WebElement registerOrsignUpIcon;

	public Commonutils(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}

	public static WebElement getRegisterOrsignUpIcon() {
		return registerOrsignUpIcon;
	}

	public static void registerIconHover() {
		Actions act = new Actions(dr);
		WebElement element = getRegisterOrsignUpIcon();
		if (element != null) {
			act.click(element).perform();
		} else {
			System.out.println("Element is null");
		}
	}

	public static void sendKeysonElement(WebDriver dr, WebElement e, Duration timeout, String value) {
		new WebDriverWait(dr, timeout).until(ExpectedConditions.visibilityOf(e)).sendKeys(value);
	}

	public static void clickOnWebElement(WebDriver dr, WebElement e, Duration timeout) {
		new WebDriverWait(dr, timeout).until(ExpectedConditions.elementToBeClickable(e)).click();
		;
	}

	public static String readProperty(String property) throws IOException {
		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
		System.out.println("UserDir" + System.getProperty("user.dir"));
		Properties p = new Properties();
		p.load(fr);
		String propertytoReturn = p.getProperty(property);
		return propertytoReturn;
	}

	public static String getScreenshot(WebDriver driver, String screenshotName, String status) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = null;

		if (status.equalsIgnoreCase("Fail")) {
			destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
		} else {
			destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName + ".png";
		}

		File finalDestination = new File(destination);
		// FileUtils.copyFile(source, finalDestination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}

	public static void dummyEmailCreation(String xlName, String sheetName, String firstName, int rowNum, int CellNum) {
		Random rnd = new Random();
		int randomInt = rnd.nextInt(1000);
		String randomEmail = firstName + randomInt + "@123.co";
		Excelutils.putCellValue(xlName, sheetName, rowNum, CellNum, randomEmail);
	}

}
