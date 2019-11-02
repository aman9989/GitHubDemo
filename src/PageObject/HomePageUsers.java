package PageObject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import Utility.CommonFunctionality;

public class HomePageUsers extends CommonFunctionality{

	public static Properties prop;
	public HomePageUsers(WebDriver driver) {
		super(driver);
	}
	
	public void clickAddUserBtn() throws IOException {
		prop = setPropertyFilePath("testData.properties");
		actionPerform(prop.getProperty("adminId"));
		actionPerform(prop.getProperty("userManagementId"));
		sendClickBtn(prop.getProperty("usersId"));
		sendClickBtn(prop.getProperty("addUserBtnId"));
	}
	
	public void addUser() throws IOException {
		prop = setPropertyFilePath("testData.properties");
		selectData(prop.getProperty("userRole"));
		sendData(prop.getProperty("employeeName"));
		sendData(prop.getProperty("userName"));
		sendData(prop.getProperty("password"));
		sendData(prop.getProperty("confirmPassword"));
		sendClickBtn(prop.getProperty("saveUser"));
	}
}
