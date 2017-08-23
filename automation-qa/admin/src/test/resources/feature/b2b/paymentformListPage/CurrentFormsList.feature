@Currentformslist
Feature: Current Forms list - B2B automation
  As an admin ui user
  I want to perform some actions on current forms list  
  So that I can manage the details displayed to user on the B2B payment form

  @currentformslist1 @Smoke
  Scenario: Verify that when a form is created , it is displayed in the current forms list with right parameters
    Given I am on Payment Form Details page
    When I save a payment form with valid details
    Then I should be on current forms list page
    And I should see the form categorised according to id, form name and unique url matching the partner name entered in the form
    And the unique url should contain domain name,partner name and form id

  @currentformslist2 @Regression
  Scenario: Verify that admin user can edit /delete the payment form
    Given I am on payment form list page
    And a payment form is already saved on the current forms list
    #Create new forms, if there are no saved forms
    When I edit the payment form changing the partner name
    Then I should see the edited form saved on the current forms list
    And I should see the change on the partner name reflect in the unique url
    And I should not see any change in the reference number
    And I should not see any change in the id
    When I select delete
    Then I should not see the deleted payment form on the current forms list

  @currentformslist3 @Regression
  Scenario: Verify that admin user can make a copy of an already saved payment form
    Given I am on payment form list page
    And a payment form is already saved on the current forms list
    When I select copy from an already saved payment form
    Then I should be on a new payment forms details page with details of original payment form
    When I select create without making any changes
    Then I should see a copy of the form on the current forms list
    And the unique url should have the same partner name
    But the unique url should contain id
    And the form name should remain the same
    And I should see a different id on the id column against the new copy

  @currentformslist4 @Regression
  Scenario Outline: Verify that admin user can carry out a search on the current forms list using the given parameters
    Given I am on payment form list page
    And payment forms are already saved on the current forms list
    When I enter "<search parameter>" in the search box
    Then I should see matching payment form in view

    Examples: 
      | search parameter |
      | Form name        |
      | Id               |
      | Reference number |
      | Partner name     |

  @currentformslist5 @Regression
  Scenario Outline: Verify that user is able to sort the forms according to available sort options
    Given I am on payment form list page
    And payment forms are already saved on the current forms list
    When I  sort by "<sort options>"
    Then I should see payment forms displayed according to "<sort options>"

    Examples: 
      | sort options |
      | Form name    |
      | id           |

  @currentformslist6
  Scenario: Verify that user is able to disable a form from the current forms link
    Given I am on payment form list page
    And the payment form is active
    When I make the payment form inactive
    Then payment form should be inactive

  @currentformslist7 @Regression
  Scenario: Verify that user is able to switch between pages from the page numbers
    Given I am on payment form list page
    And twenty forms are already saved
    #for test purpose, you can change the number of forms saved per page in the database in order to reduce number of forms to be created
    And I see twenty forms per page with the page numbers at the bottom of the page
    When I select page two from the page number
    Then I should be navigated to the top of the second page
    When I select the left arrow
    Then I should be navigated to the top of the first page
