@smoke
@emails
Feature: Email API
As an API client 
I want to perform some requests on Email Service
so that I can verify the responses received

@positive
Scenario: To verify email is sent out.
Given I am on Email Service resource
When I make a valid request for an email to be sent out
Then I should get a 201 HTTP status code back from Email Service resource

@negative
Scenario Outline: To verify that bad requests are handled by the email service
Given I am on Email Service resource
When I make an invalid request for an email to be sent out with bad data "<sender>" "<to>" "<cc>" "<bcc>"
Then I should get a 400 HTTP status code back from Email Service resource
And I should get an error object with <number_of_errors> item
Examples:
|sender         |to             |cc             |bcc             |number_of_errors  |
|               |               |               |                |3                 |
|invalid        |valid@valid.com|valid@valid.com|valida@valid.com|1                 |
|valid@valid.com|invalid        |valid@valid.com|valida@valid.com|1                 |
|valid@valid.com|valid@valid.com|invalid        |valida@valid.com|1                 |    
|valid@valid.com|valid@valid.com|valid@valid.com|invalid         |1                 |

@negative
Scenario: To verify a valid request for an template that does not exist returns an error
Given I am on Email Service resource
When I make a valid request for an email to be sent out for a nonexistant template
Then I should get a 404 HTTP status code back from Email Service resource

@negative
Scenario: To verify that an error occurs when the comunication with template-service fails
Given I am on Email Service resource
When I request a email to be sent out with bad gateway error in the product
Then I should get a 502 HTTP status code back from Email Service resource
