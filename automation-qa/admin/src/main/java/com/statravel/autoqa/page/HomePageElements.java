package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * @author STA Development Team
 *
 */
public class HomePageElements extends PageElements {

    @FindBy(how = How.CSS, using = ".logOut")
    private WebElement logoutLink;

    @FindBy(how = How.CSS, using = ".userBox>p")
    private WebElement signInNameText;

    @FindBy(css = ".chosen-single")
    private WebElement posSelect;

    @FindBy(css = "#paymentFormId")
    private WebElement paymentFormMenuItem;

    @FindBy(css = ".chosen-search > input")
    private WebElement countryInput;

    @FindBy(css = "#returnedFormId")
    private WebElement returnFormsMenuItem;

    @FindBy(xpath = "//span[contains(text(),'SAVED SEARCHES')]")
    private WebElement savedSearchesMenuItem;

    /**
     * @return the signInNameText
     */
    public WebElement getSignInNameText() {
        return signInNameText;
    }

    /**
     * @return the countryInput
     */
    public WebElement getCountryInput() {
        return countryInput;
    }

    /**
     * @return the logoutLink
     */
    public WebElement getLogoutLink() {
        return logoutLink;
    }

    /**
     * @return the posSelect
     */
    public WebElement getPosSelect() {
        return posSelect;
    }

    /**
     * @return the paymentFormMenuItem
     */
    public WebElement getPaymentFormMenuItem() {
        return paymentFormMenuItem;
    }

    /**
     * @return the returnFormsMenuItem
     */
    public WebElement getReturnFormsMenuItem() {
        return returnFormsMenuItem;
    }

    /**
     * @return the signInName
     */
    public WebElement getSignInName() {
        return signInNameText;
    }

    /**
     * @return the savedSearchesMenuItem.
     */
    public WebElement getSavedSearchesMenuItem() {
        return savedSearchesMenuItem;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HomePageElements [logoutLink=" + logoutLink + ", signInNameText=" + signInNameText + ", posSelect=" + posSelect
                + ", paymentFormMenuItem=" + paymentFormMenuItem + ", countryInput=" + countryInput + ", returnFormsMenuItem=" + returnFormsMenuItem
                + ", savedSearchesMenuItem=" + savedSearchesMenuItem + "]";
    }

}
