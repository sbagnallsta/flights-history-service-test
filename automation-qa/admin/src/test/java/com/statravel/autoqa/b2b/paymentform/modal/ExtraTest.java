package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Extra;
import com.statravel.autoqa.page.b2b.paymentform.ExtraPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class ExtraTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private ExtraPage extraPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private Extra extra1, extra2, editeExtraPrice, editedExtraProducts;

    /**
     * 
     */
    @Before
    public void init() {
        paymentFormPage.init();
        extraPage.init();
    }

    /**
     * 
     */
    @When("^I activate Extras section$")
    public void activateExtrasSection() {

        paymentFormPage.toggleExtrasSection();
    }

    /**
     * 
     */
    @Then("^I should see Extras section required message$")
    public void verifyExtraIsRequireMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_EXTRAS_SECTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getExtraIsRequireMessage()));
    }

    /**
     * 
     */
    @When("^I select add new Extras$")
    public void selectAddNewForExtras() {

        paymentFormPage.seclectAddNewExtras();
    }

    /**
     * 
     */
    @Then("^I should not see Extras section required message$")
    public void verifyExtraIsRequireMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_EXTRAS_SECTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getExtraIsRequireMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should see the Extra product details required message$")
    public void verifyExtraProductDetailsRequireMessagesIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_EXTRAS_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(extraPage.getPageElements()
                                                      .getProductNameIsRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_EXTRAS_INFORMATION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(extraPage.getPageElements()
                                                      .getProductInformationIsRequireMessage()));
    }

    /**
     * 
     */
    @When("^I fill in the details in added Extras$")
    public void fillDetaisInExtra() {

        extra1 = new Extra("100", "Test Extra Name", "Test Extra Information");

        extraPage.fillDetailsForFirstExtra(extra1);
    }

    /**
     * 
     */
    @Then("^I should not see the Extras product details required message$")
    public void verifyExtraProductDetailsRequireMessagesIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_EXTRAS_NAME, AssertionMessages.IS),
                extraPage.getPageElements()
                         .getProductNameIsRequireMessage()
                         .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_EXTRAS_INFORMATION, AssertionMessages.IS),
                extraPage.getPageElements()
                         .getProductInformationIsRequireMessage()
                         .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should see Extra with added details$")
    public void verifyAddedDetailsIsDisplayedInExtra() {

        Assert.assertTrue("Extra's Prise input value is not same as entered", extraPage.getPageElements()
                                                                                       .getFirstPriceInput()
                                                                                       .getAttribute("value")
                                                                                       .contains(extra1.getPrice()));

        Assert.assertTrue("Extra's Product Name input value is not same as entered", extraPage.getPageElements()
                                                                                              .getFirstProductNameInput()
                                                                                              .getAttribute("value")
                                                                                              .contains(extra1.getProductName()));

        Assert.assertTrue("Extra's Product Information input value is not same as entered", extraPage.getPageElements()
                                                                                                     .getFirstProductInformatinInput()
                                                                                                     .getAttribute("value")
                                                                                                     .contains(extra1.getProductInformation()));
    }

    /**
     * 
     */
    @When("^I add New Extras twice$")
    public void addExtrasTwice() {

        selectAddNewForExtras();

        selectAddNewForExtras();

        fillDetaisInExtra();

        extra2 = new Extra("200", "Second Extra Name", "Second Extra Information");

        extraPage.fillDetailsForSecondExtra(extra2);

    }

    /**
     * 
     */
    @Then("^I should see two Extras on the Extras section$")
    public void verifyTwoExtrasDisplayedOnExtrasSection() {

        Assert.assertTrue("First Extra's Prise input value is not same as entered", extraPage.getPageElements()
                                                                                             .getFirstProductNameInput()
                                                                                             .getAttribute("value")
                                                                                             .contains(extra1.getProductName()));
        Assert.assertTrue("Second Extra's Prise input value is not same as entered", extraPage.getPageElements()
                                                                                              .getSecondProductNameInput()
                                                                                              .getAttribute("value")
                                                                                              .contains(extra2.getProductName()));
    }

    /**
     * 
     */
    @When("^I delete both Extras$")
    public void deleteBothExtra() {

        extraPage.deleteSecondExtra();

        extraPage.deleteFirstExtra();
    }

    /**
     * 
     */
    @When("^I add a new Extra$")
    public void addNewExtra() {

        activateExtrasSection();

        selectAddNewForExtras();

        fillDetaisInExtra();

    }

    /**
     * 
     */
    @When("^I edit the data in the Extras Price fields by entering alphabets$")
    public void editDataInExtrasPriceFieldsByEnteringAlphabets() {

        editeExtraPrice = new Extra("ABCD", "gfjhgf", "sjg");

        extraPage.clearExtrasInputs();

        extraPage.fillDetailsForFirstExtra(editeExtraPrice);

    }

    /**
     * 
     */
    @When("^I edit the Extras product field details$")
    public void editExtrasProductFieldDetails() {

        extraPage.clearExtrasInputs();

        editedExtraProducts = new Extra("300", "Edited Name", "Edited Information");

        extraPage.fillDetailsForFirstExtra(editedExtraProducts);

    }

    /**
     * 
     */
    @Then("^I should not see the alphabets input in the Extras Price fields$")
    public void verifyAlphabetsInputIsNotDisplayedInExtrasPriceFields() {

        Assert.assertFalse("Extra's price input value contain Alphabet", extraPage.getPageElements()
                                                                                  .getFirstPriceInput()
                                                                                  .getAttribute("value")
                                                                                  .contains(editeExtraPrice.getPrice()));
    }

    /**
     * 
     */
    @Then("^I should see edited data in the Extras product fields$")
    public void verifyEditedDataInTheExtrasProductFieldsIsDisplayed() {

        Assert.assertFalse("Extra's Price input contains old value even after editing them", extraPage.getPageElements()
                                                                                                      .getFirstPriceInput()
                                                                                                      .getAttribute("value")
                                                                                                      .contains(extra1.getPrice()));

        Assert.assertFalse("Extra's Product Name input contains old value even after editing them", extraPage.getPageElements()
                                                                                                             .getFirstPriceInput()
                                                                                                             .getAttribute("value")
                                                                                                             .contains(extra1.getProductName()));

        Assert.assertFalse("Extra's Product information input contains old value even after editing them", extraPage.getPageElements()
                                                                                                                    .getFirstPriceInput()
                                                                                                                    .getAttribute("value")
                                                                                                                    .contains(
                                                                                                                            extra1.getProductInformation()));

        Assert.assertTrue("Extra's Price input not containing edited data", extraPage.getPageElements()
                                                                                     .getFirstPriceInput()
                                                                                     .getAttribute("value")
                                                                                     .contains(editedExtraProducts.getPrice()));

        Assert.assertTrue("Extra's Product Name input not containing edited data", extraPage.getPageElements()
                                                                                            .getFirstProductNameInput()
                                                                                            .getAttribute("value")
                                                                                            .contains(editedExtraProducts.getProductName()));

        Assert.assertTrue("Extra's Product Information input not containing edited data", extraPage.getPageElements()
                                                                                                   .getFirstProductInformatinInput()
                                                                                                   .getAttribute("value")
                                                                                                   .contains(
                                                                                                           editedExtraProducts.getProductInformation()));

    }

    /**
     * 
     */
    @When("^I change the input in Extra price field to numbers$")
    public void changeInputInThePriceFieldToNumbers() {

        extraPage.clearExtrasInputs();

        editeExtraPrice = new Extra("100", "", "");

        extraPage.fillDetailsForFirstExtra(editeExtraPrice);
    }

    /**
     * 
     */
    @Then("^I should see the number input in the Extras Price field with a dollar sign$")
    public void verifyNumberInputInTheExtrasPriceFieldcontainsDollarSign() {

        Assert.assertTrue("", extraPage.getPageElements()
                                       .getFirstPriceInput()
                                       .getAttribute("value")
                                       .contains("$"));
    }

}
