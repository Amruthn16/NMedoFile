package com.hms.nml.genericLibrary.miscellaneous;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hms.nml.genericLibrary.enums.PropertyKey;
import com.hms.nml.genericLibrary.enums.ReportKey;
import com.hms.nml.genericLibrary.externalResource.PropertyUtility;
/**
 * 
 * @author amruth
 *
 */
public class ReportUtility {
	private ExtentReports report;
	
	/**
	 * This is the constructor is used to initialize the report file
	 */
	public ReportUtility(){
		init();
	}
	
	/**
	 * This method is used to prepare the report and template of the report
	 * @param filePath
	 * @param title
	 * @param reportName
	 * @param browserName
	 */
	private void init() {
		
		PropertyUtility propertyUtils= new PropertyUtility(FrameworkConstants.REPORT_PROPERTY_FILE_PATH);
		String overrideOrNot=propertyUtils.getReportData(ReportKey.OVERRIDEREPORT);
		String randomName="";
		if(overrideOrNot.equalsIgnoreCase("no")) {
			randomName="_"+new JavaUtility().getCurrentDateTime();
		}
		
		//To add the template we call ExtentSparkReporter for the report
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.EXTENT_REPORT_FOLDER_PATH+"extentReport"+randomName+".html");
		spark.config().setDocumentTitle(propertyUtils.getReportData(ReportKey.EXTENTREPORTTITLE));
		spark.config().setReportName(propertyUtils.getReportData(ReportKey.EXTENTREPORTNAME));
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		//To add the system information to the report
		report.setSystemInfo("Browser", propertyUtils.getPropertyData(PropertyKey.BROWSER));
		report.setSystemInfo("OS", System.getProperty("os.name"));
	}
	
	/**
	 * This method is used to create the test tab in report and initializing the test
	 * @param testName
	 */
	public void createTest(String testName) {
		ExtentTest test = report.createTest(testName);
		UtilityInstanceTranformer.setExtentTest(test);
	}
	
	/**
	 * This method is used to add the author name in report
	 * @param test
	 * @param names
	 */
	public void addAuthor(ExtentTest test, String... names) {
		test.assignAuthor(names);
	}
	/**
	 * This method is used to add the category in report
	 * @param test
	 * @param names
	 */
	public void addCategory(ExtentTest test,String... names ) {
		test.assignCategory(names);
	}
	
	/**
	 * This method will give the pass message in report
	 * @param test
	 * @param message
	 */
	public void pass(ExtentTest test, String message) {
		test.pass(message);
		System.out.println(message);
	}
	
	/**
	 * This method will give the error message of the failed testScripts
	 * @param test
	 * @param message
	 * @param errorMessage
	 */
	public void fail(ExtentTest test, String message, Throwable errorMessage) {
		test.fail(message);
		test.fail(errorMessage);
		System.out.println(message);
	}
	
	/**
	 * This method will give the error message of the skipped testScripts
	 * @param test
	 * @param message
	 * @param errorMessage
	 */
	public void skip(ExtentTest test,String message, Throwable errorMessage) {
		test.skip(message);
		test.skip(errorMessage);
		System.out.println(message);
	}
	
	/**
	 * This method will give the warning message of the testScripts
	 * @param test
	 * @param message
	 * @param errorMessage
	 */
	public void warn(ExtentTest test, String message, Throwable errorMessage) {
		test.warning(message);
		test.warning(errorMessage);
		System.out.println(errorMessage);
	}
	
	
	/**
	 * This method will give the informations of the testScripts
	 * @param test
	 * @param message
	 */
	public void info(ExtentTest test, String message) {
		test.info(message);
		System.out.println(message);
	}
	
	/**
	 * This method is used to attach the screenshot
	 * @param test
	 * @param screenShotPath
	 * @param title
	 * @param strategy
	 */
	public void attachScreenShot (ExtentTest test, String screenShotPath, String title, String strategy) {
		if(strategy.equalsIgnoreCase("base64")) {
			test.addScreenCaptureFromBase64String(screenShotPath, title);
		}
		else {
			test.addScreenCaptureFromPath(screenShotPath, title);
		}
	}
	

	/**
	 * This method is used to save the report
	 */
	public void saveReport() {
		report.flush();
	}
}
