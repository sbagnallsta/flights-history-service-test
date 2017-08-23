package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class PaymentFormPageElements extends PageElements {

    @FindBy(css = "#payment-form-reference-number")
    private WebElement refrenceNo;

    @FindBy(css = "#terms-and-conditions-checkbox")
    private WebElement termAndCondition;

    @FindBy(css = "#total-amount-fullamount-payment")
    private WebElement totalPriceAmount;

    @FindBy(css = "#full-amount-total-amount-side-bar")
    private WebElement totalPriceAmountSideBar;

    @FindBy(css = "#main-btn")
    private WebElement submitButton;

    @FindBy(css = "#genderMale")
    private WebElement genderMaleRadioButtion;

    @FindBy(css = "#genderFemale")
    private WebElement genderFemaleRadioButtion;

    @FindBy(css = "#total-amount-deposit-payment")
    private WebElement payableTodayDepositAmount;

    @FindBy(css = "#total-amount-balance-payment")
    private WebElement payableTodayBalanceAmount;

    @FindBy(css = "#total-amount-fullamount-payment")
    private WebElement payableTodayFullAmount;

    @FindBy(css = "#deposit-total-amount-side-bar")
    private WebElement payableTodayDepositAmountForSideBar;

    @FindBy(css = "#balance-total-amount-side-bar")
    private WebElement payableTodayBalanceAmountForSideBar;

    @FindBy(css = "#full-amount-total-amount-side-bar")
    private WebElement payableTodayFullAmountForSideBar;

    @FindBy(css = "#payment-form-heading")
    private WebElement paymentFormHeading;

    @FindBy(css = "#quote-request-heading")
    private WebElement quteRequestHeading;

    @FindBy(css = "#booking-total-price")
    private WebElement totalPriceForBookingAmount;

    @FindBy(css = "#booking-total-price-side-bar")
    private WebElement totalPriceForBookingAmountForSideBar;

    @FindBy(css = "#total-cost-heading")
    private WebElement totalCostHeading;

    @FindBy(css = "#total-cost-heading-side-bar")
    private WebElement totalCostHeadingForSideBar;

    @FindBy(css = "#payable-today-heading")
    private WebElement payableTodayHeading;

    @FindBy(css = "#payable-today-heading-side-bar")
    private WebElement payableTodayHeadingForSideBar;

    @FindBy(css = "#acknowledged--checkbox")
    private WebElement flightTermsAndCondition;

    /**
     * @return the submitButton
     */
    public WebElement getSubmitButton() {
        return submitButton;
    }

    /**
     * @return the firstTermAndCondition
     */
    public WebElement getTermAndCondition() {
        return termAndCondition;
    }

    /**
     * @return the totalPriceAmount
     */
    public WebElement getTotalPriceAmount() {
        return totalPriceAmount;
    }

    /**
     * @return the totalPriceAmountSideBar
     */
    public WebElement getTotalPriceAmountSideBar() {
        return totalPriceAmountSideBar;
    }

    /**
     * @return the genderMaleRadioButtion
     */
    public WebElement getGenderMaleRadioButtion() {
        return genderMaleRadioButtion;
    }

    /**
     * @return the genderFemaleRadioButtion
     */
    public WebElement getGenderFemaleRadioButtion() {
        return genderFemaleRadioButtion;
    }

    /**
     * @return the refrenceNo
     */
    public WebElement getRefrenceNo() {
        return refrenceNo;
    }

    /**
     * @return the payableTodayDepositAmount
     */
    public WebElement getPayableTodayDepositAmount() {
        return payableTodayDepositAmount;
    }

    /**
     * @return the payableTodayBalanceAmount
     */
    public WebElement getPayableTodayBalanceAmount() {
        return payableTodayBalanceAmount;
    }

    /**
     * @return the payableTodayFullAmount
     */
    public WebElement getPayableTodayFullAmount() {
        return payableTodayFullAmount;
    }

    /**
     * @return the payableTodayDepositAmountForSideBar
     */
    public WebElement getPayableTodayDepositAmountForSideBar() {
        return payableTodayDepositAmountForSideBar;
    }

    /**
     * @return the payableTodayBalanceAmountForSideBar
     */
    public WebElement getPayableTodayBalanceAmountForSideBar() {
        return payableTodayBalanceAmountForSideBar;
    }

    /**
     * @return the payableTodayFullAmountForSideBar
     */
    public WebElement getPayableTodayFullAmountForSideBar() {
        return payableTodayFullAmountForSideBar;
    }

    /**
     * @return the paymentFormHeading
     */
    public WebElement getPaymentFormHeading() {
        return paymentFormHeading;
    }

    /**
     * @return the quteRequestHeading
     */
    public WebElement getQuteRequestHeading() {
        return quteRequestHeading;
    }

    /**
     * @return the totalPriceForBookingAmount
     */
    public WebElement getTotalPriceForBookingAmount() {
        return totalPriceForBookingAmount;
    }

    /**
     * @return the totalPriceForBookingAmountForSideBar
     */
    public WebElement getTotalPriceForBookingAmountForSideBar() {
        return totalPriceForBookingAmountForSideBar;
    }

    /**
     * @return the totalCostHeading
     */
    public WebElement getTotalCostHeading() {
        return totalCostHeading;
    }

    /**
     * @return the totalCostHeadingForSideBar
     */
    public WebElement getTotalCostHeadingForSideBar() {
        return totalCostHeadingForSideBar;
    }

    /**
     * @return the payableTodayHeading
     */
    public WebElement getPayableTodayHeading() {
        return payableTodayHeading;
    }

    /**
     * @return the payableTodayHeadingForSideBar
     */
    public WebElement getPayableTodayHeadingForSideBar() {
        return payableTodayHeadingForSideBar;
    }

    /**
     * @return the flightTermsAndCondition
     */
    public WebElement getFlightTermsAndCondition() {
        return flightTermsAndCondition;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentFormPageElements [refrenceNo=" + refrenceNo + ", termAndCondition=" + termAndCondition + ", totalPriceAmount="
                + totalPriceAmount + ", totalPriceAmountSideBar=" + totalPriceAmountSideBar + ", submitButton=" + submitButton
                + ", genderMaleRadioButtion=" + genderMaleRadioButtion + ", genderFemaleRadioButtion=" + genderFemaleRadioButtion
                + ", payableTodayDepositAmount=" + payableTodayDepositAmount + ", payableTodayBalanceAmount=" + payableTodayBalanceAmount
                + ", payableTodayFullAmount=" + payableTodayFullAmount + ", payableTodayDepositAmountForSideBar="
                + payableTodayDepositAmountForSideBar + ", payableTodayBalanceAmountForSideBar=" + payableTodayBalanceAmountForSideBar
                + ", payableTodayFullAmountForSideBar=" + payableTodayFullAmountForSideBar + ", paymentFormHeading=" + paymentFormHeading
                + ", quteRequestHeading=" + quteRequestHeading + ", totalPriceForBookingAmount=" + totalPriceForBookingAmount
                + ", totalPriceForBookingAmountForSideBar=" + totalPriceForBookingAmountForSideBar + ", totalCostHeading=" + totalCostHeading
                + ", totalCostHeadingForSideBar=" + totalCostHeadingForSideBar + ", payableTodayHeading=" + payableTodayHeading
                + ", payableTodayHeadingForSideBar=" + payableTodayHeadingForSideBar + ", flightTermsAndCondition=" + flightTermsAndCondition + "]";
    }

}
