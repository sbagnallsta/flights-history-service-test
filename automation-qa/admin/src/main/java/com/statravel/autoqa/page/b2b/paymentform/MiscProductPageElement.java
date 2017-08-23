package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class MiscProductPageElement extends PageElements {

    @FindBy(css = "#payment-form-misc-price-0")
    private WebElement firstPriceInput;

    @FindBy(css = "#payment-form-misc-price-1")
    private WebElement secondPriceInput;

    @FindBy(css = "#payment-form-misc-name-0")
    private WebElement firstNameInput;

    @FindBy(css = "#payment-form-misc-name-1")
    private WebElement secondNameInput;

    @FindBy(css = "#payment-form-misc-information-0")
    private WebElement firstInformationInput;

    @FindBy(css = "#payment-form-misc-information-1")
    private WebElement secondInformationInput;

    @FindBy(css = "#payment-form-misc-delete-0")
    private WebElement firstDeleteButton;

    @FindBy(css = "#payment-form-misc-delete-1")
    private WebElement secondDeleteButton;

    @FindBy(css = "#payment-form-misc-name-required-0")
    private WebElement productNameIsRequireMessage;

    @FindBy(css = "#payment-form-misc-information-required-0")
    private WebElement productInforamtionIsRequireMessage;

    /**
     * @return the firstPriceInput
     */
    public WebElement getFirstPriceInput() {
        return firstPriceInput;
    }

    /**
     * @return the secondPriceInput
     */
    public WebElement getSecondPriceInput() {
        return secondPriceInput;
    }

    /**
     * @return the firstNameInput
     */
    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    /**
     * @return the secondNameInput
     */
    public WebElement getSecondNameInput() {
        return secondNameInput;
    }

    /**
     * @return the firstInformationInput
     */
    public WebElement getFirstInformationInput() {
        return firstInformationInput;
    }

    /**
     * @return the secondInformationInput
     */
    public WebElement getSecondInformationInput() {
        return secondInformationInput;
    }

    /**
     * @return the firstDeleteButton
     */
    public WebElement getFirstDeleteButton() {
        return firstDeleteButton;
    }

    /**
     * @return the secondDeleteButton
     */
    public WebElement getSecondDeleteButton() {
        return secondDeleteButton;
    }

    /**
     * @return the productNameIsRequireMessage
     */
    public WebElement getProductNameIsRequireMessage() {
        return productNameIsRequireMessage;
    }

    /**
     * @return the productInforamtionIsRequireMessage
     */
    public WebElement getProductInforamtionIsRequireMessage() {
        return productInforamtionIsRequireMessage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MiscProductPageElement [firstPriceInput=" + firstPriceInput + ", secondPriceInput=" + secondPriceInput + ", firstNameInput="
                + firstNameInput + ", secondNameInput=" + secondNameInput + ", firstInformationInput=" + firstInformationInput
                + ", secondInformationInput=" + secondInformationInput + ", firstDeleteButton=" + firstDeleteButton + ", secondDeleteButton="
                + secondDeleteButton + ", productNameIsRequireMessage=" + productNameIsRequireMessage + ", productInforamtionIsRequireMessage="
                + productInforamtionIsRequireMessage + "]";
    }

}
