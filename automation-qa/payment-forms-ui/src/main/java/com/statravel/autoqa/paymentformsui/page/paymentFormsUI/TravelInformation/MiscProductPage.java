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
public class MiscProductPage extends Page<MiscProductPageElement> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private TravelInformationPage travelInformationPage;

    private MiscProductPageElement miscProductPageElement;

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
        miscProductPageElement = new MiscProductPageElement();
        super.initialiseElements(miscProductPageElement);

    }

    /**
     * 
     */
    @Override
    public MiscProductPageElement getPageElements() {

        return miscProductPageElement;
    }

    /**
     * Select first misc product check box.
     */
    public void selectFirstMiscProductTickBox() {
        webDriverCommons.click(miscProductPageElement.getFirstMiscProductCheckBox());

    }

    /**
     * Select second misc product check box.
     */
    public void selectSecondMiscProductTickBox() {
        webDriverCommons.click(miscProductPageElement.getSecondMiscProductCheckBox());

    }

    /**
     * 
     * @return true if first misc product is highlighted otherwise return false.
     */
    public boolean isFirstMiscProductOptionHighlighted() {

        return webDriverCommons.isDisplayed(miscProductPageElement.getFirstHighlightedMiscProduct());
    }

    /**
     * 
     * @return true if second misc product is highlighted otherwise return false.
     */
    public boolean isSecondMiscProductOptionHighlighted() {

        return webDriverCommons.isDisplayed(miscProductPageElement.getSecondHighlightedMiscProduct());
    }

}
