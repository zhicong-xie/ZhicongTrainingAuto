package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.UpdateEmailAddressPartialModalFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UpdateEmailAddressPartialModalSteps {

    private UpdateEmailAddressPartialModalFlow updateEmailAddressPartialModalFlow;

    public UpdateEmailAddressPartialModalSteps() {
        updateEmailAddressPartialModalFlow = new UpdateEmailAddressPartialModalFlow();
    }

    @Then("^the user in the Update email address partial modal screen$")
    public void isrestaurantNameDisplayed() {
        boolean expected = true;
        boolean actual = updateEmailAddressPartialModalFlow.isUpdateEmailAddressPartialModalTitle();
        String reason = "the Update email address partial modal screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see email address field displayed (.*) in the Update email address partial modal screen$")
    public void swipeToLeftClickNextButton(String expected) {
        String actual = updateEmailAddressPartialModalFlow.getEmailAddressField();
        String reason = String.format("the email address field displayed wrong; expected : %s; actual : %s", expected, actual);
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase(), reason);
    }

    @When("^the user input (.*) in the Update email address partial modal screen email address input box$")
    public void inputEmailAddress(String emailAddress) {
        updateEmailAddressPartialModalFlow.inputEmailAddress(emailAddress);
    }

    @Then("^the user able to see Update button is (enabled|disabled) in the Update email address partial modal screen$")
    public void isUpdateButtonClickable(String item) {
        boolean expected;
        boolean actual = updateEmailAddressPartialModalFlow.isUpdateButtonClickable();
        String reason;
        switch (item) {
            case "enabled":
                expected = true;
                reason = "the Update button is disabled in the Update email address partial modal screen";
                break;
            case "disabled":
                expected = false;
                reason = "the Update button is enabled in the Update email address partial modal screen";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click Update button in the Update email address partial modal screen email address input box$")
    public void clickUpdateButton() {
        updateEmailAddressPartialModalFlow.clickUpdateButton();
    }
}
