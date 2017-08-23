package com.statravel.autoqa;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.config.SeleniumProperties;
import com.statravel.autoqa.domain.FlightSearch;
import com.statravel.autoqa.domain.User;
import com.statravel.autoqa.page.FlightResultsPage;
import com.statravel.autoqa.page.GlobePage;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginConfirmationPage;
import com.statravel.autoqa.page.LoginInterstitialPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/******
 * 
 * @author STA Development Team
 **/
@CucumberStepsDefinition
public class SavedSearchesGlobeTest {

    private static final String MULTI_CITY = "ML";

    private static final String RETURN = "RT";

    private static final String ONE_WAY = "OW";

    private static final String MY_STA = "MySTA";

    private static final String HYPHEN = " - ";

    private static final Logger LOGGER = Logger.getLogger(SavedSearchesGlobeTest.class);

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginInterstitialPage loginFirstPage;

    @Autowired
    private LoginConfirmationPage loginSecondPage;

    @Autowired
    private GlobePage globePage;

    @Autowired
    private FlightResultsPage resultsPage;

    private static final String LOGOUT = "https://mystatestingglobe.rockpooldigital.com/logout";

    private static int loggedOutSearches = 0;

    private FlightSearch multiCityFlight1 = new FlightSearch.FlightSearchBuilder().setAdults("1")
                                                                                  .setDepartureDestination("London")
                                                                                  .setDepartureCode("LON")
                                                                                  .setArrivalDestination("New York")
                                                                                  .setArrivalCode("NYC")
                                                                                  .build();

    private FlightSearch multiCityFlight2 = new FlightSearch.FlightSearchBuilder().setAdults("1")
                                                                                  .setDepartureDestination("New York")
                                                                                  .setDepartureCode("NYC")
                                                                                  .setArrivalDestination("Los Angeles")
                                                                                  .setArrivalCode("LAX")
                                                                                  .build();

    private FlightSearch multiCityFlight3 = new FlightSearch.FlightSearchBuilder().setAdults("1")
                                                                                  .setDepartureDestination("Los Angeles")
                                                                                  .setDepartureCode("LAX")
                                                                                  .setArrivalDestination("Boston")
                                                                                  .setArrivalCode("BOS")
                                                                                  .build();

    private FlightSearch flightLONtoNYC = new FlightSearch.FlightSearchBuilder().setAdults("1")
                                                                                .setDepartureDestination("London")
                                                                                .setDepartureCode("LON")
                                                                                .setArrivalDestination("New York")
                                                                                .setArrivalCode("NYC")
                                                                                .build();

    private User rekha = new User.UserBuilder().setUsername("rekha.rajendran@statravel.com")
                                               .setPassword("Secret12")
                                               .build();

    /**
    *
    */
    @Before
    public void init() {
        homePage.init();
        resultsPage.init();
        loginFirstPage.init();
        loginSecondPage.init();
        globePage.init();

    }

    /**
     * 
     * @param user
     * @throws InterruptedException
     */
    @Given("^I am on globe advanced search page as a \"([^\"]*)\" user$")
    public void iAmOnGlobeAdvancedSearchPageAsAUser(String user) throws InterruptedException {

        homePage.loadSTAHomePage(homePage.getPageElements()
                                         .getLoginLink());

        if (user.equals(MY_STA)) {

            deleteSavedSearches();

            homePage.loginFromSTAHomePage();
            // loginFirstPage.loginFromFirstLoginPage();
            loginSecondPage.login(rekha);
            homePage.loadSTAHomePage(homePage.getPageElements()
                                             .getSavedSearchesIcon());

        }

        homePage.clickOnMultiCityButton();

        Assert.assertTrue(globePage.getPageElements()
                                   .getAdvancedSearchTitle()
                                   .isDisplayed());
    }

