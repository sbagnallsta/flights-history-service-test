@smoke 
@templates 
Feature: Template Service 
	As a Template Service client I want to perform some requests on Template Service so that I  can verify the responses received

@positive 
Scenario: To verify simple templates are created in the system 
    Given I am on Template Service templates resource 
    When I request a simple template to be created
    Then I should get a 201 HTTP status code 
    And I should get the templated created payload 

@positive
Scenario: To verify complex templates are created in the system
    Given I am on Template Service templates resource 
    When I request a complex template to be created
    Then I should get a 201 HTTP status code 
    And I should get the templated created payload

@negative 
Scenario Outline: To verify mandatory validation is applied when an invalid template is requested to be created in the system 
    Given I am on Template Service templates resource 
    When I request a template to be created with missing mandatory data "<productName>" "<type>" 
    Then I should get a 400 HTTP status code 
    And I should get a payload with errors information 
Examples:
        |productName|type|
        |||
        ||test|
        |test||

@negative
Scenario: To verify dynamic validation is applied when an invalid template is requested to be created in the system 
    Given I am on Template Service templates resource 
    When I request a template to be created with template object missing when fields are found 
    Then I should get a 400 HTTP status code 
    And I should get a payload with errors information 
