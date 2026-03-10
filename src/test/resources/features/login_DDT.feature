Feature: User login data driven test

  Scenario Outline: Login with valid set of data from excel
    Given User navigate to login page
    Then User should be redirected to the my account page by passing email and password with TcNo "<TcNo>"
    Examples:
      | TcNo |
      | 1    |
      | 2    |