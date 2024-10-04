Feature: User Login

  Scenario: To test login with valid credentials
    Given the user is on the ecommerce login page
    When the user enters valid credentials (username:"jejurkar.mahesh@gmail.com", password:"Mahesh@1990")
    And the user clicks on the login button
    Then the user should be redirected to the my account page
    And the user should see a welcome message