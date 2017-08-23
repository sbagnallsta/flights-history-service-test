package com.statravel.autoqa.b2b.paymentformList;

import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_NAME;
import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_PASSWORD;

import java.text.MessageFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.commons.Utilities;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentformListPage.GenericSetting;
import com.statravel.autoqa.domain.enumeration.POS;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginPage;
import com.statravel.autoqa.page.b2b.paymentform.PaymentFormListPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
public class GenericSettingTest {

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

    private GenericSetting genericSetting, editGenericSetting;

    private String phoneNo, bannerCrosssell, bannerHyperlink, generalTAndC, insuranceTandC, thirdPartyTandc, heading;

    private String bannerUrl = "https://www.statravel.co.uk/static/uk_division_web_live/assets/flights-merchandising/AfricaGeneral1.png";

    private String editedBannerUrl = "http://www.statravel.co.uk/static/uk_division_web_live/assets/UK_AirCanada_Mar17_MiniCarousel_282x185-CANADA.jpg";

    private String invalidImageUrl = "http://www.statravel.co.uk/static/uk_division_web_live/assets/UK_AirCanada_Mar17_MiniCarousel_282x185-CANADA.jp";

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
    @Given("^I am on Payment Forms Generic settings page$")
    public void loadPaymentFormsGenericSettingsPage() {
        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_LOGIN, loginPage.isPageLoaded());

        loginPage.login(ADMIN_NAME, ADMIN_PASSWORD);

        homePage.selectPOS(POS.US);

