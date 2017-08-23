@Cancellationfees @Regression
Feature: Cancellation fees module -B2B Automation
  As an admin UI user 
  I want to  perform some actions on B2B Payment portal Cancellation fees section
  So that I can manage Cancellation fees details displayed on payment form

  @Cancellationfees1
  Scenario: Verify admin user can add new Cancellation fees
    Given I am on Payment Form Details page
    When I activate Cancellation fees section
    Then I should see Cancellation fees section required message
    When I select Add New for Cancellation fees
    Then I should not see Cancellation fees section required message
    And I should see required messages for all Cancellation fees fields
    When I fill the details for Cancellation fees
    Then I should not see required messages for all Cancellation fees fields
    When I fill in details for Legal copy
    Then I should see details filled in for Cancellation fees and Legal copy

  @Cancellationfees2
  Scenario: Verify admin user can edit added Cancellation fees
    Given I am on Payment Form Details page
    When I activate Cancellation fees section
    Then I should see Cancellation fees section required message
    When I add Cancellation fees
    And I edit the details of the Cancellation fees
    Then I should see details of edited Cancellation fees

  @Cancellationfees3
  Scenario: Verify admin user can delete one or more added Cancellation fees
    Given I am on Payment Form Details page
    When I activate Cancellation fees section
    Then I should see Cancellation fees section required message
    When I add New Cancellation fees twice
    Then I should not see Cancellation fees section required message
    And I should see two Cancellation fees type on the cancellation fees section
    When I delete the first Cancellation fees
    Then I should not see the deleted Cancellation fees
    When I delete the second Cancellation fees
    Then I should see Cancellation fees section required message
