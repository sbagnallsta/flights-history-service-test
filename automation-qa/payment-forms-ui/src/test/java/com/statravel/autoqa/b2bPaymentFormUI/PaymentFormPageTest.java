package com.statravel.autoqa.b2bPaymentFormUI;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.paymentformsui.commons.AutomationConstant;
import com.statravel.autoqa.paymentformsui.commons.PaymentFormsAsseartionMessages;
import com.statravel.autoqa.paymentformsui.commons.Utilities;
import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;
import com.statravel.autoqa.paymentformsui.commons.WebDriverFactory;
import com.statravel.autoqa.paymentformsui.domain.entity.Extra;
import com.statravel.autoqa.paymentformsui.domain.entity.HtmlField;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentForm;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentFormsBuilder;
import com.statravel.autoqa.paymentformsui.domain.entity.Stopover;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.TravelInformationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.ConfirmationPage.ConfirmationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.AddressPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.ExtraPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.FinalDepositAndFinalPaymentPaymentFormPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.PassengerInformationPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.PaymentFormPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm.StopoverPage;
import com.statravel.autoqa.paymentformsui.repository.HtmlFieldRepository;
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
public class PaymentFormPageTest {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private PaymentFormRepository paymentFormRepository;

    @Autowired
    private HtmlFieldRepository htmlFieldRepository;

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
    private Utilities utilities;

    private PaymentForm savedForm;

    private String uniqueUrl;

    public static final String INVALID_EMAIL_ONE = "John..Doe@gmail.com";

    public static final String INVALID_EMAIL_TWO = "just" + "\"not\"" + "right@@gmail.com";

    public static final String INVALID_EMAIL_THREE = "john.doe@gmail..com";

    public static final String INVALID_EMAIL_FOUR = "Abc.gmail.com";

    public static final String INVALID_EMAIL_FIVE = "this is" + "\"not\"" + "\"allowed@example.com";

    public static final String INVALID_EMAIL_SIX = "John Doe@gmail.com";

    public static final String INVALID_EMAIL_SEVEN = "[k]l@gmail.com";

    public static final String INVALID_EMAIL_EIGHT = "\"";

    public static final String INVALID_EMAIL_FOR_CONFIRM_EMAIL = "Valid@gmail.com";

    public static final String VALID_EMAIL = "valid@gmail.com";

    private Double extraTotal, stopoverTotal;

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
    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost stopovers and extras$")
    public void createAFormWithFlightCostStopoversAndExtras() throws ParseException {
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
    @When("^I select the unique url$")
    public void selectUniqueUrl() {
        WebDriverFactory.getWebDriver()
                        .get(uniqueUrl);

    }

    /**
     * 
     */
    @When("^I proceed to booking$")
    public void proceedToBooking() {
        travelInformationPage.selectBookingButton();
    }

    /**
     * 
     */
    @Then("^I should be on frontend payment form page$")
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

        webDriverCommons.waitForLoad();

    }

