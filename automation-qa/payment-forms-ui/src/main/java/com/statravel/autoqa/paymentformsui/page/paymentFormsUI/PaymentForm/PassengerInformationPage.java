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
public class PassengerInformationPage extends Page<PassengerInformationPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private PaymentFormPage paymentFormPage;

    private PassengerInformationPageElements passengerInformationPageElements;

    public static final String TITLE = "Dr";
    public static final String FIRST_NAME = "First name";
    private static final String MIDDLE_NAME = "Middle name";
    public static final String LAST_NAME = "Last name";
    public static final String EMAIL = "s@gmail.com";
    public static final String EMAIL_CONFIRM = "s@gmail.com";
    public static final String PHONE_NO = "0123456789";
    private static final String PASSPORT_NO = "0123456789";

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
        passengerInformationPageElements = new PassengerInformationPageElements();
        super.initialiseElements(passengerInformationPageElements);

    }

    /**
     * 
     */
    @Override
    public PassengerInformationPageElements getPageElements() {

        return passengerInformationPageElements;
    }

    /**
     * fill passenger information as per given condition.
     * 
     * @param info
     *            info
     */
    public void fillPassengerInformation(final String info) {

        if (info.equalsIgnoreCase("required for form") || info.equalsIgnoreCase("allWithMiddleNameAndPassportNo")
                || info.equalsIgnoreCase("allWithOutMiddleNameAndPassportNo")) {

            webDriverCommons.sendKeys(passengerInformationPageElements.getTitleInput(), TITLE);
            webDriverCommons.sendKeys(passengerInformationPageElements.getFirstNameInput(), FIRST_NAME);
            webDriverCommons.sendKeys(passengerInformationPageElements.getLastNameInput(), LAST_NAME);
            webDriverCommons.sendKeys(passengerInformationPageElements.getEmailAddressInput(), EMAIL);
            webDriverCommons.sendKeys(passengerInformationPageElements.getEmailAddressConfirmInput(), EMAIL_CONFIRM);

            if (info.equalsIgnoreCase("all") || info.equalsIgnoreCase("allWithOutMiddleNameAndPassportNo")) {
                webDriverCommons.click(passengerInformationPageElements.getDateOfBirthInput());
                webDriverCommons.click(passengerInformationPageElements.getYearSelect());
                webDriverCommons.click(passengerInformationPageElements.getMonthSelect());
                webDriverCommons.click(passengerInformationPageElements.getDaySelect());
                webDriverCommons.sendKeys(passengerInformationPageElements.getPhoneNoInput(), PHONE_NO);
            }
            if (info.equalsIgnoreCase("all") || info.equalsIgnoreCase("allWithMiddleNameAndPassportNo")) {
                webDriverCommons.sendKeys(passengerInformationPageElements.getMiddleNameInput(), MIDDLE_NAME);
                webDriverCommons.sendKeys(passengerInformationPageElements.getPassportNumberInput(), PASSPORT_NO);
            }
        }

    }

    /**
     * enter given email address in email input.
     * @param email
     * email
     */
    public void enterEmailAddress(final String email) {
        webDriverCommons.sendKeys(passengerInformationPageElements.getEmailAddressInput(), email);

    }

}
