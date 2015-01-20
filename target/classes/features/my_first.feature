Feature: Test Feature

Scenario: Go to test page
    Given I navigate to "file:///C:/Users/Vertis/Documents/SC/example/test_page.html"
   
Scenario: click on elements
	Then I enter "selenium-cucumber" into input field having id "f_name"
	Then I click on element having id "reset"