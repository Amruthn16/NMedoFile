package practice.TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.seleniumUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


//@Listeners(com.treysta_genericUtilities.retry.SetTestParameter.class)
public class TestNgPractice1  {
 public WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
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
