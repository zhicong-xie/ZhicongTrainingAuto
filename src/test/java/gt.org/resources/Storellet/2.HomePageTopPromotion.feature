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
