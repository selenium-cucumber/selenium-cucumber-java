Feature: Each step for testing
        As a user I should able to verify all steps are working

 Scenario: Open test page
    Given I navigate to "file:///D:/sc_ruby/selenium-cucumber-ruby/tests/test_page.html"
   
  
		Scenario: selecting radio button from group
 		
 		Then I select "F" option by value from radio button group having name "radio_gender"
 		Then radio button having xpath ".//*[@id='frm']/fieldset/p[6]/input[2]" should be selected
