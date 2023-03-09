package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartLaptop {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1'][not(number(translate(text(),'₹,',' '))>30000 and number(translate(text(),'₹,',' '))<50000)]"));
		List<WebElement> laptopName = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1'][not(number(translate(text(),'₹,',' '))>30000 and number(translate(text(),'₹,',' '))<50000)]/ancestor::div[@class='_3pLy-c row']/child::div/child::div[@class='_4rR01T']"));
		for(WebElement p:price) {
			
			for(WebElement n:laptopName) {
				System.out.println(n.getText()+"-->"+p.getText());
				break;
			}
		}
	}	
}
