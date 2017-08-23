@sanity 
Feature: Template Service Health
	As a Template Service client I want to perform a healthcheck so I can verify the application is healthy 

Scenario: 
	To verify that when a request is made to check the health of the service, the service returns a positive response
	Given I am on Template Service 
	When I perform a request to check the health of the service 
	Then I should get a positive response 
