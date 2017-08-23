package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.TravelInformation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.paymentformsui.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class ImportantInstructionsPageElements extends PageElements {

    @FindBy(css = "#inportant-instruccions-heading")
    private WebElement importantInstructionHeading;

    @FindBy(css = "#inportant-instruccions-text-1")
    private WebElement importantInstructionMessage;

    /**
     * @return the importantInstructionHeading
     */
    public WebElement getImportantInstructionHeading() {
        return importantInstructionHeading;
    }

    /**
     * @return the importantInstructionMessage
     */
    public WebElement getImportantInstructionMessage() {
        return importantInstructionMessage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ImportantINstructionsPageElements [importantInstructionHeading=" + importantInstructionHeading + ", importantInstructionMessage="
                + importantInstructionMessage + "]";
    }

}
