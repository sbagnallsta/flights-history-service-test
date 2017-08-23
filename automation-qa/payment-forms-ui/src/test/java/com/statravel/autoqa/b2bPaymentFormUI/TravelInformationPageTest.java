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
import com.statravel.autoqa.paymentformsui.commons.WebDriverFactory;
import com.statravel.autoqa.paymentformsui.domain.entity.Flight;
import com.statravel.autoqa.paymentformsui.domain.entity.Misc;
import com.statravel.autoqa.paymentformsui.domain.entity.Others;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentForm;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentFormsBuilder;
import com.statravel.autoqa.paymentformsui.domain.entity.Transfer;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.FinalDepositAndFinalPaymentDatePage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.FlightGettingAroundPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.FlightGettingBackPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.FlightGettingTherePage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.ImportantInstructionsPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.MiscProductPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.OthersPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.TransferPage;
import com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation.TravelInformationPage;
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
public class TravelInformationPageTest {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private OthersPage othersPage;

    @Autowired
    private MiscProductPage miscProductPage;

    @Autowired
    private ImportantInstructionsPage importantInstructionsPage;

    @Autowired
    private TransferPage transferPage;

    @Autowired
    private FinalDepositAndFinalPaymentDatePage finalDepositAndFinalPaymentDatePage;

    @Autowired
    private FlightGettingTherePage flightGettingTherePage;

    @Autowired
    private FlightGettingAroundPage flightGettingAroundPage;

    @Autowired
    private FlightGettingBackPage flightGettingBackPage;

    @Autowired
    private PaymentFormRepository paymentFormRepository;

    @Autowired
    private PaymentFormsBuilder paymentFormsBuilder;

    @Autowired
    private PaymentFormConfigureRepository paymentFormConfigureRepository;

    @Autowired
    private Utilities utilities;

    private PaymentForm paymentFormWithProduct;

    private PaymentForm savedForm;

    private String uniqueUrl;

