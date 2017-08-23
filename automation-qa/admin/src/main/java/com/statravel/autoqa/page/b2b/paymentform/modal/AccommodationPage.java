package com.statravel.autoqa.page.b2b.paymentform.modal;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Accommodation;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class AccommodationPage extends Page<AccommodationPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private AccommodationPageElements accommodationPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {
        return webDriverCommons.isDisplayed(accommodationPageElements.getLightBox());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {
        accommodationPageElements = new AccommodationPageElements();

        super.initialiseElements(accommodationPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public AccommodationPageElements getPageElements() {

        return accommodationPageElements;
    }

    /**
     * Adds a accommodation on the screen.
     * 
     * @param accommodation
     *            accommodation object
     * 
     */
    public void fillAccommodationDetails(final Accommodation accommodation) {
        webDriverCommons.sendKeys(accommodationPageElements.getNameInput(), accommodation.getName());

        webDriverCommons.sendKeys(accommodationPageElements.getCityInput(), accommodation.getCity());

        webDriverCommons.sendKeys(accommodationPageElements.getAddressInput(), accommodation.getAddress());

        webDriverCommons.sendKeys(accommodationPageElements.getRoomsInput(), accommodation.getRooms());

        webDriverCommons.sendKeys(accommodationPageElements.getRoomTypeInput(), accommodation.getRoomsType());

        webDriverCommons.click(accommodationPageElements.getCheckInCalendarSelect());

        webDriverCommons.click(accommodationPageElements.getCheckInDateButton());

        webDriverCommons.selectFromDropdown(accommodationPageElements.getCheckInHourSelect(), accommodation.getCheckInHour());

        webDriverCommons.selectFromDropdown(accommodationPageElements.getCheckInMinuteSelect(), accommodation.getCheckInMinute());

        webDriverCommons.click(accommodationPageElements.getCheckOutCalendarSelect());

        webDriverCommons.click(accommodationPageElements.getCheckOutDateButton());

        webDriverCommons.selectFromDropdown(accommodationPageElements.getCheckOutHourSelect(), accommodation.getCheckOutHour());

        webDriverCommons.selectFromDropdown(accommodationPageElements.getCheckOutMinuteSelect(), accommodation.getCheckOutMinute());

        webDriverCommons.sendKeys(accommodationPageElements.getNightsInput(), accommodation.getNights());

        webDriverCommons.sendKeys(accommodationPageElements.getSpecialRemarkInput(), accommodation.getSpecialremark());

    }

    /**
     * Clicks on Save button.
     */
    public void saveDetails() {
        webDriverCommons.click(accommodationPageElements.getSaveButton());
    }

    /**
     * Clicks on Cancel button.
     */
    public void cancelDetails() {

        webDriverCommons.click(accommodationPageElements.getCancelButton());

        Alert cancelAlert = webDriverCommons.getAlertPopUp();

        cancelAlert.accept();

    }

}
