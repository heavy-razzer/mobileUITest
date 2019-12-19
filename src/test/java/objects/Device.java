package objects;

import lombok.Getter;
import utils.Log;

import static objects.devices.DeviceNames.iphone8plus;
import static objects.devices.DeviceNames.pixel3xl;
import static objects.devices.DeviceVersions.*;
import static utils.Log.sysLog;

@Getter
public class Device {

    private String empty = "empty";

    private String OSVersion;
    private String deviceName;

    public Device() {
        OSVersion = empty;
        deviceName = empty;
    }

    public boolean notEmpty() {
        return !this.deviceName.equals(empty);
    }

    public static Device setDefaultValuesForDevice(String deviceName) {
        Device device = new Device();
        if (deviceName.equals("android")) {
            device.OSVersion = android90;
            device.deviceName = pixel3xl;
            sysLog(MSG.DEVICE_IS_SET, device.getDeviceName(), device.getOSVersion());
        }
        if (deviceName.equals("ios")) {
            device.OSVersion = ios12;
            device.deviceName = iphone8plus;
            sysLog(MSG.DEVICE_IS_SET, device.getDeviceName(), device.getOSVersion());
        }
        return device;
    }

    public static Device setDevice(String OS, String model, String browser) {
        Device device = new Device();
        device.OSVersion = OS;
        device.deviceName = model;
        Log.sysLog(MSG.DEVICE_IS_SET, device.getOSname(), device.getDeviceName());
        return device;
    }

    public String getOSname() {
        String result = "";
        String osName = this.OSVersion;
        if (osName.equals(android71) || osName.equals(android80) || osName.equals(android90)) {
            result = "Android";
        } else if (osName.equals(ios11) || osName.equals(ios12) || osName.equals(ios13)) {
            result = "iOS";
        }
        return result;
    }
}
