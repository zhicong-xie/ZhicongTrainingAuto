package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.StorelletMainPage;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StorelletMainFlow extends AppiumHelpers {

    private StorelletMainPage storelletMainPage;
    private DriverManager driverManager;
    private AndroidDriver driver;

    public StorelletMainFlow() {
        storelletMainPage = new StorelletMainPage();
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
    }

    public boolean isStorelletMainSearchIconDisplayed() {
        return checkElement(storelletMainPage.searchIcon);
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
        List<WebElement> restaurantNameList = waitForElementsById(storelletMainPage.restaurantNameId);
        String lastName = restaurantNameList.get(restaurantNameList.size() - 1).getText();
        while (true) {
            if (!checkElementByText(restaurantInfo, 2)) {
                swipeFunction("up");
                restaurantNameList = waitForElementsById(storelletMainPage.restaurantNameId);
                String swipeUpLastName = restaurantNameList.get(restaurantNameList.size() - 1).getText();
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
}
