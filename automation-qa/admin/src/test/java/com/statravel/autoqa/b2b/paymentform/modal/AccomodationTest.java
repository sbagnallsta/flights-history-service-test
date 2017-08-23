package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Accommodation;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormListPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;
import com.statravel.autoqa.page.b2b.paymentform.modal.AccommodationPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Internal Team
 *
 */
@CucumberStepsDefinition
public class AccomodationTest {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Autowired
    private PaymentFormListPage paymentFormListPage;

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private AccommodationPage accommodationPage;

    @Autowired
    private FlightsTest flightsTest;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private Accommodation accommodation1, accommodation2, editedAccommodation;

    /**
     * 
     */
    @Before
    public void init() {

        loginPage.init();
        homePage.init();
        accommodationPage.init();
        paymentFormListPage.init();
        paymentFormPage.init();
    }

    /**
     * 
     */
    @When("^I activate Accommodation section$")
    public void activateAccommodationSection() {

        paymentFormPage.toggleAccommodationActiveBarInactiveMode();

    }

    /**
    * 
    */
    @Then("^I should see a Accommodation required message$")
    public void verifyAccommodationRequiredMessageIsDisplayed() {
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_SECTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAccommodationIsRequireMessage()));
    }

    /**
     * 
     */
    @When("^I add new Accommodation$")
    public void addNewAccommodation() {

        paymentFormPage.selectAddNewAccommodation();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_ACCOMMODATION, accommodationPage.isPageLoaded());

        accommodation1 = new Accommodation.AccommodationBuilder().setName("Test 01")
                                                                 .setCity("Test City01")
                                                                 .setAddress("Test Address")
                                                                 .setRooms("1")
                                                                 .setRoomsType("Single")
                                                                 .setCheckInHour("03 PM")
                                                                 .setCheckInMinute("18")
                                                                 .setCheckOutHour("04 AM")
                                                                 .setCheckOutMinute("10")
                                                                 .setNights("2")
                                                                 .setSpecialRemark("Enjoy")
                                                                 .build();

        accommodationPage.fillAccommodationDetails(accommodation1);

        accommodationPage.saveDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @Then("^I should not see a Accommodation required message$")
    public void verifyAccommodationRequiredMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_SECTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getAccommodationIsRequireMessage()
                               .isDisplayed());

    }

    /**
     * 
     */
    @Then("^I should see new Accommodation on the Accommodation section$")
    public void verifyAccommodationDetaisDisplayedOnTheAccommodationSection() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(accommodation1.getName()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(accommodation1.getCity()));

    }

    /**
     * 
     */
    @When("^I disable the Accommodation$")
    public void disableTheAccommodation() {

        paymentFormPage.selectFirstAccommodationActiveBarActiveMode();

    }

    /**
     * 
     */
    @When("^I enter second Accommodation$")
    public void enterSecondAccommodation() {

        paymentFormPage.selectAddNewAccommodation();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_ACCOMMODATION, accommodationPage.isPageLoaded());

        accommodation2 = new Accommodation.AccommodationBuilder().setName("Test 02")
                                                                 .setCity("Test City02")
                                                                 .setAddress("Test Address")
                                                                 .setRooms("2")
                                                                 .setRoomsType("Double")
                                                                 .setCheckInHour("03 PM")
                                                                 .setCheckInMinute("18")
                                                                 .setCheckOutHour("04 AM")
                                                                 .setCheckOutMinute("10")
                                                                 .setNights("2")
                                                                 .setSpecialRemark("Enjoy")
                                                                 .build();

        accommodationPage.fillAccommodationDetails(accommodation2);

        accommodationPage.saveDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @Given("^I am on Accommodation Details page$")
    public void loadAccommodationDetailsPage() {

        flightsTest.loadPaymentFormDetailsPage();

        activateAccommodationSection();

        paymentFormPage.selectAddNewAccommodation();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_ACCOMMODATION, accommodationPage.isPageLoaded());

    }

    /**
     * 
     */
    @Given("^I should see required messages are displayed on Accommodation page$")
    public void verifyRequiredMessagesAreDisplayedOnAccommodationpage() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getNameRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCityRequireMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getAddressRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getRoomsRequireMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getRoomsTypeRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckInDateRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckInTimeRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckOutDateRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckOutTimeRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getNightsRequireMessage()));

    }

    /**
     * 
     */
    @When("^I save Accommodation details page without entering data in the required field$")
    public void saveAccommodationDetailsPageWithoutEnteringAnyDataInTheRequiredField() {

        accommodationPage.saveDetails();

    }

    /**
     * 
     */
    @Then("^I should see warning messages on Accommodation page$")
    public void verifyWarningMessagesDisplayedOnAccommodationPage() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getNameRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCityRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getAddressRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getRoomsRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getRoomsTypeRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckInDateRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckInTimeRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckOutDateRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getCheckOutTimeRequireErrorMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getNightsRequireErrorMessage()));
    }

    /**
     * 
     */
    @When("^I enter alphabets in Rooms and Nights fields$")
    public void enterAlphabetsInRoomsAndNights() {

        accommodation1 = new Accommodation.AccommodationBuilder().setName("Test 01")
                                                                 .setCity("Test City01")
                                                                 .setAddress("Test Address")
                                                                 .setRooms("One")
                                                                 .setRoomsType("Single")
                                                                 .setCheckInHour("03 PM")
                                                                 .setCheckInMinute("18")
                                                                 .setCheckOutHour("04 AM")
                                                                 .setCheckOutMinute("10")
                                                                 .setNights("Two")
                                                                 .setSpecialRemark("Enjoy")
                                                                 .build();

        accommodationPage.fillAccommodationDetails(accommodation1);

        accommodationPage.saveDetails();

    }

    /**
     * 
     */
    @Then("^I should see Numeric fields warning messages on Accommodation page$")
    public void verifyNumericFieldsWarningMessagesDisplayedOnAccommodationpage() {

        Assert.assertTrue(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_ROOMS_NUMERIC_MESSAGE,
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getRoomsIsNumericFieldMessage()));

        Assert.assertTrue(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_NIGHTS_NUMERIC_MESSAGE,
                webDriverCommons.isDisplayed(accommodationPage.getPageElements()
                                                              .getNightsIsNumericFieldMessage()));
    }

    /**
     * 
     */
    @When("^I edit the details of the new Accommodation$")
    public void editDetailsOfTheNewAccommodation() {

        paymentFormPage.selectFirstAccommodationEditButton();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_ACCOMMODATION, accommodationPage.isPageLoaded());

        editedAccommodation = new Accommodation.AccommodationBuilder().setName("Edited Name")
                                                                      .setCity("Edited City")
                                                                      .setAddress("Test Address")
                                                                      .setRooms("1")
                                                                      .setRoomsType("Single")
                                                                      .setCheckInHour("03 PM")
                                                                      .setCheckInMinute("18")
                                                                      .setCheckOutHour("04 AM")
                                                                      .setCheckOutMinute("10")
                                                                      .setNights("2")
                                                                      .setSpecialRemark("Enjoy")
                                                                      .build();

        accommodationPage.fillAccommodationDetails(editedAccommodation);

    }

    /**
     * 
     */
    @When("^I save changes on Accommodation page$")
    public void selectSaveOnAccommodationpage() {

        accommodationPage.saveDetails();
    }

    /**
     * 
     */
    @Then("^I should see edited Accommodation on the Accommodation section with changes$")
    public void verifyEditedAccommodationIsDisplayedOnTheAccommodationSection() {

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(accommodation1.getName()));

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(accommodation1.getCity()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(editedAccommodation.getName()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(editedAccommodation.getCity()));
    }

    /**
     * 
     */
    @Then("^I should see second Accommodation on Accommodation Section$")
    public void verifySecondAccommodationIsDisplayedOnAccommodationSection() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForSecondAccommodation()
                               .getText()
                               .contains(accommodation2.getName()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForSecondAccommodation()
                               .getText()
                               .contains(accommodation2.getCity()));
    }

    /**
     * 
     */
    @When("^I select cancel on Accommodation page$")
    public void selectCancelOnAccmmodationPage() {

        accommodationPage.cancelDetails();
    }

    /**
     * 
     */
    @Then("^I should see Accommodation on Accommodation section without any changes$")
    public void verifyAccommodationDisplayedOnAccommodationSectionWithoutChanges() {

        verifyAccommodationDetaisDisplayedOnTheAccommodationSection();

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(editedAccommodation.getName()));

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACCOMMODATION_MODAL_CONFORMATION_MESSAGE,
                        AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getConfirmationForFirstAccommodation()
                               .getText()
                               .contains(editedAccommodation.getCity()));
    }

}
