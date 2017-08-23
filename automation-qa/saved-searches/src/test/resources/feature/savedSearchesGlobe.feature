Feature: Saved Searches -Store Globe searches
As a user I want to carry out some actions on my search widget
So that I can verify my saved searches 

@globe
@storeglobesearches1
Scenario Outline: To verify that when MySTA/ anonymous user carries out advanced one way flight searches, the searches are saved on saved searches dropdown
Given I am on globe advanced search page as a "<User>" user
When I select one-way search option
And I fill in details for destination and dates module
And I fill in details for travellers module
And I select a cabin option under flight options 
And I click on search
Then I should see all flights result on the results page
When I navigate to the STA homepage 
And I select the saved searches icon 
Then I should see my advanced one-way flight searches on the dropdown saved

Examples: 
|User     |
|MySTA    |
|Anonymous|

@storeglobesearches2
Scenario Outline: To verify that when MySTA/ anonymous user carries out advanced return flight searches, the searches are saved on saved searches dropdown
Given I am on globe advanced search page as a "<User>" user
When I select return search option
And I fill in return details for destination and dates module
And I fill in details for travellers module
And I select a cabin option under flight options 
And I click on search
Then I should see all flights result on the results page
When I navigate to the STA homepage 
And I select the saved searches icon 
Then I should see my advanced return flight searches on the dropdown saved 

Examples: 
|User     |
|MySTA    |
|Anonymous|

@storeglobesearches3
Scenario Outline: To verify that when MySTA/ anonymous user carries out advanced multicity flight searches, the searches are saved on saved searches dropdown
Given I am on globe advanced search page as a "<User>" user
When I select multi-city search option
And I select the number of flights 
And I fill in details for all flights in destination and dates module
And I fill in details for travellers module
And I select a cabin option under flight options 
And I click on search
Then I should see all flights result on the multi city results page
When I navigate to the STA homepage 
And I select the saved searches icon 
Then I should see my advanced multicity flight searches on the dropdown saved
And the date range should be date of first flight -date of last flight

Examples: 
|User     |
|MySTA    |
|Anonymous|

@storeglobesearches4
Scenario Outline: To verify that when user edits a search, the initial search and the edited search are displayed
Given I am on globe advanced search page as a "<User>" user
When I select multi-city search option
And I select the number of flights 
And I fill in details for all flights in destination and dates module
And I fill in details for travellers module
And I select a cabin option under flight options 
And I select a cabin option under flight options 
And I click on search
Then I should see all flights result on the multi city results page
When I edit the search details 
And I navigate to the STA homepage 
And I select the saved searches icon 
Then I should see the first search 
And I should see the edited search 
 
Examples: 
|User     |
|MySTA    |
|Anonymous|

@storeglobesearches5
Scenario: Verify that user can rerun an advanced saved search   
Given I am on STA homepage
And a valid flight advanced search is already saved  
#If search is not saved, make a valid flight search
When I select the saved search from saved searches drop down
Then I should see all flights result on the results page
When I navigate to the STA homepage 
Then I should not see the search redisplayed on the dropdown
And saved search count should not increase
