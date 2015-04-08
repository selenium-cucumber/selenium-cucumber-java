package env;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateMethods extends SelectElementByType implements BaseTest
{
	//SelectElementByType eleType= new SelectElementByType();
	WebElement element=null;
	String old_win = null;
	
	// method to open link
	public void navigateTo(String url) 
	{
		driver.get(url);
	}
	
	//method to navigate back & forward
	public void navigate(String direction)
	{
		if (direction.equals("back"))
			driver.navigate().back();
		else
			driver.navigate().forward();
	}
	
	// method to quite webdriver instance
	public void closeDriver()
	{
		driver.quit();
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
	public void zoomInOut(String inOut)
	{
		WebElement Sel= driver.findElement(getelementbytype("tagName","html"));
		if(inOut.equals("ADD"))
			Sel.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
		else if(inOut.equals("SUBTRACT"))
			Sel.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		else if(inOut.equals("reset"))
			Sel.sendKeys(Keys.chord(Keys.CONTROL, Keys.NUMPAD0));
	}
	
	// Method to zoom in/out web page until web element displays
	public void zoomInOutTillElementDisplay(String accessType,String inOut,String accessName)
	{
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		while(true)
		{
			if (element.isDisplayed())
				break;
			else
				action.keyDown(get_key()).sendKeys(inOut).keyUp(get_key()).perform();
		}
	}
	
	// Method to resize browser
	public void resizeBrowser(int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width,height));
	  //$driver.manage.window.resize_to(width, height)
	}
	
	// Method to maximize browser
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	// Method to hover on element
	public void hoverOverElement(String accessType, String accessName)
	{
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		
		action.moveToElement(element).perform();
	}
	
	// Method to scroll page to particular element
	public void scrollToElement(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	
	// Method to scroll page to top or end
	public void scrollPage(String to) throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		if (to.equals("end"))
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
            executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}
	
	//Method to switch to new window
    public void switchToNewWindow()
    {
    	String old_win = driver.getWindowHandle();
    	driver.switchTo().window("newwindow");
    }
			  /*$old_win = $driver.window_handle
			  $driver.switch_to.window($driver.window_handles[1])
			end*/
    
    // Method to switch to old window
    public void switchToOldWindow()
    {
    	driver.switchTo().window(old_win);
    }

    //Method to close new window
    public void closeNewWindow()
    {
    	driver.close();
    }
}
