package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.Utilities;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Cost;
import com.statravel.autoqa.domain.b2b.paymentform.PaymentForm;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormListPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;
import com.statravel.autoqa.page.b2b.paymentform.modal.FlightsPage;
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
public class CreateFormWithCost {

    @Autowired
    private PaymentFormTest paymentFormTest;

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private PaymentFormListPage paymentFormListPage;

    @Autowired
    private CostTest costTest;

    @Autowired
    private Utilities utilities;

    @Autowired
    private FlightsTest flightsTest;

    @Autowired
    private FlightsPage flightsPage;

    @Autowired
    private AccomodationTest accomodationTest;

    @Autowired
    private SeatMealAddressPassInfoTest seatMealAddressPassInfoTest;

    @Autowired
    private TransferTest transferTest;

    @Autowired
    private OthersTest othersTest;

    @Autowired
    private CancellationFeesTest cancellationFeesTest;

    @Autowired
    private ExtraTest extraTest;

    @Autowired
    private MiscProductTest miscProductTest;

    @Autowired
    private StopOverTest stopOverTest;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private PaymentForm paymentForm;

    private Cost cost;

    private String formName, partnerName, id;

    /**
     * 
     */
    @Before
    public void init() {
        flightsPage.init();
        paymentFormListPage.init();
        paymentFormPage.init();
    }

    /**
     * 
     */
    @Given("^I see required messages in all payment form required fields$")
    public void verifyRequiredMessagesAreDisplayedForAllPaymentFormRequiredFields() {
        paymentFormTest.verifyRequiredMessagesIsDisplayedForPartnerInformationRequiredFields();
        costTest.verifyAtLeastOneCostRequiredMessagesIsDisplayedForAllCostFields();
        paymentFormTest.verifyRequiredMessagesIsDisplayedForAllTravelInformationRequiredFields();

    }

    /**
     * 
     */
    @When("^I activate all the required fields that needs activation$")
    public void activateAllActivationRequiredFields() {
        paymentFormPage.toggleFlightAmountSectionInactiveMode();
        paymentFormPage.toggleAirFareAmountSectionInactiveMode();
        paymentFormPage.toggleTaxesAmountSectionInactiveMode();
        paymentFormPage.toggleTermsAndConditionInactiveMode();
        paymentFormPage.toggleAccommodationAmountSectionInactiveMode();
        paymentFormPage.toggleTransferAmountSectionInactiveMode();
        paymentFormPage.toggleOtherAmountSectionInactiveMode();
        paymentFormPage.toggleDepositAmountSectionInactiveMode();
        paymentFormPage.toggleBalanceSectionInactiveMode();
        paymentFormPage.toggleFlightSection();
        paymentFormPage.toggleAccommodationActiveBarInactiveMode();
        paymentFormPage.toggleTransferSection();
        paymentFormPage.toggleOthersSectionActiveBarInactiveMode();
        paymentFormPage.toggleFinalDepositDateInactiveMode();
        paymentFormPage.toggleFinalPaymentDueDateInactiveMode();
        paymentFormPage.toggleImportantInstructionActiveBarActiveMode();
        paymentFormPage.toggleCancelltionFeesSectionActiveBarInactiveMode();
        paymentFormPage.toggleExtrasSection();
        paymentFormPage.toggleMiscProduct();
        paymentFormPage.toggleStopOver();
        paymentFormPage.toggleSeatPreferenceInactiveMode();
        paymentFormPage.toggleMealPreferenceInactiveMode();

    }

    /**
     * 
     */
    @When("^I save the payment form without filling details in all required fields$")
    public void savePaymentFormWithoutFillingDetailsInAllRequiredFields() {
        paymentFormPage.createPaymentForm();
    }

