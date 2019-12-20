package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import objects.Device;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.EnvironmentProperties;
import utils.OsUtils;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static objects.MSG.*;
import static utils.Log.errLog;
import static utils.Log.sysLog;

/*
Functions to create Appium drivers
 */
class CreateDrv {

    // Create Appium driver on local machine
    static AndroidDriver createLocalDriver() {

        AndroidDriver localDriver = null;

        //. Get device parameters
        Device device = OsUtils.getDevice();

        // Set driver capabilies
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, device.getOSname());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, device.getDeviceName());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                new DecimalFormat("0.#").format(Double.parseDouble(device.getOSVersion())));
        caps.setCapability("appPackage", "io.voiapp.voi");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");

        // Try to create driver
        try {
            sysLog(CREATING_LOCAL_DRV);
            String baseURL = "http://0.0.0.0:";
            String minorURL = "/wd/hub";
            String port = "4723";
            localDriver = new AndroidDriver(new URL(baseURL + port + minorURL), caps);
            localDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            sysLog(LOCAL_DRV_CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errLog(ERR_CREATING_LOCAL_DRV);
        }
        return localDriver;
    }

    // Create remote driver on BrowserStack cloud paltform
    static AndroidDriver createBSDriver() {

        String USERNAME;
        String AUTOMATE_KEY;
        String SERVER;

        // Get credentials from Allure properties
        EnvironmentProperties environmentProperties = new EnvironmentProperties();
        USERNAME = environmentProperties.getBrowserStackUserName();
        AUTOMATE_KEY = environmentProperties.getBrowserStackUserPsw();
        SERVER = environmentProperties.getBSserver();

        // Set URL to BS platform
        String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@" + SERVER;

        AndroidDriver cloudDriver = null;

        // Set driver capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        Device device = OsUtils.getDevice();
        caps.setCapability("os_version", device.getOSVersion());
        caps.setCapability("device", device.getDeviceName());
        caps.setCapability("real_mobile", "true");
        caps.setCapability("browserstack.debug", "true"); // Allow taking screenshots
        caps.setCapability("name", device.getOSname());

        // Try to create driver connected to BS platform
        try {
            sysLog(BS_STARTING_DRV);
            cloudDriver = new AndroidDriver<>(new URL(URL), caps);
            cloudDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            sysLog(BS_DRV_CREATED);
        } catch (Exception e) {
            sysLog(e.toString());
            errLog(ERR_BS_DRV_NOT_CREATED);
        }
        return cloudDriver;
    }
}
