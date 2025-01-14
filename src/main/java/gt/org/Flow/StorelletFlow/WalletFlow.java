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
        String lastRestaurantName = waitForElementByXpath(walletPage.membershipRestaurantLastNameXpath).getText();
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName), 1)) {
                swipeElementFunction("left", walletPage.membershipRestaurantSwipeView);

                String lastRestaurantNameAfterSwipe = waitForElementByXpath(walletPage.membershipRestaurantLastNameXpath).getText();
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
        String lastRestaurantName = waitForElementByXpath(walletPage.membershipRestaurantLastNameXpath).getText();
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName), 1)) {
                swipeFunction("up");

                String lastRestaurantNameAfterSwipe = waitForElementByXpath(walletPage.membershipRestaurantLastNameXpath).getText();
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
        String lastRestaurantName = waitForElementByXpath(walletPage.myCouponsViewOfLastRestaurantNameXpath).getText();
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath, restaurantName), 1)) {
                swipeFunction("up");

                String lastRestaurantNameAfterSwipe = waitForElementByXpath(walletPage.myCouponsViewOfLastRestaurantNameXpath).getText();
                if (lastRestaurantName.equals(lastRestaurantNameAfterSwipe)) {
                    throw new NoSuchElementException("Restaurant not found: " + restaurantName);
                } else {
                    lastRestaurantName = lastRestaurantNameAfterSwipe;
                }
            } else {
                WebElement webElement = waitForElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath, restaurantName));
                int pixel = webElement.getRect().getY() - waitForElement(walletPage.bottomBar).getRect().getY();
                if (pixel >= -250) {
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
                swipeElementFunction("left", waitForElementByXpath(String.format(walletPage.couponsSwipeViewXpath, restaurantName)));
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
                swipeElementFunction("left", waitForElementByXpath(String.format(walletPage.couponsSwipeViewXpath, restaurantName)));
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
