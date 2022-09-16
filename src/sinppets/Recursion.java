package sinppets;

import java.io.IOException;
import org.openqa.selenium.By;
import utilities.UtilBase;

//Example of Recursive function --> function that calls itself
//note: Code after the recursive call gets executed at last (in this case from line 28)


public class Recursion extends UtilBase{
	
	String statusText;
	int counter;
	String currentCase;
//	Recurring Function
	public void recurringDream() throws InterruptedException, IOException {


//		get text from status column
		statusText = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[7]")).getText();
		if (statusText.contains("RECEIVED") || statusText.contains("IN-PROGRESS") || statusText.contains("READY")) {
			if (counter < 5) {
				System.out.println("count: " + counter);
				counter = counter + 1;
				System.out.println(statusText);
				recurringDream();

			} else {
				statusText = "TIME OUT";
			}
		} else if (statusText.contains("COMPLETED")) {
			statusText = "COMPLETED";
		} else {
			statusText = "FAILED";
//			ExcelRead.writeExcel(currentCase, statusText, trStatus, email_complexity_value, type);
			System.out.println(currentCase + " " + statusText);
		}
	}
	
	
}
