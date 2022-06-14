@smoke
Feature: F01_Register | user could register and make Account
  Scenario: guest user could register with valid data successfully

    Given user enter the registration page
    When user select gender "male"
    And user enter first name "Mohamed" and last name "tester"
    And user enter date of birth
    And user enter registration email "mohamed_th2030@gmail.comm"
    And user enter company "fwd"
    And user fills Password fields "P@ssw0rd" and "P@ssw0rd"
    Then user click on register button to save data
    And user registration completed successfully