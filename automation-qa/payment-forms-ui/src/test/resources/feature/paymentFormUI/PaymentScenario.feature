@paymentscenarios
Feature: Payment Scenario-B2B Automation
  As a user
  I want to carry out payment journeys 
  to verify that user is able to complete booking with the available payment types

  @paymentscenarios1
  Scenario: To verify that user is able to request for quote on the travel info page when payment form is created with quote option
    Given Form is created with accommoadation cost
    When I select unique url
    Then I should be directed to the travel information page
    And I should only see the quote option
    When I select quote option
    Then I should be on quote request page
    And I should see quote payment option on the front end payment form page
    #balance, deposit and full amount should not be displayed
    When I fill in details for all require field on page
    And I submit quote request
    Then I should be on the confirmation page
    And I should see the details for quote request on confirmation page and sidebar

  #details should include all added modules and sum of all cost
  @paymentscenarios2
  Scenario: To verify that user is able to complete booking selecting deposit payment type
    Given Form is created with Flight cost deposit and balance selected
    When I select unique url
    Then I should be directed to the travel information page
    And I should see three payment types on the travel information page
    #deposit, balance, and full amount
    When I select deposit as payment option
    And I proceed to booking
    Then I should be on frontend Payment form page
    Then I should see payable today amount same as deposit on the front end payment form page and side bar
    When I fill in details for all require field on page
    And I select pay deposit now
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see paid deposit amount on the confirmation page and side bar
    #deposit
    And I should see the remaining balance confirmation page
    And I should see the Total price on the confirmation page and side bar same as flight cost

  @paymentscenarios3
  Scenario: To verify that user is able to complete booking selecting balance payment type
    Given Form is created with Flight cost deposit and balance selected
    When I select unique url
    Then I should be directed to the travel information page
    And I should see three payment types on the travel information page
    #deposit, balance, and full amount
    When I select balance as payment option
    And I proceed to booking
    Then I should be on frontend Payment form page
    And I should see payable today amount same as balance on the front end payment form page and side bar
    When I fill in details for all require field on page
    And I select pay balance now
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see paid balance amount on the confirmation page and side bar
    #deposit
    And I should see the Total price on the confirmation page and side bar same as flight cost

  @paymentscenarios4
  Scenario: To verify that user is able to complete booking selecting full amount payment type
    Given Form is created with Flight cost deposit and balance selected
    When I select unique url
    Then I should be directed to the travel information page
    And I should see three payment types on the travel information page
    #deposit, balance, and full amount
    #And full amount is selected by default
    When I proceed to booking
    Then I should be on frontend Payment form page
    When I fill in details for all require field on page
    And I select pay full amount now
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see the Total paid amount same as flight amount on confirmation page and side bar

  #total paid should be = Deposit+Balance
  @paymentscenarios5
  Scenario: To verify that user is able to complete booking selecting full amount payment type when neither deposit nor balance is added on payment form
    Given Form is created with only flight cost
    When I select unique url
    Then I should be directed to the travel information page
    And I should not see any payment option
    When I proceed to booking
    #pay full amount now
    Then I should be on frontend Payment form page
    When I fill in details for all require field on page
    And I select pay full amount now
    Then I should be on quick payment pop up page
    When I complete payment on quick payment pop up page
    Then I should be on the confirmation page
    And I should see the Total paid amount same as flight amount on confirmation page and side bar
