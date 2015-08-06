Feature: Gmail Login
        As a user I should able to login into Gmail.
 
 Scenario: I login with valid credential
        Given I navigate to "http://www.gmail.com"
        And I enter "test@gmail.com" into input field having id "Email"
        Then I click on element having id "next"
        And I enter "123456" into input field having id "Passwd"
        When I click on element having id "signIn"
        And I wait for 15 sec
        Then I close browser