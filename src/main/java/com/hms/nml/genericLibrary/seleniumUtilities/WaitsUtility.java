package com.hms.nml.genericLibrary.seleniumUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * This waitsUtility class is used to handle the synchronization
 * @author Amruth N
 *
 */
public class WaitsUtility {
	private WebDriver driver;
	
	/**
	 * This is the constructor for getting the instance of driver
	 * @param driver
	 */
	public WaitsUtility(WebDriver driver)
	{
		this.driver=driver;
	}

	/**
	 * This method used to pause the execution
	 * @param milliSeconds
	 */
	public void pause(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to wait for the page load	
	 * @param time
	 */
	public void waitForPageLoad( long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to wait until element to be visible
	 * @param element
	 * @param timeUnit
	 */
	public void waitForElement( WebElement element, long time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method used to wait until the alter popup get displayed 
	 * @param timeUnit
	 */
	public void waitForAlter(long time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method is used to wait until the element gets clickable
	 * @param time
	 * @param element
	 */
	public void waitForClick(long time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method used to write custom waiting statement to handle the synchronization
	 * @param element
	 */
	public void customWait(WebElement element) {
		int i=0;
		while(i<=100) {
			try {
				element.isEnabled();
				break;
			}catch(Exception e) {
				i++;
			}
		}
	}
	
	/**
	 * This method used to write custom wait till the element gets clickable
	 * @param duration
	 * @param pollingTime
	 * @param element
	 */
	public void waitForClick(int duration,long pollingTime, WebElement element) {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count=count+((int)pollingTime/1000);
			}
			
		}
	}


}
