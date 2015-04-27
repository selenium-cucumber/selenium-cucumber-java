Feature: Navigation Steps
        As a user I should able to navigate on web page

  Scenario: Open test page
    Given I navigate to "http://selenium-cucumber.github.io/"

  Scenario: navigating back/forward and refresh page
    Then I click on link having text "selenium-cucumber gem"
    Then I should see page title as "selenium-cucumber | RubyGems.org | your community gem host"
    Then I navigate back
    Then I should see page title as "Test Page for selenium-cucumber"
    Then I navigate forward
    Then I should see page title as "selenium-cucumber | RubyGems.org | your community gem host"
    Then I navigate back
    Then I should see page title as "Test Page for selenium-cucumber"
    Then I refresh page
    Then I should see page title as "Test Page for selenium-cucumber"

  Scenario: switch to new window
    Then I click on link having text "selenium-cucumber website"
    Then I switch to new window
    Then element having id "access" should be present
    Then I should see page title as "Selenium-Cucumber | Code Less… Test More…"
    Then I close new window

  Scenario: switch to privious window
    Then I switch to previous window
    Then I should see page title as "Test Page for selenium-cucumber"

  Scenario: Zoom in/out web page
    Then I zoom in page
    Then I zoom out page
    Then I reset page view

  Scenario: Scroll web page
    Then I scroll to element having id "demo"
    Then I scroll to top of page
    Then I scroll to end of page

  Scenario: Hover over elelment
    Then I hover over element having id "hover_it"
    Then element having id "mouse_hover_demo" should have text as "Mouse hovered"

  Scenario: Interacting with browser
    Then I resize browser window size to width 400 and height 400
    Then I maximize browser window

  Scenario: Switching to new window by handle
    Then I click on link having text "selenium-cucumber website"
    Then I switch to new window
    Then I click on link having text "Blogs"
    Then I close new window
    Then I switch to previous window
    Then I click on link having text "selenium-cucumber gem"
    Then I navigate back

  Scenario: Switching to new window by Title
    Then I click on link having text "selenium-cucumber website"
    Then I switch to window having title "Selenium-Cucumber | Code Less… Test More…"
    Then I click on link having text "Source Code"
    Then I close new window
    Then I switch to previous window
    Then I click on link having text "selenium-cucumber gem"
    Then I navigate back

  Scenario: Moving to frames
    Then I switch to frame having name "frame_one"
    Then element having id "frame1_fname" should be present
    Then I switch to main content
    Then I switch to frame having xpath "//iframe[@name='frame_two']"
    Then element having id "frame2_email" should be present
    Then I switch to main content
    Then element having xpath "//iframe[@name='frame_one']" should be present   
