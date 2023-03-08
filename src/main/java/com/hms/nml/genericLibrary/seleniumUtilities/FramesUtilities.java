package com.hms.nml.genericLibrary.seleniumUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This class is used for handling frames
 * @author Amruth N
 *
 */
public class FramesUtilities {
	private WebDriver driver;
	
		/**
		 * This method is used to switch the frames based on index
		 * @param frameNo
		 */
		public void switchToFrame(int index) {
			driver.switchTo().frame(index);
		}

		/**
		 * This method is used to switch the frames based on name or id
		 * @param frameNameOrId
		 */
		public void switchToFrame( String frameNameOrId) {
			driver.switchTo().frame(frameNameOrId);
		}

		/**
		 * This method is used to switch the frames based on WebElement address
		 * @param element
		 */
		public void switchToFrame( WebElement address) {
			driver.switchTo().frame(address);
		}
		
		
		/**
		 * This method is used to switch back to the previous parent frame
		 */
		public void switchToParentFrame() {
			driver.switchTo().parentFrame();
		}

		/**
		 * This method is used to switch back to the main frame
		 */
		public void switchToDefaultContentFrame() {
			driver.switchTo().defaultContent();
		}



}
