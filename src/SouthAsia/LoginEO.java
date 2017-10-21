package SouthAsia;



import io.appium.java_client.MobileDriver;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginEO {
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
		
		@Test(priority=0)
		public void mobileApp_Login() throws Exception {
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			System.out.println("started");
		Thread.sleep(15000);
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
		@Test(priority=1)
		public void mobileApp_EOPage() throws Exception {
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    System.out.println("Inner Page");
			Thread.sleep(5000);
			driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
			Thread.sleep(5000);
			System.out.println("clicked the icon");
		
		}
		@Test(priority=2)
		public void mobileApp_ActivityFeed() throws Exception {
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    System.out.println("Activity Page");
			Thread.sleep(5000);
			String activityValue = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
			System.out.println("Get Activity Value is : " + activityValue);			
			if(activityValue.equals("Activity Feed")){
				driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).click();
			    System.out.println("Activity Page button is clicked");
			    WebElement chapterIcon=driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']"));
			    if(chapterIcon.isDisplayed()){
			    	 String str = driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='0']")).getAttribute("text");
			    if (str.equalsIgnoreCase("S Asia"))
			    {
			        System.out.println("Checkbox selected"+str);
			    }
			    else {
			    		Thread.sleep(2000);
			    	driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='1']")).click();
			        System.out.println("Checkbox not selected"+str);
			        System.out.println("Radio button is clicked");			    	
			    	

			    }
			    WebElement postBtn=driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']"));
				    if(postBtn.isDisplayed()){
						driver.findElement(By.xpath("// android.widget.ImageButton[@index='1']")).isDisplayed();
						driver.findElement(By.xpath("// android.widget.ImageButton[@index='1']")).click();
					    System.out.println("Clicked the Post Button");
					    String postTitle = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
						System.out.println("Get Post Title as : " + postTitle);			
						if(postTitle.equals("Update Status")){
							driver.findElement(By.xpath("//android.widget.MultiAutoCompleteTextView[@index='1']")).sendKeys("Hi How are you...!!");
						}
			    
			    
			    }
			    else {
				    System.out.println("is not Clicked the Post Button");

			    }

			   
			    
			    //			    	WebDriverWait wait = new WebDriverWait(driver, 10);
//			    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='0']")));			    	
//			    	if (obje.isSelected() == true) {
//			    	System.out.println("Radio button is clicked");
//				    }
			    
			    }

			}
			else{
			    System.out.println("Activity Page button is not clicked");

			}
		
		
		
		}
}
		