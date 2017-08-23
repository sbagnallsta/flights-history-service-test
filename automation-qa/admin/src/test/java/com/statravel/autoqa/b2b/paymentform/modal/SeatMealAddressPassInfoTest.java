package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Address;
import com.statravel.autoqa.domain.b2b.paymentform.Meal;
import com.statravel.autoqa.domain.b2b.paymentform.PassengerInformation;
import com.statravel.autoqa.domain.b2b.paymentform.Seat;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class SeatMealAddressPassInfoTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private PassengerInformation passengerInformation;

    private Seat seat;

    private Meal meal;

    private Address address;

    /**
     * 
     */
    @Before
    public void init() {
        paymentFormPage.init();
    }

    /**
     * 
     */
    @Given("^seat preferences are added by default$")
    public void verifySeatPreferencesAreAddedByDefault() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISPLAY_BY_DEFAULT, AssertionMessages.AISLE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAisleSeatConfirmation()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISPLAY_BY_DEFAULT, AssertionMessages.WINDOW),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getWindowSeatConfirmation()));
    }

    /**
     * 
     */
    @When("^I delete all the seat preference option$")
    public void deleteAllSeatPreferenceOption() {

        paymentFormPage.deleteSeatPreferences();
    }

    /**
     * 
     */
    @Then("^I should see the option redisplayed on the seat preference dropdown$")
    public void verifySeatOptionRedisplayedOnSeatPreferenceDropdown() {

        paymentFormPage.clickOnSeatPreferenceDropdown();

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.AISLE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAisleSeatEnableDropdown()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.WINDOW),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getWindowSeatEnableDropdown()));
    }

    /**
     * 
     */
    @Then("^I should see selected seat options greyed out in dropdown$")
    public void verifySeatOptionsGreyedOutInDropdown() {

        paymentFormPage.clickOnSeatPreferenceDropdown();

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.AISLE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAisleSeatDisableDropdown()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.WINDOW),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getWindowSeatDisableDropdown()));
    }

    /**
     * 
     */
    @Then("^I should see selected meal options greyed out in dropdown$")
    public void verifyMealOptionsGreyedOutInDropdown() {

        paymentFormPage.clickOnMealPreferenceDropdown();

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.VEGETARIAN),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getVegetarianegetarianDisableDropdown()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.VEGAN),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getVeganDisableDropdown()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.OTHER_MEAL),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOthersdisableDropdown()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.KOSHER),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getKocherDisableDropdown()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.DIABETIC),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDiabeticDisableDropdown()));
    }

    /**
     * 
     */
    @When("^I activate the seat preference section$")
    public void activateSeatPreferenceSection() {

        paymentFormPage.toggleSeatPreferenceInactiveMode();

    }

    /**
     * 
     */
    @Then("^I should see the seat option required field message$")
    public void verifySeatOptionRequiredFieldMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_SEAT_SECTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getSeatPrefenceReqiureMessage()));
    }

    /**
     * 
     */
    @Then("^I should not see the seat option required field message$")
    public void verifySeatOptionRequiredFieldMessageIsNotDisplayed() {
        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_SEAT_SECTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getSeatPrefenceReqiureMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should not see the meal option required field message$")
    public void verifyMealOptionRequiredFieldMessageIsNotDisplayed() {
        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MEAL_SECTION, AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getMealPreferenceRequireMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @When("^I select seat option from the dropdown$")
    public void selectSeatOptionFromDropdown() {

        seat = new Seat.SeatBuilder().setWindow("Window")
                                     .seaSeat("Aisle")
                                     .build();

        paymentFormPage.selectFromSeatOption(seat);
    }

    /**
     * 
     */
    @Then("^I should see selected seat option displayed$")
    public void verifySelectedSeatOptionDisplayed() {

        verifySeatPreferencesAreAddedByDefault();
    }

    /**
     * 
     */
    @Given("^meal preferences are added by default$")
    public void verifyMealPreferencesAreAddedByDefault() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISPLAY_BY_DEFAULT, AssertionMessages.VEGETARIAN),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getVegetarianMealConfirmation()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISPLAY_BY_DEFAULT, AssertionMessages.DIABETIC),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDiabeticMealConfirmation()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISPLAY_BY_DEFAULT, AssertionMessages.KOSHER),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getKosherMealConfirmation()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISPLAY_BY_DEFAULT, AssertionMessages.VEGAN),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getVeganMealConfirmation()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISPLAY_BY_DEFAULT, AssertionMessages.OTHER_MEAL),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOtherMealConfirmation()));
    }

    /**
     * 
     */
    @When("^I delete all the meal preference option$")
    public void deleteAllMealPreferenceOption() {

        paymentFormPage.deleteMealPreference();
    }

    /**
     * 
     */
    @Then("^I should see the option redisplayed on the meal preference dropdown$")
    public void verifyMealOptionRedisplayedOnMealPreferenceDropdown() {

        paymentFormPage.clickOnMealPreferenceDropdown();

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.VEGETARIAN),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getVegetarianEnableDropdown()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.VEGAN),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getVeganEnableDropdown()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.KOSHER),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getKosherEnableDropdown()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.OTHER_MEAL),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOtherEnableDropdown()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.DIABETIC),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDiabeticEnableDropdown()));
    }

    /**
     * 
     */
    @When("^I activate the meal preference section$")
    public void activateMealPreferenceSection() {

        paymentFormPage.toggleMealPreferenceInactiveMode();
    }

    /**
     * 
     */
    @Then("^I should see the meal option required field message$")
    public void verifyMealOptionRequiredFieldMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MEAL_SECTION, AssertionMessages.IS),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getMealPreferenceRequireMessage()));
    }

    /**
     * 
     */
    @When("^I select a meal option from the dropdown$")
    public void selectMealOptionFromDropdown() {

        meal = new Meal.MealBuilder().setDiabetic("Diabetic")
                                     .setKosher("Kosher")
                                     .setOther("Other")
                                     .setVegan("Vegan")
                                     .setVegetarian("Vegetarian")
                                     .build();

        paymentFormPage.selectFromMealPreference(meal);
    }

    /**
     * 
     */
    @Then("^I should see selected meal option displayed")
    public void verifyAddedMealOptionDisplayed() {

        verifyMealPreferencesAreAddedByDefault();

    }

    /**
     * 
     */
    @When("^I select options from the address dropdown$")
    public void selectOptionsFromAddressDropdown() {

        address = new Address.AddressBuilder().setAddressLineOne("Address line 1")
                                              .setAddressLineTwo("Address line 2")
                                              .setCity("City")
                                              .setCountry("Country")
                                              .setState("State")
                                              .setZipCode("Zip Code")
                                              .build();

        paymentFormPage.selectFromAddressPreference(address);

    }

    /**
     * 
     */
    @Then("^I should see selected address options displayed on payment form$")
    public void verifySelectedAddressOptionsDisplayedOnPaymentForm() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.ADDRESS_LINE_1),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAddressLineOneConfirmation()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.ADDRESS_LINE_2),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAddressLineTwoConfirmation()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.CITY),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getCityConfirmation()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.STATE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getStateConfirmation()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.ZIP_CODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getZipCodeConfirmation()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.COUNTRY),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getCountryConfirmation()));
    }

    /**
     * 
     */
    @Then("^I should see selected options greyed out in the address information dropdown$")
    public void selectedOptionShouldBeGreyedOutInTheAddressDropdown() {

        paymentFormPage.clickOnAddressDropdown();
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.ADDRESS_LINE_1),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAddressLineOneDisableDropdown()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.ADDRESS_LINE_2),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAddressLineTwoDisableDropdown()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.CITY),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getCityDisableDropdown()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.STATE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getStateDisableDropdown()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.ZIP_CODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getZipCodeDisableDropdown()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.COUNTRY),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getCountyDisableDropdown()));
    }

    /**
     * 
     */
    @When("^I delete all address option$")
    public void deleteAllAddressOption() {

        paymentFormPage.deleteAddressPreference();
    }

    /**
     * 
     */
    @Then("^I should see the option redisplayed on the Address dropdown$")
    public void verifyOptionRedisplayedOnTheAddressDropdown() {

        paymentFormPage.clickOnAddressDropdown();

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.ADDRESS_LINE_1),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAddressLineOneEnableDropdown()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.ADDRESS_LINE_2),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAddressLineTwoEnableDropdown()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.CITY),
                paymentFormPage.getPageElements()
                               .getCityEnableDropdown()
                               .isDisplayed());
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.STATE),
                paymentFormPage.getPageElements()
                               .getStateEnableDropdown()
                               .isDisplayed());
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.ZIP_CODE),
                paymentFormPage.getPageElements()
                               .getZipCodeEnableDropdown()
                               .isDisplayed());
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.COUNTRY),
                paymentFormPage.getPageElements()
                               .getCountryEnableDropdown()
                               .isDisplayed());

    }

    /**
     * 
     */
    @When("^I select options from the passenger information dropdown$")
    public void selectOptionsFromPassengerInformationDropdown() {

        passengerInformation = new PassengerInformation.PassengerInformationBuilder().setMiddleName("Middle Name")
                                                                                     .setdateOfBirth("Date of Birth")
                                                                                     .setPassportNumber("Passport Number")
                                                                                     .setPhoneNumber("Phone Number")
                                                                                     .build();

        paymentFormPage.selectFromPassengerInformation(passengerInformation);

    }

    /**
     * 
     */
    @Then("^I should see selected passenger information options dispalyed on payment form$")
    public void verifySelectedPassengerInformationOptionsDispalyedOnPaymentForm() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.MIDDLE_NAME),
                paymentFormPage.getPageElements()
                               .getMiddleNameConfirmation()
                               .isDisplayed());
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.DOB),
                paymentFormPage.getPageElements()
                               .getDateOfBirthConfirmation()
                               .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.PHONE_NUMBER),
                paymentFormPage.getPageElements()
                               .getPhoneNumberConfirmation()
                               .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.PASSPORT_NUMBER),
                paymentFormPage.getPageElements()
                               .getPassportNumberConfirmation()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should see selected options greyed out in the passenger information dropdown$")
    public void verifySelectedOptionsGreyedOutInPassengerInformationDropdown() {

        paymentFormPage.clickOnPassengerInformationDropdown();

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.MIDDLE_NAME),
                paymentFormPage.getPageElements()
                               .getMiddleNameDisableDropdown()
                               .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN, AssertionMessages.DOB),
                paymentFormPage.getPageElements()
                               .getDateOfBirthDisableDropdown()
                               .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.PHONE_NUMBER),
                paymentFormPage.getPageElements()
                               .getPhoneNumberDisableDropdown()
                               .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_DISABLE_AFTER_SELECTING_FROM_DROPDOWN,
                        AssertionMessages.PASSPORT_NUMBER),
                paymentFormPage.getPageElements()
                               .getPassportNumberDisableDropdown()
                               .isDisplayed());
    }

    /**
     * 
     */
    @When("^I delete all passenger information options$")
    public void deleteAllPassengerInformationOptions() {

        paymentFormPage.deletePassengerrInformationPreference();
    }

    /**
     * 
     */
    @Then("^I should see the option redisplayed on the passenger information dropdown$")
    public void verifyOptionsRedisplayedOnPassengerInformationDropdown() {

        paymentFormPage.clickOnPassengerInformationDropdown();

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.MIDDLE_NAME),
                paymentFormPage.getPageElements()
                               .getMiddleNameEnableDropdown()
                               .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.PASSPORT_NUMBER),
                paymentFormPage.getPageElements()
                               .getPassportNumberEnableDropdown()
                               .isDisplayed());
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.DOB),
                paymentFormPage.getPageElements()
                               .getDateOfBirthEnableDropdown()
                               .isDisplayed());
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_REDISPLAY_ON_DROPDOWN, AssertionMessages.PHONE_NUMBER),
                paymentFormPage.getPageElements()
                               .getPhoneNumberEnableDropdown()
                               .isDisplayed());
    }

}
