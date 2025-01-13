package gt.org.Base;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.*;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.Features2d;
import org.opencv.features2d.FlannBasedMatcher;
import org.opencv.features2d.SIFT;
import org.opencv.imgcodecs.Imgcodecs;
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
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppiumHelpers {

    private final int defaultWaitingTime = 30;
    private WebDriver webDriver;
    private AndroidDriver androidDriver;
    private DriverManager driverManager;
    private String footBarClassName = "android.widget.TabWidget";

    public AppiumHelpers() {
        /*Opencv 安装与环境配置
         *
         * 1. 终端输入 'brew install ant'
         * 2. 终端输入 'brew install opencv'
         * 3. 终端输入 'brew edit opencv' 将 DBUILD_opencv_java=OFF 修改为 DBUILD_opencv_java=ON; 保存并退出
         * 4. 终端输入 'brew install --build-from-source opencv'
         *
         * */
        System.load("/usr/local/share/java/opencv4/libopencv_java4120.dylib"); // 变更为 使用上述命令，生成本地的opencv-java 链接库路径
        driverManager = DriverManager.getInstance();
        androidDriver = driverManager.getDriver();
        webDriver = driverManager.getWebDecoratorDriver();
    }

    protected boolean checkElement(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(androidDriver, Duration.ofSeconds(defaultWaitingTime));
        try {
            w.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElement(WebElement webElement, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElementByText(String elementText, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.visibilityOf(findElementByText(elementText)));
            return findElementByText(elementText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElementByXpath(String elementXpath, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            return webDriver.findElement(By.xpath(elementXpath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElementClickable(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
        try {
            w.until(ExpectedConditions.elementToBeClickable(webElement));
            return webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean checkElementClickable(WebElement webElement, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(timeInSeconds));
        try {
            w.until(ExpectedConditions.elementToBeClickable(webElement));
            return webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitForElement(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
        return w.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement waitForElementByXpath(String xpath) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
        return w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected List<WebElement> waitForElementsByXpath(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (Exception e) {
            throw new NoSuchElementException("No element found");
        }
    }

    protected List<WebElement> waitForElementsById(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locator)));
        } catch (Exception e) {
            throw new NoSuchElementException("No element found");
        }
    }

    protected WebElement waitForElementToClickable(WebElement webElement) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
        return w.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForElementAttributeIsState(WebElement webElement, String attribute, String state) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
        w.until(d -> webElement.getDomAttribute(attribute).equals(state));
        return webElement;
    }

    protected WebElement waitForElementToClickable(WebElement webElement, Integer timeInSeconds) {
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(timeInSeconds));
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
        WebDriverWait w = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitingTime));
        String txtString = String.format("//*[contains(@text, '%s')]", text);
        return w.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(txtString))));
    }

    protected void swipeFunction(String direction) {
        Dimension size = webDriver.manage().window().getSize();
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
                waitForElement(webDriver.findElement(By.className(footBarClassName)))
                        .getLocation()
                        .getY();
        int viewBottomCoordinateY =
                webDriver.findElement(By.xpath(xpath)).getLocation().getY()
                        + webDriver.findElement(By.xpath(xpath)).getSize().getHeight();
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
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        createDirectoryIfNotExists("target/screenshot/");
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

    protected String getImageText(BufferedImage bufferedImage, String language) throws TesseractException {
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
        iTesseract.setLanguage(language);

        return iTesseract.doOCR(bufferedImage);
    }

    protected void createDirectoryIfNotExists(String path) {
        Pattern pattern = Pattern.compile("(.*/)(.*)$");
        Matcher matcher = pattern.matcher(path);

        if (matcher.matches()) {
            String directoryPath = matcher.group(1);
            File dir = new File(directoryPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        } else {
            System.out.println("Invalid path format: " + path);
        }
    }

    /*将本地文件转为Opencv Mat类型*/
    protected Mat loadImageAsMat(String path) {
        return Imgcodecs.imread(path);
    }

    /*将字节数据转为Opencv Mat类型*/
    protected Mat loadImageAsMat(byte[] imageBytes) {
        return Imgcodecs.imdecode(new MatOfByte(imageBytes), Imgcodecs.IMREAD_COLOR);
    }

    protected void extractSIFTFeatures(Mat image, MatOfKeyPoint keypoints, Mat descriptors) {
        SIFT sift = SIFT.create();// 创建 SIFT 特征提取器
        sift.detectAndCompute(image, new Mat(), keypoints, descriptors);// SIFT特征提取
    }

    protected boolean matchImagesAndDraw(Mat largeImage, Mat smallImage, String outputPath, int matchesCount) {
        // 1. 提取关键点和描述符
        MatOfKeyPoint largeImageKeypoints = new MatOfKeyPoint();
        Mat largeImageDescriptors = new Mat();
        extractSIFTFeatures(largeImage, largeImageKeypoints, largeImageDescriptors);

        MatOfKeyPoint smallImageKeypoints = new MatOfKeyPoint();
        Mat smallImageDescriptors = new Mat();
        extractSIFTFeatures(smallImage, smallImageKeypoints, smallImageDescriptors);

        // 2. FLANN匹配
        DescriptorMatcher matcher = new FlannBasedMatcher();
        List<MatOfDMatch> knnMatches = new ArrayList<>();
        matcher.knnMatch(smallImageDescriptors, largeImageDescriptors, knnMatches, 2);

        // 3. 过滤匹配结果：使用比率测试
        int goodMatchesCount = 0;
        float ratio = 0.75f;  // Lowe的比率测试阈值
        List<DMatch> goodMatches = new ArrayList<>();
        for (MatOfDMatch matOfDMatch : knnMatches) {
            DMatch[] matchArray = matOfDMatch.toArray();
            if (matchArray[0].distance < ratio * matchArray[1].distance) {
                goodMatchesCount++;
                goodMatches.add(matchArray[0]);
            }
        }
        boolean isPresent = goodMatchesCount > matchesCount; // 阈值可以根据需要调整

        System.out.println("Matches Count : " + goodMatchesCount);

        createDirectoryIfNotExists(outputPath);

        //绘制结果
        Mat resultImage = new Mat();
        Features2d.drawMatches(smallImage, smallImageKeypoints, largeImage, largeImageKeypoints,
                new MatOfDMatch(goodMatches.toArray(new DMatch[goodMatches.size()])),
                resultImage);

        Imgcodecs.imwrite(outputPath, resultImage);

        return isPresent;
    }
}
