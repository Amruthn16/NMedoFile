package com.hms.nml.genericLibrary.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hms.nml.genericLibrary.annotation.Report;
import com.hms.nml.genericLibrary.configAnnotation.BaseClass;
import com.hms.nml.genericLibrary.miscellaneous.ReportUtility;
import com.hms.nml.genericLibrary.miscellaneous.UtilityInstanceTranformer;

/**
 * This class contains methods present in the ITestListener and ISuiteListener
 * @author amruth
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener {

	private ReportUtility report;
	public static ReportUtility sreport;
	
	/**
	 * This method will execute before the suite (@beforeSuite)
	 * and initialling the non static report and store it in the static report 
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart ===> Suite");
		report = new ReportUtility();
		sreport=report;
	}
	
	/**
	 * This method will execute before the Test
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart ===> Test");
	}
	
	/**
	 * This method will execute before the execution of the test method (@Test),
	 * call the createTest method by passing the methodName (test case name) in it,
	 * and call the addAuthor and addCategory method by passing the arguments from the Report annotation
	 * 
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		System.out.println();
		report.addAuthor(UtilityInstanceTranformer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTranformer.getExtentTest(), reportAnnotation.category());
	}

	/**
	 * This method will execute after the execution of the passed test method
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTranformer.getExtentTest() , result.getMethod().getMethodName()+" is Pass");
	}

	/**
	 * This method will execute after the execution of the failed test method
	 * and takes the screenshot and attach to the report
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTranformer.getExtentTest() , result.getMethod().getMethodName()+"  is Failed", result.getThrowable() );
		
		String screenShotPath = BaseClass.class.cast(result.getMethod().getInstance()).takesScreenshotUtils.takeScreenShot();
		
		report.attachScreenShot(UtilityInstanceTranformer.getExtentTest(), screenShotPath, result.getMethod().getMethodName() , "base64");

	}

	/**
	 * This method will execute after the execution of the skipped test method
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTranformer.getExtentTest(),result.getMethod().getMethodName()+"  is skipped", result.getThrowable());
	}

	/**
	 * This method will execute after the execution of the failed test method but within success percentage
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	/**
	 * This method will execute after the execution of the failed test method with timeout
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	/**
	 * This method will execute after the execution of the test tag
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish ===> Test");
	}

	/**
	 * This method will execute after the execution of the suite and save the report
	 */
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish ===> Suite");
		report.saveReport();
	}
	
	

}
