package scJavaMethods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import features.env.CucumberRunner;
import scJavaMethods.SelectElementByType;

public class InputMethods 
{
	SelectElementByType eleType= new SelectElementByType();
	WebElement dropdown,element =null;
	Select selectList=null;
	
	//method to enter text into textfield
	public void enterText(String accessType,String text,String accessName)
	{
		CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		CucumberRunner.driver.findElement(eleType.getelementbytype(accessType, accessName)).sendKeys(text);
	}
	
	//method to clear text from textfield
	public void clearText(String accessType, String accessName)
	{
		CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		CucumberRunner.driver.findElement(eleType.getelementbytype(accessType, accessName)).clear();
	}
	
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
		/*else if (bytype.equals("selectByVisibleText"))
			select_list.selectByValue(option);*/
	}
	
	//method to select option from dropdown list
	public void selectOptionFromDropdown(String accessType, String by, String option, String accessName)
	{
		dropdown = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		//dropdown = CucumberRunner.driver.findElement(eleType.getelementbytype(accessType, accessName));
		selectList = new Select(dropdown);
		selectelementfromdropdownbytype(selectList,by,option);
		
	  /*dropdown = WAIT.until { $driver.find_element(:"#{access_type}" => "#{access_name}") }
	  select_list = Selenium::WebDriver::Support::Select.new(dropdown)
	  select_list.select_by(:"#{by}", "#{option}")*/
	}
	
	//method to select all option from dropdwon list
	/*public void select_all_option_from_multiselect_dropdown(String access_type, String access_name)
	{
		dropdown = CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name));
		select_list = new Select(dropdown);
		select_list.select_all
		Select all method not present in JAVA
	}*/
	
	//method to unselect all option from dropdwon list
	public void unselectAllOptionFromMultiselectDropdown(String accessType, String accessName)
	{
		dropdown = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		//dropdown = CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name));
		selectList = new Select(dropdown);
		selectList.deselectAll();
	}
	
	//method to check checkbox
	public void checkCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		//WebElement checkbox = CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name));
		if (!checkbox.isSelected())
			checkbox.click();
	}
	
	//method to uncheck checkbox
	public void uncheckCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		//WebElement checkbox = CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name));
		if (checkbox.isSelected())
			checkbox.click();
	}
	
	//method to select radio button
	public void toggleCheckbox(String accessType, String accessName)
	{
		CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName))).click();
		//CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name)).click();
	}
	
	//method to select radio button
	public void selectRadioButton(String accessType, String accessName)
	{
		WebElement radioButton = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		if(!radioButton.isSelected())
			radioButton.click();
	}
	
	//method to select option from radio button group
	public void selectOptionFromRadioButtonGroup(String accessType, String by, String option, String accessName)
	{
		List<WebElement> radioButtonGroup = CucumberRunner.driver.findElements(eleType.getelementbytype(accessType, accessName));
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
