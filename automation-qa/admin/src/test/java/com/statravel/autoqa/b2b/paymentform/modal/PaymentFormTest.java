package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.PaymentForm;
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
public class PaymentFormTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private PaymentForm paymentForm;

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
    @Given("^I see required messages on all the partner information required fields$")
    public void verifyRequiredMessagesIsDisplayedForPartnerInformationRequiredFields() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FORM_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFormNameISRequireMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_PARTNER_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getPartnerNameIsRequireMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRIP_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTripNameIsRequireMsg()));
    }

    /**
     * 
     */
    @When("^I fill in details in all the partner information fields$")
    public void fillInDetailsInAllPartnerInformationFields() {

        paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("Test 01")
                                                          .setPartnerName("Test Partner")
                                                          .setPartnerLogo("")
                                                          .setTripName("Test Trip")
                                                          .setTravelHeading("")
                                                          .setTravelIntro("")
                                                          .setImportantInstructionDescription("")
                                                          .build();

        paymentFormPage.fillDetailsForPaymentForm(paymentForm);

    }

    /**
     * TODO.
     */
    @Then("^I should see partner information with details added$")
    public void verifyAddedDetailsDisplayedForPartnerInformation() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION, AssertionMessages.FORM_NAME),
                paymentFormPage.getPageElements()
                               .getFormNameInput()
                               .getAttribute("value")
                               .contains(paymentForm.getFormName()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION, AssertionMessages.PARTNER_NAME),
                paymentFormPage.getPageElements()
                               .getPartnerNameInput()
                               .getAttribute("value")
                               .contains(paymentForm.getPartnerName()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION, AssertionMessages.PARTNER_LOGO),
                paymentFormPage.getPageElements()
                               .getPartnerLogoInput()
                               .getAttribute("value")
                               .contains(paymentForm.getPartnerLogo()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION, AssertionMessages.TRIP_NAME),
                paymentFormPage.getPageElements()
                               .getTripNameInput()
                               .getAttribute("value")
                               .contains(paymentForm.getTripName()));

    }

    /**
     * 
     */
    @Then("^I should not see the required messages on all the partner information required fields$")
    public void verifyRequiredMessagesIsNotDisplayedForPartnerInformationRequiredFields() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FORM_NAME, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getFormNameISRequireMsg()
                               .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_PARTNER_NAME, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getPartnerNameIsRequireMsg()
                               .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRIP_NAME, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getTripNameIsRequireMsg()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Given("^I see required messages on all the travel information required fields$")
    public void verifyRequiredMessagesIsDisplayedForAllTravelInformationRequiredFields() {
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRAVEL_HEADING, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTravelHeadingIsRequireMsg()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRAVEL_INTRO, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTravelIntroIsRequireMsg()));
    }

    /**
     * 
     */
    @When("^I fill in details in all the travel information fields$")
    public void fillInDetailsForTravelInformationFields() {

        paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("")
                                                          .setPartnerName("")
                                                          .setPartnerLogo("")
                                                          .setTripName("")
                                                          .setTravelHeading("Test Heading")
                                                          .setTravelIntro("Test Intro")
                                                          .setImportantInstructionDescription("")
                                                          .build();

        paymentFormPage.fillDetailsForPaymentForm(paymentForm);
    }

    /**
     * 
     */
    @Then("^I should see travel information with details added$")
    public void verifyAddedInformationIsDisplayedInTravelInformationField() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION, AssertionMessages.TRAVEL_HEADING),
                paymentFormPage.getPageElements()
                               .getTravelHeadingInput()
                               .getAttribute("value")
                               .contains(paymentForm.getTravelHeading()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION, AssertionMessages.TRAVEL_INTRO),
                paymentFormPage.getPageElements()
                               .getTravelIntroTextInput()
                               .getAttribute("value")
                               .contains(paymentForm.getTravelIntro()));
    }

    /**
     * 
     */
    @Then("^I should not see the required messages on all the travel information required fields$")
    public void verifyRequiredMessagesIsNotDisplayedForAllTravelInformationRequiredFields() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRAVEL_HEADING, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getTravelHeadingIsRequireMsg()
                               .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRAVEL_INTRO, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getTravelIntroIsRequireMsg()
                               .isDisplayed());
    }

    /**
     * 
     */
    @When("^I activate the Important instruction field$")
    public void activateImportantInstructionField() {

        paymentFormPage.toggleImportantInstructionActiveBarActiveMode();
    }

    /**
     * 
     */
    @Then("^I should see the Important instruction required message on the important instruction field$")
    public void verifyImportantInstructionRequiredMessageIsDisplayedForImportantInstructionField() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_IMPORTANT_INSTRUCTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getImportantInstructionRequireMsg()));
    }

    /**
     * 
     */
    @When("^I fill in details in the important instruction field$")
    public void fillDetailsInTheImportantInstructionField() {

        paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("")
                                                          .setPartnerName("")
                                                          .setPartnerLogo("")
                                                          .setTripName("")
                                                          .setTravelHeading("")
                                                          .setTravelIntro("")
                                                          .setImportantInstructionDescription("Test Important Instruction")
                                                          .build();

        paymentFormPage.fillDetailsForPaymentForm(paymentForm);
    }

    /**
     * 
     */
    @Then("^I should not see the required messages on all the important instruction field$")
    public void verifyImportantInstructionRequiredMessageIsNotDisplayedForImportantInstructionField() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_IMPORTANT_INSTRUCTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getImportantInstructionRequireMsg()
                               .isDisplayed());
    }

    /**
     * 
     * @param date
     *            date
     */
    @Given("^\"([^\"]*)\" section is not activated$")
    public void verifySectionIsNotActivated(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            Assert.assertTrue(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.FINAL_PAYMENT_DATE,
                            AssertionMessages.ACTICE_MODE, AssertionMessages.INACTICE_MODE),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getFinalDepositDateActiveBarInactiveMode()));
        }

        if (date.equalsIgnoreCase("final payment due date")) {
            Assert.assertTrue(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.FINAL_DEPOSIT_DUE_DATE,
                            AssertionMessages.ACTICE_MODE, AssertionMessages.INACTICE_MODE),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getFinalPaymentDueDateActiveBarInactiveMode()));
        }
    }

    /**
     * 
     * @param date
     *            date
     */
    @Given("^I should see \"([^\"]*)\" fields disabled$")
    public void verifyFieldIsDisabled(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            Assert.assertTrue("Final Deposit Date calendar input is enable but expected disable",
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getFinalDepositDateCalendarDisableMode()));
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            Assert.assertTrue("Final Payment Due Date calendar input is enable but expected disable",
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getFinalPaymentDueDateCalendarDisableMode()));
        }
    }

    /**
     * 
     * @param date
     *            date
     */
    @When("^I activate \"([^\"]*)\" section$")
    public void activateSection(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            paymentFormPage.toggleFinalDepositDateInactiveMode();
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            paymentFormPage.toggleFinalPaymentDueDateInactiveMode();
        }
    }

    /**
     * 
     * @param date
     *            date
     */
    @Then("^I should see \"([^\"]*)\" required message$")
    public void verifyRequiredMessageIsDisplayedOnField(final String date) {
        if (date.equalsIgnoreCase("final deposit date")) {
            Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FINAL_DEPOSIT_DATE, AssertionMessages.IS_NOT),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getFinalDepositRequireMsg()));
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FINAL_PAYMENT_DATE, AssertionMessages.IS_NOT),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getFinalPaymentDueDateRequireMsg()));
        }
    }

    /**
     * 
     * @param date
     *            date
     */
    @When("^I enter data in all fields under \"([^\"]*)\" section$")
    public void fillDataInAllFieldsUnderSection(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {

            paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("")
                                                              .setPartnerName("")
                                                              .setPartnerLogo("")
                                                              .setTripName("")
                                                              .setTravelHeading("")
                                                              .setTravelIntro("")
                                                              .setFinalDepositDateActive(true)
                                                              .setFinalDepositDescription("Final Date description")
                                                              .setImportantInstructionDescription("")
                                                              .build();

            paymentFormPage.fillDetailsForPaymentForm(paymentForm);
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("")
                                                              .setPartnerName("")
                                                              .setPartnerLogo("")
                                                              .setTripName("")
                                                              .setTravelHeading("")
                                                              .setTravelIntro("")
                                                              .setFinalPaymentDateActive(true)
                                                              .setFinalPaymentDescription("Final Payment description")
                                                              .setImportantInstructionDescription("")
                                                              .build();

            paymentFormPage.fillDetailsForPaymentForm(paymentForm);

        }
    }

    /**
     * 
     * @param date
     *            date
     */
    @Then("^I should see data entered in all \"([^\"]*)\" fields including date$")
    public void verifyDataIsDisplayedAsEnteredInAllFieldsIncludingDate(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {

            Assert.assertTrue("Final Deposit date input is empty even after entering date", !paymentFormPage.getPageElements()
                                                                                                            .getFinalDepositDateCalendarEnableMode()
                                                                                                            .getAttribute("value")
                                                                                                            .isEmpty());

            Assert.assertTrue(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION,
                            AssertionMessages.FINAL_DEPOSITE_DATE_CALENDER_INPUT),
                    paymentFormPage.getPageElements()
                                   .getFinalDepositDateDiscriptionEnableMode()
                                   .getAttribute("value")
                                   .contains(paymentForm.getFinalDepositDescription()));
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            Assert.assertTrue("Final Payment Due Date input is empty even after entering date", !paymentFormPage.getPageElements()
                                                                                                                .getFinalPaymentDueDateCalendarEnableMode()
                                                                                                                .getAttribute("value")
                                                                                                                .isEmpty());

            Assert.assertTrue(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_FIELD_CONFIRMATION,
                            AssertionMessages.FINAL_PAYMENT_DUE_DATE_CALENDER_INPUT),
                    paymentFormPage.getPageElements()
                                   .getFinalPaymentDueDateDiscriptionEnableMode()
                                   .getAttribute("value")

                                   .contains(paymentForm.getFinalPaymentDescription()));

        }

    }

    /**
     * 
     * @param date
     *            date
     */
    @Then("^I should not see the \"([^\"]*)\" required message$")
    public void verifyRequiredMessageIsNotDisplayedOnField(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_FINAL_DEPOSIT_DATE, AssertionMessages.IS),
                    paymentFormPage.getPageElements()
                                   .getFinalDepositRequireMsg()
                                   .isDisplayed());
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_DUE_DATE, AssertionMessages.IS),
                    paymentFormPage.getPageElements()
                                   .getFinalPaymentDueDateRequireMsg()
                                   .isDisplayed());
        }
    }

    /**
     * 
     * @param date
     *            date
     */
    @When("^I enter the dates in the \"([^\"]*)\" field$")
    public void enterDatesInTheDateField(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {

            paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("")
                                                              .setPartnerName("")
                                                              .setPartnerLogo("")
                                                              .setTripName("")
                                                              .setTravelHeading("")
                                                              .setTravelIntro("")
                                                              .setFinalDepositDateActive(true)
                                                              .setFinalDepositDescription("")
                                                              .setImportantInstructionDescription("")
                                                              .build();

            paymentFormPage.fillDetailsForPaymentForm(paymentForm);
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("")
                                                              .setPartnerName("")
                                                              .setPartnerLogo("")
                                                              .setTripName("")
                                                              .setTravelHeading("")
                                                              .setTravelIntro("")
                                                              .setFinalPaymentDateActive(true)
                                                              .setFinalPaymentDescription("")
                                                              .setImportantInstructionDescription("")
                                                              .build();

            paymentFormPage.fillDetailsForPaymentForm(paymentForm);

        }

    }

    /**
     * 
     * @param date
     *            date
     */
    @Then("^I should see the dates displayed in the \"([^\"]*)\" fields$")
    public void verifyDatesAreDisplayedInTheDateFields(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            Assert.assertTrue("Final Deposit date input is empty even after entering date", !paymentFormPage.getPageElements()
                                                                                                            .getFinalDepositDateCalendarEnableMode()
                                                                                                            .getAttribute("value")
                                                                                                            .isEmpty());

        }
        if (date.equalsIgnoreCase("final payment due date")) {
            Assert.assertTrue("Final Payment Due date input is empty even after entering date", !paymentFormPage.getPageElements()
                                                                                                                .getFinalPaymentDueDateCalendarEnableMode()
                                                                                                                .getAttribute("value")
                                                                                                                .isEmpty());

        }

    }

    /**
     * 
     * @param date
     *            date
     */
    @When("^I edit the \"([^\"]*)\" by clicking on today$")
    public void editDateByClickingOnToday(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            paymentFormPage.clickOnFinalDepositDateCalendarInput();

            paymentFormPage.selectTodayFromCalendar();
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            paymentFormPage.clickOnFinalPaymentDueDateCalendarInput();

            paymentFormPage.selectTodayFromCalendar();

        }

    }

    /**
     * 
     * @param date
     *            date
     */
    @Then("^I should see today's date displayed in the \"([^\"]*)\" fields$")
    public void verifyTodaysDateIsDisplayedInFields(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {

            Assert.assertTrue("Final Deposit date input is not displaying today's date after clicking Today button", paymentFormPage.getPageElements()
                                                                                                                                    .getFinalDepositDateCalendarEnableMode()
                                                                                                                                    .getAttribute(
                                                                                                                                            "value")
                                                                                                                                    .contains(
                                                                                                                                            paymentFormPage.getCurrentDate()));

        }
        if (date.equalsIgnoreCase("final payment due date")) {

            Assert.assertTrue("Final Payment Due date input is not displaying today's date after clicking Today button",
                    paymentFormPage.getPageElements()
                                   .getFinalPaymentDueDateCalendarEnableMode()
                                   .getAttribute("value")
                                   .contains(paymentFormPage.getCurrentDate()));

        }

    }

    /**
     * 
     * @param date
     *            date
     */
    @When("^I edit the \"([^\"]*)\" by clicking on clear$")
    public void editDateByClickingOnClear(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            paymentFormPage.clickOnFinalDepositDateCalendarInput();

            paymentFormPage.selectClearForCalendar();
        }
        if (date.equalsIgnoreCase("final payment due date")) {
            paymentFormPage.clickOnFinalPaymentDueDateCalendarInput();

            paymentFormPage.selectClearForCalendar();

        }

    }

    /**
     * 
     * @param date
     *            date
     */
    @Then("^I should see date input empty in \"([^\"]*)\" fields$")
    public void verifyDateInputIsEmpty(final String date) {

        if (date.equalsIgnoreCase("final deposit date")) {
            Assert.assertTrue("Final Deposit date input is not cleared after clicking clear button", paymentFormPage.getPageElements()
                                                                                                                    .getFinalDepositDateCalendarEnableMode()
                                                                                                                    .getAttribute("value")
                                                                                                                    .isEmpty());

        }
        if (date.equalsIgnoreCase("final payment due date")) {
            Assert.assertTrue("Final Paymnent Due date input is not cleared after clicking clear button", paymentFormPage.getPageElements()
                                                                                                                         .getFinalPaymentDueDateCalendarEnableMode()
                                                                                                                         .getAttribute("value")
                                                                                                                         .isEmpty());

        }

    }
}