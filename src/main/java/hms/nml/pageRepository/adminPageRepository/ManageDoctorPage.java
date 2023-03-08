package hms.nml.pageRepository.adminPageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.nml.genericLibrary.seleniumUtilities.DropDownUtility;


public class ManageDoctorPage {

private WebDriver driver;
	
	private String deleteDocPartialXpath="//td[text()='%s']/following-sibling::td[2]//i[@class='fa fa-times fa fa-white']";
	
	@FindBy(xpath="(//i[@class='fa fa-pencil'])[last()]") private WebElement editDoctor;
	@FindBy(name="Doctorspecialization") WebElement doctorSpecilization;
	@FindBy(name="submit") private WebElement submitButton;
	@FindBy(tagName ="p") private WebElement docDeletedWarningMessage;

	/**
	 * This method is used to convert the parial xpath into web element
	 * @param deleteDocPartialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String PartialXpath, String replaceData) {
		String xpath= String.format(PartialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public ManageDoctorPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform click action on specified doctor
	 * @param docName
	 */
	public void clickDoctorToDelete(String docName) {
		convertToWebElement(deleteDocPartialXpath,  docName).click();
	}
	
	/**
	 * This method is used to edit the doctor
	 * @param dropDownUtils
	 * @param newDoctorSpecilization
	 */
	public void editDoctorAction(DropDownUtility dropDownUtils, String newDoctorSpecilization) {
		editDoctor.click();
		dropDownUtils.handleDropDown(doctorSpecilization, newDoctorSpecilization);
		submitButton.click();
	}
	
	/**
	 * This method is used to get the warning text 
	 * @return
	 */
	public String getWarningText() {
		return docDeletedWarningMessage.getText();
	}

	
	
}
