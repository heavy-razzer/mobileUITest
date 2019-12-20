package test;

import drivers.DriverSetUp;
import helpers.RetryRule;
import helpers.TestWatchers;
import io.appium.java_client.android.AndroidDriver;
import objects.Environment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriverException;
import screens.*;

import static drivers.AppiumServer.closeAppiumServer;
import static drivers.AppiumServer.startAppiumServer;
import static objects.Environment.browserStack;
import static utils.OsUtils.getRunType;

/*
Basic test setup: driver and pages management
 */
public class BaseTest {

    // Set main driver
    public static AndroidDriver driver = null;

    // System process with appium server
    private static Process appium_Process;

    // How many times should we rerun failed test. 0 - never, 1 - try once after test failed
    public static int retryCount;

    // Additional actions after test finished
    @Rule
    public TestWatchers basicRules = new TestWatchers();

    // Rule to relaunch test if it was failed by defined reasons
    @Rule
    public RetryRule retryRule = new RetryRule(WebDriverException.class, AssertionError.class);

    protected LoginPage loginPage;
    protected ConfirmDialog confirmDialog;
    protected VerificationPage verificationPage;
    protected EmailPage emailPage;
    protected ConfirmOnboardingPage confirmOnboardingPage;
    protected HomePage homePage;
    protected EnableLocationPage enableLocationPage;
    protected ProfilePage profilePage;

    public BaseTest() {

        loginPage = new LoginPage();
        confirmDialog = new ConfirmDialog();
        verificationPage = new VerificationPage();
        emailPage = new EmailPage();
        confirmOnboardingPage = new ConfirmOnboardingPage();
        homePage = new HomePage();
        enableLocationPage = new EnableLocationPage();
        profilePage = new ProfilePage();
    }

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
