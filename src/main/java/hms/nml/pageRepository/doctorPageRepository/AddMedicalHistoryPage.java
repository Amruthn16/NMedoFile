package hms.nml.pageRepository.doctorPageRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMedicalHistoryPage {
	private WebDriver driver;

	private String addMedicalHistoryPartialXpath="//*[@name='%s']";

	@FindBy(xpath="//button[@class='btn btn-primary']") private WebElement submitButton;

	/**
	 * This method is used to convert the parial xpath into web element
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public AddMedicalHistoryPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to add the medical history for the patients on Add Medical History Page
	 * @param medicalData
	 */
	public void addMedicalHistoryAction(Map<String, String> medicalData){
		for(Entry<String, String> data : medicalData.entrySet() ) {
			convertToWebElement(addMedicalHistoryPartialXpath, data.getKey()).sendKeys(data.getValue());
		}

		submitButton.click();
	}
}
