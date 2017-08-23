package com.statravel.autoqa.page;

import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.AutomationConstants;
import com.statravel.autoqa.commons.Utilities;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.enumeration.POS;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class HomePage extends Page<HomePageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private Utilities utilities;

    private HomePageElements homePageElements;

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
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(homePageElements.getLogoutLink());
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

    /**
     * Clicks on Payment Forms menu item.
     */
    public void clickPaymentFormsMenuItem() {
        webDriverCommons.click(homePageElements.getPaymentFormMenuItem());
    }

    /**
     * Clicks on Saved Searches menu item.
     * 
     * @throws InterruptedException
     *             InterruptedException
     */
    public void clickSavedSearchesMenuItem() throws InterruptedException {
        utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);

        webDriverCommons.click(homePageElements.getSavedSearchesMenuItem());
    }

    /**
     * Selects POS.
     * 
     * @param pos
     *            point of sales
     * 
     * 
     */
    public void selectPOS(final POS pos) {
        webDriverCommons.click(homePageElements.getPosSelect());

        webDriverCommons.sendKeys(homePageElements.getCountryInput(), pos.name());

        webDriverCommons.sendKeys(homePageElements.getCountryInput(), Keys.ENTER);

    }

}
