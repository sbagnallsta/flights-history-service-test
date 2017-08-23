package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class OthersPageElements extends PageElements {

    @FindBy(css = "#others-heading")
    private WebElement othersHeading;

    @FindBy(css = "#others-title-1")
    private WebElement firstOthersTitle;

    @FindBy(css = "#others-title-2")
    private WebElement secondOthersTitle;

    @FindBy(css = "#others-description-1")
    private WebElement firstOthersTripDetails;

    @FindBy(css = "#others-description-2")
    private WebElement secondOthersTripDetails;

    @FindBy(css = "#others-heading-side-bar")
    private WebElement otherHeadingForSideBar;

    @FindBy(css = "#others-amount-side-bar")
    private WebElement othersAmountForSideBar;

    /**
     * @return the othersHeading
     */
    public WebElement getOthersHeading() {
        return othersHeading;
    }

    /**
     * @return the firstOthersTitle
     */
    public WebElement getFirstOthersTitle() {
        return firstOthersTitle;
    }

    /**
     * @return the secondOthersTitle
     */
    public WebElement getSecondOthersTitle() {
        return secondOthersTitle;
    }

    /**
     * @return the firstOthersTripDetails
     */
    public WebElement getFirstOthersTripDetails() {
        return firstOthersTripDetails;
    }

    /**
     * @return the secondOthersTripDetails
     */
    public WebElement getSecondOthersTripDetails() {
        return secondOthersTripDetails;
    }

    /**
     * @return the otherHeadingForSideBar
     */
    public WebElement getOtherHeadingForSideBar() {
        return otherHeadingForSideBar;
    }

    /**
     * @return the othersAmountForSideBar
     */
    public WebElement getOthersAmountForSideBar() {
        return othersAmountForSideBar;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OthersPageElements [othersHeading=" + othersHeading + ", firstOthersTitle=" + firstOthersTitle + ", secondOthersTitle="
                + secondOthersTitle + ", firstOthersTripDetails=" + firstOthersTripDetails + ", secondOthersTripDetails=" + secondOthersTripDetails
                + ", otherHeadingForSideBar=" + otherHeadingForSideBar + ", othersAmountForSideBar=" + othersAmountForSideBar + "]";
    }

}
