@run
Feature: Enter a new kudo
	I want to enter a new kudo for a user in the application.

@happyPathTest
Scenario: Create a new kudo with valid data.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And have selected a user
And have click the Kudo button
When I enter kudo information
And click the Save button
Then the new kudo will be displayed

@negativeTest
Scenario Outline: Create a new kudo with no data.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And have selected a user
And have click the Kudo button
When click the Save button
Then an error message will display indicating required data is missing

