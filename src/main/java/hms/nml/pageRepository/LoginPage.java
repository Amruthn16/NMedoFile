package hms.nml.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Declaration
	@FindBy(name= "username") private WebElement userNameTxtField;
	@FindBy(name= "password") private WebElement passwordTxtField;
	@FindBy(name= "submit") private WebElement loginButton;
	@FindBy(xpath= "//a[contains(text(),'Forgot Password ?')]") private WebElement forgotPasswordLink;
	@FindBy(xpath= "//a[contains(text(),'Create an account')]") private WebElement createAnAccountLink;
	@FindBy(xpath= "//span[text()='Invalid username or password']") private WebElement invalidLoginText;
	
	//Intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	//Utilization ---> Bussiness Logic
	/**
	 * This method is used to perform Login action on LoginPage
	 * @param username
	 * @param password
	 */
	public void loginAction(String username, String password) {
		userNameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginButton.click();
	}

	/**
	 * This method is to click on the Forgot Password Link
	 */
	public void ClickForgotPswdLinkAction() {
		forgotPasswordLink.click();;
	}

	/**
	 * This method is to click on the Create Account Link
	 */
	public void clickCreateAccountLinkAction() {
		createAnAccountLink.click();
	}
	/**
	 * This method is to get the warning text
	 * @return
	 */
	public String getWarningMessage() {
		return invalidLoginText.getText();
	}

}


