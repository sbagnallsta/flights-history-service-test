package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class MiscProductPageElement extends PageElements {
    @FindBy(css = "#misc-product-heading")
    private WebElement miscProductHeading;

    @FindBy(css = "#misc-tittle-1")
    private WebElement firstMiscProductTitle;

    @FindBy(css = "#misc-tittle-2")
    private WebElement secondMiscProductTitle;

    @FindBy(css = "#misc-price-1-true")
    private WebElement firstMiscProductPrice;

    @FindBy(css = "#misc-price-2-true")
    private WebElement secondMiscProductPrice;

    @FindBy(css = "#misc-description-1")
    private WebElement firstMiscProductDescription;

    @FindBy(css = "#misc-description-2")
    private WebElement secondMiscProductDescription;

    @FindBy(css = "#misc-checkbox-selected-1-false")
    private WebElement firstMiscProductCheckBox;

    @FindBy(css = "#misc-checkbox-selected-2-false")
    private WebElement secondMiscProductCheckBox;

    @FindBy(css = "#misc-checkbox-selected-1-true")
    private WebElement firstHighlightedMiscProduct;

    @FindBy(css = "#misc-checkbox-selected-2-true")
    private WebElement secondHighlightedMiscProduct;

    @FindBy(css = "#misc-product-heading-side-bar")
    private WebElement miscProductHeadingNameForSideBar;

    @FindBy(css = "#misc-total-amount-side-bar")
    private WebElement miscProductTotalAmountForSideBar;

    @FindBy(css = "#misc-title-side-bar-1")
    private WebElement firstMiscProductTitleForSideBar;

    @FindBy(css = "#misc-title-side-bar-2")
    private WebElement secondMiscProductTitleForSideBar;

    @FindBy(css = "#misc-price-side-bar-1-show")
    private WebElement firstMiscProductAmountForSideBar;

    @FindBy(css = "#misc-price-side-bar-2-show")
    private WebElement secondMiscProductAmountForSideBar;

    /**
     * @return the miscProductHeadingName
     */
    public WebElement getMiscProductHeadingName() {
        return miscProductHeading;
    }

    /**
     * @return the firstMiscProductName
     */
    public WebElement getFirstMiscProductTitle() {
        return firstMiscProductTitle;
    }

    /**
     * @return the secondMiscProductName
     */
    public WebElement getSecondMiscProductTitle() {
        return secondMiscProductTitle;
    }

    /**
     * @return the firstMiscProductPrice
     */
    public WebElement getFirstMiscProductPrice() {
        return firstMiscProductPrice;
    }

    /**
     * @return the secondMiscProductPrice
     */
    public WebElement getSecondMiscProductPrice() {
        return secondMiscProductPrice;
    }

    /**
     * @return the firstMiscProductDescription
     */
    public WebElement getFirstMiscProductDescription() {
        return firstMiscProductDescription;
    }

    /**
     * @return the secondMiscProductDescription
     */
    public WebElement getSecondMiscProductDescription() {
        return secondMiscProductDescription;
    }

    /**
     * @return the firstMiscProductCheckBox
     */
    public WebElement getFirstMiscProductCheckBox() {
        return firstMiscProductCheckBox;
    }

    /**
     * @return the secondMiscProductCheckBox
     */
    public WebElement getSecondMiscProductCheckBox() {
        return secondMiscProductCheckBox;
    }

    /**
     * @return the miscProductHeadingNameForSideBar
     */
    public WebElement getMiscProductHeadingNameForSideBar() {
        return miscProductHeadingNameForSideBar;
    }

    /**
     * @return the miscProductTotalAmountForSideBar
     */
    public WebElement getMiscProductTotalAmountForSideBar() {
        return miscProductTotalAmountForSideBar;
    }

    /**
     * @return the firstMiscProductAmountForSideBar
     */
    public WebElement getFirstMiscProductAmountForSideBar() {
        return firstMiscProductAmountForSideBar;
    }

    /**
     * @return the secondMiscProductAmountForSideBar
     */
    public WebElement getSecondMiscProductAmountForSideBar() {
        return secondMiscProductAmountForSideBar;
    }

    /**
     * @return the firstHighlightedMiscProduct
     */
    public WebElement getFirstHighlightedMiscProduct() {
        return firstHighlightedMiscProduct;
    }

    /**
     * @return the secondHighlightedMiscProduct
     */
    public WebElement getSecondHighlightedMiscProduct() {
        return secondHighlightedMiscProduct;
    }

    /**
     * @return the miscProductHeading
     */
    public WebElement getMiscProductHeading() {
        return miscProductHeading;
    }

    /**
     * @return the firstMiscProductTitleForSideBar
     */
    public WebElement getFirstMiscProductTitleForSideBar() {
        return firstMiscProductTitleForSideBar;
    }

    /**
     * @return the secondMiscProductTitleForSideBar
     */
    public WebElement getSecondMiscProductTitleForSideBar() {
        return secondMiscProductTitleForSideBar;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MiscProductPageElement [miscProductHeading=" + miscProductHeading + ", firstMiscProductTitle=" + firstMiscProductTitle
                + ", secondMiscProductTitle=" + secondMiscProductTitle + ", firstMiscProductPrice=" + firstMiscProductPrice
                + ", secondMiscProductPrice=" + secondMiscProductPrice + ", firstMiscProductDescription=" + firstMiscProductDescription
                + ", secondMiscProductDescription=" + secondMiscProductDescription + ", firstMiscProductCheckBox=" + firstMiscProductCheckBox
                + ", secondMiscProductCheckBox=" + secondMiscProductCheckBox + ", firstHighlightedMiscProduct=" + firstHighlightedMiscProduct
                + ", secondHighlightedMiscProduct=" + secondHighlightedMiscProduct + ", miscProductHeadingNameForSideBar="
                + miscProductHeadingNameForSideBar + ", miscProductTotalAmountForSideBar=" + miscProductTotalAmountForSideBar
                + ", firstMiscProductTitleForSideBar=" + firstMiscProductTitleForSideBar + ", secondMiscProductTitleForSideBar="
                + secondMiscProductTitleForSideBar + ", firstMiscProductAmountForSideBar=" + firstMiscProductAmountForSideBar
                + ", secondMiscProductAmountForSideBar=" + secondMiscProductAmountForSideBar + "]";
    }

}
