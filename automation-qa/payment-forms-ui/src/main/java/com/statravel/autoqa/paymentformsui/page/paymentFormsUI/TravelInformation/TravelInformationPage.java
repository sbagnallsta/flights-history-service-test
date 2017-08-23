package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.paymentformsui.page.Page;
import com.statravel.autoqa.paymentformsui.commons.AutomationConstant;
import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class TravelInformationPage extends Page<TravelInformationPageElement> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private TravelInformationPageElement travelInformationPageElement;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {
        return webDriverCommons.isDisplayed(travelInformationPageElement.getRefrenceNo());
    }

    /**
     * 
     */
    @Override
    public void init() {

        travelInformationPageElement = new TravelInformationPageElement();
        super.initialiseElements(travelInformationPageElement);

    }

    /**
     * 
     */
    @Override
    public TravelInformationPageElement getPageElements() {

        return travelInformationPageElement;
    }

    /**
     * click on booking button.
     */
    public void selectBookingButton() {
        webDriverCommons.click(travelInformationPageElement.getProceedToBookingButton());

    }

    /**
     * select payment type.
     * 
     * @param type
     *            type
     */
    public void selectPaymentOption(final String type) {
        if (type.equalsIgnoreCase(AutomationConstant.DEPOSIT_OPTION)) {
            webDriverCommons.click(travelInformationPageElement.getDepositButton());
        } else if (type.equalsIgnoreCase(AutomationConstant.FULL_PAYMENT_OPTION)) {
            webDriverCommons.click(travelInformationPageElement.getFullPaymentButton());
        } else if (type.equalsIgnoreCase(AutomationConstant.BALANCE_OPTION)) {
            webDriverCommons.click(travelInformationPageElement.getBalanceButton());
        }
    }

    /**
     * select payment type as per given type.
     * 
     * @param paymentType
     *            paymentType
     */
    public void sclectPaymentType(final String paymentType) {

        if (paymentType.equalsIgnoreCase(AutomationConstant.BALANCE_AS_PAYMENT_TYPE)) {
            webDriverCommons.click(travelInformationPageElement.getBalanceButton());
        } else if (paymentType.equalsIgnoreCase(AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE)) {
            webDriverCommons.click(travelInformationPageElement.getDepositButton());
        } else if (paymentType.equalsIgnoreCase(AutomationConstant.FULL_AMOUNT_AS_PAYMENT_TYPE)) {
            webDriverCommons.click(travelInformationPageElement.getFullPaymentButton());
        }
    }
}
