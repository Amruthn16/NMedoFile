package practice.TestNg;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.enums.ExcelSheet;
import com.hms.nml.genericLibrary.enums.TabNames;

public class DataProviderEx extends TestNGBaseClass {

	@Test (dataProvider = "abc")
	public void test(String [] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);	
		}
		
	}
	@DataProvider(name="abc")
	public String[] dataProvider() {
		String [] arr= new String[4];
		arr[0]="Java";
		arr[1]="Manual";
		arr[2]="Selenium";
		arr[3]="API";
		
		return arr;
	}
	
	@Test(dataProvider = "userData")
	public void test(String Doctorspecilization,String DoctorName,String ClinicAddress,String DoctorFees,String DoctorContact,String DoctorEmail,String	DoctorPassword) {
		String sheetName = ExcelSheet.ADMIN.getSheetName();
		String expTestScriptName = "AdhocDeleteDoctorTest";
		Map<String, String> map = excelUtils.getData(expTestScriptName, sheetName);

		//hm.adminLoginClickAction();
		verificationUtils.partialyVerify("page", "Admin-Login", webDriverUtils.getTitle(), "Admin-Login", takesScreenshotUtils, javaUtils);
		loginPage.loginAction(adminUsername, adminPassword);
		verificationUtils.partialyVerify("page", "Admin loggedin and Admin | Dashboard", webDriverUtils.getTitle(), "Admin | Dashboard", takesScreenshotUtils, javaUtils);
	
		doctorCommonPage.clickTab(TabNames.DOCTORS);
		doctorCommonPage.clickTab(TabNames.ADDDOCTOR);
		String doctorEmail= map.get("DoctorName")+javaUtils.getRandomNumber(1000)+"@gmail.com";
		addDoctorPage.addDoctorAction(dropDownUtils,map.get("Doctorspecilization") , excelUtils.getData("doctorDetails", "Data"), doctorEmail);
		popUpUtils.alterAccept(driver);
		verificationUtils.partialyVerify("page", "Doctor added and Admin | Manage Doctors", webDriverUtils.getTitle(), "Admin | Manage Doctors", takesScreenshotUtils, javaUtils);

	
	}

	@DataProvider(name="userData")
	public String[][] dataProviderEx() {
		return excelUtils.getData("Sheet2");
	}

}
