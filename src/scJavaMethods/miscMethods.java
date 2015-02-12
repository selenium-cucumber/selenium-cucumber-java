package scJavaMethods;

import java.util.Arrays;

public class MiscMethods 
{
	//method to validate locator
	public boolean valid_locator_type(String type)
	{
		return Arrays.asList("id","class","css","name","xpath").contains(type);
	}

	public void validateLocator(String type) throws Exception
	{
		if(!valid_locator_type(type))
			throw new Exception("Invalid locator type - "+type);
	}
}
