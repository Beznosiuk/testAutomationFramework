@smoke
Feature: Login

  Scenario: User can login
    Given login page is opened
    When user enter login and password
    And user click "Sign in" button
    Then home page is opened
    And  user logout
