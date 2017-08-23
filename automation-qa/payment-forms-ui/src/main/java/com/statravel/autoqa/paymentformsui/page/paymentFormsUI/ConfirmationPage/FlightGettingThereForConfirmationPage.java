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
public class FlightGettingThereForConfirmationPage extends Page<FlightGettingThereForConfirmationPageElements> {

    @Autowired
    private ConfirmationPage confirmationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FlightGettingThereForConfirmationPageElements flightGettingTherePageElements;

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

        flightGettingTherePageElements = new FlightGettingThereForConfirmationPageElements();
        super.initialiseElements(flightGettingTherePageElements);

    }

    /**
     * 
     */
    @Override
    public FlightGettingThereForConfirmationPageElements getPageElements() {

        return flightGettingTherePageElements;
    }

}
