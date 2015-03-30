package features.step_definitions;

import scJavaMethods.*;
import cucumber.api.java.en.Then;
import features.env.CucumberRunner;

public class StepDefinitions
{
	private MiscMethods miscmethod;
	private NavigateMethods navmethod = null;
	private AssertionMethods assertmethod = null;
	private ClickElementsMethods clickmethod=null;
	private ConfigurationMethods confgmethod=null;
	private InputMethods inputmethod=null;
	private ProgressMethods progressmethod=null;
	private JavascriptHandlingMethods  javascriptmethod = null;
	
	public StepDefinitions()
	{
		System.out.println("In constructor");
		miscmethod = new MiscMethods();
		assertmethod = new AssertionMethods();
		clickmethod = new ClickElementsMethods();
		confgmethod = new ConfigurationMethods();
		inputmethod = new InputMethods();
		progressmethod = new ProgressMethods();
		javascriptmethod = new JavascriptHandlingMethods();
		navmethod = new NavigateMethods();
	}
	
									//Assertion steps
	// page title checking
	@Then("^I should\\s*((?:not)?)\\s+see page title as \"(.*?)\"$")
	public void check_title(String present,String title) throws TestCaseFailed
	{
		System.out.println("Present :" + present.isEmpty());
		assertmethod.checkTitle(title,present.isEmpty());
	}
	
