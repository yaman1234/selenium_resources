package sinppets;

import java.util.ArrayList;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.UtilBase;

public class Handle_Tabs extends UtilBase {

	@BeforeSuite(alwaysRun = true)
	public void beforeMethod() {
		initialiseDriver();
	}

	@Test(priority = 1)
	public void happyFlowTest() throws InterruptedException {

		String link_sq = "http://10.0.2.248/";

		String link_2 = "https://www.google.com/";

		driver.get(link_sq);

		// opening the new tab
		jsDriver.executeScript("window.open()");

//		  body = driver.find_element_by_tag_name("body"); 
//	      body.send_keys(Keys.CONTROL + 't');

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(tabs.size());
		System.out.println(tabs.get(0));
		System.out.println(tabs.get(1));

//		switch control to new tab
		driver.switchTo().window(tabs.get(1));
		driver.get(link_2);
	}

	@AfterSuite(alwaysRun = true)
	public void afterMethod() {
	}

}
