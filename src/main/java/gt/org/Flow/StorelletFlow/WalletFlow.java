package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.WalletPage;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WalletFlow extends AppiumHelpers {

    private WalletPage walletPage;
    private AndroidDriver driver;
    private DriverManager driverManager;

    public WalletFlow() {
        walletPage = new WalletPage();
        driver = driverManager.getDriver();
    }

    public boolean isWalletTitlePageDisplayed() {
        return checkElement(walletPage.walletTitle);
    }

    public void clickRedemptionCenterButton(){
        waitForElementToClickable(walletPage.redemptionCenterButton).click();
    }

    public void clickShowAllRestaurantButton(){
        waitForElementToClickable(walletPage.showAllRestaurantButton).click();
    }

    public void swipeLeftFindMembershipRestaurantAndClick(String restaurantName){
        while (true){
          if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath,restaurantName),1)){
              swipeElementFunction("left",walletPage.membershipRestaurantSwipeView,1,1);
          }else {
              driver.findElement(By.xpath(String.format(walletPage.membershipRestaurantNameXpath,restaurantName))).click();
              break;
          }
        }
    }

    public void swipeUpFindMembershipRestaurantAndClick(String restaurantName){
        while (true){
            if (!checkElementByXpath(String.format(walletPage.membershipRestaurantNameXpath,restaurantName),1)){
                swipeFunction("up");
            }else {
                driver.findElement(By.xpath(String.format(walletPage.membershipRestaurantNameXpath,restaurantName))).click();
                break;
            }
        }
    }

    public WebElement swipeUpToFindMyCouponsViewOfRestaurant(String restaurantName){
        while (true){
            if (!checkElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath,restaurantName),1)){
                swipeFunction("up");
            }else {
                return waitForElementByXpath(String.format(walletPage.myCouponsViewOfRestaurantNameXpath,restaurantName));
            }
        }
    }

    public void clickMyCouponsViewOfRestaurant(String restaurantName){
        swipeUpToFindMyCouponsViewOfRestaurant(restaurantName).click();
    }

    public void clickMyCouponsViewOfRestaurantAllCouponsButton(String restaurantName){
        swipeUpToFindMyCouponsViewOfRestaurant(restaurantName);
        waitForElementByXpath(String.format(walletPage.allCouponsButtonXpath,restaurantName)).click();
    }
}
