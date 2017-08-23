package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author STA Development Team
 *
 */
public class LoginInterstitialPageElements extends PageElements {

    @FindBy(xpath = ".//i[@class='mysta-Icon-email']")
    private WebElement loginLink;

    /**
     * 
     * @return login link
     * 
     */
    public WebElement getLoginLink() {
        return loginLink;
    }

}
