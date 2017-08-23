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
public class FinalDepositAndFinalPaymentDatePage extends Page<FinalDepositAndFinalPaymentDatePageElements> {

    @Autowired
    private TravelInformationPage travelInformationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    private FinalDepositAndFinalPaymentDatePageElements finalDepositAndFinalPaymentDatePageElements;

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

        finalDepositAndFinalPaymentDatePageElements = new FinalDepositAndFinalPaymentDatePageElements();
        super.initialiseElements(finalDepositAndFinalPaymentDatePageElements);
    }

    /**
     * 
     */
    @Override
    public FinalDepositAndFinalPaymentDatePageElements getPageElements() {

        return finalDepositAndFinalPaymentDatePageElements;
    }

}
