package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.paymentPopUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.paymentformsui.commons.AutomationConstant;
import com.statravel.autoqa.paymentformsui.commons.Utilities;
import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;
import com.statravel.autoqa.paymentformsui.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class PaymentPopUpPage extends Page<PaymentPopUpPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private Utilities utilities;

    private PaymentPopUpPageElements paymentPopUpPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(paymentPopUpPageElements.getCardHolderNameInput());
    }

    /**
     * 
     */
    @Override
    public void init() {
        paymentPopUpPageElements = new PaymentPopUpPageElements();
        super.initialiseElements(paymentPopUpPageElements);

    }

    /**
     * 
     */
    @Override
    public PaymentPopUpPageElements getPageElements() {

        return paymentPopUpPageElements;
    }

    /**
     * Fill details in payment pop up.
     * 
     * @throws InterruptedException
     *             InterruptedException
     */
    public void fillPaymentDetails() throws InterruptedException {

        webDriverCommons.sendKeys(paymentPopUpPageElements.getCardNumberInput(), AutomationConstant.CARD_NO);

        webDriverCommons.sendKeys(paymentPopUpPageElements.getCardHolderNameInput(), AutomationConstant.CARD_HOLDER_NAME);

        webDriverCommons.selectFromDropdown(paymentPopUpPageElements.getExpiryMonthInput(), AutomationConstant.CARD_EXPIRY_MONTH);

        webDriverCommons.selectFromDropdown(paymentPopUpPageElements.getExpiryYearInput(), AutomationConstant.CARD_EXPIRY_YEAR);

        webDriverCommons.sendKeys(paymentPopUpPageElements.getSecurityCodeInput(), AutomationConstant.CARD_SECURITY_CODE);

        utilities.timeInterval(1);

        webDriverCommons.click(paymentPopUpPageElements.getSubminButton());

    }

}
