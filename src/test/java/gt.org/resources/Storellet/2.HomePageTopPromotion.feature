Feature: Verify Storellet APP Home page top promotion function

    Scenario: Check Home page first big promotion image is not null and save to local folder
    Given the user in the Storellet main screen
    Then the first big promotion image is not null in the Storellet main screen
    When the user save the Storellet main screen first big promotion image to local folder
    When the user restart the APP