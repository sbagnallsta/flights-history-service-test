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
public class PaymentFormPage extends Page<PaymentFormPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private PaymentFormPageElements paymentFormPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(paymentFormPageElements.getGenderMaleRadioButtion());
    }

    /**
     * 
     */
    @Override
    public void init() {
        paymentFormPageElements = new PaymentFormPageElements();
        super.initialiseElements(paymentFormPageElements);

    }

    /**
     * 
     */
    @Override
    public PaymentFormPageElements getPageElements() {

        return paymentFormPageElements;
    }

    /**
     * Select on Submit Button.
     */
    public void selectSubmitButton() {
        webDriverCommons.click(paymentFormPageElements.getSubmitButton());
    }

    /**
     * click on gender button.
     * 
     * @param gender
     *            gender
     */
    public void selectGender(final String gender) {
        if (gender.equalsIgnoreCase("male")) {
            webDriverCommons.click(paymentFormPageElements.getGenderMaleRadioButtion());
        } else if (gender.equalsIgnoreCase("female")) {
            webDriverCommons.click(paymentFormPageElements.getGenderFemaleRadioButtion());
        }
    }

    /**
     * click on terms and condition check box.
     */
    public void selectTermsAndCondition() {
        webDriverCommons.click(paymentFormPageElements.getTermAndCondition());
    }

    /**
     * click on flight terms and condition check box.
     */
    public void selectTermsAndConditionForFlight() {
        webDriverCommons.click(paymentFormPageElements.getFlightTermsAndCondition());

    }
}
