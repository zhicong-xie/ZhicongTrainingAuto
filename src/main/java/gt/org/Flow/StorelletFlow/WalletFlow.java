package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.WalletPage;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName), 1)) {
                swipeElementFunction("left", walletPage.membershipRestaurantSwipeView, 1, 1);
            } else {
                driver.findElement(By.xpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName))).click();
                break;
            }
        }
    }

    public void swipeUpFindMembershipRestaurantAndClick(String restaurantName) {
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName), 1)) {
                swipeFunction("up");
            } else {
                driver.findElement(By.xpath(String.format(walletPage.membershipRestaurantNameXpath, restaurantName))).click();
                break;
            }
        }
    }

    public WebElement swipeUpToFindMyCouponsViewOfRestaurant(String restaurantName) {
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath, restaurantName), 1)) {
                swipeFunction("up");
            } else {
                return waitForElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath, restaurantName));
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
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.couponsDescribeXpath, restaurantName, couponsDescribe), 1)) {
                swipeElementFunction("left", waitForElementByXpath(String.format(walletPage.couponsSwipeViewXpath, restaurantName)), 1, 1);
            } else {
                waitForElementByXpath(String.format(walletPage.couponsDescribeXpath, restaurantName, couponsDescribe)).click();
                break;
            }
        }
    }

    public void clickMyCouponsViewOfRestaurantCouponsExpiration(String restaurantName, String couponsExpiration) {
        swipeUpToFindMyCouponsViewOfRestaurant(restaurantName);
        while (true) {
            if (!checkElementByXpath(String.format(walletPage.couponsExpirationXpath, restaurantName, couponsExpiration), 1)) {
                swipeElementFunction("left", waitForElementByXpath(String.format(walletPage.couponsSwipeViewXpath, restaurantName)), 1, 1);
            } else {
                waitForElementByXpath(String.format(walletPage.couponsExpirationXpath, restaurantName, couponsExpiration)).click();
                break;
            }
        }
    }
}
