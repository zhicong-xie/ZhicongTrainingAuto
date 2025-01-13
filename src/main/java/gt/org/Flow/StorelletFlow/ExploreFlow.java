package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.ExplorePage;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class ExploreFlow extends AppiumHelpers {

    private ExplorePage explorePage;
    private AndroidDriver driver;
    private DriverManager driverManager;

    public ExploreFlow() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        explorePage = new ExplorePage();
    }

    public boolean isExploreRestaurantViewDisplayed() {
        waitForSecond(2);
        return checkElement(explorePage.restaurantView);
    }

    public void clickExploreSearchBarButton() {
        waitForElement(explorePage.searchBar).click();
    }

    public void swipeLeftClickRestaurantInNewArrivalsView(String restaurantName) {
        String lastRestaurantName = waitForElementByXpath(explorePage.newArrivalsLastRestaurantNameListXpath).getText();
        while (true) {
            if (!checkElementByXpath(String.format(explorePage.newArrivalsRestaurantName, restaurantName), 1)) {
                swipeElementFunction("left", explorePage.newArrivalsView, 1, 1);
                String lastRestaurantNameAfterSwipe = waitForElementByXpath(explorePage.newArrivalsLastRestaurantNameListXpath).getText();
                if (lastRestaurantName.equals(lastRestaurantNameAfterSwipe)) {
                    throw new NoSuchElementException("Restaurant not found: " + restaurantName);
                } else {
                    lastRestaurantName = lastRestaurantNameAfterSwipe;
                }
            } else {
                driver.findElement(By.xpath(String.format(explorePage.newArrivalsRestaurantName, restaurantName))).click();
                break;
            }
        }
    }

    public HashMap<String, String> getMemberRestaurantInfoAndClick(String restaurantName) {
        HashMap<String, String> restaurantInfo = new HashMap<>();
        String lastRestaurantName = waitForElementByXpath(explorePage.allRestaurantViewLastNameXpath).getText();
        while (true) {
            if (!checkElementByXpath(String.format(explorePage.restaurantPointsXpath, restaurantName), 1)) {
                swipeFunction("up");
                String lastRestaurantNameAfterSwipe = waitForElementByXpath(explorePage.allRestaurantViewLastNameXpath).getText();
                if (lastRestaurantName.equals(lastRestaurantNameAfterSwipe)) {
                    throw new NoSuchElementException("Restaurant not found: " + restaurantName);
                } else {
                    lastRestaurantName = lastRestaurantNameAfterSwipe;
                }
            } else {
                WebElement restaurantPoint = driver.findElement(By.xpath(String.format(explorePage.restaurantPointsXpath, restaurantName)));
                WebElement restaurantCoupons = driver.findElement(By.xpath(String.format(explorePage.restaurantCouponsXpath, restaurantName)));
                restaurantInfo.put("points", restaurantPoint.getText().trim());
                restaurantInfo.put("coupons", restaurantCoupons.getText().trim());
                System.out.println(String.format("%s info : %s", restaurantName, restaurantInfo) + "\n");
                restaurantPoint.click();
                return restaurantInfo;
            }
        }
    }

    public void clickBecomeMemberButton() {
        String lastRestaurantName = waitForElementByXpath(explorePage.allRestaurantViewLastNameXpath).getText();
        while (true) {
            if (!checkElement(explorePage.becomeMemberButton, 1)) {
                swipeFunction("up");
                String lastRestaurantNameAfterSwipe = waitForElementByXpath(explorePage.allRestaurantViewLastNameXpath).getText();

                if (lastRestaurantName.equals(lastRestaurantNameAfterSwipe)) {
                    throw new NoSuchElementException("Become member button not found");
                } else {
                    lastRestaurantName = lastRestaurantNameAfterSwipe;
                }
            } else {
                explorePage.becomeMemberButton.click();
                break;
            }
        }

    }
}
