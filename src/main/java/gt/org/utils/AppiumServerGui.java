package gt.org.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppiumServerGui {

    private Process process;
    private String[] command;

    public void startAppiumService(String proxy) throws IOException, InterruptedException {
        String appiumCommand = String.format("appium --address 127.0.0.1 --port %s --allow-cors --base-path /wd/hub --use-plugins=execute-driver", proxy);
        command = new String[]{
                "osascript", "-e",
                "tell application \"Terminal\" to do script \"" + appiumCommand + "\""};
        process = Runtime.getRuntime().exec(command);
        process.waitFor();
        Thread.sleep(8000l);
    }

    public boolean isAppiumServicePortFree(String port) {
        String command = String.format("lsof -t -i:%s", port);
        StringBuilder result = new StringBuilder();

        try {
            process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            return false;
        }
        return result.length() > 0;
    }

    public void closeAppiumService(String port) throws IOException, InterruptedException {
        String closeCommand = String.format("kill $(lsof -t -i:%s)", port);
        command = new String[]{
                "osascript", "-e",
                "tell application \"Terminal\" to do script \"" + closeCommand + "\""};
        process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }

    public void closeTerminalWindows() throws IOException, InterruptedException {
        command = new String[]{
                "pkill", "-f", "Terminal"
        };

        try {
            process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("All Terminal windows have been closed");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Failed to close Terminal windows");
        }
    }
}


