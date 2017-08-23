package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;
import com.statravel.autoqa.paymentformsui.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class ImportantInstructionsPage extends Page<ImportantInstructionsPageElements> {

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private ImportantInstructionsPageElements importantInstructionsPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(travelInformationPage.getPageElements()
                                                                 .getRefrenceNo());
    }

    /**
     * 
     */
    @Override
    public void init() {
        importantInstructionsPageElements = new ImportantInstructionsPageElements();
        super.initialiseElements(importantInstructionsPageElements);

    }

    /**
     * 
     */
    @Override
    public ImportantInstructionsPageElements getPageElements() {

        return importantInstructionsPageElements;
    }

}
