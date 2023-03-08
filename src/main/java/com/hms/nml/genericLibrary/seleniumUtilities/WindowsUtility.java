package com.hms.nml.genericLibrary.seleniumUtilities;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebDriver;

	/**
	 * This class windowsUtility is used to handle multiple windows
	 * @author Amruth N
	 *
	 */
public class WindowsUtility {
	private WebDriver driver;
	/**
	 * This method is used to switch to windows
	 * @param partialTitle
	 */
	public void switchToWindows( String expectedTitle ) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String windows : allWindows) {
			driver.switchTo().window(windows);
			String actualTitle = driver.getTitle();
			if(actualTitle.contains(expectedTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used to close all child windows
	 * @param driver
	 */
	public void closeAllChildWindows( ) {
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windows : allWindows) {
			driver.switchTo().window(windows);
			if(!(parentWindow.equals(windows))) {
				driver.close();
			}
		}
	}

	/**
	 * This method is used to close specific window
	 * @param expTitle
	 */
	public void closeSpecificWindow( String expTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String windows : allWindows) {
			driver.switchTo().window(windows);
			String actTile = driver.getTitle();
			if(actTile.contains(expTitle)) {
				driver.close();
			}
		}
	}

	/**
	 * This method is used to close all windows except the specific window
	 * @param expTitle
	 */
	public void closeAllExceptSpecificWindow(String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String windows : allWindows) {
			driver.switchTo().window(windows);
			String actTile = driver.getTitle();
			if(!(actTile.contains(expectedTitle))) {
				driver.close();
			}
		}
	}

	/**
	 * This method will switch between windows 
	 * @param partialTitle
	 */
	public void switchToWindow( String expectedTitle) {
	
		//step1: use getWindowHandes to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator <String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title 
			String actualTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether current window is expected
			if(actualTitle.contains(expectedTitle))
			{
				break;
			}
		}
	}
	

}
