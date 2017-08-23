@GenericSetting
Feature: Generic Setting Module- B2B automation
  As an admin UI user 
  I want to perform some actions on Generic Settings 
  So that I can manage the Terms & Conditions, Contact displayed on the payment form to user

  @GenericSetting1 @Smoke
  Scenario: To verify that user can add details in the generic settings module
    Given I am on Payment Forms Generic settings page
    And the generic settings fields are empty
    And I should see the generic settings required messages on all required fields
    When I fill in details in all the generic settings fields
    And I select save on generic setting
    Then I should see the generic settings fields with filled details
    And I should not see the generic settings required messages on all required fields

  @GenericSetting2 @Regression
  Scenario: To verify that user can edit details in the generic settings module
    Given I am on Payment Forms Generic settings page
    And details have been added in the generic settings fields
    When I edit the details in all the generic settings fields
    And I select save on generic setting
    Then I should see the generic settings fields with edited details

  @GenericSetting3 @Regression
  Scenario: To verify that the contact us phone number field accepts numeric values and symbols: -&*
    Given I am on Payment Forms Generic settings page
    When I enter alphabets in the contact us phone number field
    Then I should see the contact us phone number field error message
    When I change the input to any other character except -&*
    Then I should see the contact us phone number field error message
    When I change the input to only numbers
    Then I should not see the contact us phone number field error message
 
  @GenericSetting4 @Regression
  Scenario: To verify that the banner and hyperlink field does not accept invalid hyperlink
    Given I am on Payment Forms Generic settings page
    When I enter an invalid hyperlink
    Then I should see the invalid hyperlink message
    When I enter invalid image url
    Then I should see invalid image message
    When I change the input to a valid hyperlink
    Then I should not see the invalid hyperlink message
    When I select save on generic setting
    Then I should see banner and hyperlink field with details
