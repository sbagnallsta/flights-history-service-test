@sanity 
Feature: Cheap Flights Service 
	As a Cheap Flights Service client I want to perform a healthcheck so I can verify the responses received 

Scenario: 
	To verify that when a request is made to check the health of the service, the service returns a positive response
	Given I am on Cheap Flights Service
	When I perform a request to check the health of the service
	Then I should get a positive response
