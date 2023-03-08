package com.hms.nml.genericLibrary.configAnnotation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.hms.nml.genericLibrary.enums.PropertyKey;
import com.hms.nml.genericLibrary.externalResource.ExcelUtilities;
import com.hms.nml.genericLibrary.externalResource.PropertyUtility;
import com.hms.nml.genericLibrary.listener.ExtentReportListener;
import com.hms.nml.genericLibrary.miscellaneous.FrameworkConstants;
import com.hms.nml.genericLibrary.miscellaneous.JavaScriptUtilites;
import com.hms.nml.genericLibrary.miscellaneous.JavaUtility;
import com.hms.nml.genericLibrary.miscellaneous.ReportUtility;
import com.hms.nml.genericLibrary.miscellaneous.VerificationUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.DropDownUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.PopUpUtilities;
import com.hms.nml.genericLibrary.seleniumUtilities.TakesScreenshotUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.WaitsUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.WebDriverUtilities;

import hms.nml.pageRepository.HospitalManagementSystemPage;
import hms.nml.pageRepository.LoginPage;
import hms.nml.pageRepository.adminPageRepository.AddDoctorPage;
import hms.nml.pageRepository.adminPageRepository.AddDoctorSpecializationPage;
import hms.nml.pageRepository.adminPageRepository.AdminAppointmentHistoryPage;
import hms.nml.pageRepository.adminPageRepository.AdminCommonPage;
import hms.nml.pageRepository.adminPageRepository.ManageDoctorPage;
import hms.nml.pageRepository.doctorPageRepository.AddMedicalHistoryPage;
import hms.nml.pageRepository.doctorPageRepository.AddPatientPage;
import hms.nml.pageRepository.doctorPageRepository.DoctorAppointmentHistoryPage;
import hms.nml.pageRepository.doctorPageRepository.DoctorCommonPage;
import hms.nml.pageRepository.doctorPageRepository.ManagePatientsPage;
import hms.nml.pageRepository.patientPageRepository.BookAppointmentPage;
import hms.nml.pageRepository.patientPageRepository.RegistrationPage;
import hms.nml.pageRepository.patientPageRepository.UserCommonPage;

/**
 * This class contians all testNg configurations annotations 
 * @author Amruth N
 *
 */
@Listeners(ExtentReportListener.class)
public class BaseClass {

	protected PropertyUtility propertyUtils; 
	protected ExcelUtilities excelUtils;

	public WebDriverUtilities webDriverUtils; 
	protected VerificationUtility verificationUtils;
	public JavaUtility javaUtils;
	protected DropDownUtility dropDownUtils;
	protected PopUpUtilities popUpUtils;
	protected JavaScriptUtilites javaScriptUtils;
	public WebDriver driver;
	protected long timeUnit;
	protected String url;
	protected String browser;
	public TakesScreenshotUtility takesScreenshotUtils;
	protected WaitsUtility waitUtils;
	protected LoginPage loginPage;
	protected HospitalManagementSystemPage hmsHomePage;
	protected RegistrationPage registrationPage;
	protected UserCommonPage userCommonPage;
	protected BookAppointmentPage bookAppointmentPage; 
	protected DoctorAppointmentHistoryPage doctorAppointmentHistoryPage;
	protected String doctorUsername;
	protected String doctorPassword;
	protected String adminUsername;
	protected String adminPassword;
	protected String userUsername;
	protected String userPassword;
	protected DoctorCommonPage doctorCommonPage;
	protected AdminCommonPage adminCommonPage;
	protected AddDoctorPage addDoctorPage;
	protected ManageDoctorPage manageDoctorPage;
	protected AddDoctorSpecializationPage addDoctorSpecializationPage;
	protected AddPatientPage addPatientPage;
	protected ManagePatientsPage managePatientsPage;
	protected AddMedicalHistoryPage addMedicalHistoryPage;
	protected AdminAppointmentHistoryPage adminAppointmentHistoryPage;
	protected SoftAssert softassert;
	
	public ExtentTest test;
	protected ReportUtility report;

	/**
	 * This method is used to initialize the utilities, to open browser and read common data
	 * @param browser
	 */
	@Parameters(value="browser")
	@BeforeClass(alwaysRun=true)
	public void initializationSetup(@Optional String browser) {
		report=ExtentReportListener.sreport;
		propertyUtils= new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		excelUtils = new ExcelUtilities(FrameworkConstants.TEST_EXCEL_FILE_PATH);

		webDriverUtils=new WebDriverUtilities();
		verificationUtils = new VerificationUtility();
		javaUtils= new JavaUtility();
		dropDownUtils=new DropDownUtility();
		popUpUtils = new PopUpUtilities();
		
		if(browser==null  ||browser.isEmpty() || browser.equals("")) {
			browser = propertyUtils.getPropertyData(PropertyKey.BROWSER);
		}
		this.browser=browser;
		
		url = propertyUtils.getPropertyData(PropertyKey.URL);
		timeUnit = Long.parseLong(propertyUtils.getPropertyData(PropertyKey.TIMEUNIT));
		userUsername = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.USERUSERNAME));
		userPassword = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.USERPASSWORD));
		doctorUsername = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.DOCTORUSERNAME));
		doctorPassword = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.DOCTORPASSWORD));
		adminUsername =javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.ADMINUSERNAME));
		adminPassword =javaUtils.decode( propertyUtils.getPropertyData(PropertyKey.ADMINPASSWORD));

	}

	/**
	 * This method is used to open browser and initialize the pom pages
	 */
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		driver = webDriverUtils.launchBrowser(browser);
		webDriverUtils.maximizeBrowser();
		webDriverUtils.getUrl(url);
		waitUtils = new WaitsUtility(driver);
		waitUtils.waitForPageLoad(timeUnit);
		takesScreenshotUtils = new TakesScreenshotUtility(driver);
		javaScriptUtils = new JavaScriptUtilites(driver);

		softassert= new SoftAssert();

		loginPage=new LoginPage(driver);
		hmsHomePage= new HospitalManagementSystemPage(driver);
		registrationPage= new RegistrationPage(driver);
		userCommonPage= new UserCommonPage(driver);
		bookAppointmentPage = new BookAppointmentPage(driver);
		doctorAppointmentHistoryPage = new DoctorAppointmentHistoryPage(driver);
		doctorCommonPage= new DoctorCommonPage(driver);
		adminCommonPage= new AdminCommonPage(driver);
		addDoctorPage = new AddDoctorPage(driver);
		manageDoctorPage= new ManageDoctorPage(driver);
		addDoctorSpecializationPage= new AddDoctorSpecializationPage(driver);
		addPatientPage= new AddPatientPage(driver);
		managePatientsPage = new ManagePatientsPage(driver);
		addMedicalHistoryPage = new AddMedicalHistoryPage(driver);
		adminAppointmentHistoryPage = new AdminAppointmentHistoryPage(driver);

	}

	/**
	 * This method is used to close browser
	 */
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		webDriverUtils.closeBrowser();
	}

	/**
	 * This method ia used to close the excel file
	 */
	@AfterClass(alwaysRun=true)
	public void initializationTearDown() {
		excelUtils.close();
	}

}
