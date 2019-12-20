package drivers;

import io.appium.java_client.android.AndroidDriver;
import objects.Environment;
import test.BaseTest;
import utils.OsUtils;

import static objects.MSG.DRV_CLOSED;
import static utils.Log.sysLog;

/*
Functions to create local or cloud driver and terminate it
 */
public class DriverSetUp {

    public static AndroidDriver initDriver() {

        String environment = OsUtils.getRunType();
        AndroidDriver drv = null;

        if (environment.equals(Environment.local)) {
            drv = CreateDrv.createLocalDriver();
        }

        if (environment.equals(Environment.browserStack)) {
            drv = CreateDrv.createBSDriver();
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
