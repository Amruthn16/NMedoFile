package practice.TestNg;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class PracticeTestngClass3  extends BaseClassPratice{

	@Test(groups = {"regression","sanity"})
	public void facebookTest() {
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.facebook.com");
		//driver.get("http://192.168.0.146/domain/Hospital_Management_System/hms/admin/");
		System.out.println("======= Test3 ====== class 3 =====");
		
	}

}
