package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.ExplorePage;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class ExploreFlow extends AppiumHelpers {

    private ExplorePage explorePage;
    private AndroidDriver driver;
    private DriverManager driverManager;

    public ExploreFlow() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        explorePage = new ExplorePage();
    }

    public boolean isExploreSearchBarDisplayed(){
        return checkElement(explorePage.searchBar);
    }

    public void clickExploreSearchBarButton(){
        waitForElement(explorePage.searchBar).click();
    }

    public void swipeLeftClickRestaurantInNewArrivalsView(String restaurantName){
        while (true){
            if (!checkElementByXpath(String.format(explorePage.newArrivalsRestaurantName,restaurantName),3)){
                swipeElementFunction("left", explorePage.newArrivalsView, 3,1);
            }else {
                driver.findElement(By.xpath(String.format(explorePage.newArrivalsRestaurantName,restaurantName))).click();
                break;
            }
        }
    }

    public HashMap<String,String> getRestaurantInfoInAllRestaurantList(String restaurantName){
        HashMap<String ,String> restaurantInfo = new HashMap<>();
        while (true){
            if (!checkElementByXpath(String.format(explorePage.restaurantPointsXpath,restaurantName),3)){
                swipeFunction("up");
            }else {
                WebElement restaurantPoint = driver.findElement(By.xpath(String.format(explorePage.restaurantPointsXpath,restaurantName)));
                WebElement restaurantCoupons = driver.findElement(By.xpath(String.format(explorePage.restaurantCouponsXpath,restaurantName)));
                restaurantInfo.put("Point",restaurantPoint.getText().trim());
                restaurantInfo.put("Coupons",restaurantCoupons.getText().trim());
                return restaurantInfo;
            }
        }
    }

    public void ClickRestaurantBecomeMemberInAllRestaurantList(String restaurantName){
        while (true){
            if (!checkElementByXpath(String.format(explorePage.restaurantBecomeMember,restaurantName),3)){
                swipeFunction("up");
            }else {
               driver.findElement(By.xpath(String.format(explorePage.restaurantBecomeMember,restaurantName))).click();
               break;
            }
        }
    }
}
