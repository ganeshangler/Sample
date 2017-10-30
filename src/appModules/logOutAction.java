package appModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.reginalCouncilPage;
import appModules.LoginAction.TEST_RESULT;

public class logOutAction {
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

	public static TEST_RESULT logOut(WebDriver driver) throws Exception {
		homePage.HandBurgerMenu(driver).click();
		Thread.sleep(3000);
		homePage.HBMenu_RegCouncil(driver).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		Thread.sleep(3000);
		reginalCouncilPage.settings_Icn(driver).click();
		Thread.sleep(3000);
		reginalCouncilPage.logOut_Btn(driver).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		if (loginPage.userName(driver).isDisplayed()){
			return TEST_RESULT.RESULT_SUCCESS;
		}
		else if (!homePage.HandBurgerMenu(driver).isDisplayed()){
			return TEST_RESULT.RESULT_FAILURE;
		}
		else{
			return TEST_RESULT.RESULT_ERROR;
		}
	}
}
