package com.hms.nml.genericLibrary.seleniumUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hms.nml.genericLibrary.miscellaneous.JavaUtility;



/**
 * This class takesScreenshotUtility is used to provide different methods of takesScreenshot
 * @author Amruth N
 *
 */
public class TakesScreenshotUtility {
	private WebDriver driver;
	
	
	/**
	 * This is the constructor for getting the instance of driver
	 * @param driver
	 */
	public TakesScreenshotUtility(WebDriver driver){
		this.driver=driver;
	}
	


	/**
	 * This method will take screenshot of web page and save it in screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot( String screenShotName, JavaUtility javautils)
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+screenShotName+javautils.getCurrentDateTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath(); //used for extent reports
	}
	
	/**
	 * This method will take screenshot of failed testcases in extent reports
 	 * @return
	 */
	public String takeScreenShot()
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		String path=ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}

	
	/**
	 * This method will take screenshot of web element and save it in screenshot folder
	 * @param element
	 * @param elementName
	 * @param jUtil
	 * @return
	 */
	public String takeScreenShot(WebElement element, String elementName, JavaUtility javaUtils)
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/elements"+elementName+javaUtils.getCurrentDateTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}

}
