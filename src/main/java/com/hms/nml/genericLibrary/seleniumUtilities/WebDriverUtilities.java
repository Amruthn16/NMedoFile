package com.hms.nml.genericLibrary.seleniumUtilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
	 * This is the WebDriver utilities class used to provide different methods of webDriver
	 * @author Amruth N
	 *
	 */
public class WebDriverUtilities {
	private WebDriver driver;
	
	/**
	 * This is the method used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method used to launch the specific browser based on the argument
	 * @param browser
	 * @return
	 */
	//This is the ex for Runtime Polymorphism
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;	
		default:
			System.out.println("Enter proper key");
			break;
		}
		
		return driver;
	}
	
	/**
	 * This method used to launch the specific browser based on the argument and 
	 * with handling notification popup
	 * @param browser
	 * @return
	 */
	//This is the ex for Runtime Polymorphism
	public WebDriver launchBrowser(String browser, String... s) {
		switch(browser) {
		case "chrome":
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;	
		default:
			System.out.println("Enter proper key");
			break;
		}
		
		return driver;
	}
	
	
	/**
	 * This is the method used to close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
	
	/**
	 * This method used to close the tab
	 */
	public void closeTab() {
		driver.close();
	}
	
	/**
	 * This method is used to enter the url
	 * @param url
	 */
	public void  getUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * This method is used to get the current url of application
	 * @return
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * This method is used to get the title of page
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	
	/**
	 * This method is used to get the address of the current window
	 * @return
	 */
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}
	
	/**
	 * This method is used to get the address of the all windows
	 * @return
	 */
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}
	
	/**
	 * This method is used to get the source of the web page
	 * @return
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}
	
}
