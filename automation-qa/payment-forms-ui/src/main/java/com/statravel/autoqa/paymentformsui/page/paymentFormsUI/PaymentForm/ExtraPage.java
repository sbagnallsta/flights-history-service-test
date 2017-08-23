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
public class ExtraPage extends Page<ExtraPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private PaymentFormPage paymentFormPage;

    private ExtraPageElements extraPageElements;

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
        extraPageElements = new ExtraPageElements();
        super.initialiseElements(extraPageElements);
    }

    /**
     * 
     */
    @Override
    public ExtraPageElements getPageElements() {
        return extraPageElements;
    }

    /**
     * click on first and second extra check box.
     */
    public void selectBothExtra() {
        webDriverCommons.click(extraPageElements.getFirstCheckBox());
        webDriverCommons.click(extraPageElements.getSecondCheckBox());

    }

}
