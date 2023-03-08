package hms.nml.pageRepository.doctorPageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.nml.genericLibrary.enums.TabNames;

public class DoctorCommonPage {
	private WebDriver driver;

	private String tabPartialXpath="//span[contains(text(),'%s')]";
	
	@FindBy(xpath="//span[@class='username']") private WebElement doctorDropDown;
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
	
	public DoctorCommonPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform click action on the tab
	 * @param tabName
	 */
	public void clickTab(TabNames tabName) {
		convertToWebElement(tabPartialXpath, tabName.getTabNames()).click();
	}
	/**
	 * This method is used to perform click action on the Profile
	 */
	public void clickMyProfileAction() {
		doctorDropDown.click();
		myProfileOption.click();
	}
	/**
	 * This method is used to perform click action on the Logout
	 */
	public void clickLogoutAction() {
		doctorDropDown.click();
		logoutOption.click();
	}
	/**
	 * This method is used to perform click action on the Change Password 
	 */
	public void clickChangePswdAction() {
		doctorDropDown.click();
		changePwdOption.click();
	}
}

