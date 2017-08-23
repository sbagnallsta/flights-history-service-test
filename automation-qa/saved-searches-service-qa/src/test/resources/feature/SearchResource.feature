@smoke 
@searches 
Feature: Saved Searches Service 
	As an API client I want to perform some requests on <searches> resource so I can verify the responses received 

@positive 
Scenario Outline: To verify that when a request is made to store a new flight search, the service stores the flight search
	Given I am on Saved Searches Service searches resource 
	When I request a "<productType>" search to be created against a MySTA user
	Then I should get a 201 HTTP status on searches resource 
	And I should get the "<productType>" search created payload
	And I should get 1 searches in the system
Examples:
        |productType|
        |flight|
        |insurance|
        |tour|

@positive
Scenario Outline: To verify that when the same flight search is made twice, it is stored only once 
	Given I am on Saved Searches Service searches resource 
	When I carry out two "<productType>" searches with the same details
	Then I should get a 201 HTTP status on searches resource 
	And I should get the "<productType>" search created payload 
	And I should get 1 searches in the system 
Examples:
        |productType|
        |flight|
        |insurance|
        |tour|

@positive 
Scenario: To verify multiple searches products can be stored
	Given I am on Saved Searches Service searches resource 
	When I request a "flight" search to be created against a MySTA user
	Then I should get a 201 HTTP status on searches resource 
	And I should get the "flight" search created payload
	And I should get 1 searches in the system
	When I request a "insurance" search to be created against a MySTA user
	Then I should get a 201 HTTP status on searches resource 
	And I should get the "insurance" search created payload
	And I should get 2 searches in the system
	When I request a "tour" search to be created against a MySTA user
	Then I should get a 201 HTTP status on searches resource
	And I should get the "tour" search created payload
	And I should get 3 searches in the system 
	
	
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
