package com.statravel.autoqa.b2b.paymentformList;

import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_NAME;
import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_PASSWORD;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.b2b.paymentform.modal.CreateFormWithCost;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.AutomationConstants;
import com.statravel.autoqa.commons.Utilities;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.commons.WebDriverFactory;
import com.statravel.autoqa.domain.b2b.paymentform.PaymentForm;
import com.statravel.autoqa.domain.entity.PaymentFormCostEntity;
import com.statravel.autoqa.domain.entity.PaymentFormEntity;
import com.statravel.autoqa.domain.entity.PaymentFormsTermsAndConditionsEntity;
import com.statravel.autoqa.domain.enumeration.POS;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormListPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormPage;
import com.statravel.autoqa.repository.PaymentFormRepository;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
public class PaymentFormsListTest {
    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Autowired
    private PaymentFormListPage paymentFormListPage;

    @Autowired
    private Utilities utilities;

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private CreateFormWithCost createFormWithCost;

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private PaymentFormRepository paymentFormRepository;

    private PaymentForm paymentForm;

    private String id, newId, formName, partnerName, editedFormName, editedPartnerName, url, referenceNo;

    private String domainName = "https://uktest.bluee.net/paymentform.htm";

    private int lastId, firstId;

    private static final int PAYMENT_FORM_CREATION_NUMBER = 21;

    /**
     * 
     */
    @Before
    public void init() {
        loginPage.init();
        homePage.init();
        paymentFormListPage.init();
    }

