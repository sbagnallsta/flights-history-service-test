@Cost @Regression
Feature: Travel and Partner information module- B2B automation
  As an admin UI user 
  I want to perform some actions on B2B Payment portal Cost/Prices section 
  So that I can manage Cost/Prices details displayed on payment form

  @Cost1 @Smoke
  Scenario Outline: Verify that user must select at least one required cost on the form
    Given I am on Payment Form Details page
    And I should see one cost required messages on all require cost fields
    When I select "<cost option>"
    Then I should see selected "<cost option>" required message
    But I should not see one cost required messages on all require cost fields
    When I fill in cost details for the selected "<cost option>" field
    Then I should not see required message on the selected "<cost option>"

    Examples: 
      | cost option   |
      | Flight        |
      | Accommodation |
      | Transfer      |
      | Others        |

  @Cost2
  Scenario: Verify that user can select all required cost options on the form
    Given I am on Payment Form Details page
    And I should see one cost required messages on all require cost fields
    And all cost input field should be disable
    When I select all cost options
    Then I should see required message on all cost fields
    When I fill in cost details for all cost
    Then I should not see required message on all cost fields

  @Cost3
  Scenario Outline: Verify that user can edit details on cost options on the form
    Given I am on Payment Form Details page
    When I select "<cost option>"
    And I fill in cost details for the selected "<cost option>" field
    Then I should not see required message on the selected "<cost option>"
    When I edit the cost details in the "<cost option>" field
    Then I should see the edited details in the "<cost option>" field

    Examples: 
      | cost option   |
      | Flight        |
      | Accommodation |
      | Transfer      |
      | Others        |

  @Cost4
  Scenario Outline: Verify that balance updates by default when deposit field is activated and one cost is selected on the form
    Given I am on Payment Form Details page
    When I select "<cost option>"
    When I fill in cost details for the selected "<cost option>" field
    And I activate balance section
    Then I should see the balance field required message
    And I should not be able to fill in details for balance
    When I activate the deposit section
    Then I should see the deposit field required message
    And I should see the balance updated by default to the amount of the "<cost option>"
    When I fill in the deposit field
    #deposit must be lower than price of the "<cost option>"
    Then I should see the balance updated by default

    Examples: 
      | cost option   |
      | Flight        |
      | Accommodation |
      | Transfer      |
      | Others        |

  @Cost5
  Scenario: Verify that balance updates by default when deposit field is activated and all cost is selected on the form
    Given I am on Payment Form Details page
    And I should see one cost required messages on all require cost fields
    When I select all cost options
    Then I should see required message on all cost fields
    When I fill in cost details for all cost
    Then I should not see required message on all cost fields
    # all cost include deposit as well
    When I activate balance section
    #deposit must be lower than price of all the cost options
    Then I should see the balance updated by default to the amount of all cost options -deposit

  @Cost6
  Scenario: Verify that when user selects flight + accommodation, it is included in the total cost
    Given I am on Payment Form Details page
    When I fill cost for flights
    And I fill cost for accommodation
    And I activate the deposit section
    And I fill in the deposit field
    And I activate balance section
    #deposit must be lower than price of the accommodation+flights
    Then I should see the balance updated by default to the amount of flights+accommodation-deposit
