Feature: Validate Login Functionalities
  Developer - Krina
  Tester - Priya

  Background: 
    Given user open website
    Then verify user is on login page

  @Smoke @Chirag
  Scenario: Verify user can login with valid credentials
    When user login with username "admin" and password "admin123"
    Then verify user is on homepage

  @Regression @Krina
  Scenario Outline: Verify user cannot login with invalid credentials
    When user login with username "<username>" and password "<password>"
    Then verify invalid login error message is displayed

    Examples: 
      | username  | password  |
      | wronguser | wrongpass |
      | ADMIN     | admin123  |
      |           |           |
      | admin     | admin     |

  @Smoke @Chirag
  Scenario: Verify dropdown option
    When user login with username "admin" and password "admin123"
    Then verify user is on homepage
    Then verify user can see below dropdown option
      | admin  |
      | user   |
      | system |
      | laptop |
