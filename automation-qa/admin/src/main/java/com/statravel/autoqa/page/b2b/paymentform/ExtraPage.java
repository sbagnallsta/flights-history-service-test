package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Extra;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class ExtraPage extends Page<ExtraPageElement> {

    @Autowired
    private WebDriverCommons webdriverCommons;

    private ExtraPageElement extrPageElement;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webdriverCommons.isDisplayed(extrPageElement.getFirstPriceInput());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        extrPageElement = new ExtraPageElement();
        super.initialiseElements(extrPageElement);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public ExtraPageElement getPageElements() {

        return extrPageElement;
    }

    /**
     * 
     * @param extra
     *            extra reference
     */
    public void fillDetailsForFirstExtra(final Extra extra) {

        webdriverCommons.sendKeys(extrPageElement.getFirstPriceInput(), extra.getPrice());

        webdriverCommons.sendKeys(extrPageElement.getFirstProductNameInput(), extra.getProductName());

        webdriverCommons.sendKeys(extrPageElement.getFirstProductInformatinInput(), extra.getProductInformation());
    }

    /**
     * 
     * @param extra
     *            extra reference
     */
    public void fillDetailsForSecondExtra(final Extra extra) {

        webdriverCommons.sendKeys(extrPageElement.getSecondPriceInput(), extra.getPrice());

        webdriverCommons.sendKeys(extrPageElement.getSecondProductNameInput(), extra.getProductName());

        webdriverCommons.sendKeys(extrPageElement.getSecondProductInformatinInput(), extra.getProductInformation());

    }

    /**
     * Delete First Extra.
     */
    public void deleteFirstExtra() {

        webdriverCommons.click(extrPageElement.getFirstExtrasDeleteButton());

        Alert deleteAlert = new WebDriverCommons().getAlertPopUp();

        deleteAlert.accept();
    }

    /**
     * Delete Second Extra.
     */
    public void deleteSecondExtra() {

        webdriverCommons.click(extrPageElement.getSecondExtrasDeleteButton());

        Alert deleteAlert = new WebDriverCommons().getAlertPopUp();

        deleteAlert.accept();
    }

    /**
     * Clear Price input field.
     */
    public void clearExtrasInputs() {

        webdriverCommons.clear(extrPageElement.getFirstPriceInput());

        webdriverCommons.clear(extrPageElement.getFirstProductInformatinInput());

        webdriverCommons.clear(extrPageElement.getFirstProductNameInput());

    }

}
