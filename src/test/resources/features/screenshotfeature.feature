Feature: Screenshot Step
        As a user I should able to take screenshot

 	Scenario: Open test page
      Given I navigate to "http://www.googledrive.com/host/0B9vZ2s1ustr6eTZDbWlTcThveXM"

 	Scenario: take screenshot
      Then I take screenshot

 	Scenario: close browser
   		Then I close browser
