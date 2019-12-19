package objects;

import lombok.Getter;
import utils.Log;

import static objects.devices.DeviceNames.iphone8plus;
import static objects.devices.DeviceNames.pixel3xl;
import static objects.devices.DeviceVersions.*;

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

    public void setDefaultValuesForDevice(String deviceName) {
        if (deviceName.toLowerCase().equals("android")) {
            this.setDevice(android90, pixel3xl);
        }
        if (deviceName.toLowerCase().equals("ios")) {
            this.setDevice(ios12, iphone8plus);
        }
    }

    private void setDevice(String OS, String model) {
        this.OSVersion = OS;
        this.deviceName = model;
        Log.sysLog(MSG.DEVICE_IS_SET, this.getOSname(), this.getDeviceName());
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
