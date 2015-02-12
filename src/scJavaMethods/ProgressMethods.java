package scJavaMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import features.env.CucumberRunner;

public class ProgressMethods 
{
	SelectElementByType eleType= new SelectElementByType();
	
	public void wait(String time) throws NumberFormatException, InterruptedException
	{
		Thread.sleep(Integer.parseInt(time));
	}
	
	//Explicitly wait for element to be displayed
	public void waitForElementToDisplay(String accessType,String accessName,String duration)
	{
		By byEle = eleType.getelementbytype(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(CucumberRunner.driver,Integer.parseInt(duration)));
		wait.until(ExpectedConditions.presenceOfElementLocated(byEle));
	}
		
	//Explicitly wait for element to be enabled=click
	public void waitForElementToClick(String accessType,String accessName,String duration)
	{
		By byEle = eleType.getelementbytype(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(CucumberRunner.driver,Integer.parseInt(duration)));
		wait.until(ExpectedConditions.elementToBeClickable(byEle));
	}
}
