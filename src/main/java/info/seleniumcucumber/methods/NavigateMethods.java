package info.seleniumcucumber.methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class NavigateMethods extends SelectElementByType implements BaseTest
{
	//SelectElementByType eleType= new SelectElementByType();
	private WebElement element=null;
	private String old_win = null;
	private String lastWinHandle;
	
	/** Method to open link
	 * @param url : String : URL for navigation
	 */
	public void navigateTo(String url) 
	{
		driver.get(url);
	}
	
	/** Method to navigate back & forward
	 * @param direction : String : Navigate to forward or backward
	 */
	public void navigate(String direction)
	{
		if (direction.equals("back"))
			driver.navigate().back();
		else
			driver.navigate().forward();
	}
	
	/** Method to quite webdriver instance */
	public void closeDriver()
	{
		driver.close();
	}
	
	/** Method to return key by OS wise
	 * @return Keys : Return control or command key as per OS
	 */
	public Keys getKey()
	{
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("win"))
			return Keys.CONTROL;
		else if (os.contains("nux") || os.contains("nix"))
			return Keys.CONTROL;
		else if (os.contains("mac"))
			return Keys.COMMAND;
		else
			return null;
	}
	
	/** Method to zoom in/out page
	 * @param inOut : String : Zoom in or out
	 */
	public void zoomInOut(String inOut)
	{
		WebElement Sel= driver.findElement(getelementbytype("tagName","html"));
		if(inOut.equals("ADD"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.ADD));
		else if(inOut.equals("SUBTRACT"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.SUBTRACT));
		else if(inOut.equals("reset"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.NUMPAD0));
	}
	
	/** Method to zoom in/out web page until web element displays
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param inOut : String : Zoom in or out
	 * @param accessName : String : Locator value
	 */
	public void zoomInOutTillElementDisplay(String accessType,String inOut,String accessName)
	{
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		while(true)
		{
			if (element.isDisplayed())
				break;
			else
				action.keyDown(getKey()).sendKeys(inOut).keyUp(getKey()).perform();
		}
	}
	
	/** Method to resize browser
	 * @param width : int : Width for browser resize
	 * @param height : int : Height for browser resize
	 */
	public void resizeBrowser(int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width,height));
	}
	
	/** Method to maximize browser	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	/** Method to hover on element
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param accessName : String : Locator value
	 */
	public void hoverOverElement(String accessType, String accessName)
	{
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		action.moveToElement(element).perform();
	}
	
	/** Method to scroll page to particular element
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param accessName : String : Locator value
	 */
	public void scrollToElement(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/** Method to scroll page to top or end
	 * @param to : String : Scroll page to Top or End
	 * @throws Exception
	 */
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
	
	/**Method to switch to new window */
    public void switchToNewWindow()
    {
    	old_win = driver.getWindowHandle();
    	for(String winHandle : driver.getWindowHandles())
    		lastWinHandle = winHandle;
    	driver.switchTo().window(lastWinHandle);
    }
    
    /** Method to switch to old window */
    public void switchToOldWindow()
    {
    	driver.switchTo().window(old_win);
    }
    
    /** Method to switch to window by title
     * @param windowTitle : String : Name of window title to switch
     * @throws Exception */
    public void switchToWindowByTitle(String windowTitle) throws Exception
    {
    	//System.out.println("++"+windowTitle+"++");
    	old_win = driver.getWindowHandle();
    	boolean winFound = false;
    	for(String winHandle : driver.getWindowHandles())
    	{
    		String str = driver.switchTo().window(winHandle).getTitle();
    		//System.out.println("**"+str+"**");
    		if (str.equals(windowTitle))
    		{
    			winFound = true;
    			break;
    		}
    	}
    	if (!winFound)
    		throw new Exception("Window having title "+windowTitle+" not found");
    }

    /**Method to close new window*/
    public void closeNewWindow()
    {
    	driver.close();
    }
    
    /** Method to switch frame using web element frame
     * @param accessType : String : Locator type (index, id, name, class, xpath, css)
	 * @param accessName : String : Locator value
     * */
    public void switchFrame(String accessType, String accessName)
    {
    	if(accessType.equalsIgnoreCase("index"))
    		driver.switchTo().frame(accessName);
    	else
    	{
    		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    		driver.switchTo().frame(element);
    	}
    }
    
    /** method to switch to default content*/
    public void switchToDefaultContent()
    {
    	driver.switchTo().defaultContent();
    }
}
