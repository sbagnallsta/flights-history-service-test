package com.statravel.autoqa;

import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.AutomationConstants;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.FlightSearch;
import com.statravel.autoqa.domain.User;
import com.statravel.autoqa.page.FlightResultsPage;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginConfirmationPage;
import com.statravel.autoqa.page.LoginInterstitialPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/******
 * 
 * @author STA Development Team
 **/
@CucumberStepsDefinition
public class SavedSearchesTest {

    private static final Logger LOGGER = Logger.getLogger(SavedSearchesTest.class);

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginInterstitialPage loginInterstitialPage;

    @Autowired
    private LoginConfirmationPage loginSecondPage;

    @Autowired
    private FlightResultsPage resultsPage;

    private static int loggedOutSearches = 0;
    private static int loggedInSearches = 0;

    private FlightSearch mostRecentSearch;

    private FlightSearch flightAKLtoLON = new FlightSearch.FlightSearchBuilder().setAdults(AutomationConstants.ADULT_NO)
                                                                                .setDepartureDestination(AutomationConstants.DESTINATION_AUCKLAND)
                                                                                .setDepartureCode(AutomationConstants.CODE_AKL)
                                                                                .setArrivalDestination(AutomationConstants.DESTINATION_LONDON)
                                                                                .setArrivalCode(AutomationConstants.CODE_LON)
                                                                                .build();

    private FlightSearch flightLONtoLIS = new FlightSearch.FlightSearchBuilder().setAdults(AutomationConstants.ADULT_NO)
                                                                                .setDepartureDestination(AutomationConstants.DESTINATION_LONDON)
                                                                                .setDepartureCode(AutomationConstants.CODE_LON)
                                                                                .setArrivalDestination(AutomationConstants.DESTINATION_LISBON)
                                                                                .setArrivalCode(AutomationConstants.CODE_LIS)
                                                                                .build();

    private String type = "";

    private User rekha = new User.UserBuilder().setUsername(AutomationConstants.USER_NAME)
                                               .setPassword(AutomationConstants.PASSWORD)
                                               .build();

    /**
    *
    */
    @Before
    public void init() {
        homePage.init();
        resultsPage.init();
        loginInterstitialPage.init();
        loginSecondPage.init();

    }

