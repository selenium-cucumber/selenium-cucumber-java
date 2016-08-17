Feature: Logout
	I want to logout of the application.

@happyPathTest
Scenario Outline: Successful Logout
	Given User is logged in to the application with username "<name>" and password "<password>"
	And User logs out of the application
	Then Message displayed Logout Successful
		And Landing page is displayed
		Examples:
	|name   |password  |
	|"test1"|"password"|
