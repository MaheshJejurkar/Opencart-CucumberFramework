Feature: User login

  Scenario Outline: Login with valid set of data from excel
    Given user navigate to login page
    Then user should be redirected to the myaccount page by passing email and password with excel row "<Row_Index>"

    Examples: 
      | Row_Index |
      |         1 |
      |         2 |