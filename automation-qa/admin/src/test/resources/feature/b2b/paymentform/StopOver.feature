@StopOver
Feature: Stopovers module- B2B Automation
  
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Stopovers section
  So that I can manage Stopover details displayed on payment form

  @StopOver1
  Scenario: To verify that admin user is able to add a new Stopover
    Given I am on Payment Form Details page
    When I activate the Stopover section
    Then I should see the Stopover section required message
    When I select add new Stopover
    Then I should not see the Stopover section required message
    But I should see the Stopover details required message
    When I fill in the details in the added Stopover
    Then I should see Stopovers displayed with details
    And I should not see the Stopover details required message

  @StopOver2 @Regression
  Scenario: To verify that admin user can edit the price and product fields of the added Stopover
    Given I am on Payment Form Details page
    When I add a new Stopover
    And I edit the data in the Stopover Price fields by entering alphabets
    Then I should not see the alphabets input in the Stopover Price fields
    When I change the input in the Stopover price field to numbers
    Then I should see the number input in the Stopover Price field with the currency
    When I edit the Stopover product field details
    Then I should see edited data in the Stopover fields

  @StopOver3 @Regression
  Scenario: To verify admin user can delete one or more added Stopover
    Given I am on Payment Form Details page
    When I activate the Stopover section
    And I add two new Stopovers
    Then I should see two Stopovers on the Stopover section
    When I delete both Stopovers
    Then I should see the Stopover section required message
