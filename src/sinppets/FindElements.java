package sinppets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.UtilBase;

public class FindElements extends UtilBase{
	
//	findElements returns list
	
	public void findElementsDemo() {
		List<WebElement> caseQueue_data = driver.findElements(By.xpath("//div[@class='ant-table-content']/table/tbody/tr"));
		int count = caseQueue_data.size();
		
		System.out.println(count);
	}

	
}
