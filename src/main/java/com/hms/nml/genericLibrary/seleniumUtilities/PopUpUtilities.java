package com.hms.nml.genericLibrary.seleniumUtilities;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	/**
	 * This class popupUtilities used for Handling popups
	 * @author Amruth N
	 *
	 */
public class PopUpUtilities {


	/**
	 * 	This method is used to switch to alert popup and accept
	 * @param driver
	 */
	public void alterAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * 	This method is used to switch to alert popup and cancel
	 * @param driver
	 */
	public void alterCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 	This method is used to switch to alert popup and enter data in it
	 * @param driver
	 * @param data 
	 */
	public void enterTextInAlter(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * 	This method is used to switch to alert popup and get text from it
	 * @param driver
	 * @return 
	 */
	public String getTextFromAlter(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * 	This method is used to handle the file upload popup
	 * @param filePath
	 * @return
	 */
	public String fileUploadPopup(String filePath) {
		File f=new File(filePath);
		String absolutePath = f.getAbsolutePath();
		return absolutePath;
	}
	
	
	/**
	 * This generic method will add the required date in calender popup
	 * @param calYM
	 * @param reqDate
	 * @param reqMon
	 * @param reqyear
	 * @param next
	 * @param previous
	 * @return
	 */
	public int calenderPopup(WebElement calYM, int reqDate, int reqMon, int reqyear, WebElement next, WebElement previous) {
		String calenderYrMnText= calYM.getText();
		String calYear=calenderYrMnText.split(" ")[0];
		String calMonth=calenderYrMnText.split(" ")[1];
		int currentYrNo= Integer.parseInt(calYear);
		int currentMnNo= DateTimeFormatter.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(calMonth)
				.get(ChronoField.MONTH_OF_YEAR);


		while (currentYrNo< reqyear || currentMnNo < reqMon ) {
			next.click();
			calenderYrMnText= calYM.getText();
			calYear=calenderYrMnText.split(" ")[0];
			calMonth=calenderYrMnText.split(" ")[1];
			currentYrNo= Integer.parseInt(calYear);
			currentMnNo= DateTimeFormatter.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(calMonth)
					.get(ChronoField.MONTH_OF_YEAR);
		}

		while (currentYrNo > reqyear || currentMnNo > reqMon ) {
			previous.click();
			calenderYrMnText= calYM.getText();
			calYear=calenderYrMnText.split(" ")[0];
			calMonth=calenderYrMnText.split(" ")[1];
			currentYrNo= Integer.parseInt(calYear);
			currentMnNo= DateTimeFormatter.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(calMonth)
					.get(ChronoField.MONTH_OF_YEAR);
		}
		return reqDate;

	}


}
