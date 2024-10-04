Feature: Account Registration

  Scenario: To validate account registration
    Given user navigate to register account page
    When user enters the details into below fields
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And user select the privacy policy
    And user clicks on continue button
    Then user account should get created successfully.