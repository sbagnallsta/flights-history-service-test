@Others @Regression
Feature: Others module -B2B Automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Others section
  So that I can manage Others details displayed on payment form

  @Others1 
  Scenario: Verify admin user can add new Others
    Given I am on Payment Form Details page
    When I activate Others section
    Then I should see Others required message
    When I select Add New for Others
    Then I should not see Others required message
    And I should see Product required messages for Others
    When I fill product details for Others
    Then I should not see Product required messages for Others

  @Others2 
  Scenario: Verify when admin user deletes one Others product, the title place holder for the next Others product changes to the deleted one
    Given I am on Payment Form Details page
    When I select Add new twice to add new Others product
    And I fill in only trip details for both Others product
    Then I should see both Others products trip details
    When I delete the first Others product
    Then second others title place holder should change to first Others title placeholder

  @Others3 
  Scenario: Verify admin user can edit added Others
    Given I am on Payment Form Details page
    When I add Others product
    And I edit details of the Other product
    Then I should see details of edited Other product
