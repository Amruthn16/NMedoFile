package com.hms.nml.genericLibrary.listener;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.miscellaneous.JavaUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.TakesScreenshotUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.WebDriverUtilities;


public class TestNgScreenshotPractice {
	public WebDriver driver;
	public TakesScreenshotUtility takeScreenShotUtils;
	public WebDriverUtilities webDriverUtils;
	public JavaUtility javaUtils;


	@BeforeTest
	public void setup() {
		System.out.println("BeforeClass");
		javaUtils = new JavaUtility();
		webDriverUtils = new WebDriverUtilities();
		driver=webDriverUtils.launchBrowser("chrome");
		takeScreenShotUtils = new TakesScreenshotUtility(driver);
	}
	
	@Test
	public void test1() {
		System.out.print(Thread.currentThread().getId());
		driver.get("http://www.google.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getProject() {
		System.out.print(Thread.currentThread().getId());

		driver.get("http://www.facebook.com/");
		Assert.fail();
	}
	
	@AfterTest
	public void tearDown() {
		webDriverUtils.closeBrowser();
	}


}
