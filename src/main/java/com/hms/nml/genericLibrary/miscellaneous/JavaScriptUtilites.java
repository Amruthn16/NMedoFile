package com.hms.nml.genericLibrary.miscellaneous;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * This class JavascriptUtilites is used to provide different methods of JavascriptExecutor
 * @author Amruth N
 *
 */

public class JavaScriptUtilites {
	private	JavascriptExecutor js;
	/**
	 * This is the constructor for getting the instance of driver
	 * @param driver
	 */
	public JavaScriptUtilites(WebDriver driver){
		js =(JavascriptExecutor) driver;
	}
	
	
	/**
	 * This method is used to scroll until particular element
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	/**
	 * This method is used to scroll till Bottom Of Page 
	 */
	public void scrollDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	/**
	 * This method is used to scroll to top of web page
	 */
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	/**
	 * This method is used to click on the element
	 * @param element
	 */
	public void click(WebElement element) {
		js.executeScript("arguments[0].click()",element);
	}
	
	/**
	 * This method is used to send the data
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	
	/**
	 * This method is used to launch the application
	 * @param url
	 */
	public void launchApplication(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}
	
	/**
	 * This method is used to highlight the specified element
	 * @param element
	 */
	public void highlight(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style','border:6px solid red;');",element);
	}
	
	
}
