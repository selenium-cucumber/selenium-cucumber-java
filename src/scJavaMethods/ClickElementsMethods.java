package scJavaMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import features.env.CucumberRunner;

public class ClickElementsMethods 
{
	SelectElementByType eleType= new SelectElementByType();
	WebElement element=null;
	
	public void click(String accessType, String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		element.click();
	}
	
	public void clickForcefully(String accessType, String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		JavascriptExecutor executor = (JavascriptExecutor)CucumberRunner.driver;
		executor.executeScript("arguments[0].click();",element);
	}
	
	public void doubleClick(String accessType, String accessValue)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessValue)));

		Actions action = new Actions(CucumberRunner.driver);
		action.moveToElement(element).doubleClick().perform();
	}
	
	//This method is not used in click steps
	public void submit(String access_type, String access_name)
	{
		CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name)).submit();
	}
}