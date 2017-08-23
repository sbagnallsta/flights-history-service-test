package com.statravel.autoqa.b2bPaymentFormUI;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Arrays;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.paymentformsui.commons.AutomationConstant;
import com.statravel.autoqa.paymentformsui.commons.PaymentFormsAsseartionMessages;
import com.statravel.autoqa.paymentformsui.commons.Utilities;
import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;
import com.statravel.autoqa.paymentformsui.domain.entity.Extra;
import com.statravel.autoqa.paymentformsui.domain.entity.Flight;
import com.statravel.autoqa.paymentformsui.domain.entity.Misc;
import com.statravel.autoqa.paymentformsui.domain.entity.Others;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentForm;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentFormsBuilder;
import com.statravel.autoqa.paymentformsui.domain.entity.Stopover;
import com.statravel.autoqa.paymentformsui.domain.entity.Transfer;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage.ConfirmationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage.FlightGettingAroundForConfirmationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage.FlightGettingBackForConfirmationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage.FlightGettingThereForConfirmationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.PassengerInformationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.PaymentFormPage;
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
public class ConfirmationPageTest {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private PaymentFormRepository paymentFormRepository;

    @Autowired
    private PaymentFormsBuilder paymentFormsBuilder;

    @Autowired
    private PaymentFormConfigureRepository paymentFormConfigureRepository;

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private ConfirmationPage confirmationPage;

    @Autowired
    private Utilities utilities;

    @Autowired
    private FlightGettingAroundForConfirmationPage flightGettingAroundForConfirmationPage;

    @Autowired
    private FlightGettingBackForConfirmationPage flightGettingBackForConfirmationPage;

    @Autowired
    private FlightGettingThereForConfirmationPage flightGettingThereForConfirmationPage;

    @Autowired
    private PassengerInformationPage passengerInformationPage;

    private PaymentForm paymentFormWithProduct, savedForm;

    private String uniqueUrl;

    /**
     * 
     */
    @Before
    public void init() {
        paymentFormPage.init();
        confirmationPage.init();
        flightGettingAroundForConfirmationPage.init();
        flightGettingBackForConfirmationPage.init();
        flightGettingThereForConfirmationPage.init();
    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is created with flight cost two extras and two stopover options$")
    public void createFormWithFlightCostExtrasAndStopoversOptions() throws ParseException {
        Extra extra1 = new Extra();
        Extra extra2 = new Extra();

        extra1.setTitle(AutomationConstant.FIRST_EXTRA_TITLE);
        extra1.setDescription(AutomationConstant.FIRST_EXTRA_DESCRIPTION);
        extra1.setPrice(AutomationConstant.FIRST_EXTRA_AMOUNNT);

        extra2.setTitle(AutomationConstant.SECOND_EXTRA_TITLE);
        extra2.setDescription(AutomationConstant.SECOND_EXTRA_DESCRIPTION);
        extra2.setPrice(AutomationConstant.SECOND_EXTRA_AMOUNNT);

        Stopover stopover1 = new Stopover();
        Stopover stopover2 = new Stopover();

        stopover1.setTitle(AutomationConstant.FIRST_STOPOVER_TITLE);
        stopover1.setPrice(AutomationConstant.FIRST_STOPOVER_AMOUNNT);

        stopover2.setTitle(AutomationConstant.SECOND_STOPOVER_TITLE);
        stopover2.setPrice(AutomationConstant.SECOND_EXTRA_AMOUNNT);

        savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.EXTRA_AND_STOPOVER,
                Arrays.asList(extra1, extra2, stopover1, stopover2)));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @When("^I enter Unique url$")
    public void enterUniqueUrl() {
        webDriverCommons.enterUrl(uniqueUrl);
    }

