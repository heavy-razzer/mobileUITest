package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import objects.Device;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.EnvironmentProperties;
import utils.OsUtils;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static objects.MSG.*;
import static utils.Log.errLog;
import static utils.Log.sysLog;

public class CreateDrv {

    public static AppiumDriver createLocalDriver() {

        AppiumDriver localDriver = null;

        Device device = OsUtils.getDevice();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, device.getOSname());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, device.getDeviceName());

        if (device.getOSname().equals("Android")) { // for Android device
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                    new DecimalFormat("0.#").format(Double.parseDouble(device.getOSVersion())));
            caps.setCapability("appPackage", "io.voiapp.voi");
            caps.setCapability("appActivity", ".MainActivity");
        } else { // for iOS device
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getOSVersion() + ".1");
        }
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10");

        try {
            sysLog(CREATING_LOCAL_DRV);
            String baseURL = "http://0.0.0.0:";
            String minorURL = "/wd/hub";
            String port = "4723";
            localDriver = new AppiumDriver(new URL(baseURL + port + minorURL), caps);
            localDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            sysLog(LOCAL_DRV_CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errLog(ERR_CREATING_LOCAL_DRV);
        }
        return localDriver;
    }

    public static AppiumDriver createBSDriver() {

        String USERNAME;
        String AUTOMATE_KEY;
        String SERVER;

        EnvironmentProperties environmentProperties = new EnvironmentProperties();
        USERNAME = environmentProperties.getBrowserStackUserName();
        AUTOMATE_KEY = environmentProperties.getBrowserStackUserPsw();
        SERVER = environmentProperties.getBSserver();
        String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@" + SERVER;

        AppiumDriver cloudDriver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        Device device = OsUtils.getDevice();

        caps.setCapability("os_version", device.getOSVersion());
        caps.setCapability("device", device.getDeviceName());
        caps.setCapability("real_mobile", "true");
        caps.setCapability("browserstack.debug", "true"); // Allow taking screenshots
        caps.setCapability("name", device.getOSname());

        try {
            sysLog(BS_STARTING_DRV);
            cloudDriver = new AppiumDriver(new URL(URL), caps);
            cloudDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            sysLog(BS_DRV_CREATED);
        } catch (Exception e) {
            sysLog(e.toString());
            errLog(ERR_BS_DRV_NOT_CREATED);
        }
        return cloudDriver;
    }
}