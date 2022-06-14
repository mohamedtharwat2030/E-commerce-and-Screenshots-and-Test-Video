@smoke
Feature:  F03_Currencies | User can change Currencies
  Scenario: guest user could switch between currencies [$, €]
    When User enter Currencies list and select Euro [€]
    Then Euro Symbol [€] is displayed in Home page products