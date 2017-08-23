package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class ExtraPageElements extends PageElements {

    @FindBy(css = "#extras-heading")
    private WebElement heading;

    @FindBy(css = "#extras-title-1")
    private WebElement firstName;

    @FindBy(css = "#extras-title-2")
    private WebElement secondName;

    @FindBy(css = "#extra-description-1")
    private WebElement firstDescriptions;

    @FindBy(css = "#extra-description-2")
    private WebElement secondDescriptions;

    @FindBy(css = "#extras-amount-1")
    private WebElement firstAmount;

    @FindBy(css = "#extras-amount-2")
    private WebElement secondAmount;

    @FindBy(css = "#extras-checkbox-selected-1-false")
    private WebElement firstCheckBox;

    @FindBy(css = "#extras-checkbox-selected-2-false")
    private WebElement secondCheckBox;

    @FindBy(css = "#extras-checkbox-selected-1-true")
    private WebElement firstHighlightedProduct;

    @FindBy(css = "#extras-checkbox-selected-2-true")
    private WebElement secondHighlightedProduct;

    @FindBy(css = "#extras-heading-side-bar")
    private WebElement sideBarHeading;

    @FindBy(css = "#extras-amount-side-bar")
    private WebElement totalExtraAmountForSideBar;

    @FindBy(css = "#extras-title-side-bar-1")
    private WebElement firstNameForSideBar;

    @FindBy(css = "#extras-title-side-bar-2")
    private WebElement secondNameForSideBar;

    @FindBy(css = "#extras-amount-side-bar-1")
    private WebElement firstAmountForSideBar;

    @FindBy(css = "#extras-amount-side-bar-2")
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
     * @return the firstDescriptions
     */
    public WebElement getFirstDescriptions() {
        return firstDescriptions;
    }

    /**
     * @return the secondDescriptions
     */
    public WebElement getSecondDescriptions() {
        return secondDescriptions;
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
    public WebElement getTotalExtraAmountForSideBar() {
        return totalExtraAmountForSideBar;
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
        return "ExtraPageElements [heading=" + heading + ", firstName=" + firstName + ", secondName=" + secondName + ", firstDescriptions="
                + firstDescriptions + ", secondDescriptions=" + secondDescriptions + ", firstAmount=" + firstAmount + ", secondAmount=" + secondAmount
                + ", firstCheckBox=" + firstCheckBox + ", secondCheckBox=" + secondCheckBox + ", firstHighlightedProduct=" + firstHighlightedProduct
                + ", secondHighlightedProduct=" + secondHighlightedProduct + ", sideBarHeading=" + sideBarHeading + ", totalExtraAmountForSideBar="
                + totalExtraAmountForSideBar + ", firstNameForSideBar=" + firstNameForSideBar + ", secondNameForSideBar=" + secondNameForSideBar
                + ", firstAmountForSideBar=" + firstAmountForSideBar + ", secondAmountForSideBar=" + secondAmountForSideBar + "]";
    }

}
