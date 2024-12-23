package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.NewJoinGuidelinesFlow;
import gt.org.Flow.StorelletFlow.PromotionViewFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PromotionViewSteps {

    private PromotionViewFlow promotionViewFlow;

    public PromotionViewSteps() {
        promotionViewFlow = new PromotionViewFlow();
    }


    @Then("^the user in the Promotion view partial modal screen$")
    public void isPromotionViewDisplayed() {
        boolean expected = true;
        boolean actual = promotionViewFlow.isPromotionViewDisplayed();
        String reason = "the Promotion view partial modal screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click (Close|Check details) button in the Promotion view partial modal screen if exist$")
    public void clickButton(String buttonName) {
        if (promotionViewFlow.isPromotionViewDisplayed()) {
            switch (buttonName) {
                case "Close":
                    promotionViewFlow.clickCloseButton();
                    break;
                case "Update now":
                    promotionViewFlow.clickCheckDetailsButton();
                    break;
                default:
                    throw new IllegalArgumentException("Illegal Argument : " + buttonName);
            }
        }
    }
}
