package features.env;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty","html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json"},
		features = {"src/features/"}
		)
public class CucumberRunner 
{
  public static WebDriver driver = new FirefoxDriver();
  
  public static WebDriverWait wait = new WebDriverWait(driver, 30);
}
