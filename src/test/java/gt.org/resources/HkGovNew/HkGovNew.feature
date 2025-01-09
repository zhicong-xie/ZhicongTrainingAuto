@AC1 @HkGoVNewHome
Feature: Verify HK Gov APP Top bar image contains correct text function

  @AC1.1
  Scenario Outline: Verify HK Gov APP Top bar image contains correct text function
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
  Scenario Outline: Verify HK Gov APP Top bar image contains correct text function
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
