Feature: Login User

  Scenario: User valid Login
    When user go to login page
    And user enter username and password
    And user click button login
    Then go to page valid login