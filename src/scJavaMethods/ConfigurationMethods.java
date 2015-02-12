package scJavaMethods;

import java.util.Date;

public class ConfigurationMethods 
{

	// method to print configuration
	public void printConfiguration()
	{
		Date date= new Date();
		System.out.println("");
		System.out.println("Date : "+date.toString());
	}
	  /*puts ''
	  puts "Date : #{Time.now.strftime("%d-%B-%Y")}"
	  puts "Time : #{Time.now.strftime("%I:%M:%S:%p")}"

	  if $platform == 'android' or $platform == 'ios'
	  	print_mobile_configuration
	  else
	  	print_desktop_configuration
	  end
	end*/
}
