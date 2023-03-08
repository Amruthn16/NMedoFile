package hms.nml.pageRepository.adminPageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.nml.genericLibrary.enums.TabNames;

public class AdminCommonPage {
	private WebDriver driver;

	private String tabPartialXpath="//span[contains(text(),'%s')]";
	
	@FindBy(xpath="//span[@class='username']") private WebElement adminDropDown;
	@FindBy(xpath="//a[contains(text(),'My Profile')]") private WebElement myProfileOption;
	@FindBy(xpath="//a[contains(text(),'Change Password')]") private WebElement changePwdOption;
	@FindBy(xpath="//a[contains(text(),'Log Out')]") private WebElement logoutOption;
	
	/**
	 * This method is used to convert the parial xpath into web element
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public AdminCommonPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform click action on tab
	 * @param tabName
	 */
	public void clickTab(TabNames tabName) {
		convertToWebElement(tabPartialXpath, tabName.getTabNames()).click();
	}
	
	
	/**
	 * This method is used to perform click action on my profile option
	 */
	public void clickMyProfileAction() {
		adminDropDown.click();
		myProfileOption.click();
	}
	
	/**
	 * This method is used to perform click action on logout option
	 */
	public void clickLogoutAction() {
		adminDropDown.click();
		logoutOption.click();
	}
	
	/**
	 * This method is used to perform click action on change password option
	 */
	public void clickChangePswdAction() {
		adminDropDown.click();
		changePwdOption.click();
	}

}
