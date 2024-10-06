Feature: User login 1

  @Sanity @Regression
  Scenario: To test login with valid credentials
    Given User navigate to login page
    When User enters email as "jejurkar.mahesh@gmail.com" and password as "Mahesh@1990"
    And User clicks on login button
    Then User should be redirected to myaccount page