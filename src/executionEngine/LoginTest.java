package executionEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModules.LoginAction.TEST_RESULT;
import utility.ExcelUtils;
import config.Constants;

public class LoginTest extends appConfig {
	@Test(priority = 2)
	@Parameters({ "username", "password" })
	public void mobileApp_Login(String username, String password)throws Exception {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		TEST_RESULT result = appModules.LoginAction.ValidLogin(driver, username, password);
		System.out.println("Result of Blank username is"+result);
	}

	@Test(priority = 0)
	public void mobileApp_BlankPassword() throws Exception {
		driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		ExcelUtils.setExcelFile(Constants.Path_TestData+ Constants.File_TestData, Constants.File_LoginTestsheet_name);
		int rowNum = ExcelUtils.getRowCount(Constants.File_LoginTestsheet_name);
		System.out.println(rowNum);
			String username = ExcelUtils.getCellData(1, 0);
			String errAlert = ExcelUtils.getCellData(1, 2);
			TEST_RESULT result = appModules.LoginAction.blankPassword(driver, username, errAlert);
			System.out.println("Result of Blank username is"+result);
	}

	@Test(priority = 1)
	public void mobileApp_BlankUserName() throws Exception {
		driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		ExcelUtils.setExcelFile(Constants.Path_TestData+ Constants.File_TestData, Constants.File_LoginTestsheet_name);
		int rowNum = ExcelUtils.getRowCount(Constants.File_LoginTestsheet_name);
			System.out.println(rowNum);
			String password = ExcelUtils.getCellData(2, 1);
			String errAlert = ExcelUtils.getCellData(2, 2);
			System.out.println("Result of Blank Error Alert is"+errAlert);
			System.out.println("Result of Blank Password is"+password);
			TEST_RESULT result = appModules.LoginAction.blankUserName(driver, password, errAlert);
			System.out.println("Result of Blank username is"+result);

	}
}
