package SouthAsia;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
public class Login {
//private static AndroidDriver<MobileElement> driver;

WebDriver driver;

@Parameters({ "deviceName_","UDID_","platformVersion_", "URL_" })
@BeforeTest
public void beforeMethod(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException, InterruptedException {
//	File classpathRoot = new File(System.getProperty("user.dir"));
//	File appDir = new File(classpathRoot, "/Apps/Amazon/");
//	File app = new File(appDir, "in.amazon.mShop.android.shopping.apk");
//	DesiredCapabilities capabilities = new DesiredCapabilities();
//	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//	capabilities.setCapability("deviceName", deviceName_);
//	capabilities.setCapability("udid", UDID_);
//	capabilities.setCapability("platformVersion", platformVersion_);
//	capabilities.setCapability("platformName", "Android");
//	capabilities.setCapability("app", app.getAbsolutePath());
//	capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
//	capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
//	driver = new AndroidDriver<MobileElement>(new URL("http://"+URL_), capabilities);
//	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//	Thread.sleep(10000);
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

@Test(priority = 0)
public void mobileApp_Login() throws Exception {
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	System.out.println("started");
	Thread.sleep(15000);
	WebElement result = driver.findElement(By.className("android.widget.ImageView"));
	if (result.isDisplayed()) {
		System.out.println("EO South Asia LOGO is Displayed");
	}
	else {
		System.out.println("EO South Asia LOGO is not Available");
	}
	Thread.sleep(6000);
	driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys("jayanthra@gmail.com");
	Thread.sleep(5000);
	System.out.println("Email is Entered");
	driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("Eosouthasia@17");
	System.out.println("Password is Entered");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//android.view.View[@index='1']")).click();
	WebDriverWait wait = new WebDriverWait(driver, 60);
	WebElement pageAvail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout[@index='0']")));
	if (pageAvail.isDisplayed()){
		System.out.println("Home Page is Loading...!!!");    

	}
	else {
		//System.out.println("Home Page is keep loading");
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']")).isDisplayed(), "Home Page is keep loading");

	}
	 
}}
//
//@AfterMethod
//public void afterMethod() {
//}
//}


//
//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
//<suite name="Suite" parallel="tests" thread-count="2" >
//	<test name="Test1">
//		<parameter name="deviceName_" value="device_One"/>
//		<parameter name="UDID_" value="UDID_One"/>
//		<parameter name="platformVersion_" value="Version_One"/>
//		<parameter name="URL_" value="127.0.0.1:1234/wd/hub"/>
//		<classes>
//			<class name="appium_Package.Appium_TestNG_Sample_One"/>
//		</classes>
//	</test> <!—Test 1 -->
//	<test name="Test2">
//		<parameter name="deviceName_" value="device_Two"/>
//		<parameter name="UDID_" value="UDID_Two"/>
//		<parameter name="platformVersion_" value="Version_Two"/>
//		<parameter name="URL_" value="127.0.0.2:3456/wd/hub"/>
//		<classes>
//			<class name="appium_Package.Appium_TestNG_Sample_One"/>
//		</classes>
//	</test> <!—Test 2 -->
//</suite> <!-- Suite -->







































/*import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Login {
	//public AndroidDriver<WebElement> driver;
		WebDriver driver;
		@BeforeTest
		public void setUp() throws MalformedURLException {
			  // Created object of DesiredCapabilities class.
			  DesiredCapabilities capabilities = new DesiredCapabilities();
			  // Set android deviceName desired capability. Set your device name.
			  capabilities.setCapability("deviceName", "Custom Phone - 4.2.2 API 17 - 768*1280");
			  // Set BROWSER_NAME desired capability. It's Android in our case here.
			  capabilities.setCapability("browserName", "Android");

			  // Set android VERSION desired capability. Set your mobile device's OS version.
			  capabilities.setCapability("platformVersion", "4.2.2");

			  // Set android platformName desired capability. It's Android in our case here.
			  capabilities.setCapability("platformName", "Android");
			  // Created object of RemoteWebDriver will all set capabilities.
			  // Set appium server address and port number in URL string.
			  // It will launch calculator app in android device.
			 // capabilities.setCapability("unicodeKeyboard", true);
			 // capabilities.setCapability("resetKeyboard", true);
			  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 }
		
		
@Test
public void mobileApp_Login() throws Exception {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	System.out.println("started");
Thread.sleep(5000);
String result = driver.findElement(By.className("android.view.View")).getText();
System.out.println("Number sum result is : " + result);
Thread.sleep(10000);
driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys("jayanthra@gmail.com");
Thread.sleep(5000);
System.out.println("Email");
driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("Eosouthasia@17");
System.out.println("Eosouthasia@17");
Thread.sleep(5000);
driver.findElement(By.xpath("//android.view.View[@index='1']")).click();
driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
}
@AfterTest
public void mobileApp_Logout() throws InterruptedException
{
	Dimension size;
	 size = driver.manage().window().getSize();
	  System.out.println(size);
	  
//	  //Find swipe start and end point from screen's with and height.
////	  //Find startx point which is at right side of screen.
//	  int startx = (int) (size.width * 0.70);
////	  //Find endx point which is at left side of screen.
//	  int endx = (int) (size.width * 0.30);
////	  //Find vertical point where you wants to swipe. It is in middle of screen height.
//	  int starty = size.height / 2;
//	  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
////
////	  //Swipe from Right to Left.
//	  driver.swipe(startx, starty, endx, starty, 3000);
////	  Thread.sleep(2000);
////
//  //Swipe from Left to Right.
//	  driver.swipe(endx, starty, startx, starty, 3000);
//	  Thread.sleep(2000);
//	 size = driver.manage().window().getSize();
//	  System.out.println(size);
//	  
	  //Find swipe x points from screen's with and height.
	  //Find x1 point which is at right side of screen.
	  int x1 = (int) (size.width * 0.20);
	  //Find x2 point which is at left side of screen.
	  int x2 = (int) (size.width * 0.80);
	  
	  //Create object of TouchAction class.
  TouchAction action = new TouchAction((PerformsTouchActions) driver);
	  
	  //Find element to swipe from right to left.
//	  WebElement ele1 =  (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/front").get(3);  
	  //Create swipe action chain and perform horizontal(right to left) swipe.
	  //Here swipe to point x1 Is at left side of screen. So It will swipe element from right to left.
	  WebElement ele1=driver.findElement(By.xpath("//android.widget.ImageView[@index='1']"));
	  action.longPress(ele1).moveTo(x1,580).release().perform();
	  
	  //Find element to swipe from left to right.
//	  WebElement ele2 =  (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/back").get(3);
	  //Create swipe action chain and perform horizontal(left to right) swipe.
	  //Here swipe to point x2 Is at right side of screen. So It will swipe element from left to right.
//	  action.longPress(ele2).moveTo(x2,580).release().perform();
//	 }
WebElement settings=driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']"));
settings.click();
Thread.sleep(5000);
WebElement Logout=driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']"));
Logout.click();
Thread.sleep(5000);
WebElement Confirmation=driver.findElement(By.xpath("//android.widget.TextView[@text='Are you sure want to logout ?']"));
if(Confirmation.isDisplayed())
{
	WebElement Confirmation_yes=driver.findElement(By.xpath("android.widget.Button[@text='Yes']"));
	WebElement Confirmation_No=driver.findElement(By.xpath("android.widget.Button[@text='No']"));
	Confirmation_yes.click();
	System.out.println("Logged Out Successfully");
}



}
}*/
//-----------------------------------------------------------------------------------------------------------
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//
//public class Login {
//	//public AndroidDriver<WebElement> driver;
//	WebDriver driver;
//	@BeforeTest
//	public void setUp() throws MalformedURLException {
//		  // Created object of DesiredCapabilities class.
//		  DesiredCapabilities capabilities = new DesiredCapabilities();
//		  // Set android deviceName desired capability. Set your device name.
//		  capabilities.setCapability("deviceName", "Custom Phone - 4.2.2 API 17 - 768*1280");
//		  // Set BROWSER_NAME desired capability. It's Android in our case here.
//		  capabilities.setCapability("browserName", "Android");
//
//		  // Set android VERSION desired capability. Set your mobile device's OS version.
//		  capabilities.setCapability("platformVersion", "4.2.2");
//
//		  // Set android platformName desired capability. It's Android in our case here.
//		  capabilities.setCapability("platformName", "Android");
//		  // Created object of RemoteWebDriver will all set capabilities.
//		  // Set appium server address and port number in URL string.
//		  // It will launch calculator app in android device.
//		  capabilities.setCapability("unicodeKeyboard", true);
//		  capabilities.setCapability("resetKeyboard", true);
//		  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		 }
//	
//	
//	
//  /*public void Config() throws MalformedURLException {
//	  DesiredCapabilities capabilities=DesiredCapabilities.android();
//		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
//		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Custom Phone - 4.2.2 API 17 - 768*1280");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		capabilities.setCapability(MobileCapabilityType.VERSION, "4.2.2");
//		//capabilities.setCapability(MobileCapabilityType.APP,"E:\\Rajesh\\Appium\\EOSouthAsia-debug.apk");
//		//capabilities.setCapability("apppackage","com.showtime.eosouthasia");
//		//capabilities.setCapability("Launchactivity","com.showtime.eosouthasia.screens.RTCScreenSplash");
//		//capabilities.setCapability("deviceScreenSize","768*1280");
//		URL url=new URL("http://127.0.0.1:4723/wd/hub");
//		driver=new AndroidDriver<WebElement>(url,capabilities);
//  }*/
//@Test(priority=0)
//public void mobileApp_Login() throws Exception {
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	System.out.println("started");
//Thread.sleep(15000);
//String result = driver.findElement(By.className("android.widget.Button")).getText();
//System.out.println("Number sum result is : " + result);
//driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
//Thread.sleep(10000);
//driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys("ganeshkumar1@angleritech.com");
//Thread.sleep(7000);
//System.out.println("Email");
//driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("modern_pk123");
//System.out.println("Password");
//Thread.sleep(7000);
//driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
//
//}
//@Test(priority=1)
//public void mobileApp_ViewPage() throws Exception {
//
//Thread.sleep(10000);
//String checkTitle = driver.findElement(By.className("android.widget.TextView")).getText();
//if( checkTitle.equals("Driver") ) {
//System.out.println("Check Driver Title visible as : " + checkTitle);
//}
//else {
//	System.out.println("Check Driver Title not visible as : " + checkTitle);
//
//}
//Thread.sleep(10000);
//
//WebElement imgIcon=driver.findElement(By.className("android.widget.FrameLayout"));
//if(imgIcon.isDisplayed())
//{
//	System.out.println("imgIcon is visible");
//	Thread.sleep(10000);
//	WebElement logOutBtn=driver.findElement(By.className("android.widget.FrameLayout"));
//	if(logOutBtn.isDisplayed()){
//		System.out.println("Logout is displayed");
//		Thread.sleep(10000);
//
//	WebElement frameLayout=driver.findElement(By.className("android.support.v7.widget.RecyclerView"));
//	if(frameLayout.isDisplayed()) {
//		System.out.println("Frame Layout is displayed successfully");
//		driver.findElement(By.name("My Jobs List")).click();
//		Thread.sleep(7000);
//		WebElement jobList=driver.findElement(By.className("android.widget.TextView"));
//		if(jobList.isDisplayed()) {
//			String jobListLabel = driver.findElement(By.className("android.widget.TextView")).getText();
//			if( jobListLabel.equals("MY JOBS LIST") ) {
//				System.out.println("Check Job List Title visible as : " + jobListLabel);
//				driver.findElement(By.name("Search")).sendKeys("Hana International Fze");
//				Thread.sleep(5000);
//				driver.findElements(By.className("android.widget.FrameLayout")).get(0).click();	
//				Thread.sleep(7000);
//				String DeliveryLabel = driver.findElement(By.className("android.widget.TextView")).getText();
//				if( DeliveryLabel.equals("Delivery Confirmation") ) {
//					System.out.println("Check Delivery Title visible as : " + DeliveryLabel);
//					driver.findElements(By.className("android.widget.ImageView")).get(0).click();	
//					Thread.sleep(5000);
//					driver.findElements(By.className("android.widget.ImageView")).get(1).click();	
//					Thread.sleep(5000);
//					driver.findElements(By.className("android.widget.FrameLayout")).get(0).click();					
//					Thread.sleep(5000);
//					WebElement alertBox = driver.findElement(By.className("android.view.View"));	
//					System.out.println("Inside Alert");
//					if(alertBox.isDisplayed()){
//						System.out.println("Alert is successfully");
//						Thread.sleep(5000);
//						driver.findElement(By.name("Yes")).click();						
//					}
//					else {
//						System.out.println("Alert is not displayed");
//					}
//
//
//				System.out.println("LOGGEDOUT SUCCESSFULLY");
//					
//				}
//				else{
//					System.out.println("Check Delivery Title not visible as : " + DeliveryLabel);
//				}	
//
//				}
//				else {
//					System.out.println("Check Job List Title not visible as : " + jobListLabel);
//				}
//		}
//	}
//	else {
//		System.out.println("Frame Layout is not displayed");
//	}
//	}
//	else{
//		System.out.println("Logout button is not visible case failed");
//
//	}
//	
//}
//else {
//	System.out.println("Image button is not visible case failed");
//
//}
//
//
//Thread.sleep(5000);
//System.out.println("tested");
//}
////@Test(priority=2)
////public void mobileApp_Logout() throws Exception {
////	
////}
///*public void recharge() throws InterruptedException
//{
//	System.out.println("TEsting the build");
//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//System.out.println("TEsting the buildfvdgfdgd");
//
//driver.findElement(By.xpath("//android.widget.Button")).click();
//System.out.println("TEsting after");
//
//driver.findElement(By.xpath("//android.widget.TextView[@test='Recharge or Pay for']")).click();
//driver.findElement(By.xpath("//android.widget.TextView@text='Mobile']")).click();
//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//Thread.sleep(5000);
////WebElement two = driver.findElement(By.className("android.widget.EditText"));
////two.sendKeys("EOsouth@angler.com");
////Thread.sleep(45000);
//System.out.println("LAst test");
//WebElement three = driver.findElement(By.className("android.view.View"));
//three.click();
//driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Amount']")).sendKeys("100");
//driver.findElement(By.xpath("//android.widget.Button[@text='Proceed to Recharge']")).click();	
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//driver.findElement(By.xpath("//android.widget.EditText[@text='Email or Mobile']")).sendKeys("harirajesh22@gmail.com");
//driver.findElement(By.xpath("//android.widget.EditText[@text='Paytm Password']")).sendKeys("nokix302");	
//driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='6']")).click();
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//driver.findElement(By.xpath("//android.widget.Button[@text='Proceed to Pay ₹ 100']")).click();	
//Thread.sleep(1500);	
//}*/
////	
////@Test	
////public void login()
////{
////
////	
////	
////}
//@AfterTest
//public void quit()
//{
//driver.quit();
//}
//}
//
//package SouthAsia;
//
//import org.testng.annotations.Test;
//
//import io.appium.java_client.MobileDriver;
//import io.appium.java_client.PerformsTouchActions;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//public class EONews {
//	//public AndroidDriver<WebElement> driver;
//			WebDriver driver;
//			@BeforeTest
//			public void setUp() throws MalformedURLException {
//				  // Created object of DesiredCapabilities class.
//				  DesiredCapabilities capabilities = new DesiredCapabilities();
//				  // Set android deviceName desired capability. Set your device name.
//				  capabilities.setCapability("deviceName", "Custom Phone - 4.4.4 API 19 - 768*1280");
//				  // Set BROWSER_NAME desired capability. It's Android in our case here.
//				  capabilities.setCapability("browserName", "Android");
//
//				  // Set android VERSION desired capability. Set your mobile device's OS version.
//				  capabilities.setCapability("platformVersion", "4.4.4");
//
//				  // Set android platformName desired capability. It's Android in our case here.
//				  capabilities.setCapability("platformName", "Android");
//				  // Created object of RemoteWebDriver will all set capabilities.
//				  // Set appium server address and port number in URL string.
//				  // It will launch calculator app in android device.
//				  capabilities.setCapability("unicodeKeyboard", true);
//				  capabilities.setCapability("resetKeyboard", true);
//				  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//				  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//				 }
//			
//			@Test(priority=0)
//			public void mobileApp_Login() throws Exception {
//			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//				System.out.println("started");
//			Thread.sleep(15000);
//			WebElement result = driver.findElement(By.className("android.widget.ImageView"));
//			if (result.isDisplayed()){
//				System.out.println("EO South Asia LOGO Displayed");				
//			}
//			Thread.sleep(6000);				
//			driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys("jayanthra@gmail.com");
//			Thread.sleep(5000);
//			System.out.println("Email");
//			driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("Eosouthasia@17");
//			System.out.println("Eosouthasia@17");
//			Thread.sleep(5000);
//			driver.findElement(By.xpath("//android.view.View[@index='1']")).click();
//			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
//			}
//			@Test(priority=1)
//			public void mobileApp_EOPage() throws Exception {
//			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			    System.out.println("Inner Page");
//				Thread.sleep(5000);
//				driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
//				Thread.sleep(5000);
//				System.out.println("clicked the icon");
//			
//			}
//			@Test(priority=2)
//			public void mobileApp_News() throws Exception {
//			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			    System.out.println("News Page");
//				Thread.sleep(5000);
//				String newsValue = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).getText();
//				System.out.println("Get Activity Value is : " + newsValue);			
//				if(newsValue.equals("News")){
//					
//					driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).click();
//				    System.out.println("News Page button is clicked");
//				   // WebDriverWait wait = new WebDriverWait(driver, 60);
//					//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout")));
//					
//				    String newsTitle = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
//					System.out.println("News Title is : " + newsTitle);
//					Thread.sleep(10000);					
//					WebElement newsHeadline=driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']"));
//				    if(newsHeadline.isDisplayed()){
//				    	System.out.println("News is Displayed");
//				    	driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")).click();
//				    	Thread.sleep(5000);
//				    	WebElement imageDisplayed = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='1']"));
//				    	if(imageDisplayed.isDisplayed()) {
//				    		System.out.println("Image is Displayed in News Page");
//				    	}
//				    	else {
//				    		System.out.println("Image is Not Avail in News Page");
//				    	}
//				    	WebElement textDisplayed = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']"));
//				    	if(textDisplayed.isDisplayed()) {
//				    		System.out.println("Title is Displayed in News Page");
//				    	}
//				    	else {
//				    		System.out.println("Title is not Displayed in News Page");
//				    	}
//				    	WebElement descriptionDisplayed = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.webkit.WebView[@index='2']"));
//				    	if(descriptionDisplayed.isDisplayed()) {
//				    		System.out.println("Description is Displayed in News Page");
//				    	}
//				    	else {
//				    		System.out.println("Description is not Displayed in News Page");
//				    	}
//				    	Thread.sleep(5000);
//				    	driver.findElement(By.xpath("//android.widget.ImageButton[@index='1']")).click();
//				    	driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
//						Thread.sleep(5000);
//						System.out.println("clicked the icon");
//				    	
//				    }
//					
//					//System.out.println("element.getSize::"+element.getAttribute("index"));
//				}
//				else {
//				    System.out.println("News Page button is not clicked");
//                    
//				}
//			}
//	
//			@Test(priority=3)
//			public void mobileApp_ActivityFeeds() throws Exception {
//				
//				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			    System.out.println("Activity Page");
//				Thread.sleep(5000);
//				String activityValue = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
//				System.out.println("Get Activity Value is : " + activityValue);			
//				if(activityValue.equals("Activity Feed")){
//					driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).click();
//				    System.out.println("Activity Page button is clicked");
//				    WebElement chapterIcon=driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']"));
//				    if(chapterIcon.isDisplayed()){
//				    	 String str = driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='0']")).getAttribute("text");
//				    if (str.equalsIgnoreCase("S Asia"))
//				    {
//				        System.out.println("Checkbox selected"+str);
//				    }
//				    else {
//				    		Thread.sleep(2000);
//				    	driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='1']")).click();
//				        System.out.println("Checkbox not selected"+str);
//				        System.out.println("Radio button is clicked");			    	
//				    	
//
//				    }
//				    WebElement postBtn=driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']"));
//					    if(postBtn.isDisplayed()){
//							driver.findElement(By.xpath("// android.widget.ImageButton[@index='1']")).isDisplayed();
//							driver.findElement(By.xpath("// android.widget.ImageButton[@index='1']")).click();
//						    System.out.println("Clicked the Post Button");
//						    String postTitle = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
//							System.out.println("Get Post Title as : " + postTitle);			
//							if(postTitle.equals("Update Status")){
//								Thread.sleep(5000);	
//								driver.findElements(By.className("android.widget.MultiAutoCompleteTextView")).get(1).sendKeys("Hi How are you...!!");
//
//						
//								System.out.println("Enter the Text");
//							}
//				    
//				    
//				    }
//				    else {
//					    System.out.println("is not Clicked the Post Button");
//
//				    }
//
//				   
//				    
//				    //			    	WebDriverWait wait = new WebDriverWait(driver, 10);
////				    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='0']")));			    	
////				    	if (obje.isSelected() == true) {
////				    	System.out.println("Radio button is clicked");
////					    }
//				    
//				    }
//
//				}
//				else{
//				    System.out.println("Activity Page button is not clicked");
//
//				}
//			
//				
//			}
//			
//	
//	
//	
//}
//
//
//
//
