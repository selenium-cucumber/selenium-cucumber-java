Feature: Assertion Steps
        As a user I should able to verify using assert steps //Should have attribute steps are not present here

  Scenario: Open test page
    Given I navigate to "http://selenium-cucumber.github.io/"

  Scenario: verify page title
    Then I should see page title as "Test Page for selenium-cucumber"
    Then I should not see page title as "wrong title"

  Scenario: verify partial page title
    Then I should see page title having partial text as "selenium-cucumber"
    Then I should not see page title having partial text as "Wrong title"

  Scenario: verify page title - negative test
    Then I should see page title as "wrong title"

  Scenario: verify page title - negative test
    Then I should not see page title as "Test Page for selenium-cucumber"

  Scenario: verify partial page title - negative test
    Then I should see page title having partial text as "Wrong title"

  Scenario: verify partial page title - negative test
    Then I should not see page title having partial text as "selenium-cucumber"

  Scenario: verify element text
    Then I scroll to end of page
    Then element having id "dbClick" should have text as "Double-click this paragraph to trigger a function."
    Then element having name "javascript_alert_msg" should have text as "Click the button to display a confirm box."
    Then element having class "form_name" should have text as "Simple sample form with input elements"
    Then element having xpath ".//*[@id='frm']/fieldset/p[1]/label" should have text as "Text input (first name)"

  Scenario: verify element should not text
    Then element having id "dbClick" should not have text as "Double-click this"
    Then element having name "javascript_alert_msg" should not have text as "Click the button"
    Then element having class "form_name" should not have text as "Simple sample"
    Then element having xpath ".//*[@id='frm']/fieldset/p[3]/label" should not have text as "xyz"

  Scenario: verify element text - negative test 1
    Then element having id "dbClick" should have text as "Double-click this"

  Scenario: verify element text - negative test 2
    Then element having name "javascript_alert_msg" should not have text as "Click the button to display a confirm box."

  Scenario: Partial text present
    Then element having id "frm" should have partial text as "last"

  Scenario: Partial text present - negative test
    Then element having id "frm" should have partial text as "selenium"

  Scenario: Partial text not present
    Then element having id "frm" should not have partial text as "selenium"

  Scenario: Partial text not present - negative test
    Then element having id "frm" should not have partial text as "last"

  Scenario: verify element accesibility
    Then element having id "submit" should be enabled
    Then element having name "btn_reset" should be enabled
    Then element having class "cls_pwd" should be enabled
    Then element having xpath ".//*[@id='try_it']" should be enabled
    Then element having id "disabledBt_id" should be disabled
    Then element having name "disabledBt_name" should be disabled
    Then element having class "df_class" should be disabled
    Then element having xpath ".//*[@id='df_id']" should be disabled

  Scenario: verify element accesibility - negative test 1
    Then element having id "submit" should be disabled

  Scenario: verify element accesibility - negative test 2
    Then element having id "disabledBt_id" should be enabled

  Scenario: verify element visibility
    Then element having id "hiddenElement" should not be present
    Then element having name "he_name" should not be present
    Then element having class "he_class" should not be present
    Then element having xpath ".//*[@id='hiddenElement']" should not be present
    And I wait for 10 sec
    Then element having id "hiddenElement" should be present
    Then element having name "he_name" should be present
    Then element having class "he_class" should be present
    Then element having xpath ".//*[@id='hiddenElement']" should be present

  Scenario: verify checkbox checked or not
    Then checkbox having id "chk1" should be checked
    Then checkbox having name "chk5_name" should be checked
    Then checkbox having xpath ".//*[@id='chk1']" should be checked
    Then checkbox having class "chk5_class" should be checked
    Then checkbox having id "chk2" should be unchecked
    Then checkbox having name "chk3_name" should be unchecked
    Then checkbox having class "chk4_class" should be unchecked

  Scenario: verify checkbox checked or not - negative test 1
    Then checkbox having class "chk3_class" should be checked

  Scenario: verify checkbox checked or not - negative test 2
    Then checkbox having class "chk5_class" should be unchecked

  Scenario: verify radio button selected or not
    Then radio button having id "rdb1" should be selected
    Then radio button having id "rdb2" should be unselected

  Scenario: verify radio button selected or not - negative test 1
    Then radio button having id "rdb2" should be selected

  Scenario: verify radio button selected or not - negative test 2
    Then radio button having id "rdb1" should be unselected

  Scenario: verify radio button group selected or not
    Then I select radio button having xpath ".//*[@id='frm']/fieldset/p[6]/input[1]"
    Then option "M" by value from radio button group having name "radio_gender" should be selected

  Scenario: verify radio button group selected or not - negative test
    Then option "M" by value from radio button group having name "radio_gender" should be unselected

  Scenario: verify link present or not
    Then link having text "selenium-cucumber gem" should be present
    Then link having text "xyz" should not be present

  Scenario: verify pop-up alert text
    When I click on element having id "try_it"
    Then I should see alert text as "Press a button!"
    Then I accept alert
