package env;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.harmonia.qa.webdriver.utilities.BasicWebDriverProperties;

public class Env {

	private static WebDriver driver = null;

	private static String browserName = null;

	public static String getBrowserName() {
		browserName = System.getProperty("browser");

		if (browserName == null) browserName = "ff";
		return browserName;
	}

	public static WebDriver CreateWebDriver(String browser) {
		System.out.println("Browser: " + browser);

		switch (browser.toLowerCase()) {
		case "ff":
		case "firefox":
			//ProfilesIni allProfiles = new ProfilesIni();
			//FirefoxProfile profile = allProfiles.getProfile("selenium");
			//driver = new FirefoxDriver(profile);
			driver = new FirefoxDriver();
			break;

		case "ch":
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "ie":
		case "internetexplorer":
			driver = new InternetExplorerDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Invalid browser name " + browser);
			System.exit(0);
			break;
		}//switch

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

	//TODO Probably unnecessary, but temporarily hanging on to this code in case
	//the fields of this class are accessed refectively by cucumber
	//	public static void setWebDriver(WebDriver d) {
	//		driver = d;
	//		int choice = BasicWebDriverProperties.BROWSER_CHOICE;
	//		switch (choice) {
	//		case 1:
	//			browserName = "Internet Explorer 7";
	//			break;
	//		case 2:
	//			browserName = "Internet Explorer 8";
	//			break;
	//		case 3:
	//			browserName = "Internet Explorer 9";
	//			break;
	//		case 4:
	//			browserName = "Firefox";
	//			break;
	//		case 5:
	//			browserName = "Google Chrome";
	//			break;
	//		default:
	//			throw new RuntimeException("Browser name must be in the range of 1-5, specified: " + choice);
	//		}
}
