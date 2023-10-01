Feature: test login page features

  @mySmokeTest
  Scenario: verify login failed message
    Given enter user name ""
    When enter password ""
    And click on login button
    Then verify error message "The email address or mobile number you entered is not connected to an account. "