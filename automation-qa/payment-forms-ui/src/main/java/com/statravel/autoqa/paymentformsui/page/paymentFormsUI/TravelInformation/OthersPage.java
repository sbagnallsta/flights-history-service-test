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
public class OthersPage extends Page<OthersPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private TravelInformationPage travelInformationPage;

    private OthersPageElements othersPageElements;

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
        othersPageElements = new OthersPageElements();
        super.initialiseElements(othersPageElements);

    }

    /**
     * 
     */
    @Override
    public OthersPageElements getPageElements() {

        return othersPageElements;
    }

}
