package hms.nml.pageRepository.doctorPageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientsPage {

	@FindBy(xpath="(//i[@class='fa fa-eye'])[2]") private WebElement  viewLookupIcon;
	@FindBy(xpath="//button[text()='Add Medical History']") private WebElement addMedicalHistoryButton;
	
	public ManagePatientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to perform click action on the View icon 
	 */
	public void clickViewIcon(){
		viewLookupIcon.click();
	}
	
	/**
	 * This method is used to perform click action on the Add Medical History Button
	 */
	public void clickaddMedicalHistoryButton(){
		addMedicalHistoryButton.click();
	}
}
