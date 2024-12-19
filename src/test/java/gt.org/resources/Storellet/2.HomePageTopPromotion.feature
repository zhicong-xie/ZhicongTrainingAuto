Feature: Verify Storellet APP Home page function

  @AC2.1
  Scenario: Check Home page top promotion image is not null and save to local folder
    Given the user in the Storellet main screen
    When the user save the Storellet main screen big promotion image to local folder
    When the user restart the APP

  @AC2.2
  