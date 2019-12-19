package drivers;

import io.qameta.allure.Step;
import objects.Colours;
import utils.Log;

import static objects.DateFormats.SHORT_TIME;
import static objects.MSG.ERR_SLEEP_FAILED;
import static utils.Log.log;
import static utils.OsUtils.timeStamp;

/*
Safe pause while test execution
 */
public class DriverSleep {

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Log.errLog(ERR_SLEEP_FAILED);
        }
    }

    @Step("Make pause for '{seconds}' seconds")
    public static void sleep(int seconds, String tag) {
        log(Colours.BLUE.getValue() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getValue()
                + " - "
                + tag
                + ": Pause for '"
                + Colours.PURPLE.getValue() + seconds + Colours.DEFAULT.getValue()
                + "' seconds");
        sleep(seconds * 1000);
    }
}
