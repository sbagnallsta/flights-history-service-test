@Extra
Feature: Extras module -B2B Automation
  As an admin UI user 
  I want to  perform some actions on B2B Payment portal Extras section
  So that I can manage Extras details displayed on payment form

  @Extra1
  Scenario: To verify that admin user can add new Extras
    Given I am on Payment Form Details page
    When I activate Extras section
    Then I should see Extras section required message
    When I select add new Extras
    Then I should not see Extras section required message
    And I should see the Extra product details required message
    When I fill in the details in added Extras
    Then I should see Extra with added details
    And I should not see the Extras product details required message

  @Extra2 @Regression
  Scenario: To verify admin user can delete one or more added extras
    Given I am on Payment Form Details page
    When I activate Extras section
    Then I should see Extras section required message
    When I add New Extras twice
    Then I should not see Extras section required message
    And I should see two Extras on the Extras section
    When I delete both Extras
    Then I should see Extras section required message

  @Extra3 @Regression
  Scenario: To verify that admin user can edit the price and product fields of the added extras
    Given I am on Payment Form Details page
    When I add a new Extra
    And I edit the data in the Extras Price fields by entering alphabets
    Then I should not see the alphabets input in the Extras Price fields
    When I change the input in Extra price field to numbers
    Then I should see the number input in the Extras Price field with a dollar sign
    When I edit the Extras product field details
    Then I should see edited data in the Extras product fields
