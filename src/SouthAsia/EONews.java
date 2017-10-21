package SouthAsia;

import org.testng.Assert;
import org.testng.annotations.Test;
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
import config.Constants;
import utility.ExcelUtils;
public class EONews {
	//public AndroidDriver<WebElement> driver;
	WebDriver driver;
	String username,password;
	@BeforeTest
	public void setUp() throws MalformedURLException {
		// Created object of DesiredCapabilities class.
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}	

	
	@Test(priority = 0)
	public void mobileApp_Login() throws Exception {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		System.out.println("started");
		Thread.sleep(15000);
//		WebElement result = driver.findElement(By.className("android.widget.ImageView"));
//		if (result.isDisplayed()) {
//			System.out.println("EO South Asia LOGO is Displayed");
//		}
//		else {
//			System.out.println("EO South Asia LOGO is not Available");
//		}
//		Thread.sleep(6000);
		ExcelUtils.setExcelFile(Constants.Path_TestData+Constants.File_TestData, Constants.File_LoginTestsheet_name);
		  int rowNum=ExcelUtils.getRowCount(Constants.File_LoginTestsheet_name);
		  System.out.println(rowNum);
		  for(int i=1;i<rowNum;i++)
		  {
		  username=ExcelUtils.getCellData(i, 0);
		  password=ExcelUtils.getCellData(i, 1);
		  System.out.println("Username Values are looking"+username);
		  System.out.println("Password Values are looking"+password);
		  }
//		driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys("jayanthra@gmail.com");
//		Thread.sleep(5000);
//		System.out.println("Email is Entered");
//		driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("Eosouthasia@17");
//		System.out.println("Password is Entered");
		  driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys(username);
			Thread.sleep(5000);
			System.out.println("Email is Entered");
			driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys(password);
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
		 
	}
	@Test(priority = 1)
	public void mobileApp_EOPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		System.out.println("Home page is Displayed");
		Thread.sleep(5000);
		driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
		Thread.sleep(5000);
		System.out.println("clicked the Burger Menu in app");    
	}
	@Test(priority = 3)
	public void mobileApp_News() throws Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("News Page");
		Thread.sleep(5000);
//		String activityValue1 = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).getText();
//		System.out.println("Get Activity Value is : " + activityValue1);
//		if (activityValue1.equals("News")) {
//			driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).click();
//		driver.findElement(By.xpath("test+@index='5']+test")).click();

//		}
//		else{
//			System.out.println("no news is : ");
//
//		}
		driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
		Thread.sleep(5000);
		System.out.println("clicked the Burger Menu in app");  
		Thread.sleep(5000);
		String newsValue = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).getText();
		System.out.println("Get News Value is : " + newsValue);
		if (newsValue.equals("News")) {
			driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).click();
			System.out.println("News Page button is tapped");
			// WebDriverWait wait = new WebDriverWait(driver, 60);
			//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout")));

			String newsTitle = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
			System.out.println("News Title is : " + newsTitle);
			Thread.sleep(10000);
			WebElement newsHeadline = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']"));
			if (newsHeadline.isDisplayed()) {
				System.out.println("News is Displayed");
				driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")).click();
				Thread.sleep(5000);
				WebElement imageDisplayed = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='1']"));
				if (imageDisplayed.isDisplayed()) {
					System.out.println("Image is Displayed in News Page");
				}
				else {
					System.out.println("Image is Not Avail in News Page");
				}
				WebElement textDisplayed = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']"));
				if (textDisplayed.isDisplayed()) {
					System.out.println("Title is Displayed in News Page");
				}
				else {
					System.out.println("Title is not Displayed in News Page");
				}
				WebElement descriptionDisplayed = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.webkit.WebView[@index='2']"));
				if (descriptionDisplayed.isDisplayed()) {
					System.out.println("Description is Displayed in News Page");
				}
				else {
					System.out.println("Description is not Displayed in News Page");
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("//android.widget.ImageButton[@index='1']")).click();
                Thread.sleep(5000);
				WebElement logOut = driver.findElement(By.xpath("//*/android.widget.RelativeLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageButton[@index='0']"));
				if(logOut.isDisplayed()){
					
					driver.findElement(By.xpath("//*/android.widget.RelativeLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageButton[@index='0']")).click();
					System.out.println("Logout Button");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.Button[@index='0']")).click();

				}
				
				//				driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
