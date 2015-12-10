package me.storia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for login page.
 */
public class StoriaLoginPage {

    @FindBy(className = "sui-button--social gp")
    private WebElement googleLoginButton;

    @FindBy(name = "sui-button--social fb")
    private WebElement facebookLoginButton;

    @FindBy(className = "sui-button--social vk")
    private WebElement vkLoginButton;

    @FindBy(xpath = "html/body/div/div[10]/div/div[2]/div/div[2]/form/div[2]/input")
    private WebElement emailField;

    @FindBy(xpath = "html/body/div/div[10]/div/div[2]/div/div[2]/form/div[3]/input")
    private WebElement passwordField;

    @FindBy(xpath = "html/body/div/div[10]/div/div[2]/div/div[2]/form/button")
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
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
