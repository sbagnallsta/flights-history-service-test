@smoke
@files
Feature: GitHub API
As an API client 
I want to perform some requests on GitHub Services
so that I can verify the responses received

@positive
Scenario: To verify file is created.
Given I am on GitHub Service files resource
When I request a file to be created
Then I should get a 201 HTTP status code back from GitHub Service files resource
And I should get the file created payload

@negative
Scenario Outline: To verify validation is applied when an invalid file is requested to be created in the system
Given I am on GitHub Service files resource
When I request a file to be created with missing data "<message>" "<path>" "<repository>" "<content>" "<branch>"
Then I should get a 400 HTTP status code back from GitHub Service files resource
And I should get a file payload with errors information
Examples:
|message|path|repository|content|branch|
|       |    |          |				|      |
|       |test|   test   |  test | test |
|  test |    |   test   |  test | test |
|  test |test|          |  test | test |
|  test |test|   test   |       | test |
|  test |test|   test   |  test |      |


@negative
Scenario: To verify validation is applied when a file is requested to be created in the system with an invalid repository
Given I am on GitHub Service files resource
When I request a file to be created with a wrong repository
Then I should get a 500 HTTP status code back from GitHub Service files resource
And I should get a file payload with errors information
