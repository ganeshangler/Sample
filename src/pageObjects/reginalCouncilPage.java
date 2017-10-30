package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.RepositoryParser;
import config.Constants;

public class reginalCouncilPage {
	public static RepositoryParser parser=new RepositoryParser();
	private static WebElement element = null;

	public static WebElement logOut_Btn (WebDriver driver) throws Exception
	{
		parser.RepositoryParser(Constants.path_ObjectRepo);
    	element = driver.findElement(parser.getLocator("RC_settings_LogOut"));
    	return element;
	}
	public static WebElement settings_Icn (WebDriver driver) throws Exception
	{
		parser.RepositoryParser(Constants.path_ObjectRepo);
    	element = driver.findElement(parser.getLocator("RC_settings_Icn"));
    	return element;
	}

}
