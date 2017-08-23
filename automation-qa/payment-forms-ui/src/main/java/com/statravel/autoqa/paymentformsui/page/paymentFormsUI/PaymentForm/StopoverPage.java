package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm;

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
public class StopoverPage extends Page<StopoverPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private PaymentFormPage paymentFormPage;

    private StopoverPageElements stopoverPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                           .getRefrenceNo());
    }

    /**
     * 
     */
    @Override
    public void init() {
        stopoverPageElements = new StopoverPageElements();
        super.initialiseElements(stopoverPageElements);

    }

    /**
     * 
     */
    @Override
    public StopoverPageElements getPageElements() {

        return stopoverPageElements;
    }

    /**
     * click on first and second sropover price check box.
     */
    public void selectBothStopover() {
        webDriverCommons.click(stopoverPageElements.getFirstCheckBox());
        webDriverCommons.click(stopoverPageElements.getSecondCheckBox());

    }

}
