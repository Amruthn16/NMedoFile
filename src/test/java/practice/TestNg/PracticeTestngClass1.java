package practice.TestNg;

import org.testng.annotations.Test;



public class PracticeTestngClass1  extends BaseClassPratice{
	
	@Test(groups = "regression")
	public void googleTest() {
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.google.com");
//		driver.get("http://192.168.0.146/domain/Hospital_Management_System/hms/user-login.php");
		
		System.out.println("====== Test1 ===== class 1=======");
	}
	
}
