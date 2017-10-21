/*
 * This is Login Action Block
 * 
 * The methods inside this class are executed before test.
 * 
 */
package appModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import pageObjects.homePage;
import pageObjects.loginPage;

public class LoginAction {
	public enum TEST_RESULT 
	{
		RESULT_SUCCESS
		{
			@Override
			public String toString()
			{
				return "Success";
			}
		},	
		RESULT_FAILURE
		{
			@Override
			public String toString()
			{
				return "Failure";
			}
		},
		RESULT_ERROR
		{
			@Override
			public String toString()
			{
				return "Error";
			}
		}, 
	}

	public static TEST_RESULT ValidLogin(WebDriver driver, String username,String password) throws Exception {
		loginPage.userName(driver).clear();
		loginPage.password(driver).clear();
		loginPage.userName(driver).sendKeys(username);
		loginPage.password(driver).sendKeys(password);
		loginPage.SignIn(driver).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		if (homePage.HandBurgerMenu(driver).isDisplayed()){
			return TEST_RESULT.RESULT_SUCCESS;
		}
		else if (!homePage.HandBurgerMenu(driver).isDisplayed()){
			return TEST_RESULT.RESULT_FAILURE;
		}
		else{
			return TEST_RESULT.RESULT_ERROR;
		}

	}

	public static TEST_RESULT ValidUser(WebDriver driver, String username,String password) throws Exception {
		loginPage.userName(driver).clear();
		loginPage.password(driver).clear();
		loginPage.userName(driver).sendKeys(username);
		loginPage.SignIn(driver).click();
		Thread.sleep(15000);
		if (homePage.HandBurgerMenu(driver).isDisplayed()){
			return TEST_RESULT.RESULT_FAILURE;
		}
		else if (!homePage.HandBurgerMenu(driver).isDisplayed()){
			return TEST_RESULT.RESULT_SUCCESS;
		}
		else{
			return TEST_RESULT.RESULT_ERROR;
		}

	}

	public static TEST_RESULT blankUserName(WebDriver driver, String password,String errAlert) throws Exception {
		loginPage.userName(driver).clear();
		loginPage.password(driver).clear();
		loginPage.password(driver).sendKeys(password);
		loginPage.SignIn(driver).click();
		String Actual_Alert = loginPage.Password_Err_Msg(driver).getText();
		System.out.println(Actual_Alert);
		if (Actual_Alert.equals(errAlert)){
			return TEST_RESULT.RESULT_SUCCESS;
			
		}
		else if(!(Actual_Alert.equals(errAlert))){
			return TEST_RESULT.RESULT_FAILURE;
			}
			else{
				return TEST_RESULT.RESULT_ERROR;
			}

	}

	public static TEST_RESULT blankPassword(WebDriver driver, String username,String errAlert) throws Exception {
		
		loginPage.userName(driver).sendKeys(username);
		loginPage.SignIn(driver).click();
		String Actual_Alert = loginPage.Password_Err_Msg(driver).getText();
		System.out.println(Actual_Alert);
		if (Actual_Alert.equals(errAlert)){
			System.out.println("errAlert"+errAlert);
			return TEST_RESULT.RESULT_SUCCESS;
			
		}
		else if(!(Actual_Alert.equals(errAlert))){
		return TEST_RESULT.RESULT_FAILURE;
		}
		else{
			return TEST_RESULT.RESULT_ERROR;
		}
	}

	public static void blankCredentials(WebDriver driver) throws Exception {
		loginPage.SignIn(driver).click();
		

	}

	public static void ValidPass(WebDriver driver,String password) throws Exception {
		loginPage.password(driver).sendKeys(password);
		loginPage.SignIn(driver).click();

	}
}
