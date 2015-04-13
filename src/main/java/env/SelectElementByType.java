package env;

import org.openqa.selenium.By;

public class SelectElementByType 
{
	/**Method to select element 'by' type
	 * @param type : String : 'By' type
	 * @param access_name : String : Locator value
	 * @return By
	 */
	public By getelementbytype(String type,String access_name)
	{
		if(type.equals("id"))
			return By.id(access_name);
		else if (type.equals("name"))
			return By.name(access_name);
		else if (type.equals("class"))
			return By.className(access_name);
		else if (type.equals("xpath"))
			return By.xpath(access_name);
		else if (type.equals("css"))
			return By.cssSelector(access_name);
		else if(type.equals("linkText"))
			return By.linkText(access_name);
		else if(type.equals("partialLinkText"))
			return By.partialLinkText(access_name);
		else if(type.equals("tagName"))
			return By.tagName(access_name);
		else
			return null;
	}
}
