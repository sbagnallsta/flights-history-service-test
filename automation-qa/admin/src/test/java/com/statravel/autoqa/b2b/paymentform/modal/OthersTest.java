package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Others;
import com.statravel.autoqa.page.b2b.paymentform.OthersPage;
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
public class OthersTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private OthersPage othersPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private Others others1, others2, editedOthers;

    /**
     * 
     */
    @Before
    public void init() {

        paymentFormPage.init();
        othersPage.init();
        paymentFormPage.init();

    }

    /**
     * 
     */
    @When("^I activate Others section$")
    public void activateOtheres() {

        paymentFormPage.toggleOthersSectionActiveBarInactiveMode();

    }

    /**
     * 
     */
    @Then("^I should see Others required message$")
    public void verifyOthersRequreMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_OTHERS_SECTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getOthersDetailsRequireMessage()));

    }

    /**
     * 
     */
    @Then("^I should not see Others required message$")
    public void verifyOthersRequreMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_OTHERS_SECTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getOthersDetailsRequireMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should see Product required messages for Others$")
    public void verifyRequireMessagesDisplyedForRequireOtheres() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_OTHERS_TITLE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(othersPage.getPageElements()
                                                       .getTitleRequreMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_OTHERS_DESCRIPTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(othersPage.getPageElements()
                                                       .getTripDetaisRequreMessage()));
    }

    /**
     * 
     */
    @When("^I select Add New for Others$")
    public void selectAddNewForOthers() {

        paymentFormPage.selectAdddNewOthers();
    }

    /**
     * 
     */
    @When("^I fill product details for Others$")
    public void fillProductDetailsForOthers() {

        others1 = new Others.OthersBuilder().setTitle("Title 01")
                                            .setTripDetails("Trip 01")
                                            .build();

        othersPage.fillDetailsForFirstOthers(others1);
    }

    /**
     * 
     */
    @Then("^I should not see Product required messages for Others$")
    public void verifyProductRequiredMessagesNotDisplyedForOthers() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_OTHERS_TITLE, AssertionMessages.IS),
                othersPage.getPageElements()
                          .getTitleRequreMessage()
                          .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_OTHERS_DESCRIPTION, AssertionMessages.IS),
                othersPage.getPageElements()
                          .getTripDetaisRequreMessage()
                          .isDisplayed());
    }

    /**
     * 
     */
    @When("^I add Others product$")
    public void addOthers() {

        paymentFormPage.selectAdddNewOthers();

        others1 = new Others.OthersBuilder().setTitle("Title 01")
                                            .setTripDetails("Trip 01")
                                            .build();

        othersPage.fillDetailsForFirstOthers(others1);
    }

    /**
     * 
     */
    @Then("^I should see Others title and trip details$")
    public void verifyTitleAndTripDetailsDisplayedForOthersProduct() {

        Assert.assertTrue("Title not displaying", othersPage.getPageElements()
                                                            .getFirstTitleInput()
                                                            .getAttribute("value")
                                                            .contains(others1.getTitle()));
        Assert.assertTrue("Trip not displaying", othersPage.getPageElements()
                                                           .getFirstTripDetaisInput()
                                                           .getAttribute("value")
                                                           .contains(others1.getTripDetails()));

    }

    /**
     * 
     * 
     */
    @When("^I edit details of the Other product$")
    public void editTitleAndTripDetailsOfOtherProduct() {

        editedOthers = new Others.OthersBuilder().setTitle("Changed Title")
                                                 .setTripDetails("changed Trip")
                                                 .build();

        othersPage.fillDetailsForFirstOthers(editedOthers);
    }

    /**
     * 
     */
    @Then("^I should see details of edited Other product$")
    public void verifyDetailsOfEditedOtherProductChanged() {

        Assert.assertTrue(othersPage.getPageElements()
                                    .getFirstTitleInput()
                                    .getAttribute("value")
                                    .contains(editedOthers.getTitle()));

        Assert.assertTrue(othersPage.getPageElements()
                                    .getFirstTripDetaisInput()
                                    .getAttribute("value")
                                    .contains(editedOthers.getTripDetails()));
    }

    /**
     * 
     */
    @When("^I select Add new twice to add new Others product$")
    public void selectAddNewTwiseForOthers() {

        paymentFormPage.selectAdddNewOthers();

        paymentFormPage.selectAdddNewOthers();
    }

    /**
     * 
     */
    @When("^I fill in only trip details for both Others product$")
    public void fillTripDetailsForBothOthersProduct() {

        others1 = new Others.OthersBuilder().setTitle("")
                                            .setTripDetails("Trip for Day 01")
                                            .build();

        othersPage.fillDetailsForFirstOthers(others1);

        others2 = new Others.OthersBuilder().setTitle("")
                                            .setTripDetails("Trip for Day 02")
                                            .build();

        othersPage.fillDetailsForSecondOthers(others2);
    }

    /**
     * 
     * 
     */
    @Then("^I should see both Others products trip details$")
    public void verifytheTripDetailsDisplayForBothOthersProduct() {

        Assert.assertTrue("Trip Details for Day 01 not available", othersPage.getPageElements()
                                                                             .getFirstTripDetaisInput()
                                                                             .getAttribute("value")
                                                                             .contains(others1.getTripDetails()));

        Assert.assertTrue("Trip details for Day 02 not available", othersPage.getPageElements()
                                                                             .getSecondTripDetaisInput()
                                                                             .getAttribute("value")
                                                                             .contains(others2.getTripDetails()));
    }

    /**
     * 
     */
    @When("^I delete the first Others product$")
    public void deleteFirstOthersProduct() {

        othersPage.deleteFirstOthers();

    }

    /**
     * 
     */
    @Then("^second others title place holder should change to first Others title placeholder$")
    public void verifySecondOthersProductTripDetailsDisplayWithFirstOthersPlaceholder() {

        Assert.assertFalse("First Others product trip details displayed even after Deleting first product", othersPage.getPageElements()
                                                                                                                      .getFirstTripDetaisInput()
                                                                                                                      .getAttribute("value")
                                                                                                                      .contains(
                                                                                                                              others1.getTripDetails()));
        Assert.assertTrue("First Others product doesn't contains second product trip detsils after deleting first product",
                othersPage.getPageElements()
                          .getFirstTripDetaisInput()
                          .getAttribute("value")
                          .contains(others2.getTripDetails()));

        Assert.assertTrue("First Others product placeholder not contains Day 01 after deleting ", othersPage.getPageElements()
                                                                                                            .getFirstTitleInput()
                                                                                                            .getAttribute("placeholder")
                                                                                                            .contains("Day Tour 1"));

    }
}
