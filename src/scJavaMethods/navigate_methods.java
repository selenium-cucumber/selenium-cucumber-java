package sc_java_methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import features.env.CucumberRunner;

public class navigate_methods 
{
	SelectElementByType eletype= new SelectElementByType();
	WebElement element=null;
	String old_win = null;
	
	// method to open link
	public void navigate_to(String url) 
	{
		CucumberRunner.driver.get(url);
	}
	
	//method to navigate back & forward
	public void navigate(String direction)
	{
		if (direction.equals("back"))
			CucumberRunner.driver.navigate().back();
		else
			CucumberRunner.driver.navigate().forward();
	}
	
	// method to quite webdriver instance
	public void close_driver()
	{
		CucumberRunner.driver.quit();
	}
	
	// method to return key by os wise
	public Keys get_key()
	{
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("win"))
			return Keys.CONTROL;
		/*else if (os.contains("nux") || os.contains("nix"))
			return "Linux";*/
		else if (os.contains("mac"))
			return Keys.COMMAND;
		else
			return null;
			  /*os = Selenium::WebDriver::Platform.os
			  if os.to_s == 'windows'
			    return 'control'
			  elsif os.to_s == 'macosx'
			    return 'command'
			  else
			    raise 'Invalid OS'
			  end*/
	}
	
	// Method to zoom in/out page
	public void zoom_in_out(String in_out)
	{
		Actions action = new Actions(CucumberRunner.driver);
		action.keyDown(get_key()).sendKeys(in_out).keyUp(get_key()).perform();
		
		/*Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();*/
		
	  //$driver.action.key_down(:"#{get_key}").send_keys(:"#{in_out}").key_up(:"#{get_key}").perform
	}
	
	// Method to zoom in/out web page until web element displays
	public void zoom_in_out_till_element_display(String access_type,String in_out,String access_name)
	{
		Actions action = new Actions(CucumberRunner.driver);
		while(true)
		{
			if (CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name)).isDisplayed())
				break;
			else
				action.keyDown(get_key()).sendKeys(in_out).keyUp(get_key()).perform();
		}
	  /*while true
	    if WAIT.until { $driver.find_element(:"#{access_type}" => "#{access_name}") }.displayed?
	      break
	    else
	      $driver.action.key_down(:"#{get_key}").send_keys(:"#{in_out}").key_up(:"#{get_key}").perform
	    end
	  end*/
	}
	
	// Method to resize browser
	public void resize_browser(int width, int height)
	{
		CucumberRunner.driver.manage().window().setSize(new Dimension(width,height));
	  //$driver.manage.window.resize_to(width, height)
	}
	
	// Method to maximize browser
	public void maximize_browser()
	{
		CucumberRunner.driver.manage().window().maximize();
	}
	
	// Method to hover on element
	public void hover_over_element(String access_type, String access_name)
	{
		Actions action = new Actions(CucumberRunner.driver);
		element = CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name));
		
		action.moveToElement(element).perform();
	}
	
	// Method to scroll page to particular element
	public void scroll_to_element(String access_type, String access_name)
	{
		element = CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name));
	//	((JavascriptExecutor)CucumberRunner.driver).
		
		JavascriptExecutor executor = (JavascriptExecutor)CucumberRunner.driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
		
	  //ele_scroll.location_once_scrolled_into_view
	}
	
	// Method to scroll page to top or end
	public void scroll_page(String to)
	{
		JavascriptExecutor executor = (JavascriptExecutor)CucumberRunner.driver;
		if (to.equals("end"))
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
            executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
	    /*else
	       raise "Exception : Invalid Direction (only scroll \"top\" or \"end\")"*/
	}
	
	//Method to switch to new window
    public void switch_to_new_window()
    {
    	String old_win = CucumberRunner.driver.getWindowHandle();
    //	CucumberRunner.driver.switchTo().window(CucumberRunner.driver.WindowHandles[1]);
    }
			  /*$old_win = $driver.window_handle
			  $driver.switch_to.window($driver.window_handles[1])
			end*/
}
