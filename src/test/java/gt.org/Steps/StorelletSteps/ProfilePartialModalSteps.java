package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.ProfilePartialModalFlow;
import gt.org.Flow.StorelletFlow.PromotionViewFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProfilePartialModalSteps {

    private ProfilePartialModalFlow profilePartialModalFlow;

    public ProfilePartialModalSteps() {
        profilePartialModalFlow = new ProfilePartialModalFlow();
    }

    @Then("^the user in the Profile partial modal screen$")
    public void isProfilePartialModalTitleDisplayed() {
        boolean expected = true;
        boolean actual = profilePartialModalFlow.isProfilePartialModalTitleDisplayed();
        String reason = "the Profile partial modal screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see profile name field displayed \"([^\"]*)\" in the Profile partial modal screen$")
    public void checkProfileNameDisplayedNormal(String expected) {
        String actual = profilePartialModalFlow.getProfilePartialModalName();
        String reason = String.format("the profile name displayed wrong, expected: %s, actual: %s ",expected,actual);
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see QR code view displayed in the Profile partial modal screen$")
    public void isQrCodeViewDisplayed() {
        boolean expected = true;
        boolean actual = profilePartialModalFlow.isQrCodeViewDisplayed();
        String reason = "the QR code view is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click Setting button in the Profile partial modal screen$")
    public void clickSettingButton() {
        profilePartialModalFlow.clickSettingButton();
    }
}
