@paymentformfrontend
Feature: Payment form - B2B automation
  As an admin ui user
  I want to verify that the information on the payment form page is as set on admin UI 
  So that I can manage the payment form section options displayed to user

  @paymentformfrontend1
  Scenario: To verify the mandatory fields of the  Passenger information on the frontend payment form when payment form is created with all passenger information option only passport number and middle name is non mandatory
    Given Form is already saved with flight cost and all passenger information with quote option
    When I select the unique url
    Then I should be directed to the travel information page
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should see the selected passenger information fields displayed on page
    When I select submit page
    Then I should see messages for all require passenger information fields
    When I fill in details in the mandatory fields
    # fill details in all require fields on page with all passenger fields except middle name and passport
    Then I should not see payment form page error messages for passenger fields
    When I select submit page
    Then I should be on confirmation page

  @paymentformfrontend2
  Scenario: To verify that address information is displayed to user on the frontend payment form when payment form is created with address information and only address line 2 is non mandatory
    Given Form is already saved with flight cost and all address information with quote option
    When I select the unique url
    Then I should be directed to the travel information page
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should see all selected address information fields
    When I select submit page
    Then I should see error message for address information require fields
    When I fill details in all require field on page
    # fill details in all require fields on page with all address fields except a
    And I select submit page
    Then I should be on confirmation page

  @paymentformfrontend3
  Scenario: To verify that extras and stopovers are displayed to user with option to select/deselect on the frontend payment form  page when payment form is created with extras and stopovers
    Given Form is already saved with flight cost stopovers and extras
    When I select the unique url
    Then I should be directed to the travel information page
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should see extras optional fields
    And I should see stopover optional fields
    When I select both extras and stopover optional fields
    Then I should see extras and stopover optional fields highlighted
    And I should see the extras and stopover optional fields on the payment form side bar
    And I should see extras and stopover optional prices added to total price on payment form side bar

  @paymentformfrontend4
  Scenario: To verify that email field accepts only valid email format on front end payment form
    Given Form is already saved with flight cost deposit cost and final deposit due date
    When I select the unique url
    Then I should be directed to the travel information page
    When I select the deposit payment type
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should not be able to enter invalid email address in address input
    # should receive error message for each invalid format entered in email input
    When I enter a valid format email in the email field
    Then I should not see the invalid email error message
    When I enter email in confirm email input diffrent than I enter in email input
    Then I should receive error message for confirm email input
    When I enter same email in confirm email input as I enter in email input
    Then I should not receive error message for confirm email input

  @paymentformfrontend5
  Scenario: To verify that final deposit due date info is displayed to user on the front end payment form page and  sidebar when payment form is created with due dates
    Given Form is already saved with flight cost deposit cost and final deposit due date
    When I select the unique url
    Then I should be directed to the travel information page
    When I select the deposit payment type
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should see final deposit due date warning on top and bottm of the front end payment form page
    And I should see final deposit due date warning on payment form side bar
    And I should see final deposit due date message on front end payment form page

  @paymentformfrontend6
  Scenario: To verify that final payment due date info is displayed to user on the front end payment form page and  sidebar when payment form is created with due dates
    Given Form is already saved with flight cost deposit cost and final payment due date
    When I select the unique url
    Then I should be directed to the travel information page
    When I select the full amount payment type
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should see final payment due date warning on top and bottm of the front end payment form page
    And I should see final payment due date warning on payment form side bar
    And I should see final payment due date message on front end payment form page

  @paymentformfrontend7
  Scenario: To verify that user is able to complete booking successfully when quote is selected on the payment form details page
    Given Form is already saved with flight cost and all address information with quote option
    When I select the unique url
    Then I should be directed to the travel information page
    When I select quote option
    Then I should be on frontend payment form page
    And I should see only quote payment option on the front end payment form page

  @paymentformfrontend8
  Scenario Outline: To verify that is user able to proceed to payment popup successfully when any payment type is selected on the payment form details page
    Given Form is created with flight cost deposit and balance selected
    When I select the unique url
    Then I should be directed to the travel information page
    And I should see three payment types on the travel info page
    # deposit, balance, and full amount
    When I select "<Payment type>"
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should see payable today price on the front end payment form page as per selected "<Payment type>"
    And I should payment button on the front end payment form page contain expected text as per "<Payment type>"
    And I should see the total price for booking displayed on the front end payment form as per selected "<Payment type>"

    # on main page and side bar as well
    Examples: 
      | Payment type |
      | Balance      |
      | Deposit      |
      | Full Amount  |

  @paymentformfrontend9
  Scenario: To verify that state display as per country selection on payment form page
    Given Form is already saved with flight cost and all address information with quote option
    When I select the unique url
    Then I should be directed to the travel information page
    And I proceed to booking
    Then I should be on frontend payment form page
    And I should see state list from state dropdown as per country selection
