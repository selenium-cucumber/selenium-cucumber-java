@run
Feature: Delete an existing kudo
	I want to delete an existing kudo for a user in the application.

@happyPathTest
Scenario: Delete an existing kudo.
Given User is logged in to the application with username "<name>" and password "<password>"
|name|password|
|"test1"|"password"|
And I have selected a pre-existing kudo
When I click the Delete button
Then the kudo will no longer be displayed
