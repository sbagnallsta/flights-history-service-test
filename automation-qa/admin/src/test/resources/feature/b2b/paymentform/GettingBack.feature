@FlightsGettingBack
Feature: Flight module - Getting Back section - B2B Automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Getting Back section
  So that I can manage Getting Back details displayed on payment form
  
  @GettingBack1
  Scenario: Verify admin user can not add Getting Back flights details without entering flight details
    Given I am on Flights Getting Back page
    When I save without entering any flights data
    Then I should see messages for all require fields

  @GettingBack2
  Scenario: Verify Flight Section must have flights when is active
    Given I am on Payment Form Details page
    When I activate Flight section
    Then I should see a required message
    When I add two Getting Back flights
    Then I should not see the required message anymore
    When I disable Getting Back Flight
    Then I should see a required message

  @GettingBack3 @Regression
  Scenario: Verify admin user can delete a Getting Back flight
    Given I am on Payment Form Details page
    When I add two Getting Back flights
    Then I should see the flight information in Getting Back section
    When I delete the flight in Getting Back Section
    And I should not see deleted flight on Getting Back Flights section

  @GettingBack4 @Regression
  Scenario: Verify admin user can add edit flights in getting Back section
    Given I am on Flights Getting Back page
    Then I should see messages for all require fields
    When I enter the details for flight one
    And Add new flight
    And I should see a remove button for Flight One and Flight Two
    And I should see some Departure details in Flight Two being same as Arrival details from Flight one
    When I enter the details for flight two
    And Add new flight
    Then I should see Remove button for Flight Three
    When I enter the details for flight three
    And I save the flight details
    Then I should see the flight information in Getting Back section
    When I change the details of the second Flight for Getting Back section  
    Then I should see the new flight changes in Getting Back section
