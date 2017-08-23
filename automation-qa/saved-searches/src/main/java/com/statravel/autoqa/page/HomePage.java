package com.statravel.autoqa.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.AutomationConstants;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.config.SeleniumProperties;
import com.statravel.autoqa.domain.FlightSearch;
import com.statravel.autoqa.domain.User;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class HomePage extends Page<HomePageElements> {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    private static final String DATA_SEARCHQUERY = "data-searchquery";

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private LoginInterstitialPage loginInterstitialPage;

    @Autowired
    private LoginConfirmationPage loginConfirmationPage;

    @Autowired
    private GlobePage globePage;

    private HomePageElements homePageElements;

    private static final String HOME = "http://nzid.bluee.net/";

    private static int loggedOutSearches = 0;

    private static int loggedInSearches = 0;

    private User rekha = new User.UserBuilder().setUsername(AutomationConstants.USER_NAME)
                                               .setPassword(AutomationConstants.PASSWORD)
                                               .build();

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        homePageElements = new HomePageElements();

        super.initialiseElements(homePageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public HomePageElements getPageElements() {

        return homePageElements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(homePageElements.getLoginLink());

    }

    /**
     * 
     * @param search
     *            the flight we are going to search for
     */
    private void fillSearch(final FlightSearch search) {

        webDriverCommons.selectFromDropdown(homePageElements.getAdults(), search.getAdults());

        webDriverCommons.sendKeys(homePageElements.getFlightDepatureInput(), search.getDepartureDestination());

        webDriverCommons.click(homePageElements.getDepartureCityOneWay());

        webDriverCommons.sendKeys(homePageElements.getFlightArrivalInput(), search.getArrivalDestination());

        webDriverCommons.click(homePageElements.getArrivalCityOneWay());

        webDriverCommons.click(homePageElements.getDepartureCalander());

        webDriverCommons.click(homePageElements.getDepartureDate());

    }

    /**
     * 
     * @param search
     *            the flight we are going to search for
     */
    public void fillOneWayFlightSearch(final FlightSearch search) {

        webDriverCommons.click(homePageElements.getOneWayButton());

        fillSearch(search);

    }

    /**
     * 
     * @param search
     *            the flight we are going to search for
     */
    public void fillReturnFlightSearch(final FlightSearch search) {

        webDriverCommons.click(homePageElements.getReturnButton());

        fillSearch(search);

        webDriverCommons.click(homePageElements.getReturnCalander());

        webDriverCommons.click(homePageElements.getReturnDate());

    }

    /**
     * 
     */
    public void makeSearch() {

        webDriverCommons.click(homePageElements.getFindFlightButton());

    }

    public void loadSTAHomePage(WebElement element) {

        webDriverCommons.goToUrl(SeleniumProperties.getAppURL());
        webDriverCommons.waitForElementToBeVisible(element);
    }

    public void loginFromSTAHomePage() {

        webDriverCommons.click(homePageElements.getLoginLink());

        webDriverCommons.waitForLoad();

        webDriverCommons.waitForElementToBeVisible(loginInterstitialPage.getPageElements()
                                                                        .getLoginLink());

    }

    public int getNumberOfSearchesSaved() {

        String value = homePageElements.getSavedSearchesIcon()
                                       .getText()
                                       .replaceAll("[\\D]", "");
        return (value.equals("")) ? 0 : Integer.parseInt(value);

    }

    public void clickOnMultiCityButton() {

        webDriverCommons.click(homePageElements.getMultiCityButton());
        webDriverCommons.waitForElementToBeVisible(globePage.getPageElements()
                                                            .getAdvancedSearchTitle());

    }

    public void clickOnSavedSearchesIcon() {

        webDriverCommons.click(homePageElements.getSavedSearchesIcon());

    }

    public void clickOnSearch() {

        webDriverCommons.click(homePageElements.getSearchToReRun());

    }

    public String getMultiCityDates() {

        return webDriverCommons.getText(homePageElements.getMultiCityDate());

    }

    public String getSearchQuery(WebElement element) {

        return element.getAttribute(DATA_SEARCHQUERY);

    }

    /**
     * Click on saved search Icon.
     */
    public void clickOnSavedSearchIcon() {
        webDriverCommons.click(homePageElements.getSavedSearchesIcon());

    }

    /**
     * Click on first saved search.
     */
    public void ClickOnFirstSavedSearch() {
        webDriverCommons.click(homePageElements.getFirstSavedSearch());

    }

    /**
     *
     * @param search
     *            the flight to search for
     * @param type
     *            either return or one-way
     */
    public void makeFlightSearch(final FlightSearch search, final String type) {
        webDriverCommons.waitForLoad();

        webDriverCommons.waitForElementToBeVisible(homePageElements.getDepartureCalander());

        if (type.equalsIgnoreCase(AutomationConstants.RETURN_FLIGHT)) {

            fillReturnFlightSearch(search);

        } else {

            fillOneWayFlightSearch(search);
        }

        makeSearch();

    }

    /**
     *
     * @param user
     *            the user to login
     * @throws InterruptedException
     *             InterruptedException
     */
    public void login(final User user) throws InterruptedException {

        webDriverCommons.goToUrl(HOME);

        webDriverCommons.click(homePageElements.getLoginLink());

        webDriverCommons.waitForLoad();

        webDriverCommons.click(loginInterstitialPage.getPageElements()
                                                    .getLoginLink());

        webDriverCommons.waitForLoad();

        loginConfirmationPage.login(user);

        webDriverCommons.goToUrl(HOME);

        String value = webDriverCommons.getText(homePageElements.getSavedSearchesIcon())
                                       .replaceAll("[\\D]", "");

        loggedInSearches = (value.equals("")) ? 0 : Integer.parseInt(value);

    }

    /**
    *
    */
    public void logout() {

        // webDriverCommons.click(homePageElements.getLoginLink());
        //
        // webDriverCommons.click(homePageElements.getLogoutLink());
        webDriverCommons.hoverOverAndClick(homePageElements.getLoginLink(), homePageElements.getLogoutLink());

        // webDriverCommons.goToUrl(LOGOUT);
        //
        // webDriverCommons.waitForLoad();

        // webDriverCommons.goToUrl(HOME);

    }

    /**
     * @return if user is signed in or not
     */
    public boolean signedIn() {
        return (!homePageElements.getLoginLink()
                                 .getAttribute("innerHTML")
                                 .contains("Sign in"));
    }

    /**
     * @param search
     *            the flight we are checking for
     * @return if the search is there
     */
    public boolean checkSavedSearchesForFlight(final FlightSearch search) {

        webDriverCommons.waitForElementToBeVisible(homePageElements.getSavedSearchesIcon());

        webDriverCommons.click(homePageElements.getSavedSearchesIcon());

        String searchQuery = homePageElements.getFirstSavedSearch()
                                             .getAttribute("data-searchquery");

        LOGGER.info(searchQuery);

        return (searchQuery.contains("departureDestLocation=" + search.getArrivalCode())
                && searchQuery.contains("departureOriginLocation=" + search.getDepartureCode()));

    }

    /**
     * 
     * @return the number of saved searches
     */
    public int getNumberOfSavedSearches() {
        String value = webDriverCommons.getText(homePageElements.getSavedSearchesIcon())

                                       .replaceAll("[\\D]", "");
        return (value.equals("")) ? 0 : Integer.parseInt(value);
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     */
    public void deleteSavedSearches() throws InterruptedException {

        login(rekha);

        webDriverCommons.click(homePageElements.getSavedSearchesIcon());

        int searches = getNumberOfSavedSearches();

        LOGGER.info("the value of searches is: " + searches);

        while (searches > 0) {

            webDriverCommons.click(homePageElements.getSavedSearchesIcon());

            webDriverCommons.click(homePageElements.getFirstSavedSearchDelete());

            searches--;

        }

        LOGGER.info("the value of searches is: " + searches);

        logout();
    }

}
