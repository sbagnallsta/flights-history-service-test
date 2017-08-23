package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * @author STA Development Team
 *
 */
public class LoginPageElements extends PageElements {

    @FindBy(how = How.CSS, using = ".userNameInput")
    private WebElement usernameInput;

    @FindBy(how = How.CSS, using = ".userPasswordInput")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = ".loginBtn")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = ".forgotPassword")
    private WebElement resetPasswordLink;

    @FindBy(how = How.CSS, using = ".changePasswordLink")
    private WebElement changePasswordLink;

    @FindBy(how = How.CSS, using = "body")
    private WebElement pageBody;

    /**
     * @return the usernameInput
     */

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    /**
     * @return the passwordInput
     */
    public WebElement getPasswordInput() {
        return passwordInput;
    }

    /**
     * @return the loginButton
     */
    public WebElement getLoginButton() {
        return loginButton;
    }

    /**
     * @return the resetPasswordLink
     */
    public WebElement getResetPasswordLink() {
        return resetPasswordLink;
    }

    /**
     * @return the changePasswordLink
     */

    public WebElement getChangePasswordLink() {
        return changePasswordLink;
    }

    /**
     * @return the pageBody
     */

    public WebElement getPageBody() {
        return pageBody;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LoginPageElements [usernameInput=" + usernameInput + ", passwordInput=" + passwordInput + ", loginButton=" + loginButton
                + ", resetPasswordLink=" + resetPasswordLink + ", changePasswordLink=" + changePasswordLink + ", pageBody=" + pageBody + "]";
    }

}
