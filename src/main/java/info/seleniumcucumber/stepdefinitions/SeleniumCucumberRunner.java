/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.seleniumcucumber.stepdefinitions;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *
 * @author heuert
 */

@RunWith(Cucumber.class)
//@Cucumber.Options()
//@Cucumber.Options(format = {/*"pretty",*/ /*"json:target/cucumber.json",*/ "html:build/cucumber-html-report"})
//@Cucumber.Options(name = {"ContactUs"})
@CucumberOptions(plugin = {"pretty", "html:build/cucumber-html-report"})
public class SeleniumCucumberRunner {
	
}