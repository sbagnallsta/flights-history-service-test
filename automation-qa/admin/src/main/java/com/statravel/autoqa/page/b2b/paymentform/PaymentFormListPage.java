package com.statravel.autoqa.page.b2b.paymentform;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.commons.WebDriverFactory;
import com.statravel.autoqa.domain.b2b.paymentformListPage.GenericSetting;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class PaymentFormListPage extends Page<PaymentFormListPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private PaymentFormListPageElements paymentFormListElements;

    private String id, referenceNo, partnerName;

    private static final int GET_ID_ARRAY_INDEX = 8;
    private static final int GET_FORM_NAME_ARRAY_INDEX = 7;
    private static final int GET_PARTNER_NAME_ARRAY_INDEX = 6;
    private static final int PAYMENT_FORMS_LIST_SIZE = 20;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        paymentFormListElements = new PaymentFormListPageElements();

        super.initialiseElements(paymentFormListElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(paymentFormListElements.getAddNewFormButton());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public PaymentFormListPageElements getPageElements() {

        return paymentFormListElements;
    }

    /**
     * Adds new Payment Form.
     */
    public void addNewForm() {

        webDriverCommons.click(paymentFormListElements.getAddNewFormButton());

    }

    /**
     * scroll to first form.
     */
    public void scrollToFirstForm() {
        webDriverCommons.scrollTo(paymentFormListElements.getFirstFormIDConfirmation());
    }

    /**
     * click on first form edit button.
     */
    public void selectFirstFormEdit() {

        webDriverCommons.click(paymentFormListElements.getFirstFormEditButton());

    }

    /**
     * Clear generic setting input fields.
     */
    public void clearGenericSettingInputField() {

        webDriverCommons.clear(paymentFormListElements.getPhoneNumberInput());

        webDriverCommons.clear(paymentFormListElements.getBannerCrossSellInput());

        webDriverCommons.clear(paymentFormListElements.getBannerAdHyperlinkInput());

        webDriverCommons.clear(paymentFormListElements.getGeneralTAndCInput());

        webDriverCommons.clear(paymentFormListElements.getInsuranceTAndCInput());

        webDriverCommons.clear(paymentFormListElements.getThirdPartyTAndCInput());

        webDriverCommons.clear(paymentFormListElements.getHeadingInput());

    }

    /**
     * fill in details for general setting input.
     * 
     * @param genericSetting
     *            generic setting
     */
    public void fillGenericSetting(final GenericSetting genericSetting) {
        webDriverCommons.scrollTo(paymentFormListElements.getPhoneNumberInput());
        if (genericSetting.isPhoneNoActive()) {
            webDriverCommons.sendKeys(paymentFormListElements.getPhoneNumberInput(), genericSetting.getPhoneNo());
        }
        if (genericSetting.isBannerCrossSellActive()) {
            webDriverCommons.sendKeys(paymentFormListElements.getBannerCrossSellInput(), genericSetting.getBannerCrossSell());
        }
        if (genericSetting.isBannerAdHyperlinkActive()) {
            webDriverCommons.sendKeys(paymentFormListElements.getBannerAdHyperlinkInput(), genericSetting.getBannerAdHyperlink());
        }
        if (genericSetting.isGeneralTAndCActive()) {
            webDriverCommons.sendKeys(paymentFormListElements.getGeneralTAndCInput(), genericSetting.getGeneralTAndC());
        }
        if (genericSetting.isInsuranceTAndCActive()) {
            webDriverCommons.sendKeys(paymentFormListElements.getInsuranceTAndCInput(), genericSetting.getInsuranceTAndC());
        }
        if (genericSetting.isThirdPartyTAndCActive()) {
            webDriverCommons.sendKeys(paymentFormListElements.getThirdPartyTAndCInput(), genericSetting.getThirdPartyTAndC());
        }
        if (genericSetting.isHeadingActive()) {
            webDriverCommons.sendKeys(paymentFormListElements.getHeadingInput(), genericSetting.getHeading());
        }
    }

    /**
     * click in save button.
     */
    public void selectSave() {

        webDriverCommons.click(paymentFormListElements.getGenericSettingSaveButton());

    }

    /**
     * click on banner cross sell heading.
     */
    public void clickOnBannerCrossSellHeading() {
        webDriverCommons.click(paymentFormListElements.getBannerCrossSellHeading());

    }

    /**
     * click on first form delete button.
     */
    public void deleteFirstForm() {
        webDriverCommons.click(paymentFormListElements.getFirstDeleteButton());

        Alert deleteAlert = webDriverCommons.getAlertPopUp();

        deleteAlert.accept();

    }

    /**
     * click on first form active bar active mode.
     */
    public void toggleFirstFormActiveMOde() {

        webDriverCommons.click(paymentFormListElements.getFirstFormActiveBarActiveMode());

    }

    /**
     * click on first form active bar inactive mode.
     */
    public void togggleFirstFormInacticeMode() {

        webDriverCommons.click(paymentFormListElements.getFirstFormActiveBaInactiveMode());

    }

    /**
     * click on first form copy button.
     */
    public void selectFirstFormCopy() {

        webDriverCommons.click(paymentFormListElements.getFirstCopyButton());

    }

    /**
     * enter value in search box.
     * 
     * @param searchParameter
     *            search parameter
     */
    public void enterValueToSearchField(final String searchParameter) {

        webDriverCommons.sendKeys(paymentFormListElements.getSearchInput(), searchParameter);
    }

    /**
     * 
     * @param value
     *            value
     * @return is search result displayed
     */
    public boolean isResultContainSearch(final String value) {

        List<WebElement> list = WebDriverFactory.getWebDriver()
                                                .findElements(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr"));
        int size = list.size();
        boolean flag = false;
        for (int i = 1; i <= size; i++) {
            if (webDriverCommons.isDisplayed(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr[" + i + "]//td[contains(text(),'" + value + "')]"))
                    || webDriverCommons.isDisplayed(
                            By.xpath("//*[@id='paymentFormsTable']//tbody//tr[" + i + "]//td//a[contains(text(),'" + value + "')]"))) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * check is id sorted by order as should be.
     * 
     * @param order
     *            order
     * @return true if id order sorted by order else return false
     * 
     */
    public boolean isIdSorted(final String order) {
        List<WebElement> list = WebDriverFactory.getWebDriver()
                                                .findElements(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr"));
        int size = list.size();
        boolean flag = false;

        for (int i = 1; i <= size; i++) {
            int a = Integer.parseInt(WebDriverFactory.getWebDriver()
                                                     .findElement(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr[" + i
                                                             + "]//td[starts-with(@id,'payment-forms-form-id')]"))
                                                     .getText());

            for (int j = i + 1; j < size;) {
                int b = Integer.parseInt(WebDriverFactory.getWebDriver()
                                                         .findElement(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr[" + j
                                                                 + "]//td[starts-with(@id,'payment-forms-form-id')]"))
                                                         .getText());
                if (order.equals("Asceding")) {
                    if ((a < b)) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                } else if (order.equals("Dsceding")) {
                    if ((a > b)) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }

                break;
            }
        }
        return flag;
    }

    /**
     * check is form name sorted by order as should be.
     * 
     * @param order
     *            order
     * @return true if form name order sorted by order else return false
     * 
     */
    public boolean isFormNameSorted(final String order) {
        boolean flag = false;
        List<WebElement> list = WebDriverFactory.getWebDriver()
                                                .findElements(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr"));

        int size = list.size();
        String[] names = new String[size];
        String[] test = new String[size];

        for (int i = 1; i <= size; i++) {
            String a = WebDriverFactory.getWebDriver()
                                       .findElement(By.xpath(
                                               ".//*[@id='paymentFormsTable']//tbody//tr[" + i + "]//td[starts-with(@id,'payment-forms-form-name')]"))
                                       .getText()
                                       .toLowerCase();
            names[i - 1] = a;
            test[i - 1] = a;
        }

        if (order.equals("Asceding")) {
            Arrays.sort(test);
            ArrayUtils.reverse(test);
            if (Arrays.equals(names, test)) {
                flag = true;
            } else {
                flag = false;
            }
        } else if (order.equals("Dsceding")) {
            Arrays.sort(test);
            if (Arrays.equals(names, test)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;

    }

    /**
     * check payment forms list only contain 20 forms.
     * 
     * @return true is payment form list count is 20 false otherwise
     */
    public boolean isTwentyFormsDisplayed() {
        scrollToFirstForm();
        boolean flag = false;
        List<WebElement> list = WebDriverFactory.getWebDriver()
                                                .findElements(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr"));
        if (list.size() == PAYMENT_FORMS_LIST_SIZE) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * get reference no from first payment form url.
     * 
     * @return reference no from url
     */
    public String getRefrenceNoFromUrl() {
        referenceNo = paymentFormListElements.getFirstFormUrlConfirmation()
                                             .getText();
        String[] arr = referenceNo.split("/");
        return arr[GET_FORM_NAME_ARRAY_INDEX];
    }

    /**
     * get partner name from first payment form url.
     * 
     * @return partner name from first payment form url
     */
    public String getPartnerNameFromUrl() {
        partnerName = paymentFormListElements.getFirstFormUrlConfirmation()
                                             .getText();
        String[] arr = partnerName.split("/");
        return arr[GET_PARTNER_NAME_ARRAY_INDEX];
    }

    /**
     * get ID from first payment form url.
     * 
     * @return ID from first payment form url
     */
    public Object getIdFromUniqueURL() {
        id = paymentFormListElements.getFirstFormUrlConfirmation()
                                    .getText();
        String[] arr = id.split("/");
        return arr[GET_ID_ARRAY_INDEX];
    }

    /**
     * get text value from first form url.
     * 
     * @return text value from first form url
     */
    public String getUrlTextFromFirstForm() {
        scrollToFirstForm();
        return paymentFormListElements.getFirstFormUrlConfirmation()
                                      .getText();
    }

    /**
     * get form name from from first payment form name.
     * 
     * @return id from first payment form
     */
    public String getIdFromPaymentFormListPage() {
        scrollToFirstForm();
        return paymentFormListElements.getFirstFormIDConfirmation()
                                      .getText();
    }

    /**
     * get form name from first payment form.
     * 
     * @return form name from first payment form
     */
    public String getFormNameFromPaymentFormListPage() {
        scrollToFirstForm();
        return paymentFormListElements.getFirstFormNameConfirmation()
                                      .getText();
    }

    /**
     * click in id sort button.
     */
    public void clickOnIdSortButton() {
        webDriverCommons.click(paymentFormListElements.getIdSortingButton());

    }

    /**
     * click on form name sort button.
     */
    public void clickOnFormNameSortButton() {
        webDriverCommons.click(paymentFormListElements.getFormNameSortingButton());

    }

    /**
     * click on goto next page button.
     */
    public void clickOnNextPageButton() {

        webDriverCommons.click(paymentFormListElements.getGoToNextPageButton());

    }

    /**
     * click to goto previous page button.
     */
    public void clickOnPreviousPageButon() {
        webDriverCommons.click(paymentFormListElements.getGoToPriviousButton());

    }

    /**
     * click on goto page two button.
     */
    public void clickOnPageTwoButton() {

        webDriverCommons.click(paymentFormListElements.getGoToPageTwoButton());

    }

}
