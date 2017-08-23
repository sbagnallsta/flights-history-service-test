@smoke 
@settings 
Feature: Saved Searches Service 
	As an API client I want to perform some requests on <settings> resource so I can verify the responses received 


@positive 
Scenario: 
	To verify that when a request is made to get a specific settings details, the API returns the settings details 
	Given I am on Saved Searches Service settings resource 
	When I search for a settings on the system 
	Then I should get a 200 HTTP status on settings resource 
	And I should get the settings payload 
	
	
@positive 
Scenario: 
	To verify that when a request is made to update some settings, the API updates the settings 
	Given I am on Saved Searches Service settings resource 
	When I request a setting to be updated 
	Then I should get a 200 HTTP status on settings resource 
	And I should get the settings payload 
	
@positive 
Scenario: 
	To verify that when a request is made to update some settings, the cache gets cleared
	Given I am on Saved Searches Service settings resource
	When I search for a settings on the system 
	Then I should get a 200 HTTP status on settings resource 
	And I should get the settings payload
	When I request a setting to be updated 
	Then I should get a 200 HTTP status on settings resource 
	And I should get the settings payload
	When I search for a settings on the system 
	Then I should get a 200 HTTP status on settings resource 
	And I should get the settings payload
	And I should get the cache cleared
