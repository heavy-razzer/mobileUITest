package objects;

public enum MSG {

    // Environment names
    ENV_LOCAL("Running on local machine"),
    ENV_BS("Running on BrowserStack"),
    ENV_SL("Running on Saucelabs"),

    // Driver operations
    RUNNING_ON("Running on %s"),
    DEVICE_IS_SET("Device is set: %s / %s"),
    DESKTOP_IS_SET("Desktop platform is set: %s/%s %s/%s"),
    CREATING_LOCAL_DRV("Creating Local driver..."),
    LOCAL_DRV_CREATED("Local driver is created"),
    ERR_CREATING_LOCAL_DRV("Cannot create local WebDriver!"),
    DEVICE_NOT_SET_SETTING_UP_DT_CONN("Device not set: Setting up Desktop connection..."),
    DT_NOT_DEFINED_USE_DEFAULT("Desktop not defined: Using default Desktop parameters: Win10/Chrome"),
    BS_STARTING_DRV("Creating BrowserStack driver..."),
    BS_DRV_CREATED("BrowserStack driver is created"),
    ERR_BS_DRV_NOT_CREATED("Cannot create remote BrowserStack WebDriver!"),
    SL_STARTING_DRV("Creating SauceLabs driver..."),
    SL_DRV_CREATED("SauceLabs driver is created"),
    ERR_SL_DRV_NOT_CREATED("Cannot create remote SauceLabs WebDriver!"),
    DRV_CLOSED("Driver is closed"),
    ERR_SLEEP_FAILED("Sleep thread failed!"),
    ERR_SETTING_PATH_TO_DRV("Error setting path to driver executable!"),
    APPIUM_AUTOSTART_DISABLED("Appium autostart disabled"),
    ERR_INCORRECT_BROWSER_NAME("Incorrect browser name: Using platform default browser"),
    BROWSER_NOT_SET("Browser not set: Using platform default browser"),
    BROWSER_IS_SET("Browser is set: %s"),
    STARTING_APPIUM("Starting Appium..."),
    APPIUM_STARTED("Appium is started"),
    ERR_APPIUM_START_FAILED("Appium start failed!"),
    CLOSING_APPIUM("Closing Appium..."),
    ERR_FAILED_TO_CLOSE_APPIUM("Failed to close Appium!"),
    APPIUM_CLOSED("Appium closed"),
    APPIUM_CLOSED_FORCIBLY("Appium closed forcibly"),

    // Rules
    RULE_RESTART_TEST("Restarting test, attempt: %s"),

    // Config loader
    CONFIG_USED("Using config file"),
    ERR_CANT_PARSE_CONFIG("Can't parse config file"),
    ERR_CONFIG_NOT_EXISTS("Config file does not exists"),

    // BrowserStack server
    LOCAL_SRV_STARTING("Starting BrowserStack LocalTesting server... %s"),
    LOCAL_SRV_STARTED("LocalTesting server started"),
    ERR_LOCAL_SRV_START_FAILED("Failed to start BrowserStack LocalTesting server"),
    LOCAL_SRV_CLOSING("Closing LocalTesting server..."),
    LOCAL_SERVER_CLOSED("LocalTesting server destroyed normally"),
    ERR_CLOSING_LOCAL_SERVER_FAILED("Failed to destroy LocalTesting server normally"),
    LOCAL_SRV_FORCE_CLOSE("Force destroy of LocalTesting server..."),
    LOCAL_SERVER_CLOSED_BY_FORCE("LocalTesting server destroyed by force"),
    WARN_LOCAL_SERVER_NOT_STARTED("LocalTesting server not started. Internal resources can be not available"),

    // Element operations
    ERR_CLICK_INTERRUPTED("Click on element was interrupted"),
    ERR_CANT_DISMISS_ALERT("Cant dismiss alert: No alert present!"),
    ERR_CANT_ACCEPT_ALERT("Cant accept alert: No alert present!"),
    ERR_FAIL_TO_SCROLL("Fail to scroll menu to selected item!"),
    ERR_ELEMENT_NOT_FOUND("Element not found: %s"),

    // Element waits
    ERR_PAGE_NOT_OPENED("Home page was not loaded"),
    ERR_WAIT_FOR_ELEMENT_FAILED("Wait for element failed: %s"),
    ERR_WAIT_FOR_NOT_VISIBILe_FAILED("Wait for element not visible failed: %s"),

    // Skip tests
    SKIP_TEST("Test skipped. %s"),
    BECAUSE_SAFARI_RESTRICTIONS("Cross-origin restrictions, affecting form with card details, can not be turned off in Safari."),
    BECAUSE_BO_NOT_OPTIMISED_FOR_MOBILE("Back Office page is not optimised for mobile browsers."),

    // User auth state
    USER_IS_SIGNED("User is signed"),
    USER_NOT_SIGNED("User is not signed"),

    // PostgreSQL connector
    ERR_CANT_CONNECT_TO_DB("Cant connect to 'remarketing' database"),
    CONNECTED_TO_DB("Connected to 'remarketing' database"),
    ERR_SQL_EXCEPTION("SQL State: %s\n%s"),

    // BackOffice connector
    DELETE_USER("Delete user from BackOffice database"),
    ERR_HTTP_REQUEST_NOT_OK("HTTP request was not successful"),
    ERR_HTTP_REQUEST_FAILED("HTTP request failed");

    private String messageText;

    MSG(String message) {
        this.messageText = message;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