    /**
     * 
     */
    @When("^I select one-way search option$")
    public void iSelectOneWaySearchOption() {

        globePage.selectOneWay();

        Assert.assertTrue(AssertionMessages.ONE_WAY_OPTION_SELECTED, ONE_WAY.equals(globePage.getRadionButtonValue(globePage.getPageElements()
                                                                                                                            .getOneWayFlight())));
    }

    /**
     * 
     */
    @When("^I fill in details for destination and dates module$")
    public void iFillInDetailsForDestinationAndDatesModule() {

        globePage.fillOneWayDestinationsDates(flightLONtoNYC);

    }

    /**
     * 
     */
    @When("^I fill in details for travellers module$")
    public void iFillInDetailsForTravellersModule() {

        globePage.fillTravelers();

    }

    /**
     * 
     */
    @When("^I select a cabin option under flight options$")
    public void iSelectACabinOptionUnderFlightOptions() {

        globePage.fillFlightsOption();

    }

    /**
     * 
     */
    @When("^I click on search$")
    public void iClickOnSearch() {

        globePage.clickOnSearchButton();

    }

    @Then("^I should see all flights result on the results page$")
    public void iShouldSeeAllFlightsResultOnTheResultsPage() {

        Assert.assertTrue(AssertionMessages.RESULT_PAGE_LOADED, resultsPage.isPageLoaded());

        Assert.assertTrue(AssertionMessages.RESULT_PAGE_SEARCH_LOADED, resultsPage.isSearchLoaded());

        resultsPage.waitForFlightResults();

    }

    /**
     * 
     */
    @When("^I navigate to the STA homepage$")
    public void iNavigateToTheSTAHomepage() {

        homePage.loadSTAHomePage(homePage.getPageElements()
                                         .getLoginLink());

    }

    /**
     * 
     */
    @When("^I select the saved searches icon$")
    public void iSelectTheSavedSearchesIcon() {

        homePage.clickOnSavedSearchesIcon();

    }

    /**
     * 
     */
    @Then("^I should see my advanced one-way flight searches on the dropdown saved$")
    public void iShouldSeeMyAdvancedOneWayFlightSearchesOnTheDropdownSaved() {

        Assert.assertTrue(AssertionMessages.ONE_WAY_SEARCH_NOT_DISPLAYED, checkSavedSearchesForFlight(flightLONtoNYC, homePage.getPageElements()
                                                                                                                              .getFirstSavedSearch()));

    }

    /**
     * 
     */
    @When("^I select return search option$")
    public void iSelectReturnSearchOption() {

        globePage.selectReturn();

        Assert.assertTrue(AssertionMessages.RETURN_OPTION_SELECTED, RETURN.equals(globePage.getRadionButtonValue(globePage.getPageElements()
                                                                                                                          .getReturnFlight())));

    }

    /**
     * 
     */
    @When("^I fill in return details for destination and dates module$")
    public void iFillInReturnDetailsForDestinationAndDatesModule() {

        globePage.fillReturnDestinationsDates(flightLONtoNYC);
    }

    /**
     * 
     */
    @Then("^I should see my advanced return flight searches on the dropdown saved$")
    public void iShouldSeeMyAdvancedReturnFlightSearchesOnTheDropdownSaved() {

        Assert.assertTrue(AssertionMessages.RETURN_SEARCH_NOT_DISPLAYED, checkSavedSearchesForFlight(flightLONtoNYC, homePage.getPageElements()
                                                                                                                             .getFirstSavedSearch()));
    }

    /**
     * 
     */
    @Given("^a valid flight advanced search is already saved$")
    public void aValidFlightAdvancedSearchIsAlreadySaved() {

        if (homePage.getNumberOfSavedSearches() == 0) {

            homePage.clickOnMultiCityButton();
            iSelectOneWaySearchOption();
            iFillInDetailsForDestinationAndDatesModule();
            iFillInDetailsForTravellersModule();
            iClickOnSearch();
            iShouldSeeAllFlightsResultOnTheResultsPage();
            iNavigateToTheSTAHomepage();

        }

    }

