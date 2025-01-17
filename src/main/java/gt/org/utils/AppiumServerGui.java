package gt.org.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.*;

public class AppiumServerGui {

    private Process process;
    private AppiumDriverLocalService service;

    public void startAppiumService(int proxy) throws IOException, InterruptedException {
        File logFile = new File("appium-server.log");

        try (RandomAccessFile file = new RandomAccessFile(logFile, "rw")) {
            file.setLength(0);
            System.out.println("Local Appium log has been cleared.");
        } catch (IOException e) {
            System.err.println("Error clearing the file: " + e.getMessage());
        }
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(proxy)
                .withArgument(() -> "--base-path", "/wd/hub")
                .withLogFile(logFile)
                .build();

        service.clearOutPutStreams();

        service.start();

        System.out.println("Appium Server started at: " + service.getUrl());
    }

    public boolean isAppiumServicePortOccupancy(int port) {
        String command = String.format("lsof -t -i:%d", port);
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

    public void stepPort(int port) throws IOException, InterruptedException {
        String stepCommand = String.format("kill $(lsof -t -i:%d)", port);
        try {
            process = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", stepCommand});
            process.waitFor();
            System.out.println(port + " port step...");
        } catch (Exception e) {
            System.err.println("Failed to close port " + port + ": " + e.getMessage());
        }
    }

    public void stopAppiumService() {
        try {
            if (process != null) {
                service.stop();
                System.out.println("Appium Server stopped.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}