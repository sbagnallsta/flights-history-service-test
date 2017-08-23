package com.statravel.autoqa.page.b2b.paymentform.modal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class AccommodationPageElements extends PageElements {

    @FindBy(css = "#travel-info-accommodation-name")
    private WebElement nameInput;

    @FindBy(css = "#travel-info-accommodation-city")
    private WebElement cityInput;

    @FindBy(css = "#travel-info-accommodation-address")
    private WebElement addressInput;

    @FindBy(css = "#travel-info-accommodation-rooms")
    private WebElement roomsInput;

    @FindBy(css = "#travel-info-accommodation-room-type")
    private WebElement roomTypeInput;

    @FindBy(css = "#travel-info-accommodation-check-in-date")
    private WebElement checkInCalendarSelect;

    @FindBy(xpath = "//table//tr[6]//td[3]//button")
    private WebElement checkInDateButton;

    @FindBy(css = "#travel-info-accommodation-check-in-time-hh")
    private WebElement checkInHourSelect;

    @FindBy(css = "#travel-info-accommodation-check-in-time-mm")
    private WebElement checkInMinuteSelect;

    @FindBy(css = "#travel-info-accommodation-check-out-date")
    private WebElement checkOutCalendarSelect;

    @FindBy(xpath = "//table//tr[6]//td[6]//button")
    private WebElement checkOutDateButton;
    
    @FindBy(css = ".btn.btn-default.btn-sm.pull-right']")
    private WebElement checkOutDateNextMonthButton;

    @FindBy(css = "#travel-info-accommodation-check-out-time-hh")
    private WebElement checkOutHourSelect;

    @FindBy(css = "#travel-info-accommodation-check-out-time-mm")
    private WebElement checkOutMinuteSelect;

    @FindBy(css = "#travel-info-accommodation-nights")
    private WebElement nightsInput;

    @FindBy(css = "#travel-info-accommodation-special-remarks")
    private WebElement specialRemarkInput;

    @FindBy(css = "#travel-info-accommodation-save")
    private WebElement saveButton;

    @FindBy(css = "#travel-info-accommodation-cancel")
    private WebElement cancelButton;

    @FindBy(css = ".modal-content")
    private WebElement lightBox;

    @FindBy(css = "#travel-info-accommodation-name-warning")
    private WebElement nameRequireMessage;

    @FindBy(css = "#travel-info-accommodation-city-warning")
    private WebElement cityRequireMessage;

    @FindBy(css = "#travel-info-accommodation-address-warning")
    private WebElement addressRequireMessage;

    @FindBy(css = "#travel-info-accommodation-rooms-warning-required")
    private WebElement roomsRequireMessage;

    @FindBy(css = "#travel-info-accommodation-room-type-warning")
    private WebElement roomsTypeRequireMessage;

    @FindBy(css = "#travel-info-accommodation-check-in-date-warning")
    private WebElement checkInDateRequireMessage;

    @FindBy(css = "#travel-info-accommodation-check-in-time-warning")
    private WebElement checkInTimeRequireMessage;

    @FindBy(css = "#travel-info-accommodation-check-out-date-warning")
    private WebElement checkOutDateRequireMessage;

    @FindBy(css = "#travel-info-accommodation-check-out-time-warning")
    private WebElement checkOutTimeRequireMessage;

    @FindBy(css = "#travel-info-accommodation-nights-warning-required")
    private WebElement nightsRequireMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-name-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement nameRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-city-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement cityRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-address-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement addressRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-rooms-warning-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement roomsRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-room-type-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement roomsTypeRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-check-in-date-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement checkInDateRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-check-in-time-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement checkInTimeRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-check-out-date-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement checkOutDateRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-check-out-time-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement checkOutTimeRequireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-nights-warning-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement nightsRequireErrorMessage;

    @FindBy(css = "#travel-info-accommodation-rooms-warning-numeric")
    private WebElement roomsIsNumericFieldMessage;

    @FindBy(css = "#travel-info-accommodation-nights-warning-numeric")
    private WebElement nightsIsNumericFieldMessage;

    /**
     * @return the nameInput
     */
    public WebElement getNameInput() {
        return nameInput;
    }

    /**
     * @return the cityInput
     */
    public WebElement getCityInput() {
        return cityInput;
    }

    /**
     * @return the addressInput
     */
    public WebElement getAddressInput() {
        return addressInput;
    }

    /**
     * @return the roomsInput
     */
    public WebElement getRoomsInput() {
        return roomsInput;
    }

    /**
     * @return the roomTypeInput
     */
    public WebElement getRoomTypeInput() {
        return roomTypeInput;
    }

    /**
     * @return the checkInCalendarSelect
     */
    public WebElement getCheckInCalendarSelect() {
        return checkInCalendarSelect;
    }

    /**
     * @return the checkInDateButton
     */
    public WebElement getCheckInDateButton() {
        return checkInDateButton;
    }

    /**
     * @return the checkInHourSelect
     */
    public WebElement getCheckInHourSelect() {
        return checkInHourSelect;
    }

    /**
     * @return the checkInMinuteSelect
     */
    public WebElement getCheckInMinuteSelect() {
        return checkInMinuteSelect;
    }

    /**
     * @return the checkOutCalendarSelect
     */
    public WebElement getCheckOutCalendarSelect() {
        return checkOutCalendarSelect;
    }

    /**
     * @return the checkOutDateButton
     */
    public WebElement getCheckOutDateButton() {
        return checkOutDateButton;
    }

    /**
     * @return the checkOutHourSelect
     */
    public WebElement getCheckOutHourSelect() {
        return checkOutHourSelect;
    }

    /**
     * @return the checkOutMinuteSelect
     */
    public WebElement getCheckOutMinuteSelect() {
        return checkOutMinuteSelect;
    }

    /**
     * @return the nightsInput
     */
    public WebElement getNightsInput() {
        return nightsInput;
    }

    /**
     * @return the specialRemarkInput
     */
    public WebElement getSpecialRemarkInput() {
        return specialRemarkInput;
    }

    /**
     * @return the saveButton
     */
    public WebElement getSaveButton() {
        return saveButton;
    }

    /**
     * @return the cancelButton
     */
    public WebElement getCancelButton() {
        return cancelButton;
    }

    /**
     * @return the lightBox
     */
    public WebElement getLightBox() {
        return lightBox;
    }

    /**
     * @return the nameRequireMessage
     */
    public WebElement getNameRequireMessage() {
        return nameRequireMessage;
    }

    /**
     * @return the cityRequireMessage
     */
    public WebElement getCityRequireMessage() {
        return cityRequireMessage;
    }

    /**
     * @return the addressRequireMessage
     */
    public WebElement getAddressRequireMessage() {
        return addressRequireMessage;
    }

    /**
     * @return the roomsRequireMessage
     */
    public WebElement getRoomsRequireMessage() {
        return roomsRequireMessage;
    }

    /**
     * @return the roomsTypeRequireMessage
     */
    public WebElement getRoomsTypeRequireMessage() {
        return roomsTypeRequireMessage;
    }

    /**
     * @return the checkInDateRequireMessage
     */
    public WebElement getCheckInDateRequireMessage() {
        return checkInDateRequireMessage;
    }

    /**
     * @return the checkInTimeRequireMessage
     */
    public WebElement getCheckInTimeRequireMessage() {
        return checkInTimeRequireMessage;
    }

    /**
     * @return the checkOutDateRequireMessage
     */
    public WebElement getCheckOutDateRequireMessage() {
        return checkOutDateRequireMessage;
    }

    /**
     * @return the checkOutTimeRequireMessage
     */
    public WebElement getCheckOutTimeRequireMessage() {
        return checkOutTimeRequireMessage;
    }

    /**
     * @return the nightsRequireMessage
     */
    public WebElement getNightsRequireMessage() {
        return nightsRequireMessage;
    }

    /**
     * @return the nameRequireErrorMessage
     */
    public WebElement getNameRequireErrorMessage() {
        return nameRequireErrorMessage;
    }

    /**
     * @return the cityRequireErrorMessage
     */
    public WebElement getCityRequireErrorMessage() {
        return cityRequireErrorMessage;
    }

    /**
     * @return the addressRequireErrorMessage
     */
    public WebElement getAddressRequireErrorMessage() {
        return addressRequireErrorMessage;
    }

    /**
     * @return the roomsRequireErrorMessage
     */
    public WebElement getRoomsRequireErrorMessage() {
        return roomsRequireErrorMessage;
    }

    /**
     * @return the roomsTypeRequireErrorMessage
     */
    public WebElement getRoomsTypeRequireErrorMessage() {
        return roomsTypeRequireErrorMessage;
    }

    /**
     * @return the checkInDateRequireErrorMessage
     */
    public WebElement getCheckInDateRequireErrorMessage() {
        return checkInDateRequireErrorMessage;
    }

    /**
     * @return the checkInTimeRequireErrorMessage
     */
    public WebElement getCheckInTimeRequireErrorMessage() {
        return checkInTimeRequireErrorMessage;
    }

    /**
     * @return the checkOutDateRequireErrorMessage
     */
    public WebElement getCheckOutDateRequireErrorMessage() {
        return checkOutDateRequireErrorMessage;
    }

    /**
     * @return the checkOutTimeRequireErrorMessage
     */
    public WebElement getCheckOutTimeRequireErrorMessage() {
        return checkOutTimeRequireErrorMessage;
    }

    /**
     * @return the nightsRequireErrorMessage
     */
    public WebElement getNightsRequireErrorMessage() {
        return nightsRequireErrorMessage;
    }

    /**
     * @return the roomsIsNumericFieldMessage
     */
    public WebElement getRoomsIsNumericFieldMessage() {
        return roomsIsNumericFieldMessage;
    }

    /**
     * @return the nightsIsNumericFieldMessage
     */
    public WebElement getNightsIsNumericFieldMessage() {
        return nightsIsNumericFieldMessage;
    }

    /**
     * @return the checkOutDateNextMonthButton
     */
    public WebElement getCheckOutDateNextMonthButton() {
        return checkOutDateNextMonthButton;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AccommodationPageElements [nameInput=" + nameInput + ", cityInput=" + cityInput + ", addressInput=" + addressInput + ", roomsInput="
                + roomsInput + ", roomTypeInput=" + roomTypeInput + ", checkInCalendarSelect=" + checkInCalendarSelect + ", checkInDateButton="
                + checkInDateButton + ", checkInHourSelect=" + checkInHourSelect + ", checkInMinuteSelect=" + checkInMinuteSelect
                + ", checkOutCalendarSelect=" + checkOutCalendarSelect + ", checkOutDateButton=" + checkOutDateButton
                + ", checkOutDateNextMonthButton=" + checkOutDateNextMonthButton + ", checkOutHourSelect=" + checkOutHourSelect
                + ", checkOutMinuteSelect=" + checkOutMinuteSelect + ", nightsInput=" + nightsInput + ", specialRemarkInput=" + specialRemarkInput
                + ", saveButton=" + saveButton + ", cancelButton=" + cancelButton + ", lightBox=" + lightBox + ", nameRequireMessage="
                + nameRequireMessage + ", cityRequireMessage=" + cityRequireMessage + ", addressRequireMessage=" + addressRequireMessage
                + ", roomsRequireMessage=" + roomsRequireMessage + ", roomsTypeRequireMessage=" + roomsTypeRequireMessage
                + ", checkInDateRequireMessage=" + checkInDateRequireMessage + ", checkInTimeRequireMessage=" + checkInTimeRequireMessage
                + ", checkOutDateRequireMessage=" + checkOutDateRequireMessage + ", checkOutTimeRequireMessage=" + checkOutTimeRequireMessage
                + ", nightsRequireMessage=" + nightsRequireMessage + ", nameRequireErrorMessage=" + nameRequireErrorMessage
                + ", cityRequireErrorMessage=" + cityRequireErrorMessage + ", addressRequireErrorMessage=" + addressRequireErrorMessage
                + ", roomsRequireErrorMessage=" + roomsRequireErrorMessage + ", roomsTypeRequireErrorMessage=" + roomsTypeRequireErrorMessage
                + ", checkInDateRequireErrorMessage=" + checkInDateRequireErrorMessage + ", checkInTimeRequireErrorMessage="
                + checkInTimeRequireErrorMessage + ", checkOutDateRequireErrorMessage=" + checkOutDateRequireErrorMessage
                + ", checkOutTimeRequireErrorMessage=" + checkOutTimeRequireErrorMessage + ", nightsRequireErrorMessage=" + nightsRequireErrorMessage
                + ", roomsIsNumericFieldMessage=" + roomsIsNumericFieldMessage + ", nightsIsNumericFieldMessage=" + nightsIsNumericFieldMessage + "]";
    }

}
