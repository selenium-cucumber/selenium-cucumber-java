Feature: Screenshot Step
        As a user I should able to take screenshot

 	Scenario: Open test page
      Given I navigate to "file:\\\D:\sc_ruby\selenium-cucumber-ruby\tests\test_page.html"

 	Scenario: take screenshot
      Then I take screenshot

 	Scenario: close browser
   		Then I close browser
