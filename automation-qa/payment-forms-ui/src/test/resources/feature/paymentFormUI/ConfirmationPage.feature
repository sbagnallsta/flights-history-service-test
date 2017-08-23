@confirmationpage
Feature: Confirmation page- B2B automation
  As an admin ui user
  I want to verify that the information on the confirmation page is as set on admin UI 
  So that I can manage the confirmation page details displayed to user

  @confirmationpage1
  Scenario: To verify that extras and stopovers are displayed to user on the confirmation page when user has selected on the payment for page
    Given Form is created with flight cost two extras and two stopover options
    When I enter Unique url
    Then I should be directed to the travel information page
    When I proceed to booking
    Then I should be on payment form page
    When I fill in details for all require field on page
    And I select both extras and stopover optional fields
    And I proceed to booking
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see a confirmation email sent message
    And I should see payment successful message on confirmation page
    And I should see the extras and stopovers on the confirmation page side bar
    And I should see payment form heading on confirmation page
    # both extras and stopover name and price, total for both extra and stopover
    And Total price should include flight stopovers and extras cost on confirmation page and side bar

  @confirmationpage2
  Scenario: To verify that transfer details and transfer price are displayed to user on the confirmation page and sidebar when user has filled in details for transfer and selected transfer price on the payment form page
    Given Form is created with flight and transfer cost with two transfers
    When I enter Unique url
    Then I should be directed to the travel information page
    When I proceed to booking
    Then I should be on payment form page
    When I fill in details for all require field on page
    And I proceed to booking
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see a confirmation email sent message
    And I should see payment successful message on confirmation page
    And I should see the transfer details on the confirmation page
    #departure date & time, transfer route
    And I should see flight and transfer cost on the confirmation page side bar
    And I should see payment form heading on confirmation page
    And Total price should include flight and transfer cost on confirmation page and side bar

  @confirmationpage3
  Scenario: To verify that Misc details and Misc price are displayed to user on the confirmation page and sidebar when user has filled in details for Misc on the payment form page
    Given Form is created with flight cost balance deposit and two misc products
    When I enter Unique url
    Then I should be directed to the travel information page
    When I select both Misc product option
    And I proceed to booking
    Then I should be on payment form page
    When I fill in details for all require field on page
    And I proceed to booking
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see a confirmation email sent message
    And I should see payment successful message on confirmation page
    And I should see both Misc product details on the confirmation page
    And I should see both Misc product price on the confirmation page side bar
    And I should see payment form heading on confirmation page
    And Total price should include Misc and flights cost on confirmation page and side bar

  @confirmationpage4
  Scenario: To verify that final payment due date info is displayed to user on the confirmation page and  sidebar when payment form is created with due dates and deposit payment type is selected
    Given Form is created with flight cost and final payment due dates
    When I enter Unique url
    Then I should be directed to the travel information page
    When I select deposit as payment option
    And I select pay deposit now
    Then I should be on payment form page
    When I fill in details for all require field on page
    And I proceed to booking
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see a confirmation email sent message
    And I should see payment form heading on confirmation page
    And I should see deposit payment successful message on confirmation page
    And I should see the final payment due date warning message at the top and bottom of the confirmation page
    And I should see the final payment due date warning message at the bottom of  the confirmation side bar

  @confirmationpage5
  Scenario: To verify that others details displaeyd on confirmation page as entered on payment form
    Given Form is created with others cost and two others
    When I enter Unique url
    Then I should be directed to the travel information page
    When I proceed to booking
    Then I should be on payment form page
    When I fill in details for all require field on page
    And I proceed to booking
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see a confirmation email sent message
    And I should see payment successful message on confirmation page
    And I should see both Others on the confirmation page
    And I should see payment form heading on confirmation page
    And I should see the Total price on the confirmation page and side bar same as others cost

  @confirmationpage6
  Scenario Outline: To verify that flight information displayed on confirmation page as entered in payment forms
    Given Form is already saved with Flight cost and "<Flight details>"
    When I enter Unique url
    Then I should be directed to the travel information page
    When I proceed to booking
    Then I should be on payment form page
    When I fill in details for all require field including flight terms and conditions on page
    And I proceed to booking
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see a confirmation email sent message
    And I should see the "<Flight details>" flight on the confirmation page
    And I should see payment form heading on confirmation page
    And I should see message of days it takes for plane to arrive for "<Flight details>" on confirmation page
    And I should see the flight details on the confirmation page sidebar

    #flight arrives (x) days = departure-arrival
    Examples: 
      | Flight details |
      | Getting There  |
      | Getting Around |
      | Getting Back   |
