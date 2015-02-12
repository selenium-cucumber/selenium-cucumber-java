package scJavaMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import features.env.CucumberRunner;

public class ClickElementsMethods 
{
	SelectElementByType eletype= new SelectElementByType();
	
	public void click(String access_type, String access_name)
	{
		CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name)).click();
	}
	
	public void click_forcefully(String access_type, String access_name)
	{
		JavascriptExecutor executor = (JavascriptExecutor)CucumberRunner.driver;
		executor.executeScript("arguments[0].click();",CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name)));
	}
	
	public void double_click(String access_type, String access_value)
	{
		Actions action = new Actions(CucumberRunner.driver);
		WebElement element=CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_value));
		
		action.moveToElement(element).doubleClick().perform();
	}
	
	public void submit(String access_type, String access_name)
	{
		CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name)).submit();
	}
}