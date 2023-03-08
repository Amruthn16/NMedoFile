package hms.nml.doctor;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.nml.genericLibrary.configAnnotation.BaseClass;
import com.hms.nml.genericLibrary.enums.ExcelSheet;
import com.hms.nml.genericLibrary.enums.TabNames;

public class CancellingAppointmentByDoctorTest extends BaseClass {

	@Test(groups="regression")
	public void cancellingAppointmentByDoctorTest()  {
		String sheetName = ExcelSheet.USER.getSheetName();
		String expTestScriptName = "UserRegistrationLoginAndBookAppointmentTest";
		Map<String, String> map = excelUtils.getData(expTestScriptName, sheetName);
		Map<String, String> verify = excelUtils.getData("PageNames", "Verification");

		//User registration
		hmsHomePage.patientLoginClickAction();
		String actual = webDriverUtils.getTitle();
		String expected = verify.get("UserLoginPage");
		Assert.assertTrue(actual.equals(expected),"User login page not displayed" );
		loginPage.clickCreateAccountLinkAction();
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("UserRegistrationPage")));
		String userEmail = map.get("Email")+javaUtils.getRandomNumber(1000)+"@gmail.com";
		registrationPage.userRegisteringAccountAction(excelUtils.getData("userDetials", "Data"), userEmail);
		popUpUtils.alterAccept(driver);
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("UserRegistrationPage")));

		// user login
		registrationPage.clickLoginLinkAction();
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("UserLoginPage")));
		loginPage.loginAction(userEmail, map.get("Password"));
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserDashboardPage"));

		// user booking appointment
		userCommonPage.clickTab(TabNames.BOOKAPPOINTMENT);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserBookAppointmentPage"));
		bookAppointmentPage.bookAppointmentAction(javaUtils, dropDownUtils, map.get("Doctorspecialization"), map.get("DoctorName"), map.get("Hour"), map.get("Minute"), map.get("Meridian"));
		popUpUtils.alterAccept(driver);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("UserBookAppointmentPage"));

		//user logout
		userCommonPage.clickLogoutAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("HomePage"));


		//Doctor login
		hmsHomePage.doctorLoginClickAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorLoginPage"));
		loginPage.loginAction(doctorUsername, doctorPassword);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorDashboardPage"));

		//Doctor checking Appointment History
		userCommonPage.clickTab(TabNames.APPOINTMENTHISTORY);
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("DoctorAppointmentHistoryPage"));
		String actualUsername = doctorAppointmentHistoryPage.getUserAppointment(map.get("Name"));
		String expectedUsername = map.get("Name");
		Assert.assertEquals(actualUsername, expectedUsername,"Schedule appointment not displayed in list" );

		//Doctor cancelling Appointment
		doctorAppointmentHistoryPage.cancelUserAppointmentAction(javaScriptUtils);
		popUpUtils.alterAccept(driver);
		String actualAppointmentCanceledMessage= doctorAppointmentHistoryPage.getAppointmentCancelledText();
		Assert.assertEquals(actualAppointmentCanceledMessage, verify.get("AppointmentCanceledMessage"), "Appointment not cancelled");

		//Doctor logout
		doctorCommonPage.clickLogoutAction();
		Assert.assertEquals(webDriverUtils.getTitle(), verify.get("HomePage"), "Doctor not logged out and Homepage not matching");

		//Admin login
		hmsHomePage.adminLoginClickAction();
		String actualLoginPage = webDriverUtils.getTitle();
		Assert.assertTrue(actualLoginPage.equals(verify.get("AdminLoginPage")));
		loginPage.loginAction(adminUsername, adminPassword);
		Assert.assertTrue(webDriverUtils.getTitle().equals(verify.get("AdminDashboardPage")));

		//Admin checking Appointment History
		adminCommonPage.clickTab(TabNames.APPOINTMENTHISTORY);
		String actualAppointmentStatus = adminAppointmentHistoryPage.getAppointmentStatusAction(map.get("Name"));
		Assert.assertEquals(actualAppointmentStatus, verify.get("DoctorCancellingAppointment"), "Appointment status is active and TC fail");
	}
}
