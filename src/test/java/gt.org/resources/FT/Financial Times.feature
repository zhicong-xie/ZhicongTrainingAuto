Feature: Zhicong Week 2 Practice assignment

  @AC1
  Scenario: the user opens the TF APP for the first time, Verify skipping login
    Given the user reset and launch the APP
    Then the user in the Cookies on FT sites screen
    When the user click Accept Cookies button in the Cookies on FT sites screen
    Then the user in the FT login option screen
    When the user click Not now button in FT login option screen
    Then the user in the FT Top Stories screen
    When the user restart the APP

  @AC2
  Scenario Outline: the user is not opening the app for the first time, Verify select stories function
    Given the user in the FT Top Stories screen
    When the user select <TextContent> stories in the FT Top Stories screen
    Then the user in the FT Stories details screen
    And the user able to <TextContent> text content in the FT Stories details screen
    When the user click Back in the FT Stories details screen
    Then the user in the FT Top Stories screen
    When the user restart the APP
    Examples:
      | TextContent             |
      | Assad dispatched $250mn |
    #Please update the newer TextContent, or increase the number of swipe

  @AC3
  Scenario Outline: the user is not opening the app for the first time, Verify Search function
    Given the user in the FT Top Stories screen
    When the user click Menu navigation button in the FT Top Stories screen
    Then the user in the Menu navigation view
    When the user click Search button in FT login option screen
    Then the user in the Search result default screen
#    And the user able to see search history in the Search result screen
    And the user able to not see search history in the Search result screen
    When the user input <SearchData> in the Search result screen Search input box
    Then the user able to see search result in the Search result screen
    And the user verification search result contains <SearchData> in the Search result screen
    When the user select first search result in the Search result screen
    Then the user in the FT Stories details screen
    And the user able to <SearchData> text content in the FT Stories details screen
    When the user click Back in the FT Stories details screen
    Then the user in the FT Top Stories screen
    When the user click Menu navigation button in the FT Top Stories screen
    Then the user in the Menu navigation view
    When the user click Search button in FT login option screen
    Then the user in the Search result default screen
    And the user able to see search history in the Search result screen
    When the user select first search history in the Search result screen
    Then the user able to see search result in the Search result screen
    When the user click Clear input box in the Search result screen
    Then the user in the Search result default screen
    When the user restart the APP
    Examples:
      | SearchData                                     |
      | TikTok loses bid for emergency halt to looming |

  @AC4
  Scenario: the user is not opening the app for the first time, Verify the status of the Notifications screen checkbox
    Given the user in the FT Top Stories screen
    When the user click Menu navigation button in the FT Top Stories screen
    Then the user in the Menu navigation view
    When the user click Notifications button in FT login option screen
    Then the user in the Notifications screen
    When the user turn on switch button in the Notifications screen if is off state
    And the user able to see Breaking news check box status is checked in the Notifications screen
    And the user able to see Highlights check box status is checked in the Notifications screen
    And the user able to see Recommended for you check box status is not checked in the Notifications screen
    And the user able to see Morning briefing check box status is checked in the Notifications screen
    And the user able to see myFT Instant Alerts check box status is not checked in the Notifications screen
    And the user able to see FT News Briefing podcast check box status is checked in the Notifications screen
    And the user able to see FT Weekend podcast check box status is checked in the Notifications screen
    When the user click FT Weekend podcast check box in the Notifications screen
    Then the user able to see FT Weekend podcast check box status is not checked in the Notifications screen
    When the user click FT Weekend podcast check box in the Notifications screen
    Then the user able to see FT Weekend podcast check box status is checked in the Notifications screen
    When the user quit the APP