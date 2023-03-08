package hms.nml.admin;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.annotation.Report;
import com.hms.nml.genericLibrary.configAnnotation.BaseClass;
import com.hms.nml.genericLibrary.enums.ExcelSheet;
import com.hms.nml.genericLibrary.enums.TabNames;

public class AddDoctorTest extends BaseClass {
	
	@Report(author = "Amruth" )
	@Test(groups="regression")
	public void addDoctorTest() {
		
		String sheetName = ExcelSheet.ADMIN.getSheetName();
		String expTestScriptName = "AddDoctorTest";
		Map<String, String> map = excelUtils.getData(expTestScriptName, sheetName);
		Map<String, String> verify = excelUtils.getData("PageNames", "Verification");

		//Admin login
		hmsHomePage.adminLoginClickAction();
		String actual = webDriverUtils.getTitle();
		Assert.assertTrue(actual.equals(verify.get("AdminLoginPage")));
		loginPage.loginAction(adminUsername, adminPassword);
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminDashboardPage")));

		//admin adding doctor specialization
		adminCommonPage.clickTab(TabNames.DOCTORS);
		doctorCommonPage.clickTab(TabNames.DOCTORSPECIALIZATION);
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminDoctorSpecializationPage")));
		addDoctorSpecializationPage.addDoctorSpecializationAction(map.get("Doctorspecilization"));
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminDoctorSpecializationPage")));

		//admin adding doctor
		adminCommonPage.clickTab(TabNames.DOCTORS);
		adminCommonPage.clickTab(TabNames.ADDDOCTOR);
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminAddDoctorPage")));
		String doctorEmail= map.get("DoctorName")+javaUtils.getRandomNumber(100)+"@gmail.com";
		addDoctorPage.addDoctorAction(dropDownUtils,map.get("Doctorspecilization") , excelUtils.getData("doctorDetails", "Data"), doctorEmail);
		popUpUtils.alterAccept(driver);
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminManageDoctorsPage")));

		//Admin modifying doctor details
		manageDoctorPage.editDoctorAction(dropDownUtils, map.get("NewDoctorspecilization"));
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminEditDoctorDetailsPage")));

		//admin deleting doctor 
		adminCommonPage.clickTab(TabNames.DOCTORS);
		adminCommonPage.clickTab(TabNames.MANAGEDOCTORS);
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminManageDoctorsPage")));
		manageDoctorPage.clickDoctorToDelete(map.get("DoctorName"));
		popUpUtils.alterAccept(driver);
		String actText = manageDoctorPage.getWarningText();
		String exptext = verify.get("DoctorDeletedMessage");
		Assert.assertTrue(actText.equals(exptext), "Doctor Details not deleted and TC fail");
	}

}

