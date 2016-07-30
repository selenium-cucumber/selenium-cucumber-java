package methods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import env.BaseTest;

public class ScreenShotMethods implements BaseTest {

	public ScreenShotMethods() {
	}

	public void takeScreenShot() throws IOException {
		File scrFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		String scrFilepath = scrFile.getAbsolutePath();

		System.out.println((new StringBuilder("scrFilepath: ")).append(scrFilepath).toString());

		File currentDirFile = new File("Screenshots");

		String path = currentDirFile.getAbsolutePath();

		FileUtils.copyFile(scrFile,
				new File((new StringBuilder(String.valueOf(path))).append(File.separator + "screenshot-")
						.append(dateFormat.format(cal.getTime())).append(".png").toString()));
	}
}
