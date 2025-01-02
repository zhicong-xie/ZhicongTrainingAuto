@AC4
Feature: Verify Storellet APP Wallet page function

  @AC4.1
  Scenario Outline: Verify select wallet page my membership view - Need email restaurant
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to left find and click "<RestaurantData>" Membership restaurant name in the Storellet wallet screen my membership view
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
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
  Scenario Outline: Verify select wallet page my membership view - Non-need email restaurant
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to left find and click "<RestaurantData>" Membership restaurant name in the Storellet wallet screen my membership view
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
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

  @AC4.3
  Scenario Outline: Verify select wallet page my membership expand view - need email restaurant
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user click Show all restaurant button in the Storellet wallet screen my membership view
    And the user swipe to up find and click "<RestaurantData>" Membership restaurant name in the Storellet wallet screen my membership expand view
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet wallet screen
    And the user restart the APP
    Examples:
      | RestaurantData |
      | 富臨             |

  @AC4.4
  Scenario Outline: Verify select wallet page my membership expand view - Non-need email restaurant
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user click Show all restaurant button in the Storellet wallet screen my membership view
    And the user swipe to up find and click "<RestaurantData>" Membership restaurant name in the Storellet wallet screen my membership expand view
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet wallet screen
    And the user restart the APP
    Examples:
      | RestaurantData |
      | 城中泰            |

  @AC4.5
  Scenario Outline: Verify select wallet page my coupons view's Storellet Cafe restaurant and Verify existing coupon details function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to up find and click "<RestaurantData>" restaurant name in the Storellet wallet screen My coupons view
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Main bar Wallet button in the Storellet restaurant details screen
    Then the user able to see Main bar Wallet button is Selected in the Storellet restaurant details screen
    When the user select "<CouponsDescription>" Coupons description in the Storellet restaurant details screen
    Then the user in the Storellet coupon details screen
    And the user able to see Coupon title field displayed "<CouponsDescription>" in the Storellet coupon details screen
    And the user able to see QR code displayed in the Storellet coupon details screen
    When the user click Close button in the Storellet coupon details screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    When the user restart the APP
    Examples:
      | RestaurantData | CouponsDescription   |
      | Storellet Cafe | Test $10 Cash Coupon |

  @AC4.6
  Scenario Outline: Verify select wallet page my coupons view's Storellet Cafe restaurant and Verify redemption successful function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to up find and click "<RestaurantData>" restaurant name in the Storellet wallet screen My coupons view
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Main bar Redeem button in the Storellet restaurant details screen
    And the user click Skip button in the New join guidelines screen if exist
    Then the user able to see Main bar Redeem button is Selected in the Storellet restaurant details screen
    When the user select "<CouponsDescription>" Coupons description in the Storellet restaurant details screen
    Then the user in the Storellet coupon details screen
    And the user able to see Coupon title field displayed "<CouponsDescription>" in the Storellet coupon details screen
    And the user able to not see QR code displayed in the Storellet coupon details screen
    And the user able to see Coupon redeem point field displayed "0" in the Storellet coupon details screen
    When the user click Redeem button in the Storellet coupon details screen
    Then the user in the Redeem confirm partial modal screen
    When the user click Cancel button in the Coupon redeem confirm partial modal screen
    Then the user in the Storellet coupon details screen
    And the user able to see Coupon title field displayed "<CouponsDescription>" in the Storellet coupon details screen
    When the user click Redeem button in the Storellet coupon details screen
    Then the user in the Redeem confirm partial modal screen
    When the user click Confirm button in the Coupon redeem confirm partial modal screen
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Redemption success partial modal screen
    When the user click Confirm button in the Coupon redemption success partial modal screen
    Then the user in the Storellet coupon details screen
    And the user able to see Coupon title field displayed "<CouponsDescription>" in the Storellet coupon details screen
    When the user click Close button in the Storellet coupon details screen
    Then the user in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    When the user restart the APP
    Examples:
      | RestaurantData | CouponsDescription |
      | Storellet Cafe | VVIP會員套票           |

  @AC4.7
  Scenario Outline: Verify select wallet page my coupons view's Non-Storellet Cafe restaurant and Verify redemption failed function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to up find and click "<RestaurantData>" restaurant name in the Storellet wallet screen My coupons view
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Main bar Redeem button in the Storellet restaurant details screen
    And the user click Skip button in the New join guidelines screen if exist
    Then the user able to see Main bar Redeem button is Selected in the Storellet restaurant details screen
    When the user select "<CouponsDescription>" Coupons description in the Storellet restaurant details screen
    Then the user in the Storellet coupon details screen
    And the user able to see Coupon title field displayed "<CouponsDescription>" in the Storellet coupon details screen
    And the user able to not see QR code displayed in the Storellet coupon details screen
    And the user able to see Coupon redeem point field displayed "1000" in the Storellet coupon details screen
    When the user click Redeem button in the Storellet coupon details screen
    Then the user in the Redemption failed partial modal screen
    When the user click Confirm button in the Coupon redemption failed partial modal screen
    Then the user in the Storellet coupon details screen
    And the user able to see Coupon title field displayed "<CouponsDescription>" in the Storellet coupon details screen
    When the user click Close button in the Storellet coupon details screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<RestaurantData>" in the Storellet restaurant details screen
    When the user restart the APP
    Examples:
      | RestaurantData | CouponsDescription |
      | 貓抓烤肉           | 照燒雞腿肉一客            |

  @AC4.8
  Scenario Outline: Verify select wallet page my coupons view's Non-Storellet Cafe restaurant's coupons view function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to left find and click "<CouponsDescription>" coupons describe button in the Storellet wallet screen My coupons "<RestaurantData>" restaurant view
    Then the user in the Storellet coupon details screen
    And the user able to see Coupon title field displayed "<CouponsDescription>" in the Storellet coupon details screen
    And the user able to see QR code displayed in the Storellet coupon details screen
    When the user click Close button in the Storellet coupon details screen
    Then the user in the Storellet wallet screen
    When the user restart the APP
    Examples:
      | RestaurantData | CouponsDescription |
      | 爆爆鍋            | 迎新優惠：「懷念鹽酥雞」一份     |

  @AC4.9
  Scenario Outline: Verify select wallet page my coupons view's Storellet Cafe restaurant's show all coupons button function
    Given the user click Close button in the Promotion view partial modal screen if exist
    Then the user in the Storellet main screen
    When the user click Wallet button in the Storellet bottom navigation bar
    Then the user in the Storellet wallet screen
    When the user swipe to up find and click "<RestaurantData>" restaurant show all coupons button in the Storellet wallet screen My coupons view
    Then the user in the Storellet coupon details screen
    And the user able to see QR code displayed in the Storellet coupon details screen
    When the user click Close button in the Storellet coupon details screen
    Then the user in the Storellet wallet screen
    When the user restart the APP
    Examples:
      | RestaurantData |
      | Storellet Cafe |