package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.VerificationSentPartialModalFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class VerificationSentPartialModalSteps {

    private VerificationSentPartialModalFlow verificationSentPartialModalFlow;

    public VerificationSentPartialModalSteps() {
        verificationSentPartialModalFlow = new VerificationSentPartialModalFlow();
    }

    @Then("^the user in the Verification sent partial modal screen$")
    public void isVerificationSentPartialModalTitleDisplayed() {
        boolean expected = true;
        boolean actual = verificationSentPartialModalFlow.isVerificationSentPartialModalTitleDisplayed();
        String reason = "the Verification sent partial modal screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see email address field displayed \"([^\"]*)\" in the Verification sent partial modal screen$")
    public void checkVerificationSentPartialModalEmailAddressField(String expected) {
        String actual = verificationSentPartialModalFlow.getVerificationSentPartialModalEmailAddressField();
        String reason = String.format("the email address displayed wrong; expected : %s;actual : %s", expected, actual);
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase(), reason);
    }

    @When("^the user click Done button in the Verification sent partial modal screen$")
    public void clickVerificationSentPartialModalDoneButton() {
        verificationSentPartialModalFlow.clickVerificationSentPartialModalDoneButton();
    }
}
