package hms.nml.pageRepository.patientPageRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	private WebDriver driver;

	private String registerUserPartialXpath="//*[@name='%s']";

	@FindBy(name="full_name") private WebElement fullNameTxtField;
	@FindBy(name="address") private WebElement addressTxtField;
	@FindBy(name="city") private WebElement cityTxtField;
	@FindBy(xpath="//label[contains(text(),'Male')]") private WebElement maleRadioBtn;
	@FindBy(name="email") private WebElement emailTxtField;
	@FindBy(name="password") private WebElement passwordTxtField;
	@FindBy(name="password_again") private WebElement passwordAgainTxtField;
	@FindBy(id="submit") private WebElement submitButton;
	@FindBy(xpath="//label[@for='agree']") private WebElement iAgreeCheckBox;
	@FindBy(xpath="//a[contains(text(),'Log-in')]") private WebElement loginLink;
	
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to register the user account on Registration Page
	 * @param fullName
	 * @param address
	 * @param city
	 * @param email
	 * @param password
	 */

	public void userRegisteringAccountAction(Map<String, String> userData, String userEmail){
		for(Entry<String, String> data : userData.entrySet() ) {
			convertToWebElement(registerUserPartialXpath, data.getKey()).sendKeys(data.getValue());
		}
		emailTxtField.sendKeys(userEmail);
		maleRadioBtn.click();
		submitButton.click();
	}

	
	/**
	 * This method is used to perform click action on Login Link
	 */
	public void clickLoginLinkAction() {
		loginLink.click();
	}
	
	}
