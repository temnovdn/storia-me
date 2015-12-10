package me.storia.login;

import me.storia.StoriaTestInit;
import org.testng.annotations.Test;

/**
 * Created by dmitrytemnov on 08/12/15.
 */
@Test
public class StoriaMeLoginTests extends StoriaTestInit {

    /**
     * Tests login with username and password.
     */
    public void passwordUsernameLogin() {
        loginPage.facebookLogin();
    }

    /**
     * Tests login via Google+.
     **/
    public void googleLogin() {
        loginPage.googleLogin();
    }

    /**
     * Tests login via facebok.
     */
    public void facebookLogin() {
        loginPage.facebookLogin();
    }

    /**
     * Tests login via Vkontakte.
     */
    public void vkLogin() {
        loginPage.vkLogin();
    }
}
