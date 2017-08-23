package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class OthersPageElement extends PageElements {

    @FindBy(css = "#travel-info-others-title-1")
    private WebElement firstTitleInput;

    @FindBy(css = "#travel-info-others-title-2")
    private WebElement secondTitleInput;

    @FindBy(css = "#travel-info-others-details-1")
    private WebElement firstTripDetaisInput;

    @FindBy(css = "#travel-info-others-details-2")
    private WebElement secondTripDetaisInput;

    @FindBy(css = "#travel-info-others-delete-1")
    private WebElement firstDeleteButton;

    @FindBy(css = "#travel-info-others-delete-2")
    private WebElement secondDeleteButton;

    @FindBy(css = "#travel-info-others-details-warning-1")
    private WebElement tripDetaisRequreMessage;

    @FindBy(id = "travel-info-others-title-warning-1")
    private WebElement titleRequreMessage;

    /**
     * @return the firstTitle
     */
    public WebElement getFirstTitleInput() {
        return firstTitleInput;
    }

    /**
     * @return the secondTitle
     */
    public WebElement getSecondTitleInput() {
        return secondTitleInput;
    }

    /**
     * @return the firstTripDetais
     */
    public WebElement getFirstTripDetaisInput() {
        return firstTripDetaisInput;
    }

    /**
     * @return the secondTripDetais
     */
    public WebElement getSecondTripDetaisInput() {
        return secondTripDetaisInput;
    }

    /**
     * @return the firstDeleteButton
     */
    public WebElement getFirstDeleteButton() {
        return firstDeleteButton;
    }

    /**
     * @return the secondDeleteButton
     */
    public WebElement getSecondDeleteButton() {
        return secondDeleteButton;
    }

    /**
     * @return the tripDetaisRequreMessage
     */
    public WebElement getTripDetaisRequreMessage() {
        return tripDetaisRequreMessage;
    }

    /**
     * @return the titleRequreMessage
     */
    public WebElement getTitleRequreMessage() {
        return titleRequreMessage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OthersPageElement [firstTitleInput=" + firstTitleInput + ", secondTitleInput=" + secondTitleInput + ", firstTripDetaisInput="
                + firstTripDetaisInput + ", secondTripDetaisInput=" + secondTripDetaisInput + ", firstDeleteButton=" + firstDeleteButton
                + ", secondDeleteButton=" + secondDeleteButton + ", tripDetaisRequreMessage=" + tripDetaisRequreMessage + ", titleRequreMessage="
                + titleRequreMessage + "]";
    }

}
