package hms.nml.pageRepository.adminPageRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.nml.genericLibrary.seleniumUtilities.DropDownUtility;


public class AddDoctorPage {
	private WebDriver driver;

	String addDoctorPartialXpath="//*[@name='%s']";
	
	@FindBy(name="Doctorspecialization") private WebElement doctorSpecializationDropDown;
	@FindBy(name="docemail") private WebElement doctorEmailTextFiled;
	@FindBy(id="submit") private WebElement submitButton;


	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public AddDoctorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to add the doctor on the Add doctor page
	 * @param dropDownUtils
	 * @param doctorSpecilization
	 * @param doctorData
	 * @param docEmail
	 */
	public void addDoctorAction(DropDownUtility dropDownUtils, String doctorSpecilization, Map<String, String> doctorData, String docEmail){
		dropDownUtils.handleDropDown(doctorSpecializationDropDown, doctorSpecilization );

		for(Entry<String, String> data : doctorData.entrySet() ) {
			convertToWebElement(addDoctorPartialXpath, data.getKey()).sendKeys(data.getValue());
		}
		doctorEmailTextFiled.sendKeys(docEmail);
		submitButton.click();

	}
}
