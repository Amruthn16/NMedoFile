package com.hms.nml.genericLibrary.miscellaneous;

import com.aventstack.extentreports.ExtentTest;
/**
 * This class is used to create the multiple copy of the instance
 * @author amruth
 *
 */
public class UtilityInstanceTranformer {
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	/**
	 * This method is used to get the instance of the test
	 * @return
	 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	
	/**
	 * This method is used to set the instance of the test
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		 extentTest.set(setExtentTest);
	}
	
}
