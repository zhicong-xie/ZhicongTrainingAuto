package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.WalletPage;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class WalletFlow extends AppiumHelpers {

    private WalletPage walletPage;
    private AndroidDriver driver;
    private DriverManager driverManager;

    public WalletFlow() {
        walletPage = new WalletPage();
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
    }

    public boolean isWalletIdentificationDisplayed() {
        waitForSecond(8);
        return checkElement(walletPage.walletIdentification, 60);
    }

    public void clickRedemptionCenterButton() {
        waitForElementToClickable(walletPage.redemptionCenterButton).click();
    }

    public void clickShowAllRestaurantButton() {
        waitForElementToClickable(walletPage.showAllRestaurantButton).click();
    }

    public void swipeLeftFindMembershipRestaurantAndClick(String restaurantName) {
        List<WebElement> restaurantNameList = waitForElementsById(walletPage.membershipRestaurantNameId);
        String lastRestaurantName = restaurantNameList.get(restaurantNameList.size() - 1).getText();
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName), 1)) {
                swipeElementFunction("left", walletPage.membershipRestaurantSwipeView, 1, 1);

                restaurantNameList = waitForElementsById(walletPage.membershipRestaurantNameId);
                String lastRestaurantNameAfterSwipe = restaurantNameList.get(restaurantNameList.size() - 1).getText();
                if (lastRestaurantName.equals(lastRestaurantNameAfterSwipe)) {
                    throw new NoSuchElementException("Restaurant not found: " + restaurantName);
                } else {
                    lastRestaurantName = lastRestaurantNameAfterSwipe;
                }
            } else {
                driver.findElement(By.xpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName))).click();
                break;
            }
        }
    }

    public void swipeUpFindMembershipRestaurantAndClick(String restaurantName) {
        List<WebElement> restaurantNameList = waitForElementsById(walletPage.membershipRestaurantNameId);

        String lastRestaurantName = restaurantNameList.get(restaurantNameList.size() - 1).getText();
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName), 1)) {
                swipeFunction("up");

                restaurantNameList = waitForElementsById(walletPage.membershipRestaurantNameId);
                String lastRestaurantNameAfterSwipe = restaurantNameList.get(restaurantNameList.size() - 1).getText();
                if (lastRestaurantName.equals(lastRestaurantNameAfterSwipe)) {
                    throw new NoSuchElementException("Restaurant not found: " + restaurantName);
                } else {
                    lastRestaurantName = lastRestaurantNameAfterSwipe;
                }
            } else {
                driver.findElement(By.xpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName))).click();
                break;
            }
        }
    }

    public WebElement swipeUpToFindMyCouponsViewOfRestaurant(String restaurantName) {
        List<WebElement> restaurantNameList = waitForElementsById(walletPage.myCouponsViewOfRestaurantNameId);
        String lastRestaurantName = restaurantNameList.get(restaurantNameList.size() - 1).getText();
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath, restaurantName), 1)) {
                swipeFunction("up");

                restaurantNameList = waitForElementsById(walletPage.myCouponsViewOfRestaurantNameId);
                String lastRestaurantNameAfterSwipe = restaurantNameList.get(restaurantNameList.size() - 1).getText();
                if (lastRestaurantName.equals(lastRestaurantNameAfterSwipe)) {
                    throw new NoSuchElementException("Restaurant not found: " + restaurantName);
                } else {
                    lastRestaurantName = lastRestaurantNameAfterSwipe;
                }
            } else {
                WebElement webElement = waitForElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath, restaurantName));
                int pixel = webElement.getRect().getY() - waitForElement(walletPage.bottomBar).getRect().getY();
                if (pixel >= -100) {
                    swipeFunction("up");
                }
                return webElement;
            }
        }
    }

    public void clickMyCouponsViewOfRestaurant(String restaurantName) {
        swipeUpToFindMyCouponsViewOfRestaurant(restaurantName).click();
    }

    public void clickMyCouponsViewOfRestaurantAllCouponsButton(String restaurantName) {
        swipeUpToFindMyCouponsViewOfRestaurant(restaurantName);
        waitForElementByXpath(String.format(walletPage.allCouponsButtonXpath, restaurantName)).click();
    }

    public void clickMyCouponsViewOfRestaurantCouponsDescribe(String restaurantName, String couponsDescribe) {
        swipeUpToFindMyCouponsViewOfRestaurant(restaurantName);
        int num = 0;
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.couponsDescribeXpath, restaurantName, couponsDescribe), 1)) {
                swipeElementFunction("left", waitForElementByXpath(String.format(walletPage.couponsSwipeViewXpath, restaurantName)), 1, 1);
                num++;
            } else {
                waitForElementByXpath(String.format(walletPage.couponsDescribeXpath, restaurantName, couponsDescribe)).click();
                break;
            }
            if (num > 50) {
                throw new NoSuchElementException(String.format("the %s restaurant's coupons describe not found: %s", restaurantName, couponsDescribe));
            }
        }
    }

    public void clickMyCouponsViewOfRestaurantCouponsExpiration(String restaurantName, String couponsExpiration) {
        swipeUpToFindMyCouponsViewOfRestaurant(restaurantName);
        int num = 0;
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.couponsExpirationXpath, restaurantName, couponsExpiration), 1)) {
                swipeElementFunction("left", waitForElementByXpath(String.format(walletPage.couponsSwipeViewXpath, restaurantName)), 1, 1);
                num++;
            } else {
                waitForElementByXpath(String.format(walletPage.couponsExpirationXpath, restaurantName, couponsExpiration)).click();
                break;
            }
            if (num > 50) {
                throw new NoSuchElementException(String.format("the %s restaurant's coupons expiration not found: %s", restaurantName, couponsExpiration));
            }
        }
    }
}
