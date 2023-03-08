package practice;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PomExamplePage {
	WebDriver driver;
	
	private String partialXpath="//input[@id='%s']";
	
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	public PomExamplePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	public void setDataIntoTextField(Map<String, String> userTestData, PomExEnum testData) {
		
		for(Entry<String, String> texData : userTestData.entrySet() ) {
	
			 convertToWebElement(partialXpath, testData.getTextData()).sendKeys(texData.getValue());
			 
//			 Set<Entry<String, String>> data = medicalData.entrySet();
//				Iterator<Entry<String, String>> it = data.iterator();
//				while(it.hasNext())
//				{
//					  Entry<String, String> tt = it.next();
//					convertToWebElement(addMedicalHistoryPartialXpath, tt.getKey()).sendKeys(tt.getValue());
//				}
		}
	}
	
}
