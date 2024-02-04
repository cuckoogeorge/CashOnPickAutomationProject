package basePackageCashOnPick;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.media.Media;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.Commonutils;
import utilities.Excelutils;

/**
 * This class describes Base class or the parent class of the project
 * 
 * @author Cuckoo George , Feb2,2024
 */
public class BaseClass {
	public static WebDriver dr;

	public static ExtentTest extentTest;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;

	@BeforeClass
	public void beforeClass() throws IOException {
		dr = new ChromeDriver();
		dr.manage().deleteAllCookies();
		// dr.manage().window().maximize();
		String baseURL = Commonutils.readProperty("testURL");
		dr.get(baseURL);

	}

	@BeforeTest
	public static void setExtent() {
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
		reporter.config().setDocumentTitle("CashOnPick TestResults");
		reporter.config().setReportName("CashOnPick Tests");
		reporter.config().setTheme(Theme.DARK);
		// reporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostName", "Local Host");
		extent.setSystemInfo("UserName", "cuckoogeorge");
		extent.setSystemInfo("Environment", "QA");
	}

	@AfterMethod
	public static void endExtent(ITestResult result) throws IOException, InterruptedException {
		String screenshotPath = null;

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.generateLog(Status.FAIL, "TestCase FAILED for :  " + result.getName());
			extentTest.log(Status.FAIL, "TestCase FAILED for :  " + result.getName()); // to add name in extent
			// report
			extentTest.log(Status.FAIL, " Error details are as follows. For more details check the screenshot below :"
					+ result.getThrowable());
			screenshotPath = Commonutils.getScreenshot(dr, result.getName(), "FAIL");
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			// extentTest.addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test Case SKIPPED for: " + result.getName());
			screenshotPath = Commonutils.getScreenshot(dr, result.getName(), "SKIP");
			extentTest.log(Status.SKIP, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.generateLog(Status.PASS, "TestCase PASSED for :  " + result.getName());
			System.out.println("result.getName())" + result.getName());
			extentTest.log(Status.PASS, "Test Case PASSED for " + result.getName());
			screenshotPath = Commonutils.getScreenshot(dr, result.getName(), "SUCCESS");
			extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		dr.quit();
	}

	@AfterTest
	public void tear() {
		extent.flush();
	}

}
