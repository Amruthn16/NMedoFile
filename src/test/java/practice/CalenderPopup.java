package practice;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup {

	public static int calenderPopup(WebElement currentMonth, int reqMon, int reqYr, int reqDt, WebElement next, WebElement previous) throws InterruptedException {
		String cymtxt= currentMonth.getText();
		String cm= cymtxt.split(" ")[0];
		String cy= cymtxt.split(" ")[1];

		int cyn= Integer.parseInt(cy);
		int cmn = DateTimeFormatter.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(cm)
				.get(ChronoField.MONTH_OF_YEAR);


		while(cmn<reqMon || cyn<reqYr) {
			next.click();
			Thread.sleep(1000);
			cymtxt= currentMonth.getText();
			cm= cymtxt.split(" ")[0];
			cy= cymtxt.split(" ")[1];
			cyn= Integer.parseInt(cy);
			cmn = DateTimeFormatter.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(cm)
					.get(ChronoField.MONTH_OF_YEAR);

		}
		
		while(cmn>reqMon || cyn>reqYr) {
			previous.click();
			Thread.sleep(1000);
			cymtxt= currentMonth.getText();
			cm= cymtxt.split(" ")[0];
			cy= cymtxt.split(" ")[1];
			cyn= Integer.parseInt(cy);
			cmn = DateTimeFormatter.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(cm)
					.get(ChronoField.MONTH_OF_YEAR);
		}

		return reqDt;

	}
	
	
	 public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.calculator.net/date-calculator.html");
		driver.findElement(By.xpath("(//img[@title='Calendar'])[1]")).click();
		WebElement currentMonth = driver.findElement(By.xpath("(//td[@title='Show Current Month'])[1]"));
		WebElement previous=driver.findElement(By.xpath("//td[@id='today_Previous_ID']"));
		WebElement next=driver.findElement(By.xpath("//td[@id='today_Next_ID']"));
		
		int reqMon = 12;
		int reqYr = 2022;
		int reqDt = 07;
		int date = calenderPopup(currentMonth, reqMon, reqYr, reqDt, next, previous);
		driver.findElement(By.xpath("(//td[@class='calendarDateInput' and text()='"+date+"'])[1]")).click();
	}

}
