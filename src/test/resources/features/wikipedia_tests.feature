Feature: Wikipedia search
        As a non logged in user I should be able to do search on Wikipedia.
 
 Scenario: I select a language
        Given I navigate to "https://www.wikipedia.org/"
        And I select "he" option by value from dropdown having id "searchLanguage"
        When I enter "בדיקת תוכנה אוטומטית" into input field having id "searchInput"
        And I click on element having class "pure-button-primary-progressive"
        When I wait for 5 sec
        Then I close browser
