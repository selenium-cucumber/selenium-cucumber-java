package stepDefintions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty",
				"json:target/cucumber.json"},
		//pretty:target/cucumber-json-report.json
		//, "json:target/cucumber.json" ,
		features = "classpath:features",
		glue = {"info.seleniumcucumber.stepdefinitions"}
)
//plugin = {"html:target/cucumberHtmlReport"},
public class RunCukeTest {
}
