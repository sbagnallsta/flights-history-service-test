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
public class FlightGettingAroundForConfirmationPage extends Page<FlightGettingAroundForConfirmationPageElements> {

    @Autowired
    private ConfirmationPage confirmationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FlightGettingAroundForConfirmationPageElements flightGettingAroundPageElements;

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

        flightGettingAroundPageElements = new FlightGettingAroundForConfirmationPageElements();
        super.initialiseElements(flightGettingAroundPageElements);

    }

    /**
     * 
     */
    @Override
    public FlightGettingAroundForConfirmationPageElements getPageElements() {

        return flightGettingAroundPageElements;
    }

}
