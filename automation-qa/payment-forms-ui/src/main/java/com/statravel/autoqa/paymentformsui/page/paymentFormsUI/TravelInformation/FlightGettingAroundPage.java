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
public class FlightGettingAroundPage extends Page<FlightGettingAroundPageElements> {

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FlightGettingAroundPageElements flightGettingAroundPageElements;

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

        flightGettingAroundPageElements = new FlightGettingAroundPageElements();
        super.initialiseElements(flightGettingAroundPageElements);

    }

    /**
     * 
     */
    @Override
    public FlightGettingAroundPageElements getPageElements() {

        return flightGettingAroundPageElements;
    }

}
