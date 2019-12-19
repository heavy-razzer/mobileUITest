package drivers;

import io.appium.java_client.AppiumDriver;
import objects.Environment;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;
import utils.OsUtils;

import static objects.MSG.DRV_CLOSED;
import static utils.Log.sysLog;

public class DriverSetUp {

    public static WebDriverWait wait;

    public static AppiumDriver initDriver() {

        String environment = OsUtils.getRunType();
        AppiumDriver drv = null;

        if (environment.equals(Environment.local)) {
            drv = CreateDrv.createLocalDriver();
        }

        if (environment.equals(Environment.browserStack)) {
            drv = CreateDrv.createBSDriver();
        }

        if (drv != null) {
            wait = new WebDriverWait(drv, 10);
        }
        return drv;
    }

    public static void quitDriver() {

        if (BaseTest.driver != null) {
            BaseTest.driver.quit();
            sysLog(DRV_CLOSED);
        }
    }
}
