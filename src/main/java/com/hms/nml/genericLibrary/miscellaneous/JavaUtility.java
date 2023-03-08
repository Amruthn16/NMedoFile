package com.hms.nml.genericLibrary.miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.WebElement;


/**
 * This class contains java specific generic methods
 * @author Amruth N
 *
 */
public class JavaUtility {
	SimpleDateFormat sdf;
	Calendar cal;

	/**
	 * This is the method used to provide the random number
	 * @param boundaryValue
	 * @return randomNumber
	 */
	public int getRandomNumber(int boundaryValue) {
		int randomNumber = new Random().nextInt(boundaryValue);
		return randomNumber;
	}

	/**
	 * This is method used for printing the data in console 
	 * @param data
	 */
	public void printConsole(String data) {
		System.out.println(data);
	}

	/**
	 * This method is used to split the string
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] split(String s, String strategy) {
		return s.split(strategy);
	}

	/**
	 * This method is used to decode the string 
	 * @param s
	 * @return
	 */
	public String decode(String s) {

		return new String(Base64.getDecoder().decode(s.getBytes()));
	}

	/**
	 * This method is used to encode the string
	 * @param s
	 * @return
	 */
	public String encode(String s) {
		return new String (Base64.getEncoder().encode(s.getBytes()));
	}

	/**
	 * this method will generate the current system date
	 * @return
	 */
	public String getCurrentDateTime()
	{
		sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
		return sdf.format(new Date());
	}

	/**
	 * This method will generate the current system in specific format
	 * @return
	 */
	public String getCurrentDateTime(String pattern) {
		sdf=new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}


	/**
	 * This generic method will add or subtract specific no of days to current date
	 * @param noOfDays
	 * @return
	 */
	public String addOrSubtractToCurrentDate(int noOfDays)
	{
		sdf = new SimpleDateFormat("dd_MM_yyyy");
		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noOfDays);
		return sdf.format(cal.getTime());

	}

	/**
	 * This generic method will add or subtract specific no of days to specified date 
	 * @param noOfDays
	 * @param pattern
	 * @return
	 */
	public String addOrSubtractToSpecifiedDate(int noOfDays, String date)
	{
		sdf = new SimpleDateFormat("dd_MM_yyyy");
		cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, noOfDays);
		return sdf.format(cal.getTime());

	}
	
	/**
	 * This method is used to convert the month name into month number
	 * @param monthName
	 * @return
	 */
	public int getMonthNumber(String monthName) {
		int monthNo = DateTimeFormatter.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(monthName)
				.get(ChronoField.MONTH_OF_YEAR);
		return monthNo;
	}

}

