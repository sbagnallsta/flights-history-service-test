@savedsearchesadmin
Feature: Saved Searches Admin - Automation
  As a user 
  I want to save searches according to the Admin UI settings 
  So that it’s easy to maintain the searches and delete invalid searches

  @savedsearchesadmin1
  Scenario Outline: Verify that user cannot save more than the number of searches configured on admin ui
    Given I am on admin ui saved searches page
    And I set the number of saved searches to "<numberSearches>"
    When I select save
    And the "<numberSearches>" should be saved

    Examples: 
      | numberSearches |
      |              1 |
      |              2 |

  @savedsearchesadmin2
  Scenario: Verify that admin user is able to make saved searches active  or inactive
    Given I am on admin ui saved searches page
    And saved searches active slider is set to No by default
    When I change it to Yes
    Then the saved searches should be active

  @savedsearchesadmin2
  Scenario: Verify that user cannot save without entering a value for number of saved searches
    Given I am on admin ui saved searches page
    When the Number of Searches is not set to any value
    Then I see the Number of Searches required message
    When I save the Saved searches page
    Then I should see Number of Searches error message
    When I select a value greater than zero
    Then I should not see Number of Searches error message
