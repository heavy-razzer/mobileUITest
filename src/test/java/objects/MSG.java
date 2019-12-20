package objects;

import lombok.Getter;

/*
Messages list for log output
 */
@Getter
public enum MSG {

    // Environment names
    ENV_LOCAL("Running on local machine"),
    ENV_BS("Running on BrowserStack"),

    // Driver operations
    RUNNING_ON("Running on %s"),
    DEVICE_IS_SET("Device is set: %s / %s"),
    CREATING_LOCAL_DRV("Creating Local driver..."),
    LOCAL_DRV_CREATED("Local driver is created"),
    ERR_CREATING_LOCAL_DRV("Cannot create local WebDriver!"),
    DEVICE_NOT_SET("Device not set"),
    BS_STARTING_DRV("Creating BrowserStack driver..."),
    BS_DRV_CREATED("BrowserStack driver is created"),
    ERR_BS_DRV_NOT_CREATED("Cannot create remote BrowserStack WebDriver!"),
    DRV_CLOSED("Driver is closed"),
    ERR_SLEEP_FAILED("Sleep thread failed!"),
    APPIUM_AUTOSTART_DISABLED("Appium autostart disabled"),
    STARTING_APPIUM("Starting Appium..."),
    APPIUM_STARTED("Appium is started"),
    ERR_APPIUM_START_FAILED("Appium start failed!"),
    CLOSING_APPIUM("Closing Appium..."),
    ERR_FAILED_TO_CLOSE_APPIUM("Failed to close Appium!"),
    APPIUM_CLOSED("Appium closed"),
    APPIUM_CLOSED_FORCIBLY("Appium closed forcibly"),

    // Rules
    RULE_RESTART_TEST("Restarting test, attempt: %s"),

    // Element operations
    ERR_CLICK_FAILED("Click on element was failed"),
    ERR_FAIL_TO_SCROLL("Fail to scroll menu to selected item!"),
    ERR_ELEMENT_NOT_FOUND("Element not found: %s"),
    ERR_MENU_ITEM_NOT_FOUND("Menu item %s not found"),

    // Element waits
    ERR_PAGE_NOT_OPENED("Home page was not loaded"),
    ERR_WAIT_FOR_ELEMENT_FAILED("Wait for element failed: %s"),
    ERR_WAIT_FOR_NOT_VISIBILe_FAILED("Wait for element not visible failed: %s"),
    ERR_NO_SMS_CODE("Verification code NOT received"),

    // User parameters
    ERR_NO_CODE("Country code not set"),
    ERR_NO_PHONE("Phone not set"),
    ERR_NO_EMAIL("Email not set");

    private String messageText;

    MSG(String message) {
        this.messageText = message;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
