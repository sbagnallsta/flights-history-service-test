@smoke
@versions
Feature: Jira Service
As an API client
I want to perform some requests on Jira Services
so that I can verify the responses received

@positive
Scenario Outline: To verify a release is released.
Given I am on the Jira Service
When I make a request to create a release with "<product>" product and "<version>" version
And There is a "<releaseStatus>" version which matches my request
Then I get a "<code>" http status code
And I get "<response>" response body
Examples:
|product    |version            |code   |response             |releaseStatus    |
|unreleased |unreleased version |200    |release issues       |unreleased       |
|released   |released           |404    |no                   |released         |

@negative
Scenario Outline: To verify an error is thrown if request is invalid for any reason
Given I am on the Jira Service
When I make a request to create a release with "<product>" product and "<version>" version
Then I get a "<code>" http status code
And I get "<response>" response body
Examples:
|product    |version    |code   |response             |
|invalid    |unreleased |400    |unexpected JIRA error|
|invalid    |released   |400    |unexpected JIRA error|
|invalid    |invalid    |400    |unexpected JIRA error|
|unreleased |invalid    |404    |no                   |
|released   |invalid    |404    |no                   |