    /**
     * 
     */
    @Then("^I should see form unsaved with error messages in all the payment form required fields$")
    public void verifyFormUnsavedWithErrorMessagesInAllPaymentFormRequiredFields() {
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.FORM_NAME),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFormNameISRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.PARTNER_NAME),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getPartnerNameIsRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.TRIP_NAME),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTripNameIsRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.FLIGHT_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFlightAmountRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.AIRFARE_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAirFareAmountRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.TAXES_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTaxesAmountRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.TERMS_CONDITION),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTermsAndConditionRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.ACCOMMODATION_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAccommodationAmountRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.TRANSFER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTranferAmountRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.OTHER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOtherAmountRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.DEPOSIT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDepositAmountRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.TRAVEL_HEADING),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTravelHeadingIsRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.TRAVEL_INTRO),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTravelIntroIsRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.FLIGHT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFlightsAreRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.ACCOMMODATION),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAccommodationIsRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.TRANSFER),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTransferRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.OTHERS),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOthersDetailsRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.FINAL_DEPOSIT_DUE_DATE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFinalDepositRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFinalPaymentDueDateRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.IMPORTANT_INSTRUCTION),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getImportantInstructionRequireErrorMsg()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.CANCELLATION_FEES),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getCancellationFeesRequreErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.EXTRA),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getExtraIsRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.MISC_PRODUCT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getMiscProductIsRequreErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.MISC_PRODUCT_NAME),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getMiscProductTitleNameIsRequireErrorMessage()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_ERROR_MESSAGE, AssertionMessages.STOPOVER),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getStopOverRequireErrorMessage()));

    }

    /**
     * 
     */
    @When("^I fill in details for required modules$")
    public void fillInDetailsForRequiredModules() {

        paymentFormPage.fillRequiredFields();

        formName = paymentFormPage.getPageElements()
                                  .getFormNameInput()
                                  .getAttribute("value");

        partnerName = paymentFormPage.getPageElements()
                                     .getPartnerNameInput()
                                     .getAttribute("value");
    }

    /**
     * 
     */
    @When("^I fill in details for required modules selecting only flights cost$")
    public void fillInDetailsForRequiredModulesSelectingOnlyFlightsCost() {

        fillInDetailsForRequiredModules();

        paymentFormPage.toggleFlightAmountSectionInactiveMode();

        cost = new Cost.CostBuilder().setFlightAmountActive(true)
                                     .setFlightAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);

    }

    /**
     * 
     */
    @When("^I fill in details for required modules selecting only accommodation cost$")
    public void fillInDetailsForRequiredModulesSelectingOnlyAccomodationCost() {

        fillInDetailsForRequiredModules();

        paymentFormPage.toggleAccommodationAmountSectionInactiveMode();

        cost = new Cost.CostBuilder().setAccommodationAmountActive(true)
                                     .setAccommodationAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);

    }

    /**
     * 
     */
    @When("^I fill accommodation cost$")
    public void fillAccommodationCost() {

        paymentFormPage.toggleAccommodationAmountSectionInactiveMode();

        cost = new Cost.CostBuilder().setAccommodationAmountActive(true)
                                     .setAccommodationAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);
    }

    /**
     * 
     */
    @When("^I fill in details for required modules selecting only transfer cost$")
    public void fillInDetailsForRequiredModulesSelectingOnlyTransferCost() {

        fillInDetailsForRequiredModules();

        paymentFormPage.toggleTransferAmountSectionInactiveMode();

        cost = new Cost.CostBuilder().setTransferAmountActive(true)
                                     .setTransferAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);
    }

    /**
     * 
     */
    @When("^I fill in details for required modules selecting only others cost$")
    public void fillInDetailsForRequiredModulesSelectingOnlyOthersCost() {

        fillInDetailsForRequiredModules();

        paymentFormPage.toggleOtherAmountSectionInactiveMode();

        cost = new Cost.CostBuilder().setOtherAmountActive(true)
                                     .setOtherAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);
    }

    /**
     * 
     */
    @When("^I save payment form$")
    public void savePaymentForm() {
        paymentFormPage.createPaymentForm();
    }

    /**
     * @throws InterruptedException
     * 
     */
    @Then("^I should see form saved on payment forms current forms list with a unique url$")
    public void verifyFormSavedOnPaymentFormsCurrentFormsListWithUniqueURL() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormListPage.isPageLoaded());

        paymentFormListPage.scrollToFirstForm();

        id = paymentFormListPage.getIdFromPaymentFormListPage();

        Assert.assertTrue("In payment forms list, First Form Name confirmation does not contaian same form name as given in form",
                paymentFormListPage.getPageElements()
                                   .getFirstFormNameConfirmation()
                                   .getText()
                                   .contains(formName));
        Assert.assertTrue("In payment forms list, URL confirmation does not contaian same partner name as given in form",
                paymentFormListPage.getPageElements()
                                   .getFirstFormUrlConfirmation()
                                   .getText()
                                   .contains(partnerName));
        Assert.assertTrue("In payment forms list, URL confirmation does not contaian unique generated ID for that form",
                paymentFormListPage.getPageElements()
                                   .getFirstFormUrlConfirmation()
                                   .getText()
                                   .contains("/" + id));

    }

    /**
     * 
     * @param flightDetails
     *            flight details
     */
    @When("^I add new \"([^\"]*)\" flight$")
    public void addNewFlight(final String flightDetails) {
        paymentFormPage.toggleFlightSection();

        if (flightDetails.equalsIgnoreCase("Getting There")) {
            paymentFormPage.editGettingThereFlightDetails();
        } else if (flightDetails.equalsIgnoreCase("Getting Around")) {
            paymentFormPage.editGettingAroundFlightDetails();
        } else if (flightDetails.equalsIgnoreCase("Getting Back")) {
            paymentFormPage.editGettingBackFlightDetails();
        }

        flightsTest.enterFlightOneDetails();

        flightsPage.save();
    }

    /**
     * 
     */
    @When("^I add a new getting there flight$")
    public void addNewGettingThereFlight() {
        paymentFormPage.toggleFlightSection();

        paymentFormPage.editGettingThereFlightDetails();

        flightsTest.enterFlightOneDetails();

        flightsPage.save();

    }

    /**
     * 
     */
    @Then("^I should see flight and accommodation modules still selected$")
    public void verifyFlightAndAccommodationModulesStillSelected() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

        Assert.assertTrue("Flight active bar inactive but expected active", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                        .getFlightsActiveBarActiveMode()));
        Assert.assertTrue("Accommodation active bar inactive but expected active", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                               .getAccommodationActiveBarActiveMode()));

    }

    /**
     * 
     */
    @Then("^I should see flight, extra and stopover modules still selected$")
    public void verifyFlightExtraAndStopoverModulesStillSelected() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());
        Assert.assertTrue("Flight active bar inactive but expected active", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                        .getFlightsActiveBarActiveMode()));
        Assert.assertTrue("Extras active bar inactive but expected active", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                        .getExtraActivebarActiveMode()));
        Assert.assertTrue("Stopover active bar inactive but expected active", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                          .getStopOverActiveBarActiveMOde()));

    }

    /**
     * 
     */
    @Then("^I should not see required messages on all other required fields$")
    public void verifyRequiredMessagesIsNotDisplayedOnAllRequiredFields() {
        paymentFormTest.verifyRequiredMessagesIsNotDisplayedForPartnerInformationRequiredFields();
        paymentFormTest.verifyRequiredMessagesIsNotDisplayedForAllTravelInformationRequiredFields();
    }

    /**
     * 
     */
    @When("^I select save on the payment form$")
    public void selectSaveOnPaymentForm() {
        paymentFormPage.createPaymentForm();
    }

    /**
     * 
     */
    @Then("^I should see form unsaved with error message on all the required cost fields$")
    public void verifyFormNotSavedWithErrorMessageOnAllRequiredCostFields() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE_ERROR_MESSAGE, AssertionMessages.FLIGHT_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireErrorMessageForFlight()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE_ERROR_MESSAGE,
                        AssertionMessages.ACCOMMODATION_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireErrorMessageForAccommodation()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE_ERROR_MESSAGE,
                        AssertionMessages.TRANSFER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireErrorMessageForTranfer()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE_ERROR_MESSAGE, AssertionMessages.OTHER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireErrorMessageForOther()));
    }

    /**
     * 
     */
    @When("^I save form with cost filled in one of the required cost fields$")
    public void saveFormWithCostFilledInOneOfTheRequiredCostFields() {

        paymentFormPage.toggleOtherAmountSectionInactiveMode();

        cost = new Cost.CostBuilder().setOtherAmountActive(true)
                                     .setOtherAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);

        paymentFormPage.createPaymentForm();
    }

    /**
     * 
     */
    @When("^I select quote option$")
    public void selectQuoteOption() {
        paymentFormPage.toggleQuoteInactiveBar();
    }

    /**
     * 
     */
    @When("^I save the payment form without selecting other payment options$")
    public void savePaymentFormWithoutSelectingOtherPaymentOptions() {
        selectSaveOnPaymentForm();
    }

    /**
     * 
     */
    @When("^I select edit form$")
    public void selectEditForm() {
        paymentFormListPage.selectFirstFormEdit();
    }

    /**
     * 
     */
    @Then("^I should see quote selected$")
    public void verifyQuoteOptionsIsSelected() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.QUOTE,
                        AssertionMessages.INACTICE_MODE, AssertionMessages.ACTICE_MODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getQuoteActiveBarActiveMode()));

    }

    /**
     * 
     */
    @When("^I fill in details for required modules with flight and deposit$")
    public void fillInDetailsForRequiredModulesWithFlightAndDeposit() {
        fillInDetailsForRequiredModulesSelectingOnlyFlightsCost();

        paymentFormPage.toggleDepositAmountSectionInactiveMode();

        cost = new Cost.CostBuilder().setDepositAmountActive(true)
                                     .setDepositAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);
    }

    /**
     * 
     */
    @When("^I activate final deposit date section$")
    public void activateFinalDepositDateSection() {
        paymentFormPage.toggleFinalDepositDateInactiveMode();
    }

    /**
     * 
     */
    @When("^I enter the dates in the final deposit date field$")
    public void enterheDatesInheFinalDepositDateField() {
        paymentFormTest.enterDatesInTheDateField("final deposit date");
    }

    /**
     * 
     */
    @When("^I activate final payment date section$")
    public void activateFinalPaymentDateSection() {
        paymentFormPage.toggleFinalPaymentDueDateInactiveMode();
    }

    /**
     * 
     */
    @When("^I enter the dates in the final payment date field$")
    public void enterDatesInTheFinalPaymentDateField() {
        paymentFormTest.enterDatesInTheDateField("final payment due date");
    }

    /**
     * 
     */
    @Then("^deposit and balance is not selected$")
    public void verifyDepositAndBalanceIsNotSelected() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.DEPOSIT,
                        AssertionMessages.ACTICE_MODE, AssertionMessages.INACTICE_MODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDepositAmountActiveBarInactiveMode()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.BALANCE,
                        AssertionMessages.ACTICE_MODE, AssertionMessages.INACTICE_MODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getBalanceAmountActiveBarInactiveMode()));
    }

    /**
     * 
     */
    @Then("^I should see that accommodation cost, deposit and balance section are selected$")
    public void verifyAccommodationCostDepositAndBalanceIsSelected() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.ACCOMMODATION_COST,
                        AssertionMessages.INACTICE_MODE, AssertionMessages.ACTICE_MODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAccommodationAmountActiveBarActiveMode()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.DEPOSIT,
                        AssertionMessages.INACTICE_MODE, AssertionMessages.ACTICE_MODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDepositAmountActiveBarActiveMode()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.BALANCE,
                        AssertionMessages.INACTICE_MODE, AssertionMessages.ACTICE_MODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getBalanceAmountActiveBarActiveMode()));

    }

    /**
     * 
     */
    @Then("^quote option is not selected$")
    public void verifyQuoteOptionIsNotSelected() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_ACTIVE_BAR, AssertionMessages.QUOTE,
                        AssertionMessages.ACTICE_MODE, AssertionMessages.INACTICE_MODE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getQuoteActiveBarInactiveMode()));
    }

    /**
     * 
     */
    @When("^I add a new getting around flight$")
    public void addNewGettingAroundFlight() {
        paymentFormPage.toggleFlightSection();

        paymentFormPage.editGettingAroundFlightDetails();

        flightsTest.enterFlightOneDetails();

        flightsPage.save();

    }

    /**
     * 
     */
    @When("^I fill in details for all fields$")
    public void fillInDetailsForAllFields() {
        paymentFormPage.toggleQuoteInactiveBar();
        paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("Auto name" + utilities.getRandomIntUnderTwoHundred())
                                                          .setPartnerName("Auto-name" + utilities.getRandomIntUnderTwoHundred())
                                                          .setPartnerLogo("https://www.umich.edu/skins/um2013/media/images/umich-logo.png")
                                                          .setTripName("Auto trip name")
                                                          .setTravelHeading("Auto heading")
                                                          .setTravelIntro("Auto inro")
                                                          .setFinalPaymentDateActive(true)
                                                          .setFinalPaymentDescription("Auto payment description")
                                                          .setFinalDepositDateActive(true)
                                                          .setFinalDepositDescription("Auto final dep description")
                                                          .setImportantInstructionDescription("Auto Imp Instruction")
                                                          .build();
        paymentFormPage.toggleFinalDepositDateInactiveMode();
        paymentFormPage.toggleFinalPaymentDueDateInactiveMode();
        paymentFormPage.toggleImportantInstructionActiveBarInactiveMode();
        paymentFormPage.fillDetailsForPaymentForm(paymentForm);
        formName = paymentFormPage.getFormNameFormPaymentFormPage();
        partnerName = paymentFormPage.getPartnerNameFormPaymentFormPage();
        costTest.selectAllCostOptions();
        costTest.fillInCostDetailsForAllCost();
        costTest.activateBalanceSection();
        flightsTest.activateFlightSection();
        flightsTest.addFlightForGettingThere();
        flightsTest.addFlightForGettingAround();
        flightsTest.addFlightForGettingBack();
        accomodationTest.activateAccommodationSection();
        accomodationTest.addNewAccommodation();
        transferTest.activateTransferSection();
        transferTest.addNewTransportDetails();
        othersTest.activateOtheres();
        othersTest.addOthers();
        cancellationFeesTest.activateCancellationFees();
        cancellationFeesTest.addCancellationFees();
        cancellationFeesTest.filDetailsForLegalCopy();
        seatMealAddressPassInfoTest.selectOptionsFromPassengerInformationDropdown();
        seatMealAddressPassInfoTest.selectOptionsFromAddressDropdown();
        extraTest.addNewExtra();
        miscProductTest.addNewMiscProduct();
        stopOverTest.addNewStopover();
        seatMealAddressPassInfoTest.verifySeatPreferencesAreAddedByDefault();
        seatMealAddressPassInfoTest.activateSeatPreferenceSection();
        seatMealAddressPassInfoTest.verifyMealPreferencesAreAddedByDefault();
        seatMealAddressPassInfoTest.activateMealPreferenceSection();
    }

}
