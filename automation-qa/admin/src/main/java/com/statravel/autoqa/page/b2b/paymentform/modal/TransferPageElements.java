package com.statravel.autoqa.page.b2b.paymentform.modal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class TransferPageElements extends PageElements {

    @FindBy(css = "#travel-info-transfer-name")
    private WebElement nameInput;

    @FindBy(css = "#travel-info-transfer-routes")
    private WebElement routeInput;

    @FindBy(css = "#travel-info-transfer-date")
    private WebElement departureDateInput;

    @FindBy(xpath = "//table//tr[6]//td[3]//button")
    private WebElement departureDayButton;

    @FindBy(css = "#travel-info-transfer-departure-time-hh")
    private WebElement departureHoursSelect;

    @FindBy(css = "#travel-info-transfer-departure-time-mm")
    private WebElement departureMinutesSelect;

    @FindBy(css = "#travel-info-transfer-special-remarks")
    private WebElement specialRemarkInput;

    @FindBy(css = "#travel-info-transfer-save")
    private WebElement saveButton;

    @FindBy(css = "#travel-info-transfer-cancel")
    private WebElement cancelButton;

    @FindBy(how = How.CSS, using = ".modal .modal-content")
    private WebElement lightbox;

    @FindBy(css = "#travel-info-transfer-name-warning")
    private WebElement transferNameRequiredMessage;

    @FindBy(css = "#travel-info-transfer-routes-warning")
    private WebElement transferRoutesRequiredMessage;

    @FindBy(css = "#travel-info-transfer-date-warning")
    private WebElement transferDateRequiredMessage;

    @FindBy(css = "#travel-info-transfer-departure-time-warning")
    private WebElement transferTimeRequiredMessage;

    @FindBy(xpath = "//span[@id='travel-info-transfer-name-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement trasferNameReqireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-transfer-routes-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement trasferRouteReqireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-transfer-date-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement trasferDepartureDateReqireErrorMessage;

    @FindBy(xpath = "//span[@id='travel-info-transfer-departure-time-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement trasferDepartureTimeReqireErrorMessage;

    /**
     * @return the nameInput
     */
    public WebElement getNameInput() {
        return nameInput;
    }

    /**
     * @return the routeInput
     */
    public WebElement getRouteInput() {
        return routeInput;
    }

    /**
     * @return the departureDateInput
     */
    public WebElement getDepartureDateInput() {
        return departureDateInput;
    }

    /**
     * @return the departureDayButton
     */
    public WebElement getDepartureDayButton() {
        return departureDayButton;
    }

    /**
     * @return the departureHoursSelect
     */
    public WebElement getDepartureHoursSelect() {
        return departureHoursSelect;
    }

    /**
     * @return the departureMinutesSelect
     */
    public WebElement getDepartureMinutesSelect() {
        return departureMinutesSelect;
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
     * @return the light box
     */
    public WebElement getLightbox() {
        return lightbox;
    }

    /**
     * @return the transferNameRequiredMessage
     */
    public WebElement getTransferNameRequiredMessage() {
        return transferNameRequiredMessage;
    }

    /**
     * @return the transferRoutesRequiredMessage
     */
    public WebElement getTransferRoutesRequiredMessage() {
        return transferRoutesRequiredMessage;
    }

    /**
     * @return the transferDateRequiredMessage
     */
    public WebElement getTransferDateRequiredMessage() {
        return transferDateRequiredMessage;
    }

    /**
     * @return the transferTimeRequiredMessage
     */
    public WebElement getTransferTimeRequiredMessage() {
        return transferTimeRequiredMessage;
    }

    /**
     * @return the trasferNameReqireErrorMessage
     */
    public WebElement getTrasferNameReqireErrorMessage() {
        return trasferNameReqireErrorMessage;
    }

    /**
     * @return the trasferRouteReqireErrorMessage
     */
    public WebElement getTrasferRouteReqireErrorMessage() {
        return trasferRouteReqireErrorMessage;
    }

    /**
     * @return the trasferDepartureDateReqireErrorMessage
     */
    public WebElement getTrasferDepartureDateReqireErrorMessage() {
        return trasferDepartureDateReqireErrorMessage;
    }

    /**
     * @return the trasferDepartureTimeReqireErrorMessage
     */
    public WebElement getTrasferDepartureTimeReqireErrorMessage() {
        return trasferDepartureTimeReqireErrorMessage;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TransferPageElements [nameInput=" + nameInput + ", routeInput=" + routeInput + ", departureDateInput=" + departureDateInput
                + ", departureDayButton=" + departureDayButton + ", departureHoursSelect=" + departureHoursSelect + ", departureMinutesSelect="
                + departureMinutesSelect + ", specialRemarkInput=" + specialRemarkInput + ", saveButton=" + saveButton + ", cancelButton="
                + cancelButton + ", lightbox=" + lightbox + ", transferNameRequiredMessage=" + transferNameRequiredMessage
                + ", transferRoutesRequiredMessage=" + transferRoutesRequiredMessage + ", transferDateRequiredMessage=" + transferDateRequiredMessage
                + ", transferTimeRequiredMessage=" + transferTimeRequiredMessage + ", trasferNameReqireErrorMessage=" + trasferNameReqireErrorMessage
                + ", trasferRouteReqireErrorMessage=" + trasferRouteReqireErrorMessage + ", trasferDepartureDateReqireErrorMessage="
                + trasferDepartureDateReqireErrorMessage + ", trasferDepartureTimeReqireErrorMessage=" + trasferDepartureTimeReqireErrorMessage + "]";
    }

}
