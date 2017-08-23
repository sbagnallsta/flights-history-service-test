@sanity 
Feature: Flights Collector 
	As a Flights Collector client I want to perform a healthcheck so I can verify the responses received 

Scenario: 
	To verify that when a request is made to check the health of the service, the service returns a positive response
	Given I am on Flights Collector
	When I perform a request to check the health of the service
	Then I should get a positive response
