package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author STA Development Team
 *
 */
public class LoginConfirmationPageElements extends PageElements {

    @FindBy(css = ".mysta-Button.mysta-Button--full.js-emailLookupButton")
    private WebElement continueButton;

    @FindBy(xpath = ".//button[@class='mysta-Button mysta-Button--full']")
    private WebElement signInButton;

    @FindBy(css = "#Email")
    private WebElement emailInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    /**
     * 
     * @return continue button
     */
    public WebElement getContinueButton() {
        return continueButton;
    }

    /**
     * 
     * @return email input
     */
    public WebElement getEmailInput() {
        return emailInput;
    }

    /**
     * 
     * @return password input
     */
    public WebElement getPasswordInput() {
        return passwordInput;
    }

    /**
     * 
     * @return sing in button
     */
    public WebElement getSignInButton() {
        return signInButton;
    }
}
