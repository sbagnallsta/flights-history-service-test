package com.statravel.autoqa.b2bPaymentFormUI;

import java.text.MessageFormat;
import java.text.ParseException;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.paymentformsui.commons.AutomationConstant;
import com.statravel.autoqa.paymentformsui.commons.PaymentFormsAsseartionMessages;
import com.statravel.autoqa.paymentformsui.commons.Utilities;
import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;
import com.statravel.autoqa.paymentformsui.commons.WebDriverFactory;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentForm;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentFormsBuilder;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.TravelInformationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage.ConfirmationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.AddressPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.ExtraPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.FinalDepositAndFinalPaymentPaymentFormPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.PassengerInformationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.PaymentFormPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.StopoverPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.paymentPopUp.PaymentPopUpPage;
import com.statravel.autoqa.paymentformsui.repository.PaymentFormConfigureRepository;
import com.statravel.autoqa.paymentformsui.repository.PaymentFormRepository;
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
public class PaymentScenarioTest {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private PaymentFormRepository paymentFormRepository;

    @Autowired
    private PaymentFormsBuilder paymentFormsBuilder;

    @Autowired
    private PaymentFormConfigureRepository paymentFormConfigureRepository;

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private ExtraPage extraPage;

    @Autowired
    private StopoverPage stopoverPage;

    @Autowired
    private AddressPage addressPage;

    @Autowired
    private PassengerInformationPage passengerInformationPage;

    @Autowired
    private ConfirmationPage confirmationPage;

    @Autowired
    private FinalDepositAndFinalPaymentPaymentFormPage finalDepositAndFinalPaymentPaymentFormPage;

    @Autowired
    private PaymentPopUpPage paymentPopUpPage;

    @Autowired
    private Utilities utilities;

    private PaymentForm savedForm;

    private String uniqueUrl;

    /**
     * 
     */
    @Before
    public void init() {
        paymentFormPage.init();
        extraPage.init();
        stopoverPage.init();
        addressPage.init();
        passengerInformationPage.init();
        confirmationPage.init();
        finalDepositAndFinalPaymentPaymentFormPage.init();
        paymentPopUpPage.init();
    }

