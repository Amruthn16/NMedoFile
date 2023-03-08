package practice.TestNg;

import org.testng.annotations.Test;


public class PracticeTestngClass2 extends BaseClassPratice {

	@Test(groups = "sanity")
	public void gmailTest() {
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.gmail.com");
//		driver.get("http://192.168.0.146/domain/Hospital_Management_System/hms/doctor/index.php");
		System.out.println("===== Test2 ===== class 2 =======");
	}

}
