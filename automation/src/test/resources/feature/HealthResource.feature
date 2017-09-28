@sanity
Feature: Test Service is up
As a dev
I want to perform a health check
to ensure the application is running

@positive
Scenario: To verify health controller returns a 200
Given I am on Flights History Service health resource
When I perform a request to check the health of the service
Then I should get a positive response