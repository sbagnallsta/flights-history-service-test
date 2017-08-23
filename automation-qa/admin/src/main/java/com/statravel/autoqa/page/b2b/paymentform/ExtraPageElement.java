package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class ExtraPageElement extends PageElements {

    @FindBy(css = "#payment-form-extra-product-price-0")
    private WebElement firstPriceInput;

    @FindBy(css = "#payment-form-extra-product-price-1")
    private WebElement secondPriceInput;

    @FindBy(css = "#payment-form-extra-product-name-0")
    private WebElement firstProductNameInput;

    @FindBy(css = "#payment-form-extra-product-name-1")
    private WebElement secondProductNameInput;

    @FindBy(css = "#payment-form-extra-product-information-0")
    private WebElement firstProductInformatinInput;

    @FindBy(css = "#payment-form-extra-product-information-1")
    private WebElement secondProductInformatinInput;

    @FindBy(css = "#payment-form-extra-product-delete-0")
    private WebElement firstExtrasDeleteButton;

    @FindBy(css = "#payment-form-extra-product-delete-1")
    private WebElement secondExtrasDeleteButton;

    @FindBy(css = "#payment-form-extra-product-name-required-0")
    private WebElement productNameIsRequireMessage;

    @FindBy(css = "#payment-form-extra-product-information-required-0")
    private WebElement productInformationIsRequireMessage;

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
     * @return the firstProductNameInput
     */
    public WebElement getFirstProductNameInput() {
        return firstProductNameInput;
    }

    /**
     * @return the secondProductNameInput
     */
    public WebElement getSecondProductNameInput() {
        return secondProductNameInput;
    }

    /**
     * @return the firstProductInformatinInput
     */
    public WebElement getFirstProductInformatinInput() {
        return firstProductInformatinInput;
    }

    /**
     * @return the secondProductInformatinInput
     */
    public WebElement getSecondProductInformatinInput() {
        return secondProductInformatinInput;
    }

    /**
     * @return the firstExtrasDeleteButton
     */
    public WebElement getFirstExtrasDeleteButton() {
        return firstExtrasDeleteButton;
    }

    /**
     * @return the secondExtrasDeleteButton
     */
    public WebElement getSecondExtrasDeleteButton() {
        return secondExtrasDeleteButton;
    }

    /**
     * @return the productNameIsRequireMessage
     */
    public WebElement getProductNameIsRequireMessage() {
        return productNameIsRequireMessage;
    }

    /**
     * @return the productInformationIsRequireMessage
     */
    public WebElement getProductInformationIsRequireMessage() {
        return productInformationIsRequireMessage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ExtraPageElement [firstPriceInput=" + firstPriceInput + ", secondPriceInput=" + secondPriceInput + ", firstProductNameInput="
                + firstProductNameInput + ", secondProductNameInput=" + secondProductNameInput + ", firstProductInformatinInput="
                + firstProductInformatinInput + ", secondProductInformatinInput=" + secondProductInformatinInput + ", firstExtrasDeleteButton="
                + firstExtrasDeleteButton + ", secondExtrasDeleteButton=" + secondExtrasDeleteButton + ", productNameIsRequireMessage="
                + productNameIsRequireMessage + ", productInformationIsRequireMessage=" + productInformationIsRequireMessage + "]";
    }

}
