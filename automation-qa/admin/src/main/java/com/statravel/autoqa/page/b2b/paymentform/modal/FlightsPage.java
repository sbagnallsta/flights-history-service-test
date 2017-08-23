package com.statravel.autoqa.page.b2b.paymentform.modal;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Flight;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class FlightsPage extends Page<FlightPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FlightPageElements flightPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(flightPageElements.getFlightOneHeader());

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        flightPageElements = new FlightPageElements();

        super.initialiseElements(flightPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public FlightPageElements getPageElements() {

        return flightPageElements;
    }

    /**
     * 
     * @param flight
     *            Flight reference
     */
    public void fillDetailsForFirstFlight(final Flight flight) {
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightAirlineNameInput(), flight.getAirline());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightFlightOperatorInput(), flight.getOperator());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightNoInput(), flight.getNumber());
        webDriverCommons.click(flightPageElements.getFirstFlightDepartureDate());
        webDriverCommons.click(flightPageElements.getFirstFlightDepartureDateSelect());
        webDriverCommons.selectFromDropdown(flightPageElements.getFirstFlightDepartureHourSelect(), flight.getDepartureHour());
        webDriverCommons.selectFromDropdown(flightPageElements.getFirstFlightDepartureMinSelect(), flight.getDepartureMinute());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightDepartureCityInput(), flight.getDepartureCity());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightDepartureAirportNameInput(), flight.getDepartureAirport());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightDepartureAirportCodeInput(), flight.getDepartureAirportCode());
        webDriverCommons.click(flightPageElements.getFirstFlightArrivalDate());
        webDriverCommons.click(flightPageElements.getFirstFlightArrivalDateSelect());
        webDriverCommons.selectFromDropdown(flightPageElements.getFirstFlightArrivalHourSelect(), flight.getArrivalHour());
        webDriverCommons.selectFromDropdown(flightPageElements.getFirstFlightArrivalMinSelect(), flight.getArrivalMinute());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightArrivalCityInput(), flight.getArrivalCity());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightArrivalAirportInput(), flight.getArrivalAirport());
        webDriverCommons.sendKeys(flightPageElements.getFirstFlightArrivalAirportCodeInput(), flight.getArrivalAirportCode());

    }

    /**
     * 
     * @param flight
     *            Flight reference
     */
    public void fillDetailsForSecondFlight(final Flight flight) {
        webDriverCommons.sendKeys(flightPageElements.getSecondFlightAirlineNameInput(), flight.getAirline());
        webDriverCommons.sendKeys(flightPageElements.getSecondFlightOperatorInput(), flight.getOperator());
        webDriverCommons.sendKeys(flightPageElements.getSecondFlightNoInput(), flight.getNumber());
        webDriverCommons.selectFromDropdown(flightPageElements.getSecondFlightDepartureHourSelect(), flight.getDepartureHour());
        webDriverCommons.selectFromDropdown(flightPageElements.getSecondFlightDepartureMinSelect(), flight.getDepartureMinute());
        webDriverCommons.click(flightPageElements.getSecondFlightArrivalDate());
        webDriverCommons.click(flightPageElements.getSecondFlightArrivalDateSelect());
        webDriverCommons.selectFromDropdown(flightPageElements.getSecondFlightArrivalHourSelect(), flight.getArrivalHour());
        webDriverCommons.selectFromDropdown(flightPageElements.getSecondFlightArrivalMinSelect(), flight.getArrivalMinute());
        webDriverCommons.sendKeys(flightPageElements.getSecondFlightArrivalCityInput(), flight.getArrivalCity());
        webDriverCommons.sendKeys(flightPageElements.getSecondFlightArrivalAirportInput(), flight.getArrivalAirport());
        webDriverCommons.sendKeys(flightPageElements.getSecondFlightArrivalAirportCodeInput(), flight.getArrivalAirportCode());

    }

    /**
     * 
     * @param flight
     *            Flight reference
     */
    public void fillDetailsForThirdFlight(final Flight flight) {
        webDriverCommons.sendKeys(flightPageElements.getThirdFlightAirLineNameInput(), flight.getAirline());
        webDriverCommons.sendKeys(flightPageElements.getThirdFlightOperatorInput(), flight.getOperator());
        webDriverCommons.sendKeys(flightPageElements.getThirdFlightNoInput(), flight.getNumber());
        webDriverCommons.selectFromDropdown(flightPageElements.getThirdFlightDepartureHourSelect(), flight.getDepartureHour());
        webDriverCommons.selectFromDropdown(flightPageElements.getThirdFlightDepartureMinSelect(), flight.getDepartureMinute());
        webDriverCommons.click(flightPageElements.getThirdFlightArrivalCalendeSelect());
        webDriverCommons.click(flightPageElements.getThirdFlightArrivalCalendeSelect());
        webDriverCommons.click(flightPageElements.getThirdFlightArrivalDateSelect());
        webDriverCommons.selectFromDropdown(flightPageElements.getThirdFlightArrivalHourSelect(), flight.getArrivalHour());
        webDriverCommons.selectFromDropdown(flightPageElements.getThirdFlightArrivalMinSelect(), flight.getArrivalMinute());
        webDriverCommons.sendKeys(flightPageElements.getThirdFlightArrivalCityInput(), flight.getArrivalCity());
        webDriverCommons.sendKeys(flightPageElements.getThirdFlightArrivalAirportInput(), flight.getArrivalAirport());
        webDriverCommons.sendKeys(flightPageElements.getThirdFlightArrivalAirportCodeInput(), flight.getArrivalAirportCode());

    }

    /**
     * Adds a new flight.
     */
    public void addNewFlight() {
        webDriverCommons.click(flightPageElements.getAddNewFlightButton());

    }

    /**
     * Deletes the first Getting There flight.
     */
    public void deleteFlightOne() {

        webDriverCommons.click(flightPageElements.getFirstFlightRemoveButton());

        Alert deleteAlert = webDriverCommons.getAlertPopUp();

        deleteAlert.accept();

        webDriverCommons.click(flightPageElements.getSaveButton());

    }

    /**
     * Saves the flight details.
     */
    public void save() {
        webDriverCommons.click(flightPageElements.getSaveButton());

    }

}
