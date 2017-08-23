package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class CancellationFeePageElements extends PageElements {

    @FindBy(css = "#cancellation-fees-type-1")
    private WebElement firstTypeInput;

    @FindBy(css = "#cancellation-fees-type-2")
    private WebElement secondTypeInput;

    @FindBy(css = "#cancellation-fees-due-1")
    private WebElement firstDueDateInput;

    @FindBy(css = "#cancellation-fees-due-1")
    private WebElement secondDueDateInput;

    @FindBy(css = "#cancellation-fees-penalty-1")
    private WebElement firstPenaltyInput;

    @FindBy(css = "#cancellation-fees-penalty-2")
    private WebElement secondPanaltyInput;

    @FindBy(css = "#cancellation-fees-delete-1")
    private WebElement firstDeleteButton;

    @FindBy(css = "#cancellation-fees-delete-2")
    private WebElement secondDeleteButton;

    @FindBy(css = "#cancellation-fees-type-warning-1")
    private WebElement typeIsRequireMessage;

    @FindBy(css = "#cancellation-fees-due-warning-1")
    private WebElement dueDateRequireMessage;

    @FindBy(css = "#cancellation-fees-penalty-warning-1")
    private WebElement penaltyRequireMessage;

    /**
     * @return the firstTypeInput
     */
    public WebElement getFirstTypeInput() {
        return firstTypeInput;
    }

    /**
     * @return the secondTypeInput
     */
    public WebElement getSecondTypeInput() {
        return secondTypeInput;
    }

    /**
     * @return the firstDueDateInput
     */
    public WebElement getFirstDueDateInput() {
        return firstDueDateInput;
    }

    /**
     * @return the secondDueDateInput
     */
    public WebElement getSecondDueDateInput() {
        return secondDueDateInput;
    }

    /**
     * @return the firstPanaltyInput
     */
    public WebElement getFirstPenaltyInput() {
        return firstPenaltyInput;
    }

    /**
     * @return the secondPanaltyInput
     */
    public WebElement getSecondPanaltyInput() {
        return secondPanaltyInput;
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
     * @return the typeIsRequireMessage
     */
    public WebElement getTypeIsRequireMessage() {
        return typeIsRequireMessage;
    }

    /**
     * @return the dueDateRequireMessage
     */
    public WebElement getDueDateRequireMessage() {
        return dueDateRequireMessage;
    }

    /**
     * @return the penaltyRequireMessage
     */
    public WebElement getPenaltyRequireMessage() {
        return penaltyRequireMessage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CancellationFeesPageElements [firstTypeInput=" + firstTypeInput + ", secondTypeInput=" + secondTypeInput + ", firstDueDateInput="
                + firstDueDateInput + ", secondDueDateInput=" + secondDueDateInput + ", firstPenaltyInput=" + firstPenaltyInput
                + ", secondPanaltyInput=" + secondPanaltyInput + ", firstDeleteButton=" + firstDeleteButton + ", secondDeleteButton="
                + secondDeleteButton + ", typeIsRequireMessage=" + typeIsRequireMessage + ", dueDateRequireMessage=" + dueDateRequireMessage
                + ", penaltyRequireMessage=" + penaltyRequireMessage + "]";
    }

}
