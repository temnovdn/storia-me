package me.storia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.slf4j.MDC;
import me.storia.pages.StoriaLoginPage;

import java.lang.reflect.Method;

/**
 * Created by dmitrytemnov on 07/12/15.
 */
public class StoriaTestInit {

    protected static WebDriver driver;
    protected static StoriaLoginPage loginPage;
    protected static String testUrl;

    protected final static Logger LOGGER = LoggerFactory.getLogger(StoriaTestInit.class);
    protected final static String DEFAULT_URL = "https://storia.me/log-in";

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
            LOGGER.info("Browser to use: {}", browser);
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
            // Repeat 2 lines of code above (with specific WebDriver) if you need additional drivers.
            LOGGER.info("Browser to use: {}", browser);
        } else {
            LOGGER.info("No browser specified - will use Firefox as default");
            driver = new FirefoxDriver();
        }

        // Getting URL
        if (url == null) {
            LOGGER.info("Url is not specified and {} will be used", DEFAULT_URL);
            testUrl = DEFAULT_URL;
        } else {
            testUrl = url;
        }
        // Initialization of page objects for login and home pages
        loginPage = PageFactory.initElements(driver, StoriaLoginPage.class);
    }

    @BeforeMethod
    public void initMethod(Method method) {
        driver.get(testUrl);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rootView")));
        // Just some log entries to separate one method from another
        MDC.put("methodName", "[" + method.getDeclaringClass() + "#" + method.getName() + "]");
        LOGGER.info("Method {} started", method.getName());
    }

    /**
     * Returns browser to start state.
     * @param method
     * @param iTestResult
     */
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
