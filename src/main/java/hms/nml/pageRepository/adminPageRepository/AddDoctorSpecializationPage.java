package hms.nml.pageRepository.adminPageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecializationPage {

	@FindBy(name="doctorspecilization") WebElement doctorSpecilization;
	@FindBy(name="submit") private WebElement submitButton;

	public AddDoctorSpecializationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to add the doctor specialization on the add doctor specialization page
	 * @param docSpecilization
	 */
	public void addDoctorSpecializationAction(String docSpecilization){
		doctorSpecilization.sendKeys(docSpecilization);
		submitButton.click();
	}

}
