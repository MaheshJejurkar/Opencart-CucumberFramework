Feature: User login

  @sanity @regression
  Scenario: To test login with valid credentials
    Given user navigate to login page
    When user enters email as "jejurkar.mahesh@gmail.com" and password as "Mahesh@1990"
    And user clicks on login button
    Then user should be redirected to the myaccount page

  @regression
  Scenario Outline: To test login with valid set of credentials
    Given user navigate to login page
    When user enters email as "<Email>" and password as "<Password>"
    And user clicks on login button
    Then user should be redirected to the myaccount page

    Examples: 
      | Email                     | Password    |
      | abc.xyz@jollyfree.com     | abc@xyz     |
      | jejurkar.mahesh@gmail.com | Mahesh@1990 |
