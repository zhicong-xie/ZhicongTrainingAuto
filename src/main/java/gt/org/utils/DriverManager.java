package gt.org.utils;

import cucumber.api.Scenario;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

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
    desiredCapabilities.setCapability("appium:deviceName", "Pixel_9_Pro_XL_API_29");
    desiredCapabilities.setCapability("appium:platformVersion", "10.0");
    desiredCapabilities.setCapability(
        "appium:app", "/Users/automatiautomationon/Desktop/app/aos/financial-times-2-266-0.apk");
    desiredCapabilities.setCapability("appium:appPackage", "com.ft.news");
    desiredCapabilities.setCapability(
        "appium:appActivity", "com.ft.news.presentation.main.MainActivity");
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
    driver.quit();
    driver = null;
    driverManager = new DriverManager();
  }

  public AndroidDriver getDriver() {
    return driver;
  }

  //    @After
  //    public void afterScenario(Scenario scenario) {
  //        if (scenario.isFailed()) {
  //            // Take a screenshot...
  //            final byte[] screenshot = ((TakesScreenshot)
  // driver).getScreenshotAs(OutputType.BYTES);
  //            // ... and embed it in the report.
  //            scenario.embed(screenshot, "image/png");
  //        }
  //    }

}
