package drivers;

import utils.Log;

import static objects.MSG.ERR_SLEEP_FAILED;

/*
Safe pause while test execution
 */
class DriverSleep {

    static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Log.errLog(ERR_SLEEP_FAILED);
        }
    }
}
