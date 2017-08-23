package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;
import com.statravel.autoqa.paymentformsui.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class FlightGettingBackForConfirmationPage extends Page<FlightGettingBackForConfirmationPageElements> {

    @Autowired
    private ConfirmationPage confirmationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FlightGettingBackForConfirmationPageElements flightGettingBackPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                                 .getRefrenceNo());
    }

    /**
     * 
     */
    @Override
    public void init() {

        flightGettingBackPageElements = new FlightGettingBackForConfirmationPageElements();
        super.initialiseElements(flightGettingBackPageElements);

    }

    /**
     * 
     */
    @Override
    public FlightGettingBackForConfirmationPageElements getPageElements() {

        return flightGettingBackPageElements;
    }

}
