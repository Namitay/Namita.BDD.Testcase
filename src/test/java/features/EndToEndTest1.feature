Feature: End to end Scenario

  Scenario: Create an order with multiple products

    Given I am in homepage
    When I click on login link from nav bar
    Then  I should be navigated to login page
    When I enter login details
      |email|password|
      |ny@gmail.com|timh123|

    And    I click on login button
    Then  I should be logged in successfully
    When  I add item in to the cart
    And  I add another item to the cart
    And  I go the cart
    And   I click on terms of service
    And   I checkout as a existing user
    And   I click on first continue
    And   I click on second continue
    And  I click on continue third again
    And  I click on continue fourth time
    And  I click on confirm
    Then I should see the order confirmation message