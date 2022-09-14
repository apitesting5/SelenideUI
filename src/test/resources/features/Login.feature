Feature: Login

  Scenario: User should be able to see login page
    When I visit https://www.saucedemo.com/ site
    Then I should see logo element on the login page
    And I should see login button element on the login page


  Scenario Outline: Users should be able to login with accepted credentials
    When I visit https://www.saucedemo.com/ site
    Then I should see logo element on the login page
    When I fill login page with next data:
      | userName   | password   |
      | <userName> | <password> |
    And I press login button on the login page
    Then I should see Products page
    And I should not see login button element on the login page

    Examples:
      | userName                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |


  Scenario Outline: User should not be able to login with not accepted credentials
    When I visit https://www.saucedemo.com/ site
    Then I should see logo element on the login page
    When I fill login page with next data:
      | userName   | password   |
      | <userName> | <password> |
    And I press login button on the login page
    Then I should see '<errorMessage>' error message below password field on the login page

    Examples:
      | userName                  | password      | errorMessage                                                              |
      | dfsdf                     | dsfkjsd       | Epic sadface: Username and password do not match any user in this service |
      | standard_user             | secret_sauce1 | Epic sadface: Username and password do not match any user in this service |
      | problem_user1             | secret_sauce  | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user           | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
      | performance_glitch_user23 | secret_2sauce | Epic sadface: Username and password do not match any user in this service |


