Feature: Validate Logout Functionalities
  Developer - Krina
  Tester - HariKrishna

  @Smoke
  Scenario: Verify user can Logout from the application
    Given user open website
    Then verify user is on login page
    When user login with username "admin" and password "admin123"
    Then verify user is on homepage
    When user click on burger icon
    And click on logout button
    Then verify user is on login page
