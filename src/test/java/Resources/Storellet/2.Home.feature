@AC2
Feature: Verify Storellet APP Home page function

  @AC2.1 @image
  Scenario: Verify Home page top promotion image is not null and save in local
    Given the user in the Storellet main screen
    When the user save the Storellet main screen big promotion image to local folder
    And the user restart the APP

  @AC2.2
  Scenario Outline: Verify home page search function
    Given the user in the Storellet main screen
    When the user click Search icon in the Storellet main screen
    Then the user in the Storellet main search screen
    When the user input "<SearchData>" in the Storellet main search screen Search bar
    Then the Search result is contain "<SearchData>" data in the Storellet main search screen
    When the user restart the APP
    Examples:
      | SearchData |
      | 牛          |
      | 永          |

  @AC2.3
  Scenario: Verify Home page become restaurant member function
    Given the user in the Storellet main screen
    When the user click Join button in the Storellet main screen
    Then the user in the Storellet restaurant details screen
    And the user able to see New join button in the Storellet restaurant details screen
    And the user able to not see More details button in the Storellet restaurant details screen
    And the user able to not see Restaurant points field in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to not see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click New join button in the Storellet restaurant details screen
    Then the user in the Membership terms and conditions screen
    And the user able to see Agree button is disabled in the Membership terms and conditions screen
    When the user click Disagree button in the Membership terms and conditions screen
    Then the user in the Storellet restaurant details screen
    When the user click New join button in the Storellet restaurant details screen
    Then the user in the Membership terms and conditions screen
    When the user input "AT@Test.com" in the Membership terms and conditions screen email address input box if exist
    And the user swipe up until Agree button is enabled in the Membership terms and conditions screen
    Then the user able to see Agree button is enabled in the Membership terms and conditions screen
    When the user click Agree button in the Membership terms and conditions screen
    Then the user in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see restaurant points displayed "0" in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet main screen
    When the user restart the APP

  @AC2.4 @email
  Scenario Outline: Verify Home page Member email verification function
    Given the user in the Storellet main screen
    When the user click Search icon in the Storellet main screen
    Then the user in the Storellet main search screen
    When the user input "<restaurantName>" in the Storellet main search screen Search bar
    Then the Search result is contain "<restaurantName>" data in the Storellet main search screen
    When the user select first search result view in the Storellet main search screen
    Then the user in the Verify email address partial modal screen
    And the user able to see email address field displayed "<UpdateEmailAddress>" in the Verify email address partial modal screen
    When the user click Verification send button in the Verify email address partial modal screen
    Then the user in the Verification sent partial modal screen
    And the user able to see email address field displayed "<UpdateEmailAddress>" in the Verification sent partial modal screen
    When the user click Done button in the Verification sent partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<restaurantName>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user click Back button in the Storellet restaurant details screen
    Then the user in the Storellet main search screen
    And the Search result is contain "<restaurantName>" data in the Storellet main search screen
    When the user restart the APP
    Examples:
      | restaurantName | UpdateEmailAddress |
      | 富臨             | AT@Test.com        |

  @AC2.5 @email
  Scenario Outline: Verify Home page Change member email function
    Given the user in the Storellet main screen
    When the user select "<restaurantName>" restaurant in the Storellet main screen
    Then the user in the Verify email address partial modal screen
    And the user able to see email address field displayed "<EmailAddress>" in the Verify email address partial modal screen
    When the user click Change email address button in the Verify email address partial modal screen
    Then the user in the Update email address partial modal screen
    And the user able to see email address field displayed "<EmailAddress>" in the Update email address partial modal screen
    And the user able to see Update button is disabled in the Update email address partial modal screen
    When the user input "<WrongFormatEmailAddress>" in the Update email address partial modal screen email address input box
    Then the user able to see email address field displayed "<WrongFormatEmailAddress>" in the Update email address partial modal screen
    And the user able to see Update button is disabled in the Update email address partial modal screen
    When the user input "<UpdateEmailAddress>" in the Update email address partial modal screen email address input box
    Then the user able to see email address field displayed "<UpdateEmailAddress>" in the Update email address partial modal screen
    And the user able to see Update button is enabled in the Update email address partial modal screen
    When the user click Update button in the Update email address partial modal screen email address input box
    Then the user in the Verification sent partial modal screen
    And the user able to see email address field displayed "<UpdateEmailAddress>" in the Verification sent partial modal screen
    When the user click Done button in the Verification sent partial modal screen
    Then the user in the Storellet restaurant details screen
    And the user able to see restaurant name displayed "<restaurantName>" in the Storellet restaurant details screen
    And the user able to not see New join button in the Storellet restaurant details screen
    And the user able to see More details button in the Storellet restaurant details screen
    And the user able to see Main bar Summary button is Selected in the Storellet restaurant details screen
    And the user able to not see Main bar Welcome gift button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Wallet button is displayed in the Storellet restaurant details screen
    And the user able to see Main bar Redeem button is displayed in the Storellet restaurant details screen
    When the user restart the APP
    Examples:
      | restaurantName | EmailAddress    | WrongFormatEmailAddress | UpdateEmailAddress |
      | 富臨             | AT@Test.com     | 123123.com              | TestNG@Test.com    |
      | 富臨             | TestNG@Test.com | 123123.com              | AT@Test.com        |

  @AC2.6 @image
  Scenario: Verify Home page first top promotion image text displayed correct
    Given the user in the Storellet main screen
    Then the user able to see First big promotion image text contains "12種好食材‧會員優惠8折" in the Storellet main screen
    When the user restart the APP

  @AC2.7 @image
  Scenario: Verify Home page first top promotion image consistent with local images
    Given the user in the Storellet main screen
    Then the user able to see First big promotion image consistent with local images
    When the user restart the APP

  @AC2.8 @image
  Scenario: Verify Home page first top promotion image consistent with local images
    Given the user in the Storellet main screen
    Then the user able to see local images contains in the Storellet main screen First big promotion image
    When the user restart the APP