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
public class ConfirmationPage extends Page<ConfirmationPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private ConfirmationPageElements confirmationPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(confirmationPageElements.getRefrenceNo());
    }

    /**
     * 
     */
    @Override
    public void init() {
        confirmationPageElements = new ConfirmationPageElements();
        super.initialiseElements(confirmationPageElements);

    }

    /**
     * 
     */
    @Override
    public ConfirmationPageElements getPageElements() {

        return confirmationPageElements;
    }

}
