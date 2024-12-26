Feature: Verify Storellet APP Login function

  Scenario: the user first open Storellet APP and go to Login page
    Given the user click Close button in the Promotion view partial modal screen if exist
    When the user click Close button in the Update notification partial modal screen if exist
    Then the user in the Storellet introduction screen
    When the user swipe to left click next button in the Storellet introduction screen
    Then the user able to see the Storellet navigation dialog fragment view
    When the user click Explore bubble in the Storellet navigation dialog fragment view
    And the user click Membership bubble in the Storellet navigation dialog fragment view
    And the user click Wallet bubble in the Storellet navigation dialog fragment view
    And the user click Profile bubble in the Storellet navigation dialog fragment view
    And the user click Scanner bubble in the Storellet navigation dialog fragment view
    And the user click Notice bubble in the Storellet navigation dialog fragment view
    Then the user able to not see the Storellet navigation dialog fragment view
    And the user in the Storellet main screen
    When the user click Close button in the Promotion view partial modal screen if exist
    And the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet login screen
    And the International area code able displayed "852" in the Storellet login screen

  Scenario Outline: Login failed By using wrong data
    Given the user in the Storellet login screen
    When the user click International area code button in the Storellet login screen
    Then the user in the Select area code partial modal
    When the user select "<AreaCode>" International area code in the Storellet login screen area code partial modal
    Then the International area code able displayed "<AreaCode>" in the Storellet login screen
    When the user input "<PhoneNumber>" in the Storellet login screen Phone number input box
    And the user input "<Password>" in the Storellet login screen Password input box
    And the user click Confirm button in the Storellet login screen
    Then the user in the Incorrect information partial modal
    When the user click Confirm button in the Incorrect information partial modal
    Examples:
      | AreaCode | PhoneNumber | Password     |
      | 86       | 18318414197 | Abc123       |
      | 852      | 99998031    | Testing!234  |
      | 852      | 99998039    | Testing!2345 |
      | 853      | 99998039    | Testing!234  |

  Scenario Outline: Login successfully with correct data
    Given the user in the Storellet login screen
    When the user click International area code button in the Storellet login screen
    Then the user in the Select area code partial modal
    When the user select "<AreaCode>" International area code in the Storellet login screen area code partial modal
    Then the International area code able displayed "<AreaCode>" in the Storellet login screen
    When the user input "<PhoneNumber>" in the Storellet login screen Phone number input box
    And the user input "<Password>" in the Storellet login screen Password input box
    And the user click Confirm button in the Storellet login screen
    Then the user in the Storellet wallet screen
    When the user click Home button in the Storellet bottom navigation bar
    Then the user in the Storellet main screen
    When the user restart the APP
    Examples:
      | AreaCode | PhoneNumber | Password    |
      | 852      | 99998039    | Testing!234 |