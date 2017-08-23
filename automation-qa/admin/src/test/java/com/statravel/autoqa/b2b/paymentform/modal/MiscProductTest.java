package com.statravel.autoqa.b2b.paymentform.modal;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.MiscProduct;
import com.statravel.autoqa.page.b2b.paymentform.MiscProductPage;
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
public class MiscProductTest {

    @Autowired
    private PaymentFormPage paymentFormPage;

    @Autowired
    private MiscProductPage miscProductPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private MiscProduct miscProduct1, miscProduct2, editedMiscPrice, editedMiscProductDetais;

    /**
     * 
     */
    @Before
    public void init() {

        paymentFormPage.init();
        miscProductPage.init();
    }

    /**
     * 
     */
    @Given("^the Misc product Title name field is displayed$")
    public void verifyMiscProductTitleNameInputFieldIsDisplayed() {

        Assert.assertTrue("Misc Product Title Name input is not displayed", webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                                                                                        .getMiscProductTitleNameInput()));

    }

    /**
     * 
     */
    @When("^I activate the Misc product section$")
    public void activateTheMiscProductSection() {

        paymentFormPage.toggleMiscProduct();
    }

    /**
     * 
     */
    @Then("^I should see the Misc product section required message$")
    public void verifyMiscProductSectionRequiredMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_SECTION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getMiscProductIsRequreMessage()));
    }

    /**
     * 
     */
    @Then("^I should see the Misc product Title name required message$")
    public void verifyMiscProductTitleNameRequiredMessageIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_NAME_TITLE, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                            .getMiscProductTitleNameIsRequireMessage()));
    }

    /**
     * 
     */
    @When("^I select add new Misc product$")
    public void selectAddNewMiscProduct() {

        paymentFormPage.selectAddNewMiscProduct();
    }

    /**
     * 
     */
    @Then("^I should not see the Misc product section required message$")
    public void verifyMiscProductSectionRequiredMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_SECTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getMiscProductIsRequreMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should see the Misc product details required message$")
    public void verifyMiscProductDetailsRequiredMessagesIsDisplayed() {

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_NAME, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(miscProductPage.getPageElements()
                                                            .getProductNameIsRequireMessage()));

        Assert.assertTrue(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_INFORMATION, AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(miscProductPage.getPageElements()
                                                            .getProductInforamtionIsRequireMessage()));
    }

    /**
     * 
     */
    @When("^I fill in the details in the added Misc product$")
    public void fillDetailsInAddedMiscproduct() {

        miscProduct1 = new MiscProduct("100", "Test Misc Name", "Test Misc Information");

        miscProductPage.fillDetailsForFirstMiscProduct(miscProduct1);
    }

    /**
     * 
     */
    @When("^I fill in the Misc product name field$")
    public void fillInMiscProductTitleNameField() {

        paymentFormPage.fillMiscProductName("Test Misc Product Name");
    }

    /**
     * 
     */
    @Then("^I should see Misc product with added details$")
    public void verifyAddedDetailsIsDisplayedInMiscProduct() {

        Assert.assertTrue("Misc Product Price input data does not contains entered data", miscProductPage.getPageElements()
                                                                                                         .getFirstPriceInput()
                                                                                                         .getAttribute("value")
                                                                                                         .contains(miscProduct1.getPrice()));

        Assert.assertTrue("Misc Product Name input data does not contains entered data", miscProductPage.getPageElements()
                                                                                                        .getFirstNameInput()
                                                                                                        .getAttribute("value")
                                                                                                        .contains(miscProduct1.getProductName()));

        Assert.assertTrue("Misc Product Inforamtion input data does not contains entered data", miscProductPage.getPageElements()
                                                                                                               .getFirstInformationInput()
                                                                                                               .getAttribute("value")
                                                                                                               .contains(
                                                                                                                       miscProduct1.getProductInforamtion()));
    }

    /**
     * 
     */
    @Then("^I should not see the Misc product details required message$")
    public void verifyMiscProductDetailsRequiredMessagesIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_NAME, AssertionMessages.IS),
                miscProductPage.getPageElements()
                               .getProductNameIsRequireMessage()
                               .isDisplayed());

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_INFORMATION, AssertionMessages.IS),
                miscProductPage.getPageElements()
                               .getProductInforamtionIsRequireMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should not see the Misc product Title name required message$")
    public void verifyMiscProductTitleNameRequiredMessageIsNotDisplayed() {

        Assert.assertFalse(MessageFormat.format(AssertionMessages.REQUIRED_PAYMENT_FORM_DETAILS_MISC_PRODUCT_SECTION, AssertionMessages.IS),
                paymentFormPage.getPageElements()
                               .getMiscProductTitleNameIsRequireMessage()
                               .isDisplayed());
    }

    /**
     * 
     */
    @When("^I add a new Misc product$")
    public void addNewMiscProduct() {

        activateTheMiscProductSection();

        selectAddNewMiscProduct();

        fillDetailsInAddedMiscproduct();

        fillInMiscProductTitleNameField();
    }

    /**
     * 
     */
    @When("^I edit the data in the Misc products Price fields by entering alphabets$")
    public void editDataInTheMiscProductsPriceFieldsByEnteringAlphabets() {

        editedMiscPrice = new MiscProduct("Test", "", "");

        miscProductPage.fillDetailsForFirstMiscProduct(editedMiscPrice);

    }

    /**
     * 
     */
    @Then("^I should not see the alphabets input in the Misc products Price fields$")
    public void verfyAlphabetsInputIsNotDisplayedInMiscProductsPriceFields() {

        Assert.assertFalse("MIsc Product Price input contains APPHABETS", miscProductPage.getPageElements()
                                                                                         .getFirstPriceInput()
                                                                                         .getAttribute("value")
                                                                                         .contains(editedMiscPrice.getPrice()));
    }

    /**
     * 
     */
    @When("^I change the input in Misc product price field to numbers$")
    public void changeInputInMiscProductPriceFieldToNumbers() {

        editedMiscPrice = new MiscProduct("200", "", "");

        miscProductPage.fillDetailsForFirstMiscProduct(editedMiscPrice);
    }

    /**
     * 
     */
    @Then("^I should see the number input in the Misc products Price field with the currency$")
    public void verifyNumberInputInMiscProductPriceFieldContainsDollarSign() {

        Assert.assertTrue("Misc Product Price input does not contain " + "$" + " sign ", miscProductPage.getPageElements()
                                                                                                        .getFirstPriceInput()
                                                                                                        .getAttribute("value")
                                                                                                        .contains("$"));
    }

    /**
     * 
     */
    @When("^I edit the Misc products product field details$")
    public void editMiscProductFieldDetails() {

        paymentFormPage.fillMiscProductName("Edited Misc Product Title Name");

        editedMiscProductDetais = new MiscProduct("300", "Edited Misc Product Name", "Edited Misc Product Inforamtion");

        miscProductPage.fillDetailsForFirstMiscProduct(editedMiscProductDetais);
    }

    /**
     * 
     */
    @Then("^I should see edited data in the Misc products product fields$")
    public void verifyEditedDataInTheMiscProductFieldsIsDisplayed() {

        Assert.assertFalse("Misc Product Name input contain old data even after editing them", miscProductPage.getPageElements()
                                                                                                              .getFirstNameInput()
                                                                                                              .getAttribute("value")
                                                                                                              .contains(
                                                                                                                      miscProduct1.getProductName()));

        Assert.assertFalse("Misc Product Price input contain old data even after editing them", miscProductPage.getPageElements()
                                                                                                               .getFirstPriceInput()
                                                                                                               .getAttribute("value")
                                                                                                               .contains(miscProduct1.getPrice()));

        Assert.assertFalse("Misc Product Information input contain old data even after editing them", miscProductPage.getPageElements()
                                                                                                                     .getFirstInformationInput()
                                                                                                                     .getAttribute("value")
                                                                                                                     .contains(
                                                                                                                             miscProduct1.getProductInforamtion()));

        Assert.assertTrue("Misc Product Name input does not contain edited data after editing them", miscProductPage.getPageElements()
                                                                                                                    .getFirstNameInput()
                                                                                                                    .getAttribute("value")
                                                                                                                    .contains(
                                                                                                                            editedMiscProductDetais.getProductName()));

        Assert.assertTrue("Misc Product Price input does not contain edited data after editing them", miscProductPage.getPageElements()
                                                                                                                     .getFirstPriceInput()
                                                                                                                     .getAttribute("value")
                                                                                                                     .contains(
                                                                                                                             editedMiscProductDetais.getPrice()));

        Assert.assertTrue("Misc Product Inforamtion input does not contain edited data after editing them", miscProductPage.getPageElements()
                                                                                                                           .getFirstInformationInput()
                                                                                                                           .getAttribute("value")
                                                                                                                           .contains(
                                                                                                                                   editedMiscProductDetais.getProductInforamtion()));
    }

    /**
     * 
     */
    @When("^I add two new Misc products$")
    public void addTwoMiscProducts() {

        selectAddNewMiscProduct();

        selectAddNewMiscProduct();

        fillDetailsInAddedMiscproduct();

        miscProduct2 = new MiscProduct("500", "Second Mics product", "Second Mics product Information");

        miscProductPage.fillDetailsForSecondMiscProduct(miscProduct2);

    }

    /**
     * 
     */
    @Then("^I should see two Misc products on the Misc products section$")
    public void verifyTwoMiscProductsDisplayedOnMiscProductsSection() {

        Assert.assertTrue("First Misc Product is not displayed", miscProductPage.getPageElements()
                                                                                .getFirstNameInput()
                                                                                .getAttribute("value")
                                                                                .contains(miscProduct1.getProductName()));
        Assert.assertTrue("Second Misc Product is not displayed ", miscProductPage.getPageElements()
                                                                                  .getSecondNameInput()
                                                                                  .getAttribute("value")
                                                                                  .contains(miscProduct2.getProductName()));

    }

    /**
     * 
     */
    @When("^I delete both Misc products$")
    public void deleteBothMiscProducts() {

        miscProductPage.deleteSecondMiscProduct();

        miscProductPage.deleteFirstMiscProduct();
    }

    /**
     * 
     */
    @When("^I delete added Misc Product$")
    public void deleteAddedMiscProduct() {

        miscProductPage.deleteFirstMiscProduct();
    }
}
