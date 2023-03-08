package com.hms.nml.genericLibrary.seleniumUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * This is a Actions class used to handle all the actions methods
 * @author Amruth N
 *
 */
public class ActionsUtility {
	
	private WebDriver driver;
	Actions a= new Actions(driver);
	private Robot rb;

	
		/**
		 * This method used to perform the mouse hover action
		 * @param element
		 */
		public void mouseHover( WebElement element) {
			a.moveToElement(element).perform();
		}

		/**
		 * This method is used to perform the drag and drop action
		 * @param sourceElement
		 * @param targetElement
		 */
		public void dragAndDrop( WebElement sourceElement, WebElement targetElement) {
			a.dragAndDrop(sourceElement, targetElement).perform();
		}

		/**
		 * This method is used to perform the right click action on web page
		 */
		public void rightClick() {
			a.contextClick().perform();
		}

		/**
		 * This method is used to perform the right click action on web element
		 * @param driver
		 * @param element
		 */
		public void rightClick(WebElement element) {
			a.contextClick(element).perform();
		}

		/**
		 * This method is used to perform the double click action on web page
		 */
		public void doubleClick() {
			a.doubleClick().perform();
		}

		/**
		 * This method is used to perform the double click action on web element
		 * @param element
		 */
		public void doubleClick( WebElement element) {
			a.doubleClick(element).perform();
		}
		
		/**
		 * This method is used to Press the Enter Key
		 */
		public void enterKeyPress()
		{
			a.sendKeys(Keys.ENTER).perform();
		}
		
		/**
		 * This method will Press Enter Key using robot class
		 */
		public void enterKey()
		{
			try {
				rb = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			rb.keyPress(KeyEvent.VK_ENTER);
		}
		
		/** 
		 * This method is used to release the key
		 */
		public void enterRelease()
		{
			try {
				rb = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		
		


}
