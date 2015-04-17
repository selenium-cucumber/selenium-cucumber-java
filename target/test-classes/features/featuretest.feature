Feature: Each step for testing
        As a user I should able to verify all steps are working

 Scenario: Open test page
   Given I navigate to "file:\\\D:\sc_ruby\selenium-cucumber-ruby\tests\test_page.html"
   
   Scenario: verify element text

		Then I scroll to end of page
		Then element having id "dbClick" should have text as "Double-click this paragraph to trigger a function."
 		Then element having name "javascript_alert_msg" should have text as "Click the button to display a confirm box."
 		Then element having class "form_name" should have text as "Simple sample form with input elements"
 		Then element having xpath ".//*[@id='frm']/fieldset/p[1]/label" should have text as "Text input (first name)"