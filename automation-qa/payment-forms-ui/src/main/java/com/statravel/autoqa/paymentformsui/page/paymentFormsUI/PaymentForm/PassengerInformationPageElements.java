package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class PassengerInformationPageElements extends PageElements {

    @FindBy(css = "#title")
    private WebElement titleInput;

    @FindBy(css = "#first-name")
    private WebElement firstNameInput;

    @FindBy(css = "#middle-name")
    private WebElement middleNameInput;

    @FindBy(css = "#last-name")
    private WebElement lastNameInput;

    @FindBy(css = "#passport-number")
    private WebElement passportNumberInput;

    @FindBy(css = "#date-of-birth")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//table//tbody//tr[2]//td[3]//button")
    private WebElement yearSelect;

    @FindBy(xpath = "//table//tbody//tr[2]//td[2]//button")
    private WebElement monthSelect;

    @FindBy(xpath = "//table//tbody//tr[3]//td[5]//button")
    private WebElement daySelect;

    @FindBy(css = "#email-address")
    private WebElement emailAddressInput;

    @FindBy(css = "#email-address-confirmation")
    private WebElement emailAddressConfirmInput;

    @FindBy(css = "#phone-number")
    private WebElement phoneNoInput;

    @FindBy(css = "#title-required")
    private WebElement requireErrorMsgForTitleInput;

    @FindBy(css = "#first-name-required")
    private WebElement requireErrorMsgForFirstNameInput;

    @FindBy(css = "#last-name-required")
    private WebElement requireErrorMsgForLastNameInput;

    @FindBy(css = "#date-of-birth-required")
    private WebElement requireErrorMsgForDateOfBirthInput;

    @FindBy(css = "#email-address-required")
    private WebElement requireErrorMsgForEmailAddressInput;

    @FindBy(css = "#phone-number-required")
    private WebElement requireErrorMsgForPhoneNoInput;

    @FindBy(css = "#email-address-invalid")
    private WebElement invalidEmailAddressMessage;

    @FindBy(css = "#email-addresses-do-not-match")
    private WebElement emailAddressDoNotMatchMessage;

    /**
     * @return the titleInput
     */
    public WebElement getTitleInput() {
        return titleInput;
    }

    /**
     * @return the firstNameInput
     */
    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    /**
     * @return the middleNameInput
     */
    public WebElement getMiddleNameInput() {
        return middleNameInput;
    }

    /**
     * @return the lastName
     */
    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    /**
     * @return the passportNumberInput
     */
    public WebElement getPassportNumberInput() {
        return passportNumberInput;
    }

    /**
     * @return the dateOfBirthInput
     */
    public WebElement getDateOfBirthInput() {
        return dateOfBirthInput;
    }

    /**
     * @return the yearSelect
     */
    public WebElement getYearSelect() {
        return yearSelect;
    }

    /**
     * @return the monthSelect
     */
    public WebElement getMonthSelect() {
        return monthSelect;
    }

    /**
     * @return the daySelect
     */
    public WebElement getDaySelect() {
        return daySelect;
    }

    /**
     * @return the emailAddressInput
     */
    public WebElement getEmailAddressInput() {
        return emailAddressInput;
    }

    /**
     * @return the emailAddressConfirmInput
     */
    public WebElement getEmailAddressConfirmInput() {
        return emailAddressConfirmInput;
    }

    /**
     * @return the phoneNoInput
     */
    public WebElement getPhoneNoInput() {
        return phoneNoInput;
    }

    /**
     * @return the requireErrorMsgForTitleInput
     */
    public WebElement getRequireErrorMsgForTitleInput() {
        return requireErrorMsgForTitleInput;
    }

    /**
     * @return the requireErrorMsgForFirstNameInput
     */
    public WebElement getRequireErrorMsgForFirstNameInput() {
        return requireErrorMsgForFirstNameInput;
    }

    /**
     * @return the requireErrorMsgForLastNameInput
     */
    public WebElement getRequireErrorMsgForLastNameInput() {
        return requireErrorMsgForLastNameInput;
    }

    /**
     * @return the requireErrorMsgForDateOfBirthInput
     */
    public WebElement getRequireErrorMsgForDateOfBirthInput() {
        return requireErrorMsgForDateOfBirthInput;
    }

    /**
     * @return the requireErrorMsgForEmailAddressInput
     */
    public WebElement getRequireErrorMsgForEmailAddressInput() {
        return requireErrorMsgForEmailAddressInput;
    }

    /**
     * @return the requireErrorMsgForPhoneNoInput
     */
    public WebElement getRequireErrorMsgForPhoneNoInput() {
        return requireErrorMsgForPhoneNoInput;
    }

    /**
     * @return the invalidEmailAddressMessage
     */
    public WebElement getInvalidEmailAddressMessage() {
        return invalidEmailAddressMessage;
    }

    /**
     * @return the emailAddressDoNotMatchMessage
     */
    public WebElement getEmailAddressDoNotMatchMessage() {
        return emailAddressDoNotMatchMessage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PassengerInformationPageElements [titleInput=" + titleInput + ", firstNameInput=" + firstNameInput + ", middleNameInput="
                + middleNameInput + ", lastNameInput=" + lastNameInput + ", passportNumberInput=" + passportNumberInput + ", dateOfBirthInput="
                + dateOfBirthInput + ", yearSelect=" + yearSelect + ", monthSelect=" + monthSelect + ", daySelect=" + daySelect
                + ", emailAddressInput=" + emailAddressInput + ", emailAddressConfirmInput=" + emailAddressConfirmInput + ", phoneNoInput="
                + phoneNoInput + ", requireErrorMsgForTitleInput=" + requireErrorMsgForTitleInput + ", requireErrorMsgForFirstNameInput="
                + requireErrorMsgForFirstNameInput + ", requireErrorMsgForLastNameInput=" + requireErrorMsgForLastNameInput
                + ", requireErrorMsgForDateOfBirthInput=" + requireErrorMsgForDateOfBirthInput + ", requireErrorMsgForEmailAddressInput="
                + requireErrorMsgForEmailAddressInput + ", requireErrorMsgForPhoneNoInput=" + requireErrorMsgForPhoneNoInput
                + ", invalidEmailAddressMessage=" + invalidEmailAddressMessage + ", emailAddressDoNotMatchMessage=" + emailAddressDoNotMatchMessage
                + "]";
    }

}
