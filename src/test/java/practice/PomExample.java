package practice;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.hms.nml.genericLibrary.enums.ExcelSheet;
import com.hms.nml.genericLibrary.externalResource.ExcelUtilities;
import com.hms.nml.genericLibrary.miscellaneous.FrameworkConstants;
import com.hms.nml.genericLibrary.seleniumUtilities.WaitsUtility;
import com.hms.nml.genericLibrary.seleniumUtilities.WebDriverUtilities;


public class PomExample {
	public static void main(String[] args) {
		ExcelUtilities excelUtilits = new ExcelUtilities(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		
		String sheetName = ExcelSheet.USER.getSheetName();
		String expTestScriptName = "PomExample";
		Map<String, String> map = excelUtilits.getData(expTestScriptName, sheetName);
		
		
		WebDriverUtilities webDriverUtils= new WebDriverUtilities();
		WebDriver driver = webDriverUtils.launchBrowser("chrome");
		webDriverUtils.maximizeBrowser();
		WaitsUtility waitUtils = new WaitsUtility(driver);
		waitUtils.waitForPageLoad(10);
		webDriverUtils.getUrl("https://www.opencart.com/index.php?route=account/register");
		
		PomExamplePage pg= new PomExamplePage(driver);
		 pg.setDataIntoTextField(map,PomExEnum.valueOf(sheetName));
		
		
}
}
