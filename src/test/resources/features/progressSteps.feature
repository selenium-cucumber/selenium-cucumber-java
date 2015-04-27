Feature: Progress Steps
        As a user I should able to wait
 
 	Scenario: Open test page
 		Given I navigate to "http://selenium-cucumber.github.io/"

 	Scenario: wait for elements to display
 		
 		Then element having id "hiddenElement" should not be present
		Then I wait 15 seconds for element having id "hiddenElement" to display
 		Then element having id "hiddenElement" should be present


  Scenario: wait for elements to enabled
 		Then element having id "disabledBt" should be disabled
 		Then I wait 15 seconds for element having id "disabledBt" to be enabled
 		Then element having id "disabledBt" should be enabled