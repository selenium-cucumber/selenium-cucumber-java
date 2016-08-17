package stepDefintions;

import com.harmonia.qa.webdriver.utilities.BasicWebDriverProperties;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import env.BaseTest;

public class Hooks {

	/**
	 * Guarantees that the webdriver has navigated to the homepage before the
	 * scenario if a scenario is tagged with HomePageBefore
	 *
	 * @param scenario the scenario that is tested
	 */
	@Before("@HomePageBefore")
	//TODO
	public void beforeScenario(Scenario scenario) {
		System.out.println("In hooks Before"); //TODO remove debug
		System.out.println(scenario.getName());
		BaseTest.driver.get(BasicWebDriverProperties.BASE_URL);
	}

	/**
	 * Guarantees that the webdriver is quit after a scenario tagged with
	 * QuitAfter
	 *
	 * @param scenario the scenario that is tested
	 */
	@After("@QuitAfter")
	public void afterScenario(Scenario scenario) {
		System.out.println("In hooks After");//TODO remove debug
		System.out.println(scenario.getName());
		System.out.println(scenario.getStatus());
		BaseTest.driver.quit();
	}
}
