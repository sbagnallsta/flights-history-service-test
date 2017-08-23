package com.statravel.autoqa.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class LoginPage extends Page<LoginPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private LoginPageElements loginPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        loginPageElements = new LoginPageElements();

        super.initialiseElements(loginPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public LoginPageElements getPageElements() {

        return loginPageElements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(loginPageElements.getLoginButton());

    }

    /**
     * Logs in.
     * 
     * @param username
     *            username
     * @param password
     *            password
     */
    public void login(final String username, final String password) {
        webDriverCommons.sendKeys(loginPageElements.getUsernameInput(), username);
        loginPageElements.getPasswordInput().sendKeys(password);
        webDriverCommons.click(loginPageElements.getLoginButton());
    }

}
