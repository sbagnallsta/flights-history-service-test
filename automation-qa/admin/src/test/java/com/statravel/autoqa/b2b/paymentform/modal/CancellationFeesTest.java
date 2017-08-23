package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.CancellationFee;
import com.statravel.autoqa.page.b2b.paymentform.CancellationFeePage;
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
public class CancellationFeesTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private CancellationFeePage cancellationFeePage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private CancellationFee cancellationFeeOne, cancellationFeeTwo, editedCancellationFee;

    /**
     * 
     */
    @Before
    public void init() {

        paymentFormPage.init();
        cancellationFeePage.init();
    }

    /**
    * 
    */
    @When("^I activate Cancellation fees section$")
    public void activateCancellationFees() {

        paymentFormPage.toggleCancelltionFeesSectionActiveBarInactiveMode();
    }

    /**
    * 
    */
    @Then("^I should see Cancellation fees section required message$")
    public void verifyCancellationFeesRequiredMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_SECTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getCancellationFeesRequreMessage()));
    }

    /**
    * 
    */
    @When("^I select Add New for Cancellation fees$")
    public void selectAddNewForCancellationFees() {

        paymentFormPage.selectAddNewCancellationFees();
    }

    /**
    * 
    */
    @Then("^I should not see Cancellation fees section required message$")
    public void verifyCancellationFeesRequiredMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_SECTION, AssertionMessages.IS_NOT),
                paymentFormPage.getPageElements()
                               .getCancellationFeesRequreMessage()
                               .isDisplayed());
    }

    /**
    * 
    */
    @Then("^I should see required messages for all Cancellation fees fields$")
    public void verifyRequiredMessagesForAllCancellationFeesFieldsIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_TYPE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(cancellationFeePage.getPageElements()
                                                                .getTypeIsRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_DUE_DATE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(cancellationFeePage.getPageElements()
                                                                .getDueDateRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_PENALTY, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(cancellationFeePage.getPageElements()
                                                                .getPenaltyRequireMessage()));
    }

    /**
    * 
    */
    @When("^I fill the details for Cancellation fees$")
    public void fillDetailsForCancellationFee() {

        cancellationFeeOne = new CancellationFee("Cancellation one", "20/08/2017", "£50");

        cancellationFeePage.fillDetailsForFirstCancellationFees(cancellationFeeOne);

    }

    /**
    * 
    */
    @Then("^I should not see required messages for all Cancellation fees fields$")
    public void verifyRequiredMessagesForAllCancellationFeesFieldsIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_TYPE, AssertionMessages.IS),
                cancellationFeePage.getPageElements()
                                   .getTypeIsRequireMessage()
                                   .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_DUE_DATE, AssertionMessages.IS),
                cancellationFeePage.getPageElements()
                                   .getDueDateRequireMessage()
                                   .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRE_PAYMENT_FORM_DETAILS_CANCELLATION_FEES_PENALTY, AssertionMessages.IS),
                cancellationFeePage.getPageElements()
                                   .getPenaltyRequireMessage()
                                   .isDisplayed());

    }

    /**
    * 
    */
    @When("^I fill in details for Legal copy$")
    public void filDetailsForLegalCopy() {

        paymentFormPage.fillDetailsForLegalCopy();
    }

    /**
    * 
    */
    @Then("^I should see details filled in for Cancellation fees and Legal copy$")
    public void verifyDetailsForCancellationFeeAndLegalCopy() {

        Assert.assertTrue("Cancellation fee Type input value not displayed as entered", cancellationFeePage.getPageElements()
                                                                                                           .getFirstTypeInput()
                                                                                                           .getAttribute("value")
                                                                                                           .contains(cancellationFeeOne.getType()));

        Assert.assertTrue("Cancellation fee Due Date input value not displayed as entered", cancellationFeePage.getPageElements()
                                                                                                               .getFirstDueDateInput()
                                                                                                               .getAttribute("value")
                                                                                                               .contains(
                                                                                                                       cancellationFeeOne.getDueDate()));

        Assert.assertTrue("Cancellation fee Penalty input value not displayed as entered", cancellationFeePage.getPageElements()
                                                                                                              .getFirstPenaltyInput()
                                                                                                              .getAttribute("value")
                                                                                                              .contains(
                                                                                                                      cancellationFeeOne.getPenalty()));

        Assert.assertTrue("Legal Copy input value not displayed as entered", paymentFormPage.getPageElements()
                                                                                            .getLegalCopyInput()
                                                                                            .getAttribute("value")
                                                                                            .contains("This is a legal copy"));
    }

    /**
     * 
     */
    @When("^I add Cancellation fees$")
    public void addCancellationFees() {

        cancellationFeeOne = new CancellationFee("Cancellation one", "20/08/2017", "£50");

        selectAddNewForCancellationFees();

        cancellationFeePage.fillDetailsForFirstCancellationFees(cancellationFeeOne);

    }

    /**
     * 
     */
    @When("^I edit the details of the Cancellation fees$")
    public void editDetailsOfTheCancellationFees() {

        editedCancellationFee = new CancellationFee("Edited Cancellation fees", "21/08/2017", "£100");

        cancellationFeePage.fillDetailsForFirstCancellationFees(editedCancellationFee);
    }

    /**
     * 
     */
    @Then("^I should see details of edited Cancellation fees$")
    public void verifyEditedCancellationDisplayedOnCancellationSection() {

        Assert.assertFalse("Old Cancellation Fee Type value displayed even after editing them", cancellationFeePage.getPageElements()
                                                                                                                   .getFirstTypeInput()
                                                                                                                   .getAttribute("value")
                                                                                                                   .contains(
                                                                                                                           cancellationFeeOne.getType()));

        Assert.assertFalse("Old Cancellation Fee Due Date value displayed even after editing them", cancellationFeePage.getPageElements()
                                                                                                                       .getFirstDueDateInput()
                                                                                                                       .getAttribute("value")
                                                                                                                       .contains(
                                                                                                                               cancellationFeeOne.getDueDate()));

        Assert.assertFalse("Old Cancellation Fee Panelty value displayed even after editing them", cancellationFeePage.getPageElements()
                                                                                                                      .getFirstPenaltyInput()
                                                                                                                      .getAttribute("value")
                                                                                                                      .contains(
                                                                                                                              cancellationFeeOne.getPenalty()));

        Assert.assertTrue("Edited Cancellation fee Type value is not displayed", cancellationFeePage.getPageElements()
                                                                                                    .getFirstTypeInput()
                                                                                                    .getAttribute("value")
                                                                                                    .contains(editedCancellationFee.getType()));

        Assert.assertTrue("Edited Cancellation fee Due Date value is not displayed", cancellationFeePage.getPageElements()
                                                                                                        .getFirstDueDateInput()
                                                                                                        .getAttribute("value")
                                                                                                        .contains(
                                                                                                                editedCancellationFee.getDueDate()));

        Assert.assertTrue("Edited Cancellation fee Penalty value is not displayed", cancellationFeePage.getPageElements()
                                                                                                       .getFirstPenaltyInput()
                                                                                                       .getAttribute("value")
                                                                                                       .contains(editedCancellationFee.getPenalty()));

    }

    /**
     * 
     */
    @When("^I add New Cancellation fees twice$")
    public void addNewCancellationFeesTwice() {

        addCancellationFees();

        selectAddNewForCancellationFees();

        cancellationFeeTwo = new CancellationFee("Secon Cancellation Fee", "22/08/2017", "£200");

        cancellationFeePage.fillDetailsForSecondCancelltionFees(cancellationFeeTwo);
    }

    /**
     * 
     */
    @Then("^I should see two Cancellation fees type on the cancellation fees section$")
    public void verifyTwoCancellationFeesTypeOnCancellationFeesSection() {

        Assert.assertTrue("First cancelaltion fee is not displayed", webDriverCommons.isDisplayed(cancellationFeePage.getPageElements()
                                                                                                                     .getFirstTypeInput()));

        Assert.assertTrue("Second cancelaltion fee is not displayed", webDriverCommons.isDisplayed(cancellationFeePage.getPageElements()
                                                                                                                      .getSecondTypeInput()));
    }

    /**
     * 
     */
    @When("^I delete the first Cancellation fees$")
    public void deleteFirstCancellationFees() {

        cancellationFeePage.deleteFirstCancellationFees();
    }

    /**
     * 
     */
    @Then("^I should not see the deleted Cancellation fees$")
    public void verifyDeletedCancellationFeesIsNotDisplayed() {

        Assert.assertFalse("First Cancellation fee section is displayed even after deleting it", cancellationFeePage.getPageElements()
                                                                                                                    .getFirstTypeInput()
                                                                                                                    .getAttribute("value")
                                                                                                                    .contains(
                                                                                                                            cancellationFeeOne.getType()));
    }

    /**
     * 
     */
    @When("^I delete the second Cancellation fees$")
    public void deleteSecondCancellationFees() {

        cancellationFeePage.deleteFirstCancellationFees();

    }

}
