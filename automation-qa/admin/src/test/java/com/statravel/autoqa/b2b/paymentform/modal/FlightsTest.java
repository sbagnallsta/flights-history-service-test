
package com.statravel.autoqa.b2b.paymentform.modal;

import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_NAME;
import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_PASSWORD;

import java.text.MessageFormat;
import java.util.Date;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Flight;
import com.statravel.autoqa.domain.enumeration.POS;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormListPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;
import com.statravel.autoqa.page.b2b.paymentform.modal.FlightsPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Internal Team
 *
 */
@CucumberStepsDefinition
public class FlightsTest {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Autowired
    private PaymentFormListPage paymentFormListPage;

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private FlightsPage flightsPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private Flight flight1, flight2, flight3;

    /**
     * 
     */
    @Before
    public void init() {

        loginPage.init();
        homePage.init();
        flightsPage.init();
        paymentFormListPage.init();
        paymentFormPage.init();

    }

    /**
     *
     */
    @Given("^I am on Flights Getting There page$")
    public void loadFlightsGettingThereLightbox() {

        loadPaymentFormDetailsPage();

        Assert.assertTrue(webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                      .getGettingThereActiveBarDisableMode()));

        paymentFormPage.editGettingThereFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

    }

    /**
     *
     * 
     */
    @Given("^I am on Flights Getting Around page$")
    public void loadFlightsGettingAroundLightbox() {

        loadPaymentFormDetailsPage();

        Assert.assertTrue(webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                      .getGettingAroundActiveBarDisableMode()));

        paymentFormPage.editGettingAroundFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

    }

    /**
     *
     * 
     */
    @Given("^I am on Flights Getting Back page$")
    public void loadFlightsGettingBackLightbox() {

        loadPaymentFormDetailsPage(); 

        Assert.assertTrue(webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                      .getGettingBackActiveBarDisableMode()));

        paymentFormPage.editGettingBackFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I save without entering any flights data$")
    public void saveDetailsWithoutEnteringData() {
        flightsPage.save();
    }

    /**
     * 
     */
    @Then("^I should see messages for all require fields$")
    public void shouldDisplayErrorMessagesOnFlightPage() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_AIRLINE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getAirlineReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_FLIGHT_NUMBER, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getFlightNoReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_DEPARTURE_DATE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getDepartureDateReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_DEPARTURE_TIME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getDepTimeReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_DEPARTURE_CITY, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getDepartureCityReqMsg()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_DEPARTURE_AIRCODE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getDepartureAirportCodeReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_ARRIVAL_DATE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getarrivalDateReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_ARRIVAL_TIME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getarrivalTimeReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_ARRIVAL_CITY, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getarrivalCityReqMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_MODAL_ARRIVAL_CITY, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                        .getArrivalAirportCodeReqMsg()));

    }

    /**
     *
     */
    @Given("^I am on Payment Form Details page$")
    public void loadPaymentFormDetailsPage() {

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_LOGIN, loginPage.isPageLoaded());

        loginPage.login(ADMIN_NAME, ADMIN_PASSWORD);

        homePage.selectPOS(POS.US);
        homePage.clickPaymentFormsMenuItem();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormListPage.isPageLoaded());

        paymentFormListPage.addNewForm();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I activate Flight section$")
    public void activateFlightSection() {

        paymentFormPage.toggleFlightSection();

    }

    /**
     * 
     */
    @Then("^I should see a required message$")
    public void verifyFlightSectionRequiredMessageIsDisplayed() {

        Assert.assertTrue(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION,
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFlightsAreReqMsg()));

    }

    /**
     * 
     */
    @When("^I add two Getting there flights$")
    public void addFlightForGettingThere() {
        Assert.assertTrue(webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                      .getGettingThereActiveBarDisableMode()));

        paymentFormPage.editGettingThereFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flight1 = new Flight.FlightBuilder().setAirline("Test Airline01")
                                            .setOperator("Test Airline")
                                            .setNumber("001")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("London")
                                            .setDepartureAirport("London Heathrow")
                                            .setDepartureAirportCode("LHR")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Ahmedabad")
                                            .setArrivalAirport("Ahmedabad Airport")
                                            .setArrivalAirportCode("AMD")
                                            .build();

        flightsPage.fillDetailsForFirstFlight(flight1);

        flightsPage.addNewFlight();

        flight2 = new Flight.FlightBuilder().setAirline("Test Airline01")
                                            .setOperator("Test Airline")
                                            .setNumber("002")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("Ahmedabad")
                                            .setDepartureAirport("Ahmedabad Airport")
                                            .setDepartureAirportCode("AMD")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Rajkot")
                                            .setArrivalAirport("Rajkot Airport")
                                            .setArrivalAirportCode("RAJ")
                                            .build();

        flightsPage.fillDetailsForSecondFlight(flight2);

        flightsPage.save();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I add two Getting Around flights$")
    public void addFlightForGettingAround() {

        Assert.assertTrue(webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                      .getGettingAroundActiveBarDisableMode()));

        paymentFormPage.editGettingAroundFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flight1 = new Flight.FlightBuilder().setAirline("Test Airline01")
                                            .setOperator("Test Airline")
                                            .setNumber("001")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("London")
                                            .setDepartureAirport("London Heathrow")
                                            .setDepartureAirportCode("LHR")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Ahmedabad")
                                            .setArrivalAirport("Ahmedabad Airport")
                                            .setArrivalAirportCode("AMD")
                                            .build();

        flightsPage.fillDetailsForFirstFlight(flight1);

        flightsPage.addNewFlight();

        flight2 = new Flight.FlightBuilder().setAirline("Test Airline01")
                                            .setOperator("Test Airline")
                                            .setNumber("002")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("Ahmedabad")
                                            .setDepartureAirport("Ahmedabad Airport")
                                            .setDepartureAirportCode("AMD")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Rajkot")
                                            .setArrivalAirport("Rajkot Airport")
                                            .setArrivalAirportCode("RAJ")
                                            .build();

        flightsPage.fillDetailsForSecondFlight(flight2);

        flightsPage.save();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I add two Getting Back flights$")
    public void addFlightForGettingBack() {

        Assert.assertTrue(webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                      .getGettingBackActiveBarDisableMode()));

        paymentFormPage.editGettingBackFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flight1 = new Flight.FlightBuilder().setAirline("Test Airline01")
                                            .setOperator("Test Airline")
                                            .setNumber("001")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("London")
                                            .setDepartureAirport("London Heathrow")
                                            .setDepartureAirportCode("LHR")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Ahmedabad")
                                            .setArrivalAirport("Ahmedabad Airport")
                                            .setArrivalAirportCode("AMD")
                                            .build();

        flightsPage.fillDetailsForFirstFlight(flight1);

        flightsPage.addNewFlight();

        flight2 = new Flight.FlightBuilder().setAirline("Test Airline01")
                                            .setOperator("Test Airline")
                                            .setNumber("002")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("Ahmedabad")
                                            .setDepartureAirport("Ahmedabad Airport")
                                            .setDepartureAirportCode("AMD")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Rajkot")
                                            .setArrivalAirport("Rajkot Airport")
                                            .setArrivalAirportCode("RAJ")
                                            .build();

        flightsPage.fillDetailsForSecondFlight(flight2);

        flightsPage.save();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @Then("^I should not see the required message anymore$")
    public void verifyFlightSectionRequiredMessageIsNotDisplayed() {

        Assert.assertFalse(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION, paymentFormPage.getPageElements()
                                                                                                          .getFlightsAreReqMsg()
                                                                                                          .isDisplayed());
    }

    /**
     * 
     */

    @When("^I delete the flight in Getting There Section$")
    public void deleteFlightInGetingThere() {

        paymentFormPage.editGettingThereFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flightsPage.deleteFlightOne();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I delete the flight in Getting Around Section$")
    public void deleteFlightInGetingAround() {

        paymentFormPage.editGettingAroundFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flightsPage.deleteFlightOne();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I delete the flight in Getting Back Section$")
    public void deleteFlightInGetingBack() {

        paymentFormPage.editGettingBackFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flightsPage.deleteFlightOne();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @And("^I should not see deleted flight on Getting There Flights section$")
    public void verifyFlightIsDeletedForGettingThere() {

        Assert.assertFalse(paymentFormPage.getPageElements()
                                          .getAirportCodeDisplayValidationForGettingThere()
                                          .getText()
                                          .contains(flight1.getDepartureAirportCode()));

    }

    /**
     * 
     */
    @And("^I should not see deleted flight on Getting Around Flights section$")
    public void verifyFlightIsDeletedForGettingAround() {

        Assert.assertFalse(paymentFormPage.getPageElements()
                                          .getAirportCodeDisplayValidationForGettingAround()
                                          .getText()
                                          .contains(flight1.getDepartureAirportCode()));

    }

    /**
     * 
     */
    @And("^I should not see deleted flight on Getting Back Flights section$")
    public void verifyFlightIsDeletedForGettingBack() {

        Assert.assertFalse(paymentFormPage.getPageElements()
                                          .getAirportCodeDisplayValidationForGettingBack()
                                          .getText()
                                          .contains(flight1.getDepartureAirportCode()));

    }

    /**
     * 
     */
    @When("^I enter the details for flight one$")
    public void enterFlightOneDetails() {

        flight1 = new Flight.FlightBuilder().setAirline("Test Airline01")
                                            .setOperator("Test Airline")
                                            .setNumber("001")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("London")
                                            .setDepartureAirport("London Heathrow")
                                            .setDepartureAirportCode("LHR")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Ahmedabad")
                                            .setArrivalAirport("Ahmedabad Airport")
                                            .setArrivalAirportCode("AMD")
                                            .build();

        flightsPage.fillDetailsForFirstFlight(flight1);

    }

    /**
     * 
     */
    @When("^Add new flight$")
    public void addNewFlight() {

        flightsPage.addNewFlight();
    }

    /**
     * 
     */
    @And("^I should see a remove button for Flight One and Flight Two$")
    public void shouldDisplayRemoveButtonForFirstTwoFlights() {

        Assert.assertTrue(webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                                  .getFirstFlightRemoveButton()));
        Assert.assertTrue(webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                                  .getSecondFlightRemoveButton()));

    }

    /**
     * 
     */
    @And("^I should see some Departure details in Flight Two being same as Arrival details from Flight one$")
    public void verifyDepartureAndArrivalDetails() {

        String flightOneArrivalDate = flightsPage.getPageElements()
                                                 .getFirstFlightArrivalDate()
                                                 .getText();
        String flightOneArrivalCity = flightsPage.getPageElements()
                                                 .getFirstFlightArrivalCityInput()
                                                 .getText();
        String flightOneArrivalAirport = flightsPage.getPageElements()
                                                    .getFirstFlightArrivalAirportInput()
                                                    .getText();
        String flightOneArrivalAirportCode = flightsPage.getPageElements()
                                                        .getFirstFlightArrivalAirportCodeInput()
                                                        .getText();

        Assert.assertEquals(flightOneArrivalDate, flightsPage.getPageElements()
                                                             .getSecondFlightDepartureDate()
                                                             .getText());
        Assert.assertEquals(flightOneArrivalCity, flightsPage.getPageElements()
                                                             .getSecondFlightDepartureCity()
                                                             .getText());
        Assert.assertEquals(flightOneArrivalAirport, flightsPage.getPageElements()
                                                                .getSecondFlightDepartureAirportName()
                                                                .getText());
        Assert.assertEquals(flightOneArrivalAirportCode, flightsPage.getPageElements()
                                                                    .getSecondFlightDepartureAirportCodeInput()
                                                                    .getText());
    }

    /**
     * 
     */
    @When("^I enter the details for flight two$")
    public void enterFlightTwoDetails() {

        flight2 = new Flight.FlightBuilder().setAirline("Test Airline02")
                                            .setOperator("Test Airline")
                                            .setNumber("002")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setArrivalDate(new Date())
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Rajkot")
                                            .setArrivalAirport("Rajkot Airport")
                                            .setArrivalAirportCode("RAJ")
                                            .build();

        flightsPage.fillDetailsForSecondFlight(flight2);

    }

    /**
     * 
     */
    @And("^I should see Remove button for Flight Three$")
    public void shouldDisplayRemoveButtonForThirdFlight() {

        Assert.assertTrue(webDriverCommons.isDisplayed(flightsPage.getPageElements()
                                                                  .getThirdFlightRemoveButton()));
    }

    /**
     * 
     */
    @When("^I enter the details for flight three$")
    public void enterFlightThreeDetails() {

        flight3 = new Flight.FlightBuilder().setAirline("Test Airline03")
                                            .setOperator("Test Airline")
                                            .setNumber("003")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("London")
                                            .setArrivalAirport("London Heathrow")
                                            .setArrivalAirportCode("LHR")
                                            .build();

        flightsPage.fillDetailsForThirdFlight(flight3);

    }

    /**
     * 
     */
    @When("^I change the details of the second Flight for Getting There section$")
    public void editSecondFlightForGettingThereSection() {

        paymentFormPage.editGettingThereFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flight2 = new Flight.FlightBuilder().setAirline("Test Airline02")
                                            .setOperator("Test Airline")
                                            .setNumber("002")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("London")
                                            .setDepartureAirport("London Gatwick")
                                            .setDepartureAirportCode("GTW")
                                            .setArrivalDate(new Date())
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Rajkot")
                                            .setArrivalAirport("London Gatwick")
                                            .setArrivalAirportCode("Edited")
                                            .build();

        flightsPage.fillDetailsForSecondFlight(flight2);

        flightsPage.save();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I change the details of the second Flight for Getting Around section$")
    public void editSecondFlightForGettingAroundSection() {

        paymentFormPage.editGettingAroundFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flight2 = new Flight.FlightBuilder().setAirline("Test Airline02")
                                            .setOperator("Test Airline")
                                            .setNumber("002")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("London")
                                            .setDepartureAirport("London Gatwick")
                                            .setDepartureAirportCode("GTW")
                                            .setArrivalDate(new Date())
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Rajkot")
                                            .setArrivalAirport("Rajkot Airport")
                                            .setArrivalAirportCode("Edited")
                                            .build();

        flightsPage.fillDetailsForSecondFlight(flight2);

        flightsPage.save();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I change the details of the second Flight for Getting Back section$")
    public void editSecondFlightForGettingBackSection() {

        paymentFormPage.editGettingBackFlightDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, flightsPage.isPageLoaded());

        flight2 = new Flight.FlightBuilder().setAirline("Test Airline02")
                                            .setOperator("Test Airline")
                                            .setNumber("002")
                                            .setDepartureHour("05 AM")
                                            .setDepartureMinute("00")
                                            .setDepartureCity("London")
                                            .setDepartureAirport("London Gatwick")
                                            .setDepartureAirportCode("GTW")
                                            .setArrivalDate(new Date())
                                            .setArrivalHour("09 AM")
                                            .setArrivalMinute("30")
                                            .setArrivalCity("Rajkot")
                                            .setArrivalAirport("Rajkot Airport")
                                            .setArrivalAirportCode("Edited")
                                            .build();

        flightsPage.fillDetailsForSecondFlight(flight2);

        flightsPage.save();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_FLIGHTS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @And("^I save the flight details$")
    public void saveDetails() {

        flightsPage.save();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @Then("^I should see the flight information in Getting There section$")
    public void verifyFlightsAreAddedInGettinThere() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingThere()
                                         .getText()
                                         .contains(flight1.getArrivalAirportCode()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingThere()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingThere()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertFalse(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION, paymentFormPage.getPageElements()
                                                                                                          .getFlightsAreReqMsg()
                                                                                                          .isDisplayed());

    }

    /**
     * 
     */
    @Then("^I should see the flight information in Getting Around section$")
    public void verifyFlightsAreAddedInGettinAround() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingAround()
                                         .getText()
                                         .contains(flight1.getArrivalAirportCode()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingAround()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingAround()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertFalse(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION, paymentFormPage.getPageElements()
                                                                                                          .getFlightsAreReqMsg()
                                                                                                          .isDisplayed());

    }

    /**
     * 
     */
    @Then("^I should see the flight information in Getting Back section$")
    public void verifyFlightsAreAddedInGettingBack() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingBack()
                                         .getText()
                                         .contains(flight1.getArrivalAirportCode()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingBack()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingBack()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertFalse(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION, paymentFormPage.getPageElements()
                                                                                                          .getFlightsAreReqMsg()
                                                                                                          .isDisplayed());

    }

    /**
     * 
     */
    @Then("^I should see the new flight changes in Getting There section$")
    public void verifyFlightEditedForGettinthere() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingThere()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertFalse(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION, paymentFormPage.getPageElements()
                                                                                                          .getFlightsAreReqMsg()
                                                                                                          .isDisplayed());

    }

    /**
     * 
     */
    @Then("^I should see the new flight changes in Getting Around section$")
    public void verifyFlightEditedForGettingfAround() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingAround()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertFalse(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION, paymentFormPage.getPageElements()
                                                                                                          .getFlightsAreReqMsg()
                                                                                                          .isDisplayed());

    }

    /**
     * 
     */
    @Then("^I should see the new flight changes in Getting Back section$")
    public void verifyFlightEditedForGettingfBack() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getAirportCodeDisplayValidationForGettingBack()
                                         .getText()
                                         .contains(flight2.getArrivalAirportCode()));

        Assert.assertFalse(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FLIGHT_SECTION, paymentFormPage.getPageElements()
                                                                                                          .getFlightsAreReqMsg()
                                                                                                          .isDisplayed());

    }

    /**
     * 
     */
    @When("^I disable Getting There Flight$")
    public void disableGettingThereFlight() {
        paymentFormPage.disableGettingThereFlight();
        
    }

    /**
     * 
     */
    @When("^I disable Getting Around Flight$")
    public void disableGettingAroundFlight() {
        paymentFormPage.disableGettingAroundFlight();
        
    }

    /**
     * 
     */
    @When("^I disable Getting Back Flight$")
    public void disableGettingBackFlight() {
        paymentFormPage.disableGettingBackFlight();
        
    }

}
