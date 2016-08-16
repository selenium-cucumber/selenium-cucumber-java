package env;

import methods.AssertionMethods;
import methods.ClickElementsMethods;
import methods.ConfigurationMethods;
import methods.InputMethods;
import methods.JavascriptHandlingMethods;
import methods.MiscMethods;
import methods.NavigateMethods;
import methods.ProgressMethods;
import methods.ScreenShotMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriver.sqa.ManagedWebDriver;

import com.harmonia.qa.webdriver.tests.base.CommonUtils;
import com.harmonia.qa.webdriver.utilities.BasicWebDriverManager;

public interface BaseTest {

	public static WebDriver driver = new ManagedWebDriver();

	public static WebDriverWait wait = new WebDriverWait(driver, 30);

	MiscMethods miscmethodObj = new MiscMethods();

	NavigateMethods navigationObj = new NavigateMethods();

	AssertionMethods assertionObj = new AssertionMethods();

	ClickElementsMethods clickObj = new ClickElementsMethods();

	ConfigurationMethods configObj = new ConfigurationMethods();

	InputMethods inputObj = new InputMethods();

	ProgressMethods progressObj = new ProgressMethods();

	JavascriptHandlingMethods javascriptObj = new JavascriptHandlingMethods();

	ScreenShotMethods screenshotObj = new ScreenShotMethods();
}
