package com.statravel.autoqa.page;

import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.commons.WebDriverFactory;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class FlightResultsPage extends Page<FlightResultsPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FlightResultsPageElements flightResultsPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        flightResultsPageElements = new FlightResultsPageElements();

        super.initialiseElements(flightResultsPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public FlightResultsPageElements getPageElements() {

        return flightResultsPageElements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(flightResultsPageElements.getFlightSearchResultsPageId());
    }

    public boolean isSearchLoaded() {

        return webDriverCommons.isDisplayed(flightResultsPageElements.getPageContent());
    }

    public boolean isMultiCitySearchLoaded() {

        return webDriverCommons.isDisplayed(flightResultsPageElements.getMultiCityResult());
    }

    /**
    *
    */
    public void waitForFlightResults() {

        webDriverCommons.waitForElementToBeVisible(flightResultsPageElements.getFlightCounter());

    }

    public void editMultiCitySearch() {

        webDriverCommons.click(flightResultsPageElements.getEditMultiCitySearchButton());
        webDriverCommons.sendKeys(flightResultsPageElements.getMultiCityFlightFromTextField(), "Sydney");
        webDriverCommons.waitForElementToBeVisible(flightResultsPageElements.getMultiCityFlightFromDropDown1());
        webDriverCommons.click(flightResultsPageElements.getMultiCityFlightFromDropDown1());
        webDriverCommons.click(flightResultsPageElements.getUpdateSearch());

    }

    /**
    *
    */
    public void waitForMultiCityFlightResults() {

        webDriverCommons.waitForElementToBeVisible(flightResultsPageElements.getMultiCityFlightCounter());

        webDriverCommons.waitForLoad();

        try {
            webDriverCommons.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
