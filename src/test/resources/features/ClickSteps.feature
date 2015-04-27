Feature: Click On Elements
        As a user I should able to click on elements
 
 	Scenario: Open test page 
		Given I navigate to "http://selenium-cucumber.github.io/"
 		
	Scenario: click on elements
 	
 		Then I enter "selenium-cucumber" into input field having id "f_name"
		Then I click on element having id "reset"
		Then element having id "f_name" should have attribute "value" with value ""
		
	Scenario: double click on elements
		
		Then I double click on element having id "dbClick"
		Then element having name "demo2_name" should be present
	
	Scenario: click on links having text
	
		Then I click on link having text "selenium-cucumber gem"
		Then I should see page title as "selenium-cucumber | RubyGems.org | your community gem host"
		
	Scenario: click on links having partial text

		Then I click on link having partial text "Home"
		Then I should see page title as "Selenium-Cucumber | Code Less… Test More…"