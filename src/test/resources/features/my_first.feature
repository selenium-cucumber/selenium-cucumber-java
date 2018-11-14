Feature: Gmail Login
  As a user I should able to login into Gmail.

  Scenario: I login with valid credential
    Given I navigate to "http://the-internet.herokuapp.com/login"
    And I enter "tomsmith" into input field having id "username"
    And I enter "SuperSecretPassword!" into input field having id "password"
    When I click on element having class "radius"
    Then I wait 5 seconds for element having css "a[href='/logout']" to display
    

  @desktop_update_bag @scenario_1 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion should be removed when we reduce item quantity so that  threshold is not met -- Guest user
    Given I visit the web site as a guest user
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    Then I should not see free shipping promotion applied in "shopping bag"
    And I checkout until I reach the shipping page as a "guest" user
    Then I should not see free shipping promotion applied in "order summary"
    When I checkout until I reach the payment page as a "guest" user
    When I checkout until I reach the order review page as a "guest" user
    When I checkout until I reach the order confirmation page as a "guest" user
    Then I should not see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 6     | 5     |
      | 1614          | 4     | 3     |
      | 1615          | 2     | 1     |
     # | 1616          |1    |4    |


  @desktop_update_bag @scenario_2 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion should be removed when we reduce item quantity so that  threshold is not met -- signed in user
    Given I visit the web site as a registered user
    And I navigate to My Wallet page from My Account page
    And I add credit card to my wallet
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    Then I should not see free shipping promotion applied in "shopping bag"
    When I change the cookie to "responsive"
    And I checkout until I reach the payment page as a "responsive signed in" user
    Then I should not see free shipping promotion applied in "order summary"
    Then I checkout until I reach the order review page as a "signed in" user
    Then I checkout until I reach the order confirmation page as a "signed in" user
    Then I should not see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 6     | 5     |
      | 1614          | 4     | 3     |
      | 1615          | 2     | 1     |
     # | 1616          |1    |4    |

  @desktop_update_bag @scenario_3 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion should be applied when we increase item quantity so that threshold is met -- Guest user
    Given I visit the web site as a guest user
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    Then I should not see free shipping promotion applied in "shopping bag"
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    And I checkout until I reach the shipping page as a "guest" user
    Then I should see free shipping promotion applied in "order summary"
    When I checkout until I reach the payment page as a "guest" user
    When I checkout until I reach the order review page as a "guest" user
    When I checkout until I reach the order confirmation page as a "guest" user
    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 5     | 6     |
      | 1614          | 3     | 4     |
      | 1615          | 1     | 2     |
     #| 1616          |1    |4    |


  @desktop_update_bag @scenario_4 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion should be applied when we increase item quantity so that threshold is met -- signed in user
    Given I visit the web site as a registered user
    And I navigate to My Wallet page from My Account page
    And I add credit card to my wallet
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    Then I should not see free shipping promotion applied in "shopping bag"
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    When I change the cookie to "responsive"
    And I checkout until I reach the payment page as a "responsive signed in" user
    Then I should see free shipping promotion applied in "order summary"
    Then I checkout until I reach the order review page as a "signed in" user
    Then I checkout until I reach the order confirmation page as a "signed in" user
    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 5     | 6     |
      | 1614          | 3     | 4     |
      | 1615          | 1     | 2     |
     #| 1616          |1    |4    |

  @desktop_update_bag @scenario_5 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion should be applied when we increase item quantity -- Guest user
    Given I visit the web site as a guest user
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    And I checkout until I reach the shipping page as a "guest" user
    Then I should see free shipping promotion applied in "order summary"
    When I checkout until I reach the payment page as a "guest" user
    When I checkout until I reach the order review page as a "guest" user
    When I checkout until I reach the order confirmation page as a "guest" user
    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 6     | 7     |
      | 1614          | 4     | 5     |
      | 1615          | 2     | 3     |
     # | 1616          |1    |1    |

  @desktop_update_bag @scenario_6 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion should be applied when we increase item quantity -- signed in user
    Given I visit the web site as a registered user
    And I navigate to My Wallet page from My Account page
    And I add credit card to my wallet
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    When I change the cookie to "responsive"
    And I checkout until I reach the payment page as a "responsive signed in" user
    Then I should see free shipping promotion applied in "order summary"
    Then I checkout until I reach the order review page as a "signed in" user
    Then I checkout until I reach the order confirmation page as a "signed in" user
    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 6     | 7     |
      | 1614          | 4     | 5     |
      | 1615          | 2     | 3     |
     # | 1616          |1    |1    |
