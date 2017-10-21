package executionEngine;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class appConfig {
protected WebDriver driver;
//@Parameters({ "deviceName_","UDID_","platformVersion_", "URL_" })
@BeforeClass
public void beforeMethod() throws MalformedURLException, InterruptedException {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	// Set android deviceName desired capability. Set your device name.
	capabilities.setCapability("deviceName", "Custom Phone - 4.4.4 API 19 - 768*1280");
	// Set BROWSER_NAME desired capability. It's Android in our case here.
	capabilities.setCapability("browserName", "Android");

	// Set android VERSION desired capability. Set your mobile device's OS version.
	capabilities.setCapability("platformVersion", "4.4.4");

	// Set android platformName desired capability. It's Android in our case here.
	capabilities.setCapability("platformName", "Android");
	// Created object of RemoteWebDriver will all set capabilities.
	// Set appium server address and port number in URL string.
	// It will launch calculator app in android device.
	capabilities.setCapability("unicodeKeyboard", true);
	capabilities.setCapability("resetKeyboard", true);
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}
@Parameters({"username","password"})
public void mobileApp_Login(String username, String password) throws Exception  {
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	appModules.LoginAction.ValidLogin(driver, username, password);
}
}
