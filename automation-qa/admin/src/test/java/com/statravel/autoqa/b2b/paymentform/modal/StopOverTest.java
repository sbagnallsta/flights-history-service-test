package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.StopOver;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;
import com.statravel.autoqa.page.b2b.paymentform.StopOverPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class StopOverTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private StopOverPage stopOverPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private StopOver stopOver1, stopOver2, editedStopOver1, editedStopOver2;

    /**
     * 
     */
    @Before
    public void init() {

        paymentFormPage.init();
        stopOverPage.init();

    }

    /**
     * 
     */
    @When("^I activate the Stopover section$")
    public void activateStopoverSection() {

        paymentFormPage.toggleStopOver();
    }

    /**
     * 
     */
    @Then("^I should see the Stopover section required message$")
    public void verifyStopoverSectionRequiredMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_STOPOVER_SECTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getStopOverRequireMessage()));
    }

    /**
     * 
     */
    @When("^I select add new Stopover$")
    public void selectAddNewStopover() {

        paymentFormPage.selectAddNewStopOver();
    }

    /**
     * 
     */
    @Then("^I should not see the Stopover section required message$")
    public void verifyStopoverSectionRequiredMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_STOPOVER_SECTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getStopOverRequireMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should see the Stopover details required message$")
    public void verifyStopoverDetailsRequiredMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_STOPOVER_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(stopOverPage.getPageElements()
                                                         .getPriceIsARequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_STOPOVER_PRODUCT, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(stopOverPage.getPageElements()
                                                         .getProductIsARequireMessage()));

    }

    /**
     * 
     */
    @When("^I fill in the details in the added Stopover$")
    public void fillInDetailsInAddedStopover() {

        stopOver1 = new StopOver("100", "StopOver product 1");

        stopOverPage.fillDetailsForFirstStopOver(stopOver1);
    }

    /**
     * 
     */
    @Then("^I should see Stopovers displayed with details$")
    public void verifyAddedDetailsDislayedInStopovers() {

        Assert.assertTrue("First stopover price input does not contains same value as given", stopOverPage.getPageElements()
                                                                                                          .getFirstPriceInput()
                                                                                                          .getAttribute("value")
                                                                                                          .contains(stopOver1.getPrice()));

        Assert.assertTrue("First stopover product input does not contains same value as given", stopOverPage.getPageElements()
                                                                                                            .getFirstProductInput()
                                                                                                            .getAttribute("value")
                                                                                                            .contains(stopOver1.getProduct()));
    }

    /**
     * 
     */
    @Then("^I should not see the Stopover details required message$")
    public void verifyStopoverDetailsRequiredMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_STOPOVER_NAME, AssertionMessages.IS),
                stopOverPage.getPageElements()
                            .getPriceIsARequireMessage()
                            .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_STOPOVER_PRODUCT, AssertionMessages.IS),
                stopOverPage.getPageElements()
                            .getProductIsARequireMessage()
                            .isDisplayed());
    }

    /**
     * 
     */
    @When("^I add a new Stopover$")
    public void addNewStopover() {

        activateStopoverSection();

        selectAddNewStopover();

        fillInDetailsInAddedStopover();
    }

    /**
     * 
     */
    @When("^I edit the data in the Stopover Price fields by entering alphabets$")
    public void editDataiInStopoverPriceFieldsByEnteringAlphabets() {

        editedStopOver1 = new StopOver("Test Data", "Test Data");

        stopOverPage.fillDetailsForFirstStopOver(editedStopOver1);
    }

    /**
     * 
     */
    @Then("^I should not see the alphabets input in the Stopover Price fields$")
    public void verifyAlphabetsInputIsNotDisplayedInStopoverPriceFields() {

        Assert.assertFalse("StopOver Price input contains APPHABETS", stopOverPage.getPageElements()
                                                                                  .getFirstPriceInput()
                                                                                  .getAttribute("value")
                                                                                  .contains(editedStopOver1.getPrice()));
    }

    /** 
     * 
     */
    @When("^I change the input in the Stopover price field to numbers$")
    public void changeInputInStopoverPriceFieldToNumbers() {

        editedStopOver1 = new StopOver("111", "First Test Data");

        stopOverPage.fillDetailsForFirstStopOver(editedStopOver1);

    }

    /**
     * 
     */
    @Then("^I should see the number input in the Stopover Price field with the currency$")
    public void verifyNumberInputInStopoverPriceFieldContainsTheCurrency() {

        Assert.assertTrue("StopOver Price input does not contain " + "$" + " sign", stopOverPage.getPageElements()
                                                                                                .getFirstPriceInput()
                                                                                                .getAttribute("value")
                                                                                                .contains("$"));
    }

    /**
     * 
     */
    @When("^I edit the Stopover product field details$")
    public void editStopoverProductFieldDetails() {

        editedStopOver2 = new StopOver("555", "Edited Test Data");

        stopOverPage.fillDetailsForFirstStopOver(editedStopOver2);

    }

    /**
     * 
     */
    @Then("^I should see edited data in the Stopover fields$")
    public void verifyEditedDataDisplayedInStpoverFields() {

        Assert.assertFalse("StopOver Price input contain old data even after editing them", stopOverPage.getPageElements()
                                                                                                        .getFirstPriceInput()
                                                                                                        .getAttribute("value")
                                                                                                        .contains(editedStopOver1.getPrice()));

        Assert.assertFalse("StopOver Product Information input contain old data even after editing them", stopOverPage.getPageElements()
                                                                                                                      .getFirstProductInput()
                                                                                                                      .getAttribute("value")
                                                                                                                      .contains(
                                                                                                                              editedStopOver1.getProduct()));

        Assert.assertTrue("Stopover Price input does not contain edited data after editing them", stopOverPage.getPageElements()
                                                                                                              .getFirstPriceInput()
                                                                                                              .getAttribute("value")
                                                                                                              .contains(editedStopOver2.getPrice()));

        Assert.assertTrue("StopOver Product Information input does not contain edited data after editing them", stopOverPage.getPageElements()
                                                                                                                            .getFirstProductInput()
                                                                                                                            .getAttribute("value")
                                                                                                                            .contains(
                                                                                                                                    editedStopOver2.getProduct()));
    }

    /**
     * 
     */
    @When("^I add two new Stopovers$")
    public void addTwoNewStopovers() {

        selectAddNewStopover();

        stopOver1 = new StopOver("100", "first stopover");

        stopOverPage.fillDetailsForFirstStopOver(stopOver1);

        selectAddNewStopover();

        stopOver2 = new StopOver("$200", "second stopover");

        stopOverPage.fillDetailsForSecondStopOver(stopOver2);

    }

    /**
     * 
     */
    @Then("^I should see two Stopovers on the Stopover section$")
    public void verifyTwoStopoversDisplayedOnStopoverSection() {

        Assert.assertTrue("First Stopovers Product is not displayed", stopOverPage.getPageElements()
                                                                                  .getFirstPriceInput()
                                                                                  .getAttribute("value")
                                                                                  .contains(stopOver1.getPrice()));

        Assert.assertTrue("Second Stopovers Product is not displayed", stopOverPage.getPageElements()
                                                                                   .getSecondPriceInput()
                                                                                   .getAttribute("value")
                                                                                   .contains(stopOver2.getPrice()));
    }

    /**
     * 
     */
    @When("^I delete both Stopovers$")
    public void deleteBothStopovers() {

        stopOverPage.deleteSecondStopOver();

        stopOverPage.deleteFirstStopOver();

    }

}
