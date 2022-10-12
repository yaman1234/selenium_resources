package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.PageObject;
import utilities.ExcelRead;
import utilities.UtilBase;
import utilities.WebElementLib;

//This file is the template 
public class SampleTest extends UtilBase {
	
	public ExtentTest test;
	public ExtentReports report;

	public String baseUrl = null, email = null, password = null;
	public String receiver = null, receiver2=null, subject = null, message = null;
	PageObject pageObj;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		initialiseDriver();
		driver.manage().window().maximize();

		report = new ExtentReports(System.getProperty("user.dir") + "//testReports//ExtentReport.html");
	}

	@Test(priority = 1)
	public void excelReadTest() throws InterruptedException {

		test = report.startTest("Excel Read Test");

		try {
			baseUrl = ExcelRead.getData(0, 1, "Sheet1");
			email = ExcelRead.getData(1, 1, "Sheet1");
			password = ExcelRead.getData(2, 1, "Sheet1");

			receiver = ExcelRead.getData(0, 1, "Sheet2");
			receiver2 = ExcelRead.getData(3, 1, "Sheet2");
			subject = ExcelRead.getData(1, 1, "Sheet2");
			message = ExcelRead.getData(2, 1, "Sheet2");

			System.out.println(receiver2);
			test.log(LogStatus.PASS, "Excel File Read Sucessful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to read data from Excel File");
		}

		report.endTest(test);
	}

	@Test(priority = 2)
	public void sendEmail() throws InterruptedException {

		test = report.startTest("Go to Write Email");

//		end the report
		report.endTest(test);
	}

	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		report.flush();
		driver.close();

	}
}