        homePage.clickPaymentFormsMenuItem();

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_PAYMENT_FORM, paymentFormListPage.isPageLoaded());
    }

    /**
     * 
     */
    @Given("^the generic settings fields are empty$")
    public void verifyGenericSettingsFieldsAreEmpty() {
        paymentFormListPage.clearGenericSettingInputField();
    }

    /**
     * 
     */
    @Given("^I should see the generic settings required messages on all required fields$")
    public void verifyGenericSettingsRequiredMessagesAreDisplayedOnAllRequiredFields() {
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_CONTACT_US_INPUT,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getPhoneNumberRequireMessage()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_GENERAL_T_AND_C_INPUT,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getGeneralTAndCInputRequireMessage()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_INSURANCE_T_AND_C_INPUT,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getInsuranceTAndCInputRequireMessage()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_THIRD_PARTY_T_AND_C_INPUT,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getThirdPartyTAndCInputRequireMessage()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_HEADING,
                        AssertionMessages.IS_NOT),
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getHeadingInputRequireMessage()));
    }

    /**
     * 
     */
    @When("^I fill in details in all the generic settings fields$")
    public void fillInDetailsInGenericSettingsFields() {
        genericSetting = new GenericSetting.GenericSettingBuilder().setPhoneNoActive(true)
                                                                   .setPhoneNo("0000000000")
                                                                   .setBannerCrossSellActive(true)
                                                                   .setBannerCrossSell(bannerUrl)
                                                                   .setBannerAdHyperlinkActive(true)
                                                                   .setBannerAdHyperlink(bannerUrl)
                                                                   .setGeneralTAndCActive(true)
                                                                   .setGeneralTAndC("General")
                                                                   .setInsuranceTAndCActive(true)
                                                                   .setInsuranceTAndC("Insurance")
                                                                   .setThirdPartyTAndCActive(true)
                                                                   .setThirdPartyTAndC("Third Party")
                                                                   .setHeadingActive(true)
                                                                   .setHeading("Sorry about that")
                                                                   .build();

        paymentFormListPage.fillGenericSetting(genericSetting);
    }

    /**
     * 
     */
    @When("^I select save on generic setting$")
    public void selectSaveOnGenericSetting() {
        paymentFormListPage.selectSave();
    }

    /**
     * 
     */
    @Then("^I should see the generic settings fields with filled details$")
    public void verifyGenericSettingsFieldsDisplayedEnteredDetails() {

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_CONTACT_US_INPUT),
                paymentFormListPage.getPageElements()
                                   .getPhoneNumberInput()
                                   .getAttribute("value")
                                   .equals(genericSetting.getPhoneNo()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_BANNER_CROSS_SELL_INPUT),
                paymentFormListPage.getPageElements()
                                   .getBannerCrossSellInput()
                                   .getAttribute("value")
                                   .equals(bannerUrl));
        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_BANNER_AD_HYPERLINK_INPUT),
                paymentFormListPage.getPageElements()
                                   .getBannerAdHyperlinkInput()
                                   .getAttribute("value")
                                   .equals(bannerUrl));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_GENERAL_T_AND_C_INPUT),
                paymentFormListPage.getPageElements()
                                   .getGeneralTAndCInput()
                                   .getAttribute("value")
                                   .equals(genericSetting.getGeneralTAndC()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_INSURANCE_T_AND_C_INPUT),
                paymentFormListPage.getPageElements()
                                   .getInsuranceTAndCInput()
                                   .getAttribute("value")
                                   .equals(genericSetting.getInsuranceTAndC()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_THIRD_PARTY_T_AND_C_INPUT),
                paymentFormListPage.getPageElements()
                                   .getThirdPartyTAndCInput()
                                   .getAttribute("value")
                                   .equals(genericSetting.getThirdPartyTAndC()));

        Assert.assertTrue(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_HEADING),
                paymentFormListPage.getPageElements()
                                   .getHeadingInput()
                                   .getAttribute("value")
                                   .equals(genericSetting.getHeading()));
    }

    /**
     * 
     */
    @Then("^I should not see the generic settings required messages on all required fields$")
    public void verifyGenericSettingsRequiredMessagesAreNotDisplayedOnAllRequiredFields() {
        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_CONTACT_US_INPUT,
                        AssertionMessages.IS),
                paymentFormListPage.getPageElements()
                                   .getPhoneNumberRequireMessage()
                                   .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_GENERAL_T_AND_C_INPUT,
                        AssertionMessages.IS),
                paymentFormListPage.getPageElements()
                                   .getGeneralTAndCInputRequireMessage()
                                   .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_INSURANCE_T_AND_C_INPUT,
                        AssertionMessages.IS),
                paymentFormListPage.getPageElements()
                                   .getInsuranceTAndCInputRequireMessage()
                                   .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_THIRD_PARTY_T_AND_C_INPUT,
                        AssertionMessages.IS),
                paymentFormListPage.getPageElements()
                                   .getThirdPartyTAndCInputRequireMessage()
                                   .isDisplayed());

        Assert.assertFalse(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_REQUIRED_MESSAGE, AssertionMessages.GENERIC_SETTING_HEADING,
                        AssertionMessages.IS),
                paymentFormListPage.getPageElements()
                                   .getHeadingInputRequireMessage()
                                   .isDisplayed());
    }

    /**
     * 
     */
    @Given("^details have been added in the generic settings fields$")
    public void verifyDetailsHaveBeenAllreadyAddedInGenericSettingsFields() {

        fillInDetailsInGenericSettingsFields();

        phoneNo = paymentFormListPage.getPageElements()
                                     .getPhoneNumberInput()
                                     .getAttribute("value");

        bannerCrosssell = paymentFormListPage.getPageElements()
                                             .getBannerCrossSellInput()
                                             .getAttribute("value");

        bannerHyperlink = paymentFormListPage.getPageElements()
                                             .getBannerAdHyperlinkInput()
                                             .getAttribute("value");

        generalTAndC = paymentFormListPage.getPageElements()
                                          .getGeneralTAndCInput()
                                          .getAttribute("value");

        insuranceTandC = paymentFormListPage.getPageElements()
                                            .getInsuranceTAndCInput()
                                            .getAttribute("value");

        thirdPartyTandc = paymentFormListPage.getPageElements()
                                             .getThirdPartyTAndCInput()
                                             .getAttribute("value");

        heading = paymentFormListPage.getPageElements()
                                     .getHeadingInput()
                                     .getAttribute("value");

        paymentFormListPage.clearGenericSettingInputField();
    }

    /**
     * 
     */
    @When("^I edit the details in all the generic settings fields$")
    public void editDetailsInAllGenericSettingsFields() {
        editGenericSetting = new GenericSetting.GenericSettingBuilder().setPhoneNoActive(true)
                                                                       .setPhoneNo("" + utilities.getRandomIntOverOneThousand())
                                                                       .setBannerCrossSellActive(true)
                                                                       .setBannerCrossSell(editedBannerUrl)
                                                                       .setBannerAdHyperlinkActive(true)
                                                                       .setBannerAdHyperlink(editedBannerUrl)
                                                                       .setGeneralTAndCActive(true)
                                                                       .setGeneralTAndC(utilities.getRandomString(170))
                                                                       .setInsuranceTAndCActive(true)
                                                                       .setInsuranceTAndC(utilities.getRandomString(170))
                                                                       .setThirdPartyTAndCActive(true)
                                                                       .setThirdPartyTAndC(utilities.getRandomString(400))
                                                                       .setHeadingActive(true)
                                                                       .setHeading(utilities.getRandomString(10))
                                                                       .build();

        paymentFormListPage.fillGenericSetting(editGenericSetting);

    }

    /**
     * 
     */
    @Then("^I should see the generic settings fields with edited details$")
    public void verifyEditedInputSavedInGenericSettingsFields() {

        Assert.assertNotEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_CONTAIN_OLD_VALUE, AssertionMessages.GENERIC_SETTING_CONTACT_US_INPUT),
                phoneNo, paymentFormListPage.getPageElements()
                                            .getPhoneNumberInput()
                                            .getAttribute("value"));

        Assert.assertNotEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_CONTAIN_OLD_VALUE,
                        AssertionMessages.GENERIC_SETTING_BANNER_CROSS_SELL_INPUT),
                bannerCrosssell, paymentFormListPage.getPageElements()
                                                    .getBannerCrossSellInput()
                                                    .getAttribute("value"));

        Assert.assertNotEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_CONTAIN_OLD_VALUE,
                        AssertionMessages.GENERIC_SETTING_BANNER_AD_HYPERLINK_INPUT),
                bannerHyperlink, paymentFormListPage.getPageElements()
                                                    .getBannerAdHyperlinkInput()
                                                    .getAttribute("value"));

        Assert.assertNotEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_CONTAIN_OLD_VALUE,
                        AssertionMessages.GENERIC_SETTING_GENERAL_T_AND_C_INPUT),
                generalTAndC, paymentFormListPage.getPageElements()
                                                 .getGeneralTAndCInput()
                                                 .getAttribute("value"));

        Assert.assertNotEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_CONTAIN_OLD_VALUE,
                        AssertionMessages.GENERIC_SETTING_INSURANCE_T_AND_C_INPUT),
                insuranceTandC, paymentFormListPage.getPageElements()
                                                   .getInsuranceTAndCInput()
                                                   .getAttribute("value"));

        Assert.assertNotEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_CONTAIN_OLD_VALUE,
                        AssertionMessages.GENERIC_SETTING_THIRD_PARTY_T_AND_C_INPUT),
                thirdPartyTandc, paymentFormListPage.getPageElements()
                                                    .getThirdPartyTAndCInput()
                                                    .getAttribute("value"));

        Assert.assertNotEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_CONTAIN_OLD_VALUE, AssertionMessages.GENERIC_SETTING_HEADING), heading,
                paymentFormListPage.getPageElements()
                                   .getHeadingInput()
                                   .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_EDITED,
                        AssertionMessages.GENERIC_SETTING_CONTACT_US_INPUT),
                editGenericSetting.getPhoneNo(), paymentFormListPage.getPageElements()
                                                                    .getPhoneNumberInput()
                                                                    .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_EDITED,
                        AssertionMessages.GENERIC_SETTING_BANNER_CROSS_SELL_INPUT),
                editGenericSetting.getBannerCrossSell(), paymentFormListPage.getPageElements()
                                                                            .getBannerCrossSellInput()
                                                                            .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_EDITED,
                        AssertionMessages.GENERIC_SETTING_BANNER_AD_HYPERLINK_INPUT),
                editGenericSetting.getBannerAdHyperlink(), paymentFormListPage.getPageElements()
                                                                              .getBannerAdHyperlinkInput()
                                                                              .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_EDITED,
                        AssertionMessages.GENERIC_SETTING_GENERAL_T_AND_C_INPUT),
                editGenericSetting.getGeneralTAndC(), paymentFormListPage.getPageElements()
                                                                         .getGeneralTAndCInput()
                                                                         .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_EDITED,
                        AssertionMessages.GENERIC_SETTING_INSURANCE_T_AND_C_INPUT),
                editGenericSetting.getInsuranceTAndC(), paymentFormListPage.getPageElements()
                                                                           .getInsuranceTAndCInput()
                                                                           .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_EDITED,
                        AssertionMessages.GENERIC_SETTING_THIRD_PARTY_T_AND_C_INPUT),
                editGenericSetting.getThirdPartyTAndC(), paymentFormListPage.getPageElements()
                                                                            .getThirdPartyTAndCInput()
                                                                            .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_EDITED,
                        AssertionMessages.GENERIC_SETTING_HEADING),
                editGenericSetting.getHeading(), paymentFormListPage.getPageElements()
                                                                    .getHeadingInput()
                                                                    .getAttribute("value"));

    }

    /**
     * 
     */
    @When("^I enter alphabets in the contact us phone number field$")
    public void enterAlphabetsInContactUsPhoneNumberField() {

        genericSetting = new GenericSetting.GenericSettingBuilder().setPhoneNoActive(true)
                                                                   .setPhoneNo("" + utilities.getRandomString(10))
                                                                   .build();

        paymentFormListPage.fillGenericSetting(genericSetting);

    }

    /**
     * 
     */
    @Then("^I should see the contact us phone number field error message$")
    public void verifyContactUsPhoneNumberFieldErrorMessageIsDisplayed() {
        Assert.assertTrue("Phone No only accepts numbers and -* error message is not displayed even after invalid input",
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getPhoneNumberPatternErrorMessage()));
    }

    /**
     * 
     */
    @When("^I change the input to any other character except -&\\*$")
    public void changeInputAnyOtherCharacterExcept() {
        genericSetting = new GenericSetting.GenericSettingBuilder().setPhoneNoActive(true)
                                                                   .setPhoneNo("" + utilities.randomChar())
                                                                   .build();

        paymentFormListPage.fillGenericSetting(genericSetting);

    }

    /**
     * 
     */
    @When("^I change the input to only numbers$")
    public void changeInputToOnlyNumbers() {
        genericSetting = new GenericSetting.GenericSettingBuilder().setPhoneNoActive(true)
                                                                   .setPhoneNo("" + utilities.getRandomIntOverOneThousand()
                                                                           + utilities.getRandomIntOverOneThousand())
                                                                   .build();

        paymentFormListPage.fillGenericSetting(genericSetting);

    }

    /**
     * 
     */
    @Then("^I should not see the contact us phone number field error message$")
    public void verifyContactUsPhoneNumberFieldErrorMessageIsNotDisplayed() {
        Assert.assertFalse("Phone No only accepts numbers and -* error message is displayed even after entering valid input",
                paymentFormListPage.getPageElements()
                                   .getPhoneNumberPatternErrorMessage()
                                   .isDisplayed());
    }

    /**
     * 
     */
    @When("^I enter an invalid hyperlink$")
    public void enterAnInvalidHyperlink() {
        genericSetting = new GenericSetting.GenericSettingBuilder().setBannerCrossSellActive(true)
                                                                   .setBannerCrossSell(utilities.getRandomString(18))
                                                                   .setBannerAdHyperlinkActive(true)
                                                                   .setBannerAdHyperlink(utilities.getRandomString(10))
                                                                   .build();

        paymentFormListPage.fillGenericSetting(genericSetting);

    }

    /**
     * 
     */
    @Then("^I should see the invalid hyperlink message$")
    public void verifyInvalidHyperlinkMessageIsDisplayed() {
        Assert.assertTrue("BANNER/CROSS SELL url is not a correct url message is not displayed",
                webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                .getBannerCrossSellIncorrectUrlMessage()));

        Assert.assertTrue("Invalid Hyperlink! message is not displayed", webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                                                                         .getBannerAdHyperlinkInputInvalidURLMessage()));
    }

    /**
     * 
     */
    @When("^I enter invalid image url$")
    public void enterInvalidImageUrl() {
        genericSetting = new GenericSetting.GenericSettingBuilder().setBannerCrossSellActive(true)
                                                                   .setBannerCrossSell(invalidImageUrl)
                                                                   .build();

        paymentFormListPage.fillGenericSetting(genericSetting);

    }

    /**
     * 
     */
    @Then("^I should see invalid image message$")
    public void verifyInvalidImageMessageIsDisplayed() {
        paymentFormListPage.clickOnBannerCrossSellHeading();

        Assert.assertTrue("Image does not exist! message is not displayed", webDriverCommons.isDisplayed(paymentFormListPage.getPageElements()
                                                                                                                            .getImageNotExistErrorMessage()));
    }

    /**
     * 
     */
    @When("^I change the input to a valid hyperlink$")
    public void changeInputToValidHyperlink() {
        genericSetting = new GenericSetting.GenericSettingBuilder().setBannerCrossSellActive(true)
                                                                   .setBannerCrossSell(bannerUrl)
                                                                   .setBannerAdHyperlinkActive(true)
                                                                   .setBannerAdHyperlink(bannerUrl)
                                                                   .build();

        paymentFormListPage.fillGenericSetting(genericSetting);
    }

    /**
     * 
     */
    @Then("^I should not see the invalid hyperlink message$")
    public void verifyInvalidHyperlinkMessageIsNotDisplayed() {
        Assert.assertFalse("BANNER/CROSS SELL url is not a correct url message is displayed", paymentFormListPage.getPageElements()
                                                                                                                 .getBannerCrossSellIncorrectUrlMessage()
                                                                                                                 .isDisplayed());

        Assert.assertFalse("Invalid Hyperlink! message is displayed", paymentFormListPage.getPageElements()
                                                                                         .getBannerAdHyperlinkInputInvalidURLMessage()
                                                                                         .isDisplayed());

        Assert.assertFalse("Image does not exist! message is displayed", paymentFormListPage.getPageElements()
                                                                                            .getImageNotExistErrorMessage()
                                                                                            .isDisplayed());
    }

    /**
     * 
     */
    @Then("^I should see banner and hyperlink field with details$")
    public void verifyBannerCrosssellAndHyperlinkFieldWithDetails() {
        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_BANNER_CROSS_SELL_INPUT),
                bannerUrl, paymentFormListPage.getPageElements()
                                              .getBannerCrossSellInput()
                                              .getAttribute("value"));

        Assert.assertEquals(
                MessageFormat.format(AssertionMessages.GENERAL_SETTING_INPUT_DOES_NOT_CONTAIN_VALUE_AS_ENTERED,
                        AssertionMessages.GENERIC_SETTING_BANNER_AD_HYPERLINK_INPUT),
                bannerUrl, paymentFormListPage.getPageElements()
                                              .getBannerAdHyperlinkInput()
                                              .getAttribute("value"));
    }

}
