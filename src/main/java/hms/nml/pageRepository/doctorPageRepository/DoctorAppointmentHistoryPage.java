package hms.nml.pageRepository.doctorPageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.nml.genericLibrary.miscellaneous.JavaScriptUtilites;


public class DoctorAppointmentHistoryPage {
	private WebDriver driver;

	private String userAppointmentPartialXpath="//td[contains(text(),'%s')]";
	private String userAppointmentCancelPartialXpath="(//td[text()='%s']/parent::tr/child::td//a)[last()]";
	@FindBy(xpath="(//a[text()='Cancel'])[last()]") private WebElement userAppointmentCancelBtn;
	@FindBy(tagName ="p") private WebElement appointmentCancelledMessage;


	/**
	 * This method is used to convert the parial xpath into web element
	 * @param userAppointmentPartialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String userAppointmentPartialXpath, String replaceData) {
		String xpath= String.format(userAppointmentPartialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public DoctorAppointmentHistoryPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to get the text (user name) on appointment history page
	 * @param userName
	 * @return
	 */
	public String getUserAppointment(String userName) {
		return convertToWebElement(userAppointmentPartialXpath, userName).getText();
	}
	 
	public void cancelUserAppointmentAction(String userName, JavaScriptUtilites javaScriptUtils) {
		javaScriptUtils.scrollDown();
		convertToWebElement(userAppointmentCancelPartialXpath, userName).click();
	}
	public void cancelUserAppointmentAction(JavaScriptUtilites javaScriptUtils) {
		javaScriptUtils.scrollToElement(userAppointmentCancelBtn);
		userAppointmentCancelBtn.click();
	}
	
	public String getAppointmentCancelledText() {
		return appointmentCancelledMessage.getText();
	}
}
