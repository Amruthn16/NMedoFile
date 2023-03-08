package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableExVtiger {
	static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://192.168.0.146:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		String colName="Organization Name";
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tn[1]/td/a"));
		int count=0;
		for(int i=0; i<list.size(); i++) {
			String actHeader = list.get(i).getText();
			if(colName.equals(actHeader)) {
				count=i+2;
				break;
			}
		}
		String strPage=driver.findElement(By.xpath("//a[text()='Create Mail Merge templates']/following::span[@name]")).getText();
		int pages =Integer.parseInt(strPage.split(" ")[1]);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		String orgName = "amazon91";
		boolean flag = false;
		for(int i=0; i<pages; i++) {
			List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td["+count+"]"));
			for(WebElement webElement : listOrg) {
				String actOrg = webElement.getText();
				System.out.println(actOrg);
				if(actOrg.equals(orgName)) {
					driver.findElement(By.xpath("//a[text()="+orgName+"']/../preceding-sibling::td/input")).click();
					flag=true;
					break;
				}
			}
			if(flag) {
				break;
			}
			else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("status"))));
			}
		}
		
	}
}