	// step to check element partial text
	@Then("^I should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
	public void check_partial_text(String present, String partialTextTitle) throws TestCaseFailed
	{
		System.out.println("Present :" + present.isEmpty());
		assertmethod.checkPartialTitle(partialTextTitle, present.isEmpty());
	}
	
	// step to check element text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String type, String accessName,String present,String value) throws Exception 
	{
		miscmethod.validateLocator(type);
		assertmethod.checkElementText(type, value, accessName,present.isEmpty());
	}	
	
	//step to check element partial text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
	public void check_element_partial_text(String type,String accessName,String present,String value) throws Exception
	{
		miscmethod.validateLocator(type);
		assertmethod.checkElementPartialText(type, value, accessName, present.isEmpty());
	}
	  	
	// step to check attribute value
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$") 
	public void check_element_attribute(String type,String accessName,String present,String attrb,String value) throws Exception
	{
		miscmethod.validateLocator(type);
		assertmethod.checkElementAttribute(type, attrb, value, accessName, present.isEmpty());
	}
	 
	// step to check element enabled or not
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
	public void check_element_enable(String type, String accessName,String present,String state) throws Exception
	{
		miscmethod.validateLocator(type);
		boolean flag = state.equals("enabled");
		if(!present.isEmpty())
		{
			flag = !flag;
		}
		assertmethod.checkElementEnable(type, accessName, flag);
	}
	
	//step to check element present or not
	@Then("^element having (.+) \"(.*?)\" should\\s*((?:not)?)\\s+be present$") 
	public void check_element_presence(String type,String accessName,String present) throws Exception
	{
		miscmethod.validateLocator(type);
		assertmethod.checkElementPresence(type, accessName, present.isEmpty());
	}
	
	//step to assert checkbox is checked or unchecked
	@Then("^checkbox having (.+) \"(.*?)\" should be (checked|unchecked)$")
	public void is_checkbox_checked(String type, String accessName,String state) throws Exception
	{
		miscmethod.validateLocator(type);
		boolean flag = state.equals("checked");
		assertmethod.isCheckboxChecked(type, accessName, flag);
	}
	  
	//steps to assert radio button checked or unchecked
	@Then("^radio button having (.+) \"(.*?)\" should be (selected|unselected)$") 
	public void is_radio_button_selected(String type,String accessName,String state) throws Exception
	{
		miscmethod.validateLocator(type);
		boolean flag = state.equals("selected");
		assertmethod.isRadioButtonSelected(type, accessName, flag);
	}
	 
	//steps to assert option by text from radio button group selected/unselected
	@Then("^option \"(.*?)\" by (.+) from radio button group having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_radio_button_group_selected(String option,String attrb,String type,String accessName,String state) throws Exception
	{
		miscmethod.validateLocator(type);
		boolean flag = state.equals("selected");
		assertmethod.isOptionFromRadioButtonGroupSelected(type,attrb,option,accessName,flag);
	}
	
	//steps to check link presence
	@Then("^link having text \"(.*?)\" should\\s*((?:not)?)\\s+be present$") 
	public void check_element_presence(String accessName,String present) throws TestCaseFailed, Exception
	{
		assertmethod.checkElementPresence("linkText",accessName,present.isEmpty());
	}
	  
	//steps to check partail link presence
	@Then("^link having partial text \"(.*?)\" should\\s*((?:not)?)\\s+be present$") 
	public void check_partial_element_presence(String accessName,String present) throws TestCaseFailed, Exception
	{
		assertmethod.checkElementPresence("partialLinkText", accessName, present.isEmpty());
	}
	
	//step to assert javascript pop-up alert text
	@Then("^I should see alert text as \"(.*?)\"$") 
	public void check_alert_text(String actualValue) throws TestCaseFailed
	{
		assertmethod.checkAlertText(actualValue);
	}
	  
	// step to assert dropdown list
	@Then("^option \"(.*?)\" by (.+) from dropdown having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_dropdown_selected(String option,String by,String type,String accessName,String state) throws Exception
	{
		miscmethod.validateLocator(type);
		boolean flag = state.equals("selected");
		assertmethod.isOptionFromDropdownSelected(type,by,option,accessName,flag);
		//ruby : is_option_from_dropdown_selected(type, by, option, access_name, state)
	}
	
				//Click element Steps 
	
	// click on web element
	@Then("^I click on element having (.+) \"(.*?)\"$") 
	public void click(String type,String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		clickmethod.click(type, accessName);
	}
	  
	//Forcefully click on element
	@Then("^I forcefully click on element having (.+) \"(.*?)\"$")
	public void click_forcefully(String type,String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		clickmethod.clickForcefully(type,accessName);
	}
	  
	// double click on web element
	@Then("^I double click on element having (.+) \"(.*?)\"$") 
	public void double_click(String type, String accessValue) throws Exception
	{
		miscmethod.validateLocator(type);
		clickmethod.doubleClick(type, accessValue);
	}
	
	// steps to click on link
	@Then("^I click on link having text \"(.*?)\"$")
	public void click_link(String accessName)
	{
		clickmethod.click("linkText", accessName);
	}
	
	//Step to click on partial link
	@Then("^I click on link having partial text \"(.*?)\"$")
	public void click_partial_link(String accessName)
	{
		clickmethod.click("partialLinkText", accessName);
	}
	
				//Configuration steps
	// step to print configuration
	@Then("^I print configuration$") 
	public void print_config()
	{
		confgmethod.printConfiguration();
	}
	  
				//Input steps
	// enter text into input field steps
	@Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void enter_text(String text, String type,String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		inputmethod.enterText(type, text, accessName);
	}
	
	// clear input field steps
	@Then("^I clear input field having (.+) \"([^\"]*)\"$") 
	public void clear_text(String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		inputmethod.clearText(type, accessName);
	}
	  
	// select option by text/value from dropdown/multiselect
	@Then("^I select \"(.*?)\" option by (.+) from\\s*((?:multiselect)?)\\sdropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown(String option,String optionBy, String present,String type,String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		miscmethod.validateOptionBy(optionBy);
		inputmethod.selectOptionFromDropdown(type, optionBy, option, accessName);
	}
	
	// select option by index from dropdown/multiselect
	@Then("^I select (\\d+) option by index from\\s*((?:multiselect)?)\\sdropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown(String option, String present, String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		inputmethod.selectOptionFromDropdown(type,"selectByIndex", option, accessName);
	}
	
	// step to select option from mutliselect dropdown list
	@Then("^I select all options from multiselect dropdown having (.+) \"(.*?)\"$")
	public void select_all_option_from_multiselect_dropdown(String type,String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		//inputmethod.
		//select_all_option_from_multiselect_dropdown(type, access_name)
	}
	
	// step to unselect option from mutliselect dropdown list
	@Then("^I unselect all options from multiselect dropdown having (.+) \"(.*?)\"$")
	public void unselect_all_option_from_multiselect_dropdown(String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		inputmethod.unselectAllOptionFromMultiselectDropdown(type, accessName);
	}
	
	//check checkbox steps
	@Then("^I check the checkbox having (.+) \"(.*?)\"$") 
	public void check_checkbox(String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		inputmethod.checkCheckbox(type, accessName);
	}
	  
	
				//Progress methods
	// wait for specific period of time
	@Then("^I wait for (\\d+) sec$")
	public void wait(String time) throws NumberFormatException, InterruptedException
	{
		progressmethod.wait(time);
	}
	
	//wait for specific element to display for specific period of time
	@Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to display$")
	public void wait_for_ele_to_display(String duration, String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		progressmethod.waitForElementToDisplay(type, accessName, duration);
	}
	  
	// wait for specific element to enable for specific period of time
	@Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to click$")
	public void wait_for_ele_to_click(String duration, String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		progressmethod.waitForElementToClick(type, accessName, duration);
	}
	  
					//JavaScript handling steps
	//Step to handle java script
	@Then("^I accept alert$")
	public void handle_alert()
	{
		javascriptmethod.handleAlert("accept");
	}
	
	//Steps to dismiss java script
	@Then("^I dismiss alert$")
	public void dismiss_alert()
	{
		javascriptmethod.handleAlert("dismiss");
	}
	
							//Navigation Steps
	//Step to navigate to specified URL
	@Then("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link)
	{
		navmethod.navigateTo(link);
	}
	
	//Step to navigate forward
	@Then("^I navigate forward")
	public void navigate_forward()
	{
		navmethod.navigate("forward");
	}
	
	//Step to navigate backward
	@Then("^I navigate back")
	public void navigate_back()
	{
		navmethod.navigate("back");
	}
		  
	//Step to close the browser
	@Then("^I close browser$")
	public void close_browser()
	{
		navmethod.closeDriver();
	}
	
	// step to resize browser
	@Then("^I resize browser window size to width (\\d+) and height (\\d+)$")
	public void resize_browser(int width, int heigth)
	{
		navmethod.resizeBrowser(width, heigth);
	}
	
	// step to maximize browser
	@Then("^I maximize browser window$")
	public void maximize_browser()
	{
		navmethod.maximizeBrowser();
	}
	 
	// steps to refresh page
	@Then("^I refresh page$")
	public void refresh_page()
	{
		CucumberRunner.driver.navigate().refresh();
	}
	
	//Switch to new window
	@Then("^I switch to new window$")
	public void switch_to_new_window()
	{
		navmethod.switchToNewWindow();
	}
	 
	//Switch to old window
	@Then("^I switch to previous window$")
	public void switch_to_old_window()
	{
		navmethod.switchToOldWindow();
	}
	
	//Close new window
	@Then("^I close new window$")
	public void close_new_window()
	{
		navmethod.closeNewWindow();
	}
	
	//steps to scroll to element
	@Then("^I scroll to element having (.+) \"(.*?)\"$")
	public void scroll_to_element(String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		navmethod.scrollToElement(type, accessName);
	}
	
	// steps to scroll web page to top or end
	@Then("^I scroll to (top|end) of page$")
	public void scroll_page(String to) throws Exception
	{
		navmethod.scrollPage(to);
	}
	
	// step to hover over a element       Note: Doesn't work on Windows firefox
	@Then("^I hover over element having (.+) \"(.*?)\"$")
	public void hover_over_element(String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		navmethod.hoverOverElement(type, accessName);
	}
	
	// steps to zoom in page
	@Then("^I zoom in page$") 
	public void zoom_in()
	{
		navmethod.zoomInOut("add");
	}
	
	// steps to zoom out page
	@Then("^I zoom out page$")
	public void zoom_out()
	{
		navmethod.zoomInOut("substract");
	}
	
	// steps to zoom out till element displays
	@Then("^I zoom out page till I see element having (.+) \"(.*?)\"$")
	public void zoom_till_element_display(String type, String accessName) throws Exception
	{
		miscmethod.validateLocator(type);
		navmethod.zoomInOutTillElementDisplay(type,"substract", accessName);
	}
	
	//Reset browser to default zoom
	@Then("^I reset page view$")
	public void reset_page_zoom()
	{
		navmethod.zoomInOut("numpad0");
	}
	
	
}

