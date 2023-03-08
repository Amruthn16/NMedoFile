package practice.TestNg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.miscellaneous.JavaUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.TakesScreenshotUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.WebDriverUtilities;

public class BaseClassPratice1 {
public WebDriver driver;
public TakesScreenshotUtility takeScreenShotUtils;
public WebDriverUtilities webDriverUtils;
public JavaUtility javaUtils;
	
	@AfterMethod
	public void methodTearDown()
	{
		System.out.println("AfterMethod");
	}
	@AfterClass
	public void classTearDown()
	{
		System.out.println("AfterClass");
	}
	@AfterTest
	public void testTearDown()
	{
		System.out.println("AfterTest");
	}
	@AfterSuite
	public void suiteTearDown()
	{
		System.out.println("AfterSuite");
	}
	@BeforeSuite
	public void suiteSetup()
	{
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void testSetup()
	{
		System.out.println("BeforeTest");
		
	}
	@Test
	public void test1()
	{
		System.out.println("Test");
	}

	@BeforeClass
	public void classSetup()
	{
		System.out.println("BeforeClass");
		
		javaUtils = new JavaUtility();
		webDriverUtils = new WebDriverUtilities();
		driver= webDriverUtils.launchBrowser("chrome");
		takeScreenShotUtils = new TakesScreenshotUtility(driver);

	}
	
	@BeforeMethod
	public void methodSetup()
	{
		System.out.println("BeforeMethod");
	}


}


