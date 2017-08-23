@Regression @Createform
Feature: Create Form - B2B automation
  As an admin ui user
  I want to perform some actions in creating a B2B payment form  
  So that I can manage the details displayed to user on the B2B payment form

  @createform1
  Scenario: To verify that admin user cannot save a payment form without filling in the required fields
    Given I am on Payment Form Details page
    And I see required messages in all payment form required fields
    When I activate all the required fields that needs activation
    And I save the payment form without filling details in all required fields
    Then I should see form unsaved with error messages in all the payment form required fields

  @createform2
  Scenario: Verify that admin user cannot save form without selecting at least one cost
    Given I am on Payment Form Details page
    And I fill in details for required modules
    Then I should see one cost required messages on all require cost fields
    But I should not see required messages on all other required fields
    When I select save on the payment form
    Then I should see form unsaved with error message on all the required cost fields
    When I save form with cost filled in one of the required cost fields
    Then I should see form saved on payment forms current forms list with a unique url

  @createform3 @Smoke
  Scenario: Verify that admin user can select only quote option when any cost is selected
    Given I am on Payment Form Details page
    And I see required messages in all payment form required fields
    When I fill in details for required modules selecting only flights cost
    And I select quote option
    And I save the payment form without selecting other payment options
    #deposit, balance
    Then I should see form saved on payment forms current forms list with a unique url
    When I select edit form
    Then I should see quote selected
    And deposit and balance is not selected

  @createform4
  Scenario: Verify that admin user can create form with deposit and balance
    Given I am on Payment Form Details page
    And I fill in details for required modules selecting only accommodation cost
    When I activate the deposit section
    And I fill in the deposit field
    And I activate balance section
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url
    When I select edit form
    Then I should see that accommodation cost, deposit and balance section are selected
    And quote option is not selected

  @createform6
  Scenario Outline: Verify that admin user can create form with only flights and flights cost
    Given I am on Payment Form Details page
    When I fill in details for required modules selecting only flights cost
    And I add new "<flight details>" flight
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

    Examples: 
      | flight details |
      | Getting There  |
      | Getting Around |
      | Getting Back   |

  @createform7
  Scenario: Verify that admin user can create form with only accommodation and accommodation cost
    Given I am on Payment Form Details page
    When I fill in details for required modules selecting only accommodation cost
    And I add new Accommodation
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

  @createform8
  Scenario: Verify that admin user can create form with only transfer and transfers cost
    Given I am on Payment Form Details page
    When I fill in details for required modules selecting only transfer cost
    And I add a new Transport
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

  @createform9
  Scenario: Verify that admin user can create form with only Others and Others cost
    Given I am on Payment Form Details page
    When I fill in details for required modules selecting only others cost
    And I add Others product
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

  @createform10
  Scenario: Verify that admin user can create form with only Misc product and otheres cost
    Given I am on Payment Form Details page
    When I fill in details for required modules selecting only others cost
    And I add a new Misc product
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

  @createform11 @Smoke
  Scenario: Verify that admin user can create form with accommodation and flights
    Given I am on Payment Form Details page
    When I fill in details for required modules selecting only flights cost
    And I fill accommodation cost
    And I add a new getting there flight
    And I activate Accommodation section
    And I add new Accommodation
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url
    When I select edit form
    Then I should see flight and accommodation modules still selected

  @createform12
  Scenario: Verify that admin user can create form with flights, extras and stopovers
    Given I am on Payment Form Details page
    When I fill in details for required modules selecting only flights cost
    And I add a new getting there flight
    And I add a new Stopover
    And I add a new Extra
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url
    When I select edit form
    Then I should see flight, extra and stopover modules still selected

  @createform13
  Scenario: Verify that admin user can create form with accommodation cost, accommodation, passenger information and address with quote option selected
    Given I am on Payment Form Details page
    When I select quote option
    And I fill in details for required modules selecting only accommodation cost
    And I select options from the passenger information dropdown
    And I select options from the address dropdown
    And I add new Accommodation
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

  @createform14
  Scenario: Verify that admin user can create form with flight cost, T&Cs(final deposit and final payment), Important instruction and Deposit with quote option selected
    Given I am on Payment Form Details page
    When I select quote option
    And I fill in details for required modules with flight and deposit
    And I activate final deposit date section
    And I enter the dates in the final deposit date field
    And I activate final payment date section
    And I enter the dates in the final payment date field
    And I activate the Important instruction field
    And I fill in details in the important instruction field
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

  @createform15
  Scenario: Verify that admin user can create a form with flight cost, getting around flight, seat and meal preference with quote option selected
    Given I am on Payment Form Details page
    And meal preferences are added by default
    And seat preferences are added by default
    When I select quote option
    And I fill in details for required modules selecting only flights cost
    And I add a new getting around flight
    And I activate the meal preference section
    And I activate the seat preference section
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url

  @createform16 @Smoke
  Scenario: Verify that admin user can create a form with all details and fields
    Given I am on Payment Form Details page
    When I fill in details for all fields
    And I save payment form
    Then I should see form saved on payment forms current forms list with a unique url
