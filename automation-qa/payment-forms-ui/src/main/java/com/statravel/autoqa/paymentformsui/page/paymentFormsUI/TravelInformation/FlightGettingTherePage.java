package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

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
public class FlightGettingTherePage extends Page<FlightGettingTherePageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private TravelInformationPage travelInformationPage;

    private FlightGettingTherePageElements flightGettingTherePageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                 .getRefrenceNo());
    }

    /**
     * 
     */
    @Override
    public void init() {

        flightGettingTherePageElements = new FlightGettingTherePageElements();
        super.initialiseElements(flightGettingTherePageElements);

    }

    /**
     * 
     */
    @Override
    public FlightGettingTherePageElements getPageElements() {

        return flightGettingTherePageElements;
    }

}
