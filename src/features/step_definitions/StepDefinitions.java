package features.step_definitions;

import sc_java_methods.navigate_methods;
import sc_java_methods.click_elements_methods;
import sc_java_methods.input_methods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions
{
	private navigate_methods navmethod=new navigate_methods();
	private click_elements_methods clickmethods=new click_elements_methods();
	private input_methods inputmethods=new input_methods();
	
	@Then("^I navigate to \"([^\"]*)\"$")
	public void navigate_to_0(String url) throws Throwable 
	{
		navmethod.navigate_to(url);
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
	}
}

