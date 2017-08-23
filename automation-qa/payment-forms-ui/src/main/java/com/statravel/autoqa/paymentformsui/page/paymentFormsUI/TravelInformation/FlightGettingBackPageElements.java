package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class FlightGettingBackPageElements extends PageElements {
    @FindBy(css = "#coming-back-heading")
    private WebElement heading;

    @FindBy(css = "#coming-back-flight-number-1")
    private WebElement firstFlightNo;

    @FindBy(css = "#coming-back-flight-number-2")
    private WebElement secondFlightNo;

    @FindBy(css = "#coming-back-departure-date-1")
    private WebElement firstDepartureDate;

    @FindBy(css = "#coming-back-departure-date-2")
    private WebElement secondDepartureDate;

    @FindBy(css = "#coming-back-departure-time-1")
    private WebElement firstDepartureTime;

    @FindBy(css = "#coming-back-departure-time-2")
    private WebElement secondDepartureTime;

    @FindBy(css = "#coming-back-departure-city-1")
    private WebElement firstDepartureCity;

    @FindBy(css = "#coming-back-departure-city-2")
    private WebElement secondDepartureCity;

    @FindBy(css = "#coming-back-departure-airport-1")
    private WebElement firstDepartureAirport;

    @FindBy(css = "#coming-back-departure-airport-2")
    private WebElement secondDepartureAirport;

    @FindBy(css = "#coming-back-departure-airport-code-1")
    private WebElement firstDepartureAirportCode;

    @FindBy(css = "#coming-back-departure-airport-code-2")
    private WebElement secondDepartureAirportCode;

    @FindBy(css = "#coming-back-arrival-date-1")
    private WebElement firstArrivalDate;

    @FindBy(css = "#coming-back-arrival-date-2")
    private WebElement secondArrivalDate;

    @FindBy(css = "#coming-back-arrival-city-1")
    private WebElement firstArrivalCity;

    @FindBy(css = "#coming-back-arrival-city-2")
    private WebElement secondArrivalCity;

    @FindBy(css = "#coming-back-arrival-time-1")
    private WebElement firstArrivalTime;

    @FindBy(css = "#coming-back-arrival-time-2")
    private WebElement secondArrivalTime;

    @FindBy(css = "#coming-back-arrival-airport-1")
    private WebElement firstArrivalAirport;

    @FindBy(css = "#coming-back-arrival-airport-2")
    private WebElement secondArrivalAirport;

    @FindBy(css = "#coming-back-arrival-airport-code-1")
    private WebElement firstArrivalAirportCode;

    @FindBy(css = "#coming-back-arrival-airport-code-2")
    private WebElement secondArrivalAirportCode;

    @FindBy(css = "#coming-back-day-indicator-1")
    private WebElement firstFlightDayIndicator;

    @FindBy(css = "#coming-back-day-indicator-2")
    private WebElement secondFlightDayIndicator;

    @FindBy(css = "#coming-back-operator-flight-airline-1")
    private WebElement firstAirline;

    @FindBy(css = "#coming-back-operator-flight-airline-2")
    private WebElement secondAirline;

    @FindBy(css = "#coming-back-operator-1")
    private WebElement firstAirlineOperator;

    @FindBy(css = "#coming-back-operator-2")
    private WebElement secondAirlineOperator;

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FlightGettingBackPageElements [heading=" + heading + ", firstFlightNo=" + firstFlightNo + ", secondFlightNo=" + secondFlightNo
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
                + firstAirlineOperator + ", secondAirlineOperator=" + secondAirlineOperator + "]";
    }

}
