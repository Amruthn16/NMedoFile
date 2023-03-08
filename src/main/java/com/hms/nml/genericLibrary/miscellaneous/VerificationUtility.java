package com.hms.nml.genericLibrary.miscellaneous;

import com.hms.nml.genericLibrary.seleniumUtilities.TakesScreenshotUtility;

/**
 * The class VerificationUtility contains generic methods for verification purpose 
 * @author Amruth N
 *
 */
public class VerificationUtility {


	/**
	 * This method will verify for exact value using nested for loop concept
	 * @param actual
	 * @param expected
	 */
	public void exactVerify(String actual, String expected, String strategy, String pageNameOrTCname)
	{
		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else
			{
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" page Displayed");
			}
			else
			{
				System.out.println(pageNameOrTCname+" page not Displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("element")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" is showing");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not showing");
			}
		}
		else if(strategy.equalsIgnoreCase("popup")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" is present");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not present");
			}
		}
	}

	/**
	 * This method will verify for partial data using nested for loop concept
	 * @param actual
	 * @param expected
	 */
	public void partialVerify(String actual, String expected, String strategy, String pageNameOrTCname)
	{
		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else
			{
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" page Displayed");
			}
			else
			{
				System.out.println(pageNameOrTCname+" page not Displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("element")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" is showing");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not showing");
			}
		}
		else if(strategy.equalsIgnoreCase("popup")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" is present");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not present");
			}
		}
	}
	
	/**
	 * This method is used for verify exactly actual and expected data 
	 * @param strategy
	 * @param pageNameOrTCnameOrElementOrPopup
	 * @param actual
	 * @param expected
	 */
	
	//This is the ex for Runtime Polymorphism
	public void exactlyVerify(String strategy,String pageNameOrTCnameOrElementOrPopup, String actual, String expected,  TakesScreenshotUtility takesScreenshotUtils, JavaUtility javaUtils) {
		String pass="";
		String fail="";
		switch (strategy.toUpperCase()) {
		case "TC":
			pass= " TC is pass";
			fail= " TC is fail";
			break;

		case "PAGE":
			pass= " page Displayed";
			fail= " page not Displayed";
			break;
			
		case "ELEMENT":
			pass= " is showing";
			fail= " is not showing";
			break;
			
		case "POPUP":
			pass= " Popup is present";
			fail= " Popup is not present";
			break;
			
		default:
			break;
		}
		if(actual.equals(expected)){
				System.out.println(pageNameOrTCnameOrElementOrPopup + pass);
			}
			else{
				System.out.println(pageNameOrTCnameOrElementOrPopup + fail);
				takesScreenshotUtils.takeScreenShot(actual, javaUtils);
			}
		}
	
	/**
	 * This method is used for verify partially actual and expected data 
	 * @param strategy
	 * @param pageNameOrTCnameOrElementOrPopup
	 * @param actual
	 * @param expected
	 */
	public void partialyVerify(String strategy,String pageNameOrTCnameOrElementOrPopup, String actual, String expected, TakesScreenshotUtility takesScreenshotUtils, JavaUtility javaUtils) {
		String pass="";
		String fail="";
		switch (strategy.toUpperCase()) {
		case "TC":
			pass= " TC is pass";
			fail= " TC is fail";
			break;

		case "PAGE":
			pass= " page Displayed";
			fail= " page not Displayed";
			break;
			
		case "ELEMENT":
			pass= " is showing";
			fail= " is not showing";
			break;
			
		case "POPUP":
			pass= " Popup is present";
			fail= " Popup is not present";
			break;
			
		default:
			break;
		}
		if(actual.contains(expected)){
				System.out.println(pageNameOrTCnameOrElementOrPopup + pass);
			}
			else{
				System.out.println(pageNameOrTCnameOrElementOrPopup + fail);
				takesScreenshotUtils.takeScreenShot(actual, javaUtils);
			}
		}

		
	}






