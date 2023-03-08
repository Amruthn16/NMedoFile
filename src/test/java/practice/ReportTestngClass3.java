package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.annotation.Report;
import com.hms.nml.genericLibrary.configAnnotation.BaseClass;


public class ReportTestngClass3  extends BaseClass{

	@Report(author = "Vishwas")
	@Test
	public void facebookTest() {
		System.out.println(Thread.currentThread().getId());
		//driver.get("https://www.facebook.com");
		driver.get("http://192.168.0.146/domain/Hospital_Management_System/hms/admin/");
		Assert.fail();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("Test3 ----> class 3");
		
	}

}
