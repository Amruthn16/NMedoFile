package hms.nml.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HospitalManagementSystemPage {

	//Declaration
	@FindBy(xpath="//parent::li[@class='active']/child::a") 
	private WebElement homeButton;
	@FindBy(xpath="//parent::li[@class='active']/following-sibling::li/child::a") 
	private WebElement contactButton;
	@FindBy(xpath="//h3[text()='Patients']/parent::div/child::div//a") 
	private WebElement patientsClickHereLink;
	@FindBy(xpath="//h3[text()='Doctors Login']/parent::div/child::div//a") 
	private WebElement doctorClickHereLink;
	@FindBy(xpath="//h3[text()='Admin Login']/parent::div/child::div//a") 
	private WebElement adminClickHereLink;
	@FindBy(xpath="//div[@class='footer-left']//a[text()='Home']") 
	private WebElement homeLink;
	@FindBy(xpath="//div[@class=\"footer-left\"]//a[text()='contact']") 
	private WebElement contactLink;
	
	//Intialization
	public HospitalManagementSystemPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}


	//Utilization ---> Bussiness Logic
	/**
	 * This method is used to perform click action on Patients Click Here Link
	 */
	public void patientLoginClickAction() {
		patientsClickHereLink.click();
	}

	/**
	 * This method is used to perform click action on Doctor Click Here Link
	 */
	public void doctorLoginClickAction() {
		doctorClickHereLink.click();
	}

	/**
	 * This method is used to perform click action on Admin Click Here Link
	 */
	public void adminLoginClickAction() {
		adminClickHereLink.click();
	}
}