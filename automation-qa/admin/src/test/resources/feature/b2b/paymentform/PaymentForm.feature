@PaymentForm
Feature: Travel and Partner information module- B2B automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Travel, Partner Information section and T&C's section 
  So that I can manage Partner, Travel Information and T&Cs details displayed on payment form

  @PaymentForm1
  Scenario: Verify that admin user can add partner information details in the respective fields
    Given I am on Payment Form Details page
    And I see required messages on all the partner information required fields
    #All fields are required except Partner logo url
    When I fill in details in all the partner information fields
    Then I should see partner information with details added
    And I should not see the required messages on all the partner information required fields

  @PaymentForm2
  Scenario: Verify that admin user can add travel information details in the respective fields
    Given I am on Payment Form Details page
    And I see required messages on all the travel information required fields
    When I fill in details in all the travel information fields
    Then I should see travel information with details added
    And I should not see the required messages on all the travel information required fields

  @PaymentForm3
  Scenario: Verify that admin user can add important instruction details
    Given I am on Payment Form Details page
    When I activate the Important instruction field
    Then I should see the Important instruction required message on the important instruction field
    When I fill in details in the important instruction field
    Then I should not see the required messages on all the important instruction field

  @PaymentForm4
  Scenario Outline: Verify that admin user can not add any details in the add final deposit and final payment due dates fields under T&Cs section when the sections are not activated
    Given I am on Payment Form Details page
    And "<date>" section is not activated
    And I should see "<date>" fields disabled

    Examples: 
      | date                   |
      | final deposit date     |
      | final payment due date |

  @PaymentForm5
  Scenario Outline: Verify that admin user can add final deposit and final payment due dates under T&C's section
    Given I am on Payment Form Details page
    When I activate "<date>" section
    Then I should see "<date>" required message
    When I enter data in all fields under "<date>" section
    Then I should see data entered in all "<date>" fields including date
    And I should not see the "<date>" required message

    Examples: 
      | date                   |
      | final deposit date     |
      | final payment due date |

  @PaymentForm6 @Regression
  Scenario Outline: Verify that admin user can edit dates entered in the  final deposit and final payment due dates fields
    Given I am on Payment Form Details page
    When I activate "<date>" section
    And I enter the dates in the "<date>" field
    Then I should see the dates displayed in the "<date>" fields
    When I edit the "<date>" by clicking on today
    Then I should see today's date displayed in the "<date>" fields
    When I edit the "<date>" by clicking on clear
    Then I should see date input empty in "<date>" fields
    And I should see "<date>" required message

    Examples: 
      | date                   |
      | final deposit date     |
      | final payment due date |