    /**
     * 
     */
    @Then("^I should see the extras and stopovers on the confirmation page side bar$")
    public void verifyExtrasAndStopoversAreDisplayedOnConfirmationPageSideBar() {

        Double extraTotal = AutomationConstant.FIRST_EXTRA_AMOUNNT + AutomationConstant.SECOND_EXTRA_AMOUNNT;
        Double stopoverTotal = AutomationConstant.FIRST_STOPOVER_AMOUNNT + AutomationConstant.SECOND_STOPOVER_AMOUNNT;

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.EXTRA),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getExtraHeadingForSidebar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.EXTRA, extraTotal),
                extraTotal, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                           .getTotalExtraAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.FIRST_EXTRA_TITLE),
                AutomationConstant.FIRST_EXTRA_TITLE, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getFirstExtraNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.FIRST_EXTRA_AMOUNNT),
                AutomationConstant.FIRST_EXTRA_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getFirstExtraAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.SECOND_EXTRA_TITLE),
                AutomationConstant.SECOND_EXTRA_TITLE, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                .getSecondExtraNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.SECOND_EXTRA_AMOUNNT),
                AutomationConstant.SECOND_EXTRA_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getSecondExtraAmountForSideBar())));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.STOPOVER),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getStopOverHeadingForSidebar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.STOPOVER, stopoverTotal),
                stopoverTotal, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                              .getTotalStopoverAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.FIRST_STOPOVER_TITLE),
                AutomationConstant.FIRST_STOPOVER_TITLE, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                  .getFirstStopoverNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.FIRST_STOPOVER_AMOUNNT),
                AutomationConstant.FIRST_STOPOVER_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getFirstStopoverAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.SECOND_STOPOVER_TITLE),
                AutomationConstant.SECOND_STOPOVER_TITLE, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                   .getSecondStopoverNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.SECOND_STOPOVER_AMOUNNT),
                AutomationConstant.SECOND_STOPOVER_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getSecondStopoverAmountForSideBar())));

    }

    /**
    * 
    */
    @Then("^I should be on payment form page$")
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
     * 
     */
    @Then("^I should see a confirmation email sent message$")
    public void verifyConfirmationEmailSentMessageIsDisplayed() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.CONFIRMATION_EMAIL_SENT_MESSAGE, PaymentFormsAsseartionMessages.CONFORMATION_PAGE),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getConfirmationEmailBeenSentMessage()));
    }

    /**
     * 
     */
    @Then("^Total price should include flight stopovers and extras cost on confirmation page and side bar$")
    public void verifyTotalPriceOnConfirmationPageAndSidearIncludeFlightsStopoversAndExtrasCost() {

        Double extraTotal = AutomationConstant.FIRST_EXTRA_AMOUNNT + AutomationConstant.SECOND_EXTRA_AMOUNNT;

        Double stopoverTotal = AutomationConstant.FIRST_STOPOVER_AMOUNNT + AutomationConstant.SECOND_STOPOVER_AMOUNNT;

        Double totalAmount = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                            .getTotalPriceAmount()));

        Double totalAmountOnSideBar = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                     .getTotalPriceAmountSideBar()));

        Double totalAmountExpected = (extraTotal + stopoverTotal + PaymentFormsBuilder.FLIGHT_AMOUNT);

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IS_NOT_AS_EXPECTED, totalAmountExpected),
                totalAmountExpected, totalAmount);

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IN_SIDE_BAR_IS_NOT_AS_EXPECTED, totalAmountExpected),
                totalAmountExpected, totalAmountOnSideBar);

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is created with flight and transfer cost with two transfers$")
    public void createFormWithFlightAndTransferCostWithTwoTransfers() throws ParseException {
        Transfer transfer1 = new Transfer();
        Transfer transfer2 = new Transfer();

        transfer1.setActive(true);
        transfer1.setName(AutomationConstant.FIRST_TRANSFER_NAME);
        transfer1.setRoutes(AutomationConstant.FIRST_TRANSFER_ROUTE);
        transfer1.setDepartureDate(utilities.getCurrentDateWithHourAndMin());
        transfer1.setSpecialRemarks(AutomationConstant.SPECIAL_REMARK_FOR_FIRST_TRANSFER);

        transfer2.setActive(true);
        transfer2.setName(AutomationConstant.SECOND_TRANSFER_NAME);
        transfer2.setRoutes(AutomationConstant.SECOND_TRANSFER_ROUTE);
        transfer2.setDepartureDate(utilities.getCurrentDateWithHourAndMin());
        transfer2.setSpecialRemarks(AutomationConstant.SPECIAL_REMARK_FOR_SECOND_TRANSFER);

        paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_AND_TRASFER, AutomationConstant.TRANSFER,
                Arrays.asList(transfer1, transfer2));

        savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_AND_TRASFER,
                AutomationConstant.TRANSFER, Arrays.asList(transfer1, transfer2)));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @Then("^I should see the transfer details on the confirmation page$")
    public void verifyTransferDetailsAreDisplayedOnConfirmationPage() {
        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.TRANSFER),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getTransferHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.FIRST_TRANSFER_NAME),
                AutomationConstant.FIRST_TRANSFER_NAME, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                 .getFirstTransferName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.TRANSFER, utilities.getDateFromDataBase(paymentFormWithProduct.getTransferList()
                                                                                                                     .get(0)
                                                                                                                     .getDepartureDate(),
                                AutomationConstant.TRANSFER)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getTransferList()
                                                                    .get(0)
                                                                    .getDepartureDate(),
                        AutomationConstant.TRANSFER),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFirstTransferDepDate())
                                .replaceAll("[\r\n]+", "")
                                .replaceAll(" ", ""));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_TIME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.TRANSFER, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getTransferList()
                                                                                                                          .get(0)
                                                                                                                          .getDepartureDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getTransferList()
                                                                         .get(0)
                                                                         .getDepartureDate()),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFirstTransferTime())
                                .replaceAll("[\r\n]+", "")
                                .replaceAll(" ", ""));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.FIRST_TRANSFER_ROUTE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFirstTransferRoute())
                                .contains(AutomationConstant.FIRST_TRANSFER_ROUTE));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_SPECIAL_REMARK_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.SPECIAL_REMARK_FOR_FIRST_TRANSFER),
                AutomationConstant.SPECIAL_REMARK_FOR_FIRST_TRANSFER, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                               .getFirstTransferSplRemark()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.SECOND_TRANSFER_NAME),
                AutomationConstant.SECOND_TRANSFER_NAME, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                  .getSecondTransferName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.TRANSFER, utilities.getDateFromDataBase(paymentFormWithProduct.getTransferList()
                                                                                                                     .get(1)
                                                                                                                     .getDepartureDate(),
                                AutomationConstant.TRANSFER)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getTransferList()
                                                                    .get(1)
                                                                    .getDepartureDate(),
                        AutomationConstant.TRANSFER),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getSecondTransferDepDate())
                                .replaceAll("[\r\n]+", "")
                                .replaceAll(" ", ""));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_TIME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.TRANSFER, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getTransferList()
                                                                                                                          .get(1)
                                                                                                                          .getDepartureDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getTransferList()
                                                                         .get(1)
                                                                         .getDepartureDate()),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getSecondTransferTime())
                                .replaceAll("[\r\n]+", "")
                                .replaceAll(" ", ""));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.SECOND_TRANSFER_ROUTE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getSecondTransferRoute())
                                .contains(AutomationConstant.SECOND_TRANSFER_ROUTE));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_SPECIAL_REMARK_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.TRANSFER,
                        AutomationConstant.SPECIAL_REMARK_FOR_SECOND_TRANSFER),
                AutomationConstant.SPECIAL_REMARK_FOR_SECOND_TRANSFER, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                .getSecondTransferSplRemark()));

    }

    /**
     * 
     */
    @Then("^I should see flight and transfer cost on the confirmation page side bar$")
    public void verifyFlightAndTransferCostAreDisplayedOnConfirmationPageSidear() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.FLIGHT),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getFlightHeadingSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.FLIGHT, PaymentFormsBuilder.FLIGHT_AMOUNT),
                PaymentFormsBuilder.FLIGHT_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                                  .getFlightAmountForSideBar())));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.TRANSFER),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getTransferHeadingSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.TRANSFER, PaymentFormsBuilder.TRANSFER_AMOUNT),
                PaymentFormsBuilder.TRANSFER_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                                    .getTransferAmountForSideBar())));
    }

    /**
     * 
     */
    @Then("^Total price should include flight and transfer cost on confirmation page and side bar$")
    public void verifyTotalPriceIncludesFlightAndTransferCostOnConfirmationPageAndSidebar() {

        Double totalAmountExpected = PaymentFormsBuilder.FLIGHT_AMOUNT + PaymentFormsBuilder.TRANSFER_AMOUNT;
        Double totalAmountActual = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                  .getTotalPriceAmount()));

        Double totalAmountActualForSidebar = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                            .getTotalPriceAmountSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IS_NOT_AS_EXPECTED, totalAmountExpected),
                totalAmountExpected, totalAmountActual);

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IS_NOT_AS_EXPECTED, totalAmountExpected),
                totalAmountExpected, totalAmountActualForSidebar);

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see payment form heading on confirmation page$")
    public void verifyPaymentFormHeadingIsDisplayedOnConfirmationPage() {

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_ON_CONFIRMATION_PAGE,
                        PaymentFormsAsseartionMessages.FORM_HEADING),
                savedForm.getTravelHeading(), webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                       .getFormHeading()));

    }

    /**
     * 
     */
    @Then("^I should see payment successful message on confirmation page$")
    public void verifyPaymentSuccessfulMessageIsDisplayedOnConfirmationPage() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.YOUR_PAYMENT_WAS_SUCCESSFUL_MESSAGE, PaymentFormsAsseartionMessages.CONFORMATION_PAGE),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getSuccessFullAmountPaidMessage()));

    }

    /**
     * 
     */
    @Then("^I should see deposit payment successful message on confirmation page$")
    public void verifyDepositPaymentSuccessfulMessageIsDisplayedOnConfirmationPage() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.YOUR_DEPOSIT_WAS_SUCCESSFUL_MESSAGE, PaymentFormsAsseartionMessages.CONFORMATION_PAGE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getSuccessFullAmountPaidMessage())
                                .contains("deposit"));

    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is created with flight cost balance deposit and two misc products$")
    public void createAFormWithFlightCostBalanceDepositAndMiscProducts() throws ParseException {
        Misc misc1 = new Misc();
        misc1.setDescription(AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT);
        misc1.setPrice(AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT);
        misc1.setTitle(AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT);

        Misc misc2 = new Misc();
        misc2.setDescription(AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT);
        misc2.setPrice(AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT);
        misc2.setTitle(AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT);

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.MISC_PRODUCT, Arrays.asList(misc1, misc2)));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see both Misc product details on the confirmation page$")
    public void verifyBothMiscProductSDetailsDispalyedOnConfirmationPage() {
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_HEADING_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.MISC_NAME),
                AutomationConstant.MISC_NAME, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                       .getMiscProductHeadingName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                          .getFirstMiscProductTitle()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT),
                AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                          .getFirstMiscProductDescription()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                           .getSecondMiscProductTitle()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT),
                AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                          .getSecondMiscProductDescription()));

    }

    /**
     * 
     */
    @Then("^I should see both Misc product price on the confirmation page side bar$")
    public void verifyBothMiscroductPriceDisplayedOnConfirmationPageSideBar() {

        Double totalMiscPriceEntered = AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT + AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT;

        Double totalMiscAmountInSideBarDouble = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                               .getMiscProductTotalAmountForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT),
                AutomationConstant.MISC_NAME, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                       .getMiscProductHeadingNameForSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_NOT_UPDATED,
                PaymentFormsAsseartionMessages.MISC_PRODUCT, PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT),
                totalMiscPriceEntered, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                      .getMiscProductTotalAmountForSideBar())));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                          .getFirstMiscProductTitleForSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                           .getSecondMiscProductTitleForSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_AMOUNT_IN_SIDE_BAR_NOT_UPDATED,
                PaymentFormsAsseartionMessages.MISC_PRODUCT), totalMiscPriceEntered, totalMiscAmountInSideBarDouble);

    }

    /**
     * 
     */
    @Then("^Total price should include Misc and flights cost on confirmation page and side bar$")
    public void verifyTotalPriceIncludeSMiscAndFlightsCostOnConfirmationPageAndSideBar() {

        Double totalCostExpected = PaymentFormsBuilder.FLIGHT_AMOUNT + AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT
                + AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT;

        Double totalActualCost = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                .getTotalPriceAmount()));

        Double totalActualCostSidebar = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                                       .getTotalPriceAmountSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                PaymentFormsAsseartionMessages.TOTAL_PAID_AMOUNT, PaymentFormsAsseartionMessages.CONFORMATION_PAGE, totalCostExpected),
                totalCostExpected, totalActualCost);

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                PaymentFormsAsseartionMessages.TOTAL_PAID_AMOUNT_FOR_SIDE_BAR, PaymentFormsAsseartionMessages.CONFORMATION_PAGE, totalCostExpected),
                totalCostExpected, totalActualCostSidebar);

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is created with flight cost and final payment due dates$")
    public void createFormWithFlightCostAndFinalPaymentDueDates() throws ParseException {

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_WITH_DEPOSIT, AutomationConstant.FINAL_PAYMENT));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see the final payment due date warning message at the top and bottom of the confirmation page$")
    public void verifyFinalPaymentDueDateMessageAreDisplayedAtTheTopAndBottomOfTheConfirmationPage() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getFinalPaymentHeadingForTop()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFinalPaymentHeadingForTop())
                                .contains("Payment"));

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFinalPaymentHeadingForTop())
                                .contains("Deposit"));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.TOP,
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE, utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                                                                                  .getFinalPaymentDueDate(),
                                PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE)),
                utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                       .getFinalPaymentDueDate(),
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFinalPaymentDateForTop()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getFinalPaymentHeadingForBottom()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFinalPaymentHeadingForBottom())
                                .contains("Payment"));

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFinalPaymentHeadingForBottom())
                                .contains("Deposit"));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.BOTTOM,
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE, utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                                                                                  .getFinalPaymentDueDate(),
                                PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE)),
                utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                       .getFinalPaymentDueDate(),
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFinalPaymentDateForBottom()));

    }

    /**
     * 
     */
    @Then("^I should see the final payment due date warning message at the bottom of  the confirmation side bar$")
    public void verifyFinalPaymentDueDateMessageDisplayedAtTheBottomOfTheConfirmationSideBar() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getFinalPaymentHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SIDE_BAR,
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE, utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                                                                                  .getFinalPaymentDueDate(),
                                PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE)),
                utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                       .getFinalPaymentDueDate(),
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFinalPaymentDateForSideBar()));

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     * @param flightType
     *            flightType
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with Flight cost and \"([^\"]*)\"$")
    public void createAFormWithFlightCostAndGivenFlightType(final String flightType) throws ParseException {

        Flight flight1 = new Flight();
        Flight flight2 = new Flight();

        flight1.setActive(true);
        flight1.setAirline(AutomationConstant.FIRST_AIRLINE);
        flight1.setOperator(AutomationConstant.FIRST_FLIGHT_OPERATOR);
        flight1.setNumber(AutomationConstant.FIRST_FLIGHT_NUMBER);
        flight1.setDepartureDate(utilities.getCurrentDateWithHourAndMin());
        flight1.setDepartureCity(AutomationConstant.FIRST_DEP_CITY);
        flight1.setDepartureAirport(AutomationConstant.FIRST_DEP_AIRPORT);
        flight1.setDepartureAirportCode(AutomationConstant.FIRST_DEP_AIRPORT_CODE);
        flight1.setArrivalDate(utilities.getNextDate(1));
        flight1.setArrivalCity(AutomationConstant.FIRST_ARRIVAL_CITY);
        flight1.setArrivalAirport(AutomationConstant.FIRST_ARRIVAL_AIRPORT);
        flight1.setArrivalAirportCode(AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE);

        flight2.setActive(true);
        flight2.setAirline(AutomationConstant.SECOND_AIRLINE);
        flight2.setOperator(AutomationConstant.SECOND_FLIGHT_OPERATOR);
        flight2.setNumber(AutomationConstant.SECOND_FLIGHT_NUMBER);
        flight2.setDepartureDate(utilities.getCurrentDateWithHourAndMin());
        flight2.setDepartureCity(AutomationConstant.SECOND_DEP_CITY);
        flight2.setDepartureAirport(AutomationConstant.SECOND_DEP_AIRPORT);
        flight2.setDepartureAirportCode(AutomationConstant.SECOND_DEP_AIRPORT_CODE);
        flight2.setArrivalDate(utilities.getNextDate(2));
        flight2.setArrivalCity(AutomationConstant.SECOND_ARRIVAL_CITY);
        flight2.setArrivalAirport(AutomationConstant.SECOND_ARRIVAL_AIRPORT);
        flight2.setArrivalAirportCode(AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE);

        if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_THERE)) {

            flight1.setType("GETTING_THERE");
            flight2.setType("GETTING_THERE");

            paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.GETTING_THERE,
                    Arrays.asList(flight1, flight2));

            savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.GETTING_THERE,
                    Arrays.asList(flight1, flight2)));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_AROUND)) {

            flight1.setType("GETTING_AROUND");
            flight2.setType("GETTING_AROUND");

            paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.GETTING_AROUND,
                    Arrays.asList(flight1, flight2));

            savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.GETTING_AROUND,
                    Arrays.asList(flight1, flight2)));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_BACK)) {

            flight1.setType("GETTING_BACK");
            flight2.setType("GETTING_BACK");

            paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.GETTING_BACK,
                    Arrays.asList(flight1, flight2));

            savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.GETTING_BACK,
                    Arrays.asList(flight1, flight2)));

        }

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     * @param flightType
     *            flightType
     */
    @Then("^I should see the \"([^\"]*)\" flight on the confirmation page$")
    public void verifyFlightIsDisplayedWithEnteredDetailsOnTravelInfoPage(final String flightType) {

        if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_THERE)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_THERE),
                    webDriverCommons.isDisplayed(flightGettingThereForConfirmationPage.getPageElements()
                                                                                      .getHeading()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.FIRST_FLIGHT_NUMBER),
                    AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                          .getFirstFlightNo()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getFirstDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                    AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                             .getFirstDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.FIRST_DEP_CITY),
                    AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                     .getFirstDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT, AutomationConstant.FIRST_DEP_AIRPORT),
                    AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                        .getFirstDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getFirstDepartureTime()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getFirstArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                                 .getFirstArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.FIRST_ARRIVAL_CITY),
                    AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                         .getFirstArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                            .getFirstArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getFirstArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                    AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                    .getFirstAirline()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.FIRST_FLIGHT_OPERATOR),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getFirstAirlineOperator())
                                    .contains(AutomationConstant.FIRST_FLIGHT_OPERATOR));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.SECOND_FLIGHT_NUMBER),
                    AutomationConstant.SECOND_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                           .getSecondFlightNo()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                    PaymentFormsAsseartionMessages.DEPARTURE_DATE, utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                       .get(1)
                                                                                                                       .getDepartureDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getSecondDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT_CODE),
                    AutomationConstant.SECOND_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                              .getSecondDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.SECOND_DEP_CITY),
                    AutomationConstant.SECOND_DEP_CITY, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                      .getSecondDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT),
                    AutomationConstant.SECOND_DEP_AIRPORT, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                         .getSecondDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                    PaymentFormsAsseartionMessages.DEPARTURE_TIME, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                            .get(1)
                                                                                                                            .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getSecondDepartureTime()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getSecondArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                                  .getSecondArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.SECOND_ARRIVAL_CITY),
                    AutomationConstant.SECOND_ARRIVAL_CITY, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                          .getSecondArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.SECOND_ARRIVAL_AIRPORT),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                             .getSecondArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getSecondArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.SECOND_AIRLINE),
                    AutomationConstant.SECOND_AIRLINE, webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                     .getSecondAirline()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.SECOND_FLIGHT_OPERATOR),
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getSecondAirlineOperator())
                                    .contains(AutomationConstant.SECOND_FLIGHT_OPERATOR));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_AROUND)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_AROUND),
                    webDriverCommons.isDisplayed(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                       .getHeading()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.FIRST_FLIGHT_NUMBER),
                    AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                           .getFirstFlightNo()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                    PaymentFormsAsseartionMessages.DEPARTURE_DATE, utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                       .get(0)
                                                                                                                       .getDepartureDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getFirstDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                    AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                              .getFirstDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.FIRST_DEP_CITY),
                    AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                      .getFirstDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT, AutomationConstant.FIRST_DEP_AIRPORT),
                    AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                         .getFirstDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                    PaymentFormsAsseartionMessages.DEPARTURE_TIME, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                            .get(0)
                                                                                                                            .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getFirstDepartureTime()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getFirstArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                                  .getFirstArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.FIRST_ARRIVAL_CITY),
                    AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                          .getFirstArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                             .getFirstArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getFirstArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                    AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                     .getFirstAirline()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.FIRST_FLIGHT_OPERATOR),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getFirstAirlineOperator())
                                    .contains(AutomationConstant.FIRST_FLIGHT_OPERATOR));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.SECOND_FLIGHT_NUMBER),
                    AutomationConstant.SECOND_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                            .getSecondFlightNo()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                    PaymentFormsAsseartionMessages.DEPARTURE_DATE, utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                       .get(1)
                                                                                                                       .getDepartureDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getSecondDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT_CODE),
                    AutomationConstant.SECOND_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                               .getSecondDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.SECOND_DEP_CITY),
                    AutomationConstant.SECOND_DEP_CITY, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                       .getSecondDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT),
                    AutomationConstant.SECOND_DEP_AIRPORT, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                          .getSecondDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                    PaymentFormsAsseartionMessages.DEPARTURE_TIME, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                            .get(1)
                                                                                                                            .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getSecondDepartureTime()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getSecondArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                                   .getSecondArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.SECOND_ARRIVAL_CITY),
                    AutomationConstant.SECOND_ARRIVAL_CITY, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                           .getSecondArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.SECOND_ARRIVAL_AIRPORT),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                              .getSecondArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getSecondArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.SECOND_AIRLINE),
                    AutomationConstant.SECOND_AIRLINE, webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                                                      .getSecondAirline()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.SECOND_FLIGHT_OPERATOR),
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getSecondAirlineOperator())
                                    .contains(AutomationConstant.SECOND_FLIGHT_OPERATOR));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_BACK)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_BACK),
                    webDriverCommons.isDisplayed(flightGettingBackForConfirmationPage.getPageElements()
                                                                                     .getHeading()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.FIRST_FLIGHT_NUMBER),
                    AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                         .getFirstFlightNo()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getFirstDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                    AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                            .getFirstDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.FIRST_DEP_CITY),
                    AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                    .getFirstDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT, AutomationConstant.FIRST_DEP_AIRPORT),
                    AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                       .getFirstDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getFirstDepartureTime()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(0)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getFirstArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                                .getFirstArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.FIRST_ARRIVAL_CITY),
                    AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                        .getFirstArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                           .getFirstArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getFirstArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                    AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                   .getFirstAirline()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.FIRST_FLIGHT_OPERATOR),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getFirstAirlineOperator())
                                    .contains(AutomationConstant.FIRST_FLIGHT_OPERATOR));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.SECOND_FLIGHT_NUMBER),
                    AutomationConstant.SECOND_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                          .getSecondFlightNo()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getDepartureDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getSecondDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT_CODE),
                    AutomationConstant.SECOND_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                             .getSecondDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.SECOND_DEP_CITY),
                    AutomationConstant.SECOND_DEP_CITY, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                     .getSecondDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT),
                    AutomationConstant.SECOND_DEP_AIRPORT, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                        .getSecondDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getSecondDepartureTime()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT)),
                    utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                        .get(1)
                                                                        .getArrivalDate(),
                            AutomationConstant.FLIGHT),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getSecondArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                                 .getSecondArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.SECOND_ARRIVAL_CITY),
                    AutomationConstant.SECOND_ARRIVAL_CITY, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                         .getSecondArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.SECOND_ARRIVAL_AIRPORT),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                            .getSecondArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getSecondArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.SECOND_AIRLINE),
                    AutomationConstant.SECOND_AIRLINE, webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                                                    .getSecondAirline()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.SECOND_FLIGHT_OPERATOR),
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getSecondAirlineOperator())
                                    .contains(AutomationConstant.SECOND_FLIGHT_OPERATOR));

        }

    }

    /**
     * 
     */
    @When("^I fill in details for all require field including flight terms and conditions on page$")
    public void fillInDetailsForAllRequireFieldOnPage() {
        paymentFormPage.selectGender(AutomationConstant.GENDER_MALE);
        passengerInformationPage.fillPassengerInformation("required for form");
        paymentFormPage.selectTermsAndCondition();
        paymentFormPage.selectTermsAndConditionForFlight();

    }

    /**
     * 
     */
    @Then("^I should see the flight details on the confirmation page sidebar$")
    public void verifyFlightDetailsDisplayedOnTravelInfoSideBar() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.FLIGHT),
                webDriverCommons.isDisplayed(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getFlightHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.FLIGHT, PaymentFormsBuilder.FLIGHT_AMOUNT),
                PaymentFormsBuilder.FLIGHT_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                                                    .getFlightAmountForSideBar())));
        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     * @param flightType
     *            flightType
     */
    @Then("^I should see message of days it takes for plane to arrive for \"([^\"]*)\" on confirmation page$")
    public void verifyMessageOfDaysItTakesForPlaneToArriveIsDisplayed(final String flightType) {

        if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_THERE)) {
            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE,
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getFirstFlightDayIndicator()));

            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE,
                    webDriverCommons.getText(flightGettingThereForConfirmationPage.getPageElements()
                                                                                  .getSecondFlightDayIndicator()));
        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_AROUND)) {
            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE,
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getFirstFlightDayIndicator()));

            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE,
                    webDriverCommons.getText(flightGettingAroundForConfirmationPage.getPageElements()
                                                                                   .getSecondFlightDayIndicator()));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_BACK)) {
            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE,
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getFirstFlightDayIndicator()));

            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE,
                    webDriverCommons.getText(flightGettingBackForConfirmationPage.getPageElements()
                                                                                 .getSecondFlightDayIndicator()));

        }

    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is created with others cost and two others$")
    public void createAFormWithOthersCostAndTwoOthers() throws ParseException {

        Others others1 = new Others();
        Others others2 = new Others();
        others1.setTitle(AutomationConstant.FIRST_OTHERS_TITLE);
        others1.setDescription(AutomationConstant.FIRST_OTHERS_DESCRIPTION);
        others2.setTitle(AutomationConstant.SECOND_OTHERS_TITLE);
        others2.setDescription(AutomationConstant.SECOND_OTHERS_DESCRIPTION);

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.OTHERS, AutomationConstant.OTHERS, Arrays.asList(others1, others2)));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see both Others on the confirmation page$")
    public void verifyBothOthersDisplayedOnTravelInfoPage() {
        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.OTHERS),
                webDriverCommons.isDisplayed(confirmationPage.getPageElements()
                                                             .getOthersHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.FIRST_OTHERS_TITLE),
                AutomationConstant.FIRST_OTHERS_TITLE, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                .getFirstOthersTitle()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.FIRST_OTHERS_DESCRIPTION),
                AutomationConstant.FIRST_OTHERS_DESCRIPTION,

                webDriverCommons.getText(confirmationPage.getPageElements()
                                                         .getFirstOthersTripDetails()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.SECOND_OTHERS_TITLE),
                AutomationConstant.SECOND_OTHERS_TITLE, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                 .getSecondOthersTitle()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.FIRST_OTHERS_DESCRIPTION),
                AutomationConstant.SECOND_OTHERS_DESCRIPTION, webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                                       .getSecondOthersTripDetails()));

    }

    /**
     * 
     */
    @Then("^I should see the Total price on the confirmation page and side bar same as others cost$")
    public void verifyTotalPriceOnConfirmationPageAndSideBarContainSameAmountAsOthersCost() {
        Assert.assertEquals(PaymentFormsBuilder.OTHERS_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getTotalPriceAmount())));

        Assert.assertEquals(PaymentFormsBuilder.OTHERS_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(confirmationPage.getPageElements()
                                                                                               .getTotalPriceAmountSideBar())));

        paymentFormRepository.delete(savedForm.getId());
    }

}
