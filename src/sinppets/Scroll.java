package sinppets;

import org.openqa.selenium.WebElement;

import utilities.UtilBase;

public class Scroll extends UtilBase {

	public void scroll_to_top() {
//		scroll to the top of the page
		jsDriver.executeScript("window.scrollTo(0, 0)");
	}

	public void scroll_to_bottom() {
// This will scroll the web page till end.
		jsDriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scroll_to_element() {
//		WebElement paginationElement = pageObj.pagination();
//		jsDriver.executeScript("arguments[0].scrollIntoView();", paginationElement);
	}

}
