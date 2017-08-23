@sanity 
Feature: Saved Searches Service 
	As an API client I want to perform a healthcheck so I can verify the responses received 

Scenario: 
	To verify that when a request is made to check the health of the service, the API returns a positive response
	Given I am on Saved Searches Service
	When I perform a request to check the health of the API
	Then I should get a positive response	
