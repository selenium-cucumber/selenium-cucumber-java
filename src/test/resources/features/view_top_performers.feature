@run
Feature: View top performers on the dashboard page.
	I want to view the top performers on the dashboard page.

@happyPathTest
Scenario: View top performers on the dashboard page.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
When I navigate to top performers section
Then the top performers will be displayed in a table
