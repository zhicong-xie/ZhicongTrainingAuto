package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.SettingFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SettingSteps {

    private SettingFlow settingFlow;

    public SettingSteps() {
        settingFlow = new SettingFlow();
    }

    @Then("^the user in the Profile setting screen$")
    public void isSettingPageTitleDisplayed() {
        boolean expected = true;
        boolean actual = settingFlow.isSettingPageTitleDisplayed();
        String reason = "the Profile setting screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click (Back|Logout) button in the Profile setting screen$")
    public void clickButton(String item) {
        switch (item){
            case "Back":
                settingFlow.clickBackButton();
                break;
            case "Logout":
                settingFlow.clickLogoutButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }

    @Then("^the user in the Confirm logout partial modal screen$")
    public void isConfirmLogoutPartialModalTitleDisplayed() {
        boolean expected = true;
        boolean actual = settingFlow. isConfirmLogoutPartialModalTitleDisplayed();
        String reason = "the Confirm logout partial modal screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click (Cancel|Logout) button in the Confirm logout partial modal screen$")
    public void clickButton2(String item) {
        switch (item){
            case "Cancel":
                settingFlow.clickConfirmLogoutPartialModalCancelButton();
                break;
            case "Logout":
                settingFlow.clickConfirmLogoutPartialModalLogoutButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }
}
