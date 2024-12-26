@AC3
Feature: Verify Storellet APP Explore page function

  @AC3.1
  Scenario Outline: Verify explore page search function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user click Search bar in the Storellet explore screen
    Then the user in the Storellet main search screen
    When the user input "<SearchData>" in the Storellet main search screen Search bar
    Then the Search result is contain "<SearchData>" data in the Storellet main search screen
    When the user click Search bar clear button in the Storellet main search screen
    Then the user in the Storellet main search screen
    When the user click navigate back button
    Then the user in the Storellet explore screen
    When the user restart the APP
    Examples:
      | SearchData |
      | 4          |
      | 子          |

  @AC3.2
  Scenario Outline: Verify select explore page search result - Non-VIP restaurant name
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user click Search bar in the Storellet explore screen
    Then the user in the Storellet main search screen
    When the user input "<SearchData>" in the Storellet main search screen Search bar
    Then the Search result is contain "<SearchData>" data in the Storellet main search screen
    When the user select first search result view in the Storellet main search screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<SearchData>" in the Storellet restaurant details screen
    And the user able to see New join button in the Storellet restaurant details screen
    And the user able to not see More details button in the Storellet restaurant details screen
    And the user able to not see Restaurant points field in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click New join button in the Storellet restaurant details screen
    Then the user in the Membership terms and conditions screen
    And the user able to not see email input box in the Membership terms and conditions screen
    And the user able to see Agree button is disabled in the Membership terms and conditions screen
    When the user click Disagree button in the Membership terms and conditions screen
    Then the user in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet main search screen
    And the Search result is contain "<SearchData>" data in the Storellet main search screen
    When the user restart the APP
    Examples:
      | SearchData |
      | 哆啦         |

  @AC3.3
  Scenario Outline: Verify select explore page search result - VIP restaurant name
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user click Search bar in the Storellet explore screen
    Then the user in the Storellet main search screen
    When the user input "<SearchData>" in the Storellet main search screen Search bar
    Then the Search result is contain "<SearchData>" data in the Storellet main search screen
    When the user select first search result view in the Storellet main search screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<SearchData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
#    And the user able to see restaurant points displayed "0" in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet main search screen
    And the Search result is contain "<SearchData>" data in the Storellet main search screen
    When the user restart the APP
    Examples:
      | SearchData |
      | Rico       |

  @AC3.4
  Scenario Outline: Verify select explore page new arrivals view - Non-VIP restaurant name
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user swipe left to click "<RestaurantData>" restaurant name in the Storellet explore screen new arrivals view
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to see New join button in the Storellet restaurant details screen
    And the user able to not see More details button in the Storellet restaurant details screen
    And the user able to not see Restaurant points field in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Redeem button is displayed in the Storellet restaurant details screen
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
  Scenario Outline: Verify select explore page new arrivals view - VIP restaurant name
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user swipe left to click "<RestaurantData>" restaurant name in the Storellet explore screen new arrivals view
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
#    And the user able to see restaurant points displayed "0" in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet explore screen
    When the user restart the APP
    Examples:
      | RestaurantData |
      | 莆田             |

  @AC3.6
  Scenario Outline: Verify select explore page all restaurant list view - non-VIP restaurant name
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user swipe up to click "<RestaurantData>" restaurant become member button in the Storellet explore screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to see New join button in the Storellet restaurant details screen
    And the user able to not see More details button in the Storellet restaurant details screen
    And the user able to not see Restaurant points field in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Redeem button is displayed in the Storellet restaurant details screen
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
      | 牛牛日式           |

  @AC3.7
  Scenario Outline: Verify select explore page all restaurant list view - VIP restaurant name
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Explore button in the Storellet bottom navigation bar
    Then the user in the Storellet explore screen
    When the user swipe up to get "<RestaurantData>" member restaurant info and click in the Storellet explore screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see restaurant points is align Explore page info in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is Unselected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Main bar Wallet button in the Storellet restaurant details screen
    Then the user able to see Main bar Wallet button is Selected in the Storellet restaurant details screen
    And the user able to see restaurant coupons list size is align Explore page info in the Storellet restaurant details screen
    #coupons list not had identification mark, If the data needs to swipe, it is impossible to determine whether it has slid to the bottom
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet explore screen
    When the user restart the APP
    Examples:
      | RestaurantData |
      | 貓抓烤肉           |