@AC5
Feature: Verify Storellet APP Profile page function

  @AC5.1
  Scenario: Verify profile page - setting screen Logout function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Profile button in the Storellet bottom navigation bar
    Then the user in the Profile partial modal screen
    And the user able to see profile name field displayed "oTepop" in the Profile partial modal screen
    And the user able to see QR code view displayed in the Profile partial modal screen
    When the user click Setting button in the Profile partial modal screen
    Then the user in the Profile setting screen
    When the user click Back button in the Profile setting screen
    Then the user in the Profile partial modal screen
    When the user click Setting button in the Profile partial modal screen
    Then the user in the Profile setting screen
    When the user click Logout button in the Profile setting screen
    Then the user in the Confirm logout partial modal screen
    When the user click Cancel button in the Confirm logout partial modal screen
    Then the user in the Profile setting screen
    When the user click Logout button in the Profile setting screen
    Then the user in the Confirm logout partial modal screen
    When the user click Logout button in the Confirm logout partial modal screen
    Then the user in the Storellet main screen
    When the user click Profile button in the Storellet bottom navigation bar
    Then the user in the Storellet login screen
    When the user restart the APP