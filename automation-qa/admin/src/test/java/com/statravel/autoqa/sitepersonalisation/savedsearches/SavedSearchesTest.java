package com.statravel.autoqa.sitepersonalisation.savedsearches;

import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_NAME;
import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_PASSWORD;

import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.AutomationConstants;
import com.statravel.autoqa.commons.SavedSearchesAssertionMessages;
import com.statravel.autoqa.commons.Utilities;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.enumeration.POS;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginPage;
import com.statravel.autoqa.page.sitepersonalisation.savedsearches.SavedSearchesPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Internal Team
 *
 */
@CucumberStepsDefinition
public class SavedSearchesTest {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private Utilities utilities;

    private static final String VALUE_TO_BE_SELECTED = "3";

    private static final Logger LOGGER = Logger.getLogger(SavedSearchesTest.class);

    private static final String SELECT = "Select";

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Autowired
    private SavedSearchesPage savedSearchesPage;

    /**
     * 
     */
    @Before
    public void init() {
        loginPage.init();
        homePage.init();
        savedSearchesPage.init();

    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     *
     */
    @Given("^I am on admin ui saved searches page$")
    public void iAmOnAdminUiSavedSearchesPage() throws InterruptedException {

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_LOGIN, loginPage.isPageLoaded());

        loginPage.login(ADMIN_NAME, ADMIN_PASSWORD);

        homePage.selectPOS(POS.NZ);

        homePage.clickSavedSearchesMenuItem();

        Assert.assertTrue(SavedSearchesAssertionMessages.SAVED_SEARCHES_PAGE_NOT_LOADED, savedSearchesPage.isPageLoaded());

        Assert.assertTrue(SavedSearchesAssertionMessages.NUMBER_OF_SEARCHES_TITLE_NOT_DISPLAYED,
                webDriverCommons.isDisplayed(savedSearchesPage.getPageElements()
                                                              .getNumberSearchesTitle()));

    }

    /**
     * 
     * @param numberSearches
     *            numberSearches
     */
    @Given("^I set the number of saved searches to \"([^\"]*)\"$")
    public void iSetTheNumberOfSavedSearchesTo(final String numberSearches) {

        savedSearchesPage.waitForElementToBeClickable();
        savedSearchesPage.clickOnNumberOfSerchesInput();
        savedSearchesPage.selectValueFromDropDown(numberSearches);

    }

    /**
    *
    */
    @When("^I select save$")
    public void iSelectSave() {

        savedSearchesPage.clickSaveButton();

    }

    /**
     * 
     * @param numberSearches
     *            numberSearches
     * @throws InterruptedException
     *             InterruptedException
     */
    @Then("^the \"([^\"]*)\" should be saved$")
    public void theShouldBeSaved(final String numberSearches) throws InterruptedException {
        savedSearchesPage.waitForPageLoaded();
        utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_FOUR_SECONDS);
        String maxNumberOfsearchesSaved = savedSearchesPage.getSelectedNumberOfSearches();
        boolean isMaxNumberOfsearchesSaved = maxNumberOfsearchesSaved.equals(numberSearches);
        Assert.assertTrue(SavedSearchesAssertionMessages.MAX_NUMBER_OF_SEARCHES_NOT_SAVED, isMaxNumberOfsearchesSaved);
    }

    /**
    *
    */
    @And("^saved searches active slider is set to No by default$")
    public void savedSearchesActiveSliderIsSetToNoByDefault() {

        try {

            savedSearchesPage.clickOnFlightSearchActiveBarActiveMode();

        } catch (NoSuchElementException nse) {

            LOGGER.debug("Saved searches Flight slider was inactive by default");

        }

        Assert.assertTrue(
                MessageFormat.format(SavedSearchesAssertionMessages.FLIGHT_TOGGLE_ACTIVE_INACTIVE_MESSAGE, SavedSearchesAssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(savedSearchesPage.getPageElements()
                                                              .getSavedSearchesFlightInactive()));

    }

    /**
    *
    */
    @When("^I change it to Yes$")
    public void iChangeItToYes() {

        savedSearchesPage.scrollToFlightTitle();

        savedSearchesPage.clickOnFlightSearchActiveBarInactiveMode();

    }

    /**
    *
    */
    @Then("^the saved searches should be active$")
    public void theSavedSearchesShouldBeActive() {

        Assert.assertTrue(
                MessageFormat.format(SavedSearchesAssertionMessages.FLIGHT_TOGGLE_ACTIVE_INACTIVE_MESSAGE, SavedSearchesAssertionMessages.IS),
                webDriverCommons.isDisplayed(savedSearchesPage.getPageElements()
                                                              .getSavedSearchesFlightActive()));

    }

    /**
    *
    */
    @When("^the Number of Searches is not set to any value$")
    public void theNumberOfSearchesIsNotSetToAnyValue() {

        String selectedNumberOfSearches = savedSearchesPage.getSelectedNumberOfSearches();

        if (!selectedNumberOfSearches.equals(SELECT)) {

            savedSearchesPage.clickOnNumberOfSerchesInput();

            savedSearchesPage.selectValueFromDropDown(SELECT);

        }

    }

    /**
    *
    */
    @Then("^I see the Number of Searches required message$")
    public void iSeeTheNumberOfSearchesRequiredMessage() {

        Assert.assertTrue(SavedSearchesAssertionMessages.NUMBER_OF_SEARCHES_REQUIRED_MESSAGE_NOT_DISPLAYED,
                webDriverCommons.isDisplayed(savedSearchesPage.getPageElements()
                                                              .getNumberOfSearchesRequireMessage()));

    }

    /**
    *
    */
    @When("^I save the Saved searches page$")
    public void iSaveTheSavedSearchesPage() {

        savedSearchesPage.clickSaveButton();

    }

    /**
    *
    */
    @Then("^I should see Number of Searches error message$")
    public void iShouldSeeNumberOfSearchesErrorMessage() {

        Assert.assertTrue(SavedSearchesAssertionMessages.NUMBER_OF_SEARCHES_REQUIRED_MESSAGE_NOT_DISPLAYED,
                webDriverCommons.isDisplayed(savedSearchesPage.getPageElements()
                                                              .getNumberOfSearchesRequireMessage()));

    }

    /**
    *
    */
    @When("^I select a value greater than zero$")
    public void iSelectAValueGreaterThanZero() {

        savedSearchesPage.selectValueFromDropDown(VALUE_TO_BE_SELECTED);

    }

    /**
    *
    */
    @Then("^I should not see Number of Searches error message$")
    public void iShouldNotSeeNumberOfSearchesErrorMessage() {

        Assert.assertFalse(SavedSearchesAssertionMessages.NUMBER_OF_SEARCHES_REQUIRED_MESSAGE_NOT_DISPLAYED, savedSearchesPage.getPageElements()
                                                                                                                              .getNumberOfSearchesRequireMessage()
                                                                                                                              .isDisplayed());

    }

}
