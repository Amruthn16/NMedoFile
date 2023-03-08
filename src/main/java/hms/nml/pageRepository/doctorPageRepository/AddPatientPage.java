package hms.nml.pageRepository.doctorPageRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddPatientPage {
	private WebDriver driver;

	String addPatientPartialXpath="//*[@name='%s']";
	
	@FindBy(id="patemail") private WebElement patientEmailTxtField;
	@FindBy(xpath="//label[contains(text(),'Male')]") private WebElement maleRadioButton;
	@FindBy(id="submit") private WebElement submitButton;

	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public AddPatientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to add the Patient on the Add Patient Page
	 * @param patientData
	 * @param patEmail
	 */
	public void addPatientAction(Map<String, String> patientData, String patEmail){
		for(Entry<String, String> data : patientData.entrySet() ) {
			convertToWebElement(addPatientPartialXpath, data.getKey()).sendKeys(data.getValue());
		}
		patientEmailTxtField.sendKeys(patEmail);
		maleRadioButton.click();
		submitButton.click();

	}
}
