Feature: Registration
	I want to register with the application.

@happyPathTest
Scenario: Registration with valid data.
Given User is on Landing Page
	And User navigates to Registration Page
When User enters Registration Data
|"username1"|"f_name1"|"l_name1"|"phone1"|"password"|
	And User clicks confirm registration button
	Then Message displayed Registration Successful

@negativeTest
Scenario Outline: Registration with no data.
Given User is on Landing Page
	And User navigates to Registration Page
	And User clicks confirm registration button
Then Message displayed Registration Error Missing Data

