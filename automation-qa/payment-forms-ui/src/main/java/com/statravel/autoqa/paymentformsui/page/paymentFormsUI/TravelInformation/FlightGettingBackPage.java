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
public class FlightGettingBackPage extends Page<FlightGettingBackPageElements> {

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FlightGettingBackPageElements flightGettingBackPageElements;

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

        flightGettingBackPageElements = new FlightGettingBackPageElements();
        super.initialiseElements(flightGettingBackPageElements);

    }

    /**
     * 
     */
    @Override
    public FlightGettingBackPageElements getPageElements() {

        return flightGettingBackPageElements;
    }

}
