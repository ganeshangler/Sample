package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Constants;
import utility.RepositoryParser;

public class loginPage {
	public static RepositoryParser parser=new RepositoryParser();
	private static WebElement element = null;

	public static WebElement userName (WebDriver driver) throws Exception
	{
		parser.RepositoryParser(Constants.path_ObjectRepo);
    	element = driver.findElement(parser.getLocator("LoginPage_Username_Txt"));
    	return element;
	}
	public static WebElement password (WebDriver driver) throws Exception
	{
		parser.RepositoryParser(Constants.path_ObjectRepo);
    	element = driver.findElement(parser.getLocator("LoginPage_Password_Txt"));
    	return element;
	}
	public static WebElement SignIn (WebDriver driver) throws Exception
	{
		parser.RepositoryParser(Constants.path_ObjectRepo);
    	element = driver.findElement(parser.getLocator("LoginPage_Login_Btn"));
    	return element;
	}
	public static WebElement Password_Err_Msg (WebDriver driver) throws Exception
	{
		parser.RepositoryParser(Constants.path_ObjectRepo);
    	element = driver.findElement(parser.getLocator("LoginPage_Pass_Alrt"));
    	return element;
	}
	
}
