@Transfer
Feature: Transfer module -B2B Automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Transfer section
  So that I can manage Transfer details displayed on payment form

  @Transfer1
  Scenario: Verify Transfer section must have Transfer details when it is active
    Given I am on Payment Form Details page
    When I activate Transfer section
    Then I should see a Transfer required message
    When I add a new Transport
    Then I should not see a Transfer required message
    And I should see the new Transport on the Transfer section
    When I disable the new transport
    Then I should see a Transfer required message
    When I add second Transport
    Then I should see second Transport on the Transfer section
    Then I should not see a Transfer required message

  @Transfer2 @Regression
  Scenario: Verify admin user cannot save Transfer details without filling the required fields
    Given I am on Payment Form Details page
    And I select add new Transfer
    Then I should be on Transfer Page
    And I should see transfer details required messages
    When I save Transfer details page without entering data in the required fields
    Then I should see warning messages for require fields

  @Transfer3 @Regression @Smoke
  Scenario: Verify admin user can edit Transfer details
    Given I am on Payment Form Details page
    When I activate Transfer section
    And I add a new Transport
    Then I should see the new Transport on the Transfer section
    When I edit the details of the new Transport
    And I cancel changes on Transfer page
    Then I should not see the new Transport on the Transfer section
    When I edit the details of the new Transport
    And I select save on Transfer page
    Then I should see the edited Transport on the Transfer section
