package practice;

import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.annotation.Report;
import com.hms.nml.genericLibrary.configAnnotation.BaseClass;
import com.hms.nml.genericLibrary.miscellaneous.UtilityInstanceTranformer;


public class ReportTestngClass1  extends BaseClass{
	@Report(author = "Amruth")
	@Test
	public void googleTest() {
		System.out.println(Thread.currentThread().getId());
		//driver.get("https://www.google.com");
		driver.get("http://192.168.0.146/domain/Hospital_Management_System/hms/user-login.php");
		
		report.info(UtilityInstanceTranformer.getExtentTest(), "Hospital_Management_System");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Test1 ----> class 1");
	}
	
}
