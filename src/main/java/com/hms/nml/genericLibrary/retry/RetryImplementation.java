package com.hms.nml.genericLibrary.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class contains methods present in the IRetryAnalyzer 
 * @author amruth
 *
 */
public class RetryImplementation  implements IRetryAnalyzer{
	
	int count;

	/**
	 * This method used to reExecute the failed test scrits
	 */
	@Override
	public boolean retry(ITestResult result) {
		int maxCount=2;
		if(count<maxCount) {
			count++;
			return true;
		}
		return false;
	}


}
