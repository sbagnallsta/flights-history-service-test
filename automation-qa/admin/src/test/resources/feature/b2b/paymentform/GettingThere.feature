@FlightsGettingThere
Feature: Flight module - Getting There section - B2B Automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Getting There section
  So that I can manage Getting There details displayed on payment form

  @GettingThere1 @Regression
  Scenario: Verify admin user can not add Getting There flights details without entering flight details
    Given I am on Flights Getting There page
    When I save without entering any flights data
    Then I should see messages for all require fields

  @GettingThere2
  Scenario: Verify Flight Section must have flights when is active
    Given I am on Payment Form Details page
    When I activate Flight section
    Then I should see a required message
    When I add two Getting there flights
    Then I should not see the required message anymore
    When I disable Getting There Flight
    Then I should see a required message

  @GettingThere3 @Regression
  Scenario: Verify admin user can delete a Getting There flight
    Given I am on Payment Form Details page
    When I add two Getting there flights
    Then I should see the flight information in Getting There section
    When I delete the flight in Getting There Section
    And I should not see deleted flight on Getting There Flights section

  @GettingThere4 @Regression
  Scenario: Verify admin user can add edit flights in getting there section
    Given I am on Flights Getting There page
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
    Then I should see the flight information in Getting There section
    When I change the details of the second Flight for Getting There section
    Then I should see the new flight changes in Getting There section
