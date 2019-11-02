package TestNgClasses;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.HomePageUsers;
import PageObject.LogoutPage;
import PageObject.loginPage;
import Utility.CommonFunctionality;

public class LoginTestCase extends BaseTestNgPage{
	
	static String actualURL;
	static String actualPanelText;
	static Properties prop;
	static SoftAssert sa = new SoftAssert();
	
	loginPage lp = new loginPage(driver);
	LogoutPage logpage = new LogoutPage(driver);
	HomePageUsers hpu = new HomePageUsers(driver);
	
	@Test
	public void verifyLogin() throws IOException {
		lp.chkLoginWithValid();
		prop = CommonFunctionality.setPropertyFilePath("testData.properties");
		actualURL = prop.getProperty("loginActualURL");
		sa.assertEquals(actualURL, driver.getCurrentUrl());
		sa.assertAll();
	}
	
	//Try to change Username, Password and Confirm password from 'TestData.properties' file each time you run this code
	@Test(dependsOnMethods="verifyLogin")
	public void addUser() throws IOException, InterruptedException {
		hpu.clickAddUserBtn();
		hpu.addUser();
		Thread.sleep(5000);
	}
	
	@Test(dependsOnMethods="addUser")
	public void logout() throws IOException {
		logpage.logoutFunc();
		prop = CommonFunctionality.setPropertyFilePath("testData.properties");
		actualPanelText = obj.getData(prop.getProperty("logoutPanelId"));
		sa.assertEquals(prop.getProperty("logoutPanelText"), actualPanelText);
		sa.assertAll();
	}
	
}
