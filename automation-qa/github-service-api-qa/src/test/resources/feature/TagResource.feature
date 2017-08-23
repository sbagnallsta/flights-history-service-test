@smoke
@tags
Feature: GitHub API
As an API client 
I want to perform some requests on GitHub Services
so that I can verify the responses received

@positive
Scenario: To verify tags are created.
Given I am on GitHub Service tags resource
When I request a tag to be created
Then I should get a 201 HTTP status code from GitHub Service tags resource
And I should get the tag created payload

@negative
Scenario Outline: To verify validation is applied when an invalid tag is requested to be created in the system
Given I am on GitHub Service tags resource
When I request a tag to be created with missing data "<tagName>" "<body>" "<repository>"
Then I should get a 400 HTTP status code from GitHub Service tags resource
And I should get a tag payload with errors information
Examples:
|tagName|body|repository|
|       |    |          |
|       |test|   test   |
|  test |    |   test   |
|  test |test|          |

@negative
Scenario: To verify validation is applied when a tag is requested to be created in the system with an invalid repository
Given I am on GitHub Service tags resource
When I request a tag to be created with a wrong repository
Then I should get a 500 HTTP status code from GitHub Service tags resource
And I should get a tag payload with errors information
