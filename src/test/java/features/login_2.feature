Feature: User login 2

  @Regression
  Scenario Outline: To test login with valid set of credentials
    Given User navigate to login page
    When User enters email as "<Email>" and password as "<Password>"
    And User clicks on login button
    Then User should be redirected to myaccount page

    Examples: 
      | Email                     | Password    |
      | jejurkar.mahesh@gmail.com | Mahesh@1990 |
      | abc.xyz@jollyfree.com     | abc@xyzz     |