package com.statravel.autoqa.page.b2b.paymentform;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class PaymentFormListPageElements extends PageElements {

    @FindBy(css = "#payment-forms-add-new")
    private WebElement addNewFormButton;

    @FindBy(css = "#payment-forms-form-name-0")
    private WebElement firstFormNameConfirmation;

    @FindBy(css = "#payment-forms-form-name-1")
    private WebElement secondFormNameConfirmation;

    @FindBy(css = "#payment-forms-form-url-0")
    private WebElement firstFormUrlConfirmation;

    @FindBy(css = "#payment-forms-form-url-1")
    private WebElement secondFormUrlConfirmation;

    @FindBy(css = "#payment-forms-form-id-0")
    private WebElement firstFormIDConfirmation;

    @FindBy(css = "#payment-forms-form-id-1")
    private WebElement secondFormIDConfirmation;
    
    @FindBy(css = "#payment-forms-form-id-19")
    private WebElement lastFormIdConfirmation;

    @FindBy(css = "#payment-forms-edit-0")
    private WebElement firstFormEditButton;

    @FindBy(css = "#payment-forms-edit-1")
    private WebElement secondFormEditButton;

    @FindBy(css = "#payment-forms-delete-0")
    private WebElement firstDeleteButton;

    @FindBy(css = "#payment-forms-delete-1")
    private WebElement secondtDeleteButton;

    @FindBy(css = "#payment-forms-copy-0")
    private WebElement firstCopyButton;

    @FindBy(css = "#payment-forms-copy-1")
    private WebElement secondCopyButton;

    @FindBy(css = "#payment-forms-active-0-true")
    private WebElement firstFormActiveBarActiveMode;

    @FindBy(css = "#payment-forms-active-0-false")
    private WebElement firstFormActiveBaInactiveMode;

    @FindBy(css = "#searchFormsText")
    private WebElement searchInput;

    @FindBy(css = "#payment-forms-header-id")
    private WebElement idSortingButton;
    
    @FindBy(css = "#payment-forms-header-name")
    private WebElement formNameSortingButton;

    @FindBy(css = "#payment-forms-pager-next")
    private WebElement goToNextPageButton;

    @FindBy(css = "#payment-forms-pager-prev")
    private WebElement goToPriviousButton;
    
    @FindBy(css = "#payment-forms-pager-1")
    private WebElement goToPageTwoButton;

    @FindBy(css = "#generic-settings-phone-number")
    private WebElement phoneNumberInput;

    @FindBy(css = "#generic-settings-phone-number-required")
    private WebElement phoneNumberRequireMessage;

    @FindBy(css = "#generic-settings-phone-number-pattern")
    private WebElement phoneNumberPatternErrorMessage;

    @FindBy(xpath = "//span[@id='generic-settings-phone-number-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement phoneNumberRequireErrorMessage;

    @FindBy(css = "#generic-settings-banner-cross-sell")
    private WebElement bannerCrossSellInput;

    @FindBy(css = "#generic-settings-banner-cross-sell-url-incorrect")
    private WebElement bannerCrossSellIncorrectUrlMessage;

    @FindBy(css = "#generic-settings-banner-ad-hyperlink")
    private WebElement bannerAdHyperlinkInput;

    @FindBy(css = "#generic-settings-banner-ad-hyperlink-invalid-hyperlink")
    private WebElement bannerAdHyperlinkInputInvalidURLMessage;

    @FindBy(css = "#generic-settings-terms-conditions-general")
    private WebElement generalTAndCInput;

    @FindBy(css = "#generic-settings-terms-conditions-general-required")
    private WebElement generalTAndCInputRequireMessage;

    @FindBy(xpath = "//span[@id='generic-settings-terms-conditions-general-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement generalTAndCInputRequireErrorMessage;

    @FindBy(css = "#generic-settings-terms-conditions-insurance")
    private WebElement insuranceTAndCInput;

    @FindBy(css = "#generic-settings-terms-conditions-insurance-required")
    private WebElement insuranceTAndCInputRequireMessage;

    @FindBy(xpath = "//span[@id='generic-settings-terms-conditions-insurance-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement insuranceTAndCInputRequireErrorMessage;

    @FindBy(css = "#generic-settings-third-party-terms-conditions")
    private WebElement thirdPartyTAndCInput;

    @FindBy(css = "#generic-settings-third-party-terms-conditions-required")
    private WebElement thirdPartyTAndCInputRequireMessage;

    @FindBy(xpath = "//span[@id='generic-settings-third-party-terms-conditions-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement thirdPartyTAndCInputRequireErrorMessage;

    @FindBy(css = "#generic-settings-payment-error-page-heading")
    private WebElement headingInput;

    @FindBy(css = "#generic-settings-payment-error-page-heading-required")
    private WebElement headingInputRequireMessage;

    @FindBy(xpath = "//span[@id='generic-settings-payment-error-page-heading-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement headingInputRequireErrorMessage;

    @FindBy(css = "#generic-settings-submit-button")
    private WebElement genericSettingSaveButton;

    @FindBy(css = "#generic-settings-banner-cross-sell-title")
    private WebElement bannerCrossSellHeading;

    @FindBy(css = "#generic-settings-banner-cross-sell-image-does-not-exist")
    private WebElement imageNotExistErrorMessage;

    @FindBy(xpath = ".//*[@id='paymentFormsTable']//tbody//tr")
    private List<WebElement> numberOfSurchResult;

    /**
     * @return the imageNotExistErrorMessage
     */
    public WebElement getImageNotExistErrorMessage() {
        return imageNotExistErrorMessage;
    }

    /**
     * @return the bannerCrossSellHeading
     */
    public WebElement getBannerCrossSellHeading() {
        return bannerCrossSellHeading;
    }

    /**
     * @return the addNewFormButton
     */
    public WebElement getAddNewFormButton() {
        return addNewFormButton;
    }

    /**
     * @return the firstFormNameConfirmation
     */
    public WebElement getFirstFormNameConfirmation() {
        return firstFormNameConfirmation;
    }

    /**
     * @return the secondFormNameConfirmation
     */
    public WebElement getSecondFormNameConfirmation() {
        return secondFormNameConfirmation;
    }

    /**
     * @return the firstFormUrlConfirmation
     */
    public WebElement getFirstFormUrlConfirmation() {
        return firstFormUrlConfirmation;
    }

    /**
     * @return the secondFormUrlConfirmation
     */
    public WebElement getSecondFormUrlConfirmation() {
        return secondFormUrlConfirmation;
    }

    /**
     * @return the firstFormIDConfirmation
     */
    public WebElement getFirstFormIDConfirmation() {
        return firstFormIDConfirmation;
    }

    /**
     * @return the secondFormIDConfirmation
     */
    public WebElement getSecondFormIDConfirmation() {
        return secondFormIDConfirmation;
    }

    /**
     * @return the firstFormEditButton
     */
    public WebElement getFirstFormEditButton() {
        return firstFormEditButton;
    }

    /**
     * @return the secondFormEditButton
     */
    public WebElement getSecondFormEditButton() {
        return secondFormEditButton;
    }

    /**
     * @return the phoneNumberInput
     */
    public WebElement getPhoneNumberInput() {
        return phoneNumberInput;
    }

    /**
     * @return the phoneNumberRequireMessage
     */
    public WebElement getPhoneNumberRequireMessage() {
        return phoneNumberRequireMessage;
    }

    /**
     * @return the phoneNumberRequireErrorMessage
     */
    public WebElement getPhoneNumberRequireErrorMessage() {
        return phoneNumberRequireErrorMessage;
    }

    /**
     * @return the phoneNumberPatternErrorMessage
     */
    public WebElement getPhoneNumberPatternErrorMessage() {
        return phoneNumberPatternErrorMessage;
    }

    /**
     * @return the bannerCrossSellInput
     */
    public WebElement getBannerCrossSellInput() {
        return bannerCrossSellInput;
    }

    /**
     * @return the bannerCrossSellIncorrectUrlMessage
     */
    public WebElement getBannerCrossSellIncorrectUrlMessage() {
        return bannerCrossSellIncorrectUrlMessage;
    }

    /**
     * @return the bannerAdHyperlinkInput
     */
    public WebElement getBannerAdHyperlinkInput() {
        return bannerAdHyperlinkInput;
    }

    /**
     * @return the bannerAdHyperlinkInputInvalidURLMessage
     */
    public WebElement getBannerAdHyperlinkInputInvalidURLMessage() {
        return bannerAdHyperlinkInputInvalidURLMessage;
    }

    /**
     * @return the generalTAndCInput
     */
    public WebElement getGeneralTAndCInput() {
        return generalTAndCInput;
    }

    /**
     * @return the generalTAndCInputRequireMessage
     */
    public WebElement getGeneralTAndCInputRequireMessage() {
        return generalTAndCInputRequireMessage;
    }

    /**
     * @return the generalTAndCInputRequireErrorMessage
     */
    public WebElement getGeneralTAndCInputRequireErrorMessage() {
        return generalTAndCInputRequireErrorMessage;
    }

    /**
     * @return the insuranceTAndCInput
     */
    public WebElement getInsuranceTAndCInput() {
        return insuranceTAndCInput;
    }

    /**
     * @return the insuranceTAndCInputRequireMessage
     */
    public WebElement getInsuranceTAndCInputRequireMessage() {
        return insuranceTAndCInputRequireMessage;
    }

    /**
     * @return the insuranceTAndCInputRequireErrorMessage
     */
    public WebElement getInsuranceTAndCInputRequireErrorMessage() {
        return insuranceTAndCInputRequireErrorMessage;
    }

    /**
     * @return the thirdPartyTAndCInput
     */
    public WebElement getThirdPartyTAndCInput() {
        return thirdPartyTAndCInput;
    }

    /**
     * @return the thirdPartyTAndCInputRequireMessage
     */
    public WebElement getThirdPartyTAndCInputRequireMessage() {
        return thirdPartyTAndCInputRequireMessage;
    }

    /**
     * @return the thirdPartyTAndCInputRequireErrorMessage
     */
    public WebElement getThirdPartyTAndCInputRequireErrorMessage() {
        return thirdPartyTAndCInputRequireErrorMessage;
    }

    /**
     * @return the headingInput
     */
    public WebElement getHeadingInput() {
        return headingInput;
    }

    /**
     * @return the headingInputRequireMessage
     */
    public WebElement getHeadingInputRequireMessage() {
        return headingInputRequireMessage;
    }

    /**
     * @return the headingInputRequireErrorMessage
     */
    public WebElement getHeadingInputRequireErrorMessage() {
        return headingInputRequireErrorMessage;
    }

    /**
     * @return the genericSettingSaveButton
     */
    public WebElement getGenericSettingSaveButton() {
        return genericSettingSaveButton;
    }

    /**
     * @return the firstDeleteButton
     */
    public WebElement getFirstDeleteButton() {
        return firstDeleteButton;
    }

    /**
     * @return the secondtDeleteButton
     */
    public WebElement getSecondtDeleteButton() {
        return secondtDeleteButton;
    }

    /**
     * @return the firstCopyButton
     */
    public WebElement getFirstCopyButton() {
        return firstCopyButton;
    }

    /**
     * @return the secondCopyButton
     */
    public WebElement getSecondCopyButton() {
        return secondCopyButton;
    }

    /**
     * @return the firstFormActiveBarActiveBar
     */
    public WebElement getFirstFormActiveBarActiveMode() {
        return firstFormActiveBarActiveMode;
    }

    /**
     * @return the firstFormActiveBaInactiveBar
     */
    public WebElement getFirstFormActiveBaInactiveMode() {
        return firstFormActiveBaInactiveMode;
    }

    /**
     * @return the searchInput
     */
    public WebElement getSearchInput() {
        return searchInput;
    }

    /**
     * @return the numberOfSurchResult
     */
    public List<WebElement> getNumberOfSurchResult() {
        return numberOfSurchResult;
    }

    /**
     * @return the idSortingButton
     */
    public WebElement getIdSortingButton() {
        return idSortingButton;
    }

    /**
     * @return the formNameSortingButton
     */
    public WebElement getFormNameSortingButton() {
        return formNameSortingButton;
    }

    /**
     * @return the goToNextPageButton
     */
    public WebElement getGoToNextPageButton() {
        return goToNextPageButton;
    }

    /**
     * @return the goToPriviousButton
     */
    public WebElement getGoToPriviousButton() {
        return goToPriviousButton;
    }

    /**
     * @return the lastFormNameConfirmation
     */
    public WebElement getLastFormIdConfirmation() {
        return lastFormIdConfirmation;
    }

    /**
     * @return the goToPageTwoButton
     */
    public WebElement getGoToPageTwoButton() {
        return goToPageTwoButton;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentFormListPageElements [addNewFormButton=" + addNewFormButton + ", firstFormNameConfirmation=" + firstFormNameConfirmation
                + ", secondFormNameConfirmation=" + secondFormNameConfirmation + ", firstFormUrlConfirmation=" + firstFormUrlConfirmation
                + ", secondFormUrlConfirmation=" + secondFormUrlConfirmation + ", firstFormIDConfirmation=" + firstFormIDConfirmation
                + ", secondFormIDConfirmation=" + secondFormIDConfirmation + ", lastFormIdConfirmation=" + lastFormIdConfirmation
                + ", firstFormEditButton=" + firstFormEditButton + ", secondFormEditButton=" + secondFormEditButton + ", firstDeleteButton="
                + firstDeleteButton + ", secondtDeleteButton=" + secondtDeleteButton + ", firstCopyButton=" + firstCopyButton + ", secondCopyButton="
                + secondCopyButton + ", firstFormActiveBarActiveMode=" + firstFormActiveBarActiveMode + ", firstFormActiveBaInactiveMode="
                + firstFormActiveBaInactiveMode + ", searchInput=" + searchInput + ", idSortingButton=" + idSortingButton + ", formNameSortingButton="
                + formNameSortingButton + ", goToNextPageButton=" + goToNextPageButton + ", goToPriviousButton=" + goToPriviousButton
                + ", goToPageTwoButton=" + goToPageTwoButton + ", phoneNumberInput=" + phoneNumberInput + ", phoneNumberRequireMessage="
                + phoneNumberRequireMessage + ", phoneNumberPatternErrorMessage=" + phoneNumberPatternErrorMessage
                + ", phoneNumberRequireErrorMessage=" + phoneNumberRequireErrorMessage + ", bannerCrossSellInput=" + bannerCrossSellInput
                + ", bannerCrossSellIncorrectUrlMessage=" + bannerCrossSellIncorrectUrlMessage + ", bannerAdHyperlinkInput=" + bannerAdHyperlinkInput
                + ", bannerAdHyperlinkInputInvalidURLMessage=" + bannerAdHyperlinkInputInvalidURLMessage + ", generalTAndCInput=" + generalTAndCInput
                + ", generalTAndCInputRequireMessage=" + generalTAndCInputRequireMessage + ", generalTAndCInputRequireErrorMessage="
                + generalTAndCInputRequireErrorMessage + ", insuranceTAndCInput=" + insuranceTAndCInput + ", insuranceTAndCInputRequireMessage="
                + insuranceTAndCInputRequireMessage + ", insuranceTAndCInputRequireErrorMessage=" + insuranceTAndCInputRequireErrorMessage
                + ", thirdPartyTAndCInput=" + thirdPartyTAndCInput + ", thirdPartyTAndCInputRequireMessage=" + thirdPartyTAndCInputRequireMessage
                + ", thirdPartyTAndCInputRequireErrorMessage=" + thirdPartyTAndCInputRequireErrorMessage + ", headingInput=" + headingInput
                + ", headingInputRequireMessage=" + headingInputRequireMessage + ", headingInputRequireErrorMessage="
                + headingInputRequireErrorMessage + ", genericSettingSaveButton=" + genericSettingSaveButton + ", bannerCrossSellHeading="
                + bannerCrossSellHeading + ", imageNotExistErrorMessage=" + imageNotExistErrorMessage + ", numberOfSurchResult=" + numberOfSurchResult
                + "]";
    }

}
