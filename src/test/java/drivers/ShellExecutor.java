package drivers;

import java.io.IOException;

class ShellExecutor {

    void executeShell(String[] cmd) {
        try {
            final Process p = new ProcessBuilder(cmd)
                    .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start();
            p.destroy();
            if (p.isAlive()) {
                p.destroyForcibly();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
