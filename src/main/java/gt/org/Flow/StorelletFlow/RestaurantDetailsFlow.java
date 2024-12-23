package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.RestaurantDetailsPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RestaurantDetailsFlow extends AppiumHelpers {

    private RestaurantDetailsPage restaurantDetailsPage;

    public RestaurantDetailsFlow() {
        restaurantDetailsPage = new RestaurantDetailsPage();
    }

    public boolean isRestaurantNameDisplayed() {
        return checkElement(restaurantDetailsPage.restaurantName);
    }

    public String getRestaurantName() {
        return waitForElement(restaurantDetailsPage.restaurantName).getText().trim();
    }

    public void clickBackButton() {
        waitForElementToClickable(restaurantDetailsPage.backButton).click();
    }

    public void clickNewJointButton() {
        waitForElementToClickable(restaurantDetailsPage.newJoinButton).click();
    }

    public void clickMoreDetailsButton() {
        waitForElementToClickable(restaurantDetailsPage.moreDetailsButton).click();
    }

    public void clickShowAllShopsButton() {
        waitForElementToClickable(restaurantDetailsPage.showAllShopsButton).click();
    }

    public boolean isNewJoinButtonDisplayed() {
        return checkElement(restaurantDetailsPage.newJoinButton, 5);
    }

    public boolean isMoreDetailsButtonDisplayed() {
        return checkElement(restaurantDetailsPage.moreDetailsButton, 5);
    }

    public String getRestaurantPoints() {
        return waitForElement(restaurantDetailsPage.restaurantPoints).getText().replace("積分", "").trim();
    }

    public boolean isRestaurantPointsDisplayed(){
        return checkElement(restaurantDetailsPage.restaurantPoints,5);
    }

    public void clickButtonInMainBar(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "summary":
                waitForElementToClickable(restaurantDetailsPage.summaryButton).click();
                break;
            case "wallet":
                waitForElementToClickable(restaurantDetailsPage.walletButton).click();
                break;
            case "redeem":
                waitForElementToClickable(restaurantDetailsPage.redeemButton).click();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
    }

    public boolean getButtonStateInMainBar(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "summary":
                return waitForElementToClickable(restaurantDetailsPage.summaryButton).isSelected();
            case "wallet":
                return waitForElementToClickable(restaurantDetailsPage.walletButton).isSelected();
            case "redeem":
                return waitForElementToClickable(restaurantDetailsPage.redeemButton).isSelected();
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
    }

    public String getRestaurantCouponsListSize() {
        List<WebElement> couponDescriptionList = waitForElementsByXpath(restaurantDetailsPage.restaurantCouponDescriptionListXpath);
        List<WebElement> tipsList = waitForElementsByXpath(restaurantDetailsPage.restaurantCouponTipsListXpath);

        if (couponDescriptionList.size() == tipsList.size()) {
            for (int i = 0; i < couponDescriptionList.size(); i++) {
                System.out.println(couponDescriptionList.get(i).getText() + " : " + tipsList.get(i).getText());
            }
            return couponDescriptionList.size()+"";
        } else {
            return "-1";
        }
    }
}