    /**
     * 
     */
    @Then("^I should see extras optional fields$")
    public void verifyExtrasOptionalFieldsIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.EXTRA),
                webDriverCommons.isDisplayed(extraPage.getPageElements()
                                                      .getHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.FIRST_EXTRA_TITLE),
                AutomationConstant.FIRST_EXTRA_TITLE, webDriverCommons.getText(extraPage.getPageElements()
                                                                                        .getFirstName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.FIRST_EXTRA_DESCRIPTION),
                AutomationConstant.FIRST_EXTRA_DESCRIPTION, webDriverCommons.getText(extraPage.getPageElements()
                                                                                              .getFirstDescriptions()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.FIRST_EXTRA_AMOUNNT),
                AutomationConstant.FIRST_EXTRA_AMOUNNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(extraPage.getPageElements()
                                                                                                                                .getFirstAmount())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.SECOND_EXTRA_TITLE),
                AutomationConstant.SECOND_EXTRA_TITLE, webDriverCommons.getText(extraPage.getPageElements()
                                                                                         .getSecondName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.SECOND_EXTRA_DESCRIPTION),
                AutomationConstant.SECOND_EXTRA_DESCRIPTION, webDriverCommons.getText(extraPage.getPageElements()
                                                                                               .getSecondDescriptions()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.SECOND_EXTRA_AMOUNNT),
                AutomationConstant.SECOND_EXTRA_AMOUNNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(extraPage.getPageElements()
                                                                                                                                 .getSecondAmount())));
    }

    /**
     * 
     */
    @Then("^I should see stopover optional fields$")
    public void verifyStopoverOptionalFieldsIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.STOPOVER),
                webDriverCommons.isDisplayed(stopoverPage.getPageElements()
                                                         .getHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.FIRST_STOPOVER_TITLE),
                AutomationConstant.FIRST_STOPOVER_TITLE, webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                              .getFirstName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.FIRST_STOPOVER_AMOUNNT),
                AutomationConstant.FIRST_STOPOVER_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                           .getFirstAmount())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.SECOND_STOPOVER_TITLE),
                AutomationConstant.SECOND_STOPOVER_TITLE, webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                               .getSecondName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.SECOND_STOPOVER_AMOUNNT),
                AutomationConstant.SECOND_STOPOVER_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                           .getSecondAmount())));
    }

    /**
     * 
     */
    @When("^I select both extras and stopover optional fields$")
    public void selectExtrasAndStopoverOptionalFields() {
        extraPage.selectBothExtra();
        stopoverPage.selectBothStopover();
    }

    /**
     * 
     */
    @Then("^I should see extras and stopover optional fields highlighted$")
    public void verifyExtrasAndStopoverOptionalFieldsHighlighted() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_BOX_NOT_HIGHLIGHTED_AFTER_SELECTING, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.EXTRA),
                webDriverCommons.isDisplayed(extraPage.getPageElements()
                                                      .getFirstHighlightedProduct()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_BOX_NOT_HIGHLIGHTED_AFTER_SELECTING,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.EXTRA),
                webDriverCommons.isDisplayed(extraPage.getPageElements()
                                                      .getSecondHighlightedProduct()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_BOX_NOT_HIGHLIGHTED_AFTER_SELECTING, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.STOPOVER),
                webDriverCommons.isDisplayed(stopoverPage.getPageElements()
                                                         .getFirstHighlightedProduct()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_BOX_NOT_HIGHLIGHTED_AFTER_SELECTING,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.STOPOVER),
                webDriverCommons.isDisplayed(stopoverPage.getPageElements()
                                                         .getSecondHighlightedProduct()));
    }

    /**
     * 
     */
    @Then("^I should see the extras and stopover optional fields on the payment form side bar$")
    public void verifyExtrasAndStopoverOptionalFieldsDisplayedOnPaymentFormSideBar() {
        extraTotal = AutomationConstant.FIRST_EXTRA_AMOUNNT + AutomationConstant.SECOND_EXTRA_AMOUNNT;
        stopoverTotal = AutomationConstant.FIRST_STOPOVER_AMOUNNT + AutomationConstant.SECOND_STOPOVER_AMOUNNT;

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.EXTRA),
                webDriverCommons.isDisplayed(extraPage.getPageElements()
                                                      .getSideBarHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.EXTRA, extraTotal),
                extraTotal, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(extraPage.getPageElements()
                                                                                                    .getTotalExtraAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.FIRST_EXTRA_TITLE),
                AutomationConstant.FIRST_EXTRA_TITLE, webDriverCommons.getText(extraPage.getPageElements()
                                                                                        .getFirstNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.FIRST_EXTRA_AMOUNNT),
                AutomationConstant.FIRST_EXTRA_AMOUNNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(extraPage.getPageElements()
                                                                                                                                .getFirstAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.SECOND_EXTRA_TITLE),
                AutomationConstant.SECOND_EXTRA_TITLE, webDriverCommons.getText(extraPage.getPageElements()
                                                                                         .getSecondNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.EXTRA, AutomationConstant.SECOND_EXTRA_AMOUNNT),
                AutomationConstant.SECOND_EXTRA_AMOUNNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(extraPage.getPageElements()
                                                                                                                                 .getSecondAmountForSideBar())));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.STOPOVER),
                webDriverCommons.isDisplayed(stopoverPage.getPageElements()
                                                         .getSideBarHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.STOPOVER, stopoverTotal),
                stopoverTotal, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                                          .getTotalStopoverAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.FIRST_STOPOVER_TITLE),
                AutomationConstant.FIRST_STOPOVER_TITLE, webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                              .getFirstNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.FIRST_STOPOVER_AMOUNNT),
                AutomationConstant.FIRST_STOPOVER_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                           .getFirstAmountForSideBar())));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.SECOND_STOPOVER_TITLE),
                AutomationConstant.SECOND_STOPOVER_TITLE, webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                               .getSecondNameForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.STOPOVER, AutomationConstant.SECOND_STOPOVER_AMOUNNT),
                AutomationConstant.SECOND_STOPOVER_AMOUNNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(stopoverPage.getPageElements()
                                                                                           .getSecondAmountForSideBar())));

    }

    /**
     * 
     */
    @Then("^I should see extras and stopover optional prices added to total price on payment form side bar$")
    public void verifyExtrasAndStopoverOptionalPricesAddedToTotalPriceOnPaymentFormSideBar() {
        Double totalAmount = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                           .getTotalPriceAmount()));

        Double totalAmountForSideBar = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                                     .getTotalPriceAmountSideBar()));

        Double totalAmountExpected = (extraTotal + stopoverTotal + PaymentFormsBuilder.FLIGHT_AMOUNT);

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IS_NOT_AS_EXPECTED, totalAmountExpected),
                totalAmountExpected, totalAmount);

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IN_SIDE_BAR_IS_NOT_AS_EXPECTED, totalAmountExpected),
                totalAmountExpected, totalAmountForSideBar);

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost and all address information with quote option$")
    public void createFormWithFlightCostAndAllAddressInformationWithQuoteOption() throws ParseException {

        List<HtmlField> fieldList = htmlFieldRepository.findByTypeAndMandatoryIsFalse(AutomationConstant.ADDRESS);

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_WITH_QUOTE, AutomationConstant.ADDRESS_INFO, fieldList));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @Then("^I should see all selected address information fields$")
    public void verifyAllSelectedAddressInformationFieldsIsDisplayed() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.ADDRESS_ONE),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getAddressLineOne()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.ADDRESS_TWO),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getAddressLineTwo()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.CITY),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getCity()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.STATE),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getState()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.ZIP),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getZipCode()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.COUNTRY),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getCountry()));
    }

    /**
     * 
     */
    @When("^I select submit page$")
    public void selectSubmitPage() {
        paymentFormPage.selectSubmitButton();
    }

    /**
     * 
     */
    @Then("^I should see error message for address information require fields$")
    public void verifyErrorMessagesDisplayedForAddressInformationRequireFields() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.IS_NOT, PaymentFormsAsseartionMessages.ADDRESS_ONE),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getRequireErrorMsgForAddressOne()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.IS_NOT, PaymentFormsAsseartionMessages.CITY),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getRequireErrorMsgForCity()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.IS_NOT, PaymentFormsAsseartionMessages.STATE),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getRequireErrorMsgForState()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.IS_NOT, PaymentFormsAsseartionMessages.ZIP),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getRequireErrorMsgForZip()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.IS_NOT, PaymentFormsAsseartionMessages.COUNTRY),
                webDriverCommons.isDisplayed(addressPage.getPageElements()
                                                        .getRequireErrorMsgForCountry()));

    }

    /**
     * 
     */
    @When("^I fill details in all require field on page$")
    public void fillDetailsInAllRequireFieldOnPage() {
        paymentFormPage.selectGender(AutomationConstant.GENDER_MALE);
        passengerInformationPage.fillPassengerInformation("required for form");
        addressPage.fillAddressDetils("required");
        paymentFormPage.selectTermsAndCondition();

    }

    /**
     * 
     */
    @Then("^I should be on confirmation page$")
    public void verifyConfirmationPageIsDisplayed() {
        Assert.assertTrue(PaymentFormsAsseartionMessages.PAGE_NOT_LOADED_CONFIRMATION_PAGE, confirmationPage.isPageLoaded());

        paymentFormRepository.delete(savedForm.getId());

    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost and all passenger information with quote option$")
    public void createFormWithFlightCostAndAllPassengerInformationWithQuoteOption() throws ParseException {

        List<HtmlField> htmlField = htmlFieldRepository.findByTypeAndMandatoryIsFalse(AutomationConstant.PASSENGER);

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_WITH_QUOTE, AutomationConstant.PASSENGER_INFO, htmlField));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @Then("^I should see the selected passenger information fields displayed on page$")
    public void verifySelectedPassengerInformationFieldsDisplayedOnPage() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.TITLE),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getTitleInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.FIRST_NAME),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getFirstNameInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.MIDDLE_NAME),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getMiddleNameInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.LAST_NAME),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getLastNameInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.PASSPORT_NO),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getPassportNumberInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.DATE_OF_BIRTH),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getDateOfBirthInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.EMAIL),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getEmailAddressInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.EMAIL_CONFIRM),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getEmailAddressConfirmInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_INPUT_IS_NOT_DISPLAYED_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.PHONE_NO),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getPhoneNoInput()));

    }

    /**
     * 
     */
    @Then("^I should see messages for all require passenger information fields$")
    public void verifyMessagesForAllRequirePassengerInformationFieldsAreDisplayed() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.TITLE, PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getRequireErrorMsgForTitleInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.FIRST_NAME, PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getRequireErrorMsgForFirstNameInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.LAST_NAME, PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getRequireErrorMsgForLastNameInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.DATE_OF_BIRTH, PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getRequireErrorMsgForDateOfBirthInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.EMAIL, PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getRequireErrorMsgForEmailAddressInput()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.PHONE_NO, PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getRequireErrorMsgForPhoneNoInput()));

    }

    /**
     * 
     */
    @When("^I fill in details in the mandatory fields$")
    public void fillInDetailsInMandatoryFields() {
        paymentFormPage.selectGender(AutomationConstant.GENDER_MALE);
        passengerInformationPage.fillPassengerInformation("allWithOutMiddleNameAndPassportNo");
        paymentFormPage.selectTermsAndCondition();

    }

    /**
     * 
     */
    @Then("^I should not see payment form page error messages for passenger fields$")
    public void verifyErrorMessagesAreNotDisplayedForPassengerFields() {

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.TITLE, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getRequireErrorMsgForTitleInput()
                                        .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.FIRST_NAME, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getRequireErrorMsgForFirstNameInput()
                                        .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.LAST_NAME, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getRequireErrorMsgForLastNameInput()
                                        .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.DATE_OF_BIRTH, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getRequireErrorMsgForDateOfBirthInput()
                                        .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.EMAIL, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getRequireErrorMsgForEmailAddressInput()
                                        .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.PHONE_NO, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getRequireErrorMsgForPhoneNoInput()
                                        .isDisplayed());
    }

    /**
     * 
     */
    @When("^I select the T & C checkbox$")
    public void selectTAndCCheckbox() {
        paymentFormPage.selectTermsAndCondition();
    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost deposit cost and final deposit due date$")
    public void creatFormWithFlightCostDepositCostAndFinalDepositDueDate() throws ParseException {

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_WITH_DEPOSIT, AutomationConstant.FINAL_DEPOSIT));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());
    }

    /**
     * 
     */
    @When("^I select the deposit payment type$")
    public void selectDepositPaymentType() {
        travelInformationPage.selectPaymentOption(AutomationConstant.DEPOSIT_OPTION);
    }

    /**
     * 
     */
    @Then("^I should see final deposit due date warning on top and bottm of the front end payment form page$")
    public void verifyFinalDepositDueDateWarningIsDisplayedOnTopAndBottomOfPaymentForm() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                       .getFinalDepositHeadingForTop()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.TOP,
                        PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE, utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                                                                                   .getFinalDepositDate(),
                                PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE)),
                utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                       .getFinalDepositDate(),
                        PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalDepositDateForTop()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                       .getFinalDepositHeadingForBottom()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.BOTTOM,
                        PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE, utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                                                                                   .getFinalDepositDate(),
                                PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE)),
                utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                       .getFinalDepositDate(),
                        PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalDepositDateForBottom()));

    }

    /**
     * 
     */
    @Then("^I should see final deposit due date warning on payment form side bar$")
    public void verifyFinalDepositDueDateWarningIsDisplayedOnPaymentFormSideBar() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                       .getFinalDepositHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SIDE_BAR,
                        PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE, utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                                                                                   .getFinalDepositDate(),
                                PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE)),
                utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                       .getFinalDepositDate(),
                        PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalDepositDateForSideBar()));
    }

    /**
     * 
     */
    @Then("^I should see final deposit due date message on front end payment form page$")
    public void verifyFinalDepositDueDateMessageIsDisplayedOnFrontEndPaymentFormPage() {
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_ENTERED_IN_PAYMENT_FORM,
                        PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE_MESSAGE),
                AutomationConstant.FINAL_DEPOSIT_DATE_DESCRIPTION,
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalDepositMessage()));

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost deposit cost and final payment due date$")
    public void creatFormWithFlightCostDepositCostAndFinalPamentDueDate() throws ParseException {
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
    @When("^I select the full amount payment type$")
    public void selectFullAmountPaymentType() {
        travelInformationPage.selectPaymentOption(AutomationConstant.FULL_PAYMENT_OPTION);
    }

    /**
     * 
     */
    @Then("^I should see final payment due date warning on top and bottm of the front end payment form page$")
    public void verifyFinalPaymentDueDateWarningIsDisplayedOnTopAndBottmOfTheFrontEndPaymentFormPage() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                       .getFinalPaymentHeadingForTop()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalPaymentHeadingForTop())
                                .contains("Payment"));

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
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
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalPaymentDateForTop()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                       .getFinalPaymentHeadingForBottom()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalPaymentHeadingForBottom())
                                .contains("Payment"));

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
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
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalPaymentDateForBottom()));

    }

    /**
     * 
     */
    @Then("^I should see final payment due date warning on payment form side bar$")
    public void verifyFinalPaymentDueDateWarningIsDisplayedOnPaymentFormSideBar() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                       .getFinalPaymentHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DATE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SIDE_BAR,
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE, utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                                                                                  .getFinalPaymentDueDate(),
                                PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE)),
                utilities.getDateFromDataBase(savedForm.getTermsAndCondition()
                                                       .getFinalPaymentDueDate(),
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalPaymentDateForSideBar()));
    }

    /**
     * 
     */
    @Then("^I should see final payment due date message on front end payment form page$")
    public void verifyFinalPaymentDueDateMessageOnFrontEndPaymentFormPage() {
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_ENTERED_IN_PAYMENT_FORM,
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE_MESSAGE),
                savedForm.getTermsAndCondition()
                         .getFinalPaymentDescription(),
                webDriverCommons.getText(finalDepositAndFinalPaymentPaymentFormPage.getPageElements()
                                                                                   .getFinalPaymentMessage()));

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should not be able to enter invalid email address in address input$")
    public void verifyInvalidFormatEmailIsNotAllowedInTheEmailField() {

        String[] arr = { INVALID_EMAIL_ONE, INVALID_EMAIL_TWO, INVALID_EMAIL_THREE, INVALID_EMAIL_FOUR, INVALID_EMAIL_FIVE, INVALID_EMAIL_SIX,
                INVALID_EMAIL_SEVEN, INVALID_EMAIL_EIGHT };

        for (int i = 0; i < arr.length; i++) {

            passengerInformationPage.enterEmailAddress(arr[i]);

            Assert.assertTrue("Invalid email address message is not displayed after entering invalid format",
                    webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                         .getInvalidEmailAddressMessage()));
        }

    }

    /**
     * 
     */
    @When("^I enter a valid format email in the email field$")
    public void enterAValidFormatEmailInEmailField() {

        passengerInformationPage.enterEmailAddress(VALID_EMAIL);
    }

    /**
     * 
     */
    @Then("^I should not see the invalid email error message$")
    public void verifyInvalidEmailErrorMessageIsNotDisplayed() {
        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.EMAIL, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getRequireErrorMsgForEmailAddressInput()
                                        .isDisplayed());
    }

    /**
     * 
     */
    @When("^I enter email in confirm email input diffrent than I enter in email input$")
    public void enterEmailInConfirmEmailInputDiffrentThanEnteredInEmailInput() {
        webDriverCommons.sendKeys(passengerInformationPage.getPageElements()
                                                          .getEmailAddressConfirmInput(),
                INVALID_EMAIL_FOR_CONFIRM_EMAIL);
    }

    /**
     * 
     */
    @Then("^I should receive error message for confirm email input$")
    public void verifyErrorMessageIsDisplayedForConfirmEmailInput() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.EMAIL_ADDRESS_DO_NOT_MATCH, PaymentFormsAsseartionMessages.IS_NOT),
                webDriverCommons.isDisplayed(passengerInformationPage.getPageElements()
                                                                     .getEmailAddressDoNotMatchMessage()));
    }

    /**
     * 
     */
    @When("^I enter same email in confirm email input as I enter in email input$")
    public void enterSameEmailInConfirmEmailInputAsIEnterInEmailInput() {
        webDriverCommons.sendKeys(passengerInformationPage.getPageElements()
                                                          .getEmailAddressConfirmInput(),
                VALID_EMAIL);
    }

    /**
     * 
     */
    @Then("^I should not receive error message for confirm email input$")
    public void verifyErrorMessageIsNotDisplayedForConfirmEmailInput() {

        Assert.assertFalse(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_REQUIRED_ERROR_MESSAGE_ON_PAYMENT_FORM_PAGE,
                        PaymentFormsAsseartionMessages.EMAIL_ADDRESS_DO_NOT_MATCH, PaymentFormsAsseartionMessages.IS),
                passengerInformationPage.getPageElements()
                                        .getEmailAddressDoNotMatchMessage()
                                        .isDisplayed());

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * @throws ParseException
     *             ParseException
     * 
     */
    @Given("^Form is created with flight cost deposit and balance selected$")
    public void createAwFormWithFlightCostDepositAndBalanceSelected() throws ParseException {

        savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT_WITH_DEPOSIT_AND_BALANCE_ONLY));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     */
    @When("^I select quote option$")
    public void selectQuoteOption() throws InterruptedException {

        utilities.timeInterval(AutomationConstant.TIME_INTERVAL_FOR_THREE_SECONDS);

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.BUTTON_NOT_CONTAINING_TEXT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE, AutomationConstant.REQUEST_A_QUOTE_TEXT),
                AutomationConstant.REQUEST_A_QUOTE_TEXT, webDriverCommons.getText(travelInformationPage.getPageElements()
                                                                                                       .getProceedToBookingButton()));

        proceedToBooking();
    }

    /**
     * 
     */
    @Then("^I should see only quote payment option on the front end payment form page$")
    public void verifyQuotePaymentOptionOnFrontEndPaymentFormPageIsDisplayed() {

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.BUTTON_NOT_CONTAINING_TEXT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.QUOTE_REQUEST_PAGE, AutomationConstant.SUBMIT_A_QUOTE_REQUEST_TEXT),
                AutomationConstant.SUBMIT_A_QUOTE_REQUEST_TEXT, webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                        .getSubmitButton()));

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see three payment types on the travel info page$")
    public void verifyAllThreePaymentTypesDisplayedOnTravelInfoPage() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, AutomationConstant.DEPOSIT_OPTION,
                        PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                  .getDepositButton()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, AutomationConstant.BALANCE_OPTION,
                        PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                  .getBalanceButton()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED, AutomationConstant.FULL_PAYMENT_OPTION,
                        PaymentFormsAsseartionMessages.TRAVEL_INFO_PAGE),
                webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                  .getFullPaymentButton()));
    }

    /**
     * 
     * @param type
     *            type
     */
    @When("^I select \"([^\"]*)\"$")
    public void select(final String type) {

        if (type.equalsIgnoreCase(AutomationConstant.BALANCE_AS_PAYMENT_TYPE)) {

            travelInformationPage.sclectPaymentType(AutomationConstant.BALANCE_AS_PAYMENT_TYPE);

        } else if (type.equalsIgnoreCase(AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE)) {

            travelInformationPage.sclectPaymentType(AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE);

        } else if (type.equalsIgnoreCase(AutomationConstant.FULL_AMOUNT_AS_PAYMENT_TYPE)) {

            travelInformationPage.sclectPaymentType(AutomationConstant.FULL_AMOUNT_AS_PAYMENT_TYPE);
        }

    }

    /**
     * 
     * @param type
     *            type
     */
    @Then("^I should see payable today price on the front end payment form page as per selected \"([^\"]*)\"$")
    public void verifyPayableTodayPriceOnFrontEndPaymentFormPageContainPriceAsPerSelectedPaymentOption(final String type) {

        Double balance = PaymentFormsBuilder.FLIGHT_AMOUNT - PaymentFormsBuilder.DEPOSIT_AMOUNT;

        if (type.equalsIgnoreCase(AutomationConstant.BALANCE_AS_PAYMENT_TYPE)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.PAYABLE_TODAY_HEADING),
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
        } else if (type.equalsIgnoreCase(AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.PAYABLE_TODAY_HEADING),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getPayableTodayHeading()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.PAYABLE_TODAY_HEADING_FOR_SIDEBAR),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getPayableTodayHeadingForSideBar()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE, PaymentFormsBuilder.DEPOSIT_AMOUNT),
                    PaymentFormsBuilder.DEPOSIT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getPayableTodayDepositAmount())));
            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE_SIDE_BAR, PaymentFormsBuilder.DEPOSIT_AMOUNT),
                    PaymentFormsBuilder.DEPOSIT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getPayableTodayDepositAmountForSideBar())));
        } else if (type.equalsIgnoreCase(AutomationConstant.FULL_AMOUNT_AS_PAYMENT_TYPE)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.TOTAL_COST_FOR_SIDE_BAR),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getTotalCostHeading()));

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.TOTAL_COST_FOR_SIDE_BAR),
                    webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                .getTotalCostHeadingForSideBar()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.FULL_AMOUNT_AS_PAYMENT_TYPE,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE, PaymentFormsBuilder.FLIGHT_AMOUNT),
                    PaymentFormsBuilder.FLIGHT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getPayableTodayFullAmount())));
            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED, AutomationConstant.FULL_AMOUNT_AS_PAYMENT_TYPE,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE_SIDE_BAR, PaymentFormsBuilder.FLIGHT_AMOUNT),
                    PaymentFormsBuilder.FLIGHT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getPayableTodayFullAmountForSideBar())));
        }

    }

    /**
     * 
     * @param type
     *            type
     * @throws InterruptedException
     *             InterruptedException
     */
    @Then("^I should payment button on the front end payment form page contain expected text as per \"([^\"]*)\"$")
    public void verifyPaymentButtonOnFrontEndPaymentFormPageContainExpectedTextAsPerSelectedPaymentOption(final String type)
            throws InterruptedException {

        utilities.timeInterval(1);

        if (type.equalsIgnoreCase(AutomationConstant.BALANCE_AS_PAYMENT_TYPE)) {

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.BUTTON_NOT_CONTAINING_TEXT_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE, AutomationConstant.PAY_BALANCE_NOW_TEXT),
                    AutomationConstant.PAY_BALANCE_NOW_TEXT, webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                     .getSubmitButton()));
        } else if (type.equalsIgnoreCase(AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE)) {

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.BUTTON_NOT_CONTAINING_TEXT_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE, AutomationConstant.PAY_DEPOSIT_NOW_TEXT),
                    AutomationConstant.PAY_DEPOSIT_NOW_TEXT, webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                     .getSubmitButton()));
        } else if (type.equalsIgnoreCase(AutomationConstant.FULL_AMOUNT_AS_PAYMENT_TYPE)) {

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.BUTTON_NOT_CONTAINING_TEXT_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE, AutomationConstant.PAY_FULL_AMOUNT_NOW_TEXT),
                    AutomationConstant.PAY_FULL_AMOUNT_NOW_TEXT, webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                         .getSubmitButton()));
        }
    }

    /**
     * 
     * @param type
     *            type
     */
    @Then("^I should see the total price for booking displayed on the front end payment form as per selected \"([^\"]*)\"$")
    public void verifyTotalPriceForBookingDisplayedOnFrontEndPaymentFormAsPerSelectedPaymentOption(final String type) {

        if (type.equalsIgnoreCase(AutomationConstant.BALANCE_AS_PAYMENT_TYPE)) {

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.TOTAL_PRICE_FOR_BOOKING_AMOUNT, PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE,
                            PaymentFormsBuilder.FLIGHT_AMOUNT),
                    PaymentFormsBuilder.FLIGHT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getTotalPriceForBookingAmount())));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.TOTAL_PRICE_FOR_BOOKING_AMOUNT_FOR_SIDE_BAR,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE_SIDE_BAR, PaymentFormsBuilder.FLIGHT_AMOUNT),
                    PaymentFormsBuilder.FLIGHT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getTotalPriceForBookingAmountForSideBar())));
        } else if (type.equalsIgnoreCase(AutomationConstant.DEPOSIT_AS_PAYMENT_TYPE)) {

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.TOTAL_PRICE_FOR_BOOKING_AMOUNT, PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE,
                            PaymentFormsBuilder.FLIGHT_AMOUNT),
                    PaymentFormsBuilder.FLIGHT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getTotalPriceForBookingAmount())));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.AMOUNT_IS_NOT_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.TOTAL_PRICE_FOR_BOOKING_AMOUNT_FOR_SIDE_BAR,
                            PaymentFormsAsseartionMessages.PAYMENT_FORM_PAGE_SIDE_BAR, PaymentFormsBuilder.FLIGHT_AMOUNT),
                    PaymentFormsBuilder.FLIGHT_AMOUNT,
                    utilities.getAmountAsDoubleFromString(webDriverCommons.getText(paymentFormPage.getPageElements()
                                                                                                  .getTotalPriceForBookingAmountForSideBar())));
        }

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see state list from state dropdown as per country selection$")
    public void verifyStateListFromStateDropdownDisplayesAsPerCountrySelection() {

        addressPage.selectCountry(AddressPage.UNITED_KINGDOM);
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.DROP_DOWN_LIST_IS_NOT_AS_EXPECTED, PaymentFormsAsseartionMessages.STATE,
                        AddressPage.UNITED_KINGDOM),
                addressPage.expectedStateList(AddressPage.UNITED_KINGDOM), addressPage.getStateFromPaymentFormUI());

        addressPage.selectCountry(AddressPage.AUSTRALIA);
        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.DROP_DOWN_LIST_IS_NOT_AS_EXPECTED,
                PaymentFormsAsseartionMessages.STATE, AddressPage.AUSTRALIA), addressPage.expectedStateList(AddressPage.AUSTRALIA),
                addressPage.getStateFromPaymentFormUI());

        addressPage.selectCountry(AddressPage.U_S_A);
        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.DROP_DOWN_LIST_IS_NOT_AS_EXPECTED,
                PaymentFormsAsseartionMessages.STATE, AddressPage.U_S_A), addressPage.expectedStateList(AddressPage.U_S_A),
                addressPage.getStateFromPaymentFormUI());

        paymentFormRepository.delete(savedForm.getId());
    }

}
