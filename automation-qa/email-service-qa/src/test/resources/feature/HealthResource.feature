@sanity
Feature: Test Service is up
As a dev
I want to perform a health check
to ensure the application is running

@positive
Scenario: To verify health controller returns a 200
Given I am on Email Service health resource
Then I should get a 200 Http status code