package gt.org.Base;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
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
import java.util.NoSuchElementException;

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
        } catch (Exception e) {
            throw new NoSuchElementException("No element found");
        }
    }

    protected List<WebElement> waitForElementsById(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locator)));
        } catch (Exception e) {
            throw new NoSuchElementException("No element found");
        }
    }

    protected WebElement waitForElementToClickable(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        return w.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForElementAttributeIsState(WebElement webElement, String attribute, String state) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        w.until(d -> webElement.getAttribute(attribute).equals(state));
        return webElement;
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
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Collections.singletonList(swipe));
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
        androidDriver.hideKeyboard();
    }

    protected void coordinateClick(Integer x, Integer y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence click = new Sequence(finger, 0);

        click.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        click.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        click.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(click));
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

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Collections.singletonList(swipe));
    }

    protected byte[] takeDeviceScreenshot() {
        return androidDriver.getScreenshotAs(OutputType.BYTES);
    }

    protected void swipeCoordinateFunction(Integer startX, Integer startY, Integer endX, Integer endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Collections.singletonList(swipe));
    }

    protected String getImageText(BufferedImage bufferedImage) throws TesseractException {
        /*
         *  在自己macbook终端输入"brew install tesseract" 安装
         *  完成上述后在终端输入"brew install tesseract-lang" 获取除英文以外的全部语言包
         *  或者在 "https://github.com/tesseract-ocr/tessdata" 手动下载'.traineddata'后缀的语言包并手动添加到该目录下'/usr/local/Cellar/tesseract/<tesseract version>/share/tessdata'
         *
         * iTesseract.setDatapath("path")        设置 Tess4J 数据路径
         * iTesseract.setLanguage("language");   设置识别的语言(eng:英文; chi_sim:简中; chi_tra:繁中. 如果有字体混合组合可用'+')
         */

        ITesseract iTesseract = new Tesseract();
        iTesseract.setDatapath("/usr/local/Cellar/tesseract/5.5.0/share/tessdata");
        iTesseract.setLanguage("eng+chi_sim+chi_tra");

        return iTesseract.doOCR(bufferedImage);
    }
}
