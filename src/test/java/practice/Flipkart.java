package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		/*
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']/ancestor::div[@class='_1YokD2 _3Mn1Gg']//div[@class='_30jeq3 _1_WHN1']"));
		
		for(WebElement p:products) {
			String text = p.getText().substring(1).replaceAll(",", "");
			int no= Integer.parseInt(text);
			for(WebElement n:name) {
					if(no>=20000 && no <=30000 ) {
						String lap = n.getText();
						System.out.println(lap+"-->"+no);
						}
				}
			}
		}
		*/
}
}