package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OdiCricket {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/homepage");
		driver.findElement(By.xpath("(//button[contains(text(),'Rankings')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Overview')])[1]")).click();
		String country = driver.findElement(By.xpath("//h4[text()='ODI Team Rankings']/ancestor::div[@class='rankings-block__banner']/div[2]/div[@class='rankings-block__banner--team-name']")).getText();
		String ranking = driver.findElement(By.xpath("//h4[text()='ODI Team Rankings']/ancestor::div[@class='rankings-block__banner']/div[2]/div[@class='rankings-block__banner--rating u-text-right']")).getText();
		System.out.println(country+"-->"+ranking);
		driver.close();
	}
}