    /**
    *
    */
    @Then("^saved search count should not increase$")
    public void savedSearchCountShouldNotIncrease() {
        LOGGER.info("the saved search count should not increase");

        Assert.assertTrue(String.format(AssertionMessages.SAVED_SEARCH_COUNT_NOT_UPDATING, loggedOutSearches, homePage.getPageElements()
                                                                                                                      .getSavedSearchCircle()
                                                                                                                      .getAttribute("innerHTML")),
                homePage.getPageElements()
                        .getSavedSearchCircle()
                        .getAttribute("innerHTML")
                        .equals(String.valueOf(1)));
    }

    /**
     * 
     */
    @When("^I select multi-city search option$")
    public void iSelectMultiCitySearchOption() {

        globePage.selectMultiCity();

        Assert.assertTrue(AssertionMessages.MULTI_CITY_OPTION_SELECTED, MULTI_CITY.equals(globePage.getRadionButtonValue(globePage.getPageElements()
                                                                                                                                  .getMultiCityFlight())));
    }

    /**
     * 
     */
    @When("^I select the number of flights$")
    public void iSelectTheNumberOfFlights() {

        globePage.selectNumberOfFlights();

    }

    /**
     * 
     */
    @When("^I fill in details for all flights in destination and dates module$")
    public void iFillInDetailsForAllFlightsInDestinationAndDatesModule() {

        globePage.fillMultiCityDestinationsDates(multiCityFlight1, multiCityFlight2, multiCityFlight3);

        globePage.setDateSelected(globePage.getPageElements()
                                           .getMultiCityInputDate1(),
                multiCityFlight1);

        globePage.setDateSelected(globePage.getPageElements()
                                           .getMultiCityInputDate3(),
                multiCityFlight3);

    }

    /**
     * 
     */
    @Then("^I should see all flights result on the multi city results page$")
    public void iShouldSeeAllFlightsResultOnTheMultiCityResultsPage() {

        Assert.assertTrue("", resultsPage.isPageLoaded());

        Assert.assertTrue("", resultsPage.isMultiCitySearchLoaded());

        resultsPage.waitForMultiCityFlightResults();

    }

    /**
     * 
     */
    @Then("^I edit the search details$")
    public void iEditTheSearchDetails() {

        resultsPage.editMultiCitySearch();

        iShouldSeeAllFlightsResultOnTheMultiCityResultsPage();

    }

    /**
     * 
     */
    @Then("^I should see my advanced multicity flight searches on the dropdown saved$")
    public void iShouldSeeMyAdvancedMulticityFlightSearchesOnTheDropdownSaved() {

        Assert.assertTrue(AssertionMessages.MULTICITY_SEARCH_NOT_DISPLAYED,
                checkSavedSearchesForMultiCity(multiCityFlight1, multiCityFlight2, multiCityFlight3, homePage.getPageElements()
                                                                                                             .getFirstSavedSearch()));

    }

    /**
     * 
     */
    @Then("^the date range should be date of first flight -date of last flight$")
    public void theDateRangeShouldBeDateOfFirstFlightDateOfLastFlight() {

        Assert.assertTrue(AssertionMessages.MULTICITY_SEARCH_DATES_NOT_DISPLAYED, checkDatesForMultiCity(multiCityFlight1, multiCityFlight3));

    }

    /**
     * 
     */
    @Then("^I should see the first search$")
    public void iShouldSeeTheFirstSearch() {

        Assert.assertTrue(AssertionMessages.MULTICITY_FIRST_SEARCH_NOT_DISPLAYED,
                checkSavedSearchesForMultiCity(multiCityFlight1, multiCityFlight2, multiCityFlight3, homePage.getPageElements()
                                                                                                             .getFirstSavedSearch()));

    }

    /**
     * 
     */
    @And("^I should see the edited search $")
    public void iShouldSeeTheEditedSearch() {

        Assert.assertTrue(AssertionMessages.MULTICITY_EDITED_SEARCH_NOT_DISPLAYED,
                checkSavedSearchesForMultiCity(multiCityFlight1, multiCityFlight2, multiCityFlight3, homePage.getPageElements()
                                                                                                             .getEditedSavedSearch()));

    }

