Feature: Products

  Scenario: Standard User should be able to see correct amount of products
    When I Login with Standard User
    Then I should see 6 products on the Products page


  Scenario: User should see sorted products by price from low to high
    When I Login with Standard User
    When I sort products by Price (low to high)



  Scenario Outline: Standard User should see detail information about product
    When I Login with Standard User
    Then I click on <product> on the Products page
    Then I should see ProductItem Page and the name of my <product>
    And I should see the following <description>

    Examples:
      | product             | description                                                                                                                            |
      | Sauce Labs Backpack | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |



