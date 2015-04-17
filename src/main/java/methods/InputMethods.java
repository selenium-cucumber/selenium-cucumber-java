package methods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import env.BaseTest;

public class InputMethods extends SelectElementByType implements BaseTest
{
	//SelectElementByType eleType= new SelectElementByType();
	private WebElement dropdown =null;
	private Select selectList=null;
	
	/** Method to enter text into text field
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param text : String : Text value to enter in field
	   @param accessName : String : Locator value
	 */
	public void enterText(String accessType,String text,String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).sendKeys(text);
	}
	
	/** Method to clear text of text field
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void clearText(String accessType, String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).clear();
	}
	
	/** Method to select element from Dropdown by type
	 * @param select_list : Select : Select variable
	 * @param bytype : String : Name of by type
	 * @param option : String : Option to select
	 */
	public void selectelementfromdropdownbytype (Select select_list, String bytype, String option)
	{
		System.out.println("**"+bytype+"++"+option);
		if(bytype.equals("selectByIndex"))
		{
			int index = Integer.parseInt(option);
			select_list.selectByIndex(index-1);
		}
		else if (bytype.equals("value"))
			select_list.selectByValue(option);
		else if (bytype.equals("text"))
			select_list.selectByVisibleText(option);
	}
	
	/** Method to select option from dropdown list
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param by : String : Name of by type
	@param option : String : Option to select
	@param accessName : String : Locator value
	*/
	public void selectOptionFromDropdown(String accessType, String by, String option, String accessName)
	{
		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		selectelementfromdropdownbytype(selectList,by,option);
	}
	
	//method to select all option from dropdwon list
	/*public void select_all_option_from_multiselect_dropdown(String access_type, String access_name)
	{
		dropdown = CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name));
		select_list = new Select(dropdown);
		select_list.select_all
		Select all method not present in JAVA
	}*/
	
	/** Method to unselect all option from dropdwon list
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void unselectAllOptionFromMultiselectDropdown(String accessType, String accessName)
	{
		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		selectList.deselectAll();
	}
	
	/** Method to check check-box
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void checkCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if (!checkbox.isSelected())
			checkbox.click();
	}
	
	/** Method to uncheck check-box
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void uncheckCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if (checkbox.isSelected())
			checkbox.click();
	}
	
	/** Method to toggle check-box status
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void toggleCheckbox(String accessType, String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName))).click();
	}
	
	/** Method to select radio button
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void selectRadioButton(String accessType, String accessName)
	{
		WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if(!radioButton.isSelected())
			radioButton.click();
	}
	
	/** Method to select option from radio button group
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param by : String : Name of by type
	@param option : String : Option to select
	@param accessName : String : Locator value
	*/
	public void selectOptionFromRadioButtonGroup(String accessType, String by, String option, String accessName)
	{
		List<WebElement> radioButtonGroup = driver.findElements(getelementbytype(accessType, accessName));
		String getoption = null;
		
		/*System.out.println("cnt : "+radioButtonGroup.size());
		for(int i =0; i < radioButtonGroup.size() ; i++ ){
			System.out.println("In loop i: "+i);
			System.out.println(radioButtonGroup.get(i).isSelected());
		}*/
		
		for(WebElement temp : radioButtonGroup)
		{
			if(by.equals("value"))
			{
				System.out.println("+++"+temp.getAttribute("value"));
				getoption = temp.getAttribute("value");
			}
			else
			{
				System.out.println("***"+temp.getText());
				getoption = temp.getText();
			}
			System.out.println("Element : "+getoption);
			if(getoption.equals(option) && !temp.isSelected())
				temp.click();
		}
		
	}
	//	List<WebElement> radioButtonGroup = CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name));
		

	/*  getter = ->(rb, by) { by == 'value' ? rb.attribute('value') : rb.text }
	  ele = radio_button_group.find { |rb| getter.call(rb, by) == option }
	  ele.click unless ele.selected?
	}*/
}
