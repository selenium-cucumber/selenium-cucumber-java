@run
Feature: Filter kudos
	I want to filter kudos by date, first name, and last name.

@happyPathTest
Scenario: Filter kudos by date.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And on the filter kudos page
When I apply the date range filter
Then the newly added kudo will display as the first item in the table

@happyPathTest
Scenario: Filter kudos by first name.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And on the filter kudos page
When I enter the first name NAME
Then the kudo associated with user named NAME will display as the first item in the table

@happyPathTest
Scenario: Filter kudos by last name.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And on the filter kudos page
When I enter the last name NAME
Then the kudo associated with user named NAME will display as the first item in the table



