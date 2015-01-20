package sc_java_methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import features.env.CucumberRunner;

public class assertion_methods 
{
	SelectElementByType eleType= new SelectElementByType();
	WebElement element=null;
		
	//Page title checking
	public String getPageTitle()
	{
		return CucumberRunner.driver.getTitle();
	}
	
	public void checkTitle(String title) throws TestCaseFailed
	{
			if (!getPageTitle().equals(title))
				throw new TestCaseFailed("Page Title Not Matched");
				
	 // raise TestCaseFailed, '' unless get_page_title == title
			/*try {methodthatthrowsexception} catch(IllegalArgumentException e){e.getMessage();}*/
	}

	// Method to get element text
	public String getElementText(String accessType, String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.getText();
		
	  //WAIT.until { $driver.find_element(:"#{access_type}" => "#{access_name}") }.text
	}
	
	// Method to check element text
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
	
	// Method to check partial element text
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
	
	//Method to return element status - enabled?
	public boolean isElementEnabled(String accessType, String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.isEnabled();
		
		//return WAIT.until{$driver.find_element(:"#{access_type}" => "#{access_name}")}.enabled?
	}
	
	//Element enabled checking
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
	
	//method to get attribute value
	public String getElementAttribute(String accessType,String accessName,String attributeName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.getAttribute(attributeName);
		//return WAIT.until{$driver.find_element(:"#{access_type}" => "#{access_name}")}.attribute("#{attribute_name}")
	}
	
	//method to check attribute value
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
	
	//method to get element status - displayed?
	public boolean isElementDisplayed(String accessType,String accessName)
	{
		element = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		return element.isDisplayed();
	}
	
	//method to check element presence
	public void checkElementPresence(String accessType,String accessName,boolean testCase) throws TestCaseFailed
	{
		if (testCase)
		{
			if (!isElementDisplayed(accessType, accessName))
				throw new TestCaseFailed("Element Not Present");
		}
		else
		{
			if(isElementDisplayed(accessType, accessName))
				throw new TestCaseFailed("Element Present");
		}
	}
	
	//method to assert checkbox check/uncheck
	public void isCheckboxChecked(String accessType,String accessName, should_be_checked = true)
	  checkbox = WAIT.until{ $driver.find_element(:"#{access_type}" => "#{access_name}") }

	  if !checkbox.selected? && should_be_checked
	    raise TestCaseFailed, 'Checkbox is not checked'
	  elsif checkbox.selected? && !should_be_checked
	    raise TestCaseFailed, 'Checkbox is checked'
	  end
	end
	
}
