package utils;

import io.appium.java_client.android.AndroidKeyCode;
import objects.Device;
import objects.Environment;
import objects.MSG;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static test.BaseTest.driver;
import static utils.Log.sysLog;

/*
Various functions to work with environment properties and command line keys
 */
public class OsUtils {

    private static String OS = null;
    private static String envType = null;
    private static Device device = null;

    private static String getOsName() {

        if (OS == null) {
            OS = System.getProperty("os.name").toLowerCase();
            sysLog(MSG.RUNNING_ON, OS);
        }
        return OS;
    }

    public static boolean isMAC() {
        return getOsName().contains("mac");
    }

    public static boolean isLinux() {
        return getOsName().contains("linux");
    }

    public static boolean isWindows() {
        return getOsName().contains("windows");
    }

    // Get parameter: on which platform (local or cloud) to run tests
    public static String getRunType() {

        if (envType == null) {
            envType = Environment.local;
            String envTypeValue;
            envTypeValue = System.getProperty("env");

            if (envTypeValue != null) {

                if (envTypeValue.equals("browserstack")) {
                    envType = Environment.browserStack;
                }
            }
            sysLog(envType);
        }
        return envType;
    }

    // Get parameter: on which mobile platform should we run tests
    public static Device getDevice() {

        if (device == null) {
            device = new Device();
            String mobileDeviceValue = System.getProperty("device");
            if (mobileDeviceValue != null) {
                device.setDefaultValuesForDevice(mobileDeviceValue);
            } else {
                device.setDefaultValuesForDevice("android");
            }
            return device;
        } else {
            return device;
        }
    }

    public static String timeStamp(String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        Date newDate = new Date();
        return dateFormat.format(newDate);
    }

    public static String getSMSCodeFromNotification() {

        String result;

        // Open notification panel
        driver.openNotifications();

        // Locator for message text
        By by = By.id("android:id/message_text");

        try {
            // Wait until message tile appears on Notification panel
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(webDriver -> driver.findElements(by).size() > 0);
            result = driver.findElement(by).getText().split(":")[1].trim();
        } catch (TimeoutException | NoSuchElementException ex) {
            result = null;
        }

        // Close Notification panel with Back key
        driver.pressKeyCode(AndroidKeyCode.BACK);
        return result;
    }
}
