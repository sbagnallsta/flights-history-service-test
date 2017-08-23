Feature: Verifying admin user can login onto admin UI.

  @Login @Smoke
  Scenario: Admin user can login with valid credentials
    Given I am on the login page
    When I log in
    Then I should be redirected to the home page
