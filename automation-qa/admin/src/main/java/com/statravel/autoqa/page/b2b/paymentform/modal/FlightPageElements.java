package com.statravel.autoqa.page.b2b.paymentform.modal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class FlightPageElements extends PageElements {

    @FindBy(xpath = "//h2[@class='subHeading']")
    private WebElement pageHeader;

    @FindBy(xpath = "//h2[contains(text(),'Flight 1')]")
    private WebElement flightOneHeader;

    @FindBy(css = "#flight-detail-airline-warning-1")
    private WebElement airlineReqMsg;

    @FindBy(css = "#flight-detail-number-warning-1")
    private WebElement flightNoReqMsg;

    @FindBy(css = "#flight-detail-departure-date-warning-1")
    private WebElement departureDateReqMsg;

    @FindBy(css = "#flight-detail-departure-time-warning-1")
    private WebElement depTimeReqMsg;

    @FindBy(css = "#flight-detail-departure-city-warning-1")
    private WebElement departureCityReqMsg;

    @FindBy(css = "#flight-detail-departure-airport-code-warning-1")
    private WebElement departureAirportCodeReqMsg;

    @FindBy(css = "#flight-detail-arrival-date-warning-1")
    private WebElement arrivalDateReqMsg;

    @FindBy(css = "#flight-detail-arrival-time-warning-1")
    private WebElement arrivalTimeReqMsg;

    @FindBy(css = "#flight-detail-arrival-city-warning-1")
    private WebElement arrivalCityReqMsg;
    
    @FindBy(css = "#flight-detail-arrival-airport-code-warning-1")
    private WebElement arrivalAirportCodeReqMsg;

    @FindBy(css = "#flight-detail-airline-1")
    private WebElement firstFlightAirlineNameInput;

    @FindBy(css = "#flight-detail-operator-1")
    private WebElement firstFlightFlightOperatorInput;

    @FindBy(css = "#flight-detail-number-1")
    private WebElement firstFlightNoInput;

    @FindBy(css = "#flight-detail-departure-date-1")
    private WebElement firstFlightDepartureDate;

    @FindBy(xpath = "//table//tr[6]//td[3]//button")
    private WebElement firstFlightDepartureDateSelect;

    @FindBy(css = "#flight-detail-departure-time-hh-1")
    private WebElement firstFlightDepartureHourSelect;

    @FindBy(css = "#flight-detail-departure-time-mm-1")
    private WebElement firstFlightDepartureMinSelect;

    @FindBy(css = "#flight-detail-departure-city-1")
    private WebElement firstFlightDepartureCityInput;

    @FindBy(css = "#flight-detail-departure-aiport-1")
    private WebElement firstFlightDepartureAirportNameInput;

    @FindBy(css = "#flight-detail-departure-airport-code-1")
    private WebElement firstFlightDepartureAirportCodeInput;

    @FindBy(css = "#flight-detail-arrival-date-1")
    private WebElement firstFlightArrivalDate;

    @FindBy(xpath = "//table//tr[6]//td[6]//button")
    private WebElement firstFlightArrivalDateSelect;

    @FindBy(css = "#flight-detail-arrival-time-hh-1")
    private WebElement firstFlightArrivalHourSelect;

    @FindBy(css = "#flight-detail-arrival-time-mm-1")
    private WebElement firstFlightArrivalMinSelect;

    @FindBy(css = "#flight-detail-arrival-city-1")
    private WebElement firstFlightArrivalCityInput;

    @FindBy(css = "#flight-detail-arrival-airport-1")
    private WebElement firstFlightArrivalAirportInput;

    @FindBy(css = "#flight-detail-arrival-airport-code-1")
    private WebElement firstFlightArrivalAirportCodeInput;

    @FindBy(css = "#flight-remove-1")
    private WebElement firstFlightRemoveButton;

    @FindBy(xpath = "//span[@id='flight-detail-airline-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqAirline;

    @FindBy(xpath = "//span[@id='flight-detail-number-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqFlightNo;

    @FindBy(xpath = "//span[@id='flight-detail-departure-date-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqDepartureDate;

    @FindBy(xpath = "//span[@id='flight-detail-departure-time-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqDepTime;

    @FindBy(xpath = "//span[@id='flight-detail-departure-city-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqDepartureCity;

    @FindBy(xpath = "//span[@id='flight-detail-departure-airport-code-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqDepartureAirportCode;

    @FindBy(xpath = "//span[@id='flight-detail-arrival-date-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqArrivalDate;

    @FindBy(xpath = "//span[@id='flight-detail-arrival-time-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqArrivalTime;

    @FindBy(xpath = "//span[@id='flight-detail-arrival-city-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqArrivalCity;

    @FindBy(xpath = "//span[@id='flight-detail-arrival-airport-code-warning-1'and@class='error paymentFormWarning paymentFormError']")
    private WebElement errorMsgForReqArrivalAirportCode;

    /*
     * Flight 2
     */

    @FindBy(xpath = "//h2[contains(text(),'Flight 2')]")
    private WebElement flightTwoHeader;

    @FindBy(css = "#flight-detail-airline-2")
    private WebElement secondFlightAirlineNameInput;

    @FindBy(css = "#flight-detail-operator-2")
    private WebElement secondFlightOperatorInput;

    @FindBy(css = "#flight-detail-number-2")
    private WebElement secondFlightNoInput;

    @FindBy(css = "#flight-detail-departure-date-2")
    private WebElement secondFlightDepartureDate;

    @FindBy(xpath = "//table//tr[6]//td[3]//button")
    private WebElement secondFlightDepartureDateSelect;

    @FindBy(css = "#flight-detail-departure-time-hh-2")
    private WebElement secondFlightDepartureHourSelect;

    @FindBy(css = "#flight-detail-departure-time-mm-2")
    private WebElement secondFlightDepartureMinSelect;

    @FindBy(css = "#flight-detail-departure-city-2")
    private WebElement secondFlightDepartureCity;

    @FindBy(css = "#flight-detail-departure-aiport-2")
    private WebElement secondFlightDepartureAirportName;

    @FindBy(css = "#flight-detail-arrival-date-2")
    private WebElement secondFlightArrivalDate;

    @FindBy(xpath = "//table//tr[6]//td[6]//button")
    private WebElement secondFlightArrivalDateSelect;

    @FindBy(css = "#flight-detail-arrival-time-hh-2")
    private WebElement secondFlightArrivalHourSelect;

    @FindBy(css = "#flight-detail-arrival-time-mm-2")
    private WebElement secondFlightArrivalMinSelect;

    @FindBy(css = "#flight-detail-departure-airport-code-2")
    private WebElement secondFlightDepartureAirportCodeInput;

    @FindBy(css = "#flight-detail-arrival-city-2")
    private WebElement secondFlightArrivalCityInput;

    @FindBy(css = "#flight-detail-arrival-airport-2")
    private WebElement secondFlightArrivalAirportInput;

    @FindBy(css = "#flight-detail-arrival-airport-code-2")
    private WebElement secondFlightArrivalAirportCodeInput;

    @FindBy(css = "#flight-remove-2")
    private WebElement secondFlightRemoveButton;

    /*
     * Flight 3
     */

    @FindBy(xpath = "//h2[contains(text(),'Flight 3')]")
    private WebElement flightThreeHeader;

    @FindBy(css = "#flight-detail-airline-3")
    private WebElement thirdFlightAirLineNameInput;

    @FindBy(css = "#flight-detail-operator-3")
    private WebElement thirdFlightOperatorInput;

    @FindBy(css = "#flight-detail-number-3")
    private WebElement thirdFlightNoInput;

    @FindBy(css = "#flight-detail-departure-date-3")
    private WebElement thirdFlightDepCalendarSelect;

    @FindBy(xpath = "//table//tr[6]//td[3]//button")
    private WebElement thirdFlightDepartureDateSelect;

    @FindBy(css = "#flight-detail-departure-time-hh-3")
    private WebElement thirdFlightDepartureHourSelect;

    @FindBy(css = "#flight-detail-departure-time-mm-3")
    private WebElement thirdFlightDepartureMinSelect;

    @FindBy(css = "#flight-detail-departure-city-3")
    private WebElement thirdFlightDepartureCityInput;

    @FindBy(css = "#flight-detail-departure-aiport-3")
    private WebElement thirdFlightDepartureAirportNameInput;

    @FindBy(css = "#flight-detail-departure-airport-code-3")
    private WebElement thirdFlightDepartureAirportCodeInput;

    @FindBy(css = "#flight-detail-arrival-date-3")
    private WebElement thirdFlightArrivalCalendeSelect;

    @FindBy(xpath = "//table//tr[6]//td[6]//button")
    private WebElement thirdFlightArrivalDateSelect;

    @FindBy(css = "#flight-detail-arrival-time-hh-3")
    private WebElement thirdFlightArrivalHourSelect;

    @FindBy(css = "#flight-detail-arrival-time-mm-3")
    private WebElement thirdFlightArrivalMinSelect;

    @FindBy(css = "#flight-detail-arrival-city-3")
    private WebElement thirdFlightArrivalCityInput;

    @FindBy(css = "#flight-detail-arrival-airport-3")
    private WebElement thirdFlightArrivalAirportInput;

    @FindBy(css = "#flight-detail-arrival-airport-code-3")
    private WebElement thirdFlightArrivalAirportCodeInput;

    @FindBy(css = "#flight-remove-3")
    private WebElement thirdFlightRemoveButton;

    @FindBy(css = "#flight-detail-add-new-flight")
    private WebElement addNewFlightButton;

    @FindBy(css = "#flight-detail-save")
    private WebElement saveButton;

    @FindBy(css = "#flight-detail-cancel")
    private WebElement cancelButton;

    /**
     * @return the pageHeader
     */
    public WebElement getPageHeader() {
        return pageHeader;
    }

    /**
     * @return the flightOneHeader
     */

    public WebElement getFlightOneHeader() {
        return flightOneHeader;
    }

    /**
     * @return the airlineReqMsg
     */
    public WebElement getAirlineReqMsg() {
        return airlineReqMsg;
    }

    /**
     * @return the flightNoReqMsg
     */
    public WebElement getFlightNoReqMsg() {
        return flightNoReqMsg;
    }

    /**
     * @return the DepartureDateReqMsg
     */
    public WebElement getDepartureDateReqMsg() {
        return departureDateReqMsg;
    }

    /**
     * @return the depTimeReqMsg
     */
    public WebElement getDepTimeReqMsg() {
        return depTimeReqMsg;
    }

    /**
     * @return the DepartureCityReqMsg
     */

    public WebElement getDepartureCityReqMsg() {
        return departureCityReqMsg;
    }

    /**
     * @return the DepartureAirportCodeReqMsg
     */
    public WebElement getDepartureAirportCodeReqMsg() {
        return departureAirportCodeReqMsg;
    }

    /**
     * @return the arrivalDateReqMsg
     */

    public WebElement getarrivalDateReqMsg() {
        return arrivalDateReqMsg;
    }

    /**
     * @return the arrivalTimeReqMsg
     */
    public WebElement getarrivalTimeReqMsg() {
        return arrivalTimeReqMsg;
    }

    /**
     * @return the arrivalCityReqMsg
     */
    public WebElement getarrivalCityReqMsg() {
        return arrivalCityReqMsg;
    }

    /**
     * @return the arrivalAirportCodeReqMsg
     */
    public WebElement getArrivalAirportCodeReqMsg() {
        return arrivalAirportCodeReqMsg;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightAirlineNameInput() {
        return firstFlightAirlineNameInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightFlightOperatorInput() {
        return firstFlightFlightOperatorInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightNoInput() {
        return firstFlightNoInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightDepartureDate() {
        return firstFlightDepartureDate;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightDepartureDateSelect() {
        return firstFlightDepartureDateSelect;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightDepartureHourSelect() {
        return firstFlightDepartureHourSelect;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightDepartureMinSelect() {
        return firstFlightDepartureMinSelect;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightDepartureCityInput() {
        return firstFlightDepartureCityInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightDepartureAirportNameInput() {
        return firstFlightDepartureAirportNameInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getFirstFlightDepartureAirportCodeInput() {
        return firstFlightDepartureAirportCodeInput;
    }

    /**
     * @return the firstFlightArrivalDate
     */
    public WebElement getFirstFlightArrivalDate() {
        return firstFlightArrivalDate;
    }

    /**
     * @return the firstFlightArrivalDateSelect
     */
    public WebElement getFirstFlightArrivalDateSelect() {
        return firstFlightArrivalDateSelect;
    }

    /**
     * @return the firstFlightArrivalHourSelect
     */
    public WebElement getFirstFlightArrivalHourSelect() {
        return firstFlightArrivalHourSelect;
    }

    /**
     * @return the firstFlightArrivalMinSelect
     */
    public WebElement getFirstFlightArrivalMinSelect() {
        return firstFlightArrivalMinSelect;
    }

    /**
     * @return the firstFlightArrivalCityInput
     */
    public WebElement getFirstFlightArrivalCityInput() {
        return firstFlightArrivalCityInput;
    }

    /**
     * @return the firstFlightArrivalAirportInput
     */
    public WebElement getFirstFlightArrivalAirportInput() {
        return firstFlightArrivalAirportInput;
    }

    /**
     * @return the firstFlightArrivalAirportCodeInput
     */
    public WebElement getFirstFlightArrivalAirportCodeInput() {
        return firstFlightArrivalAirportCodeInput;
    }

    /**
     * @return the firstFlightRemoveButton
     */
    public WebElement getFirstFlightRemoveButton() {
        return firstFlightRemoveButton;
    }

    /**
     * @return the errorMsgForReqAirline
     */
    public WebElement getErrorMsgForReqAirline() {
        return errorMsgForReqAirline;
    }

    /**
     * @return the errorMsgForReqFlightNo
     */
    public WebElement getErrorMsgForReqFlightNo() {
        return errorMsgForReqFlightNo;
    }

    /**
     * @return the errorMsgForReqDepartureDate
     */
    public WebElement getErrorMsgForReqDepartureDate() {
        return errorMsgForReqDepartureDate;
    }

    /**
     * @return the errorMsgForReqDepTime
     */
    public WebElement getErrorMsgForReqDepTime() {
        return errorMsgForReqDepTime;
    }

    /**
     * @return the errorMsgForReqDepartureCity
     */
    public WebElement getErrorMsgForReqDepartureCity() {
        return errorMsgForReqDepartureCity;
    }

    /**
     * @return the errorMsgForReqDepartureAirportCode
     */
    public WebElement getErrorMsgForReqDepartureAirportCode() {
        return errorMsgForReqDepartureAirportCode;
    }

    /**
     * @return the errorMsgForReqArrivalDate
     */
    public WebElement getErrorMsgForReqArrivalDate() {
        return errorMsgForReqArrivalDate;
    }

    /**
     * @return the errorMsgForReqArrivalTime
     */
    public WebElement getErrorMsgForReqArrivalTime() {
        return errorMsgForReqArrivalTime;
    }

    /**
     * @return the errorMsgForReqArrivalCity
     */
    public WebElement getErrorMsgForReqArrivalCity() {
        return errorMsgForReqArrivalCity;
    }

    /**
     * @return the errorMsgForReqArrivalAirportCode
     */
    public WebElement getErrorMsgForReqArrivalAirportCode() {
        return errorMsgForReqArrivalAirportCode;
    }

    /**
     * @return the flightTwoHeader
     */
    public WebElement getFlightTwoHeader() {
        return flightTwoHeader;
    }

    /**
     * @return the secondFlightAirlineNameInput
     */
    public WebElement getSecondFlightAirlineNameInput() {
        return secondFlightAirlineNameInput;
    }

    /**
     * @return the secondFlightOperatorInput
     */
    public WebElement getSecondFlightOperatorInput() {
        return secondFlightOperatorInput;
    }

    /**
     * @return the secondFlightNoInput
     */
    public WebElement getSecondFlightNoInput() {
        return secondFlightNoInput;
    }

    /**
     * @return the secondFlightDepartureDate
     */
    public WebElement getSecondFlightDepartureDate() {
        return secondFlightDepartureDate;
    }

    /**
     * @return the secondFlightDepartureDateSelect
     */
    public WebElement getSecondFlightDepartureDateSelect() {
        return secondFlightDepartureDateSelect;
    }

    /**
     * @return the secondFlightDepartureHourSelect
     */
    public WebElement getSecondFlightDepartureHourSelect() {
        return secondFlightDepartureHourSelect;
    }

    /**
     * @return the secondFlightDepartureMinSelect
     */
    public WebElement getSecondFlightDepartureMinSelect() {
        return secondFlightDepartureMinSelect;
    }

    /**
     * @return the secondFlightDepartureCity
     */
    public WebElement getSecondFlightDepartureCity() {
        return secondFlightDepartureCity;
    }

    /**
     * @return the secondFlightDepartureAirportName
     */
    public WebElement getSecondFlightDepartureAirportName() {
        return secondFlightDepartureAirportName;
    }

    /**
     * @return the secondFlightArrivalDate
     */
    public WebElement getSecondFlightArrivalDate() {
        return secondFlightArrivalDate;
    }

    /**
     * @return the secondFlightArrivalDateSelect
     */
    public WebElement getSecondFlightArrivalDateSelect() {
        return secondFlightArrivalDateSelect;
    }

    /**
     * @return the secondFlightArrivalHourSelect
     */
    public WebElement getSecondFlightArrivalHourSelect() {
        return secondFlightArrivalHourSelect;
    }

    /**
     * @return the secondFlightArrivalMinSelect
     */
    public WebElement getSecondFlightArrivalMinSelect() {
        return secondFlightArrivalMinSelect;
    }

    /**
     * @return the secondFlightDepartureAirportCodeInput
     */
    public WebElement getSecondFlightDepartureAirportCodeInput() {
        return secondFlightDepartureAirportCodeInput;
    }

    /**
     * @return the secondFlightArrivalCityInput
     */
    public WebElement getSecondFlightArrivalCityInput() {
        return secondFlightArrivalCityInput;
    }

    /**
     * @return the secondFlightArrivalAirportInput
     */
    public WebElement getSecondFlightArrivalAirportInput() {
        return secondFlightArrivalAirportInput;
    }

    /**
     * @return the secondFlightArrivalAirportCodeInput
     */
    public WebElement getSecondFlightArrivalAirportCodeInput() {
        return secondFlightArrivalAirportCodeInput;
    }

    /**
     * @return the secondFlightRemoveButton
     */
    public WebElement getSecondFlightRemoveButton() {
        return secondFlightRemoveButton;
    }

    /**
     * @return the flightThreeHeader
     */
    public WebElement getFlightThreeHeader() {
        return flightThreeHeader;
    }

    /**
     * @return the thirdFlightAirLineNameInput
     */
    public WebElement getThirdFlightAirLineNameInput() {
        return thirdFlightAirLineNameInput;
    }

    /**
     * @return the thirdFlightOperatorInput
     */
    public WebElement getThirdFlightOperatorInput() {
        return thirdFlightOperatorInput;
    }

    /**
     * @return the thirdFlightNoInput
     */
    public WebElement getThirdFlightNoInput() {
        return thirdFlightNoInput;
    }

    /**
     * @return the thirdFlightDepCalendarSelect
     */
    public WebElement getThirdFlightDepCalendarSelect() {
        return thirdFlightDepCalendarSelect;
    }

    /**
     * @return the thirdFlightDepartureDateSelect
     */
    public WebElement getThirdFlightDepartureDateSelect() {
        return thirdFlightDepartureDateSelect;
    }

    /**
     * @return the thirdFlightDepartureHourSelect
     */
    public WebElement getThirdFlightDepartureHourSelect() {
        return thirdFlightDepartureHourSelect;
    }

    /**
     * @return the thirdFlightDepartureMinSelect
     */
    public WebElement getThirdFlightDepartureMinSelect() {
        return thirdFlightDepartureMinSelect;
    }

    /**
     * @return the thirdFlightDepartureCityInput
     */
    public WebElement getThirdFlightDepartureCityInput() {
        return thirdFlightDepartureCityInput;
    }

    /**
     * @return the thirdFlightDepartureAirportNameInput
     */
    public WebElement getThirdFlightDepartureAirportNameInput() {
        return thirdFlightDepartureAirportNameInput;
    }

    /**
     * @return the thirdFlightDepartureAirportCodeInput
     */
    public WebElement getThirdFlightDepartureAirportCodeInput() {
        return thirdFlightDepartureAirportCodeInput;
    }

    /**
     * @return the thirdFlightArrivalCalendeSelect
     */
    public WebElement getThirdFlightArrivalCalendeSelect() {
        return thirdFlightArrivalCalendeSelect;
    }

    /**
     * @return the thirdFlightArrivalDateSelect
     */
    public WebElement getThirdFlightArrivalDateSelect() {
        return thirdFlightArrivalDateSelect;
    }

    /**
     * @return the thirdFlightArrivalHourSelect
     */
    public WebElement getThirdFlightArrivalHourSelect() {
        return thirdFlightArrivalHourSelect;
    }

    /**
     * @return the pageHeader
     */

    public WebElement getThirdFlightArrivalMinSelect() {
        return thirdFlightArrivalMinSelect;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getThirdFlightArrivalCityInput() {
        return thirdFlightArrivalCityInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getThirdFlightArrivalAirportInput() {
        return thirdFlightArrivalAirportInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getThirdFlightArrivalAirportCodeInput() {
        return thirdFlightArrivalAirportCodeInput;
    }

    /**
     * @return the pageHeader
     */
    public WebElement getThirdFlightRemoveButton() {
        return thirdFlightRemoveButton;
    }

    /**
     * @return the addNewFlightButton
     */
    public WebElement getAddNewFlightButton() {
        return addNewFlightButton;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FlightPageElements [pageHeader=" + pageHeader + ", flightOneHeader=" + flightOneHeader + ", airlineReqMsg=" + airlineReqMsg
                + ", flightNoReqMsg=" + flightNoReqMsg + ", departureDateReqMsg=" + departureDateReqMsg + ", depTimeReqMsg=" + depTimeReqMsg
                + ", departureCityReqMsg=" + departureCityReqMsg + ", departureAirportCodeReqMsg=" + departureAirportCodeReqMsg
                + ", arrivalDateReqMsg=" + arrivalDateReqMsg + ", arrivalTimeReqMsg=" + arrivalTimeReqMsg + ", arrivalCityReqMsg=" + arrivalCityReqMsg
                + ", arrivalAirportCodeReqMsg=" + arrivalAirportCodeReqMsg + ", firstFlightAirlineNameInput=" + firstFlightAirlineNameInput
                + ", firstFlightFlightOperatorInput=" + firstFlightFlightOperatorInput + ", firstFlightNoInput=" + firstFlightNoInput
                + ", firstFlightDepartureDate=" + firstFlightDepartureDate + ", firstFlightDepartureDateSelect=" + firstFlightDepartureDateSelect
                + ", firstFlightDepartureHourSelect=" + firstFlightDepartureHourSelect + ", firstFlightDepartureMinSelect="
                + firstFlightDepartureMinSelect + ", firstFlightDepartureCityInput=" + firstFlightDepartureCityInput
                + ", firstFlightDepartureAirportNameInput=" + firstFlightDepartureAirportNameInput + ", firstFlightDepartureAirportCodeInput="
                + firstFlightDepartureAirportCodeInput + ", firstFlightArrivalDate=" + firstFlightArrivalDate + ", firstFlightArrivalDateSelect="
                + firstFlightArrivalDateSelect + ", firstFlightArrivalHourSelect=" + firstFlightArrivalHourSelect + ", firstFlightArrivalMinSelect="
                + firstFlightArrivalMinSelect + ", firstFlightArrivalCityInput=" + firstFlightArrivalCityInput + ", firstFlightArrivalAirportInput="
                + firstFlightArrivalAirportInput + ", firstFlightArrivalAirportCodeInput=" + firstFlightArrivalAirportCodeInput
                + ", firstFlightRemoveButton=" + firstFlightRemoveButton + ", errorMsgForReqAirline=" + errorMsgForReqAirline
                + ", errorMsgForReqFlightNo=" + errorMsgForReqFlightNo + ", errorMsgForReqDepartureDate=" + errorMsgForReqDepartureDate
                + ", errorMsgForReqDepTime=" + errorMsgForReqDepTime + ", errorMsgForReqDepartureCity=" + errorMsgForReqDepartureCity
                + ", errorMsgForReqDepartureAirportCode=" + errorMsgForReqDepartureAirportCode + ", errorMsgForReqArrivalDate="
                + errorMsgForReqArrivalDate + ", errorMsgForReqArrivalTime=" + errorMsgForReqArrivalTime + ", errorMsgForReqArrivalCity="
                + errorMsgForReqArrivalCity + ", errorMsgForReqArrivalAirportCode=" + errorMsgForReqArrivalAirportCode + ", flightTwoHeader="
                + flightTwoHeader + ", secondFlightAirlineNameInput=" + secondFlightAirlineNameInput + ", secondFlightOperatorInput="
                + secondFlightOperatorInput + ", secondFlightNoInput=" + secondFlightNoInput + ", secondFlightDepartureDate="
                + secondFlightDepartureDate + ", secondFlightDepartureDateSelect=" + secondFlightDepartureDateSelect
                + ", secondFlightDepartureHourSelect=" + secondFlightDepartureHourSelect + ", secondFlightDepartureMinSelect="
                + secondFlightDepartureMinSelect + ", secondFlightDepartureCity=" + secondFlightDepartureCity + ", secondFlightDepartureAirportName="
                + secondFlightDepartureAirportName + ", secondFlightArrivalDate=" + secondFlightArrivalDate + ", secondFlightArrivalDateSelect="
                + secondFlightArrivalDateSelect + ", secondFlightArrivalHourSelect=" + secondFlightArrivalHourSelect
                + ", secondFlightArrivalMinSelect=" + secondFlightArrivalMinSelect + ", secondFlightDepartureAirportCodeInput="
                + secondFlightDepartureAirportCodeInput + ", secondFlightArrivalCityInput=" + secondFlightArrivalCityInput
                + ", secondFlightArrivalAirportInput=" + secondFlightArrivalAirportInput + ", secondFlightArrivalAirportCodeInput="
                + secondFlightArrivalAirportCodeInput + ", secondFlightRemoveButton=" + secondFlightRemoveButton + ", flightThreeHeader="
                + flightThreeHeader + ", thirdFlightAirLineNameInput=" + thirdFlightAirLineNameInput + ", thirdFlightOperatorInput="
                + thirdFlightOperatorInput + ", thirdFlightNoInput=" + thirdFlightNoInput + ", thirdFlightDepCalendarSelect="
                + thirdFlightDepCalendarSelect + ", thirdFlightDepartureDateSelect=" + thirdFlightDepartureDateSelect
                + ", thirdFlightDepartureHourSelect=" + thirdFlightDepartureHourSelect + ", thirdFlightDepartureMinSelect="
                + thirdFlightDepartureMinSelect + ", thirdFlightDepartureCityInput=" + thirdFlightDepartureCityInput
                + ", thirdFlightDepartureAirportNameInput=" + thirdFlightDepartureAirportNameInput + ", thirdFlightDepartureAirportCodeInput="
                + thirdFlightDepartureAirportCodeInput + ", thirdFlightArrivalCalendeSelect=" + thirdFlightArrivalCalendeSelect
                + ", thirdFlightArrivalDateSelect=" + thirdFlightArrivalDateSelect + ", thirdFlightArrivalHourSelect=" + thirdFlightArrivalHourSelect
                + ", thirdFlightArrivalMinSelect=" + thirdFlightArrivalMinSelect + ", thirdFlightArrivalCityInput=" + thirdFlightArrivalCityInput
                + ", thirdFlightArrivalAirportInput=" + thirdFlightArrivalAirportInput + ", thirdFlightArrivalAirportCodeInput="
                + thirdFlightArrivalAirportCodeInput + ", thirdFlightRemoveButton=" + thirdFlightRemoveButton + ", addNewFlightButton="
                + addNewFlightButton + ", saveButton=" + saveButton + ", cancelButton=" + cancelButton + "]";
    }

}
