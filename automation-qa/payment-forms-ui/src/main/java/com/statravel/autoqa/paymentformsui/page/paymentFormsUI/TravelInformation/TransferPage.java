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
public class TransferPage extends Page<TransferPageElements> {

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private TransferPageElements transferPageElements;

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

        transferPageElements = new TransferPageElements();
        super.initialiseElements(transferPageElements);

    }

    /**
     * 
     */
    @Override
    public TransferPageElements getPageElements() {

        return transferPageElements;
    }

}
