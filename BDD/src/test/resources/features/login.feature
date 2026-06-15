Feature: Login

  Scenario Outline: Valid login
    Given User is on login page
    When User logs in with "<username>" and "<password>"
    Then User should be redirected to home page

    Examples:
      | username   | password    |
      | student    | Password123 |
