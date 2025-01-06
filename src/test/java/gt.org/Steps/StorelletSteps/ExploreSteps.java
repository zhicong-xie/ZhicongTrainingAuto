package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.ExploreFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ExploreSteps {

    private ExploreFlow exploreFlow;

    public ExploreSteps() {
        exploreFlow = new ExploreFlow();
    }

    @Then("^the user in the Storellet explore screen$")
    public void isExploreSearchBarDisplayed() {
        boolean expected = true;
        boolean actual = exploreFlow.isExploreRestaurantViewDisplayed();
        String reason = "the Storellet explore screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click Search bar in the Storellet explore screen$")
    public void clickExploreSearchBarButton() {
        exploreFlow.clickExploreSearchBarButton();
    }

    @When("^the user swipe left to click \"([^\"]*)\" restaurant name in the Storellet explore screen new arrivals view$")
    public void swipeLeftClickRestaurantInNewArrivalsView(String restaurantName) {
        exploreFlow.swipeLeftClickRestaurantInNewArrivalsView(restaurantName);
    }

    @When("^the user click Become Member button in the Storellet explore screen$")
    public void clickBecomeMemberButton() {
        exploreFlow.clickBecomeMemberButton();
    }
}