    /**
     * 
     * @param search
     *            the flight we are checking for
     * @param element
     *            element from the view
     * @return if the search is displayed in the drop down
     */
    private boolean checkSavedSearchesForFlight(final FlightSearch search, final WebElement element) {

        String searchQuery = homePage.getSearchQuery(element);

        return (searchQuery.contains("departureDestLocation=" + search.getArrivalCode())
                && searchQuery.contains("departureOriginLocation=" + search.getDepartureCode()));

    }

    /**
     * 
     * @param search1
     *            the flight we are checking for
     * @param search2
     *            the flight we are checking for
     * @param search3
     *            the flight we are checking for
     * @param element
     *            element from the view
     * @return if the search is displayed in the drop down
     */
    private boolean checkSavedSearchesForMultiCity(final FlightSearch search1, final FlightSearch search2, final FlightSearch search3,
            final WebElement element) {

        String searchQuery = homePage.getSearchQuery(element);

        return (searchQuery.contains("destinationLocationCode=" + search1.getArrivalCode())
                && searchQuery.contains("originLocationCode=" + search1.getDepartureCode())
                && searchQuery.contains("destinationLocationCode=" + search2.getArrivalCode())
                && searchQuery.contains("originLocationCode=" + search2.getDepartureCode())
                && searchQuery.contains("destinationLocationCode=" + search3.getArrivalCode())
                && searchQuery.contains("originLocationCode=" + search3.getDepartureCode()));

    }

    /**
     * 
     * @param search1
     *            the flight we are checking for
     * @param search3
     *            the flight we are checking for
     * @return if the search is displayed in the drop down
     */
    private boolean checkDatesForMultiCity(final FlightSearch search1, final FlightSearch search3) {

        String multiCityDates = homePage.getMultiCityDates();

        return (multiCityDates.equals(search1.getDepartureDate() + HYPHEN + search3.getDepartureDate()));

    }

    /**
    *
    */
    public void deleteSavedSearches() {

        login(rekha);

        try {
            webDriverCommons.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.getPageElements()
                .getSavedSearchesIcon()
                .click();

        int searches = homePage.getNumberOfSavedSearches();

        LOGGER.info("the value of searches is: " + searches);

        while (searches > 0) {

            homePage.getPageElements()
                    .getSavedSearchesIcon()
                    .click();

            webDriverCommons.waitForElementToBeVisible(homePage.getPageElements()
                                                               .getFirstSavedSearchDelete());

            homePage.getPageElements()
                    .getFirstSavedSearchDelete()
                    .click();

            searches--;

        }

        LOGGER.info("the value of searches is: " + searches);

        logout();
    }

    /**
     *
     * @param user
     *            the user to login
     */
    public void login(final User user) {

        webDriverCommons.goToUrl(SeleniumProperties.getAppURL());

        webDriverCommons.waitForElementToBeVisible(homePage.getPageElements()
                                                           .getLoginLink());

        homePage.getPageElements()
                .getLoginLink()
                .click();

        webDriverCommons.waitForLoad();

        webDriverCommons.waitForElementToBeVisible(loginFirstPage.getPageElements()
                                                                 .getLoginLink());

        loginFirstPage.getPageElements()
                      .getLoginLink()
                      .click();

        webDriverCommons.waitForLoad();

        // loginSecondPage.login(user);

        webDriverCommons.goToUrl(SeleniumProperties.getAppURL());

        webDriverCommons.waitForElementToBeVisible(homePage.getPageElements()
                                                           .getSavedSearchesIcon());

        try {
            webDriverCommons.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
    *
    */
    public void logout() {

        webDriverCommons.goToUrl(LOGOUT);

        webDriverCommons.waitForLoad();

        webDriverCommons.goToUrl(SeleniumProperties.getAppURL());

    }

}
