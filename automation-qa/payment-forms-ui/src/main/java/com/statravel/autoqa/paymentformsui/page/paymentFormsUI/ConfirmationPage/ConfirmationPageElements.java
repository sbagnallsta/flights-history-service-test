package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class ConfirmationPageElements extends PageElements {

    @FindBy(css = "#confirmation-reference-number")
    private WebElement refrenceNo;

    @FindBy(css = "#total-amount-fullamount-payment")
    private WebElement paidFullAmount;

    @FindBy(css = "#full-amount-total-amount-side-bar")
    private WebElement paidFullAmountForSideBar;

    @FindBy(css = "#total-amount-deposit-payment")
    private WebElement paidDepositAmount;

    @FindBy(css = "#total-amount-balance-payment")
    private WebElement paidBalanceAmount;

    @FindBy(css = "#deposit-total-amount-side-bar")
    private WebElement paidDepositAmountForSideBar;

    @FindBy(css = "#balance-total-amount-side-bar")
    private WebElement paidBalanceAmountForSideBar;

    @FindBy(css = "#booking-total-price")
    private WebElement totalPriceForBookingAmount;

    @FindBy(css = "#booking-total-price-side-bar")
    private WebElement totalPriceForBookingAmountForSideBar;

    @FindBy(css = "#remaining-balance-confirmation")
    private WebElement remainingAmount;

    @FindBy(css = "#payment-success-confirmantion-message")
    private WebElement successFullAmountPaidMessage;

    @FindBy(css = "#accommodation-heading-side-bar")
    private WebElement accommodationHeadingForSideBar;

    @FindBy(css = "#accommodation-amount-side-bar")
    private WebElement accommodationAmountForSideBar;

    @FindBy(css = "#stopover-heading-side-bar")
    private WebElement stopOverHeadingForSidebar;

    @FindBy(css = "#stopover-total-amount-side-bar")
    private WebElement totalStopoverAmountForSideBar;

    @FindBy(css = "#stopover-title-1")
    private WebElement firstStopoverNameForSideBar;

    @FindBy(css = "#stopover-title-2")
    private WebElement secondStopoverNameForSideBar;

    @FindBy(css = "#stopover-price-1")
    private WebElement firstStopoverAmountForSideBar;

    @FindBy(css = "#stopover-price-2")
    private WebElement secondStopoverAmountForSideBar;

    @FindBy(css = "#extras-heading-side-bar")
    private WebElement extraHeadingForSidebar;

    @FindBy(css = "#extras-amount-side-bar")
    private WebElement totalExtraAmountForSideBar;

    @FindBy(css = "#extras-title-side-bar-1")
    private WebElement firstExtraNameForSideBar;

    @FindBy(css = "#extras-title-side-bar-2")
    private WebElement secondExtraNameForSideBar;

    @FindBy(css = "#extras-amount-side-bar-1")
    private WebElement firstExtraAmountForSideBar;

    @FindBy(css = "#extras-amount-side-bar-2")
    private WebElement secondExtraAmountForSideBar;

    @FindBy(css = "#confirmation-email-message")
    private WebElement confirmationEmailBeenSentMessage;

    @FindBy(css = "#travel-heading-confirmation")
    private WebElement formHeading;

    @FindBy(css = "#transfers-heading-confirmation")
    private WebElement transferHeading;

    @FindBy(css = "#transfers-name-confirmation-1")
    private WebElement firstTransferName;

    @FindBy(css = "#transfers-name-confirmation-2")
    private WebElement secondTransferName;

    @FindBy(css = "#transfers-route-confirmation-1")
    private WebElement firstTransferRoute;

    @FindBy(css = "#transfers-route-confirmation-2")
    private WebElement secondTransferRoute;

    @FindBy(css = "#transfers-special-remarks-confirmation-1")
    private WebElement firstTransferSplRemark;

    @FindBy(css = "#transfers-special-remarks-confirmation-2")
    private WebElement secondTransferSplRemark;

    @FindBy(css = "#transfers-departure-date-confirmation-1")
    private WebElement firstTransferDepDate;

    @FindBy(css = "#transfers-departure-date-confirmation-2")
    private WebElement secondTransferDepDate;

    @FindBy(css = "#transfers-departure-time-confirmation-1")
    private WebElement firstTransferTime;

    @FindBy(css = "#transfers-departure-time-confirmation-2")
    private WebElement secondTransferTime;

    @FindBy(css = "#transfer-heading-side-bar")
    private WebElement transferHeadingSideBar;

    @FindBy(css = "#transfer-amount-side-bar")
    private WebElement transferAmountForSideBar;

    @FindBy(css = "#total-amount-fullamount-payment")
    private WebElement totalPriceAmount;

    @FindBy(css = "#full-amount-total-amount-side-bar")
    private WebElement totalPriceAmountSideBar;

    @FindBy(css = "#flight-heading-side-bar")
    private WebElement flightHeadingSideBar;

    @FindBy(css = "#flight-amount-side-bar")
    private WebElement flightAmountForSideBar;

    @FindBy(css = "#misc-heading-name-confirmation")
    private WebElement miscProductHeadingName;

    @FindBy(css = "#misc-title-confirmation-1")
    private WebElement firstMiscProductTitle;

    @FindBy(css = "#misc-title-confirmation-2")
    private WebElement secondMiscProductTitle;

    @FindBy(css = "#misc-description-confirmation-1")
    private WebElement firstMiscProductDescription;

    @FindBy(css = "#misc-description-confirmation-2")
    private WebElement secondMiscProductDescription;

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

    @FindBy(css = "#final-payment-due-date-heading-top-confirmation")
    private WebElement finalPaymentHeadingForTop;

    @FindBy(css = "#final-payment-due-date-heading-bottom-confirmation")
    private WebElement finalPaymentHeadingForBottom;

    @FindBy(css = "#final-payment-due-date-side-bar-heading")
    private WebElement finalPaymentHeadingForSideBar;

    @FindBy(css = "#final-payment-due-date-top-confirmation")
    private WebElement finalPaymentDateForTop;

    @FindBy(css = "#final-payment-due-date-bottom-confirmation")
    private WebElement finalPaymentDateForBottom;

    @FindBy(css = "#final-payment-due-date-side-bar-date")
    private WebElement finalPaymentDateForSideBar;

    @FindBy(css = "#others-heading-confirmation")
    private WebElement othersHeading;

    @FindBy(css = "#others-title-confirmation-1")
    private WebElement firstOthersTitle;

    @FindBy(css = "#others-title-confirmation-2")
    private WebElement secondOthersTitle;

    @FindBy(css = "#others-description-confirmation-1")
    private WebElement firstOthersTripDetails;

    @FindBy(css = "#others-description-confirmation-2")
    private WebElement secondOthersTripDetails;

    @FindBy(css = "#others-heading-side-bar")
    private WebElement otherHeadingForSideBar;

    @FindBy(css = "#others-amount-side-bar")
    private WebElement othersAmountForSideBar;

    /**
     * @return the refrenceNo
     */
    public WebElement getRefrenceNo() {
        return refrenceNo;
    }

    /**
     * @return the totalCostAmount
     */
    public WebElement getPaidFullAmount() {
        return paidFullAmount;
    }

    /**
     * @return the totalCostAmountForSideBar
     */
    public WebElement getPaidFullAmountForSideBar() {
        return paidFullAmountForSideBar;
    }

    /**
     * @return the paidDepositAmount
     */
    public WebElement getPaidDepositAmount() {
        return paidDepositAmount;
    }

    /**
     * @return the paidBalanceAmount
     */
    public WebElement getPaidBalanceAmount() {
        return paidBalanceAmount;
    }

    /**
     * @return the paidDepositAmountForSideBar
     */
    public WebElement getPaidDepositAmountForSideBar() {
        return paidDepositAmountForSideBar;
    }

    /**
     * @return the paidBalanceAmountForSideBar
     */
    public WebElement getPaidBalanceAmountForSideBar() {
        return paidBalanceAmountForSideBar;
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
     * @return the remainingAmount
     */
    public WebElement getRemainingAmount() {
        return remainingAmount;
    }

    /**
     * @return the successFullAmountPaidMessage
     */
    public WebElement getSuccessFullAmountPaidMessage() {
        return successFullAmountPaidMessage;
    }

    /**
     * @return the accommodationHeadingForSideBar
     */
    public WebElement getAccommodationHeadingForSideBar() {
        return accommodationHeadingForSideBar;
    }

    /**
     * @return the accommodationAmountForSideBar
     */
    public WebElement getAccommodationAmountForSideBar() {
        return accommodationAmountForSideBar;
    }

    /**
     * @return the sideBarHeading
     */
    public WebElement getStopOverHeadingForSidebar() {
        return stopOverHeadingForSidebar;
    }

    /**
     * @return the totalStopoverAmountForSideBar
     */
    public WebElement getTotalStopoverAmountForSideBar() {
        return totalStopoverAmountForSideBar;
    }

    /**
     * @return the firstStopoverNameForSideBar
     */
    public WebElement getFirstStopoverNameForSideBar() {
        return firstStopoverNameForSideBar;
    }

    /**
     * @return the secondStopoverNameForSideBar
     */
    public WebElement getSecondStopoverNameForSideBar() {
        return secondStopoverNameForSideBar;
    }

    /**
     * @return the firstStopoverAmountForSideBar
     */
    public WebElement getFirstStopoverAmountForSideBar() {
        return firstStopoverAmountForSideBar;
    }

    /**
     * @return the secondStopoverAmountForSideBar
     */
    public WebElement getSecondStopoverAmountForSideBar() {
        return secondStopoverAmountForSideBar;
    }

    /**
     * @return the totalExtraAmountForSideBar
     */
    public WebElement getTotalExtraAmountForSideBar() {
        return totalExtraAmountForSideBar;
    }

    /**
     * @return the firstExtraNameForSideBar
     */
    public WebElement getFirstExtraNameForSideBar() {
        return firstExtraNameForSideBar;
    }

    /**
     * @return the secondExtraNameForSideBar
     */
    public WebElement getSecondExtraNameForSideBar() {
        return secondExtraNameForSideBar;
    }

    /**
     * @return the firstExtraAmountForSideBar
     */
    public WebElement getFirstExtraAmountForSideBar() {
        return firstExtraAmountForSideBar;
    }

    /**
     * @return the secondExtraAmountForSideBar
     */
    public WebElement getSecondExtraAmountForSideBar() {
        return secondExtraAmountForSideBar;
    }

    /**
     * @return the confirmationEmailBeenSentMessage
     */
    public WebElement getConfirmationEmailBeenSentMessage() {
        return confirmationEmailBeenSentMessage;
    }

    /**
     * @return the heading
     */
    public WebElement getFormHeading() {
        return formHeading;
    }

    /**
     * @return the extraHeadingForSidebar
     */
    public WebElement getExtraHeadingForSidebar() {
        return extraHeadingForSidebar;
    }

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
     * @return the flightHeadingSideBar
     */
    public WebElement getFlightHeadingSideBar() {
        return flightHeadingSideBar;
    }

    /**
     * @return the flightAmountForSideBar
     */
    public WebElement getFlightAmountForSideBar() {
        return flightAmountForSideBar;
    }

    /**
     * @return the firstMiscProductTitle
     */
    public WebElement getFirstMiscProductTitle() {
        return firstMiscProductTitle;
    }

    /**
     * @return the secondMiscProductTitle
     */
    public WebElement getSecondMiscProductTitle() {
        return secondMiscProductTitle;
    }

    /**
     * @return the firstMiscProductDescription
     */
    public WebElement getFirstMiscProductDescription() {
        return firstMiscProductDescription;
    }

    /**
     * @return the miscProductHeadingName
     */
    public WebElement getMiscProductHeadingName() {
        return miscProductHeadingName;
    }

    /**
     * @return the secondMiscProductDescription
     */
    public WebElement getSecondMiscProductDescription() {
        return secondMiscProductDescription;
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
     * @return the finalPaymentHeadingForTop
     */
    public WebElement getFinalPaymentHeadingForTop() {
        return finalPaymentHeadingForTop;
    }

    /**
     * @return the finalPaymentHeadingForBottom
     */
    public WebElement getFinalPaymentHeadingForBottom() {
        return finalPaymentHeadingForBottom;
    }

    /**
     * @return the finalPaymentHeadingForSideBar
     */
    public WebElement getFinalPaymentHeadingForSideBar() {
        return finalPaymentHeadingForSideBar;
    }

    /**
     * @return the finalPaymentDateForTop
     */
    public WebElement getFinalPaymentDateForTop() {
        return finalPaymentDateForTop;
    }

    /**
     * @return the finalPaymentDateForBottom
     */
    public WebElement getFinalPaymentDateForBottom() {
        return finalPaymentDateForBottom;
    }

    /**
     * @return the finalPaymentDateForSideBar
     */
    public WebElement getFinalPaymentDateForSideBar() {
        return finalPaymentDateForSideBar;
    }

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
        return "ConfirmationPageElements [refrenceNo=" + refrenceNo + ", paidFullAmount=" + paidFullAmount + ", paidFullAmountForSideBar="
                + paidFullAmountForSideBar + ", paidDepositAmount=" + paidDepositAmount + ", paidBalanceAmount=" + paidBalanceAmount
                + ", paidDepositAmountForSideBar=" + paidDepositAmountForSideBar + ", paidBalanceAmountForSideBar=" + paidBalanceAmountForSideBar
                + ", totalPriceForBookingAmount=" + totalPriceForBookingAmount + ", totalPriceForBookingAmountForSideBar="
                + totalPriceForBookingAmountForSideBar + ", remainingAmount=" + remainingAmount + ", successFullAmountPaidMessage="
                + successFullAmountPaidMessage + ", accommodationHeadingForSideBar=" + accommodationHeadingForSideBar
                + ", accommodationAmountForSideBar=" + accommodationAmountForSideBar + ", stopOverHeadingForSidebar=" + stopOverHeadingForSidebar
                + ", totalStopoverAmountForSideBar=" + totalStopoverAmountForSideBar + ", firstStopoverNameForSideBar=" + firstStopoverNameForSideBar
                + ", secondStopoverNameForSideBar=" + secondStopoverNameForSideBar + ", firstStopoverAmountForSideBar="
                + firstStopoverAmountForSideBar + ", secondStopoverAmountForSideBar=" + secondStopoverAmountForSideBar + ", extraHeadingForSidebar="
                + extraHeadingForSidebar + ", totalExtraAmountForSideBar=" + totalExtraAmountForSideBar + ", firstExtraNameForSideBar="
                + firstExtraNameForSideBar + ", secondExtraNameForSideBar=" + secondExtraNameForSideBar + ", firstExtraAmountForSideBar="
                + firstExtraAmountForSideBar + ", secondExtraAmountForSideBar=" + secondExtraAmountForSideBar + ", confirmationEmailBeenSentMessage="
                + confirmationEmailBeenSentMessage + ", formHeading=" + formHeading + ", transferHeading=" + transferHeading + ", firstTransferName="
                + firstTransferName + ", secondTransferName=" + secondTransferName + ", firstTransferRoute=" + firstTransferRoute
                + ", secondTransferRoute=" + secondTransferRoute + ", firstTransferSplRemark=" + firstTransferSplRemark + ", secondTransferSplRemark="
                + secondTransferSplRemark + ", firstTransferDepDate=" + firstTransferDepDate + ", secondTransferDepDate=" + secondTransferDepDate
                + ", firstTransferTime=" + firstTransferTime + ", secondTransferTime=" + secondTransferTime + ", transferHeadingSideBar="
                + transferHeadingSideBar + ", transferAmountForSideBar=" + transferAmountForSideBar + ", totalPriceAmount=" + totalPriceAmount
                + ", totalPriceAmountSideBar=" + totalPriceAmountSideBar + ", flightHeadingSideBar=" + flightHeadingSideBar
                + ", flightAmountForSideBar=" + flightAmountForSideBar + ", miscProductHeadingName=" + miscProductHeadingName
                + ", firstMiscProductTitle=" + firstMiscProductTitle + ", secondMiscProductTitle=" + secondMiscProductTitle
                + ", firstMiscProductDescription=" + firstMiscProductDescription + ", secondMiscProductDescription=" + secondMiscProductDescription
                + ", miscProductHeadingNameForSideBar=" + miscProductHeadingNameForSideBar + ", miscProductTotalAmountForSideBar="
                + miscProductTotalAmountForSideBar + ", firstMiscProductTitleForSideBar=" + firstMiscProductTitleForSideBar
                + ", secondMiscProductTitleForSideBar=" + secondMiscProductTitleForSideBar + ", firstMiscProductAmountForSideBar="
                + firstMiscProductAmountForSideBar + ", secondMiscProductAmountForSideBar=" + secondMiscProductAmountForSideBar
                + ", finalPaymentHeadingForTop=" + finalPaymentHeadingForTop + ", finalPaymentHeadingForBottom=" + finalPaymentHeadingForBottom
                + ", finalPaymentHeadingForSideBar=" + finalPaymentHeadingForSideBar + ", finalPaymentDateForTop=" + finalPaymentDateForTop
                + ", finalPaymentDateForBottom=" + finalPaymentDateForBottom + ", finalPaymentDateForSideBar=" + finalPaymentDateForSideBar
                + ", othersHeading=" + othersHeading + ", firstOthersTitle=" + firstOthersTitle + ", secondOthersTitle=" + secondOthersTitle
                + ", firstOthersTripDetails=" + firstOthersTripDetails + ", secondOthersTripDetails=" + secondOthersTripDetails
                + ", otherHeadingForSideBar=" + otherHeadingForSideBar + ", othersAmountForSideBar=" + othersAmountForSideBar + "]";
    }

}
