package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.NewJoinGuidelinesFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NewJoinGuidelinesSteps {

    private NewJoinGuidelinesFlow newJoinGuidelinesFlow;

    public NewJoinGuidelinesSteps() {
        newJoinGuidelinesFlow = new NewJoinGuidelinesFlow();
    }

    @Then("^the user able to (see|not see) the New join guidelines screen$")
    public void isNewJoinGuidelinesTitleDisplayed(String item) {
        boolean expected;
        boolean actual = newJoinGuidelinesFlow.isNewJoinGuidelinesTitleDisplayed();
        String reason;
        switch (item) {
            case "see":
                expected = true;
                reason = "the New join guidelines screen is not displayed";
                break;
            case "not see":
                expected = false;
                reason = "the New join guidelines screen is displayed";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click Skip button in the New join guidelines screen if exist$")
    public void clickSkipButton() {
        newJoinGuidelinesFlow.clickSkipButton();
    }
}
