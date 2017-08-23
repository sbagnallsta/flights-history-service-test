package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class FlightGettingTherePageElements extends PageElements {

    @FindBy(css = "#getting-there-heading")
    private WebElement heading;

    @FindBy(css = "#getting-there-flight-number-1")
    private WebElement firstFlightNo;

    @FindBy(css = "#getting-there-flight-number-2")
    private WebElement secondFlightNo;

    @FindBy(css = "#getting-there-departure-date-1")
    private WebElement firstDepartureDate;

    @FindBy(css = "#getting-there-departure-date-2")
    private WebElement secondDepartureDate;

    @FindBy(css = "#getting-there-departure-time-1")
    private WebElement firstDepartureTime;

    @FindBy(css = "#getting-there-departure-time-2")
    private WebElement secondDepartureTime;

    @FindBy(css = "#getting-there-departure-city-1")
    private WebElement firstDepartureCity;

    @FindBy(css = "#getting-there-departure-city-2")
    private WebElement secondDepartureCity;

    @FindBy(css = "#getting-there-departure-airport-1")
    private WebElement firstDepartureAirport;

    @FindBy(css = "#getting-there-departure-airport-2")
    private WebElement secondDepartureAirport;

    @FindBy(css = "#getting-there-departure-airport-code-1")
    private WebElement firstDepartureAirportCode;

    @FindBy(css = "#getting-there-departure-airport-code-2")
    private WebElement secondDepartureAirportCode;

    @FindBy(css = "#getting-there-arrival-date-1")
    private WebElement firstArrivalDate;

    @FindBy(css = "#getting-there-arrival-date-2")
    private WebElement secondArrivalDate;

    @FindBy(css = "#getting-there-arrival-city-1")
    private WebElement firstArrivalCity;

    @FindBy(css = "#getting-there-arrival-city-2")
    private WebElement secondArrivalCity;

    @FindBy(css = "#getting-there-arrival-time-1")
    private WebElement firstArrivalTime;

    @FindBy(css = "#getting-there-arrival-time-2")
    private WebElement secondArrivalTime;

    @FindBy(css = "#getting-there-arrival-airport-1")
    private WebElement firstArrivalAirport;

    @FindBy(css = "#getting-there-arrival-airport-2")
    private WebElement secondArrivalAirport;

    @FindBy(css = "#getting-there-arrival-airport-code-1")
    private WebElement firstArrivalAirportCode;

    @FindBy(css = "#getting-there-arrival-airport-code-2")
    private WebElement secondArrivalAirportCode;

    @FindBy(css = "#getting-there-day-indicator-1")
    private WebElement firstFlightDayIndicator;

    @FindBy(css = "#getting-there-day-indicator-2")
    private WebElement secondFlightDayIndicator;

    @FindBy(css = "#getting-there-flight-airline-operator-1")
    private WebElement firstAirline;

    @FindBy(css = "#getting-there-flight-airline-operator-2")
    private WebElement secondAirline;

    @FindBy(css = "#getting-there-operator-1")
    private WebElement firstAirlineOperator;

    @FindBy(css = "#getting-there-operator-2")
    private WebElement secondAirlineOperator;

    @FindBy(css = "#flight-heading-side-bar")
    private WebElement flightHeadingForSideBar;

    @FindBy(css = "#flight-amount-side-bar")
    private WebElement flightAmountForSideBar;

    /**
     * @return the heading
     */
    public WebElement getHeading() {
        return heading;
    }

    /**
     * @return the firstFlightNo
     */
    public WebElement getFirstFlightNo() {
        return firstFlightNo;
    }

    /**
     * @return the secondFlightNo
     */
    public WebElement getSecondFlightNo() {
        return secondFlightNo;
    }

    /**
     * @return the firstDepartureDate
     */
    public WebElement getFirstDepartureDate() {
        return firstDepartureDate;
    }

    /**
     * @return the secondDepartureDate
     */
    public WebElement getSecondDepartureDate() {
        return secondDepartureDate;
    }

    /**
     * @return the firstDepartureTime
     */
    public WebElement getFirstDepartureTime() {
        return firstDepartureTime;
    }

    /**
     * @return the secondDepartureTime
     */
    public WebElement getSecondDepartureTime() {
        return secondDepartureTime;
    }

    /**
     * @return the firstDepartureCity
     */
    public WebElement getFirstDepartureCity() {
        return firstDepartureCity;
    }

    /**
     * @return the secondDepartureCity
     */
    public WebElement getSecondDepartureCity() {
        return secondDepartureCity;
    }

    /**
     * @return the firstDepartureAirport
     */
    public WebElement getFirstDepartureAirport() {
        return firstDepartureAirport;
    }

    /**
     * @return the secondDepartureAirport
     */
    public WebElement getSecondDepartureAirport() {
        return secondDepartureAirport;
    }

    /**
     * @return the firstDepartureAirportCode
     */
    public WebElement getFirstDepartureAirportCode() {
        return firstDepartureAirportCode;
    }

    /**
     * @return the secondDepartureAirportCode
     */
    public WebElement getSecondDepartureAirportCode() {
        return secondDepartureAirportCode;
    }

    /**
     * @return the firstArrivalDate
     */
    public WebElement getFirstArrivalDate() {
        return firstArrivalDate;
    }

    /**
     * @return the secondArrivalDate
     */
    public WebElement getSecondArrivalDate() {
        return secondArrivalDate;
    }

    /**
     * @return the firstArrivalTime
     */
    public WebElement getFirstArrivalTime() {
        return firstArrivalTime;
    }

    /**
     * @return the secondArrivalTime
     */
    public WebElement getSecondArrivalTime() {
        return secondArrivalTime;
    }

    /**
     * @return the firstArrivalAirport
     */
    public WebElement getFirstArrivalAirport() {
        return firstArrivalAirport;
    }

    /**
     * @return the secondArrivalAirport
     */
    public WebElement getSecondArrivalAirport() {
        return secondArrivalAirport;
    }

    /**
     * @return the firstArrivalAirportCode
     */
    public WebElement getFirstArrivalAirportCode() {
        return firstArrivalAirportCode;
    }

    /**
     * @return the secondArrivalAirportCode
     */
    public WebElement getSecondArrivalAirportCode() {
        return secondArrivalAirportCode;
    }

    /**
     * @return the firstArrivalCity
     */
    public WebElement getFirstArrivalCity() {
        return firstArrivalCity;
    }

    /**
     * @return the secondArrivalCity
     */
    public WebElement getSecondArrivalCity() {
        return secondArrivalCity;
    }

    /**
     * @return the firstFlightDayIndicator
     */
    public WebElement getFirstFlightDayIndicator() {
        return firstFlightDayIndicator;
    }

    /**
     * @return the secondFlightDayIndicator
     */
    public WebElement getSecondFlightDayIndicator() {
        return secondFlightDayIndicator;
    }

    /**
     * @return the firstAirline
     */
    public WebElement getFirstAirline() {
        return firstAirline;
    }

    /**
     * @return the secondAirline
     */
    public WebElement getSecondAirline() {
        return secondAirline;
    }

    /**
     * @return the firstAirlineOperator
     */
    public WebElement getFirstAirlineOperator() {
        return firstAirlineOperator;
    }

    /**
     * @return the secondAirlineOperator
     */
    public WebElement getSecondAirlineOperator() {
        return secondAirlineOperator;
    }

    /**
     * @return the flightHeadingForSideBar
     */
    public WebElement getFlightHeadingForSideBar() {
        return flightHeadingForSideBar;
    }

    /**
     * @return the flightAmountForSideBar
     */
    public WebElement getFlightAmountForSideBar() {
        return flightAmountForSideBar;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FlightGettingTherePageElements [heading=" + heading + ", firstFlightNo=" + firstFlightNo + ", secondFlightNo=" + secondFlightNo
                + ", firstDepartureDate=" + firstDepartureDate + ", secondDepartureDate=" + secondDepartureDate + ", firstDepartureTime="
                + firstDepartureTime + ", secondDepartureTime=" + secondDepartureTime + ", firstDepartureCity=" + firstDepartureCity
                + ", secondDepartureCity=" + secondDepartureCity + ", firstDepartureAirport=" + firstDepartureAirport + ", secondDepartureAirport="
                + secondDepartureAirport + ", firstDepartureAirportCode=" + firstDepartureAirportCode + ", secondDepartureAirportCode="
                + secondDepartureAirportCode + ", firstArrivalDate=" + firstArrivalDate + ", secondArrivalDate=" + secondArrivalDate
                + ", firstArrivalCity=" + firstArrivalCity + ", secondArrivalCity=" + secondArrivalCity + ", firstArrivalTime=" + firstArrivalTime
                + ", secondArrivalTime=" + secondArrivalTime + ", firstArrivalAirport=" + firstArrivalAirport + ", secondArrivalAirport="
                + secondArrivalAirport + ", firstArrivalAirportCode=" + firstArrivalAirportCode + ", secondArrivalAirportCode="
                + secondArrivalAirportCode + ", firstFlightDayIndicator=" + firstFlightDayIndicator + ", secondFlightDayIndicator="
                + secondFlightDayIndicator + ", firstAirline=" + firstAirline + ", secondAirline=" + secondAirline + ", firstAirlineOperator="
                + firstAirlineOperator + ", secondAirlineOperator=" + secondAirlineOperator + ", flightHeadingForSideBar=" + flightHeadingForSideBar
                + ", flightAmountForSideBar=" + flightAmountForSideBar + "]";
    }

}
