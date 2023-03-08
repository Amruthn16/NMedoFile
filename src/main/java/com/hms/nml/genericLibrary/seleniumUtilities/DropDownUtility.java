package com.hms.nml.genericLibrary.seleniumUtilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class dropDownUtility is used for handling Drop down list
 * @author Amruth N
 *
 */
public class DropDownUtility {

	/**
	 * This method is used for handling Drop down list based on index
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method is used for handling Drop down list based on value
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value) {
		Select s= new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used for handling Drop down list based on visible text
	 * @param text
	 */
	public void handleDropDown(String visibleText, WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(visibleText);
	}

}
