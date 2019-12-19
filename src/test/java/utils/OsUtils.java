package utils;

import objects.Device;
import objects.Environment;
import objects.MSG;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.Log.sysLog;

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
}
