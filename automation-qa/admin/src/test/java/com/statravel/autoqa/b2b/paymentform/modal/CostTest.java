package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.Utilities;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Cost;
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
public class CostTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private Utilities utilities;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private Cost cost, editedCost;

    private String originalAmount, depositAmount, balanceAmount, flightAmount, accommodation, transferAmount, otherAmount;

    private double newOriginalAmount, newBalanceAmount, newDepositAmount, newFlightAmount, newAccommodation, newTransferAmount, newOtherAmount,
            balance;

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
    @Given("^I should see one cost required messages on all require cost fields$")
    public void verifyAtLeastOneCostRequiredMessagesIsDisplayedForAllCostFields() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS_NOT,
                        AssertionMessages.FLIGHT_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireMessageForFlight()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS_NOT,
                        AssertionMessages.ACCOMMODATION_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireMessageForAccommodation()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS_NOT,
                        AssertionMessages.TRANSFER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireMessageForTranfer()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS_NOT,
                        AssertionMessages.OTHER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAtleastOneCostRequireMessageForOther()));
    }

    /**
     * 
     */
    @Given("^all cost input field should be disable$")
    public void verifyAllCostInputAreDisable() {
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.FLIGHT_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFlightAmountInputDisableMode()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.AIRFARE_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAirFareAmountInputDisableMode()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.TAXES_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTaxesAmountInputDisableMode()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.TERMS_CONDITION),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTermsAndConditionInputDisableMode()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.ACCOMMODATION_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAccommodationAmountInputDisableMode()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.TRANSFER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTransferAmountInputDisableMode()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.OTHER_COST),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOtherAmountInputDisableMode()));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.BALANCE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDepositAmountInputDisableMode()));
    }

    /**
     * 
     * @param costOption
     *            cost option
     */
    @When("^I select \"([^\"]*)\"$")
    public void selectCost(final String costOption) {
        if (costOption.equals("Flight")) {
            paymentFormPage.toggleFlightAmountSectionInactiveMode();
        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            paymentFormPage.toggleAccommodationAmountSectionInactiveMode();
        } else if (costOption.equalsIgnoreCase("Transfer")) {
            paymentFormPage.toggleTransferAmountSectionInactiveMode();
        } else if (costOption.equalsIgnoreCase("Others")) {
            paymentFormPage.toggleOtherAmountSectionInactiveMode();
        }

    }

    /**
     * 
     * 
     * @param costOption
     *            cost option
     */
    @Then("^I should see selected \"([^\"]*)\" required message$")
    public void verifyRequiredMessageIsDisplayForSelectedCost(final String costOption) {

        if (costOption.equalsIgnoreCase("Flight")) {
            Assert.assertTrue("Flight amount requrire message is not displayed", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                             .getFlightAmountRequireMessage()));
        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            Assert.assertTrue("Accommodation amount requrire message is not displayed", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                                    .getAccommodationAmountRequireMessage()));
        } else if (costOption.equalsIgnoreCase("Transfer")) {
            Assert.assertTrue("Trasfer amount requrire message is not displayed", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                              .getTransferAmountRequireMessage()));
        } else if (costOption.equalsIgnoreCase("Others")) {
            Assert.assertTrue("Others amount requrire message is not displayed", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                             .getOtherAmountRequireMessage()));
        }

    }

    /**
     * 
     */
    @Then("^I should not see one cost required messages on all require cost fields$")
    public void verifyAtLeastOneCostRequiredMessagesIsNotDisplayedForAllCostFields() {

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS,
                        AssertionMessages.FLIGHT_COST),
                paymentFormPage.getPageElements()
                               .getAtleastOneCostRequireMessageForFlight()
                               .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS,
                        AssertionMessages.ACCOMMODATION_COST),
                paymentFormPage.getPageElements()
                               .getAtleastOneCostRequireMessageForAccommodation()
                               .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS,
                        AssertionMessages.TRANSFER_COST),
                paymentFormPage.getPageElements()
                               .getAtleastOneCostRequireMessageForTranfer()
                               .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_AT_LEAST_ONE_COST_REQUIRE, AssertionMessages.IS,
                        AssertionMessages.OTHER_COST),
                paymentFormPage.getPageElements()
                               .getAtleastOneCostRequireMessageForOther()
                               .isDisplayed());
    }

    /**
     * 
     * @param costOption
     *            cost option
     * 
     */
    @When("^I fill in cost details for the selected \"([^\"]*)\" field$")
    public void fillInCostDetailsForSelectedField(final String costOption) {
        if (costOption.equalsIgnoreCase("Flight")) {
            cost = new Cost.CostBuilder().setFlightAmountActive(true)
                                         .setFlightAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnFlightCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getFlightAmountInputEnableMode()
                                            .getAttribute("value");

        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            cost = new Cost.CostBuilder().setAccommodationAmountActive(true)
                                         .setAccommodationAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnAccommodationCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getAccommodationAmountInputEnableMode()
                                            .getAttribute("value");
        } else if (costOption.equalsIgnoreCase("Transfer")) {
            cost = new Cost.CostBuilder().setTransferAmountActive(true)
                                         .setTransferAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnTransferCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getTransferAmountInputEnableMode()
                                            .getAttribute("value");

        } else if (costOption.equalsIgnoreCase("Others")) {
            cost = new Cost.CostBuilder().setOtherAmountActive(true)
                                         .setOtherAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnOtherCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getOtherAmountInputEnableMode()
                                            .getAttribute("value");
        }
    }

    /**
     * TODO.
     * 
     * @param costOption
     *            cost option
     */
    @Then("^I should not see required message on the selected \"([^\"]*)\"$")
    public void verifyRequiredMessageIsNotDisplayForSelectedCost(final String costOption) {
        if (costOption.equalsIgnoreCase("Flight")) {
            Assert.assertFalse("", paymentFormPage.getPageElements()
                                                  .getFlightAmountRequireMessage()
                                                  .isDisplayed());
        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            Assert.assertFalse("", paymentFormPage.getPageElements()
                                                  .getAccommodationAmountRequireMessage()
                                                  .isDisplayed());
        } else if (costOption.equalsIgnoreCase("Transfer")) {
            Assert.assertFalse("", paymentFormPage.getPageElements()
                                                  .getTransferAmountRequireMessage()
                                                  .isDisplayed());
        } else if (costOption.equalsIgnoreCase("Others")) {
            Assert.assertFalse("", paymentFormPage.getPageElements()
                                                  .getOtherAmountRequireMessage()
                                                  .isDisplayed());
        }

    }

    /**
     * 
     */
    @When("^I select all cost options$")
    public void selectAllCostOptions() {
        paymentFormPage.toggleFlightAmountSectionInactiveMode();
        paymentFormPage.toggleAirFareAmountSectionInactiveMode();
        paymentFormPage.toggleTaxesAmountSectionInactiveMode();
        paymentFormPage.toggleTermsAndConditionInactiveMode();
        paymentFormPage.toggleAccommodationAmountSectionInactiveMode();
        paymentFormPage.toggleTransferAmountSectionInactiveMode();
        paymentFormPage.toggleOtherAmountSectionInactiveMode();
        paymentFormPage.toggleDepositAmountSectionInactiveMode();
    }

    /**
     * 
     */
    @Then("^I should see required message on all cost fields$")
    public void verifyRequiredMessageIsDisplayedOnAllCostFields() {
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.FLIGHT_COST,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getFlightAmountRequireMessage()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.AIRFARE_COST,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAirFareAmountRequireMessage()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.TAXES_COST,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTaxesAmountRequireMessage()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.TERMS_CONDITION,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTermsAndConditionRequireMessage()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.ACCOMMODATION_COST,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getAccommodationAmountRequireMessage()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.TRANSFER_COST,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getTransferAmountRequireMessage()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.OTHER_COST,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOtherAmountRequireMessage()));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.DEPOSIT,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDepositAmountRequireMessage()));
    }

    /**
     * 
     * 
     */
    @When("^I fill in cost details for all cost$")
    public void fillInCostDetailsForAllCost() {

        cost = new Cost.CostBuilder().setAccommodationAmountActive(true)
                                     .setFlightAmountActive(true)
                                     .setAirFareAmountActive(true)
                                     .setTaxesAmountActive(true)
                                     .setTermsAndConditionInputActive(true)
                                     .setAccommodationAmountActive(true)
                                     .setTransferAmountActive(true)
                                     .setOtherAmountActive(true)
                                     .setDepositAmountActive(true)
                                     .setFlightAmount(utilities.getRandomIntOverOneThousand())
                                     .setAirFareAmount(utilities.getRandomIntOverOneThousand())
                                     .setTaxesAmount(utilities.getRandomIntOverOneThousand())
                                     .setTermsAndConditionInput("Terms and condition")
                                     .setAccommodationAmount(utilities.getRandomIntOverOneThousand())
                                     .setTransferAmount(utilities.getRandomIntOverOneThousand())
                                     .setOtherAmount(utilities.getRandomIntOverOneThousand())
                                     .setDepositAmount(utilities.getRandomIntUnderTwoHundred())
                                     .build();

        paymentFormPage.fillCost(cost);

        paymentFormPage.clickOnDepositCostHeading();

    }

    /**
     * 
     */
    @Then("^I should not see required message on all cost fields$")
    public void verifyRequiredMessageIsNotDisplayedOnAllCostFields() {
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.FLIGHT_COST,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getFlightAmountRequireMessage()
                               .isDisplayed());
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.AIRFARE_COST,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getAirFareAmountRequireMessage()
                               .isDisplayed());
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.TAXES_COST,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getTaxesAmountRequireMessage()
                               .isDisplayed());
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.TERMS_CONDITION,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getTermsAndConditionRequireMessage()
                               .isDisplayed());
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.ACCOMMODATION_COST,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getAccommodationAmountRequireMessage()
                               .isDisplayed());
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.TRANSFER_COST,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getTransferAmountRequireMessage()
                               .isDisplayed());
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.OTHER_COST,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getOtherAmountRequireMessage()
                               .isDisplayed());
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.DEPOSIT,
                        AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getDepositAmountRequireMessage()
                               .isDisplayed());
    }

    /**
     * 
     * @param costOption
     *            cost option
     */
    @Then("^I should see cost details in the \"([^\"]*)\" field$")
    public void verifyCostDetailsInCostField(final String costOption) {
        if (costOption.equalsIgnoreCase("Flight")) {
            Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_EMPTY, AssertionMessages.FLIGHT_COST),
                    paymentFormPage.getPageElements()
                                   .getFlightAmountRequireMessage()
                                   .getAttribute("value")
                                   .isEmpty());

        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_EMPTY, AssertionMessages.ACCOMMODATION_COST),
                    paymentFormPage.getPageElements()
                                   .getAccommodationAmountRequireMessage()
                                   .getAttribute("value")
                                   .isEmpty());
        } else if (costOption.equalsIgnoreCase("Transfer")) {
            Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_EMPTY, AssertionMessages.TRANSFER_COST),
                    paymentFormPage.getPageElements()
                                   .getTransferAmountRequireMessage()
                                   .getAttribute("value")
                                   .isEmpty());
        } else if (costOption.equalsIgnoreCase("Others")) {
            Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_EMPTY, AssertionMessages.OTHER_MEAL),
                    paymentFormPage.getPageElements()
                                   .getOtherAmountRequireMessage()
                                   .getAttribute("value")
                                   .isEmpty());
        }
    }

    /**
     * 
     * @param costOption
     *            cost option
     */
    @When("^I edit the cost details in the \"([^\"]*)\" field$")
    public void editCostDetailsInCostField(final String costOption) {
        if (costOption.equalsIgnoreCase("Flight")) {
            editedCost = new Cost.CostBuilder().setFlightAmountActive(true)
                                               .setFlightAmount(utilities.getRandomIntUnderTwoHundred())
                                               .build();

            paymentFormPage.fillCost(editedCost);

        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            editedCost = new Cost.CostBuilder().setAccommodationAmountActive(true)
                                               .setAccommodationAmount(utilities.getRandomIntUnderTwoHundred())
                                               .build();

            paymentFormPage.fillCost(editedCost);

        } else if (costOption.equalsIgnoreCase("Transfer")) {
            editedCost = new Cost.CostBuilder().setTransferAmountActive(true)
                                               .setTransferAmount(utilities.getRandomIntUnderTwoHundred())
                                               .build();

            paymentFormPage.fillCost(editedCost);

        } else if (costOption.equalsIgnoreCase("Others")) {
            editedCost = new Cost.CostBuilder().setOtherAmountActive(true)
                                               .setOtherAmount(utilities.getRandomIntUnderTwoHundred())
                                               .build();

            paymentFormPage.fillCost(editedCost);

        }
    }

    /**
     * 
     * @param costOption
     *            cost option
     */
    @Then("^I should see the edited details in the \"([^\"]*)\" field$")
    public void verifyCostFieldInputDetailsEdited(final String costOption) {
        if (costOption.equalsIgnoreCase("Flight")) {
            Assert.assertFalse(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_EDITED_FIELD_CONFIRMATION,
                            AssertionMessages.FLIGHT_COST),
                    paymentFormPage.getPageElements()
                                   .getFlightAmountInputEnableMode()
                                   .getAttribute("value")
                                   .contains(originalAmount));

            Assert.assertNotEquals(originalAmount, paymentFormPage.getPageElements()
                                                                  .getFlightAmountInputEnableMode()
                                                                  .getAttribute("value"));
        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            Assert.assertFalse(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_EDITED_FIELD_CONFIRMATION,
                            AssertionMessages.ACCOMMODATION_COST),
                    paymentFormPage.getPageElements()
                                   .getAccommodationAmountInputEnableMode()
                                   .getAttribute("value")
                                   .contains(originalAmount));
            Assert.assertNotEquals(originalAmount, paymentFormPage.getPageElements()
                                                                  .getAccommodationAmountInputEnableMode()
                                                                  .getAttribute("value"));
        } else if (costOption.equalsIgnoreCase("Transfer")) {
            Assert.assertFalse(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_EDITED_FIELD_CONFIRMATION,
                            AssertionMessages.TRANSFER_COST),
                    paymentFormPage.getPageElements()
                                   .getTransferAmountInputEnableMode()
                                   .getAttribute("value")
                                   .contains(originalAmount));
            Assert.assertNotEquals(originalAmount, paymentFormPage.getPageElements()
                                                                  .getTransferAmountInputEnableMode()
                                                                  .getAttribute("value"));
        } else if (costOption.equalsIgnoreCase("Others")) {
            Assert.assertFalse(
                    MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_INPUT_EDITED_FIELD_CONFIRMATION,
                            AssertionMessages.OTHER_COST),
                    paymentFormPage.getPageElements()
                                   .getOtherAmountInputEnableMode()
                                   .getAttribute("value")
                                   .contains(originalAmount));

            Assert.assertNotEquals(originalAmount, paymentFormPage.getPageElements()
                                                                  .getOtherAmountInputEnableMode()
                                                                  .getAttribute("value"));

        }
    }

    /**
     * 
     */
    @When("^I activate balance section$")
    public void activateBalanceSection() {

        paymentFormPage.toggleBalanceSectionInactiveMode();
    }

    /**
     * 
     */
    @Then("^I should not be able to fill in details for balance$")
    public void verifyBalanceInputFieldIsDisable() {
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_COST_INPUT_FIELD_DISABLE, AssertionMessages.BALANCE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDepositAmountInputDisableMode()));
    }

    /**
     * 
     */
    @Then("^I should see the balance field required message$")
    public void verifyBalanceFieldRequiredMessageIsDisplayed() {
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.BALANCE),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getBalanceAmountRequireMessage()));

    }

    /**
     * 
     */
    @When("^I activate the deposit section$")
    public void activateDepositSection() {
        paymentFormPage.toggleDepositAmountSectionInactiveMode();
    }

    /**
     * 
     */
    @Then("^I should see the deposit field required message$")
    public void verifyDepositFieldRequiredMessageIsDisplayed() {
        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_INPUT_FIELD_REQUIRE_MESSAGE, AssertionMessages.DEPOSIT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getDepositAmountRequireMessage()));
    }

    /**
     * 
     * 
     */
    @When("^I fill in the deposit field$")
    public void fillInDepositField() {
        cost = new Cost.CostBuilder().setDepositAmountActive(true)
                                     .setDepositAmount(utilities.getRandomIntUnderTwoHundred())
                                     .build();
        paymentFormPage.fillCost(cost);

        paymentFormPage.clickOnDepositCostHeading();

        depositAmount = paymentFormPage.getPageElements()
                                       .getDepositAmountInputEnableMode()
                                       .getAttribute("value");

        depositAmount = depositAmount.substring(1);
        if (depositAmount.contains(",")) {
            depositAmount = depositAmount.replace(",", "");
        }
        newDepositAmount = Double.parseDouble(depositAmount);

    }

    /**
     * 
     */
    @Then("^I should see the balance updated by default$")
    public void verifyBalanceUpdatedByDefault() {

        balanceAmount = paymentFormPage.getPageElements()
                                       .getBalanceAmountInputDisableMode()
                                       .getAttribute("value");

        balanceAmount = balanceAmount.substring(1);

        if (balanceAmount.contains(",")) {
            balanceAmount = balanceAmount.replace(",", "");
        }
        newBalanceAmount = Double.parseDouble(balanceAmount);

        Assert.assertTrue("Balance is not updeted as ", newBalanceAmount == newOriginalAmount - newDepositAmount);

    }

    /**
     * 
     * @param costOption
     *            cost price
     */
    @When("^I fill in cost details for the selected \"([^\"]*)\" field and get inputed value$")
    public void fillInCostDetailsForSelectedFieldAndGetInputedValue(final String costOption) {

        if (costOption.equalsIgnoreCase("Flight")) {
            cost = new Cost.CostBuilder().setFlightAmountActive(true)
                                         .setFlightAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnFlightCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getFlightAmountInputEnableMode()
                                            .getAttribute("value");

        } else if (costOption.equalsIgnoreCase("Accommodation")) {
            cost = new Cost.CostBuilder().setAccommodationAmountActive(true)
                                         .setAccommodationAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnAccommodationCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getAccommodationAmountInputEnableMode()
                                            .getAttribute("value");

        } else if (costOption.equalsIgnoreCase("Transfer")) {
            cost = new Cost.CostBuilder().setTransferAmountActive(true)
                                         .setTransferAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnTransferCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getTransferAmountInputEnableMode()
                                            .getAttribute("value");

        } else if (costOption.equalsIgnoreCase("Others")) {
            cost = new Cost.CostBuilder().setOtherAmountActive(true)
                                         .setOtherAmount(utilities.getRandomIntOverOneThousand())
                                         .build();

            paymentFormPage.fillCost(cost);

            paymentFormPage.clickOnOtherCostHeading();

            originalAmount = paymentFormPage.getPageElements()
                                            .getOtherAmountInputEnableMode()
                                            .getAttribute("value");
        }

        originalAmount = originalAmount.substring(1);

        if (originalAmount.contains(",")) {
            originalAmount = originalAmount.replace(",", "");
        }

        newOriginalAmount = Double.parseDouble(originalAmount);
    }

    /**
     * 
     * @param costOption
     *            cost Option
     */
    @Then("^I should see the balance updated by default to the amount of the \"([^\"]*)\"$")
    public void verifyBalanceUpdatedByDefaultToAmountEnteredInCostField(final String costOption) {

        originalAmount = originalAmount.substring(1);

        if (originalAmount.contains(",")) {
            originalAmount = originalAmount.replace(",", "");
        }

        newOriginalAmount = Double.parseDouble(originalAmount);

        balanceAmount = paymentFormPage.getPageElements()
                                       .getBalanceAmountInputDisableMode()
                                       .getAttribute("value");

        balanceAmount = balanceAmount.substring(1);

        if (balanceAmount.contains(",")) {
            balanceAmount = balanceAmount.replace(",", "");
        }

        newBalanceAmount = Double.parseDouble(balanceAmount);

        Assert.assertTrue("Balance is not updetd", newOriginalAmount == newBalanceAmount);
    }

    /**
     * 
     */
    @Then("^I should see the balance updated by default to the amount of all cost options -deposit$")
    public void verifyBalanceUpdatedByDefaultToTheAmountOfAllCostOptionsMinusdeposit() {

        flightAmount = paymentFormPage.getPageElements()
                                      .getFlightAmountInputEnableMode()
                                      .getAttribute("value");
        flightAmount = flightAmount.substring(1);
        if (flightAmount.contains(",")) {
            flightAmount = flightAmount.replace(",", "");
        }
        newFlightAmount = Double.parseDouble(flightAmount);

        accommodation = paymentFormPage.getPageElements()
                                       .getAccommodationAmountInputEnableMode()
                                       .getAttribute("value");
        accommodation = accommodation.substring(1);
        if (accommodation.contains(",")) {
            accommodation = accommodation.replace(",", "");
        }
        newAccommodation = Double.parseDouble(accommodation);

        transferAmount = paymentFormPage.getPageElements()
                                        .getTransferAmountInputEnableMode()
                                        .getAttribute("value");
        transferAmount = transferAmount.substring(1);

        if (transferAmount.contains(",")) {
            transferAmount = transferAmount.replace(",", "");
        }
        newTransferAmount = Double.parseDouble(transferAmount);

        otherAmount = paymentFormPage.getPageElements()
                                     .getOtherAmountInputEnableMode()
                                     .getAttribute("value");
        otherAmount = otherAmount.substring(1);
        if (otherAmount.contains(",")) {
            otherAmount = otherAmount.replace(",", "");
        }
        newOtherAmount = Double.parseDouble(otherAmount);

        depositAmount = paymentFormPage.getPageElements()
                                       .getDepositAmountInputEnableMode()
                                       .getAttribute("value");
        depositAmount = depositAmount.substring(1);
        if (depositAmount.contains(",")) {
            depositAmount = depositAmount.replace(",", "");
        }
        newDepositAmount = Double.parseDouble(depositAmount);

        balanceAmount = paymentFormPage.getPageElements()
                                       .getBalanceAmountInputDisableMode()
                                       .getAttribute("value");

        balanceAmount = balanceAmount.substring(1);

        if (balanceAmount.contains(",")) {
            balanceAmount = balanceAmount.replace(",", "");
        }
        newBalanceAmount = Double.parseDouble(balanceAmount);

        balance = (newFlightAmount + newAccommodation + newTransferAmount + newOtherAmount) - newDepositAmount;

        Assert.assertTrue("Balance is differ then all cost inputed", balance == newBalanceAmount);

    }

    /**
     * 
     */
    @When("^I fill cost for flights$")
    public void fillFlightCost() {
        paymentFormPage.toggleFlightAmountSectionInactiveMode();
        cost = new Cost.CostBuilder().setFlightAmountActive(true)
                                     .setFlightAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);

        paymentFormPage.clickOnFlightCostHeading();

    }

    /**
     * 
     */
    @When("^I fill cost for accommodation$")
    public void fillCostForAccommodation() {
        paymentFormPage.toggleAccommodationAmountSectionInactiveMode();
        cost = new Cost.CostBuilder().setAccommodationAmountActive(true)
                                     .setAccommodationAmount(utilities.getRandomIntOverOneThousand())
                                     .build();

        paymentFormPage.fillCost(cost);

        paymentFormPage.clickOnAccommodationCostHeading();

    }

    /**
     * 
     */
    @Then("^I should see the balance updated by default to the amount of flights\\+accommodation-deposit$")
    public void verifyBalanceUpdetedAsPerFlighAndAccommodationCost() {

        flightAmount = paymentFormPage.getPageElements()
                                      .getFlightAmountInputEnableMode()
                                      .getAttribute("value");
        flightAmount = flightAmount.substring(1);
        if (flightAmount.contains(",")) {
            flightAmount = flightAmount.replace(",", "");
        }
        newFlightAmount = Double.parseDouble(flightAmount);

        accommodation = paymentFormPage.getPageElements()
                                       .getAccommodationAmountInputEnableMode()
                                       .getAttribute("value");
        accommodation = accommodation.substring(1);
        if (accommodation.contains(",")) {
            accommodation = accommodation.replace(",", "");
        }
        newAccommodation = Double.parseDouble(accommodation);

        balanceAmount = paymentFormPage.getPageElements()
                                       .getBalanceAmountInputDisableMode()
                                       .getAttribute("value");

        balanceAmount = balanceAmount.substring(1);

        if (balanceAmount.contains(",")) {
            balanceAmount = balanceAmount.replace(",", "");
        }

        newBalanceAmount = Double.parseDouble(balanceAmount);

        balance = (newFlightAmount + newAccommodation) - newDepositAmount;
        Assert.assertTrue("Balance is differ then flight cost and accommodatio cost and deposit inputed", balance == newBalanceAmount);

    }
}
