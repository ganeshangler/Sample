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
	String errAlert;

	@Test(priority = 2)
	@Parameters({ "username", "password" })
	public void mobileApp_Login(String username, String password)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		appModules.LoginAction.ValidLogin(driver, username, password);
		TEST_RESULT result = appModules.LoginAction.ValidLogin(driver, username, errAlert);
		System.out.println("Result of Blank username is"+result);
	}

	@Test(priority = 0)
	public void mobileApp_BlankPassword() throws Exception {
		driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		ExcelUtils.setExcelFile(Constants.Path_TestData+ Constants.File_TestData, Constants.File_LoginTestsheet_name);
		int rowNum = ExcelUtils.getRowCount(Constants.File_LoginTestsheet_name);
		System.out.println(rowNum);
		for (int i = 1; i < rowNum; i++) {
			String username = ExcelUtils.getCellData(i, 0);
			errAlert = ExcelUtils.getCellData(i, 2);
			appModules.LoginAction.blankPassword(driver, username, errAlert);
			TEST_RESULT result = appModules.LoginAction.blankPassword(driver, username, errAlert);
			System.out.println("Result of Blank username is"+result);
		}

	}

	@Test(priority = 1)
	public void mobileApp_BlankUserName() throws Exception {
		driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		ExcelUtils.setExcelFile(Constants.Path_TestData+ Constants.File_TestData, Constants.File_LoginTestsheet_name);
		int rowNum = ExcelUtils.getRowCount(Constants.File_LoginTestsheet_name);
		System.out.println(rowNum);
		for (int i = 3; i < rowNum; i++) {
			String password = ExcelUtils.getCellData(i, 1);
			errAlert = ExcelUtils.getCellData(i, 2);
			TEST_RESULT result = appModules.LoginAction.blankUserName(driver, password, errAlert);
			System.out.println("Result of Blank username is"+result);
		}

	}
}
