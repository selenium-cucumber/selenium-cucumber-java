
Feature: Javasciprt Handling Steps
        As a user I should able to handle javascript pop-up 

	Scenario: Open test page
 		Given I navigate to "file:\\\D:\sc_ruby\selenium-cucumber-ruby\tests\test_page.html" 
 	
 	Scenario: accept alert

 		Then I click on element having id "try_it"
 		Then I accept alert 
       	Then element having id "demo" should have text as "You pressed OK!"

	Scenario: dismiss alert       	
	
       	Then I click on element having id "try_it"
 		Then I dismiss alert
 		Then element having id "demo" should have text as "You pressed Cancel!"
		
