package scJavaMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import features.env.CucumberRunner;

public class AssertionMethods 
{
	//This file contains assertion methods which are called from assertion_steps.rb

	SelectElementByType eleType= new SelectElementByType();
	WebElement element=null;
		
	// Method to return page title
	public String getPageTitle()
	{
		return CucumberRunner.driver.getTitle();
	}
	
	/* Method to verify title
	# param 1 : String : expected title
	# param 2 : Boolean : test case [true or false]*/
	public void checkTitle(String title,boolean testCase) throws TestCaseFailed
	{
		String pageTitle = getPageTitle();
		if (testCase)
		{
			if(!pageTitle.equals(title))
				throw new TestCaseFailed("Page Title Not Matched, Actual Page Title : "+pageTitle);
		}
		else
		{
			if(pageTitle.equals(title))
				throw new TestCaseFailed("Page Title Matched, Actual Page Title : "+pageTitle);
		}
	}

	// Method to get element text
	public String getElementText(String accessType, String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.getText();
		
	  //WAIT.until { $driver.find_element(:"#{access_type}" => "#{access_name}") }.text
	}
	
	/*Method to check element text
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Expected element text
	# param 3 : String : Locator value
	# param 4 : Boolean : test case [true or false]*/

	public void checkElementText(String accessType,String actualValue,String accessName,boolean testCase) throws TestCaseFailed
	{
		String elementText = getElementText(accessType, accessName);
		
		if (testCase)
		{
			if (!elementText.equals(actualValue))
				throw new TestCaseFailed("Text Not Matched");
		}
		else
		{
			if (elementText.equals(actualValue))
				throw new TestCaseFailed("Text Matched");
		}
	}
	
	/* Method to check partial element text
	param 1 : String : Locator type (id, name, class, xpath, css)
	param 2 : String : Expected element partial text
	param 3 : String : Locator value
	param 4 : Boolean : test case [true or false]*/
	
	public void checkElementPartialText(String accessType,String actualValue,String accessName,boolean testCase) throws TestCaseFailed
	{
		String elementText = getElementText(accessType, accessName);

	    if (testCase)
	    {
	    	if (!elementText.equals(actualValue))
	    		throw new TestCaseFailed("Text Not Matched");
	    }
	    else
	    {
	    	if (elementText.equals(actualValue))
	    		throw new TestCaseFailed("Text Matched");
	    }
	}
	
	/*Method to return element status - enabled?
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Locator value*/
	
	public boolean isElementEnabled(String accessType, String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.isEnabled();
		
		//return WAIT.until{$driver.find_element(:"#{access_type}" => "#{access_name}")}.enabled?
	}
	
	/*Element enabled checking
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Expected element text
	# param 4 : Boolean : test case [true or false]*/
			
	public void checkElementEnable(String accessType, String accessName, boolean testCase) throws TestCaseFailed
	{
		boolean result=isElementEnabled(accessType,accessName);
		if(testCase)
		{
			if (!result)
				throw new TestCaseFailed("Element Not Enabled");
		}
		else 
		{ 
			 if(result)
				 throw new TestCaseFailed("Element Enabled");
		}
	}	  
	
	/*# method to get attribute value
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Expected element text
	# param 3 : String : atrribute name*/
	
	public String getElementAttribute(String accessType,String accessName,String attributeName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.getAttribute(attributeName);
		//return WAIT.until{$driver.find_element(:"#{access_type}" => "#{access_name}")}.attribute("#{attribute_name}")
	}
	
	/*# method to check attribute value
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : atrribute name
	# param 3 : String : atrribute value
	# param 4 : String : Locator value
	# param 5 : Boolean : test case [true or false]*/
	
	public void checkElementAttribute(String accessType, String attributeName, String attributeValue, String accessName, boolean testCase) throws TestCaseFailed
	{
		String attrVal = getElementAttribute(accessType, accessName, attributeName);
		if(testCase)
		{
			if(!attrVal.equals(attributeValue))
				throw new TestCaseFailed("Attribute Value Not Matched");
		}
		else 
		{
			if(attrVal.equals(attributeValue))
				throw new TestCaseFailed("Attribute Value Matched");
		}
	}
	
	/*# method to get element status - displayed?
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Locator value*/
	
	public boolean isElementDisplayed(String accessType,String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.isDisplayed();
	}
	
	/*# method to check element presence
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Locator value
	# param 3 : Boolean : test case [true or false]*/
	
	public void checkElementPresence(String accessType,String accessName,boolean testCase) throws TestCaseFailed
	{
		if (testCase)
		{
			if (!isElementDisplayed(accessType, accessName))
				throw new TestCaseFailed("Element Not Present");
		}
		else
		{
			try
			{
				if(isElementDisplayed(accessType, accessName))
					throw new Exception("Present"); //since it is negative test and we found element
			}
			catch(Exception e)
			{
				if(e.getMessage().equals("Present")) //only raise if it present
					throw new TestCaseFailed("Element Present");
			}
		}
	}
	
	/*method to assert checkbox check/uncheck
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Locator value
	# param 3 : Boolean : test case [true or false]*/
	
	public void isCheckboxChecked(String accessType,String accessName,boolean shouldBeChecked) throws TestCaseFailed
	{
		WebElement checkbox = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		if((!checkbox.isSelected()) && shouldBeChecked)
			throw new TestCaseFailed("Checkbox is not checked");
		else if(checkbox.isSelected() && !shouldBeChecked)
			throw new TestCaseFailed("Checkbox is checked");
	}
	
	/*# method to assert radio button selected/unselected
	# param 1 : String : Locator type (id, name, class, xpath, css)
	# param 2 : String : Locator value
	# param 3 : Boolean : test case [true or false]*/
	
	public void isRadioButtonSelected(String accessType,String accessName,boolean shouldBeSelected) throws TestCaseFailed
	{
		WebElement radioButton = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		if((!radioButton.isSelected()) && shouldBeSelected)
			throw new TestCaseFailed("Radio Button not selected");
		else if(radioButton.isSelected() && !shouldBeSelected)
			throw new TestCaseFailed("Radio Button is selected");
	}

	//method to assert option from radio button group is selected/unselected
	public void isOptionFromRadioButtonGroupSelected(String accessType,String by,String option,String accessName,boolean shouldBeSelected)
	{
		WebElement radioButtonGroup = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
	}
	
	//method to get javascript pop-up alert text
	public String getAlertText()
	{
		return CucumberRunner.driver.switchTo().alert().getText();
	}
	  
	//method to check javascript pop-up alert text
	public void checkAlertText(String text) throws TestCaseFailed
	{
		if(!getAlertText().equals(text))
			throw new TestCaseFailed("Text on alert pop up not matched");
	}
	
	  /*radio_button_group = WAIT.until{ $driver.find_elements(:"#{access_type}" => "#{access_name}") }

	  getter = ->(rb, by) { by == 'value' ? rb.attribute('value') : rb.text }

	  ele = radio_button_group.find { |rb| getter.call(rb, by) == option }

	  if !ele.selected? && should_be_selected
	    raise TestCaseFailed, 'Radio button is not selected'
	  elsif ele.selected? && !should_be_selected
	    raise TestCaseFailed, 'Radio button is selected'
	  end
	end*/
	
	/*method to get javascript pop-up alert text
	def get_alert_text
	  $driver.switch_to.alert.text
	end*/
}
