package me.storia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.slf4j.MDC;
import me.storia.pages.StoriaHomePage;
import me.storia.pages.StoriaLoginPage;

import java.lang.reflect.Method;

/**
 * Created by dmitrytemnov on 07/12/15.
 */
public class StoriaTestInit {

    protected static WebDriver driver;
    protected static StoriaLoginPage loginPage;
    protected static StoriaHomePage homePage;

    protected final static Logger LOGGER = LoggerFactory.getLogger(StoriaTestInit.class);
    protected final static String DEFAULT_URL = "http://storia.me";

    /**
     * This is the method to initialize test run on application, located at url (defined in test xml,
     * via defined in xml browser. If browser or url is not defined - Firefox and http://storia.me will be used.
     * @param browser
     * @param url
     */
    @BeforeSuite
    @Parameters({"browser", "url"})
    public void initTest(@Optional final String browser, @Optional final String url) {
        // Initialization of WebDriver
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
            // Repeat 2 lines of code above (with specific WebDriver) if you need additional drivers.
        } else {
            LOGGER.info("No browser specified - will use Firefox as default");
            driver = new FirefoxDriver();
        }

        // Getting URL
        if (url == null) {
            LOGGER.info("Url is not specified and http://storia.me will be used");
            driver.get(DEFAULT_URL);
        } else {
            driver.get(url);
        }

        // Initialization of page objects for login and home pages
        loginPage = PageFactory.initElements(driver, StoriaLoginPage.class);
        homePage = PageFactory.initElements(driver, StoriaHomePage.class);
    }

    @BeforeMethod
    public void initMethod(Method method) {
        // Just some log entries to separate one method from another
        MDC.put("methodName", "[" + method.getDeclaringClass() + "#" + method.getName() + "]");
        LOGGER.info("Method {} started", method.getName());
    }

    @AfterMethod
    public void stopMethod(Method method, ITestResult iTestResult) {
        // Just some log entries to separate one method from another
        LOGGER.info("Method {} finished", method.getName());
        if (!iTestResult.isSuccess()) {
            LOGGER.error("Test {} failed! ", method.getName(), iTestResult.getThrowable());
        }
    }

    /**
     * Closes the browser after suite run.
     */
    @AfterSuite
    public void endTest() {
        LOGGER.info("Test completed");
        driver.quit();
    }
}
