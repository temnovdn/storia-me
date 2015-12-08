package me.storia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmitrytemnov on 08/12/15.
 */
public class StoriaLoginPage {

    @FindBy(name = "google")
    private WebElement googleLoginButton;

    @FindBy(name = "facebook")
    private WebElement facebookLoginButton;

    @FindBy(name = "vk")
    private WebElement vkLoginButton;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    private WebDriver driver;

    public StoriaLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void googleLogin() {
        googleLoginButton.click();
    }

    public void facebookLogin() {
        facebookLoginButton.click();
    }

    public void vkLogin() {
        vkLoginButton.click();
    }

    public void usernameAndPasswordLogin(final String username, final String password) {
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
