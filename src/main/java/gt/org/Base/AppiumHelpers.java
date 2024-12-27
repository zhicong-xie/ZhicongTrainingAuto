package gt.org.Base;

import gt.org.utils.DriverManager;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        try {
            w.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElement(WebElement webElement, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElementByText(String elementText, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.visibilityOf(findElementByText(elementText)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElementByXpath(String elementXpath, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElementClickable(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        try {
            w.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
        }
        return w.until(ExpectedConditions.elementToBeClickable(webElement)).isEnabled();
    }

    protected boolean checkElementClickable(WebElement webElement, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitForElement(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        return w.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement waitForElementByXpath(String xpath) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        return w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected List<WebElement> waitForElementsByXpath(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (TimeoutException e) {
            return Collections.emptyList();
        }
    }

    protected List<WebElement> waitForElementsById(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locator)));
        } catch (TimeoutException e) {
            return Collections.emptyList();
        }
    }

    protected WebElement waitForElementToClickable(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        return w.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForElementToClickable(WebElement webElement, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(timeInSeconds));
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
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        String txtString = String.format("//*[contains(@text, '%s')]", text);
        return w.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.xpath(txtString))));
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
                startX = width * 5 / 6;
                startY = height / 2;
                endX = width / 6;
                endY = height / 2;
                break;
            case "right":
                startX = width / 6;
                startY = height / 2;
                endX = width * 5 / 6;
                endY = height / 2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction.toLowerCase());
        }

        TouchAction touchAction = new TouchAction((PerformsTouchActions) androidDriver);
        touchAction
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    protected WebElement swipeToUpFindFinancialTimesWebElementXpath(
            String xpath, Integer existenceTime, Integer attempts) throws Exception {
        for (int i = 1; i <= attempts; i++) {
            if (!checkElementByText(xpath, existenceTime)) {
                swipeFunction("up");
                waitForSecond(1);
            } else if (!isViewNotInFinancialTimesFootBar(xpath)) {
                swipeFunction("up");
                waitForSecond(1);
            } else {
                break;
            }
        }
        try {
            return findElementByText(xpath);
        } catch (Exception e) {
            throw new Exception("Can't find this element : " + xpath);
        }
    }

    protected void dismissKeyboard() {
//        KeyEvent key = new KeyEvent();
//        key.withKey(AndroidKey.SEARCH);
//        androidDriver.pressKey(key);
        androidDriver.hideKeyboard();
    }

    protected void coordinateClick(Integer x, Integer y) {
        PointOption pointConcat = PointOption.point(x, y);
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.tap(pointConcat).perform();
    }

    protected boolean isViewNotInFinancialTimesFootBar(String xpath) {
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

    protected WebElement swipeToFindElement(String direction, WebElement webElement, Integer existenceTime, Integer attempts) {
        for (int i = 1; i <= attempts; i++) {
            if (!checkElement(webElement, existenceTime)) {
                swipeFunction(direction);
                waitForSecond(1);
            }
        }
        return webElement;
    }

    protected boolean elementIsDisplayedWhenSwipe(String direction, WebElement webElement, Integer existenceTime, Integer attempts) {
        for (int i = 1; i <= attempts; i++) {
            if (!checkElement(webElement, existenceTime)) {
                swipeFunction(direction);
                waitForSecond(1);
            } else {
                return true;
            }
        }
        return false;
    }

    protected BufferedImage getElementScreenshot(WebElement webElement) throws IOException {
        BufferedImage bufferedImage;
        String base64 = webElement.getScreenshotAs(OutputType.BASE64);
        base64 = base64.replaceAll("[\n\r]", "");
        byte[] elementScreenshot = Base64.getDecoder().decode(base64);
        bufferedImage = ImageIO.read(new ByteArrayInputStream(elementScreenshot));
        return bufferedImage;
    }

    protected boolean isImageViewNotNull(BufferedImage bufferedImage) {
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int rgb = bufferedImage.getRGB(x, y);
                Color color = new Color(rgb);
                if (color.getRed() != 255 || color.getGreen() != 255 || color.getBlue() != 255) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void saveElementScreenshot(BufferedImage bufferedImage, String imageName) throws IOException {
        File parentDir = new File("target");
        File screenshotDir = new File(parentDir, "screenshot");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }
        File outputFile = new File(String.format("target/screenshot/%s.png", imageName + formattedDate));
        ImageIO.write(bufferedImage, "png", outputFile);
    }

    protected boolean compareImage(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false;
        }
        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean compareImages(BufferedImage img1, List<BufferedImage> bufferedImageList) {
        int size = bufferedImageList.size();
        int num = 0;
        if (size == 0) {
            return false;
        } else {
            for (BufferedImage bufferedImage : bufferedImageList) {
                if (!compareImage(img1, bufferedImage)) {
                    num++;
                }
            }
        }
        if (num == size) {
            return false;
        }
        return true;
    }

    protected void swipeElementFunction(String direction, WebElement webElement, Integer existenceTime, Integer attempts) {
        Rectangle rect = webElement.getRect();
        int x = rect.getX();
        int y = rect.getY();
        int width = rect.getWidth();
        int height = rect.getHeight();

        int startX;
        int startY;
        int endX;
        int endY;

        switch (direction.toLowerCase()) {
            case "up":
                startX = x + (width / 2);
                startY = y + (height * 4 / 5);
                endX = x + (width / 2);
                endY = y + (height / 5);
                break;
            case "down":
                startX = x + (width / 2);
                startY = y + (height / 5);
                endX = x + (width / 2);
                endY = y + (height * 4 / 5);
                break;
            case "left":
                startX = x + (width * 5 / 6);
                startY = y + (height / 2);
                endX = x + (width / 6);
                endY = y + (height / 2);
                break;
            case "right":
                startX = x + (width / 6);
                startY = y + (height / 2);
                endX = x + (width * 5 / 6);
                endY = y + (height / 2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction.toLowerCase());
        }

        TouchAction touchAction = new TouchAction((PerformsTouchActions) androidDriver);
        touchAction
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    protected byte[] takeFailScreenshot() {
        return androidDriver.getScreenshotAs(OutputType.BYTES);
    }

    protected void swipeCoordinateFunction(Integer startX, Integer startY, Integer endX, Integer endY) {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) androidDriver);
        touchAction
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}
