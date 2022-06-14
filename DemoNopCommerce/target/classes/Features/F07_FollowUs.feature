@smoke
Feature: F07_followUs | users could open followUs links
  Scenario: user open facebook link
    When user scroll down and choose "facebook"
    Then open new tab of "facebook"

  Scenario: user open twitter link
    When user scroll down and choose "twitter"
    Then open new tab of "twitter"

  Scenario: user open rss link
    When user scroll down and choose "rss"
    Then open new tab of "rss"

  Scenario: user open youtube link
    When user scroll down and choose "youtube"
    Then open new tab of "youtube"