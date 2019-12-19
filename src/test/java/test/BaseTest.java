package test;

import drivers.DriverSetUp;
import helpers.RetryRule;
import helpers.TestWatchers;
import io.appium.java_client.AppiumDriver;
import objects.Environment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriverException;

import static drivers.AppiumServer.closeAppiumServer;
import static drivers.AppiumServer.startAppiumServer;
import static objects.Environment.browserStack;
import static utils.OsUtils.getRunType;

public class BaseTest {

    // Set main driver
    public static AppiumDriver driver = null;

    // System process with appium server
    public static Process appium_Process;

    // How many times should we rerun failed test. 0 - never, 1 - try once after test failed
    public static int retryCount;

    // Additional actions after test finished
    @Rule
    public TestWatchers basicRules = new TestWatchers();

    // Rule to relauch test if it was failed by defined reasons
    @Rule
    public RetryRule retryRule = new RetryRule(WebDriverException.class, AssertionError.class);

    // Actions before test class
    @BeforeClass
    public static void beforeClass() {

        if (getRunType().equals(Environment.local)) {
            appium_Process = startAppiumServer(4723);
        }

        if (getRunType().equals(browserStack)) {
            retryCount = 1;
        } else {
            retryCount = 0;
        }

        driver = DriverSetUp.initDriver();
    }

    // Actions after test class
    @AfterClass
    public static void afterClass() {
        DriverSetUp.quitDriver();

        if (getRunType().equals(Environment.local)) {
            closeAppiumServer(appium_Process);
        }
        System.out.println("\n");
    }
}