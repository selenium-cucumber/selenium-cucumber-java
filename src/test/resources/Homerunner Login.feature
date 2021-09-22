Feature: Homerunner Login
As a user, I should be able to login to homerunner application

Scenario: Access homepage
Given I navigate to "www.homerunner.ng"
And I click on element having xpath "//button[text()='Get Started']"
And I switch to new window
Then element having xpath "//span[text()='Start']" should be present

Scenario: Fill homerunner form
Given I click on element having xpath "//span[text()='Start']"
And I enter "Random" into field having name "given-name"
And I click on element having xpath "//span[text()='OK']"
Then element having name "family-name" should not be present