    /**
     * 
     */
    @Given("^I am on payment form list page$")
    public void iAmOnPaymentFormListPage() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_LOGIN, loginPage.isPageLoaded());

        loginPage.login(ADMIN_NAME, ADMIN_PASSWORD);

        homePage.selectPOS(POS.US);

        homePage.clickPaymentFormsMenuItem();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormListPage.isPageLoaded());
    }

    /**
     * 
     */
    @When("^I save a payment form with valid details$")
    public void saveAPaymentFormWithValidDetails() {
        createFormWithCost.fillInDetailsForRequiredModulesSelectingOnlyAccomodationCost();

        partnerName = paymentFormPage.getPartnerNameFormPaymentFormPage();

        createFormWithCost.savePaymentForm();
    }

    /**
     * 
     */
    @Then("^I should be on current forms list page$")
    public void verifyB2BCurrentFormsListPageIsDisplayed() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormListPage.isPageLoaded());

    }

    /**
    * 
    */
    @Then("^I should see the form categorised according to id, form name and unique url matching the partner name entered in the form$")
    public void verifyFormCategorisedAccordingToIdFormNameAndUniqueUrlMatchingThePartnerNameEnteredInTheForm() {
        paymentFormListPage.scrollToFirstForm();
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.PAYMENT_FORM_LIST_CATEGORISED_LIST, AssertionMessages.ID_COLOUM_FOR_PAYMENT_LIST_PAGE),
                paymentFormListPage.getPageElements()
                                   .getFirstFormIDConfirmation()
                                   .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.PAYMENT_FORM_LIST_CATEGORISED_LIST,
                        AssertionMessages.PARTNER_NAME_COLOUM_FOR_PAYMENT_LIST_PAGE),
                paymentFormListPage.getPageElements()
                                   .getFirstFormNameConfirmation()
                                   .isDisplayed());
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.PAYMENT_FORM_LIST_CATEGORISED_LIST, AssertionMessages.UNIQUE_URL_COLOUM_FOR_PAYMENT_LIST_PAGE),
                paymentFormListPage.getPageElements()
                                   .getFirstFormUrlConfirmation()
                                   .isDisplayed());
    }

    /**
     * 
     */
    @Then("^the unique url should contain domain name,partner name and form id$")
    public void verifyUniqueUrlContainDomainNamePartnerNameAndFormId() {
        url = paymentFormListPage.getUrlTextFromFirstForm();

        id = paymentFormListPage.getIdFromPaymentFormListPage();

        Assert.assertTrue(MessageFormat.format(AssertionMessages.UNIQUE_URL_FOR_PAYMENT_FORM, AssertionMessages.UNIQUE_ID), url.contains(id));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.UNIQUE_URL_FOR_PAYMENT_FORM, AssertionMessages.PARTNER_NAME),
                url.contains(partnerName));
        Assert.assertTrue(MessageFormat.format(AssertionMessages.UNIQUE_URL_FOR_PAYMENT_FORM, AssertionMessages.DOMAIN_NAME),
                url.contains(domainName));

    }

    /**
     * 
     */
    @Given("^a payment form is already saved on the current forms list$")
    public void verifyAPaymentFormIsAlreadySavedNnCurrentFormsList() {
        if (webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                            .getFirstFormIDConfirmation())) {
            paymentFormListPage.scrollToFirstForm();

            Assert.assertTrue("There is no saved payment forms on payment forms list page", paymentFormListPage.getPageElements()
                                                                                                               .getFirstFormIDConfirmation()
                                                                                                               .isDisplayed());
        } else {
            paymentFormListPage.addNewForm();

            Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

            saveAPaymentFormWithValidDetails();

            Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormListPage.isPageLoaded());

            paymentFormListPage.scrollToFirstForm();

            Assert.assertTrue("There is no saved payment forms on payment forms list page", paymentFormListPage.getPageElements()
                                                                                                               .getFirstFormIDConfirmation()
                                                                                                               .isDisplayed());
        }

    }

    /**
     * 
     */
    @When("^I edit the payment form changing the partner name$")
    public void editPaymentFormWithChangingPartnerName() {
        id = paymentFormListPage.getIdFromPaymentFormListPage();

        referenceNo = paymentFormListPage.getRefrenceNoFromUrl();

        paymentFormListPage.selectFirstFormEdit();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());

        formName = paymentFormPage.getFormNameFormPaymentFormPage();

        partnerName = paymentFormPage.getPartnerNameFormPaymentFormPage();

        paymentFormPage.clearFormNameAndPartnerNameFromPaymentFormPage();

        paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("Edited Form Name" + utilities.getRandomIntOverOneThousand())
                                                          .setPartnerName("Edited-Partner" + utilities.getRandomIntOverOneThousand())
                                                          .setPartnerLogo("")
                                                          .setTripName("")
                                                          .setTravelHeading("")
                                                          .setTravelIntro("")
                                                          .setImportantInstructionDescription("")
                                                          .build();

        paymentFormPage.fillDetailsForPaymentForm(paymentForm);

        editedFormName = paymentFormPage.getFormNameFormPaymentFormPage();

        editedPartnerName = paymentFormPage.getPartnerNameFormPaymentFormPage();

        paymentFormPage.saveAfterEdit();

    }

    /**
     * 
     */
    @Then("^I should see the edited form saved on the current forms list$")
    public void verifyEditedFormSavedOnCurrentFormsList() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormListPage.isPageLoaded());

        paymentFormListPage.scrollToFirstForm();

        Assert.assertTrue("First form name on payment form list table does not contain edited form name after editing form",
                paymentFormListPage.getPageElements()
                                   .getFirstFormNameConfirmation()
                                   .getText()
                                   .equals(editedFormName));

    }

    /**
     * 
     */
    @Then("^I should see the change on the partner name reflect in the unique url$")
    public void verifyChangeOnPartnerNameReflectInUniqueUrl() {
        Assert.assertNotEquals("First payment form unique url does contains original partner name even after editing them", partnerName,
                paymentFormListPage.getPartnerNameFromUrl());

        Assert.assertEquals("First payment form unique url does not contains editied partner name even after editing them", editedPartnerName,
                paymentFormListPage.getPartnerNameFromUrl());
    }

    /**
     * 
     */
    @Then("^I should not see any change in the reference number$")
    public void verifyReferenceNumberNotChangedInUrl() {
        Assert.assertEquals("Reference No in Unique URL for payment form changed after editing in form", referenceNo,
                paymentFormListPage.getRefrenceNoFromUrl());
    }

    /**
     * 
     */
    @Then("^I should not see any change in the id$")
    public void verifyIdIsNotChanged() {
        Assert.assertEquals("ID for payment form changed on payment list page after editing in form", id,
                paymentFormListPage.getIdFromPaymentFormListPage());
    }

    /**
     * 
     */
    @When("^I select delete$")
    public void selectDeleteForFirstForm() {
        paymentFormListPage.deleteFirstForm();
    }

    /**
     * 
     * @throws InterruptedException
     *             InterruptedException
     */
    @Then("^I should not see the deleted payment form on the current forms list$")
    public void verifyDeletedPaymentFormIsNotDisplayedOnCurrentFormsList() throws InterruptedException {
        utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);
        Assert.assertFalse("First payment form id contain deleted form ID even after deleting that form", paymentFormListPage.getPageElements()
                                                                                                                             .getFirstFormIDConfirmation()
                                                                                                                             .getText()
                                                                                                                             .equals(id));

        Assert.assertTrue("Payment form is not showing delete true in DATABASE even after deleing from playment list page",
                paymentFormRepository.findOne(Long.parseLong(id))
                                     .isDeleted());

    }

    /**
     * 
     */
    @Given("^the payment form is active$")
    public void verifyFirstPaymentFormIsActive() {
        paymentFormListPage.scrollToFirstForm();

        if (!webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                             .getFirstFormActiveBarActiveMode())) {
            paymentFormListPage.togggleFirstFormInacticeMode();
        }
        Assert.assertTrue("First payment form active bar is on inactive mode", paymentFormListPage.getPageElements()
                                                                                                  .getFirstFormActiveBarActiveMode()
                                                                                                  .isDisplayed());
    }

    /**
     * 
     */
    @When("^I make the payment form inactive$")
    public void makeFirstPaymentFormInactive() {
        paymentFormListPage.toggleFirstFormActiveMOde();

    }

    /**
     * 
     */
    @Then("^payment form should be inactive$")
    public void verifyPaymentFormShouldBeInactive() {
        Assert.assertTrue("First payment form active bar is on active mode even after inactivete it", paymentFormListPage.getPageElements()
                                                                                                                         .getFirstFormActiveBaInactiveMode()
                                                                                                                         .isDisplayed());

        id = paymentFormListPage.getIdFromPaymentFormListPage();

        Assert.assertTrue("Payment form is active in DATABASE even after deactivate form", !paymentFormRepository.findOne(Long.parseLong(id))
                                                                                                                 .isActive());

    }

    /**
     * 
     */
    @When("^I select copy from an already saved payment form$")
    public void selectCopyFromAnAlreadySavedPaymentForm() {
        id = paymentFormListPage.getIdFromPaymentFormListPage();

        url = paymentFormListPage.getUrlTextFromFirstForm();

        formName = paymentFormListPage.getFormNameFromPaymentFormListPage();

        partnerName = paymentFormListPage.getPartnerNameFromUrl();

        paymentFormListPage.selectFirstFormCopy();
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     * 
     */
    @Then("^I should be on a new payment forms details page with details of original payment form$")
    public void verifyNewPaymentFormsDetailsPageContainsDetailsOfOriginalPaymentForm() throws InterruptedException {

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM_DETAILS, paymentFormPage.isPageLoaded());
        utilities.timeInterval(1);
        Assert.assertEquals(MessageFormat.format(AssertionMessages.COPY_PAYMENT_FORM_FROM_PAYMENT_FORM_LIST_PAGE, AssertionMessages.FORM_NAME),
                formName, paymentFormPage.getFormNameFormPaymentFormPage());

        Assert.assertEquals(MessageFormat.format(AssertionMessages.COPY_PAYMENT_FORM_FROM_PAYMENT_FORM_LIST_PAGE, AssertionMessages.PARTNER_NAME),
                partnerName, paymentFormPage.getPartnerNameFormPaymentFormPage());
    }

    /**
     * 
     */
    @When("^I select create without making any changes$")
    public void selectCreateWithoutMakingAnyChanges() {
        paymentFormPage.createPaymentForm();
    }

    /**
     * 
     */
    @Then("^I should see a copy of the form on the current forms list$")
    public void verifyCopyOfFormIsDisplayedOnCurrentFormsList() {
        paymentFormListPage.scrollToFirstForm();
        Assert.assertFalse("First ID confirmation contain old form ID even after creating new", paymentFormListPage.getPageElements()
                                                                                                                   .getFirstFormIDConfirmation()
                                                                                                                   .getText()
                                                                                                                   .contains(id));

    }

    /**
     * 
     */
    @Then("^the unique url should have the same partner name$")
    public void verifuUniqueUrlHaveSamePartnerName() {
        Assert.assertEquals("Unique URL for payment form on form list page contain diffrent partner name after copying form original", partnerName,
                paymentFormListPage.getPartnerNameFromUrl());
    }

    /**
     * 
     */
    @Then("^the unique url should contain id$")
    public void verifyUniqueUrlContainADifferentId() {
        paymentFormListPage.scrollToFirstForm();

        newId = paymentFormListPage.getIdFromPaymentFormListPage();

        Assert.assertEquals("Unique URL for payment form on form list page doen not contain same ID as new form ID", newId,
                paymentFormListPage.getIdFromUniqueURL());
    }

    /**
     * 
     */
    @Then("^the form name should remain the same$")
    public void verifyFormNameRemainSame() {
        Assert.assertEquals("After copying from a payment form, form name is not same as original form", formName,
                paymentFormListPage.getFormNameFromPaymentFormListPage());
    }

    /**
     * 
     */
    @Then("^I should see a different id on the id column against the new copy$")
    public void verifyDifferentIdIsDisplayedOnIdColumnAgainstNewCopy() {
        Assert.assertNotEquals("After copying form from a payment form, new form ID is same as original form but expected diffrent", id,
                paymentFormListPage.getPageElements()
                                   .getFirstFormIDConfirmation()
                                   .getText());
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     */
    @Given("^payment forms are already saved on the current forms list$")
    public void verifyPaymentFormsAreAlreadySavedOnCurrentFormsList() throws InterruptedException {
        verifyTwentyFormsAreAlreadySaved();
    }

    /**
     * 
     * @param searchParameter
     *            search Parameter
     */
    @When("^I enter \"([^\"]*)\" in the search box$")
    public void enterValueInSearchBox(final String searchParameter) {
        paymentFormListPage.scrollToFirstForm();

        if (searchParameter.contains("Form name")) {

            paymentFormListPage.enterValueToSearchField(paymentFormListPage.getFormNameFromPaymentFormListPage());

        } else if (searchParameter.contains("Id")) {

            paymentFormListPage.enterValueToSearchField(paymentFormListPage.getIdFromPaymentFormListPage());

        } else if (searchParameter.contains("Partner name")) {

            paymentFormListPage.enterValueToSearchField(paymentFormListPage.getPartnerNameFromUrl());

        } else if (searchParameter.contains("Reference number")) {

            paymentFormListPage.enterValueToSearchField(paymentFormListPage.getRefrenceNoFromUrl());
        }
    }

    /**
     * 
     * @throws InterruptedException
     *             Interrupted Exception
     */
    @Then("^I should see matching payment form in view$")
    public void verifyMatchingPaymentFormsInView() throws InterruptedException {
        utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);

        Assert.assertTrue("Result(s) does not contain search input", paymentFormListPage.isResultContainSearch(paymentFormListPage.getPageElements()
                                                                                                                                  .getSearchInput()
                                                                                                                                  .getAttribute(
                                                                                                                                          "value")));

    }

    /**
     * 
     * @param sortOptions
     *            sort options
     */
    @When("^I  sort by \"([^\"]*)\"$")
    public void sortPaymentFormsBy(final String sortOptions) {
        if (sortOptions.contains("id")) {
            paymentFormListPage.scrollToFirstForm();

            paymentFormListPage.clickOnIdSortButton();

        } else if (sortOptions.contains("Form name")) {
            paymentFormListPage.scrollToFirstForm();

            paymentFormListPage.clickOnFormNameSortButton();
        }
    }

    /**
     * 
     * @param sortOptions
     *            sort Options
     * @throws InterruptedException
     *             Interrupted Exception
     */
    @Then("^I should see payment forms displayed according to \"([^\"]*)\"$")
    public void verifyPaymentFormsDisplayedInOrderAccordingTo(final String sortOptions) throws InterruptedException {
        if (sortOptions.contains("id")) {
            utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);
            Assert.assertTrue("Payment form list ID not sorted in Ascending order", paymentFormListPage.isIdSorted("Asceding"));

            webDriverCommons.click(paymentFormListPage.getPageElements()
                                                      .getIdSortingButton());
            utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);

            Assert.assertTrue("Payment form list ID not sorted in Dscending order", paymentFormListPage.isIdSorted("Dsceding"));

        } else if (sortOptions.contains("Form name")) {
            utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);
            Assert.assertTrue("Payment form list ID not sorted in Ascending order", paymentFormListPage.isFormNameSorted("Asceding"));

            webDriverCommons.click(paymentFormListPage.getPageElements()
                                                      .getFormNameSortingButton());
            utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);
            Assert.assertTrue("Payment form list ID not sorted in Dscending order", paymentFormListPage.isFormNameSorted("Dsceding"));
        }
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     * 
     */
    @Given("^twenty forms are already saved$")
    public void verifyTwentyFormsAreAlreadySaved() throws InterruptedException {
        if (!webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                             .getGoToNextPageButton())) {
            List<PaymentFormEntity> paymentFormList = new ArrayList<>();

            for (int i = 0; i < PAYMENT_FORM_CREATION_NUMBER; i++) {

                PaymentFormEntity paymentFormEntity = new PaymentFormEntity();

                paymentFormEntity.setName("Test name" + utilities.getRandomIntOverOneThousand());
                paymentFormEntity.setPosId(1L);
                paymentFormEntity.setPartnerName("Test Partner" + utilities.getRandomIntOverOneThousand());
                paymentFormEntity.setTripName("Test Trip" + utilities.getRandomIntOverOneThousand());
                paymentFormEntity.setQuoteActive(false);
                paymentFormEntity.setTravelHeading("Test Heading");
                paymentFormEntity.setTravelIntro("hi");
                paymentFormEntity.setUniqueId(UUID.randomUUID()
                                                  .toString());
                paymentFormEntity.setUrlFriendlyPartnerName(paymentFormEntity.getPartnerName());
                paymentFormEntity.setPaymentFormCostEntity(new PaymentFormCostEntity());
                paymentFormEntity.setPaymentFormsTermsAndConditionsEntity(new PaymentFormsTermsAndConditionsEntity());
                paymentFormList.add(paymentFormEntity);
            }

            paymentFormRepository.save(paymentFormList);
            WebDriverFactory.getWebDriver()
                            .navigate()
                            .refresh();

            utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);

        } else {
            Assert.assertTrue("Twenty forms are not saved on payment forms list page", paymentFormListPage.getPageElements()
                                                                                                          .getGoToNextPageButton()
                                                                                                          .isDisplayed());
        }

    }

    /**
     * 
     */
    @Given("^I see twenty forms per page with the page numbers at the bottom of the page$")
    public void verifyTwentyFormsDisplayedPerPageWithPageNumbersAtBottomOfThePage() {
        Assert.assertTrue("payment forms list page not contain 20 forms on first page", paymentFormListPage.isTwentyFormsDisplayed());

        Assert.assertTrue("Page 2 button is not displayed on payment form list page",
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getGoToPageTwoButton()));
    }

    /**
     * 
     */
    @When("^I select page two from the page number$")
    public void selectPageTwoFromPageNumber() {
        id = paymentFormListPage.getIdFromPaymentFormListPage();

        lastId = Integer.parseInt(paymentFormListPage.getPageElements()
                                                     .getLastFormIdConfirmation()
                                                     .getText());

        paymentFormListPage.clickOnPageTwoButton();
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     * 
     */
    @Then("^I should be navigated to the top of the second page$")
    public void verifyUserNavigatedToTopOfTheSecondPage() throws InterruptedException {
        utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);
        paymentFormListPage.scrollToFirstForm();

        firstId = Integer.parseInt(paymentFormListPage.getPageElements()
                                                      .getFirstFormIDConfirmation()
                                                      .getText());

        Assert.assertTrue("First id on second page is greatet than last id of first page", lastId > firstId);
    }

    /**
     * 
     */
    @When("^I select the left arrow$")
    public void selectLeftArrow() {
        paymentFormListPage.clickOnPreviousPageButon();
    }

    /**
     * @throws InterruptedException
     *             InterruptedException
     * 
     */
    @Then("^I should be navigated to the top of the first page$")
    public void verifyUserNavigatedToTopOfFirstPage() throws InterruptedException {
        utilities.timeInterval(AutomationConstants.TIME_INTERVAL_FOR_THREE_SECONDS);
        paymentFormListPage.scrollToFirstForm();
        Assert.assertTrue("After clicking on previous page button on payment form list page, first form ID is not same as it should be",
                paymentFormListPage.getPageElements()
                                   .getFirstFormIDConfirmation()
                                   .getText()
                                   .equals(id));
    }

}
