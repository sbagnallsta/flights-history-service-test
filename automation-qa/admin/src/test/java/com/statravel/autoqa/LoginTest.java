package com.statravel.autoqa;

import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_NAME;
import static com.statravel.autoqa.commons.AutomationConstants.ADMIN_PASSWORD;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.commons.AssertionMessages;
import com.statravel.autoqa.page.HomePage;
import com.statravel.autoqa.page.LoginPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class LoginTest {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    /**
     * 
     */
    @Before
    public void init() {

        loginPage.init();
        homePage.init();

    }

    /**
     * 
     */
    @Given("^I am on the login page$")
    public void loadLoginPage() {

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_LOGIN, loginPage.isPageLoaded());
    }

    /**
     * 
     */
    @When("^I log in$")
    public void logIn() {

        loginPage.login(ADMIN_NAME, ADMIN_PASSWORD);
    }

    /**
     * 
     */
    @Then("^I should be redirected to the home page$")
    public void redirectToHomePage() {

        Assert.assertTrue(AssertionMessages.PAGE_NOT_LOADED_HOME, homePage.isPageLoaded());
        Assert.assertTrue("Login Failed", homePage.getPageElements()
                                                  .getSignInName()
                                                  .getText()
                                                  .contains("SHOHIL BAGDAI"));
    }

}
