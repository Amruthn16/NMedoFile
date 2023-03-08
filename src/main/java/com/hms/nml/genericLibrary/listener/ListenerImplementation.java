package com.hms.nml.genericLibrary.listener;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener, IClassListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart ===> suite");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish ===> suite");
	}

	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		
		TestNgScreenshotPractice.class.cast(result.getMethod().getInstance()).takeScreenShotUtils.takeScreenShot(
				result.getMethod().getRealClass().getSimpleName(),
				TestNgScreenshotPractice.class.cast(result.getMethod().getInstance()).javaUtils);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart ===> Test");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish ===> Test");
	}


	
}
