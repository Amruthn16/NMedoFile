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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.hms.nml.genericLibrary.miscellaneous.JavaUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.TakesScreenshotUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.WebDriverUtilities;

public class BaseClassPratice {
	public WebDriver driver;
	public TakesScreenshotUtility takeScreenShotUtils;
	public WebDriverUtilities webDriverUtils;
	public JavaUtility javaUtils;
	protected String browser;

	
	@AfterMethod(alwaysRun=true)
	public void methodTearDown()
	{
		System.out.println("======AfterMethod=======");
	}
	
	@AfterClass(alwaysRun=true)
	public void classTearDown()
	{
		System.out.println("=======AfterClass======");
		System.out.println("=======Closing Browser=======");
		webDriverUtils.closeBrowser();
	}
	
	@AfterTest(alwaysRun=true)
	public void testTearDown()
	{
		System.out.println("=======AfterTest=======");
	}
	@AfterSuite
	public void suiteTearDown()
	{
		System.out.println("=======AfterSuite=======");
	}
	@BeforeSuite(alwaysRun=true)
	public void suiteSetup()
	{
		System.out.println("=======Before Suite=======");
	}
	@BeforeTest(alwaysRun=true)
	public void testSetup()
	{
		System.out.println("=======BeforeTest=======");
		
	}

	@Parameters(value="browser")
	@BeforeClass(alwaysRun=true)
	public void classSetup(@Optional String browser)
	{
		System.out.println("=======BeforeClass=======");
		System.out.println("=======Launching Browser=======");
		javaUtils = new JavaUtility();
		webDriverUtils = new WebDriverUtilities();
		if(browser==null || browser.isEmpty() || browser.equals("")) {
			browser = "chrome";
		}
		this.browser=browser;
		
		driver=webDriverUtils.launchBrowser(this.browser);
		takeScreenShotUtils = new TakesScreenshotUtility(driver);

	}
	
	@BeforeMethod(alwaysRun=true)
	public void methodSetup()
	{
		System.out.println("=======BeforeMethod=======");
	}


}


