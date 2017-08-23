package com.statravel.autoqa.page.sitepersonalisation.savedsearches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class SavedSearchesPage extends Page<SavedSearchesPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private SavedSearchesPageElements savedSearchesPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(savedSearchesPageElements.getNumberSearches());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        savedSearchesPageElements = new SavedSearchesPageElements();

        super.initialiseElements(savedSearchesPageElements);

    }

    /**
     * Waits for element to be clickable.
     */
    public void waitForElementToBeClickable() {

        webDriverCommons.waitForElementToBeClickable(savedSearchesPageElements.getNumberSearches());
    }

    /**
     * scroll to saved searches drop down.
     */
    public void waitForPageLoaded() {

        webDriverCommons.waitForPageLoaded();

    }

    /**
     * scroll to flight title.
     */
    public void scrollToFlightTitle() {

        webDriverCommons.scrollTo(savedSearchesPageElements.getNumberSearchesTitle());
    }

    /**
     * scroll to flight title.
     */
    public void scrollToSaveButton() {

        webDriverCommons.scrollTo(savedSearchesPageElements.getSaveButton());
    }

    /**
     * scroll to flight title.
     */
    public void scrollToNumberSearches() {

        webDriverCommons.scrollTo(savedSearchesPageElements.getNumberSearches());
    }

    /**
     * Selects a value from a drop down.
     * 
     * @param value
     *            to be selected on the drop down
     */
    public void selectValueFromDropDown(final String value) {

        webDriverCommons.selectFromDropdown(savedSearchesPageElements.getNumberSearches(), value);

    }

    /**
     * Gets selected number of searches.
     * 
     * @return selected number of searches
     */
    public String getSelectedNumberOfSearches() {

        return webDriverCommons.getSelectedValueFromDropdown(savedSearchesPageElements.getNumberSearches());

    }

    /**
     * Clicks on save button.
     */
    public void clickSaveButton() {

        webDriverCommons.click(savedSearchesPageElements.getSaveButton());

    }

    /**
     * 
     */
    @Override
    public SavedSearchesPageElements getPageElements() {

        return savedSearchesPageElements;
    }

    /**
     * Click on number of searches input.
     */
    public void clickOnNumberOfSerchesInput() {
        webDriverCommons.click(savedSearchesPageElements.getNumberSearches());

    }

    /**
     * click on saved search flight active bar active mode.
     */
    public void clickOnFlightSearchActiveBarActiveMode() {
        webDriverCommons.click(savedSearchesPageElements.getSavedSearchesFlightActive());

    }

    /**
     * click on saved search flight active bar inactive mode.
     */
    public void clickOnFlightSearchActiveBarInactiveMode() {
        webDriverCommons.click(savedSearchesPageElements.getSavedSearchesFlightInactive());

    }

}
