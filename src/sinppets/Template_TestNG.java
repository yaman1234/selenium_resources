package sinppets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.PageObject;
import utilities.UtilBase;

public class Template_TestNG extends UtilBase {

	ExtentTest test;
	ExtentReports report;
	String baseUrl, username, password;
	public PageObject pageObj = new PageObject();
	WebDriverWait wait;

	@BeforeSuite(alwaysRun = true)
	public void beforeMethod() {
		initialiseDriver();
		driver.manage().window().maximize();
//			implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			Explicit wait
		wait = new WebDriverWait(driver, 30);
		report = new ExtentReports(System.getProperty("user.dir") + "//testReports//ExtentReport.html");
	}

	@Test(priority = 1)
	public void happyFlowTest() throws InterruptedException {
		test = report.startTest("Test #1");
		test.log(LogStatus.PASS, "Logged in sucessful");
		report.endTest(test);

	}

	@Test(priority = 2)
	public void method() throws InterruptedException {

	}

	@AfterSuite(alwaysRun = true)
	public void afterMethod() {
		report.endTest(test);
		// report will not be generated if flush() is not defined
		report.flush();
//		driver.close();
	}
}
