package hms.nml.pageRepository.patientPageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.nml.genericLibrary.miscellaneous.JavaUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.DropDownUtility;

public class BookAppointmentPage {

	@FindBy(name="Doctorspecialization") private WebElement doctorSpecializationDropDown;
	@FindBy(id="doctor") private WebElement doctorDropDown;
	@FindBy(name="appdate") private WebElement dateTextField;
	@FindBy(id="timepicker1") private WebElement timeTextField;
	@FindBy(xpath="//input[@class='bootstrap-timepicker-hour form-control']") private WebElement hourTextField;
	@FindBy(xpath="//input[@class='bootstrap-timepicker-minute form-control']") private WebElement minuteTextField;
	@FindBy(xpath="//input[@class='bootstrap-timepicker-meridian form-control']") private WebElement meridianTextField;
	@FindBy(name="submit") private WebElement submitButton;

	public BookAppointmentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform Book the appointment action on Book Appointment Page
	 * @param javaUtils
	 * @param dropdownUtils
	 * @param doctorSpecilization
	 * @param doctorName
	 * @param hour
	 * @param minute
	 * @param meridian
	 * @throws InterruptedException
	 */
	public void bookAppointmentAction(JavaUtility javaUtils, DropDownUtility dropDownUtils,String doctorSpecilization, String doctorName, String hour, String minute, String meridian)  {
		dropDownUtils.handleDropDown( doctorSpecializationDropDown,doctorSpecilization);
		dropDownUtils.handleDropDown(doctorName, doctorDropDown);
		String date = javaUtils.getCurrentDateTime("yyyy-mm-dd");
		dateTextField.sendKeys(date);
		timeTextField.click();
		timeTextField.clear();
		hourTextField.clear();
		hourTextField.sendKeys(hour);
		minuteTextField.clear();
		minuteTextField.sendKeys(minute);
		meridianTextField.clear();
		meridianTextField.sendKeys(meridian);
		submitButton.click();
	}
}
