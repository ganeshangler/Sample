package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Constants;
import utility.RepositoryParser;

public class homePage {
	public static RepositoryParser parser=new RepositoryParser();
	private static WebElement element = null;

	public static WebElement HandBurgerMenu (WebDriver driver) throws Exception
	{
		parser.RepositoryParser(Constants.path_ObjectRepo);
    	element = driver.findElement(parser.getLocator("Home_HBurgerMenu"));
    	return element;
	}
}