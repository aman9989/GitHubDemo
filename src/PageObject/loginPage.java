package PageObject;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import Utility.CommonFunctionality;

public class loginPage extends CommonFunctionality{

	public static Properties prop;
	public loginPage(WebDriver driver) {
		super(driver);
	}

	public void chkLoginWithValid() throws IOException {
		prop = setPropertyFilePath("testData.properties");
		String eleEmail = prop.getProperty("loginUsername");
		sendData(eleEmail);
		String elePass = prop.getProperty("loginPassword");
		sendData(elePass);
		String eleClickBtn = prop.getProperty("loginClickButton");
		sendClickBtn(eleClickBtn);
		
	}
}
