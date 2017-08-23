@smoke
@pageresource
Feature: Confluence Service - API
As an API client 
I want to perform some requests on confluence service API
so that I  can verify the responses received 

@positive
Scenario: To verify that confluence pages are created
Given I am on the page resource
When I make a "valid" request to create a confluence page  
Then  I should get a "201" HTTP status code 

@negative
@negative1
Scenario: To verify validation is applied when the page request is submitted to the confluence service API and we handle Confluence API errors
Given I am on the page resource
When I make a "invalid" request to create a confluence page  
Then  I should get a "400" HTTP status code
And I should get a response with the "validation errors"

@negative
@negative2
Scenario: To verify validation is applied when the page request is submitted to the confluence service API and we handle Confluence API errors
Given I am on the page resource
When I make a "duplicate" request to create a confluence page  
Then  I should get a "400" HTTP status code
And I should get a response with the "confluence api errors"
