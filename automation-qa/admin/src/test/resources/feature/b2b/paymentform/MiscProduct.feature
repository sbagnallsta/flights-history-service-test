@MiscProduct
Feature: Misc Product module- B2B Automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Misc Product section
  So that I can manage Misc Product details displayed on payment form

  @MiscProduct1
  Scenario: To verify that admin user is able to add a new Misc product
    Given I am on Payment Form Details page
    And the Misc product Title name field is displayed
    When I activate the Misc product section
    Then I should see the Misc product section required message
    And I should see the Misc product Title name required message
    When I select add new Misc product
    Then I should not see the Misc product section required message
    And I should see the Misc product details required message
    When I fill in the details in the added Misc product
    And I fill in the Misc product name field
    Then I should see Misc product with added details
    And I should not see the Misc product details required message
    And I should not see the Misc product Title name required message

  @MiscProduct2 @Regression
  Scenario: To verify that admin user can edit the Misc name, price and product fields of the added Misc products
    Given I am on Payment Form Details page
    When I add a new Misc product
    And I edit the data in the Misc products Price fields by entering alphabets
    Then I should not see the alphabets input in the Misc products Price fields
    When I change the input in Misc product price field to numbers
    Then I should see the number input in the Misc products Price field with the currency
    When I edit the Misc products product field details
    Then I should see edited data in the Misc products product fields

  @MiscProduct3 @Regression
  Scenario: To verify admin user can delete one or more added Misc product
    Given I am on Payment Form Details page
    When I activate the Misc product section
    Then I should see the Misc product section required message
    When I add two new Misc products
    Then I should not see the Misc product section required message
    And I should see two Misc products on the Misc products section
    When I delete both Misc products
    Then I should see the Misc product section required message

  @MiscProduct4
  Scenario: To verify that when Misc product section is disabled, misc product title name required message is not displayed after user deletes added product
    Given I am on Payment Form Details page
    When I select add new Misc product
    Then I should see the Misc product Title name required message
    And I should see the Misc product details required message
    When I fill in the details in the added Misc product
    Then I should see Misc product with added details
    When I delete added Misc Product
    Then I should not see the Misc product Title name required message
