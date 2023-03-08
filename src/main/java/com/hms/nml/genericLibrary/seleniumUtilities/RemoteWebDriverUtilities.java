package com.hms.nml.genericLibrary.seleniumUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This class remoteWebDriverUtilities is used to provide different methods of remoteWebDriver
 * @author Amruth N
 *
 */
public class RemoteWebDriverUtilities {

	/**
	 * This method is used to handle Disable Element
	 * @param driver
	 * @param javaScriptStatement
	 */
		public void disableElement(WebDriver driver, String javaScriptStatement) {
			RemoteWebDriver r =(RemoteWebDriver) driver;
			r.executeScript(javaScriptStatement);
		}
}
