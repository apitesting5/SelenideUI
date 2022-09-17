Feature: Add_Product

  Scenario Outline: User should be able to add product to the basket
    When I Login with Standard User
    Then I take <nameOfProduct> and press Add to Cart button on the Products Page
    And I should see Remove button except Add to Cart button
    Then I press Basket Icon on the Products page
    And I should see Basket Page
    And I should see the availability of <nameOfProduct> on the Basket page

    Examples:
      | nameOfProduct       |
      | Sauce Labs Backpack |


