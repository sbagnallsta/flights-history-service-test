package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class TransferPageElements extends PageElements {

    @FindBy(css = "#transfers-heading")
    private WebElement transferHeading;

    @FindBy(css = "#transfers-name-1")
    private WebElement firstTransferName;

    @FindBy(css = "#transfers-name-2")
    private WebElement secondTransferName;

    @FindBy(css = "#transfers-route-1")
    private WebElement firstTransferRoute;

    @FindBy(css = "#transfers-route-2")
    private WebElement secondTransferRoute;

    @FindBy(css = "#transfers-special-remarks-1")
    private WebElement firstTransferSplRemark;

    @FindBy(css = "#transfers-special-remarks-2")
    private WebElement secondTransferSplRemark;

    @FindBy(css = "#transfers-departure-date-1")
    private WebElement firstTransferDepDate;

    @FindBy(css = "#transfers-departure-date-2")
    private WebElement secondTransferDepDate;

    @FindBy(css = "#transfers-departure-time-1")
    private WebElement firstTransferTime;

    @FindBy(css = "#transfers-departure-time-2")
    private WebElement secondTransferTime;

    @FindBy(css = "#transfer-heading-side-bar")
    private WebElement transferHeadingSideBar;

    @FindBy(css = "#transfer-amount-side-bar")
    private WebElement transferAmountForSideBar;

    /**
     * @return the transferHeading
     */
    public WebElement getTransferHeading() {
        return transferHeading;
    }

    /**
     * @return the firstTransferName
     */
    public WebElement getFirstTransferName() {
        return firstTransferName;
    }

    /**
     * @return the secondTransferName
     */
    public WebElement getSecondTransferName() {
        return secondTransferName;
    }

    /**
     * @return the firstTransferRoute
     */
    public WebElement getFirstTransferRoute() {
        return firstTransferRoute;
    }

    /**
     * @return the secondTransferRoute
     */
    public WebElement getSecondTransferRoute() {
        return secondTransferRoute;
    }

    /**
     * @return the firstTransferSplRemark
     */
    public WebElement getFirstTransferSplRemark() {
        return firstTransferSplRemark;
    }

    /**
     * @return the secondTransferSplRemark
     */
    public WebElement getSecondTransferSplRemark() {
        return secondTransferSplRemark;
    }

    /**
     * @return the firstTransferDepDate
     */
    public WebElement getFirstTransferDepDate() {
        return firstTransferDepDate;
    }

    /**
     * @return the secondTransferDepDate
     */
    public WebElement getSecondTransferDepDate() {
        return secondTransferDepDate;
    }

    /**
     * @return the firstTransferTime
     */
    public WebElement getFirstTransferTime() {
        return firstTransferTime;
    }

    /**
     * @return the secondTransferTime
     */
    public WebElement getSecondTransferTime() {
        return secondTransferTime;
    }

    /**
     * @return the transferHeadingSideBar
     */
    public WebElement getTransferHeadingSideBar() {
        return transferHeadingSideBar;
    }

    /**
     * @return the transferAmountForSideBar
     */
    public WebElement getTransferAmountForSideBar() {
        return transferAmountForSideBar;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TransferPageElements [transferHeading=" + transferHeading + ", firstTransferName=" + firstTransferName + ", secondTransferName="
                + secondTransferName + ", firstTransferRoute=" + firstTransferRoute + ", secondTransferRoute=" + secondTransferRoute
                + ", firstTransferSplRemark=" + firstTransferSplRemark + ", secondTransferSplRemark=" + secondTransferSplRemark
                + ", firstTransferDepDate=" + firstTransferDepDate + ", secondTransferDepDate=" + secondTransferDepDate + ", firstTransferTime="
                + firstTransferTime + ", secondTransferTime=" + secondTransferTime + ", transferHeadingSideBar=" + transferHeadingSideBar
                + ", transferAmountForSideBar=" + transferAmountForSideBar + "]";
    }

}
