Feature: Registration
	I want to register with the application.

@happyPathTest
Scenario Outline: Registration with valid data.
Given User is on Landing Page
	And User navigates to Registration Page
When User enters Registration Data
	And User clicks confirm registration button
	Then Message displayed Registration Successful
	Examples:
	|"username1"|"f_name1"|"l_name1"|"phone1"|"password"|

@negativeTest
Scenario: Registration with no data.
Given User is on Landing Page
	And User navigates to Registration Page
	And User clicks confirm registration button
Then Message displayed Registration Error Missing Data

