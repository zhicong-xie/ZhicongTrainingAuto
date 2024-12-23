Feature: Verify Storellet APP Explore page function

  @AC3.1
  Scenario Outline: Check Explore page search function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user click Search bar in the Storellet explore screen
    Then the user in the Storellet main search screen
    When the user input <SearchData> in the Storellet main search screen Search bar
    Then the Search result is contain <SearchData> data in the Storellet main search screen
    When the user click Search bar clear button in the Storellet main search screen
    Then the user in the Storellet main search screen
    When the user dismiss keyboard
    Then the user in the Storellet explore screen
    When the user restart the APP
    Examples:
      | SearchData |
      | 4          |
      | 子          |

  @AC3.2
  Scenario Outline: Check Explore page select search result function is Non-VIP
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user click Search bar in the Storellet explore screen
    Then the user in the Storellet main search screen
    When the user input <SearchData> in the Storellet main search screen Search bar
    Then the Search result is contain <SearchData> data in the Storellet main search screen
    When the user select first search result view in the Storellet main search screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed <SearchData> in the Storellet restaurant details screen
    And the user able to see New join button in the Storellet restaurant details screen
    And the user able to not see More details button in the Storellet restaurant details screen
    And the user able to not see Restaurant points field in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    When the user click New join button in the Storellet restaurant details screen
    Then the user in the Membership terms and conditions screen
    And the user able to not see email input box in the Membership terms and conditions screen
    And the user able to see Agree button is disabled in the Membership terms and conditions screen
    When the user click Disagree button in the Membership terms and conditions screen
    Then the user in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet main search screen
    And the Search result is contain <SearchData> data in the Storellet main search screen
    When the user restart the APP
    Examples:
      | SearchData |
      | 哆啦         |

  @AC3.3
  Scenario Outline: Check Explore page select search result function is VIP
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user click Search bar in the Storellet explore screen
    Then the user in the Storellet main search screen
    When the user input <SearchData> in the Storellet main search screen Search bar
    Then the Search result is contain <SearchData> data in the Storellet main search screen
    When the user select first search result view in the Storellet main search screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed <SearchData> in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see restaurant points displayed 0 in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet main search screen
    And the Search result is contain <SearchData> data in the Storellet main search screen
    When the user restart the APP
    Examples:
      | SearchData |
      | Rico       |

  @AC3.4
  Scenario Outline: Check Explore page swipe left find non-VIP restaurant in Storellet explore screen new arrivals view
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user swipe left to click <RestaurantData> restaurant name in the Storellet explore screen new arrivals view
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed <RestaurantData> in the Storellet restaurant details screen
    And the user able to see New join button in the Storellet restaurant details screen
    And the user able to not see More details button in the Storellet restaurant details screen
    And the user able to not see Restaurant points field in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    When the user click New join button in the Storellet restaurant details screen
    Then the user in the Membership terms and conditions screen
    And the user able to not see email input box in the Membership terms and conditions screen
    And the user able to see Agree button is disabled in the Membership terms and conditions screen
    When the user click Disagree button in the Membership terms and conditions screen
    Then the user in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet explore screen
    When the user restart the APP
    Examples:
      | RestaurantData |
      | 日之超市           |

  @AC3.5
  Scenario Outline: Check Explore page swipe left find VIP restaurant in Storellet explore screen new arrivals view
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user swipe left to click <RestaurantData> restaurant name in the Storellet explore screen new arrivals view
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed <RestaurantData> in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see restaurant points displayed 0 in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet explore screen
    When the user restart the APP
    Examples:
      | RestaurantData |
      | 莆田      |