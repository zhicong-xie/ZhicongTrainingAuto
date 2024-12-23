package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.RestaurantDetailsPage;

public class RestaurantDetailsFlow extends AppiumHelpers {

    private RestaurantDetailsPage restaurantDetailsPage;

    public RestaurantDetailsFlow() {
        restaurantDetailsPage = new RestaurantDetailsPage();
    }

    public boolean isRestaurantNameDisplayed(){
        return checkElement(restaurantDetailsPage.restaurantName);
    }

    public String getRestaurantName(){
        return waitForElement(restaurantDetailsPage.restaurantName).getText().trim();
    }

    public void clickBackButton(){
        waitForElementToClickable(restaurantDetailsPage.backButton).click();
    }

    public void clickNewJointButton(){
        waitForElementToClickable(restaurantDetailsPage.newJoinButton).click();
    }

    public void clickMoreDetailsButton(){
        waitForElementToClickable(restaurantDetailsPage.moreDetailsButton).click();
    }

    public boolean isNewJoinButtonDisplayed(){
        return checkElement(restaurantDetailsPage.newJoinButton,5);
    }

    public boolean isMoreDetailsButtonDisplayed(){
        return checkElement(restaurantDetailsPage.moreDetailsButton,5);
    }
}
