package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class StopoverPageElements extends PageElements {

    @FindBy(id = "stopovers=-heading")
    private WebElement heading;

    @FindBy(css = "#stopovers-title-1")
    private WebElement firstName;

    @FindBy(css = "#stopovers-title-2")
    private WebElement secondName;

    @FindBy(css = "#stopover-amount-1")
    private WebElement firstAmount;

    @FindBy(css = "#stopover-amount-2")
    private WebElement secondAmount;

    @FindBy(css = "#stopovers-checkbox-selected-1-false")
    private WebElement firstCheckBox;

    @FindBy(css = "#stopovers-checkbox-selected-2-false")
    private WebElement secondCheckBox;

    @FindBy(css = "#stopovers-checkbox-selected-1-true")
    private WebElement firstHighlightedProduct;

    @FindBy(css = "#stopovers-checkbox-selected-2-true")
    private WebElement secondHighlightedProduct;

    @FindBy(css = "#stopover-heading-side-bar")
    private WebElement sideBarHeading;

    @FindBy(css = "#stopover-total-amount-side-bar")
    private WebElement totalStopoverAmountForSideBar;

    @FindBy(css = "#stopover-title-1")
    private WebElement firstNameForSideBar;

    @FindBy(css = "#stopover-title-2")
    private WebElement secondNameForSideBar;

    @FindBy(css = "#stopover-price-1")
    private WebElement firstAmountForSideBar;

    @FindBy(css = "#stopover-price-2")
    private WebElement secondAmountForSideBar;

    /**
     * @return the heading
     */
    public WebElement getHeading() {
        return heading;
    }

    /**
     * @return the firstName
     */
    public WebElement getFirstName() {
        return firstName;
    }

    /**
     * @return the secondName
     */
    public WebElement getSecondName() {
        return secondName;
    }

    /**
     * @return the firstAmount
     */
    public WebElement getFirstAmount() {
        return firstAmount;
    }

    /**
     * @return the secondAmount
     */
    public WebElement getSecondAmount() {
        return secondAmount;
    }

    /**
     * @return the firstCheckBox
     */
    public WebElement getFirstCheckBox() {
        return firstCheckBox;
    }

    /**
     * @return the secondCheckBox
     */
    public WebElement getSecondCheckBox() {
        return secondCheckBox;
    }

    /**
     * @return the sideBarHeading
     */
    public WebElement getSideBarHeading() {
        return sideBarHeading;
    }

    /**
     * @return the totalExtraAmountForSideBar
     */
    public WebElement getTotalStopoverAmountForSideBar() {
        return totalStopoverAmountForSideBar;
    }

    /**
     * @return the firstNameForSideBar
     */
    public WebElement getFirstNameForSideBar() {
        return firstNameForSideBar;
    }

    /**
     * @return the secondNameForSideBar
     */
    public WebElement getSecondNameForSideBar() {
        return secondNameForSideBar;
    }

    /**
     * @return the firstAmountForSideBar
     */
    public WebElement getFirstAmountForSideBar() {
        return firstAmountForSideBar;
    }

    /**
     * @return the secondAmountForSideBar
     */
    public WebElement getSecondAmountForSideBar() {
        return secondAmountForSideBar;
    }

    /**
     * @return the firstHighlightedProduct
     */
    public WebElement getFirstHighlightedProduct() {
        return firstHighlightedProduct;
    }

    /**
     * @return the secondHighlightedProduct
     */
    public WebElement getSecondHighlightedProduct() {
        return secondHighlightedProduct;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StopoverPageElements [heading=" + heading + ", firstName=" + firstName + ", secondName=" + secondName + ", firstAmount=" + firstAmount
                + ", secondAmount=" + secondAmount + ", firstCheckBox=" + firstCheckBox + ", secondCheckBox=" + secondCheckBox
                + ", firstHighlightedProduct=" + firstHighlightedProduct + ", secondHighlightedProduct=" + secondHighlightedProduct
                + ", sideBarHeading=" + sideBarHeading + ", totalStopoverAmountForSideBar=" + totalStopoverAmountForSideBar + ", firstNameForSideBar="
                + firstNameForSideBar + ", secondNameForSideBar=" + secondNameForSideBar + ", firstAmountForSideBar=" + firstAmountForSideBar
                + ", secondAmountForSideBar=" + secondAmountForSideBar + "]";
    }

}
