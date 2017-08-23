@savedsearches
Feature: Saved Searches- Automation
  As a user   
  I want to see my last X searches on the STA Travel website  
  so that I can easily repeat them when visiting the site again

  @savedsearches1
  Scenario Outline: Verify that searches are saved when user is not logged in and synchronised when user logs in
    Given I am on STA homepage with no saved serches saved
    And saved searches icon is displayed
    And new search message is displayed on the drop down
    When I make a valid "<flight type>" flight search
    Then I should see the flight results on the flights result page
    When I am on STA homepage
    #Then I should see the search saved on saved searches drop down
    When I log in to mySTA account
    And I am on STA homepage
    #Then I should see the search saved on saved searches drop down
    When I make another valid "<flight type>" flight search
    Then I should see the flight results on the flights result page
    When I am on STA homepage
    # And I should see the search saved on saved searches drop down
    # And the saved search count should update
    When I log out of mySTA account
    And I am on STA homepage

    #Then I should not see my saved searches on the drop down
    Examples: 
      | flight type |
      | Return      |
      | One-way     |

  @savedsearches2
  Scenario: Verify that a new search is not saved when details are the same with a previous saved search
    Given I am on STA homepage with no saved serches saved
    When I make a valid flight search
    Then I should see the flight results on the flights result page
    When I am on STA homepage
    # Then I should see the search saved on saved searches drop down
    When I make a different valid flight search
    Then I should see the flight results on the flights result page
    When I am on STA homepage
    #Then I should see the search saved on saved searches drop down
    #And the saved search count should update
    When I repeat a valid flight search
    Then I should see the flight results on the flights result page
    When I am on STA homepage

  #Then I should see the search saved on saved searches drop down
  #And I should not see the search redisplayed on the dropdown
  #And the saved search count should not increase
  @savedsearches3
  Scenario: Verify that user can rerun a saved search
    Given I am on STA homepage
    And a valid flight search is already saved
    #If search is not saved, make a valid flight search
    When I select the saved search from saved searches drop down
    Then I should see the flight results on the flights result page
    When I am on STA homepage
    And I should not see the search redisplayed on the dropdown
    And I should see the search saved on saved searches drop down
    And the saved search count should not increase
