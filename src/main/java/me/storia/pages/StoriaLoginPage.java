package me.storia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for login page.
 */
public class StoriaLoginPage {

    @FindBy(className = "logo")
    private WebElement logoButton;

    @FindBy(css = "#rootView > div > div.mod-SignIn.with-bg.ui-popup > div"
            + " > div.ui-wrapper > div > div.Join-container > div.Join-social-form > form > div.sui-button--social.gp")
    private WebElement googleLoginButton;

    @FindBy(css = "#rootView > div > div.mod-SignIn.with-bg.ui-popup > div"
            + " > div.ui-wrapper > div > div.Join-container > div.Join-social-form > form > div.sui-button--social.fb")
    private WebElement facebookLoginButton;

    @FindBy(css = "div.sui-form--line:nth-child(2) > input:nth-child(1)")
    private WebElement emailField;

    @FindBy(css = "div.sui-form--line:nth-child(3) > input:nth-child(1)")
    private WebElement passwordField;

    @FindBy(css = ".sui-button")
    private WebElement loginButton;

    @FindBy(css = "div.tab:nth-child(1) > a:nth-child(2)")
    private WebElement registrationLink;

    @FindBy(linkText = "forgot")
    private WebElement forgottenPassword;

    public void googleLogin() {
        googleLoginButton.click();
    }

    public void facebookLogin() {
        facebookLoginButton.click();
    }

    public void usernameAndPasswordLogin(final String username, final String password) {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void forgottenPasswordLinkClick() {
        forgottenPassword.click();
    }

    public void clickRegistrationLink() {
        registrationLink.click();
    }
}
