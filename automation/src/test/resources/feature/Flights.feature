@flights
@smoke
@positive
Feature: Flights History Service
    As a service consumer 
    I want to perform some requests on <flights> resource so I can verify the responses received   

Scenario Outline: To verify flights are stored from all types of sources
Given I am POSTing flights to the Flights History Service flights resource
When The request is valid "<source>" flights
Then I should get a 201 HTTP status code from Flights History Service flights resource
And The flights should be stored
Examples:
|source|
|manual|
|collector|

Scenario Outline: To verify that flights are not replaced by the same flight being stored twice
Given I am POSTing flights to the Flights History Service flights resource
When The request is valid "<first-source>" flights with a specific POS "<first-pos>"
Then I should get a 201 HTTP status code from Flights History Service flights resource
And The flights should be stored
When The request is valid "<second-source>" flights with a specific POS "<second-pos>"
Then I should get a 201 HTTP status code from Flights History Service flights resource
And Both sets of flights should be stored
Examples:
|first-source|first-pos|second-source|second-pos|
|manual|uk|manual|uk|
|manual|uk|collector|us|
|collector|uk|manual|uk|
|collector|us|collector|us|