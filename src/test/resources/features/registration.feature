Feature: Account Registration

  Scenario: To validate account registration
    Given User navigate to register account page
    When User enters the details into below fields
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And User select the privacy policy
    And User clicks on continue button
    Then User account should get created successfully.