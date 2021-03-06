package drivers;

import objects.MSG;

import java.util.ArrayList;
import java.util.List;

import static drivers.DriverSleep.sleep;
import static utils.Log.sysLog;
import static utils.OsUtils.*;

/*
Commands to launch and stop Appium server on defined port
 */
public class AppiumServer {

    public static Process startAppiumServer(int serverPort) {

        Process appium_Process = null;
        if (System.getProperty("appium") != null) {
            sysLog(MSG.STARTING_APPIUM);
            ShellExecutor shellExecutor = new ShellExecutor();
            String[] cmd;

            // Kill process on server port
            if (isMAC() || isLinux()) {
                cmd = new String[]{"sh", "-c", "lsof -P | grep ':" + serverPort + "' | awk '{print $2}' | xargs kill -9"};
                shellExecutor.executeShell(cmd);
            } else {
                cmd = new String[]{"cmd.exe", "/c", "for /f \"tokens=5\" %p in ('netstat -aon ^| findstr " + serverPort + "') do @TASKKILL /PID %p /F"};
                shellExecutor.executeShell(cmd);
            }

            // Set Appium server parameters
            List<String> list = new ArrayList<>();
            if (isWindows()) { // windows
                list.add("cmd.exe");
                list.add("/c");
            }
            list.add("appium");
            list.add("--log-level");
            list.add("error");
            list.add("--port");
            list.add(String.valueOf(serverPort));
            list.add("--bootstrap-port");
            list.add(String.valueOf(serverPort + 100));
            list.add("--command-timeout");
            list.add("90");
            list.add("--session-override");
            list.add("--log-timestamp");
            list.add("--allow-insecure");
            list.add("chromedriver_autodownload");

            // Create the process builder
            try {
                ProcessBuilder pb1 = new ProcessBuilder(list);
                pb1.redirectErrorStream(true);
                pb1.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                appium_Process = pb1.start();
                sleep(10000); // TODO: Research how to check if server started correctly
                sysLog(MSG.APPIUM_STARTED);
            } catch (Exception e) {
                sysLog(MSG.ERR_APPIUM_START_FAILED);
                e.printStackTrace();
            }
        } else {
            sysLog(MSG.APPIUM_AUTOSTART_DISABLED);
        }
        return appium_Process;
    }

    public static void closeAppiumServer(Process appiumProcess) {
        if (System.getProperty("appium") != null) {
            sysLog(MSG.CLOSING_APPIUM);
            if (appiumProcess != null) {
                try {
                    appiumProcess.destroy();
                } catch (Exception e) {
                    sysLog(MSG.ERR_FAILED_TO_CLOSE_APPIUM);
                    e.printStackTrace();
                }
                if (appiumProcess.isAlive()) {
                    appiumProcess.destroyForcibly();
                    sysLog(MSG.APPIUM_CLOSED_FORCIBLY);
                } else {
                    sysLog(MSG.APPIUM_CLOSED);
                }
            }
        }
    }
}
