Feature: Input Step
        As a user I should able to give inputs

  Scenario: Open test page
    Given I navigate to "http://selenium-cucumber.github.io/"

  Scenario: Enter text into textfield
    Then I enter "abc" into input field having id "f_name"
    Then element having id "f_name" should have attribute "value" with value "abc"
    Then I enter "xyz" into input field having name "lname_name"
    Then element having name "lname_name" should have attribute "value" with value "xyz"
    Then I enter "pqr" into input field having class "address_class"
    Then element having class "address_class" should have attribute "value" with value "pqr"

  Scenario: Clear text From textfield
    Then I clear input field having id "f_name"
    Then element having id "f_name" should have attribute "value" with value ""
    Then I clear input field having name "lname_name"
    Then element having name "lname_name" should have attribute "value" with value ""
    Then I clear input field having class "address_class"
    Then element having class "address_class" should have attribute "value" with value ""

  Scenario: select option from dropdown list
    Then I select "Select_5" option by text from dropdown having id "dropdownList1"
    Then option "Select_5" by text from dropdown having id "dropdownList1" should be selected
    Then I select 1 option by index from dropdown having id "dropdownList1"
    Then option "Select_1" by text from dropdown having id "dropdownList1" should be selected
    Then I select "s3" option by value from dropdown having id "dropdownList1"
    Then option "s3" by value from dropdown having id "dropdownList1" should be selected

  Scenario: select option from Multiselect List
    Then I select "Volvo" option by text from multiselect dropdown having name "cars"
    Then I select 4 option by index from multiselect dropdown having name "cars"
    Then I select "opel" option by value from multiselect dropdown having name "cars"
  
  Scenario: deselect option from Multiselect List
    Then I deselect "Volvo" option by text from multiselect dropdown having name "cars"
      
  Scenario: deselect all options from Multiselect List
    Then I deselect all options from multiselect dropdown having name "cars"

  Scenario: selecting checkbox
    Then I check the checkbox having id "chk3"
    Then checkbox having id "chk3" should be checked
    Then I check the checkbox having name "chk2_name"
    Then checkbox having name "chk2_name" should be checked

  Scenario: unselecting checkbox
    Then I uncheck the checkbox having class "chk5_class"
    Then checkbox having class "chk5_class" should be unchecked

  Scenario: toggle checkbox
    Then I toggle checkbox having id "chk4"
    Then checkbox having id "chk4" should be checked
    Then I toggle checkbox having id "chk4"
    Then checkbox having id "chk4" should be unchecked

  Scenario: selecting radio buttons
    Then I select radio button having id "rdb2"
    Then radio button having id "rdb2" should be selected
    Then I select radio button having name "rdb3_name"
    Then radio button having name "rdb3_name" should be selected
    Then I select radio button having class "rdb4_class"
    Then radio button having class "rdb4_class" should be selected

  Scenario: selecting radio button from group
    Then I select "F" option by value from radio button group having name "radio_gender"
    Then radio button having xpath ".//*[@id='frm']/fieldset/p[6]/input[2]" should be selected
