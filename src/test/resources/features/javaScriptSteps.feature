
Feature: Javasciprt Handling Steps
        As a user I should able to handle javascript pop-up 

	Scenario: Open test page
 		Given I navigate to "http://selenium-cucumber.github.io/" 
 	
 	Scenario: accept alert

 		Then I click on element having id "try_it"
 		Then I accept alert 
       	Then element having id "demo" should have text as "You pressed OK!"

	Scenario: dismiss alert       	
	
       	Then I click on element having id "try_it"
 		Then I dismiss alert
 		Then element having id "demo" should have text as "You pressed Cancel!"
		