//				Thread.sleep(5000);
//				System.out.println("clicked the icon");

			}

			//System.out.println("element.getSize::"+element.getAttribute("index"));
		}
		else {
			System.out.println("News Page button is not clicked");

		}
	}
//@Test(priority = 4)
//public void mobileApp_Logout() throws Exception 
//{
//	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
//	System.out.println("Click to View Logout ");
//	Thread.sleep(5000);
//	driver.findElement(By.xpath("//android.widget.RelativeLayout[2]/android.widget.ImageButton[0]")).click();
//	Thread.sleep(5000);
//	String logOutValue = driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).getText();
//	
//	System.out.println("Get Settings Value is : " + logOutValue);
//	driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='0']")).click();
//	Thread.sleep(8000);
//	System.out.println("Logout Successfully");
//}

	@Test(priority = 2)
	public void mobileApp_ActivityFeeds() throws Exception {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Click to View Activity Page");
		Thread.sleep(5000);
		String activityValue = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
		System.out.println("Get Activity Value is : " + activityValue);
		if (activityValue.equals("Activity Feed")) {
			driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).click();
			System.out.println("Activity Page button is tabbed");
			WebElement chapterIcon = driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']"));
			if (chapterIcon.isDisplayed()) {
				String str = driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='0']")).getAttribute("text");
				if (str.equalsIgnoreCase("S Asia")) {
					System.out.println("Checkbox selected" + str);
				}
				else {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='1']")).click();
					System.out.println("Checkbox not selected" + str);
					System.out.println("Radio button in the activity feed page is tabbed");


				}
				WebElement postBtn = driver.findElement(By.xpath("//android.widget.RadioGroup[@index='0']"));
				if (postBtn.isDisplayed()) {
					driver.findElement(By.xpath("// android.widget.ImageButton[@index='1']")).isDisplayed();
					driver.findElement(By.xpath("// android.widget.ImageButton[@index='1']")).click();
					System.out.println("Clicked the Post Button");
					String postTitle = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).getText();
					System.out.println("Get Post Title as : " + postTitle);
					if (postTitle.equals("Update Status")) {
						Thread.sleep(5000);
						System.out.println("Displayed Post Comment Page");
						String userName = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index ='0']/android.widget.LinearLayout[@index ='1']/android.widget.TextView[@index='0']")).getText();
						System.out.println("User Name in Post page as : " + userName);


						//WebElement txtFeed =  driver.findElement(By.className("android.widget.EditText"));
						WebElement test = driver.findElement(By.xpath("//android.widget.MultiAutoCompleteTextView[1]"));
						System.out.println("Enter the Text"+test);
						String descpName = "Hi Hello Everyone";
						//if(txtFeed.isDisplayed()){
						
						if(test.isDisplayed()){
							System.out.println("Enter the Value in Post Comment");
							test.sendKeys(descpName);
							//txtFeed.sendKeys(descpName);
							Thread.sleep(2000);
							//driver.findElement(By.xpath("//android.widget.RelativeLayout[1]/android.widget.ImageView[0]")).click();
							//Thread.sleep(2000);
							driver.findElement(By.xpath("//android.widget.TextView[2]")).click();
							Thread.sleep(7000);
							String userNameActivity = driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']//*/android.widget.TextView[@index='0']")).getText();
							System.out.println("Get User Name Activity as : " + userNameActivity);
							if (userNameActivity.equalsIgnoreCase(userName)){
								String postDesc = driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")).getText();
								System.out.println("Actual Get Post Title as : " + postDesc);
								if (postDesc.equalsIgnoreCase(descpName)) {
									System.out.println("Expected Get Post Title as : " + postDesc);
									
									
									driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']//*/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")).click(); 
									String commentTitle =driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='0']")).getText(); 
									if (commentTitle.equals("Comments")){
										WebElement typeCmt = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']/android.widget.MultiAutoCompleteTextView[@index='0']")); 
										typeCmt.click();
										String cmtText ="Hi Hello Guys";
										typeCmt.sendKeys(cmtText);
										Thread.sleep(5000);
										driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).click();
										
										String commentPosted =driver.findElement(By.xpath("//*/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).getText(); 
										if (commentPosted.equals(cmtText)){
											System.out.println("Comment posted successfully " );
											driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.ImageButton[@index='1']")).click();

										}
										else {
											System.out.println("Comment posted Failed to compare " );
										}
									driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']//*/android.widget.ImageView[@index='1']")).click(); 
									Thread.sleep(5000);
									driver.findElement(By.xpath("//android.widget.GridView[@index='1']/android.widget.LinearLayout[@index='1']")).click(); 
									System.out.println("Post Cancel working");
									driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']//*/android.widget.ImageView[@index='1']")).click(); 
									Thread.sleep(3000);
									driver.findElement(By.xpath("//android.widget.GridView[@index='1']/android.widget.LinearLayout[@index='0']")).click();                     	 
									driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
									Thread.sleep(5000);
									driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).click();
									Thread.sleep(5000);
									System.out.println("Post Deleted Successfully");
									Thread.sleep(5000);
									
									}//if for comment check

								}
								else {
									System.out.println("Get Post Title in Activity is wrong as : " + postDesc);
								}
							}
							else {
								System.out.println("Get User Name in Activity is wrong as : " + userNameActivity);
							}
						}


						 else {
						driver.findElement(By.xpath("//android.widget.LinearLayout")).click();
						 Thread.sleep(2000);
						driver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']")).click();
						 Thread.sleep(2000);
						 System.out.println("First Image is selected");
						 driver.findElement(By.xpath("//android.widget.FrameLayout[@index='2']")).click();
					     Thread.sleep(2000);
						System.out.println("Second Image is selected");
						WebElement done_btn=driver.findElement(By.xpath("//android.widget.Button[@index='2']"));
						if(done_btn.isDisplayed())
						{
						System.out.println("Done btn is displayed");                
						done_btn.click();
						Thread.sleep(2000);
						}                        
						}


						//           String test = driver.findElement(By.xpath("//android.widget.MultiAutoCompleteTextView[1]")).getText();
						//           System.out.println("Enter the Text"+test);
						//            String stre =  driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.RelativeLayout[0]/android.widget.LinearLayout[0]/android.widget.LinearLayout[0]/android.widget.MultiAutoCompleteTextView[1]")).getAttribute("text");
						//           if (stre.equalsIgnoreCase("What's on your mind?")){
						//        	   System.out.println("TRUE345");
						//           }
						//           else {
						//        	   System.out.println("FAILED INSPECTed");
						//           }

						//driver.findElement(By.xpath("//android.widget.MultiAutoCompleteTextView[1]")).sendKeys("Hi Good Morning");

						//           if (test.isDisplayed()){ 
						//        	   System.out.println("Enter the Text");
						//           test.sendKeys("Hi How are you...!!");
						//           }
						//           else {
						//        	   System.out.println("Not Enter the Text");   
						//           }


						System.out.println("Completed the Scenarios");
					}
				}
				else {
					System.out.println("is not Clicked the Post Button");
				}
				//			    	WebDriverWait wait = new WebDriverWait(driver, 10);
				//				    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RadioGroup[@index='0']/android.widget.RadioButton[@index='0']")));			    	
				//				    	if (obje.isSelected() == true) {
				//				    	System.out.println("Radio button is clicked");
				//					    }

			}
		}
		else {
			System.out.println("Activity Page button is not clicked");

		}
	}
}