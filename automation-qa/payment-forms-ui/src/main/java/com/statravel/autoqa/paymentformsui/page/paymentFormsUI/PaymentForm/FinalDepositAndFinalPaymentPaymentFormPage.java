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
public class FinalDepositAndFinalPaymentPaymentFormPage extends Page<FinalDepositAndFinalPaymentPaymentFormPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private PaymentFormPage paymentFormPage;

    private FinalDepositAndFinalPaymentPaymentFormPageElements finalDepositAndFinalPaymentPaymentFormPageElements;

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
        finalDepositAndFinalPaymentPaymentFormPageElements = new FinalDepositAndFinalPaymentPaymentFormPageElements();
        super.initialiseElements(finalDepositAndFinalPaymentPaymentFormPageElements);

    }

    /**
     * 
     */
    @Override
    public FinalDepositAndFinalPaymentPaymentFormPageElements getPageElements() {

        return finalDepositAndFinalPaymentPaymentFormPageElements;
    }

}
