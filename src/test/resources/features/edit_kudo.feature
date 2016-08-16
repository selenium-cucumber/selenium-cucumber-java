@run
Feature: Edit an existing kudo
	I want to edit an existing kudo for a user in the application.

@happyPathTest
Scenario: Edit an existing kudo with valid data.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And I have selected a pre-existing kudo
And I click the Edit button
When I make a change to the kudo
And click the Save button
Then the edited kudo will be displayed

@negativeTest
Scenario Outline: Edit existing kudo and remove required data.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And I have selected a pre-existing kudo
And I click the Edit button
When I delete the pre-populated data
And I click the Save button
Then an error message will display indicating required data is missing




