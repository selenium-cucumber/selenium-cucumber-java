package sc_java_methods;

import org.openqa.selenium.By;
import features.env.CucumberRunner;

public class SeleniumCucJava 
{
	public void navigatetogmailmain() throws Throwable 
	{
		System.out.println("Go to gmail");
		CucumberRunner.driver.get("http://www.gmail.com");
	}
	
	public void clickSignInmain() throws Throwable {
		CucumberRunner.driver.findElement(By.id("signIn")).click();
		Thread.sleep(1000);
	}
	
	public void I_enter_credentials_and_click_on_enter_buttonmain() throws Throwable {
	    CucumberRunner.driver.findElement(By.id("Email")).sendKeys("testinghangloose1@gmail.com");
	    CucumberRunner.driver.findElement(By.id("Passwd")).sendKeys("goodsamaritan");
	}
}
