Feature: Gmail Login
  As a user I should able to login into Gmail.

  Scenario: I login with valid credential
    Given I navigate to "http://the-internet.herokuapp.com/login"
    And I enter "tomsmith" into input field having xpath "//input[@id='username']"
    And I enter "SuperSecretPassword!" into input field having id "password"
    When I click on element having class "radius"
    Then I wait 5 seconds for element having css "a[href='/logout']" to display

  Scenario: Try to navigate backwards
    Given I refresh page
    And I click on element having xpath "//i[text()=' Logout']"
    Then element having xpath "//input[@id='username']" should be present

  Scenario: Log back in
    Given I click on element having xpath "//input[@id='username']"
    And I enter "tomsmith" into input field having xpath "//input[@id='username']"
    And I enter "SuperSecretPassword!" into input field having id "password"
    When I click on element having class "radius"
    Then I wait 5 seconds for element having css "a[href='/logout']" to display