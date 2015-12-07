import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.slf4j.MDC;
import java.lang.reflect.Method;

/**
 * Created by dmitrytemnov on 07/12/15.
 */
public class StoriaTestInit {

    protected static WebDriver driver;

    protected final static Logger LOGGER = LoggerFactory.getLogger(StoriaTestInit.class);
    protected final static String DEFAULT_URL = "http://storia.me";

    @BeforeSuite
    @Parameters({"browser", "url"})
    public void initTest(@Optional final String browser, @Optional final String url) {
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
            // Repeat this code for any driver used.
        } else {
            //Log that no browser specified - will use Firefox as default.
            driver = new FirefoxDriver();
        }

        if (url.equals(null)) {
            //Log that url is not specified and http://storia.me will be used.
            driver.get(DEFAULT_URL);
        } else {
            driver.get(url);
        }
    }

    @BeforeMethod
    public void initMethod(Method method) {
        MDC.put("methodName", "[" + method.getDeclaringClass() + "#" + method.getName() + "]");
        LOGGER.info("Method {} started", method.getName());
    }

    @AfterMethod
    public void stopMethod(Method method, ITestResult iTestResult) {
        LOGGER.info("Method {} finished", method.getName());
        if (!iTestResult.isSuccess()) {
            LOGGER.error("Test {} failed! ", method.getName(), iTestResult.getThrowable());
        }
    }

    @AfterSuite
    public void endTest() {
        //Log "Test ended"
        driver.quit();
    }
}
