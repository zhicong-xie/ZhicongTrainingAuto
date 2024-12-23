package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.RestaurantDetailsFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RestaurantDetailsSteps {

    private RestaurantDetailsFlow restaurantDetailsFlow;

    public RestaurantDetailsSteps() {
        restaurantDetailsFlow = new RestaurantDetailsFlow();
    }

    @Then("^the user in the Storellet restaurant details screen$")
    public void isRestaurantNameDisplayed() {
        boolean expected = true;
        boolean actual = restaurantDetailsFlow.isRestaurantNameDisplayed();
        String reason = "the Storellet restaurant details screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see restaurant name displayed (.*) in the Storellet restaurant details screen$")
    public void checkRestaurantName(String expected) {
        String actual = restaurantDetailsFlow.getRestaurantName();
        String reason = String.format("the restaurant name displayed wrong; expected : %s; actual: %s", expected, actual);
        Assert.assertEquals(actual.contains(expected), true, reason);
    }

    @When("^the user click (Back|New join|More details) button in the Storellet restaurant details screen$")
    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Back":
                restaurantDetailsFlow.clickBackButton();
                break;
            case "New join":
                restaurantDetailsFlow.clickNewJointButton();
                break;
            case "More details":
                restaurantDetailsFlow.clickMoreDetailsButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
    }

    @Then("^the user able to (see|not see) (New join|More details) button in the Storellet restaurant details screen$")
    public void checkButton(String item, String buttonName) {
        boolean expected;
        boolean actual;
        String reason;
        switch (item) {
            case "see":
                expected = true;
                reason = String.format("the %s button is not displayed", buttonName);
                break;
            case "not see":
                expected = false;
                reason = String.format("the %s button is displayed", buttonName);
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        switch (buttonName) {
            case "New join":
                actual = restaurantDetailsFlow.isNewJoinButtonDisplayed();
                break;
            case "More details":
                actual = restaurantDetailsFlow.isMoreDetailsButtonDisplayed();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
        Assert.assertEquals(actual, expected, reason);
    }
}
