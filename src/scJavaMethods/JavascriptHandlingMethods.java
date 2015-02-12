package scJavaMethods;

import features.env.CucumberRunner;

public class JavascriptHandlingMethods 
{
	public void handleAlert(String decision)
	{
		if(decision.equals("accept"))
			CucumberRunner.driver.switchTo().alert().accept();
		else
			CucumberRunner.driver.switchTo().alert().dismiss();
	}
}
