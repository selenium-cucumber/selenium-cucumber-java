package env;

import java.util.Collections;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.ErrorHandler;

/**
 * Created by tom on 24/02/17.
 */
public class DriverUtil {
    public static long DEFAULT_WAIT = 20;
    private static int DEFAULT_WINDOW_WIDTH = 1920;
    private static int DEFAULT_WINDOW_HEIGHT = 1080;

    public static WebDriver getDefaultDriver() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        System.setProperty("webdriver.gecko.driver", "./geckodriver");

        DesiredCapabilities capabilities = null; //DesiredCapabilities.phantomjs();
		//capabilities = DesiredCapabilities.phantomjs();
		capabilities = DesiredCapabilities.firefox();
		//ChromeOptions chromeOptions = new ChromeOptions();

		//capabilities.addArguments("--headless", "--disable-gpu");
		//capabilities.setCapability(PhantomJSDriverService., capabilities);
		//capabilities. // --local-storage-path=
		// localStorate/sessionStorage seems to not work with the following:
		//capabilities.setCapability("phantomjs.cli.args", Collections.singletonList("--local-storage-path=/tmp/phantomjs.localstorage"));

        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);

        ////capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "libs/phantomjs-1.9.1-windows/phantomjs.exe");
        ////capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/bin/phantomjs");
        ////capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "node_modules/phantomjs/bin/phantomjs");
        //capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "./node_modules/phantomjs-prebuilt/bin/phantomjs");
        //capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{"--web-security=false", "--ssl-protocol=any", "--ignore-ssl-errors=true"});
        //driver = new HtmlUnitDriver(true);
        //driver = new ChromeDriver(capabilities);
        // driver = new PhantomJSDriver(capabilities);
        // driver = new PhantomJSDriver(capabilities);
        // driver = new ChromeDriver(capabilities);
        final WebDriver driver = chooseDriver(capabilities);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(DEFAULT_WINDOW_WIDTH,
                DEFAULT_WINDOW_HEIGHT));
        return driver;
    }

    /**
     * By default to web driver will be PhantomJS
     *
     * Override it by passing -DWebDriver=Chrome to the command line arguments
     * @param capabilities
     * @return
     */
    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
		String preferredDriver = System.getProperty("WebDriver", "Firefox");
		boolean headless = System.getProperty("Headless", "true").equals("true");
		
		switch (preferredDriver) {
			case "Chrome":
				/*
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless", "--disable-gpu", "--disable-extensions", "--remote-debugging-port=9222");
				//options.addArguments("--disable-gpu", "--disable-extensions");
				//options.setBinary("/usr/bin/chromium-browser");
				options.setBinary("/usr/bin/google-chrome");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				ChromeDriver driver = new ChromeDriver(capabilities);
				*/
				
				
				// /usr/bin/google-chrome
				final ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setBinary("/usr/bin/chromium-browser");
				if (headless) {
					chromeOptions.addArguments("--headless");
				}
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				ChromeDriver driver = new ChromeDriver(capabilities);
				ErrorHandler handler = new ErrorHandler();
				handler.setIncludeServerErrors(false);
				driver.setErrorHandler(handler);
				return driver;
			case "PhantomJS":
				return new PhantomJSDriver(capabilities);
			default:
				//return new PhantomJSDriver(capabilities);
				FirefoxOptions options = new FirefoxOptions();
				//capabilities.s
				if (headless) {
					options.addArguments("-headless", "-safe-mode");
				}
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				final FirefoxDriver firefox = new FirefoxDriver(capabilities);
				return firefox;
		}
    }

    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector,
                                                            int seconds) {
        By selection = By.cssSelector(selector);
        return (new WebDriverWait(driver, seconds)).until( // ensure element is visible!
                ExpectedConditions.visibilityOfElementLocated(selection));
    }
}
