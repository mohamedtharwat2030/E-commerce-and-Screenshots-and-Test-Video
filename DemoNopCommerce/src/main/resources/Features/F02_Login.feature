@smoke
Feature: F02_Login | user should be able to login the system

  Scenario:guest user could Login with valid credentials

    When user navigate to login page
    And user enter "mohamed_th2030@gmail.comm" and "P@ssw0rd"
    Then user click on login button
    And user login successfully and go to home page


  Scenario:guest user could Login with invalid credentials

    When user navigate to login page
    And user enter "test@gmail.com" and "P@ssw0rd"
    Then user click on login button
    And user could not login successfully and go to home page