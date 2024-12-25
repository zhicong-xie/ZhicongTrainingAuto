package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.WalletFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WalletSteps {

    private WalletFlow walletFlow;

    public WalletSteps() {
        walletFlow = new WalletFlow();
    }

    @Then("^the user in the Storellet wallet screen$")
    public void isWalletTitlePageDisplayed() {
        boolean expected = true;
        boolean actual = walletFlow.isWalletIdentificationDisplayed();
        String reason = "the Storellet wallet screen not displayed";
        Assert.assertEquals(actual,expected,reason);
    }

    @When("^the user click (Redemption center|Show all restaurant) button in the Storellet wallet screen my membership view$")
    public void clickButton(String item) {
        switch (item){
            case "Redemption center":
                walletFlow.clickRedemptionCenterButton();
                break;
            case "Show all restaurant":
                walletFlow.clickShowAllRestaurantButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }

    @When("^the user swipe to left find and click \"([^\"]*)\" Membership restaurant name in the Storellet wallet screen my membership view$")
    public void swipeLeftFindMembershipRestaurantAndClick(String membershipName) {
        walletFlow.swipeLeftFindMembershipRestaurantAndClick(membershipName);
    }

    @When("^the user swipe to up find and click \"([^\"]*)\" Membership restaurant name in the Storellet wallet screen my membership expand view$")
    public void swipeUpFindMembershipRestaurantAndClick(String membershipName) {
        walletFlow.swipeUpFindMembershipRestaurantAndClick(membershipName);
    }

    @When("^the user swipe to up find \"([^\"]*)\" restaurant name in the Storellet wallet screen My coupons view$")
    public void swipeUpToFindMyCouponsViewOfRestaurant(String membershipName) {
        walletFlow.swipeUpToFindMyCouponsViewOfRestaurant(membershipName);
    }

    @When("^the user swipe to up find and click \"([^\"]*)\" restaurant name in the Storellet wallet screen My coupons view$")
    public void clickMyCouponsViewOfRestaurant(String membershipName) {
        walletFlow.clickMyCouponsViewOfRestaurant(membershipName);
    }

    @When("^the user swipe to up find and click \"([^\"]*)\" restaurant show all coupons button in the Storellet wallet screen My coupons view$")
    public void clickMyCouponsViewOfRestaurantAllCouponsButton(String membershipName) {
        walletFlow.clickMyCouponsViewOfRestaurantAllCouponsButton(membershipName);
    }

    @When("^the user swipe to left find and click \"([^\"]*)\" coupons (describe|expiration) button in the Storellet wallet screen My coupons \"([^\"]*)\" restaurant view$")
    public void clickMyCouponsViewOfRestaurantCoupons(String couponsData, String item , String restaurantName) {
        switch (item){
            case "describe":
                walletFlow.clickMyCouponsViewOfRestaurantCouponsDescribe(restaurantName, couponsData);
                break;
            case "expiration":
                walletFlow.clickMyCouponsViewOfRestaurantCouponsExpiration(restaurantName, couponsData);
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }

}
