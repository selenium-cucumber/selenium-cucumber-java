Feature: Desktop merge bag Free shipping threshold scenarios
# Pre-requisite
  #1. FST promotions should be active in respective environment
  #2. FST products test data should be available

  @desktop_merge_bag @scenario_1 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is applied when we add saved bag items to current bag
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I navigate to shopping bag page
    When I add saved items to current bag
    Then I should see free shipping promotion applied in "shopping bag"
#    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 |
      | 1490          | 6     |
      | 1614          | 4     |
      | 1615          | 2     |
     # | 1616          |1    |


  @desktop_merge_bag @scenario_2 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is applied when we add saved bag items to current bag in addition with current bag items
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    When I add saved items to current bag
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
#    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 5     | 1     |
      | 1614          | 3     | 1     |
      | 1615          | 1     | 1     |
     #| 1616          |1    |6    |

  @desktop_merge_bag @scenario_3 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is applied when we add saved bag items to current bag in addition with current bag items during checkout
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I checkout until I reach the shipping page as a "guest" user
    When I add saved items to current bag
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
#    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 5     | 5     |
      | 1614          | 1     | 6     |
      | 1615          | 1     | 6     |
     # | 1616         |1    |6|

  @desktop_merge_bag @scenario_4 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is applied when we add saved bag items to current bag along with current bag items
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    When I add saved items to current bag
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
#    Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 |
      | 1490          | 6     |
      | 1614          | 4     |
      | 1615          | 2     |
     # | 1616          |1    |

  @desktop_merge_bag @scenario_5 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is applied when we remove saved bag items with current bag items (met threshold)
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    When I remove saved bag items
    Then I should see free shipping promotion applied in "shopping bag"
   # Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 6     | 6     |
      | 1614          | 4     | 4     |
      | 1615          | 2     | 2     |
     # | 1616          |1    |1    |

  @desktop_merge_bag @scenario_6 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is removed when we remove current bag items so that threshold is not met
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    When I remove current bag items
    Then I should not see free shipping promotion applied in "shopping bag"
   # Then I should not see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 6     | 6     |
      | 1614          | 4     | 4     |
      | 1615          | 2     | 2     |
     # | 1616          |1    |1    |


  @desktop_merge_bag @scenario_7 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is not applied even when we increase saved bag items quantity
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    When I change saved item quantity to "<qty_3>"
    Then I should not see free shipping promotion applied in "shopping bag"
    # Then I should not see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 | qty_3 |
      | 1490          | 5     | 5     | 1     |
      | 1614          | 3     | 3     | 1     |
      | 1615          | 1     | 1     | 1     |
     # | 1616          |1    |6    |    |

  @desktop_merge_bag @scenario_8 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is applied when we increase current bag items quantity
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    When I set "<qty_3>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    # Then I should see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 | qty_3 |
      | 1490          | 5     | 5     | 6     |
      | 1614          | 3     | 3     | 4     |
      | 1615          | 1     | 1     | 2     |
     # | 1616          |1    |6    |    |

  @desktop_merge_bag @scenario_9 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is removed when we decrease current bag items quantity
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    When I set "<qty_3>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    Then I should not see free shipping promotion applied in "shopping bag"
    # Then I should not see "<segment_value>" free shipping promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 | qty_3 |
      | 1490          | 5     | 6     | 5     |
      | 1614          | 3     | 4     | 3     |
      | 1615          | 1     | 2     | 1     |
     # | 1616          |1    |6    |    |

  # ----------------------    Promocode in merge bag    -------------------------------

  @desktop_merge_bag @scenario_10 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is not applied when order total reduces less than threshold values after applying promocode in merge bag
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    When I apply valid promo code "VALPAK10" on shopping bag
    Then I should not see free shipping promotion applied in "shopping bag"
    #Then I should not see "<segment_value>" free shipping promotion in DB
   #And I should see "VALPAK10" promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 5     | 6     |
     # | 1614          |3    |4    |
     # | 1615          |1    |2    |
      #| 1616          |1    |6    |

  @desktop_merge_bag @scenario_11 @ab_free_shipping
  Scenario Outline: Verify that free shipping promotion is applied when order total is not less than threshold values after applying promocode in merge bag
    Given I visit the web site as a guest user
    When I click on "my account" link in the header
    And I navigate to create profile page
    And I create a new profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_1>" in the shopping bag page
    And I verify order sub total is less than "<segment_value>"
    And I close and reopen the browser
    And I visit the web site as a guest user
    And I sign in to my existing profile
    And I have "<segment_value>" for SEGMENT cookie
    And I add a "FST_product" product to my bag
    And I navigate to shopping bag page
    And I set "<qty_2>" in the shopping bag page
    And I verify order sub total is more than "<segment_value>"
    Then I should see free shipping promotion applied in "shopping bag"
    When I apply valid promo code "VALPAK10" on shopping bag
    Then I should see free shipping promotion applied in "shopping bag"
    Then I should see "<segment_value>" free shipping promotion in DB
    #And I should see "VALPAK10" promotion in DB

    Examples:
      | segment_value | qty_1 | qty_2 |
      | 1490          | 5     | 7     |
     # | 1614          |3    |5    |
      #| 1615          |1    |3    |
      #| 1616          |1    |6    |



