@Smap @Regression
Feature: Payment Form Module- B2B Payment Automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Passenger Information, Address, Meal and Seat preference module
  So that I can manage Passenger Information, Address, Meal and Seat preference details displayed on payment form

  @Smap1
  Scenario: Verify that admin user can add and remove a seat preferences option in the payment form
    Given I am on Payment Form Details page
    And seat preferences are added by default
    When I delete all the seat preference option
    Then I should see the option redisplayed on the seat preference dropdown
    When I activate the seat preference section
    Then I should see the seat option required field message
    When I select seat option from the dropdown
    Then I should not see the seat option required field message
    And I should see selected seat option displayed
    And I should see selected seat options greyed out in dropdown

  @Smap2
  Scenario: Verify that admin user can add and remove a meal preferences option in the payment form
    Given I am on Payment Form Details page
    And meal preferences are added by default
    When I delete all the meal preference option
    Then I should see the option redisplayed on the meal preference dropdown
    When I activate the meal preference section
    Then I should see the meal option required field message
    When I select a meal option from the dropdown
    Then I should not see the meal option required field message
    And I should see selected meal option displayed
    And I should see selected meal options greyed out in dropdown

  @Smap3
  Scenario: Verify that admin user can add and remove address details in the payment form section
    Given I am on Payment Form Details page
    When I select options from the address dropdown
    Then I should see selected address options displayed on payment form
    And I should see selected options greyed out in the address information dropdown
    When I delete all address option
    Then I should see the option redisplayed on the Address dropdown

  @Smap4
  Scenario: Verify that admin user can add and remove passenger information details in the payment form section
    Given I am on Payment Form Details page
    When I select options from the passenger information dropdown
    Then I should see selected passenger information options dispalyed on payment form
    And I should see selected options greyed out in the passenger information dropdown
    When I delete all passenger information options
    Then I should see the option redisplayed on the passenger information dropdown
