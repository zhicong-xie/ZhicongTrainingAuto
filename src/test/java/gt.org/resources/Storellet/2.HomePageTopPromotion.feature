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
  Scenario Outline: Check Click Shops view in Home page and join this shps
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
    Then the user in the Storellet shops details screen
    And the user able to not see New join button in the Storellet shops details screen
    And the user able to see More details button in the Storellet shops details screen
    When the user click Back button in the Storellet shops details screen
    Then the user in the Storellet main screen
    When the user restart the APP
    Examples:
      | ShopsName |
      | 爆爆鍋       |