package gt.org.utils;

import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class DriverManager {

    private static DriverManager driverManager;
    private AndroidDriver driver;

    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    private DriverManager() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:fullReset", false);
        desiredCapabilities.setCapability("appium:platformName", "Android");

//    desiredCapabilities.setCapability("appium:deviceName", "Pixel_9_Pro_XL_API_29");
//    desiredCapabilities.setCapability("appium:platformVersion", "10.0");
//    desiredCapabilities.setCapability(
//        "appium:app", "/Users/automatiautomationon/Desktop/app/aos/financial-times-2-266-0.apk");
//    desiredCapabilities.setCapability("appium:appPackage", "com.ft.news");
//    desiredCapabilities.setCapability(
//        "appium:appActivity", "com.ft.news.presentation.main.MainActivity");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel_9_Pro_XL_API_30");
        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
        desiredCapabilities.setCapability("appium:app", "/Users/automatiautomationon/Desktop/app/aos/Storellet_4023303.apk");
        desiredCapabilities.setCapability("appium:appPackage", "com.storellet");
        desiredCapabilities.setCapability("appium:appActivity", "com.storellet.v3.basement.activity.SplashActivity");

        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 500);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void restartApp() {
        driver.terminateApp((String) driver.getCapabilities().getCapability("appium:appPackage"));
        driver.activateApp((String) driver.getCapabilities().getCapability("appium:appPackage"));
    }

    public void quitApp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void startRecording(String scenarioName) {
        try {
            System.out.println("Start recording scenario: " + scenarioName + "...\n");
            AndroidStartScreenRecordingOptions options = AndroidStartScreenRecordingOptions.startScreenRecordingOptions()
                    .withVideoSize("1280x720")
                    .withBitRate(2000000)
                    .withTimeLimit(Duration.ofMinutes(3));
            driver.startRecordingScreen(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopScreenRecording(String scenarioName) {
        try {
            String base64Video = driver.stopRecordingScreen();
            byte[] decodedVideo = Base64.getDecoder().decode(base64Video);

            File parentDir = new File("target");
            File recordingDir = new File(parentDir, "recording");

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(formatter);

            if (!recordingDir.exists()) {
                recordingDir.mkdir();
            }
            Files.write(Paths.get(String.format("target/recording/%s_%s.mov", formattedDate, scenarioName)), decodedVideo);
            System.out.println(scenarioName + " scenario screen recording stopped...\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}
