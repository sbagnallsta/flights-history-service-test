@smoke 
@searches 
Feature: Saved Searches Service 
	As an API client I want to perform some requests on <searches> resource so I can verify the responses received 

@positive 
Scenario: 
	To verify that when a request is made to store a new search, the API creates a search in the system 
	Given I am on Saved Searches Service searches resource 
	When I request a search to be created against a mysta user 
	Then I should get a 201 HTTP status on searches resource 
	And I should get the search created payload 
	And I should get 1 searches in the system 
	
@positive 
Scenario: To verify that a search is deleted when requested 
	Given I am on Saved Searches Service searches resource 
	When I request to delete a search 
	Then I should get a 204 HTTP status on searches resource 
	And I should get no payload 
	And I should get 0 searches in the system 
	
@positive 
Scenario: 
	To verify that when a request is made to delete invalid searches, the searches are deleted 
	Given I am on Saved Searches Service searches resource 
	When I delete the invalid searches from the system 
	Then I should get a 204 HTTP status on searches resource 
	And I should get no payload 
	And I should get 0 searches in the system 
	
@positive
Scenario: To verify that when the same search is made twice, is stored only once 
	Given I am on Saved Searches Service searches resource 
	When I carry out two flight search with the same details 
	Then I should get a 201 HTTP status on searches resource 
	And I should get the search created payload 
	And I should get 1 searches in the system 
	
#@negative 
#Scenario:
#To verify that when an invalid search is submitted, it will not be stored 
#	Given I am on Saved Searches Service searches resource 
#	When I carry out two flight search with the same details 
#	Then I should get a 400 HTTP status on searches resource 
#	And I should get the search created payload 
#	And I should get 1 searches in the system 
