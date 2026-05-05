Feature: Swag Labs Web Automation

  Background:
    Given the user is on the login page

  Scenario: Verify that User Can Log In Successfully
    When the user logs in with valid credentials
    Then the user should see the Products page

  Scenario: Add products to cart and verify total price
    When the user logs in with valid credentials
    And the user adds Sauce Labs Backpack to cart
    And the user goes to cart
    Then Sauce Labs Backpack should be in the cart
    And the user continues shopping
    And the user adds Sauce Labs Bolt T-Shirt to cart
    And the user goes to cart
    Then Sauce Labs Bolt T-Shirt should be in the cart
    And the total price should be correct

  Scenario: Complete checkout successfully
    When the user logs in with valid credentials
    And the user adds Sauce Labs Backpack to cart
    And the user adds Sauce Labs Bolt T-Shirt to cart
    And the user goes to cart
    And the user proceeds to checkout
    And the user fills checkout info with valid data
    And the user finishes the order
    Then the order should be confirmed

  Scenario: Verify logout functionality
    When the user logs in with valid credentials
    Then the user should see the Products page
    And the user logs out
    Then the user should be on the login page

  Scenario: Invalid login credentials
    When the user logs in with invalid credentials
    Then an error message should appear

  Scenario: Locked out user
    When the user logs in as locked out user
    Then a locked out error message should appear

  Scenario: Checkout with missing information
    When the user logs in with valid credentials
    And the user adds Sauce Labs Backpack to cart
    And the user goes to cart
    And the user proceeds to checkout
    And the user clicks continue without filling data
    Then a missing info error message should appear

  Scenario: Remove item from cart
    When the user logs in with valid credentials
    And the user adds Sauce Labs Backpack to cart
    And the user goes to cart
    And the user removes the item from cart
    Then the cart should be empty