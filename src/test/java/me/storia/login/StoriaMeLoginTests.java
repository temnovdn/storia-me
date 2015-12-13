package me.storia.login;

import me.storia.StoriaTestInit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by dmitrytemnov on 08/12/15.
 */
@Test
public class StoriaMeLoginTests extends StoriaTestInit {

    /**
     * Tests login with username and password.
     */
    public void passwordUsernameLogin() {
        String username = "<test username>";
        String password = "<test password>";
        String expectedTitle = "Storia. Capture life with the people you love";

        loginPage.usernameAndPasswordLogin(username, password);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String titleString = driver.getTitle();
        Assert.assertEquals(titleString, expectedTitle);
    }

    /**
     * Tests login attempt with invalid email/password
     */
    public void invalidUsernameAndPassword() {

    }

    /**
     * Tests that pressing Google+ login button reveals Google+ popup.
     **/
    public void googleLogin() {
        final String expectedPopUpTitle = "Sign in - Google Accounts";
        String actualPopupTitle = "";
        final String mainWindowHandle = driver.getWindowHandle();

        loginPage.googleLogin();

        Set windowHandles = driver.getWindowHandles();
        Iterator handlesIterator = windowHandles.iterator();

        while(handlesIterator.hasNext())
        {
            String popupHandle = handlesIterator.next().toString();
            if(!popupHandle.contains(mainWindowHandle))
            {
                driver.switchTo().window(popupHandle);
                actualPopupTitle = driver.getTitle();
                driver.close();
                driver.switchTo().window(mainWindowHandle);
            }
        }
        Assert.assertEquals(actualPopupTitle, expectedPopUpTitle);
    }

    /**
     * Tests that facebook login button opens facebook login popup.
     */
    public void facebookLogin() {
        boolean isFacebook = false;
        final String mainWindowHandle = driver.getWindowHandle();

        loginPage.facebookLogin();

        Set windowHandles = driver.getWindowHandles();
        Iterator handlesIterator = windowHandles.iterator();

        while(handlesIterator.hasNext())
        {
            String popupHandle = handlesIterator.next().toString();
            if(!popupHandle.contains(mainWindowHandle))
            {
                driver.switchTo().window(popupHandle);
                isFacebook = driver.getPageSource().contains("facebook");
                driver.close();
                driver.switchTo().window(mainWindowHandle);
            }
        }
        Assert.assertTrue(isFacebook);
    }

    /**
     * Tests that registration button redirects to sign-up page.
     */
    public void registrationButtonRedirects() {
        final String expectedTitle = "Storia. Sign Up.";
        loginPage.clickRegistrationLink();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String titleString = driver.getTitle();
        Assert.assertEquals(titleString, expectedTitle);
    }

    /**
     * Tests that Storia button in header redirects to landing page.
     */
    public void headerButtonRedirect() {

    }

    /**
     * Tests that "forgot" link redirects to forgotten password recovery page.
     */
    public void forgottenLinkRedirection() {

    }
}
