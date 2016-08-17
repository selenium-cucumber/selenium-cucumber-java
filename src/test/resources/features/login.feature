Feature: Login
	I want to login to the application.

@happyPathTest
Scenario Outline: Successful Login with Valid Credentials
	Given User is on Landing Page
	And User enters "<username>" and "<password>" to login
	Then Message displayed Login Successful
	And Dashboard page is displayed
Examples:
	|username  |password  |
	|"testUser"|"password"|

@negativeTest
Scenario Outline: Unsuccessfuly Login with Invalid Credentials
	Given User is on Landing Page
	And User enters "<invalidUsername>" and "<invalidPassword>" to login
	Then Message displayed Login Error Missing Data
Examples:
	|invalidUsername|invalidPassword|
	|"xxx"|"xxx"|
