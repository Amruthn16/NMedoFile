package hms.nml.admin;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.annotation.Report;
import com.hms.nml.genericLibrary.configAnnotation.BaseClass;
import com.hms.nml.genericLibrary.enums.ExcelSheet;
import com.hms.nml.genericLibrary.enums.TabNames;

public class AdhocDeleteDoctorTest extends BaseClass{

	@Report(author = "Amruth")
	@Test(groups="regression")
	public void adhocDeleteDoctorTest() {
		String sheetName = ExcelSheet.ADMIN.getSheetName();
		String expTestScriptName = "AdhocDeleteDoctorTest";
		Map<String, String> map = excelUtils.getData(expTestScriptName, sheetName);
		Map<String, String> verify = excelUtils.getData("PageNames", "Verification");


		//Admin Login
		hmsHomePage.adminLoginClickAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("AdminLoginPage"));
		loginPage.loginAction(adminUsername, adminPassword);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("AdminDashboardPage"), "Admin not logged in");

		//Admin adding doctor
		doctorCommonPage.clickTab(TabNames.DOCTORS);
		doctorCommonPage.clickTab(TabNames.ADDDOCTOR);
		String doctorEmail= map.get("DoctorName")+javaUtils.getRandomNumber(1000)+"@gmail.com";
		addDoctorPage.addDoctorAction(dropDownUtils,map.get("Doctorspecilization") , excelUtils.getData("doctorDetails", "Data"), doctorEmail);
		popUpUtils.alterAccept(driver);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("AdminManageDoctorsPage"),"Doctor not added and Admin | Manage Doctors page not matching");

		//Admin logout
		adminCommonPage.clickLogoutAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("HomePage"),"Admin not logged out and Home page not matching");

		//User Login
		hmsHomePage.patientLoginClickAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserLoginPage"), "User Login page not matching");
		loginPage.loginAction(userUsername, userPassword);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserDashboardPage"),"User not logged in and page not matching");

		// user booking appointment
		userCommonPage.clickTab(TabNames.BOOKAPPOINTMENT);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserBookAppointmentPage"), "User Book Appointment page not matching");
		bookAppointmentPage.bookAppointmentAction(javaUtils,dropDownUtils, map.get("Doctorspecilization"), map.get("DoctorName"), map.get("Hour"), map.get("Minute"), map.get("Meridian"));
		popUpUtils.alterAccept(driver);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserBookAppointmentPage"),"User not booked appointment and User Book Appointment page not matching");

		//user logout
		userCommonPage.clickLogoutAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("HomePage"), "User not logged out and Homepage not matching");

		//Admin Login
		hmsHomePage.adminLoginClickAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("AdminLoginPage"), "Admin Login Page not matching");
		loginPage.loginAction(adminUsername, adminPassword);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("AdminDashboardPage"), "Admin not logged in and Admin Dashboard page not matching");

		//Admin deleting doctor
		adminCommonPage.clickTab(TabNames.DOCTORS);
		adminCommonPage.clickTab(TabNames.MANAGEDOCTORS);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("AdminManageDoctorsPage"), "Admin Manage Doctors page not matching");
		manageDoctorPage.clickDoctorToDelete(map.get("DoctorName"));
		popUpUtils.alterAccept(driver);
		String actualDocDeletedMessage = manageDoctorPage.getWarningText();
		Assert.assertEquals(actualDocDeletedMessage, verify.get("DoctorDeletedMessage"),"Doctor Details not deleted and Admin Manage Doctors page not matching");

		//admin logout
		adminCommonPage.clickLogoutAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("HomePage"),"Admin not logged out and Home page not matching");

		//Doctor Login
		hmsHomePage.doctorLoginClickAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorLoginPage"), "Doctor Login page not matching");
		loginPage.loginAction(map.get("DoctorEmail"), map.get("DoctorPassword"));
		String actualInvalidLoginMessage = loginPage.getWarningMessage();
		Assert.assertEquals(actualInvalidLoginMessage, verify.get("InvalidLoginMessage"),"Invalid Login Warning message not displayed");
	}
}
