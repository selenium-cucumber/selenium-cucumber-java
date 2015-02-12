package features.step_definitions;

import scJavaMethods.AssertionMethods;
import scJavaMethods.MiscMethods;
import scJavaMethods.NavigateMethods;
import scJavaMethods.TestCaseFailed;
import cucumber.api.java.en.Then;

public class StepDefinitions
{
	private MiscMethods miscmethods = new MiscMethods();
	private NavigateMethods navmethod = new NavigateMethods();
	private AssertionMethods assertmethod = new AssertionMethods();
	
	public StepDefinitions()
	{
		System.out.println("In constructor");
		assertmethod = new AssertionMethods();
	}
	
									//Assertion steps
	// page title checking
	@Then("^I should\\s*((?:not)?)\\s+see page title as \"(.*?)\"$")
	public void check_title(String present,String title) throws TestCaseFailed
	{
		assertmethod.checkTitle(title,present.isEmpty());
	}
	
	// step to check element text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String type, String accessName,String present,String value) throws Exception 
	{
		miscmethods.validateLocator(type);
		assertmethod.checkElementText(type, value, accessName,present.isEmpty());
	}	
	
	//step to check element partial text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
	public void check_element_partial_text(String type,String accessName,String present,String value) throws Exception
	{
		miscmethods.validateLocator(type);
		assertmethod.checkElementPartialText(type, value, accessName, present.isEmpty());
	}
	  	
	// step to check attribute value
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$") 
	public void check_element_attribute(String type,String accessName,String present,String attrb,String value) throws Exception
	{
		miscmethods.validateLocator(type);
		assertmethod.checkElementAttribute(type, attrb, value, accessName, present.isEmpty());
	}
	 
	// step to check element enabled or not
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
	public void check_element_enable(String type, String accessName,String present,String state) throws Exception
	{
		miscmethods.validateLocator(type);
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
		miscmethods.validateLocator(type);
		assertmethod.checkElementPresence(type, accessName, present.isEmpty());
	}
	
	//step to assert checkbox is checked or unchecked
	@Then("^checkbox having (.+) \"(.*?)\" should be (checked|unchecked)$")
	public void is_checkbox_checked(String type, String accessName,String state) throws Exception
	{
		miscmethods.validateLocator(type);
		boolean flag = state.equals("checked");
		assertmethod.isCheckboxChecked(type, accessName, flag);
	}
	  
	//steps to assert radio button checked or unchecked
	@Then("^radio button having (.+) \"(.*?)\" should be (selected|unselected)$") 
	public void is_radio_button_selected(String type,String accessName,String state) throws Exception
	{
		miscmethods.validateLocator(type);
		boolean flag = state.equals("selected");
		assertmethod.isRadioButtonSelected(type, accessName, flag);
	}
	 
	//steps to assert option by text from radio button group selected/unselected
	@Then("^option \"(.*?)\" by (.+) from radio button group having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_radio_button_group_selected(String option,String attrb,String type,String accessName,String state) throws Exception
	{
		miscmethods.validateLocator(type);
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
	  
					//Navigation Steps
	//Step to navigate to specified URL
	@Then("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link)
	{
		navmethod.navigate_to(link);
	}
	
	/*@Then("^I navigate to \"([^\"]*)\"$")
	public void navigate_to_0(String url) throws Throwable 
	{
		//navmethod.navigate_to(url);
	}

	@Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void I_enter_into_input_field_having_id(String text,String access_type, String access_name) throws Throwable 
	{
	    inputmethods.enter_text(access_type, text, access_name);
	}
	
	@Then("^I click on element having (.+) \"([^\"]*)\"$")
	public void I_click_on_element_having_id(String access_type, String access_name) throws Throwable 
	{
		clickmethods.click(access_type, access_name);
	}*/
}

