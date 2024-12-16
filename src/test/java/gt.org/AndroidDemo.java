package gt.org;

import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class AndroidDemo {

  public static void main(String[] args) throws InterruptedException, IOException {

    AndroidDriver androidDriver = null;
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    WebDriverWait w = null;

    desiredCapabilities.setCapability("appium:noReset", false);
    desiredCapabilities.setCapability("appium:fullReset", false);
    desiredCapabilities.setCapability("appium:platformName", "Android");
    desiredCapabilities.setCapability("appium:deviceName", "Pixel_9_Pro_XL_API_29");
    desiredCapabilities.setCapability("appium:platformVersion", "10.0");
    desiredCapabilities.setCapability(
        "appium:app", "C:\\Users\\Administrator\\Desktop\\Automation\\financial-times-2-266-0.apk");
    desiredCapabilities.setCapability("appium:appPackage", "com.ft.news");
    desiredCapabilities.setCapability(
        "appium:appActivity", "com.ft.news.presentation.main.MainActivity");
    desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");

    try {
      androidDriver =
          new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
      //      androidDriver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT,500);
      w = new WebDriverWait(androidDriver, 30);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    Thread.sleep(30000l);
    androidDriver.findElementByXPath("//*[@text = 'Accept Cookies']").click();

    //    System.out.println("等待3s");
    //    Thread.sleep(3000l);
    //    System.out.println("点击英语按钮");
    //    androidDriver.findElementById("english").click();
    //    System.out.println("等待15s");
    //    Thread.sleep(15000l);
    //
    //    WebElement image =  androidDriver.findElementById("imageview");

    File imageViewScreenshot = androidDriver.getScreenshotAs(OutputType.FILE);

    LocalDateTime localDateTime = LocalDateTime.now();

    FileUtils.copyFile(
        imageViewScreenshot, new File(String.format("Screenshot/%s_ImageView.png", localDateTime)));

    //    BufferedImage actualImage = ImageIO.read(imageViewScreenshot);
    //
    //    AndroidDemo androidDemo = new AndroidDemo();
    //
    //    if (androidDemo.isImageWhite(actualImage)){
    //      System.out.println("全白色");
    //    }else {
    //      System.out.println("非白色");
    //    }
    //
    if (androidDriver != null) {
      androidDriver.quit();
    }
  }

  //  public boolean isImageWhite(BufferedImage image){
  //
  //    for (int x = 0; x<image.getWidth();x++){
  //      for (int y = 0; y<image.getHeight();y++){
  //        int rgb = image.getRGB(x,y);
  //        Color color = new Color(rgb);
  //        if (color.getRed()!=255 || color.getGreen()!=255||color.getBlue()!=255){
  //          return false;
  //        }
  //      }
  //    }
  //    return true;
  //  }

}
