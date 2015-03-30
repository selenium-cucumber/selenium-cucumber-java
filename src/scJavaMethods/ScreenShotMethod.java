package scJavaMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import features.env.CucumberRunner;

public class ScreenShotMethod 
{
	public void takeScreenShot() throws IOException
	{
		File scrFile = ((TakesScreenshot)CucumberRunner.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c://screenshots/screenshot.png"));
	}
	 /* cur_time = Time.now.strftime('%Y%m%d%H%M%S%L')
	  $driver.save_screenshot('./features/screenshots/screenshot' + cur_time + '.png')*/
}
