package TestNgClasses;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import Utility.CommonFunctionality;

public class BaseTestNgPage  {
	public static WebDriver driver;
	String driverPath;
	String browser;
	String appURL;
	CommonFunctionality obj;
	public Properties prop;
	 

	
	@BeforeSuite
	public void launchBrowser() throws IOException
	{
		//To get the property
		//browser =  
		//appURL = prop.getProperty("appURL");
				
	    prop = CommonFunctionality.setPropertyFilePath("config.properties");
		browser = prop.getProperty("browser");
		appURL = prop.getProperty("appURL");
		
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driverPath = System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("Firefox")) {
			driverPath = System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		}else {
			System.out.println("Plese provide correct browser name in the argument");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appURL);
		obj = new CommonFunctionality(driver);
	}
	
}
