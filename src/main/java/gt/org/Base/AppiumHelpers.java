package gt.org.Base;

import gt.org.utils.DriverManager;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumHelpers {

  private final int defaultWaitingTime = 30;
  private AndroidDriver androidDriver;
  private DriverManager driverManager;
  private String footBarClassName = "android.widget.TabWidget";

  public AppiumHelpers() {
    driverManager = DriverManager.getInstance();
    androidDriver = driverManager.getDriver();
  }

  protected boolean checkElement(WebElement webElement) {
    WebDriverWait w = new WebDriverWait(androidDriver, defaultWaitingTime);
    try {
      w.until(ExpectedConditions.visibilityOf(webElement));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  protected boolean checkElement(WebElement webElement, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(androidDriver, timeInSeconds);
    try {
      w.until(ExpectedConditions.visibilityOf(webElement));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  protected boolean checkElementByXpath(String elementXpath, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(androidDriver, timeInSeconds);
    try {
      w.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.xpath(elementXpath))));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  protected boolean checkElementClickable(WebElement webElement) {
    WebDriverWait w = new WebDriverWait(androidDriver, defaultWaitingTime);
    try {
      w.until(ExpectedConditions.visibilityOf(webElement));
    } catch (Exception e) {
    }
    return w.until(ExpectedConditions.elementToBeClickable(webElement)).isEnabled();
  }

  protected boolean checkElementClickable(WebElement webElement, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(androidDriver, timeInSeconds);
    try {
      w.until(ExpectedConditions.visibilityOf(webElement));

    } catch (Exception e) {
    }
    return w.until(ExpectedConditions.elementToBeClickable(webElement)).isEnabled();
  }

  protected WebElement waitForElement(WebElement webElement) {
    WebDriverWait w = new WebDriverWait(androidDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.visibilityOf(webElement));
  }

  protected WebElement waitForElementToClickable(WebElement webElement) {
    WebDriverWait w = new WebDriverWait(androidDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.elementToBeClickable(webElement));
  }

  protected void waitForSecond(Integer timeInSeconds) {
    try {
      Thread.sleep(timeInSeconds * 1000l);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected WebElement findElementByText(String text) {
    WebDriverWait w = new WebDriverWait(androidDriver, defaultWaitingTime);
    String txtString = String.format("//*[contains(@text, '%s')]", text);
    return w.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.xpath(txtString))));
  }

  protected String elementTextXpathString(String text) {
    return String.format("//*[contains(@text, '%s')]", text);
  }

  protected void swipeFunction(String direction) {
    Dimension size = androidDriver.manage().window().getSize();
    int width = size.width;
    int height = size.height;

    int startX;
    int startY;
    int endX;
    int endY;

    switch (direction.toLowerCase()) {
      case "up":
        startX = width / 2;
        startY = height * 4 / 5;
        endX = width / 2;
        endY = height / 5;
        break;
      case "down":
        startX = width / 2;
        startY = height / 5;
        endX = width / 2;
        endY = height * 4 / 5;
        break;
      case "left":
        startX = width * 4 / 5;
        startY = height / 2;
        endX = width / 5;
        endY = height / 2;
        break;
      case "right":
        startX = width / 5;
        startY = height / 2;
        endX = width * 4 / 5;
        endY = height / 2;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + direction.toLowerCase());
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) androidDriver);
    touchAction
        .press(PointOption.point(startX, startY))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        .moveTo(PointOption.point(endX, endY))
        .release()
        .perform();
  }

  protected WebElement swipeToUpFindWebElementXpath(
      String xpath, Integer existenceTime, Integer attempts) throws Exception {
    for (int i = 1; i <= attempts; i++) {
      if (!checkElementByXpath(xpath, existenceTime)) {
        swipeFunction("up");
        waitForSecond(1);
      } else if (!isViewNotInFootBar(xpath)) {
        swipeFunction("up");
        waitForSecond(1);
      } else {
        break;
      }
    }
    try {
      return androidDriver.findElement(By.xpath(xpath));
    } catch (Exception e) {
      throw new Exception("Can't find this element : " + xpath);
    }
  }

  protected void dismissKeyboard() {
    KeyEvent key = new KeyEvent();
    key.withKey(AndroidKey.SEARCH);
    androidDriver.pressKey(key);
  }

  protected void coordinateClick(Integer x, Integer y) {
    PointOption pointConcat = PointOption.point(x, y);
    TouchAction touchAction = new TouchAction(androidDriver);
    touchAction.tap(pointConcat).perform();
  }

  protected boolean isViewNotInFootBar(String xpath) {
    int footBarCoordinateY =
        waitForElement(androidDriver.findElement(By.className(footBarClassName)))
            .getLocation()
            .getY();
    int viewBottomCoordinateY =
        androidDriver.findElement(By.xpath(xpath)).getLocation().getY()
            + androidDriver.findElement(By.xpath(xpath)).getSize().getHeight();
    if (viewBottomCoordinateY >= footBarCoordinateY) {
      return false;
    }
    return true;
  }
}
