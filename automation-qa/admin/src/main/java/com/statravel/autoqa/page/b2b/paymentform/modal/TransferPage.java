package com.statravel.autoqa.page.b2b.paymentform.modal;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Transfer;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class TransferPage extends Page<TransferPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private TransferPageElements transferPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        transferPageElements = new TransferPageElements();

        super.initialiseElements(transferPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(transferPageElements.getLightbox());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public TransferPageElements getPageElements() {

        return transferPageElements;
    }

    /**
     * Adds a transfer on the screen.
     * 
     * @param transfer
     *            transfer object
     * 
     */
    public void fillTransferDetails(final Transfer transfer) {

        webDriverCommons.sendKeys(transferPageElements.getNameInput(), transfer.getName());
        webDriverCommons.sendKeys(transferPageElements.getRouteInput(), transfer.getRoute());
        webDriverCommons.click(transferPageElements.getDepartureDateInput());
        webDriverCommons.click(transferPageElements.getDepartureDayButton());
        webDriverCommons.selectFromDropdown(transferPageElements.getDepartureHoursSelect(), transfer.getDepartureHour());
        webDriverCommons.selectFromDropdown(transferPageElements.getDepartureMinutesSelect(), transfer.getDepartureMinute());
        webDriverCommons.sendKeys(transferPageElements.getSpecialRemarkInput(), transfer.getSpecialRemarks());
    }

    /**
     * Clicks on Save button.
     */
    public void saveDetails() {
        webDriverCommons.click(transferPageElements.getSaveButton());

    }

    /**
     * Clicks on Cancel button.
     */
    public void cancelDetails() {

        webDriverCommons.click(transferPageElements.getCancelButton());

        Alert cancelAlert = webDriverCommons.getAlertPopUp();

        cancelAlert.accept();

    }

}
