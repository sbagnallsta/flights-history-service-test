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
public class LoginInterstitialPage extends Page<LoginInterstitialPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private LoginInterstitialPageElements loginInterstitialPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        loginInterstitialPageElements = new LoginInterstitialPageElements();

        super.initialiseElements(loginInterstitialPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public LoginInterstitialPageElements getPageElements() {

        return loginInterstitialPageElements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(loginInterstitialPageElements.getLoginLink());

    }
}