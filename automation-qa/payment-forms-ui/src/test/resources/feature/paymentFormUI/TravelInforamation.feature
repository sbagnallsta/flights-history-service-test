@Travelinformationpage
Feature: Travel Information - B2B automation
  As an admin ui user
  I want to verify that the information on the travel information page is as set on admin UI 
  So that I can manage the payment form section options displayed to user

  @Travelinformation1
  Scenario: To verify that misc product is displayed  to user with option to select/deselect on the travel info page when payment form is created with misc product
    Given Form is already saved with flight cost and two misc product with cost
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see the both Misc products information as entered in form with check box
    When I select both Misc product option
    Then I should see the selected Options highlighted
    And I should see the misc product with price on the travel info sidebar
    And I should see that the misc product price added to the total price

  @Travelinformation2
  Scenario: To verify that price is displayed as NA on the travel info page when no price is entered for a misc product
    Given Form is already saved with flight cost and misc product with out cost
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see the Misc product information as entered in form with check box
    When I select the Misc product option
    Then I should see the selected Option highlighted
    And I should see the misc product on the travel information sidebar
    And misc price should be displayed as NA on the travel info sidebar

  @Travelinformation3
  Scenario: To verify that transfer is displayed to user without option to select/deselect on the travel info page when payment form is created with transfer
    Given Form is already saved with transfer cost and two transfer product
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see the Transfer details on the travel information page
    And I should see the Transfer with amount on the travel info sidebar
    And I should see that the transfer price is added to the total price on the travel info side bar

  @Travelinformation4
  Scenario: To verify that the important instructions is displayed to user on the travel info page when payment form is created with important instruction
    Given Form is already saved with others cost and important instructions
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see the important instruction module information displayed

  @Travelinformation5
  Scenario: To verify that due dates info is displayed to user on the travel info sidebar when payment form is created with due dates
    Given Form is already saved with flight cost final deposite and final payment date
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see the final deposit due date on the travel info side bar
    And I should see the final payment due date on the travel info side bar

  @Travelinformation6
  Scenario: To verify that Others is displayed to user without option to select/deselect on the travel info page when payment form is created with Others
    Given Form is already saved with others cost and two others product
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see both Others on the travel info page
    And I should see the Others on the travel info sidebar with price
    And I should see that the Others price is added to the total price

  @Travelinformation7
  Scenario Outline: To verify that flights details is displayed to user on travel info page when payment form is created with flights
    Given Form is already saved with flight cost and "<Flight details>"
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see the "<Flight details>" flight on the travel info page
    And I should see the flight details on the travel info sidebar
    And I should see message of days it takes for plane to arrive on "<Flight details>"

    #flight arrives (x) days = departure-arrival
    Examples: 
      | Flight details |
      | Getting There  |
      | Getting Around |
      | Getting Back   |

  @Travelinformation8
  Scenario: To verify that flights details and T&C are displayed to user on travel info page when payment form is created with all flight type
    Given Form is already saved with flight cost all flight types and all t & c types
    When I enter unique url
    Then I should be directed to the travel information page
    And I should see the details of all flight entered on travel info page
    And I should see message of days it takes for plane to arrive for each flight type
    #flight arrives (x) days = departure-arrival
    And I should see all t&c types displayed on travel info page
