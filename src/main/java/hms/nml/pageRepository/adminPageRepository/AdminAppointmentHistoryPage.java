package hms.nml.pageRepository.adminPageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class AdminAppointmentHistoryPage {
	private WebDriver driver;

	String appointmentStatusPartialXpath="//td[text()='%s']/following-sibling::td[5]";
	
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	public AdminAppointmentHistoryPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to get the appointment status text
	 * @param userName
	 * @return
	 */
	public String getAppointmentStatusAction(String userName) {
		return convertToWebElement(appointmentStatusPartialXpath, userName).getText();
	}
}

