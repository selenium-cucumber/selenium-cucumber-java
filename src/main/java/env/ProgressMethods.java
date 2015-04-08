package env;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressMethods extends SelectElementByType implements BaseTest
{
	//SelectElementByType eleType= new SelectElementByType();
	
	public void wait(String time, String method) throws NumberFormatException, InterruptedException
	{
		//sleep method takes parameter in milliseconds
		if (method.equals("sleep"))
			Thread.sleep(Integer.parseInt(time)*1000);
		else if (method.equals("implicit"))
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//Explicitly wait for element to be displayed
	public void waitForElementToDisplay(String accessType,String accessName,String duration)
	{
		By byEle = getelementbytype(accessType, accessName);
		/*System.out.println("dura : "+duration);
		int dur = ;
		System.out.println("dura : "+dur);*/
		WebDriverWait wait = (new WebDriverWait(driver,Integer.parseInt(duration)*1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
	}
		
	//Explicitly wait for element to be enabled=click
	public void waitForElementToClick(String accessType,String accessName,String duration)
	{
		By byEle = getelementbytype(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(driver,Integer.parseInt(duration)*1000));
		wait.until(ExpectedConditions.elementToBeClickable(byEle));
	}
	
}
