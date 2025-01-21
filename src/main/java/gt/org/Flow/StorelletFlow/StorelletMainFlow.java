package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.StorelletMainPage;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Mat;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StorelletMainFlow extends AppiumHelpers {

    private StorelletMainPage storelletMainPage;
    private DriverManager driverManager;
    private WebDriver driver;

    public StorelletMainFlow() {
        storelletMainPage = new StorelletMainPage();
        driverManager = DriverManager.getInstance();
        driver = driverManager.getWebDecoratorDriver();
    }

    public boolean isStorelletMainSearchIconDisplayed() {
        return checkElement(storelletMainPage.mainPageIdentification);
    }

    public void clickRedemptionCenterButton() {
        waitForElementToClickable(storelletMainPage.redemptionCenterButton).click();
    }

    public void clickSearchIcon() {
        waitForElementToClickable(storelletMainPage.searchIcon).click();
    }

    public void clickNoticeIcon() {
        waitForElementToClickable(storelletMainPage.noticeIcon).click();
    }

    public void saveBigPromotionImageToLocalFolder() throws IOException {
        List<WebElement> imageViewElements = waitForElementsByXpath(storelletMainPage.bigPromotionImageXpathString);
        int firstImageWidth = imageViewElements.get(0).getRect().getWidth();
        List<BufferedImage> screenshotBufferedImage = new ArrayList<>();
        Rectangle rect = waitForElement(storelletMainPage.bigPromotionView).getRect();
        int swipePixel = 100;
        int num = 1;
        while (true) {
            int elementNum = 0;
            for (int i = 0; i < imageViewElements.size(); i++) {
                BufferedImage bufferedImage = getElementScreenshot(imageViewElements.get(i));
                if (imageViewElements.get(i).getRect().getWidth() == firstImageWidth && isImageViewNotNull(bufferedImage) && !compareImages(bufferedImage, screenshotBufferedImage)) {
                    screenshotBufferedImage.add(bufferedImage);
                    saveElementScreenshot(bufferedImage, "Big Promotion Image_" + num + "_");
                    num++;
                    swipePixel = imageViewElements.get(i).getRect().getX() + imageViewElements.get(i).getRect().getWidth();
                } else {
                    elementNum++;
                }
            }
            if (elementNum == imageViewElements.size()) {
                break;
            } else {
                int y = rect.getY();
                int height = rect.getHeight();
                swipeCoordinateFunction(swipePixel - 10, (y + height) / 2, 5, (y + height) / 2);
                imageViewElements = waitForElementsByXpath(storelletMainPage.bigPromotionImageXpathString);
            }
        }
    }

    public void selectRestaurant(String restaurantInfo) {
        String lastName = waitForElementByXpath(storelletMainPage.lastRestaurantNameXpath).getText();
        while (true) {
            if (!checkElementByText(restaurantInfo, 1)) {
                swipeFunction("up");
                String swipeUpLastName = waitForElementByXpath(storelletMainPage.lastRestaurantNameXpath).getText();
                if (lastName.equals(swipeUpLastName)) {
                    throw new NoSuchElementException("Restaurant not found: " + restaurantInfo);
                } else {
                    lastName = swipeUpLastName;
                }
            } else {
                WebElement webElement = driver.findElement(By.xpath(String.format("//*[contains(@text, '%s')]/../*[@resource-id = 'com.storellet:id/item_payload_action_row_action_container']", restaurantInfo)));
                int pixel = webElement.getRect().getY() - waitForElement(storelletMainPage.bottomBar).getRect().getY();
                if (pixel >= -100) {
                    swipeFunction("up");
                }
                webElement.click();
                break;
            }
        }
    }

    public void clickJoinButton() {
        String lastName = waitForElementByXpath(storelletMainPage.lastRestaurantNameXpath).getText();
        while (true) {
            if (!checkElement(storelletMainPage.jointButton, 1)) {
                swipeFunction("up");
                String swipeUpLastName = waitForElementByXpath(storelletMainPage.lastRestaurantNameXpath).getText();
                if (lastName.equals(swipeUpLastName)) {
                    throw new NoSuchElementException("Join button not found");
                } else {
                    lastName = swipeUpLastName;
                }
            } else {
                int pixel = storelletMainPage.jointButton.getRect().getY() - waitForElement(storelletMainPage.bottomBar).getRect().getY();
                if (pixel >= -100) {
                    swipeFunction("up");
                }
                storelletMainPage.jointButton.click();
                break;
            }
        }
    }

    public String getFirstBigPromotionImageText() throws IOException, TesseractException {
        List<WebElement> imageViewElements = waitForElementsByXpath(storelletMainPage.bigPromotionImageXpathString);
        String result = getImageText(getElementScreenshot(imageViewElements.get(0)), "chi_tra").replaceAll(" ", "");
        System.out.println("Home page first big promotion image text: " + result);
        return result;
    }

    public boolean isFirstBigPromotionImageConsistentWithLocalImages() {
        boolean actualResult = false;
        Mat expectedMat = loadImageAsMat("LocalImage/First big promotion image.png");
        Mat actualMat = loadImageAsMat(takeDeviceScreenshot());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        String outputPath = String.format("LocalImage/CompareResult/matched_result_%s.png", formattedDate);

        actualResult = matchImagesAndDraw(actualMat, expectedMat, outputPath, 5500);

        System.out.println("Home page first big promotion image compare saved successfully at: " + outputPath);
        return actualResult;
    }

    public boolean isLocalImageContainsFirstBigPromotion() throws Exception {
        boolean actualResult = false;
        Mat expectedMat = loadImageAsMat("LocalImage/First big image_1.png");
        List<WebElement> imageViewElements = waitForElementsByXpath(storelletMainPage.bigPromotionImageXpathString);
        Mat actualMat = loadImageAsMat(bufferedImageToBytes(getElementScreenshot(imageViewElements.get(0)),"png"));
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        String outputPath = String.format("LocalImage/CompareResult/matched_result_%s.png", formattedDate);

        actualResult = matchImagesAndDraw(actualMat, expectedMat, outputPath, 130);

        System.out.println("Home page first big promotion image compare saved successfully at: " + outputPath);
        return actualResult;
    }
}
