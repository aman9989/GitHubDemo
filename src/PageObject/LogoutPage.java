package PageObject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Utility.CommonFunctionality;

public class LogoutPage extends CommonFunctionality{

	public static Properties prop;
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	public void logoutFunc() throws IOException {
		prop= setPropertyFilePath("testData.properties");
		sendClickBtn(prop.getProperty("logoutArrowId"));
		sendClickBtn(prop.getProperty("logout"));
	}
}
