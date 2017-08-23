@Accommodation
Feature: Accommodation module -B2B Automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Accommodation section
  So that I can manage Accommodation details displayed on payment form

  @Accommodation1
  Scenario: Verify Accommodation section must have Accommodation details when it is active
    Given I am on Payment Form Details page
    When I activate Accommodation section
    Then I should see a Accommodation required message
    When I add new Accommodation
    Then I should not see a Accommodation required message
    And I should see new Accommodation on the Accommodation section
    When I disable the Accommodation
    Then I should see a Accommodation required message
    When I enter second Accommodation
    Then I should see second Accommodation on Accommodation Section
    And I should not see a Accommodation required message

  @Accommodation2 @Regression
  Scenario: Verify admin user cannot save Accommodation details without filling the required fields
    Given I am on Accommodation Details page
    And I should see required messages are displayed on Accommodation page
    When I save Accommodation details page without entering data in the required field
    Then I should see warning messages on Accommodation page
    When I enter alphabets in Rooms and Nights fields
    Then I should see Numeric fields warning messages on Accommodation page

  @Accommodation3 @Regression @Smoke
  Scenario: Verify admin user can edit an Accommodation
    Given I am on Payment Form Details page
    When I add new Accommodation
    Then I should see new Accommodation on the Accommodation section
    When I edit the details of the new Accommodation
    And I select cancel on Accommodation page
    Then I should see Accommodation on Accommodation section without any changes 
    When I edit the details of the new Accommodation
    # change name and city as only these reflect on Accommodation section
    And I save changes on Accommodation page
    Then I should see edited Accommodation on the Accommodation section with changes
