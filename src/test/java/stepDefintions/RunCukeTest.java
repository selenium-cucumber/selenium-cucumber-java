package stepDefintions;

import org.junit.runner.RunWith;

import com.harmonia.qa.webdriver.tests.base.CommonUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import env.BaseTest;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumberHtmlReport" },
//pretty:target/cucumber-json-report.json
		features = "classpath:features")
public class RunCukeTest implements BaseTest {
}
