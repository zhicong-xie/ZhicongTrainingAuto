Feature: Verify Storellet APP Wallet page function

  @AC4.1
  Scenario Outline: Select need emails address Restaurant in the Storellet wallet screen my membership view function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to left find and click <RestaurantData> Membership restaurant name in the Storellet wallet screen my membership view
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed <RestaurantData> in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see restaurant points displayed 0 in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet wallet screen
    And the user restart the APP
    Examples:
      | RestaurantData |
      | 莆田             |

  @AC4.2
  Scenario Outline: Select not need emails address Restaurant in the Storellet wallet screen my membership view function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to left find and click <RestaurantData> Membership restaurant name in the Storellet wallet screen my membership view
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed <RestaurantData> in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see restaurant points displayed 100 in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet wallet screen
    And the user restart the APP
    Examples:
      | RestaurantData |
      | 貓抓烤肉           |