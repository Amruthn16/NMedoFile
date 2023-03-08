package practice.TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.miscellaneous.JavaUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.TakesScreenshotUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


//@Listeners(com.treysta_genericUtilities.retry.SetTestParameter.class)
public class TestNgPractice  {
	public WebDriver driver;
	public TakesScreenshotUtility takeScreenShotUtils;
	public WebDriverUtilities webDriverUtils;
	public JavaUtility javaUtils;


	@BeforeMethod
	public void setup() {
		System.out.println("BeforeClass");
		javaUtils = new JavaUtility();
		webDriverUtils = new WebDriverUtilities();
		driver= webDriverUtils.launchBrowser("chrome");
		takeScreenShotUtils = new TakesScreenshotUtility(driver);

	}
	
//	@Test
//	public void test1() {
//		System.out.print(Thread.currentThread().getId());
//		driver.get("http://192.168.0.146/domain/Hospital_Management_System/hms/dashboard.php");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void getProject() {
//		System.out.print(Thread.currentThread().getId());
//
//		driver.get("http://192.168.0.146/domain/Online_Tourism_Management_System/");
//		//Assert.fail();
//	}
	
	@AfterMethod
	public void tearDown() {
	driver.close();
	}


}
