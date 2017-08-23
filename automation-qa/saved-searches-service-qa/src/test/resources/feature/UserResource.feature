@smoke 
@users 
Feature: Saved Searches Service 
	As an API client I want to perform some requests on <users> resource so I can verify the responses received 

@positive 
Scenario: 
	To verify that when a request is made to get a specific user details, the API returns the user's details 
	Given I am on Saved Searches Service users resource 
	When I search for a MySTA user on the system 
	Then I should get a 200 HTTP status code on users resource
	And I should get the user payload
	
@positive 
Scenario:
To verify that when a request is made to synchronise the searches in the system between an Anonymous user and a MySTA user, the API synchronises the searches 
	Given I am on Saved Searches Service users resource
	When I request a search to be created against an Anonymous user 
	And I request a search to be created against a MySTA user
	When I synchronise the searches of Anonymous user and MySTA user
	Then I should get a 200 HTTP status code on users resource
	And I should get the user payload with searches synchronised
