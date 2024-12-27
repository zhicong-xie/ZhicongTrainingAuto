package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.VerifyEmailAddressPartialModalFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class VerifyEmailAddressPartialModalSteps {

    private VerifyEmailAddressPartialModalFlow verifyEmailAddressPartialModalFlow;

    public VerifyEmailAddressPartialModalSteps() {
        verifyEmailAddressPartialModalFlow = new VerifyEmailAddressPartialModalFlow();
    }

    @Then("^the user in the Verify email address partial modal screen$")
    public void isVerifyEmailAddressPartialModalTitleDisplayed() {
        boolean expected = true;
        boolean actual = verifyEmailAddressPartialModalFlow.isVerifyEmailAddressPartialModalTitleDisplayed();
        String reason = "the Verify email address partial modal screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see email address field displayed \"([^\"]*)\" in the Verify email address partial modal screen$")
    public void checkEmailField(String expected) {
        String actual = verifyEmailAddressPartialModalFlow.getEmailField();
        String reason = String.format("the email address field displayed wrong; expected : %s;actual :%s", expected, actual);
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase(), reason);
    }

    @When("^the user click (Verification send|Change email address|Ignore) button in the Verify email address partial modal screen$")
    public void clickButton(String item) {
        switch (item) {
            case "Verification send":
                verifyEmailAddressPartialModalFlow.clickVerificationSendButton();
                break;
            case "Change email address":
                verifyEmailAddressPartialModalFlow.clickChangeEmailAddressButton();
                break;
            case "Ignore":
                verifyEmailAddressPartialModalFlow.clickIgnoreButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }
}
