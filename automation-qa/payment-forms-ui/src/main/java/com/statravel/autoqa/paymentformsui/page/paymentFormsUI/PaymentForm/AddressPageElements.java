package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class AddressPageElements extends PageElements {

    @FindBy(css = "#address-line-1")
    private WebElement addressLineOne;

    @FindBy(css = "#address-line-2")
    private WebElement addressLineTwo;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#state")
    private WebElement state;

    @FindBy(css = "#zip-code")
    private WebElement zipCode;

    @FindBy(css = "#country")
    private WebElement country;

    @FindBy(css = "#address-line-1-required")
    private WebElement requireErrorMsgForAddressOne;

    @FindBy(css = "#city-required")
    private WebElement requireErrorMsgForCity;

    @FindBy(css = "#state-required")
    private WebElement requireErrorMsgForState;

    @FindBy(css = "#zip-required")
    private WebElement requireErrorMsgForZip;

    @FindBy(css = "#country-required")
    private WebElement requireErrorMsgForCountry;

    /**
     * @return the addressLineOne
     */
    public WebElement getAddressLineOne() {
        return addressLineOne;
    }

    /**
     * @return the addressLineTwo
     */
    public WebElement getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     * @return the city
     */
    public WebElement getCity() {
        return city;
    }

    /**
     * @return the state
     */
    public WebElement getState() {
        return state;
    }

    /**
     * @return the zipCode
     */
    public WebElement getZipCode() {
        return zipCode;
    }

    /**
     * @return the country
     */
    public WebElement getCountry() {
        return country;
    }

    /**
     * @return the requireErrorMsgForAddressOne
     */
    public WebElement getRequireErrorMsgForAddressOne() {
        return requireErrorMsgForAddressOne;
    }

    /**
     * @return the requireErrorMsgForCity
     */
    public WebElement getRequireErrorMsgForCity() {
        return requireErrorMsgForCity;
    }

    /**
     * @return the requireErrorMsgForState
     */
    public WebElement getRequireErrorMsgForState() {
        return requireErrorMsgForState;
    }

    /**
     * @return the requireErrorMsgForZip
     */
    public WebElement getRequireErrorMsgForZip() {
        return requireErrorMsgForZip;
    }

    /**
     * @return the requireErrorMsgForCountry
     */
    public WebElement getRequireErrorMsgForCountry() {
        return requireErrorMsgForCountry;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AddressPageElements [addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city + ", state=" + state
                + ", zipCode=" + zipCode + ", country=" + country + ", requireErrorMsgForAddressOne=" + requireErrorMsgForAddressOne
                + ", requireErrorMsgForCity=" + requireErrorMsgForCity + ", requireErrorMsgForState=" + requireErrorMsgForState
                + ", requireErrorMsgForZip=" + requireErrorMsgForZip + ", requireErrorMsgForCountry=" + requireErrorMsgForCountry + "]";
    }

}
