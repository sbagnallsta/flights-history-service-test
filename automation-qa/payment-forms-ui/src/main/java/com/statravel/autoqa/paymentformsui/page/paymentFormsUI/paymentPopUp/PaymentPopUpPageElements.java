package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.paymentPopUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class PaymentPopUpPageElements extends PageElements {

    @FindBy(css = "#cardNumber")
    private WebElement cardNumberInput;

    @FindBy(css = "#cardholderName")
    private WebElement cardHolderNameInput;

    @FindBy(css = "#expiryMonth")
    private WebElement expiryMonthInput;

    @FindBy(css = "#expiryYear")
    private WebElement expiryYearInput;

    @FindBy(css = "#securityCode")
    private WebElement securityCodeInput;

    @FindBy(css = "#cancelButton")
    private WebElement cancelButton;

    @FindBy(css = "#submitButton")
    private WebElement subminButton;

    /**
     * @return the cardNumberInput
     */
    public WebElement getCardNumberInput() {
        return cardNumberInput;
    }

    /**
     * @return the cardHolderNameInput
     */
    public WebElement getCardHolderNameInput() {
        return cardHolderNameInput;
    }

    /**
     * @return the expityMonthInput
     */
    public WebElement getExpiryMonthInput() {
        return expiryMonthInput;
    }

    /**
     * @return the expityYearInput
     */
    public WebElement getExpiryYearInput() {
        return expiryYearInput;
    }

    /**
     * @return the securityCodeInput
     */
    public WebElement getSecurityCodeInput() {
        return securityCodeInput;
    }

    /**
     * @return the cancelButton
     */
    public WebElement getCancelButton() {
        return cancelButton;
    }

    /**
     * @return the subminButton
     */
    public WebElement getSubminButton() {
        return subminButton;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentPopUpPageElements [cardNumberInput=" + cardNumberInput + ", cardHolderNameInput=" + cardHolderNameInput + ", expityMonthInput="
                + expiryMonthInput + ", expityYearInput=" + expiryYearInput + ", securityCodeInput=" + securityCodeInput + ", cancelButton="
                + cancelButton + ", subminButton=" + subminButton + "]";
    }

}
