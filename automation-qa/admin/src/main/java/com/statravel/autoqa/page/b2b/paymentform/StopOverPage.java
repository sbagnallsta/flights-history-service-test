package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.StopOver;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class StopOverPage extends Page<StopOverPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private StopOverPageElements stopOverPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(stopOverPageElements.getFirstPriceInput());

    }

    /**
     * 
     */
    @Override
    public void init() {

        stopOverPageElements = new StopOverPageElements();

        super.initialiseElements(stopOverPageElements);
    }

    /**
     * 
     */
    @Override
    public StopOverPageElements getPageElements() {

        return stopOverPageElements;
    }

    /**
     * 
     * @param stopOver
     *            stop over reference
     */
    public void fillDetailsForFirstStopOver(final StopOver stopOver) {

        webDriverCommons.sendKeys(stopOverPageElements.getFirstPriceInput(), stopOver.getPrice());

        webDriverCommons.sendKeys(stopOverPageElements.getFirstProductInput(), stopOver.getProduct());

    }

    /**
     * @param stopOver
     *            stop over reference
     */
    public void fillDetailsForSecondStopOver(final StopOver stopOver) {

        webDriverCommons.sendKeys(stopOverPageElements.getSecondPriceInput(), stopOver.getPrice());

        webDriverCommons.sendKeys(stopOverPageElements.getSecondProductInput(), stopOver.getProduct());
    }

    /**
     * Delete first StopOver.
     */
    public void deleteFirstStopOver() {

        webDriverCommons.click(stopOverPageElements.getFirstDeleteButton());

        Alert deleteAlert = new WebDriverCommons().getAlertPopUp();

        deleteAlert.accept();
    }

    /**
     * Delete second StopOver.
     */
    public void deleteSecondStopOver() {

        webDriverCommons.click(stopOverPageElements.getSecondDeleteButton());

        Alert deleteAlert = new WebDriverCommons().getAlertPopUp();

        deleteAlert.accept();
    }
}
