package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.CancellationFee;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class CancellationFeePage extends Page<CancellationFeePageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private CancellationFeePageElements cancellationFeePageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(cancellationFeePageElements.getFirstDeleteButton());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        cancellationFeePageElements = new CancellationFeePageElements();

        super.initialiseElements(cancellationFeePageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public CancellationFeePageElements getPageElements() {

        return cancellationFeePageElements;
    }

    /**
     * 
     * @param cancellationFee
     *            cancelltionFees reference
     */
    public void fillDetailsForFirstCancellationFees(final CancellationFee cancellationFee) {

        webDriverCommons.sendKeys(cancellationFeePageElements.getFirstTypeInput(), cancellationFee.getType());

        webDriverCommons.sendKeys(cancellationFeePageElements.getFirstDueDateInput(), cancellationFee.getDueDate());

        webDriverCommons.sendKeys(cancellationFeePageElements.getFirstPenaltyInput(), cancellationFee.getPenalty());

    }

    /**
     * 
     * @param cancellationFee
     *            cancelltionFees reference
     */
    public void fillDetailsForSecondCancelltionFees(final CancellationFee cancellationFee) {

        webDriverCommons.sendKeys(cancellationFeePageElements.getSecondTypeInput(), cancellationFee.getType());

        webDriverCommons.sendKeys(cancellationFeePageElements.getSecondDueDateInput(), cancellationFee.getDueDate());

        webDriverCommons.sendKeys(cancellationFeePageElements.getSecondPanaltyInput(), cancellationFee.getPenalty());

    }

    /**
     * Delete first Cancellation Fees.
     */
    public void deleteFirstCancellationFees() {
        webDriverCommons.click(cancellationFeePageElements.getFirstDeleteButton());

        Alert deleteAlert = webDriverCommons.getAlertPopUp();

        deleteAlert.accept();
    }

}
