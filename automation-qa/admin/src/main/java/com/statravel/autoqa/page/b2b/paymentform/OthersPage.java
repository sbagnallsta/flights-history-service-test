package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Others;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class OthersPage extends Page<OthersPageElement> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private OthersPageElement othersPageElement;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(othersPageElement.getFirstDeleteButton());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        othersPageElement = new OthersPageElement();

        super.initialiseElements(othersPageElement);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public OthersPageElement getPageElements() {

        return othersPageElement;
    }

    /**
     * 
     * @param others
     *            Others reference
     */
    public void fillDetailsForFirstOthers(final Others others) {

        webDriverCommons.sendKeys(othersPageElement.getFirstTitleInput(), others.getTitle());

        webDriverCommons.sendKeys(othersPageElement.getFirstTripDetaisInput(), others.getTripDetails());

    }

    /**
     * 
     * @param others
     *            Others reference
     */
    public void fillDetailsForSecondOthers(final Others others) {

        webDriverCommons.sendKeys(othersPageElement.getSecondTitleInput(), others.getTitle());

        webDriverCommons.sendKeys(othersPageElement.getSecondTripDetaisInput(), others.getTripDetails());

    }

    /**
     * Delete First Others.
     */
    public void deleteFirstOthers() {

        webDriverCommons.click(othersPageElement.getFirstDeleteButton());

        Alert deleteAlert = webDriverCommons.getAlertPopUp();

        deleteAlert.accept();

    }

}
