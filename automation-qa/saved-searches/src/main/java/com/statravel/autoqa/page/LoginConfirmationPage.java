package com.statravel.autoqa.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.User;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class LoginConfirmationPage extends Page<LoginConfirmationPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private LoginConfirmationPageElements loginConfirmationPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        loginConfirmationPageElements = new LoginConfirmationPageElements();

        super.initialiseElements(loginConfirmationPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public LoginConfirmationPageElements getPageElements() {

        return loginConfirmationPageElements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(loginConfirmationPageElements.getContinueButton());

    }

    /**
     * 
     * @param user
     *            the user to login
     * @throws InterruptedException
     *             InterruptedException
     */
    public void login(final User user) throws InterruptedException {

        webDriverCommons.sendKeys(loginConfirmationPageElements.getEmailInput(), user.getUsername());

        webDriverCommons.click(loginConfirmationPageElements.getContinueButton());

        webDriverCommons.sendKeys(loginConfirmationPageElements.getPasswordInput(), user.getPassword());

        webDriverCommons.click(loginConfirmationPageElements.getSignInButton());

        webDriverCommons.sleep(5);

    }

}