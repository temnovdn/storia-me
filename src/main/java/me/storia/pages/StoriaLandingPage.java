package me.storia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmitrytemnov on 10/12/15.
 */
public class StoriaLandingPage {

    @FindBy(className = "span data-reactid")
    private WebElement googleLoginButton;

    @FindBy(className = "sui-button--social fb")
    private WebElement facebookLoginButton;

    @FindBy(className = "sui-button--social vk")
    private WebElement emailLoginButton;

    @FindBy(className = "sui-button--social email")
    private WebElement emailField;

    @FindBy(className = "")
    private WebElement passwordField;

    @FindBy(xpath = "html/body/div/div[10]/div/div[2]/div/div[2]/form/button")
    private WebElement loginButton;

    private WebDriver driver;

    public StoriaLandingPage(WebDriver driver) {
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
        emailLoginButton.click();
    }

    public void usernameAndPasswordLogin(final String username, final String password) {
        emailField.click();
        emailField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
