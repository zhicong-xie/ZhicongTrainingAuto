package gt.org.Steps.StorelletSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.StorelletFlow.UpdateNotificationPartialModalFlow;
import org.testng.Assert;

public class UpdateNotificationPartialModalSteps {

    private UpdateNotificationPartialModalFlow updateNotificationPartialModalFlow;

    public UpdateNotificationPartialModalSteps() {
        updateNotificationPartialModalFlow = new UpdateNotificationPartialModalFlow();
    }

    @Then("^the user in the Update notification partial modal screen$")
    public void isUpdateNotificationPartialModalTitleDisplayed() {
        boolean expected = true;
        boolean actual = updateNotificationPartialModalFlow.isUpdateNotificationPartialModalTitleDisplayed();
        String reason = "the Update notification partial modal screen not displayed";
        Assert.assertEquals(actual,expected,reason);
    }

    @When("^the user click (Close|Update now) button in the Update notification partial modal screen if exist$")
    public void clickButton(String buttonName) {
        if (updateNotificationPartialModalFlow.isUpdateNotificationPartialModalTitleDisplayed()){
            switch (buttonName){
                case "Close":
                    updateNotificationPartialModalFlow.clickCloseButton();
                    break;
                case "Update now":
                    updateNotificationPartialModalFlow.clickUpdateNowButton();
                    break;
                default:
                    throw new IllegalArgumentException("Illegal Argument : " + buttonName);
            }
        }
    }


}
