package webdriver.sqa;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.harmonia.qa.webdriver.tests.base.CommonUtils;
import com.harmonia.qa.webdriver.utilities.BasicWebDriverManager;

import env.Env;

/**
 * Wraps calls to the BasicWebDriverManager in the WebDriver interface.
 *
 * @author jfoley
 */
public class ManagedWebDriver implements WebDriver {

	BasicWebDriverManager manager = BasicWebDriverManager.get();

	private WebDriver getCurrentDriver() {
		return manager.driver();
	}

	@Override
	public void get(String url) {
		getCurrentDriver().get(url);
	}

	@Override
	public String getCurrentUrl() {
		return getCurrentDriver().getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return getCurrentDriver().getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return getCurrentDriver().findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return getCurrentDriver().findElement(by);
	}

	@Override
	public String getPageSource() {
		return getCurrentDriver().getPageSource();
	}

	@Override
	public void close() {
		BasicWebDriverManager.get().quit(); //TODO
	}

	@Override
	public void quit() {
		BasicWebDriverManager.get().quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return getCurrentDriver().getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return getCurrentDriver().getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return getCurrentDriver().switchTo();
	}

	@Override
	public Navigation navigate() {
		return getCurrentDriver().navigate();
	}

	@Override
	public Options manage() {
		return getCurrentDriver().manage();
	}

}
