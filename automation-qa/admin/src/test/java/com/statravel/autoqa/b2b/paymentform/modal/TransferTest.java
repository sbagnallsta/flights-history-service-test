package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Transfer;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormListPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;
import com.statravel.autoqa.page.b2b.paymentform.modal.TransferPage;
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
public class TransferTest {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Autowired
    private TransferPage transferPage;

    @Autowired
    private PaymentFormListPage paymentFormListPage;

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private Transfer transfer1, transfer2;

    /**
     * 
     */
    @Before
    public void init() {

        loginPage.init();
        homePage.init();
        transferPage.init();
        paymentFormListPage.init();
        paymentFormPage.init();

    }

    /**
     * 
     */
    @Then("^I should see the new Transport on the Transfer section$")
    public void verifyTransferAdded() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getConformationForFirstTrasfer()
                                         .getText()
                                         .contains(transfer1.getRoute()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getConformationForFirstTrasfer()
                                         .getText()
                                         .contains(transfer1.getName()));

    }

    /**
     * 
     */
    @Then("^I should see second Transport on the Transfer section$")
    public void verifyTransportAddedForSecondTransfer() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getConformationForSecondTrasfer()
                                         .getText()
                                         .contains(transfer2.getRoute()));

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getConformationForSecondTrasfer()
                                         .getText()
                                         .contains(transfer2.getName()));

    }

    /**
     * 
     */
    @Given("^I select add new Transfer$")
    public void selectAddNewTransfer() {

        paymentFormPage.addNewTransfer();

    }

    /**
     * 
     */
    @Then("^I should be on Transfer Page$")
    public void shouldBeOnTrasferPage() {

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_TRANSFER, transferPage.isPageLoaded());

    }

    /**
     * 
     */
    @Then("^I should see transfer details required messages$")
    public void verifyTransferDetailsRequiredMessagesDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRASFER_MODAL_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTransferNameRequiredMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRASFER_MODAL_ROUTES, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTransferRoutesRequiredMessage()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRASFER_MODAL_FLIGHT_DEPARTURE_DATE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTransferDateRequiredMessage()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_TRASFER_MODAL_DEPARTURE_TIME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTransferTimeRequiredMessage()));

    }

    /**
     * 
     */
    @When("^I save Transfer details page without entering data in the required fields$")
    public void saveTransferDetailsPageWithoutEnteringDataInTheRequiredFields() {

        transferPage.saveDetails();
    }

    /**
     * 
     */
    @Then("^I should see warning messages for require fields$")
    public void verifyTransferDetailsRequiredErrorMessagesDisplayed() {

        Assert.assertTrue(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_TRASFER_MODAL_NAME, webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                                                                                                    .getTrasferNameReqireErrorMessage()));

        Assert.assertTrue(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_TRASFER_MODAL_ROUTES,
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTrasferRouteReqireErrorMessage()));

        Assert.assertTrue(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_TRASFER_MODAL_FLIGHT_DEPARTURE_DATE,
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTrasferDepartureDateReqireErrorMessage()));

        Assert.assertTrue(AssertionMessages.ERROR_PAYMENT_FORM_DETAILS_TRASFER_MODAL_DEPARTURE_TIME,
                webDriverCommons.isDisplayed(transferPage.getPageElements()
                                                         .getTrasferDepartureTimeReqireErrorMessage()));

    }

    /**
     * 
     */
    @When("^I edit the details of the new Transport$")
    public void editDetailsOfNewTransport() {

        webDriverCommons.click(paymentFormPage.getPageElements()
                                              .getTransferEditButton());

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_TRANSFER, transferPage.isPageLoaded());

        transfer1 = new Transfer.TransferBuilder().setName("Bus Transfer")
                                                  .setRoute("Test01-Test02")
                                                  .setDepartureHour("12 AM")
                                                  .setDepartureMinute("15")
                                                  .setSpecialRemarks("Enjoy")
                                                  .build();

        transferPage.fillTransferDetails(transfer1);

    }

    /**
     * 
     */
    @When("^I select save on Transfer page$")
    public void selectSave() {

        transferPage.saveDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());
    }

    /**
     * 
     */
    @Then("^I should see the edited Transport on the Transfer section$")
    public void verifyEditedTransportRoutesDispayedOnTransferSection() {

        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getConformationForFirstTrasfer()
                                         .getText()
                                         .contains(transfer1.getRoute()));
        Assert.assertTrue(paymentFormPage.getPageElements()
                                         .getConformationForFirstTrasfer()
                                         .getText()
                                         .contains(transfer1.getName()));
    }

    /**
     * 
     */
    @When("^I cancel changes on Transfer page$")
    public void selectCancel() {

        transferPage.cancelDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());
    }

    /**
     * 
     */
    @Then("^I should not see the new Transport on the Transfer section$")
    public void verifyNewTransferNotAdded() {

        Assert.assertFalse(paymentFormPage.getPageElements()
                                          .getConformationForFirstTrasfer()
                                          .getText()
                                          .contains(transfer1.getRoute()));

        Assert.assertFalse(paymentFormPage.getPageElements()
                                          .getConformationForFirstTrasfer()
                                          .getText()
                                          .contains(transfer1.getName()));

    }

    /**
     * 
     */
    @When("^I activate Transfer section$")
    public void activateTransferSection() {

        paymentFormPage.toggleTransferSection();
    }

    /**
     * 
     */
    @When("^I add a new Transport$")
    public void addNewTransportDetails() {

        paymentFormPage.addNewTransfer();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_TRANSFER, transferPage.isPageLoaded());

        transfer1 = new Transfer.TransferBuilder().setName("Train Transfer")
                                                  .setRoute("Mumbai-Pune")
                                                  .setDepartureHour("12 AM")
                                                  .setDepartureMinute("15")
                                                  .setSpecialRemarks("Enjoy")
                                                  .build();

        transferPage.fillTransferDetails(transfer1);

        transferPage.saveDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @When("^I add second Transport$")
    public void addSecondTransportDetails() {

        paymentFormPage.addNewTransfer();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS_TRANSFER, transferPage.isPageLoaded());

        transfer2 = new Transfer.TransferBuilder().setName("Goa Transfer")
                                                  .setRoute("Chennai-Goa")
                                                  .setDepartureHour("12 AM")
                                                  .setDepartureMinute("15")
                                                  .setSpecialRemarks("Enjoy Goa")
                                                  .build();

        transferPage.fillTransferDetails(transfer2);

        transferPage.saveDetails();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

    }

    /**
     * 
     */
    @Then("^I should see a Transfer required message$")
    public void verifyTransferREqureMessageisDisplayed() {

        Assert.assertTrue(webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                      .getTransferRequireMessage()));
    }

    /**
     * 
     */
    @Then("^I should not see a Transfer required message$")
    public void verifyTransferREqureMessageIsNotDisplayed() {

        Assert.assertFalse(paymentFormPage.getPageElements()
                                          .getTransferRequireMessage()
                                          .isDisplayed());

    }

    /**
     * 
     */
    @When("^I disable the new transport$")
    public void disableNewTransport() {

        paymentFormPage.toggleFirstTransferActiveBarActiveMode();
    }

}
