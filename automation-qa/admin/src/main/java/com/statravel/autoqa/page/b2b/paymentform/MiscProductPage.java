package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.MiscProduct;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class MiscProductPage extends Page<MiscProductPageElement> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private MiscProductPageElement miscProductPageElement;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(miscProductPageElement.getFirstPriceInput());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {
        miscProductPageElement = new MiscProductPageElement();
        super.initialiseElements(miscProductPageElement);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public MiscProductPageElement getPageElements() {

        return miscProductPageElement;
    }

    /**
     * 
     * @param miscProduct
     *            misc product reference
     */
    public void fillDetailsForFirstMiscProduct(final MiscProduct miscProduct) {

        webDriverCommons.sendKeys(miscProductPageElement.getFirstPriceInput(), miscProduct.getPrice());

        webDriverCommons.sendKeys(miscProductPageElement.getFirstNameInput(), miscProduct.getProductName());

        webDriverCommons.sendKeys(miscProductPageElement.getFirstInformationInput(), miscProduct.getProductInforamtion());
    }

    /**
     * 
     * @param miscProduct
     *            Misc product reference
     */
    public void fillDetailsForSecondMiscProduct(final MiscProduct miscProduct) {

        webDriverCommons.sendKeys(miscProductPageElement.getSecondPriceInput(), miscProduct.getPrice());

        webDriverCommons.sendKeys(miscProductPageElement.getSecondNameInput(), miscProduct.getProductName());

        webDriverCommons.sendKeys(miscProductPageElement.getSecondInformationInput(), miscProduct.getProductInforamtion());
    }

    /**
     * Delete First Misc Product.
     */
    public void deleteFirstMiscProduct() {
        webDriverCommons.click(miscProductPageElement.getFirstDeleteButton());

        Alert deleteAlert = new WebDriverCommons().getAlertPopUp();

        deleteAlert.accept();

    }

    /**
     * Delete Second MIsc Product.
     */
    public void deleteSecondMiscProduct() {
        webDriverCommons.click(miscProductPageElement.getSecondDeleteButton());

        Alert deleteAlert = new WebDriverCommons().getAlertPopUp();

        deleteAlert.accept();
    }

}
