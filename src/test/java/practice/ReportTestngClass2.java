package practice;

import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.annotation.Report;
import com.hms.nml.genericLibrary.configAnnotation.BaseClass;


public class ReportTestngClass2 extends BaseClass {

	@Report(author = "Amruth", category = "sanity")
	@Test
	public void gmailTest() {
		System.out.println(Thread.currentThread().getId());
		//driver.get("https://www.gmail.com");
		driver.get("http://192.168.0.146/domain/Hospital_Management_System/hms/doctor/index.php");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Test2 ----> class 2");
	}

}
