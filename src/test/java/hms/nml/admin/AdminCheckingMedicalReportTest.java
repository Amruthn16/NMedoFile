package hms.nml.admin;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.configAnnotation.BaseClass;
import com.hms.nml.genericLibrary.enums.ExcelSheet;
import com.hms.nml.genericLibrary.enums.TabNames;

public class AdminCheckingMedicalReportTest extends BaseClass{

	@Test
	public void adminCheckingMedicalReportTest() {
		
		String sheetName = ExcelSheet.DOCTOR.getSheetName();
		String expTestScriptName = "ApprovePatientAppointmentAndAddMedicalHistoryTest";
		Map<String, String> map = excelUtils.getData(expTestScriptName, sheetName);
		Map<String, String> verify = excelUtils.getData("PageNames", "Verification");


		//user Login
		hmsHomePage.patientLoginClickAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserLoginPage"), "User Login page not matching");
		loginPage.loginAction(userUsername, userPassword);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserDashboardPage"),"User not logged in and page not matching");


		// user booking appointment
		userCommonPage.clickTab(TabNames.BOOKAPPOINTMENT);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserBookAppointmentPage"), "User Book Appointment page not matching");
		bookAppointmentPage.bookAppointmentAction(javaUtils, dropDownUtils, map.get("Doctorspecialization"), map.get("DoctorName"), map.get("Hour"), map.get("Minute"), map.get("Meridian"));
		popUpUtils.alterAccept(driver);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserBookAppointmentPage"),"User not booked appointment and User Book Appointment page not matching");

		
		//user logout
		userCommonPage.clickLogoutAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("HomePage"), "User not logged out and Homepage not matching");

		//Doctor login
		hmsHomePage.doctorLoginClickAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorLoginPage"), "Doctor Login page not matching");
		loginPage.loginAction(doctorUsername, doctorPassword);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorDashboardPage"),"Doctor not logged in and page not matching");
		
		//Doctor checking appointment history
		doctorCommonPage.clickTab(TabNames.APPOINTMENTHISTORY);
		String actualUsername = doctorAppointmentHistoryPage.getUserAppointment(map.get("UserName"));
		String expectedUsername = map.get("UserName");
		Assert.assertEquals(actualUsername, expectedUsername, "User name not present in the Appointment list");

		//Doctor adding patient
		doctorCommonPage.clickTab(TabNames.PATIENTS);
		doctorCommonPage.clickTab(TabNames.ADDPATIENT);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorAddPatientPage"), "Doctor Add Patient Page not displayed");
		String patEmail= map.get("UserName")+javaUtils.getRandomNumber(1000)+"@gmail.com";
		addPatientPage.addPatientAction(excelUtils.getData("patientDetails", "Data"), patEmail);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorAddPatientPage"), "Patient not added and Doctor Add Patient Page not displayed");
		
		//Doctor adding medical details
		doctorCommonPage.clickTab(TabNames.PATIENTS);
		doctorCommonPage.clickTab(TabNames.MANAGEPATIENT);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorManagePatientsPage"), "Manage Patients Page not displayed");
		managePatientsPage.clickViewIcon();
		managePatientsPage.clickaddMedicalHistoryButton();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorManagePatientsPage"), "Add Medical History Page not displayed");
		addMedicalHistoryPage.addMedicalHistoryAction(excelUtils.getData("medicalHistory", "Data"));
		popUpUtils.alterAccept(driver);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorManagePatientsPage"), "Patient medication not added");

		//Doctor Logout
		doctorCommonPage.clickLogoutAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("HomePage"), "Doctor not logged out and Homepage not matching");

		//Admin Login

	}

}
