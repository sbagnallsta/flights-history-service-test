package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class StopOverPageElements extends PageElements {

    @FindBy(css = "#payment-form-stopovers-price-0")
    private WebElement firstPriceInput;

    @FindBy(css = "#payment-form-stopovers-price-1")
    private WebElement secondPriceInput;

    @FindBy(css = "#payment-form-stopovers-product-0")
    private WebElement firstProductInput;

    @FindBy(css = "#payment-form-stopovers-product-1")
    private WebElement secondProductInput;

    @FindBy(css = "#payment-form-stopovers-product-delete-0")
    private WebElement firstDeleteButton;

    @FindBy(css = "#payment-form-stopovers-product-delete-1")
    private WebElement secondDeleteButton;

    @FindBy(css = "#payment-form-stopovers-price-required-0")
    private WebElement priceIsARequireMessage;

    @FindBy(css = "#payment-form-stopovers-product-required-0")
    private WebElement productIsARequireMessage;

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
     * @return the firstProductInput
     */
    public WebElement getFirstProductInput() {
        return firstProductInput;
    }

    /**
     * @return the secondProductInput
     */
    public WebElement getSecondProductInput() {
        return secondProductInput;
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
     * @return the priceIsARequireMessage
     */
    public WebElement getPriceIsARequireMessage() {
        return priceIsARequireMessage;
    }

    /**
     * @return the productIsARequireMessage
     */
    public WebElement getProductIsARequireMessage() {
        return productIsARequireMessage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StopOverPageElements [firstPriceInput=" + firstPriceInput + ", secondPriceInput=" + secondPriceInput + ", firstProductInput="
                + firstProductInput + ", secondProductInput=" + secondProductInput + ", firstDeleteButton=" + firstDeleteButton
                + ", secondDeleteButton=" + secondDeleteButton + ", priceIsARequireMessage=" + priceIsARequireMessage + ", productIsARequireMessage="
                + productIsARequireMessage + "]";
    }

}
