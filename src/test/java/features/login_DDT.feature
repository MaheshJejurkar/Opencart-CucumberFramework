Feature: User login data driven test

  Scenario Outline: Login with valid set of data from excel
    Given User navigate to login page
    Then User should be redirected to the myaccount page by passing email and password with excel row "<Row_Index>"

    Examples: 
      | Row_Index |
      |         1 |
      |         2 |