    /**
     * @throws ParseException
     *             ParseException
     * 
     */
    @Given("^Form is created with Flight cost deposit and balance selected$")
    public void createAwFormWithFlightCostDepositAndBalanceSelected() throws ParseException {

        savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_WITH_DEPOSIT_AND_BALANCE_ONLY));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is created with accommoadation cost$")
    public void createFormWithAccommoadationCost() throws ParseException {

        savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.ACCOMMODATION_COST_WITH_QUOTE));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @When("^I select unique url$")
    public void selectUniqueUrl() {
        WebDriverFactory.getWebDriver()
                        .get(uniqueUrl);

    }

    /**
     *
     */
    @Then("^I should only see the quote option$")
    public void verifyOnlyQuoteOptionIsDisplayed() {

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DISPLAYED_WITHOUT_SELECTING_IN_PAYMENT_FORM,
                        AutomationConstant.BALANCE_OPTION, PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                travelInformationPage.getPageElements()
                                     .getBalanceButton()
                                     .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DISPLAYED_WITHOUT_SELECTING_IN_PAYMENT_FORM,
                        AutomationConstant.DEPOSIT_OPTION, PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                travelInformationPage.getPageElements()
                                     .getDepositButton()
                                     .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DISPLAYED_WITHOUT_SELECTING_IN_PAYMENT_FORM,
                        AutomationConstant.FULL_PAYMENT_OPTION, PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                travelInformationPage.getPageElements()
                                     .getFullPaymentButton()
                                     .isDisplayed());

    }

    /**
     * 
     */
    @Then("^I should be on front end payment form page$")
    public void verifyFrontEndPaymentFormIsDisplayed() {
        Assert.assertTrue(PaymentFormsAsseartionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormPage.isPageLoaded());
        if (savedForm.isQuoteActive()) {
            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE,
                            PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getQuteRequestHeading()));

        } else {
            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getPaymentFormHeading()));
        }

    }

    /**
     * 
     */
    @Then("^I should be on quote request page$")
    public void verifyQuoteRequestPageIsDisplayed() {

        Assert.assertTrue(PaymentFormsAsseartionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormPage.isPageLoaded());

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE,
                        PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getQuteRequestHeading()));
    }

    /**
     * 
     */
    @Then("^I should see quote payment option on the front end payment form page$")
    public void verifyQuotePaymentOptionOnFrontEndPaymentFormPageIsDisplayed() {

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.BUTTON_NOT_CONTAINING_TEXT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE, AutomationConstant.SUBMIT_A_QUOTE_REQUEST_TEXT),
                AutomationConstant.SUBMIT_A_QUOTE_REQUEST_TEXT, webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                        .getSubmitButton()));

    }

    /**
     * 
     */
    @When("^I fill in details for all require field on page$")
    public void fillInDetailsForAllRequireFieldOnPage() {
        paymentFormPage.selectGender(AutomationConstant.GENDER_MALE);
        passengerInformationPage.fillPassengerInformation("required for form");
        paymentFormPage.selectTermsAndCondition();

    }

    /**
     * 
     */
    @When("^I submit quote request$")
    public void selectSubmitQuoteRequest() {
        paymentFormPage.selectSubmitButton();
    }

    /**
     * 
     */
    @When("^I select pay deposit now$")
    public void selectPayDepositNow() {
        paymentFormPage.selectSubmitButton();
    }

    /**
     * 
     */
    @When("^I select pay balance now$")
    public void selectPayBalanceNow() {
        paymentFormPage.selectSubmitButton();
    }

    /**
     * 
     */
    @When("^I select pay full amount now$")
    public void selectPayFullAmountNow() {
        paymentFormPage.selectSubmitButton();
    }

    /**
     * 
     */
    @Then("^I should be on the confirmation page$")
    public void verifyConfirmationPageIsDisplayed() {
        Assert.assertTrue(PaymentFormsAsseartionMessages.PAGE_NOT_LOADED_CONFIRMATION_PAGE, confirmationPage.isPageLoaded());

    }

    /**
     * 
     */
    @Then("^I should see the details for quote request on confirmation page and sidebar$")
    public void verifyQuoteRequestDetailsDisplayesOnConfirmationPageAndSidebar() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR_ON_CONFORMATION_PAGE,
                        PaymentFormsAsseartionMessages.ACCOMMODATION),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getAccommodationHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_ON_CONFORMATION_PAGE_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.ACCOMMODATION, PaymentFormsBuilder.ACCOMMODATION_AMOUNT),
                PaymentFormsBuilder.ACCOMMODATION_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getAccommodationAmountForSideBar())));

        Assert.assertEquals(PaymentFormsBuilder.ACCOMMODATION_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getPaidFullAmount())));

        Assert.assertEquals(PaymentFormsBuilder.ACCOMMODATION_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getPaidFullAmountForSideBar())));

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see three payment types on the travel information page$")
    public void verifyThreePaymentTypesDisplayedOnTravelInformationPage() {
        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, AutomationConstant.BALANCE_OPTION),
                webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                  .getBalanceButton()));

        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, AutomationConstant.DEPOSIT_OPTION),
                webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                  .getDepositButton()));

        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, AutomationConstant.FULL_PAYMENT_OPTION),
                webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                  .getFullPaymentButton()));
    }

    /**
     * 
     */
    @When("^I select deposit as payment option$")
    public void selectDepositAsPaymentOption() {
        travelInformationPage.selectPaymentOption(AutomationConstant.DEPOSIT_OPTION);

    }

    /**
     * 
     */
    @Then("^I should be on frontend Payment form page$")
    public void verifyFrontendPaymentFormIsDisplayed() {
        Assert.assertTrue(PaymentFormsAsseartionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormPage.isPageLoaded());

        if (savedForm.isQuoteActive()) {
            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE,
                            PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getQuteRequestHeading()));

        } else {
            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getPaymentFormHeading()));
        }

    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     * 
     */
    @Then("^I should be on quick payment pop up page$")
    public void verifyQuickPaymentPopUpPageIsDisplayed() throws InterruptedException {

        webDriverCommons.swithToFrame(0);

        Assert.assertTrue(PaymentFormsAsseartionMessages.PAGE_NOT_LOADED_PAYMENT_POP_UP_PAGE, paymentPopUpPage.isPageLoaded());

    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     */
    @When("^I complete payment on quick payment pop up page$")
    public void completePaymentOnQuickPaymentPopUpPageWithDepositAmount() throws InterruptedException {
        paymentPopUpPage.fillPaymentDetails();
    }

    /**
     * 
     */
    @Then("^I should see paid balance amount on the confirmation page and side bar$")
    public void verifyPaidBalanceAmountDisplayedOnConfirmationPageAndSideBar() {

        Double balance = PaymentFormsBuilder.FLIGHT_AMOUNT - PaymentFormsBuilder.DEPOSIT_AMOUNT;

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_PAID_AMOUNT_NOT_CONTAINING_AMOUNT_AS_EXPECTED, balance),
                balance, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                        .getPaidBalanceAmount())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_PAID_AMOUNT_ON_SIDE_BAR_NOT_CONTAINING_AMOUNT_AS_EXPECTED, balance),
                balance, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                        .getPaidBalanceAmountForSideBar())));
    }

    /**
     * 
     */
    @Then("^I should see paid deposit amount on the confirmation page and side bar$")
    public void verifyPaidDepositAmountDisplayedOnConfirmationPageAndSideBar() {
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_PAID_AMOUNT_NOT_CONTAINING_AMOUNT_AS_EXPECTED,
                        PaymentFormsBuilder.DEPOSIT_AMOUNT),
                PaymentFormsBuilder.DEPOSIT_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                                   .getPaidDepositAmount())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_PAID_AMOUNT_ON_SIDE_BAR_NOT_CONTAINING_AMOUNT_AS_EXPECTED,
                        PaymentFormsBuilder.DEPOSIT_AMOUNT),
                PaymentFormsBuilder.DEPOSIT_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                                   .getPaidDepositAmountForSideBar())));
    }

    /**
     * 
     */
    @Then("^I should see the Total price on the confirmation page and side bar same as flight cost$")
    public void verifyTotalPriceIsDisplayedOnConfirmationPageAndSideBarSameAsFlightCost() {

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.TOTAL_PRICE_FOR_BOOKING_AMOUNT, PaymentFormsAsseartionMessages.CONFORMATION_PAGE,
                        PaymentFormsBuilder.FLIGHT_AMOUNT),
                PaymentFormsBuilder.FLIGHT_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                                  .getTotalPriceForBookingAmount())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.TOTAL_PRICE_FOR_BOOKING_AMOUNT, PaymentFormsAsseartionMessages.CONFORMATION_PAGE,
                        PaymentFormsBuilder.FLIGHT_AMOUNT),
                PaymentFormsBuilder.FLIGHT_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                                  .getTotalPriceForBookingAmountForSideBar())));

        paymentFormRepository.delete(savedForm.getId());

    }

    /**
     * 
     */
    @Then("^I should see the remaining balance confirmation page$")
    public void verifyRemainingBalanceDisplayedOnCnfirmationPage() {
        Double remainingAmount = PaymentFormsBuilder.FLIGHT_AMOUNT - PaymentFormsBuilder.DEPOSIT_AMOUNT;

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.REMAINING_AMOUNT_NOT_CONTAINING_AMOUNT_AS_EXPECTED, remainingAmount),
                remainingAmount, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                .getRemainingAmount())));

    }

    /**
     * 
     */
    @When("^I select balance as payment option$")
    public void selectBalanceAsPaymentOption() {
        travelInformationPage.selectPaymentOption(AutomationConstant.BALANCE_OPTION);
    }

    /**
     * 
     */
    @Then("^I should see payable today amount same as balance on the front end payment form page and side bar$")
    public void verifyPayableTodayAmountContainsSameAmountAsBalanceOnFrontndPaymentFormPageAndSideBar() {
        Double balance = PaymentFormsBuilder.FLIGHT_AMOUNT - PaymentFormsBuilder.DEPOSIT_AMOUNT;

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, PaymentFormsAsseartionMessages.PAYABLE_TODAY_HEADING),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getPayableTodayHeading()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.PAYABLE_TODAY_HEADING_FOR_SIDEBAR),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getPayableTodayHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.BALANCE_AS_PAYMENT_TYPE,
                        PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE, balance),
                balance, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                       .getPayableTodayBalanceAmount())));
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.BALANCE_AS_PAYMENT_TYPE,
                        PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE_SIDE_BAR, balance),
                balance, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                       .getPayableTodayBalanceAmountForSideBar())));
    }

    /**
    *
    *    
     */
    @Then("^I should see payable today amount same as deposit on the front end payment form page and side bar$")
    public void verifyPayableTodayAmountContainsSameAmountAsDepositOnFrontndPaymentFormPageAndSideBar() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, PaymentFormsAsseartionMessages.PAYABLE_TODAY_HEADING),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getPayableTodayHeading()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.PAYABLE_TODAY_HEADING_FOR_SIDEBAR),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getPayableTodayHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.BALANCE_AS_PAYMENT_TYPE,
                        PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE, PaymentFormsBuilder.DEPOSIT_AMOUNT),
                PaymentFormsBuilder.DEPOSIT_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                                                  .getPayableTodayDepositAmount())));
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.BALANCE_AS_PAYMENT_TYPE,
                        PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE_SIDE_BAR, PaymentFormsBuilder.DEPOSIT_AMOUNT),
                PaymentFormsBuilder.DEPOSIT_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                                                  .getPayableTodayDepositAmount())));
    }

    /**
    * 
    */
    @Then("^full amount is selected by default$")
    public void verifyFullAmountIsSelectedByDefault() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_SELECTED_BY_DEFAULT, AutomationConstant.FULL_PAYMENT_OPTION,
                        PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                  .getSelectedFullAmount()));
    }

    /**
     * 
     */
    @Then("^I should see the Total paid amount same as flight amount on confirmation page and side bar$")
    public void verifyTotalPaidAmountIsSameAsFlightAmountOnConfirmationPageAndSideVBar() {
        Assert.assertEquals(PaymentFormsBuilder.FLIGHT_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getPaidFullAmount())));

        Assert.assertEquals(PaymentFormsBuilder.FLIGHT_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getPaidFullAmountForSideBar())));

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     */
    @Given("^Form is created with only flight cost$")
    public void createFormWithOnlyFlightCost() {

        savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.ONLY_FLIGHT_COST));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should not see any payment option$")
    public void verifyAnyPaymentOptionSAreNotDisplayed() {

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DISPLAYED_WITHOUT_SELECTING_IN_PAYMENT_FORM,
                        AutomationConstant.BALANCE_OPTION, PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                travelInformationPage.getPageElements()
                                     .getBalanceButton()
                                     .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DISPLAYED_WITHOUT_SELECTING_IN_PAYMENT_FORM,
                        AutomationConstant.DEPOSIT_OPTION, PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                travelInformationPage.getPageElements()
                                     .getDepositButton()
                                     .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DISPLAYED_WITHOUT_SELECTING_IN_PAYMENT_FORM,
                        AutomationConstant.FULL_PAYMENT_OPTION, PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                travelInformationPage.getPageElements()
                                     .getFullPaymentButton()
                                     .isDisplayed());
    }

}
