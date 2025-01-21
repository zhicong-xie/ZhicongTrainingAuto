@AC1 @HkGoVNewHome
Feature: Verify HK Gov New APP Home page function

  @AC1.1
  Scenario Outline: Verify HK Gov New APP Top bar Home button image contains correct text function
    Given the user in the HK Gov New Select language partial modal screen
    When the user click <LanguageOption> button in the HK Gov New Select language partial modal screen
    Then the user in the HK Gov New Home screen
    And the user able to see Top bar view Home button Image contains "<ImageText>" in the HK Gov New Home screen
    When the user reinstall the APP
    Examples:
      | LanguageOption      | ImageText |
      | English             | Home      |
      | Traditional chinese | 主頁        |
      | Simplified chinese  | 主页        |

  @AC1.2
  Scenario Outline: Verify HK Gov APP Top bar Home button image consistent with local images
    Given the user in the HK Gov New Select language partial modal screen
    When the user click <LanguageOption> button in the HK Gov New Select language partial modal screen
    Then the user in the HK Gov New Home screen
    And the user able to <Expected> Top bar view Home button Image is consistent with local images in the HK Gov New Home screen
    When the user reinstall the APP
    Examples:
      | LanguageOption      | Expected |
      | English             | not see  |
      | Traditional chinese | not see  |
      | Simplified chinese  | see      |

  @AC1.3
  Scenario: Verify HK Gov APP swipe to bottom function
    Given the user in the HK Gov New Select language partial modal screen
    When the user click English button in the HK Gov New Select language partial modal screen
    Then the user in the HK Gov New Home screen
    When the user swipe to bottom in the HK Gov New Home screen
    When the user restart the APP