    /**
    *
    */
    @Given("^I am on STA homepage$")
    public void iAmOnSTAHomepage() {
        LOGGER.info("I am on STA homepage");

        webDriverCommons.goToUrl(AutomationConstants.HOME);

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_HOME, webDriverCommons.isDisplayed(homePage.getPageElements()
                                                                                                       .getLoginLink()));
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     */
    @Given("^I am on STA homepage with no saved serches saved$")
    public void iAmOnSTAHomepageWithNoSavedSerchesSaved() throws InterruptedException {
        LOGGER.info("I am on STA homepage");

        if (homePage.getNumberOfSavedSearches() != 0) {
            homePage.deleteSavedSearches();
        }

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_HOME, webDriverCommons.isDisplayed(homePage.getPageElements()
                                                                                                       .getLoginLink()));

    }

    /**
    *
    */
    @Given("^saved searches icon is displayed$")
    public void savedSearchesIconIsDisplayed() {
        LOGGER.info("saved searches icon is displayed");

        Assert.assertTrue(AssertionMessages.SAVED_SEARCH_ICON_NOT_DISPLAYED, webDriverCommons.isDisplayed(homePage.getPageElements()
                                                                                                                  .getSavedSearchesIcon()));

    }

    /**
    *
    */
    @Given("^new search message is displayed on the drop down$")
    public void newSearchMessageIsDisplayedOnTheDropDown() {
        LOGGER.info("new search message is displayed on the drop down");

        homePage.clickOnSavedSearchesIcon();

        webDriverCommons.hoverOver(homePage.getPageElements()
                                           .getSavedSearchesIcon());

        Assert.assertTrue(AssertionMessages.SEARCH_MESSAGE_NOT_DISPLAY, webDriverCommons.isDisplayed(homePage.getPageElements()
                                                                                                             .getSavedSearchesNewMessage()));

        Assert.assertTrue(AssertionMessages.SEARCH_MESSAGE_NOT_DISPLAY, homePage.getPageElements()
                                                                                .getSavedSearchesNewMessage()
                                                                                .getText()
                                                                                .equals(AutomationConstants.MESSAGE_WITHOUT_ANY_SEARCH));

    }

    /**
     * @param flightType
     *            a string which is the type of flight - one-way or return
     */
    @When("^I make a valid \"([^\"]*)\" flight search$")
    public void iMakeAValidFlightSearch(final String flightType) {
        LOGGER.info("I make a valid " + flightType + " flight search");
        loggedOutSearches++;
        loggedInSearches++;
        mostRecentSearch = flightLONtoLIS;
        type = flightType;
        homePage.makeFlightSearch(flightLONtoLIS, flightType);
    }

    /**
    *
    */
    @Then("^I should see the flight results on the flights result page$")
    public void iShouldSeeTheFlightResultsOnTheFlightsResultPage() {
        LOGGER.info("I should see the flight results on the flights result page");

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_FLIGHT_RESULT, webDriverCommons.isDisplayed(resultsPage.getPageElements()
                                                                                                                   .getFlightCounter()));

        String toFrom = webDriverCommons.getText(resultsPage.getPageElements()
                                                            .getFlightSearchToFrom());

        Assert.assertTrue("", toFrom.contains(mostRecentSearch.getDepartureCode() + " " + mostRecentSearch.getArrivalCode()));

        String flightType = webDriverCommons.getText(resultsPage.getPageElements()
                                                                .getFlightSearchType());

        Assert.assertTrue("", flightType.equalsIgnoreCase(type + " Flight"));

    }

    /**
    *
    */
    @Then("^I should see the search saved on saved searches drop down$")
    public void iShouldSeeTheSearchSavedOnSavedSearchesDropDown() {
        LOGGER.info("I should see the search saved on saved searches drop down");

        Assert.assertTrue(AssertionMessages.MOST_RECENT_SEARCH_NOT_DISPLAYED, homePage.checkSavedSearchesForFlight(mostRecentSearch));
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     */
    @When("^I log in to mySTA account$")
    public void iLogInToMySTAAccount() throws InterruptedException {
        LOGGER.info("I log in to mySTA account");
        homePage.login(rekha);
    }

    /**
     * @param flightType
     *            a string which is the type of flight - one-way or return
     */
    @When("^I make another valid \"([^\"]*)\" flight search$")
    public void iMakeAnotherValidFlightSearch(final String flightType) {
        LOGGER.info("I make another valid " + flightType + " flight search");

        loggedOutSearches++;
        loggedInSearches++;

        mostRecentSearch = flightAKLtoLON;
        type = flightType;

        homePage.makeFlightSearch(flightAKLtoLON, flightType);
    }

    /**
    *
    */
    @When("^the saved search count should update$")
    public void theSavedSearchCountShouldUpdate() {
        LOGGER.info("the saved search count should update");
        if (homePage.signedIn()) {
            Assert.assertTrue(MessageFormat.format(AssertionMessages.SAVED_SEARCH_COUNT_NOT_UPDATING, loggedInSearches, homePage.getPageElements()
                                                                                                                                .getSavedSearchCircle()
                                                                                                                                .getAttribute(
                                                                                                                                        "innerHTML")),
                    homePage.getPageElements()
                            .getSavedSearchCircle()
                            .getAttribute("innerHTML")
                            .equals(String.valueOf(loggedInSearches)));

        } else {
            Assert.assertTrue(MessageFormat.format(AssertionMessages.SAVED_SEARCH_COUNT_NOT_UPDATING, loggedOutSearches, homePage.getPageElements()
                                                                                                                                 .getSavedSearchCircle()
                                                                                                                                 .getAttribute(
                                                                                                                                         "innerHTML")),
                    homePage.getPageElements()
                            .getSavedSearchCircle()
                            .getAttribute("innerHTML")
                            .equals(String.valueOf(loggedOutSearches)));
        }
    }

    /**
    *
    */
    @When("^I log out of mySTA account$")
    public void iLogOutOfMySTAAccount() {
        LOGGER.info("I log out of mySTA account");
        loggedOutSearches = 0;

        homePage.logout();
    }

    /**
    *
    */
    @Then("^I should not see my saved searches on the drop down$")
    public void iShouldNotSeeMySavedSearchesOnTheDropDown() {
        LOGGER.info("I should not see my saved searches on the drop down");

        Assert.assertTrue(MessageFormat.format(AssertionMessages.SAVED_SEARCH_COUNT_NOT_UPDATING, 0, homePage.getNumberOfSavedSearches()),
                homePage.getNumberOfSavedSearches() == 0);

    }

    /**
    *
    */
    @When("^I make a valid flight search$")
    public void iMakeAValidFlightSearch() {
        LOGGER.info("I make a valid flight search");

        loggedOutSearches++;
        loggedInSearches++;
        mostRecentSearch = flightLONtoLIS;
        type = "one-way";

        homePage.makeFlightSearch(flightLONtoLIS, AutomationConstants.ONE_WAY);
    }

    /**
    *
    */
    @When("^I make a different valid flight search$")
    public void iMakeADifferentValidFlightSearch() {
        LOGGER.info("I make a different valid flight search");

        loggedOutSearches++;
        loggedInSearches++;
        mostRecentSearch = flightAKLtoLON;
        type = "one-way";

        homePage.makeFlightSearch(flightAKLtoLON, AutomationConstants.ONE_WAY);
    }

    /**
    *
    */
    @When("^I repeat a valid flight search$")
    public void iRepeatAValidFlightSearch() {
        LOGGER.info("I repeat a valid flight search");
        mostRecentSearch = flightLONtoLIS;

        homePage.makeFlightSearch(flightLONtoLIS, AutomationConstants.ONE_WAY);
    }

    /**
    *
    */
    @Then("^I should not see the search redisplayed on the dropdown$")
    public void iShouldNotSeeTheSearchRedisplayedOnTheDropdown() {
        LOGGER.info("I should not see the search redisplayed on the dropdown");

        if (homePage.getNumberOfSavedSearches() > 1) {

            Assert.assertFalse(MessageFormat.format(AssertionMessages.SAME_SAVED_SEARCHES_SHOULD_NOT_APPEAR_MORE_THEN_ONCE,
                    webDriverCommons.getText(homePage.getPageElements()
                                                     .getFirstSavedSearch()),
                    webDriverCommons.getText(homePage.getPageElements()
                                                     .getSecondSavedSearch())),
                    webDriverCommons.getText(homePage.getPageElements()
                                                     .getSecondSavedSearch())
                                    .equals(webDriverCommons.getText(homePage.getPageElements()
                                                                             .getFirstSavedSearch())));

        } else {

            Assert.assertTrue(MessageFormat.format(AssertionMessages.SAVED_SEARCH_COUNT_NOT_UPDATING, 1, homePage.getNumberOfSavedSearches()),
                    homePage.getNumberOfSavedSearches() == 1);

        }
    }

    /**
    *
    */
    @Then("^the saved search count should not increase$")
    public void theSavedSearchCountShouldNotIncrease() {
        LOGGER.info("the saved search count should not increase");
        theSavedSearchCountShouldUpdate();
    }

    /**
    *
    */
    @Given("^a valid flight search is already saved$")
    public void aValidFlightSearchIsAlreadySaved() {
        LOGGER.info("a valid flight search is already saved");

        if (homePage.getNumberOfSavedSearches() == 0) {
            iMakeAValidFlightSearch();
            iShouldSeeTheFlightResultsOnTheFlightsResultPage();
            iAmOnSTAHomepage();
        }

        Assert.assertTrue(AssertionMessages.SAVED_SEARCH_COUNT_SHOULD_NOT_BE_ZERO, homePage.getNumberOfSavedSearches() > 0);
    }

    /**
    *
    */
    @When("^I select the saved search from saved searches drop down$")
    public void iSelectTheSavedSearchFromSavedSearchesDropDown() {
        LOGGER.info("I select the saved search from saved searches drop down");

        homePage.clickOnSavedSearchIcon();

        homePage.ClickOnFirstSavedSearch();

    }
}
