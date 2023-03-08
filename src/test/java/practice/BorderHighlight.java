package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BorderHighlight {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		JavascriptExecutor j= (JavascriptExecutor)driver;

		driver.get("https://www.google.com");
		WebElement textField = driver.findElement(By.name("q"));
		j.executeScript("arguments[0].setAttribute('style','border:6px solid red;');",textField);
		driver.close();
		
	}

}
