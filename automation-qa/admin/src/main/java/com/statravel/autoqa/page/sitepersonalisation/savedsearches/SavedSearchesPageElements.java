package com.statravel.autoqa.page.sitepersonalisation.savedsearches;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class SavedSearchesPageElements extends PageElements {
    @FindBy(css = "#saved-searches-number-of-searches-title")
    private WebElement numberSearchesTitle;

    @FindBy(css = "#saved-searches-number-of-searches")
    private WebElement numberSearches;

    @FindBy(css = "#saved-searches-number-of-searches-required")
    private WebElement numberOfSearchesRequireMessage;

    @FindBy(xpath = "//span[@id='saved-searches-number-of-searches-required'and@class='error paymentFormWarning ng-hide']")
    private WebElement numberOfSearchesRequireMessageHide;

    @FindBy(css = "#saved-searches-delete-save")
    private WebElement saveButton;

    @FindBy(css = "#saved-searches-flight-toggle-inactive")
    private WebElement savedSearchesFlightInactive;

    @FindBy(css = "#saved-searches-flight-toggle-active")
    private WebElement savedSearchesFlightActive;

    @FindBy(css = "#saved-searches-delete-button")
    private WebElement deleteButton;

    /**
     * @return the numberSearchesTitle
     */
    public WebElement getNumberSearchesTitle() {
        return numberSearchesTitle;
    }

    /**
     * @return the numberSearches
     */
    public WebElement getNumberSearches() {
        return numberSearches;
    }

    /**
     * @return the numberOfSearchesRequireMessage
     */
    public WebElement getNumberOfSearchesRequireMessage() {
        return numberOfSearchesRequireMessage;
    }

    /**
     * @return the numberOfSearchesRequireMessageHide
     */
    public WebElement getNumberOfSearchesRequireMessageHide() {
        return numberOfSearchesRequireMessageHide;
    }

    /**
     * @return the saveButton
     */
    public WebElement getSaveButton() {
        return saveButton;
    }

    /**
     * @return the savedSearchesFlightInactive
     */
    public WebElement getSavedSearchesFlightInactive() {
        return savedSearchesFlightInactive;
    }

    /**
     * @return the savedSearchesFlightActive
     */
    public WebElement getSavedSearchesFlightActive() {
        return savedSearchesFlightActive;
    }

    /**
     * @return the deleteButton
     */
    public WebElement getDeleteButton() {
        return deleteButton;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SavedSearchesPageElements [numberSearchesTitle=" + numberSearchesTitle + ", numberSearches=" + numberSearches
                + ", numberOfSearchesRequireMessage=" + numberOfSearchesRequireMessage + ", numberOfSearchesRequireMessageHide="
                + numberOfSearchesRequireMessageHide + ", saveButton=" + saveButton + ", savedSearchesFlightInactive=" + savedSearchesFlightInactive
                + ", savedSearchesFlightActive=" + savedSearchesFlightActive + ", deleteButton=" + deleteButton + "]";
    }

}
