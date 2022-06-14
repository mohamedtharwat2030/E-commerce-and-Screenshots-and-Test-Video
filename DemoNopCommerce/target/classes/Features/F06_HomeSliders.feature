@smoke
Feature: F06_homeSliders | users will be able to open sliders in home page
  Scenario: user could open first slider
    When enter slider number "1"
    And user go to first slider detail page



    Scenario: user could open second slider
      When enter slider number "2"
      And user go to second slider detail page
