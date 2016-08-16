@run
Feature: View recent kudos on the dashboard page.
	I want to view recent kudos on the dashboard page.

@happyPathTest
Scenario: View recent kudos on the dashboard page.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And I have added a new kudo
When I navigate to the recent kudos section
Then the new kudo will be displayed


