package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class TravelInformationPageElement extends PageElements {

    @FindBy(css = "#trip-name")
    private WebElement tripName;

    @FindBy(css = ".pull-left.p-t-0.ng-binding")
    private WebElement travelHeading;

    @FindBy(css = "#travel-information-reference-number")
    private WebElement refrenceNo;

    @FindBy(css = "#total-amount-fullamount-payment")
    private WebElement totalPriceAmount;

    @FindBy(css = "#full-amount-total-amount-side-bar")
    private WebElement totalPriceAmountSideBar;

    @FindBy(css = "#main-btn")
    private WebElement proceedToBookingButton;

    @FindBy(css = "#deposit")
    private WebElement depositButton;

    @FindBy(css = "#fullAmount")
    private WebElement fullPaymentButton;

    @FindBy(css = "#balance")
    private WebElement balanceButton;

    @FindBy(xpath = ".//input[@id='fullAmount' and contains(@class,'ng-valid-parse')]")
    private WebElement selectedFullAmount;

    /**
     * @return the tripName
     */
    public WebElement getTripName() {
        return tripName;
    }

    /**
     * @return the travelHeading
     */
    public WebElement getTravelHeading() {
        return travelHeading;
    }

    /**
     * @return the refrenceNo
     */
    public WebElement getRefrenceNo() {
        return refrenceNo;
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
     * @return the proceedToBookingButton
     */
    public WebElement getProceedToBookingButton() {
        return proceedToBookingButton;
    }

    /**
     * @return the depositButton
     */
    public WebElement getDepositButton() {
        return depositButton;
    }

    /**
     * @return the fullPaymentButton
     */
    public WebElement getFullPaymentButton() {
        return fullPaymentButton;
    }

    /**
     * @return the balanceButton
     */
    public WebElement getBalanceButton() {
        return balanceButton;
    }

    /**
     * @return the selectedFullAmount
     */
    public WebElement getSelectedFullAmount() {
        return selectedFullAmount;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TravelInformationPageElement [tripName=" + tripName + ", travelHeading=" + travelHeading + ", refrenceNo=" + refrenceNo
                + ", totalPriceAmount=" + totalPriceAmount + ", totalPriceAmountSideBar=" + totalPriceAmountSideBar + ", proceedToBookingButton="
                + proceedToBookingButton + ", depositButton=" + depositButton + ", fullPaymentButton=" + fullPaymentButton + ", balanceButton="
                + balanceButton + ", selectedFullAmount=" + selectedFullAmount + "]";
    }

}
