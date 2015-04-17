
Feature: Javasciprt Handling Steps
        As a user I should able to handle javascript pop-up 

	Scenario: Open test page
 		Given I navigate to "http://www.googledrive.com/host/0B9vZ2s1ustr6eTZDbWlTcThveXM" 
 	
 	Scenario: accept alert

 		Then I click on element having id "try_it"
 		Then I accept alert 
       	Then element having id "demo" should have text as "You pressed OK!"

	Scenario: dismiss alert       	
	
       	Then I click on element having id "try_it"
 		Then I dismiss alert
 		Then element having id "demo" should have text as "You pressed Cancel!"
		
