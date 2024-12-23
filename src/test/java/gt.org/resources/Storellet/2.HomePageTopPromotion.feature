Feature: Verify Storellet APP Home page function

  @AC2.1
  Scenario: Check Home page top promotion image is not null and save to local folder
    Given the user in the Storellet main screen
    When the user save the Storellet main screen big promotion image to local folder
    And the user restart the APP

  @AC2.2
  Scenario Outline: Check Home page search button function
    Given the user in the Storellet main screen
    When the user click Search icon in the Storellet main screen
    Then the user in the Storellet main search screen
    When the user input <SearchData> in the Storellet main search screen Search bar
    Then the Search result is contain <SearchData> data in the Storellet main search screen
    When the user click Search bar clear button in the Storellet main search screen
    And the user restart the APP
    Examples:
      | SearchData |
      | 牛          |
      | 永          |

  @AC2.3
  Scenario Outline: Check Click Shops view in Home page and join the shops by not need email address
    Given the user in the Storellet main screen
    When the user select <ShopsName> shops in the Storellet main screen
    Then the user in the Storellet shops details screen
    And the user able to see shops name displayed <ShopsName> in the Storellet shops details screen
    And the user able to see New join button in the Storellet shops details screen
    And the user able to not see More details button in the Storellet shops details screen
    When the user click New join button in the Storellet shops details screen
    Then the user in the Membership terms and conditions screen
    And the user able to not see email input box in the Membership terms and conditions screen
    And the user able to see Agree button is disabled in the Membership terms and conditions screen
    When the user click Disagree button in the Membership terms and conditions screen
    Then the user in the Storellet shops details screen
    When the user click New join button in the Storellet shops details screen
    Then the user in the Membership terms and conditions screen
    When the user swipe up until Agree button is enabled in the Membership terms and conditions screen
    Then the user able to see Agree button is enabled in the Membership terms and conditions screen
    When the user click Agree button in the Membership terms and conditions screen
    Then the user able to see the New join guidelines screen
    When the user click Skip button in the New join guidelines screen if exist
    Then the user able to not see the New join guidelines screen
    And the user in the Storellet shops details screen
    And the user able to not see New join button in the Storellet shops details screen
    And the user able to see More details button in the Storellet shops details screen
    When the user click Back button in the Storellet shops details screen
    Then the user in the Storellet main screen
    When the user restart the APP
    Examples:
      | ShopsName |
      | Rico Rico |

  @AC2.4
  Scenario Outline: Check Click Shops view in Home page and join the shops by need email address
    Given the user in the Storellet main screen
    When the user select <ShopsName> shops in the Storellet main screen
    Then the user in the Storellet shops details screen
    And the user able to see shops name displayed <ShopsName> in the Storellet shops details screen
    And the user able to see New join button in the Storellet shops details screen
    And the user able to not see More details button in the Storellet shops details screen
    When the user click New join button in the Storellet shops details screen
    Then the user in the Membership terms and conditions screen
    And the user able to see email input box in the Membership terms and conditions screen
    And the user able to see Agree button is disabled in the Membership terms and conditions screen
    When the user input <WrongFormatEmailAddress> in the Membership terms and conditions screen email address input box
    And the user swipe up until Agree button is enabled in the Membership terms and conditions screen
    Then the user able to see Agree button is enabled in the Membership terms and conditions screen
    When the user click Agree button in the Membership terms and conditions screen
    Then the user in the Membership terms and conditions screen incorrect email format partial modal
    When the user click Confirm button in the Membership terms and conditions screen incorrect email format partial modal
    Then the user in the Membership terms and conditions screen
    And the user able to see Agree button is enabled in the Membership terms and conditions screen
    When the user click Disagree button in the Membership terms and conditions screen
    Then the user in the Storellet shops details screen
    When the user click New join button in the Storellet shops details screen
    Then the user in the Membership terms and conditions screen
    When the user input <EmailAddress> in the Membership terms and conditions screen email address input box
    And the user swipe up until Agree button is enabled in the Membership terms and conditions screen
    Then the user able to see Agree button is enabled in the Membership terms and conditions screen
    When the user click Agree button in the Membership terms and conditions screen
    And the user click Skip button in the New join guidelines screen if exist
    Then the user in the Verify email address partial modal screen
    And the user able to see email address field displayed <EmailAddress> in the Verify email address partial modal screen
    When the user click Ignore button in the Verify email address partial modal screen
    Then the user able to not see the New join guidelines screen
    And the user in the Storellet shops details screen
    And the user able to not see New join button in the Storellet shops details screen
    And the user able to see More details button in the Storellet shops details screen
    When the user click Back button in the Storellet shops details screen
    Then the user in the Storellet main screen
    When the user restart the APP
    Examples:
      | ShopsName | WrongFormatEmailAddress | EmailAddress |
      | 富臨        | 123123.com              | AT@Test.com  |

  @AC2.5
  Scenario Outline: Check update email and Verification sent function
    Given the user in the Storellet main screen
    When the user select <ShopsName> shops in the Storellet main screen
    Then the user in the Verify email address partial modal screen
    And the user able to see email address field displayed <EmailAddress> in the Verify email address partial modal screen
    When the user click Change email address button in the Verify email address partial modal screen
    Then the user in the Update email address partial modal screen
    And the user able to see email address field displayed <EmailAddress> in the Update email address partial modal screen
    And the user able to see Update button is disabled in the Update email address partial modal screen
    When the user input <WrongFormatEmailAddress> in the Update email address partial modal screen email address input box
    Then the user able to see email address field displayed <WrongFormatEmailAddress> in the Update email address partial modal screen
    And the user able to see Update button is disabled in the Update email address partial modal screen
    When the user input <UpdateEmailAddress> in the Update email address partial modal screen email address input box
    Then the user able to see email address field displayed <UpdateEmailAddress> in the Update email address partial modal screen
    And the user able to see Update button is enabled in the Update email address partial modal screen
    When the user click Update button in the Update email address partial modal screen email address input box
    Then the user in the Verification sent partial modal screen
    And the user able to see email address field displayed <UpdateEmailAddress> in the Verification sent partial modal screen
    When the user click Done button in the Verification sent partial modal screen
    Then the user in the Storellet shops details screen
    And the user able to see shops name displayed <ShopsName> in the Storellet shops details screen
    And the user able to not see New join button in the Storellet shops details screen
    And the user able to see More details button in the Storellet shops details screen
    When the user restart the APP
    Examples:
      | ShopsName | EmailAddress | WrongFormatEmailAddress | UpdateEmailAddress |
      | 富臨        | AT@Test.com  | 123123.com              | TestNG@Test.com    |

  @AC2.6
  Scenario Outline: Check Verification sent function
    Given the user in the Storellet main screen
    When the user select <ShopsName> shops in the Storellet main screen
    Then the user in the Verify email address partial modal screen
    And the user able to see email address field displayed <UpdateEmailAddress> in the Verify email address partial modal screen
    When the user click Verification send button in the Verify email address partial modal screen
    Then the user in the Verification sent partial modal screen
    And the user able to see email address field displayed <UpdateEmailAddress> in the Verification sent partial modal screen
    When the user click Done button in the Verification sent partial modal screen
    Then the user in the Storellet shops details screen
    And the user able to see shops name displayed <ShopsName> in the Storellet shops details screen
    And the user able to not see New join button in the Storellet shops details screen
    And the user able to see More details button in the Storellet shops details screen
    When the user restart the APP
    Examples:
      | ShopsName | UpdateEmailAddress |
      | 富臨        | TestNG@Test.com    |