    /**
     * 
     */
    @Before
    public void init() {
        travelInformationPage.init();
        miscProductPage.init();
        othersPage.init();
        importantInstructionsPage.init();
        finalDepositAndFinalPaymentDatePage.init();
        transferPage.init();
        flightGettingTherePage.init();
        flightGettingAroundPage.init();
        flightGettingBackPage.init();
    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost and two misc product with cost$")
    public void verifyFormIsCreatedWithFlightCostAndMiscProductWithCost() throws ParseException {

        Misc misc1 = new Misc();
        misc1.setDescription(AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT);
        misc1.setPrice(AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT);
        misc1.setTitle(AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT);

        Misc misc2 = new Misc();
        misc2.setDescription(AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT);
        misc2.setPrice(AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT);
        misc2.setTitle(AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT);

        paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.MISC_PRODUCT,
                Arrays.asList(misc1, misc2));

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
    @When("^I enter unique url$")
    public void enterUniqueUrl() {

        WebDriverFactory.getWebDriver()
                        .get(uniqueUrl);

    }

    /**
     * 
     */
    @Then("^I should be directed to the travel information page$")
    public void verifyTravelInformationPageIsLoaded() {

        Assert.assertTrue(PaymentFormsAsseartionMessages.PAGE_NOT_LOADED_TRAVEL_INFORMATION, travelInformationPage.isPageLoaded());

        webDriverCommons.waitForLoad();
    }

    /**
     * 
     */
    @Then("^I should see the both Misc products information as entered in form with check box$")
    public void verifyBothMiscProductsInformationDisplayedAsEnteredInFormWithCheckBox() {

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_HEADING_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, paymentFormWithProduct.getMiscProductName()),
                paymentFormWithProduct.getMiscProductName(), webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                     .getMiscProductHeadingName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getFirstMiscProductTitle()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT),
                AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getFirstMiscProductDescription()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT),
                AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                              .getFirstMiscProductPrice())));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRICE_CHECK_BOX_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT),
                webDriverCommons.isDisplayed(miscProductPage.getPageElements()
                                                            .getFirstMiscProductCheckBox()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                          .getSecondMiscProductTitle()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT),
                AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getSecondMiscProductDescription()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_PRICE_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT),
                AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                              .getSecondMiscProductPrice())));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRICE_CHECK_BOX_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT),
                webDriverCommons.isDisplayed(miscProductPage.getPageElements()
                                                            .getSecondMiscProductCheckBox()));

    }

    /**
     * 
     */
    @When("^I select both Misc product option$")
    public void selectBothMiscProductOption() {
        miscProductPage.selectFirstMiscProductTickBox();
        miscProductPage.selectSecondMiscProductTickBox();

    }

    /**
     * 
     */
    @When("^I select the Misc product option$")
    public void selectMiscProductOption() {
        miscProductPage.selectFirstMiscProductTickBox();

    }

    /**
     * .
     * 
     */
    @Then("^I should see the selected Options highlighted$")
    public void verifyBothMiscProductOptionIsHighlighted() {
        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_BOX_NOT_HIGHLIGHTED_AFTER_SELECTING,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT),
                miscProductPage.isFirstMiscProductOptionHighlighted());

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_BOX_NOT_HIGHLIGHTED_AFTER_SELECTING,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.MISC_PRODUCT),
                miscProductPage.isSecondMiscProductOptionHighlighted());
    }

    /**
     * .
     * 
     */
    @Then("^I should see the selected Option highlighted$")
    public void verifyMiscProductOptionIsHighlighted() {
        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_BOX_NOT_HIGHLIGHTED_AFTER_SELECTING,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT),
                miscProductPage.isFirstMiscProductOptionHighlighted());
    }

    /**
     * 
     */
    @Then("^I should see the misc product with price on the travel info sidebar$")
    public void verifyMiscProductWithPriceDisplayedOnTravelInfoSidebar() {
        Double totalMiscPriceEntered = AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT + AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT;

        Double totalMiscAmountInSideBarDouble = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                                              .getMiscProductTotalAmountForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT),
                AutomationConstant.MISC_NAME, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                      .getMiscProductHeadingNameForSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_NOT_UPDATED,
                PaymentFormsAsseartionMessages.MISC_PRODUCT, PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT),
                totalMiscPriceEntered, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                                     .getMiscProductTotalAmountForSideBar())));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getFirstMiscProductTitleForSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_SECOND_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                          .getSecondMiscProductTitleForSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_AMOUNT_IN_SIDE_BAR_NOT_UPDATED,
                PaymentFormsAsseartionMessages.MISC_PRODUCT), totalMiscPriceEntered, totalMiscAmountInSideBarDouble);

    }

    /**
     * 
     */
    @Then("^I should see that the misc product price added to the total price$")
    public void verifyMiscProductPriceAddedToTheTotalPrice() {

        Double totalMiscPriceEntered = AutomationConstant.PRICE_FOR_FIRST_MISC_PRODUCT + AutomationConstant.PRICE_FOR_SECOND_MISC_PRODUCT
                + PaymentFormsBuilder.FLIGHT_AMOUNT;

        Double totalCostInDouble = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(travelInformationPage.getPageElements()
                                                                                                                       .getTotalPriceAmount()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_AMOUNT_NOT_UPDATED, PaymentFormsAsseartionMessages.MISC_PRODUCT),
                totalMiscPriceEntered, totalCostInDouble);

        paymentFormRepository.delete(savedForm.getId());

    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost and misc product with out cost$")
    public void verifyFormIsCreatedWithFlightCostAndMiscProductWithOutCost() throws ParseException {
        Misc misc1 = new Misc();
        misc1.setDescription(AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT);
        misc1.setTitle(AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT);

        paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.MISC_PRODUCT,
                Arrays.asList(misc1));

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.MISC_PRODUCT, Arrays.asList(misc1)));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @Then("^I should see the Misc product information as entered in form with check box$")
    public void verifyMiscProductInformationDisplayedAsEnteredInFormWithCheckBox() {
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_HEADING_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, paymentFormWithProduct.getMiscProductName()),
                paymentFormWithProduct.getMiscProductName(), webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                     .getMiscProductHeadingName()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getFirstMiscProductTitle()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT),
                AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getFirstMiscProductDescription()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRICE_CHECK_BOX_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT),
                webDriverCommons.isDisplayed(miscProductPage.getPageElements()
                                                            .getFirstMiscProductCheckBox()));

    }

    /**
     * 
     */
    @Then("^I should see the misc product on the travel information sidebar")
    public void verifyMiscProductNameAndCheckBoxDisplayedOnTravelInformationPage() {

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_HEADING_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT),
                paymentFormWithProduct.getMiscProductName(), webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                     .getMiscProductHeadingName()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, "0.00"),
                webDriverCommons.getText(miscProductPage.getPageElements()
                                                        .getMiscProductTotalAmountForSideBar())
                                .contains("0.00"));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IN_SIDE_BAR_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT),
                AutomationConstant.TITLE_FOR_FIRST_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getFirstMiscProductTitleForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.MISC_PRODUCT, AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT),
                AutomationConstant.DISCRIPTION_FOR_MISC_PRODUCT, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                                         .getFirstMiscProductDescription()));

    }

    /**
     * 
     */
    @Then("^misc price should be displayed as NA on the travel info sidebar$")
    public void verifyMiscProductDisplayedAsNAOnTravelInfoSidebar() {

        Assert.assertEquals("Misc Product in side is not displaying N/A after selecting misc product without price",
                AutomationConstant.NOT_APPLICABLE, webDriverCommons.getText(miscProductPage.getPageElements()
                                                                                           .getFirstMiscProductAmountForSideBar()));

        paymentFormRepository.delete(savedForm.getId());

    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with others cost and two others product$")
    public void saveFormWithOthersCostAndTwoOthersProduct() throws ParseException {
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
    @Then("^I should see both Others on the travel info page$")
    public void verifyBothOthersDisplayedOnTravelInfoPage() {
        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.OTHERS),
                webDriverCommons.isDisplayed(othersPage.getPageElements()
                                                       .getOthersHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.FIRST_OTHERS_TITLE),
                AutomationConstant.FIRST_OTHERS_TITLE, webDriverCommons.getText(othersPage.getPageElements()
                                                                                          .getFirstOthersTitle()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.FIRST_OTHERS_DESCRIPTION),
                AutomationConstant.FIRST_OTHERS_DESCRIPTION,

                webDriverCommons.getText(othersPage.getPageElements()
                                                   .getFirstOthersTripDetails()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.SECOND_OTHERS_TITLE),
                AutomationConstant.SECOND_OTHERS_TITLE, webDriverCommons.getText(othersPage.getPageElements()
                                                                                           .getSecondOthersTitle()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.OTHERS, AutomationConstant.FIRST_OTHERS_DESCRIPTION),
                AutomationConstant.SECOND_OTHERS_DESCRIPTION, webDriverCommons.getText(othersPage.getPageElements()
                                                                                                 .getSecondOthersTripDetails()));

    }

    /**
     * 
     */
    @Then("^I should see the Others on the travel info sidebar with price$")
    public void verifyOthersIsDisplayedOnTravelInfoSidebar() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.OTHERS),
                webDriverCommons.isDisplayed(othersPage.getPageElements()
                                                       .getOtherHeadingForSideBar()));

        Double othersAmountForSideBar = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(othersPage.getPageElements()
                                                                                                                 .getOthersAmountForSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                PaymentFormsAsseartionMessages.OTHERS, savedForm.getCost()
                                                                .getOtherAmount()),
                PaymentFormsBuilder.OTHERS_AMOUNT, othersAmountForSideBar);
    }

    /**
     * 
     */
    @Then("^I should see that the Others price is added to the total price$")
    public void verifyOthersPriceIsAddedToTotalPrice() {

        Double totalCost = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(travelInformationPage.getPageElements()
                                                                                                               .getTotalPriceAmount()));

        Double totalCostInSideBar = utilities.getAmountAsDoubleFromString(webDriverCommons.getText(travelInformationPage.getPageElements()
                                                                                                                        .getTotalPriceAmountSideBar()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IS_NOT_AS_EXPECTED, PaymentFormsBuilder.OTHERS_AMOUNT),
                PaymentFormsBuilder.OTHERS_AMOUNT, totalCost);

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IN_SIDE_BAR_IS_NOT_AS_EXPECTED, PaymentFormsBuilder.OTHERS_AMOUNT),
                PaymentFormsBuilder.OTHERS_AMOUNT, totalCostInSideBar);

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with others cost and important instructions$")
    public void createAFormWithOthersCostAndImportantInstructions() throws ParseException {

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.OTHERS, AutomationConstant.IMPORTANT_INSTRUCTIONS));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @Then("^I should see the important instruction module information displayed$")
    public void verifyImportantInstructionModuleInformationIsDisplayed() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.IMPORTANT_INSTRUCTIONS),
                webDriverCommons.isDisplayed(importantInstructionsPage.getPageElements()
                                                                      .getImportantInstructionHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED, "",
                        PaymentFormsAsseartionMessages.IMPORTANT_INSTRUCTIONS, PaymentFormsBuilder.IMPORTANT_INSTRUCTIONS),
                PaymentFormsBuilder.IMPORTANT_INSTRUCTIONS, webDriverCommons.getText(importantInstructionsPage.getPageElements()
                                                                                                              .getImportantInstructionMessage()));

        paymentFormRepository.delete(savedForm.getId());

    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost final deposite and final payment date$")
    public void createAFormWithFlightCostFinalDepositeAndFinalPaymentDate() throws ParseException {

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.FINAL_DEPOSIT_AND_PAYMENT));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());
    }

    /**
     * 
     */
    @Then("^I should see the final deposit due date on the travel info side bar$")
    public void verifyFinalDepositDueDateIsDisplayedOnTravelInfoSideBar() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentDatePage.getPageElements()
                                                                                .getFinalDepositDueDateHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_ENTERED_IN_PAYMENT_FORM,
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                utilities.getCurrentDateInString(), webDriverCommons.getText(finalDepositAndFinalPaymentDatePage.getPageElements()
                                                                                                                .getFinalDepositDueDateForSideBar()));
    }

    /**
     * 
     */
    @Then("^I should see the final payment due date on the travel info side bar$")
    public void verifyFinalPaymentDueDateIsDisplayedOnTravelInfoSideBar() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                webDriverCommons.isDisplayed(finalDepositAndFinalPaymentDatePage.getPageElements()
                                                                                .getFinalPaymentDueDateHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.NOT_DISPLAYING_AS_ENTERED_IN_PAYMENT_FORM,
                        PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE),
                utilities.getCurrentDateInString(), webDriverCommons.getText(finalDepositAndFinalPaymentDatePage.getPageElements()
                                                                                                                .getFinalPaymentDueDateForSideBar()));

        paymentFormRepository.delete(savedForm.getId());

    }

    /**
     * 
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with transfer cost and two transfer product$")
    public void ceateAFormWitHTransferCostAndTwoTransferProduct() throws ParseException {

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

        paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.TRANSFER, AutomationConstant.TRANSFER,
                Arrays.asList(transfer1, transfer2));

        savedForm = paymentFormRepository.save(
                paymentFormsBuilder.buildPaymentForm(AutomationConstant.TRANSFER, AutomationConstant.TRANSFER, Arrays.asList(transfer1, transfer2)));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());
    }

    /**
     * @throws ParseException
     *             ParseException
     * 
     */
    @Then("^I should see the Transfer details on the travel information page$")
    public void verifyTransferDetailsIsDisplayedOnTravelInformationPageAsEnteredOnPaymentForm() throws ParseException {

        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.TRANSFER),
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTransferHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.FIRST_TRANSFER_NAME),
                AutomationConstant.FIRST_TRANSFER_NAME, webDriverCommons.getText(transferPage.getPageElements()
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
                webDriverCommons.getText(transferPage.getPageElements()
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
                webDriverCommons.getText(transferPage.getPageElements()
                                                     .getFirstTransferTime())
                                .replaceAll("[\r\n]+", "")
                                .replaceAll(" ", ""));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.FIRST_TRANSFER_ROUTE),
                webDriverCommons.getText(transferPage.getPageElements()
                                                     .getFirstTransferRoute())
                                .contains(AutomationConstant.FIRST_TRANSFER_ROUTE));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_SPECIAL_REMARK_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.SPECIAL_REMARK_FOR_FIRST_TRANSFER),
                AutomationConstant.SPECIAL_REMARK_FOR_FIRST_TRANSFER, webDriverCommons.getText(transferPage.getPageElements()
                                                                                                           .getFirstTransferSplRemark()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_NAME_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.SECOND,
                        PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.SECOND_TRANSFER_NAME),
                AutomationConstant.SECOND_TRANSFER_NAME, webDriverCommons.getText(transferPage.getPageElements()
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
                webDriverCommons.getText(transferPage.getPageElements()
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
                webDriverCommons.getText(transferPage.getPageElements()
                                                     .getSecondTransferTime())
                                .replaceAll("[\r\n]+", "")
                                .replaceAll(" ", ""));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.TRANSFER, AutomationConstant.SECOND_TRANSFER_ROUTE),
                webDriverCommons.getText(transferPage.getPageElements()
                                                     .getSecondTransferRoute())
                                .contains(AutomationConstant.SECOND_TRANSFER_ROUTE));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_SPECIAL_REMARK_IS_NOT_DISPLAYED_AS_ENTERED,
                        PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.TRANSFER,
                        AutomationConstant.SPECIAL_REMARK_FOR_SECOND_TRANSFER),
                AutomationConstant.SPECIAL_REMARK_FOR_SECOND_TRANSFER, webDriverCommons.getText(transferPage.getPageElements()
                                                                                                            .getSecondTransferSplRemark()));

    }

    /**
     * 
     */
    @Then("^I should see the Transfer with amount on the travel info sidebar$")
    public void verifyTransferWithAmountIsDisplayedOnTravelInfoSideBar() {

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.TRANSFER),
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTransferHeadingSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.TRANSFER, PaymentFormsBuilder.TRANSFER_AMOUNT),
                PaymentFormsBuilder.TRANSFER_AMOUNT, utilities.getAmountAsDoubleFromString(webDriverCommons.getText(transferPage.getPageElements()
                                                                                                                                .getTransferAmountForSideBar())));

    }

    /**
     * 
     */
    @Then("^I should see that the transfer price is added to the total price on the travel info side bar$")
    public void verifyTransferPriceIsAddedToTotalPriceOnTravelInfoSideBar() {

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IN_SIDE_BAR_IS_NOT_AS_EXPECTED, PaymentFormsBuilder.TRANSFER_AMOUNT),
                PaymentFormsBuilder.TRANSFER_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(travelInformationPage.getPageElements()
                                                                                                    .getTotalPriceAmount())));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.TOTAL_COST_IS_NOT_AS_EXPECTED, PaymentFormsBuilder.TRANSFER_AMOUNT),
                PaymentFormsBuilder.TRANSFER_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(travelInformationPage.getPageElements()
                                                                                                    .getTotalPriceAmountSideBar())));

        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     * @param flightType
     *            flightType
     * @throws ParseException
     *             ParseException
     */
    @Given("^Form is already saved with flight cost and \"([^\"]*)\"$")
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
    @Then("^I should see the \"([^\"]*)\" flight on the travel info page$")
    public void verifyFlightIsDisplayedWithEnteredDetailsOnTravelInfoPage(final String flightType) {

        if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_THERE)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_THERE),
                    webDriverCommons.isDisplayed(flightGettingTherePage.getPageElements()
                                                                       .getHeading()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.FIRST_FLIGHT_NUMBER),
                    AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingTherePage.getPageElements()
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
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                   .getFirstDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                    AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                              .getFirstDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.FIRST_DEP_CITY),
                    AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                      .getFirstDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT, AutomationConstant.FIRST_DEP_AIRPORT),
                    AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                         .getFirstDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
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
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                   .getFirstArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                                  .getFirstArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.FIRST_ARRIVAL_CITY),
                    AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                          .getFirstArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                             .getFirstArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                   .getFirstArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE),
                    AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                                       .getFirstFlightDayIndicator()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                    AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                     .getFirstAirline()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.FIRST_FLIGHT_OPERATOR),
                    AutomationConstant.FIRST_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                             .getFirstAirlineOperator()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.SECOND_FLIGHT_NUMBER),
                    AutomationConstant.SECOND_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingTherePage.getPageElements()
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
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                   .getSecondDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT_CODE),
                    AutomationConstant.SECOND_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                               .getSecondDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.SECOND_DEP_CITY),
                    AutomationConstant.SECOND_DEP_CITY, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                       .getSecondDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT),
                    AutomationConstant.SECOND_DEP_AIRPORT, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                          .getSecondDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                    PaymentFormsAsseartionMessages.DEPARTURE_TIME, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                            .get(1)
                                                                                                                            .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
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
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                   .getSecondArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                                   .getSecondArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.SECOND_ARRIVAL_CITY),
                    AutomationConstant.SECOND_ARRIVAL_CITY, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                           .getSecondArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.SECOND_ARRIVAL_AIRPORT),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                              .getSecondArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                   .getSecondArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE),
                    AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                                             .getSecondFlightDayIndicator())
                                                                                              .replaceAll("[\r\n]+", ""));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.SECOND_AIRLINE),
                    AutomationConstant.SECOND_AIRLINE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                      .getSecondAirline()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_THERE,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.SECOND_FLIGHT_OPERATOR),
                    AutomationConstant.SECOND_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                              .getSecondAirlineOperator()));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_AROUND)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_AROUND),
                    webDriverCommons.isDisplayed(flightGettingAroundPage.getPageElements()
                                                                        .getHeading()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.FIRST_FLIGHT_NUMBER),
                    AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                    .getFirstDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                    AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                               .getFirstDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.FIRST_DEP_CITY),
                    AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                       .getFirstDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT, AutomationConstant.FIRST_DEP_AIRPORT),
                    AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                          .getFirstDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                    PaymentFormsAsseartionMessages.DEPARTURE_TIME, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                            .get(0)
                                                                                                                            .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                    .getFirstArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                                   .getFirstArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.FIRST_ARRIVAL_CITY),
                    AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                           .getFirstArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                              .getFirstArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                    .getFirstArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE),
                    AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                                        .getFirstFlightDayIndicator()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                    AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                      .getFirstAirline()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.FIRST_FLIGHT_OPERATOR),
                    AutomationConstant.FIRST_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                              .getFirstAirlineOperator()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.SECOND_FLIGHT_NUMBER),
                    AutomationConstant.SECOND_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                    .getSecondDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT_CODE),
                    AutomationConstant.SECOND_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                                .getSecondDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.SECOND_DEP_CITY),
                    AutomationConstant.SECOND_DEP_CITY, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                        .getSecondDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT),
                    AutomationConstant.SECOND_DEP_AIRPORT, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                           .getSecondDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                    PaymentFormsAsseartionMessages.DEPARTURE_TIME, utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                                                                            .get(1)
                                                                                                                            .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                    .getSecondArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                                    .getSecondArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.SECOND_ARRIVAL_CITY),
                    AutomationConstant.SECOND_ARRIVAL_CITY, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                            .getSecondArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.SECOND_ARRIVAL_AIRPORT),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                               .getSecondArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                    .getSecondArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE),
                    AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                                              .getSecondFlightDayIndicator()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.SECOND_AIRLINE),
                    AutomationConstant.SECOND_AIRLINE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                       .getSecondAirline()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_AROUND,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.SECOND_FLIGHT_OPERATOR),
                    AutomationConstant.SECOND_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                               .getSecondAirlineOperator()));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_BACK)) {

            Assert.assertTrue(
                    MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_BACK),
                    webDriverCommons.isDisplayed(flightGettingBackPage.getPageElements()
                                                                      .getHeading()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.FIRST_FLIGHT_NUMBER),
                    AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingBackPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                  .getFirstDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                    AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                             .getFirstDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.FIRST_DEP_CITY),
                    AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                     .getFirstDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT, AutomationConstant.FIRST_DEP_AIRPORT),
                    AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                        .getFirstDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                  .getFirstArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                                 .getFirstArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.FIRST_ARRIVAL_CITY),
                    AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                         .getFirstArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                    AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                            .getFirstArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(0)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                  .getFirstArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE),
                    AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                                      .getFirstFlightDayIndicator()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                    AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                    .getFirstAirline()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.FIRST_FLIGHT_OPERATOR),
                    AutomationConstant.FIRST_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                            .getFirstAirlineOperator()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.SECOND_FLIGHT_NUMBER),
                    AutomationConstant.SECOND_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingBackPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                  .getSecondDepartureDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT_CODE),
                    AutomationConstant.SECOND_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                              .getSecondDepartureAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.SECOND_DEP_CITY),
                    AutomationConstant.SECOND_DEP_CITY, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                      .getSecondDepartureCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE, AutomationConstant.SECOND_DEP_AIRPORT),
                    AutomationConstant.SECOND_DEP_AIRPORT, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                         .getSecondDepartureAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getDepartureDate()),
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
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
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                  .getSecondArrivalDate()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE, AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                                  .getSecondArrivalAirportCode()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.SECOND_ARRIVAL_CITY),
                    AutomationConstant.SECOND_ARRIVAL_CITY, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                          .getSecondArrivalCity()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.SECOND_ARRIVAL_AIRPORT),
                    AutomationConstant.SECOND_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                             .getSecondArrivalAirport()));

            Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                    PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate())),
                    utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                             .get(1)
                                                                             .getArrivalDate()),
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                  .getSecondArrivalTime()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE),
                    AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                                            .getSecondFlightDayIndicator())
                                                                                              .replaceAll("[\r\n]+", ""));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.SECOND_AIRLINE),
                    AutomationConstant.SECOND_AIRLINE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                     .getSecondAirline()));

            Assert.assertEquals(
                    MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                            PaymentFormsAsseartionMessages.SECOND, PaymentFormsAsseartionMessages.GETTING_BACK,
                            PaymentFormsAsseartionMessages.AIRLINE_OPERAROR, AutomationConstant.SECOND_FLIGHT_OPERATOR),
                    AutomationConstant.SECOND_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                             .getSecondAirlineOperator()));

        }

    }

    /**
     * 
     */
    @Then("^I should see the flight details on the travel info sidebar$")
    public void verifyFlightDetailsDisplayedOnTravelInfoSideBar() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.FLIGHT),
                webDriverCommons.isDisplayed(flightGettingTherePage.getPageElements()
                                                                   .getFlightHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.FLIGHT, PaymentFormsBuilder.FLIGHT_AMOUNT),
                PaymentFormsBuilder.FLIGHT_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                     .getFlightAmountForSideBar())));
        paymentFormRepository.delete(savedForm.getId());
    }

    /**
     * 
     * @param flightType
     *            flightType
     */
    @Then("^I should see message of days it takes for plane to arrive on \"([^\"]*)\"$")
    public void verifyMessageOfDaysItTakesForPlaneToArriveIsDisplayed(final String flightType) {

        if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_THERE)) {
            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                                                   .getFirstFlightDayIndicator()));

            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE,
                    webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                   .getSecondFlightDayIndicator()));
        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_AROUND)) {
            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                                                    .getFirstFlightDayIndicator()));

            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE,
                    webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                    .getSecondFlightDayIndicator()));

        } else if (flightType.equalsIgnoreCase(AutomationConstant.GETTING_BACK)) {
            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                                                  .getFirstFlightDayIndicator()));

            Assert.assertEquals(AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE,
                    webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                  .getSecondFlightDayIndicator()));

        }
    }

    /**
     * @throws ParseException
     *             ParseException
     * 
     */
    @Given("^Form is already saved with flight cost all flight types and all t & c types$")
    public void createFormWithFlightCostAllFlightTypesAndAllTAndCTypes() throws ParseException {
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Flight flight3 = new Flight();

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
        flight1.setType("GETTING_THERE");

        flight2.setActive(true);
        flight2.setAirline(AutomationConstant.FIRST_AIRLINE);
        flight2.setOperator(AutomationConstant.FIRST_FLIGHT_OPERATOR);
        flight2.setNumber(AutomationConstant.FIRST_FLIGHT_NUMBER);
        flight2.setDepartureDate(utilities.getCurrentDateWithHourAndMin());
        flight2.setDepartureCity(AutomationConstant.FIRST_DEP_CITY);
        flight2.setDepartureAirport(AutomationConstant.FIRST_DEP_AIRPORT);
        flight2.setDepartureAirportCode(AutomationConstant.FIRST_DEP_AIRPORT_CODE);
        flight2.setArrivalDate(utilities.getNextDate(2));
        flight2.setArrivalCity(AutomationConstant.FIRST_ARRIVAL_CITY);
        flight2.setArrivalAirport(AutomationConstant.FIRST_ARRIVAL_AIRPORT);
        flight2.setArrivalAirportCode(AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE);
        flight2.setType("GETTING_AROUND");

        flight3.setActive(true);
        flight3.setAirline(AutomationConstant.FIRST_AIRLINE);
        flight3.setOperator(AutomationConstant.FIRST_FLIGHT_OPERATOR);
        flight3.setNumber(AutomationConstant.FIRST_FLIGHT_NUMBER);
        flight3.setDepartureDate(utilities.getCurrentDateWithHourAndMin());
        flight3.setDepartureCity(AutomationConstant.FIRST_DEP_CITY);
        flight3.setDepartureAirport(AutomationConstant.FIRST_DEP_AIRPORT);
        flight3.setDepartureAirportCode(AutomationConstant.FIRST_DEP_AIRPORT_CODE);
        flight3.setArrivalDate(utilities.getNextDate(AutomationConstant.FIVE_DAYS));
        flight3.setArrivalCity(AutomationConstant.FIRST_ARRIVAL_CITY);
        flight3.setArrivalAirport(AutomationConstant.FIRST_ARRIVAL_AIRPORT);
        flight3.setArrivalAirportCode(AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE);
        flight3.setType("GETTING_BACK");

        paymentFormWithProduct = paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.FLIGHTS_AND_TC,
                Arrays.asList(flight1, flight2, flight3));

        savedForm = paymentFormRepository.save(paymentFormsBuilder.buildPaymentForm(AutomationConstant.FLIGHT, AutomationConstant.FLIGHTS_AND_TC,
                Arrays.asList(flight1, flight2, flight3)));

        uniqueUrl = MessageFormat.format(
                paymentFormConfigureRepository.findByPosIdAndEnvironment(savedForm.getPosId(), AutomationConstant.CI_ENVOROMENT)
                                              .getUrl(),
                savedForm.getPartnerName(), savedForm.getUniqueId(), savedForm.getId());

    }

    /**
     * 
     */
    @Then("^I should see the details of all flight entered on travel info page$")
    public void verifyDetailsOfAllFlightDisplayedOnTravelInfoPageAsEntered() {

        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, AutomationConstant.GETTING_THERE),
                webDriverCommons.isDisplayed(flightGettingTherePage.getPageElements()
                                                                   .getHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.FLIGHT_NO, AutomationConstant.FIRST_FLIGHT_NUMBER),
                AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                       .getFirstFlightNo()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_DATE,
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(0)
                                                                    .getDepartureDate(),
                        AutomationConstant.FLIGHT)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(0)
                                                                    .getDepartureDate(),
                        AutomationConstant.FLIGHT),
                webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                               .getFirstDepartureDate()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE,
                        AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                          .getFirstDepartureAirportCode()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_CITY, AutomationConstant.FIRST_DEP_CITY),
                AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                  .getFirstDepartureCity()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT, AutomationConstant.FIRST_DEP_AIRPORT),
                AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                     .getFirstDepartureAirport()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(0)
                                                                         .getDepartureDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(0)
                                                                         .getDepartureDate()),
                webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                               .getFirstDepartureTime()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(0)
                                                                    .getArrivalDate(),
                        AutomationConstant.FLIGHT)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(0)
                                                                    .getArrivalDate(),
                        AutomationConstant.FLIGHT),
                webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                               .getFirstArrivalDate()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE,
                        AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                              .getFirstArrivalAirportCode()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_CITY, AutomationConstant.FIRST_ARRIVAL_CITY),
                AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                      .getFirstArrivalCity()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT, AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                         .getFirstArrivalAirport()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, AutomationConstant.GETTING_THERE, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(0)
                                                                         .getArrivalDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(0)
                                                                         .getArrivalDate()),
                webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                               .getFirstArrivalTime()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                 .getFirstAirline()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_THERE, PaymentFormsAsseartionMessages.AIRLINE_OPERAROR,
                        AutomationConstant.FIRST_FLIGHT_OPERATOR),
                AutomationConstant.FIRST_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                         .getFirstAirlineOperator()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_AROUND),
                webDriverCommons.isDisplayed(flightGettingAroundPage.getPageElements()
                                                                    .getHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.FLIGHT_NO,
                        AutomationConstant.FIRST_FLIGHT_NUMBER),
                AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                        .getFirstFlightNo()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.DEPARTURE_DATE,
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(1)
                                                                    .getDepartureDate(),
                        AutomationConstant.FLIGHT)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(1)
                                                                    .getDepartureDate(),
                        AutomationConstant.FLIGHT),
                webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                .getFirstDepartureDate()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE,
                        AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                           .getFirstDepartureAirportCode()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.DEPARTURE_CITY,
                        AutomationConstant.FIRST_DEP_CITY),
                AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                   .getFirstDepartureCity()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT,
                        AutomationConstant.FIRST_DEP_AIRPORT),
                AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                      .getFirstDepartureAirport()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(1)
                                                                         .getDepartureDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(1)
                                                                         .getDepartureDate()),
                webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                .getFirstDepartureTime()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(1)
                                                                    .getArrivalDate(),
                        AutomationConstant.FLIGHT)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(1)
                                                                    .getArrivalDate(),
                        AutomationConstant.FLIGHT),
                webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                .getFirstArrivalDate()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE,
                        AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                               .getFirstArrivalAirportCode()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_CITY,
                        AutomationConstant.FIRST_ARRIVAL_CITY),
                AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                       .getFirstArrivalCity()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT,
                        AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                          .getFirstArrivalAirport()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(1)
                                                                         .getArrivalDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(1)
                                                                         .getArrivalDate()),
                webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                .getFirstArrivalTime()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                  .getFirstAirline()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_AROUND, PaymentFormsAsseartionMessages.AIRLINE_OPERAROR,
                        AutomationConstant.FIRST_FLIGHT_OPERATOR),
                AutomationConstant.FIRST_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                          .getFirstAirlineOperator()));

        Assert.assertTrue(MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.GETTING_BACK),
                webDriverCommons.isDisplayed(flightGettingBackPage.getPageElements()
                                                                  .getHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.FLIGHT_NO,
                        AutomationConstant.FIRST_FLIGHT_NUMBER),
                AutomationConstant.FIRST_FLIGHT_NUMBER, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                      .getFirstFlightNo()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_DATE,
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(2)
                                                                    .getDepartureDate(),
                        AutomationConstant.FLIGHT)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(2)
                                                                    .getDepartureDate(),
                        AutomationConstant.FLIGHT),
                webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                              .getFirstDepartureDate()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT_CODE,
                        AutomationConstant.FIRST_DEP_AIRPORT_CODE),
                AutomationConstant.FIRST_DEP_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                         .getFirstDepartureAirportCode()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_CITY,
                        AutomationConstant.FIRST_DEP_CITY),
                AutomationConstant.FIRST_DEP_CITY, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                 .getFirstDepartureCity()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_AIRPORT,
                        AutomationConstant.FIRST_DEP_AIRPORT),
                AutomationConstant.FIRST_DEP_AIRPORT, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                    .getFirstDepartureAirport()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.DEPARTURE_TIME,
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(2)
                                                                         .getDepartureDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(2)
                                                                         .getDepartureDate()),
                webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                              .getFirstDepartureTime()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_DATE,
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(2)
                                                                    .getArrivalDate(),
                        AutomationConstant.FLIGHT)),
                utilities.getDateFromDataBase(paymentFormWithProduct.getFlightList()
                                                                    .get(2)
                                                                    .getArrivalDate(),
                        AutomationConstant.FLIGHT),
                webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                              .getFirstArrivalDate()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT_CODE,
                        AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE),
                AutomationConstant.FIRST_ARRIVAL_AIRPORT_CODE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                             .getFirstArrivalAirportCode()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_CITY,
                        AutomationConstant.FIRST_ARRIVAL_CITY),
                AutomationConstant.FIRST_ARRIVAL_CITY, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                     .getFirstArrivalCity()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_AIRPORT,
                        AutomationConstant.FIRST_ARRIVAL_AIRPORT),
                AutomationConstant.FIRST_ARRIVAL_AIRPORT, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                        .getFirstArrivalAirport()));

        Assert.assertEquals(MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED,
                PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.ARRIVAL_TIME,
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(2)
                                                                         .getArrivalDate())),
                utilities.getMinAndSecFromDataBase(paymentFormWithProduct.getFlightList()
                                                                         .get(2)
                                                                         .getArrivalDate()),
                webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                              .getFirstArrivalTime()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.AIRLINE_NAME, AutomationConstant.FIRST_AIRLINE),
                AutomationConstant.FIRST_AIRLINE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                .getFirstAirline()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_ENTERED, PaymentFormsAsseartionMessages.FIRST,
                        PaymentFormsAsseartionMessages.GETTING_BACK, PaymentFormsAsseartionMessages.AIRLINE_OPERAROR,
                        AutomationConstant.FIRST_FLIGHT_OPERATOR),
                AutomationConstant.FIRST_FLIGHT_OPERATOR, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                        .getFirstAirlineOperator()));

        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED_IN_SIDE_BAR, PaymentFormsAsseartionMessages.FLIGHT),
                webDriverCommons.isDisplayed(flightGettingTherePage.getPageElements()
                                                                   .getFlightHeadingForSideBar()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.COST_AMOUNT_IN_SIDE_BAR_FOR_PARTICULAR_PRODUCT_IS_NOT_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.FLIGHT, PaymentFormsBuilder.FLIGHT_AMOUNT),
                PaymentFormsBuilder.FLIGHT_AMOUNT,
                utilities.getAmountAsDoubleFromString(webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                     .getFlightAmountForSideBar())));

    }

    /**
     * 
     */
    @Then("^I should see message of days it takes for plane to arrive for each flight type$")
    public void verifyMessageOfDaysItTakesForPlaneToArriveForEachFlighTypeIsDisplayed() {
        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_THERE,
                        PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE),
                AutomationConstant.FLIGHT_ARRIVES_NEXT_DAY_MESSAGE, webDriverCommons.getText(flightGettingTherePage.getPageElements()
                                                                                                                   .getFirstFlightDayIndicator()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_AROUND,
                        PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE),
                AutomationConstant.FLIGHT_ARRIVES_AFTER_TWO_DAYS_MESSAGE, webDriverCommons.getText(flightGettingAroundPage.getPageElements()
                                                                                                                          .getFirstFlightDayIndicator()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.ITEM_FOR_FLIGHT_IS_NOT_DISPLAYED_AS_EXPECTED,
                        PaymentFormsAsseartionMessages.FIRST, PaymentFormsAsseartionMessages.GETTING_BACK,
                        PaymentFormsAsseartionMessages.DAY_INDICATOR, AutomationConstant.FLIGHT_ARRIVES_AFTER_FIVE_DAYS_MESSAGE),
                AutomationConstant.FLIGHT_ARRIVES_AFTER_FIVE_DAYS_MESSAGE, webDriverCommons.getText(flightGettingBackPage.getPageElements()
                                                                                                                         .getFirstFlightDayIndicator()));
    }

    /**
     * 
     */
    @Then("^I should see all t&c types displayed on travel info page$")
    public void verifyAllTAndCTypesDisplayedOnTravelInfoPage() {
        Assert.assertTrue(
                MessageFormat.format(PaymentFormsAsseartionMessages.HEADING_IS_NOT_DISPLAYED, PaymentFormsAsseartionMessages.IMPORTANT_INSTRUCTIONS),
                webDriverCommons.isDisplayed(importantInstructionsPage.getPageElements()
                                                                      .getImportantInstructionHeading()));

        Assert.assertEquals(
                MessageFormat.format(PaymentFormsAsseartionMessages.PRODUCT_DESCRIPTION_IS_NOT_DISPLAYED_AS_ENTERED, "",
                        PaymentFormsAsseartionMessages.IMPORTANT_INSTRUCTIONS, PaymentFormsBuilder.IMPORTANT_INSTRUCTIONS),
                PaymentFormsBuilder.IMPORTANT_INSTRUCTIONS, webDriverCommons.getText(importantInstructionsPage.getPageElements()
                                                                                                              .getImportantInstructionMessage()));

        verifyFinalDepositDueDateIsDisplayedOnTravelInfoSideBar();

        verifyFinalPaymentDueDateIsDisplayedOnTravelInfoSideBar();

    }

}
