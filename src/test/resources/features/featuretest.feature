Feature: Each step for testing
        As a user I should able to verify all steps are working

 Scenario: Open test page
    Given I navigate to "file:///D:/sc_ruby/selenium-cucumber-ruby/tests/test_page.html"
   
  
		Scenario: selecting radio button from group
 		
 		Then I select "rdb2" option by id from radio button group having class "rdb2_class"
 		Then radio button having id "rdb2" should be selected
