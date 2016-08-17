@run
Feature: Edit Profile
	I want to edit my profile within the application.

@happyPathTest
Scenario: Edit profile with valid data.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And User clicks edit profile button
When I make a change to my pre-populated data
And I click the Save button
Then a profile saved success message will display

@negativeTest
Scenario Outline: Edit profile and remove required data.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And User clicks edit profile button
When I delete the pre-populated data
And I click the Save button
Then an error message will display indicating required data is missing

