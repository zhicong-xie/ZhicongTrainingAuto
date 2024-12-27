package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.MembershipTermsAndConditionsFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MembershipTermsAndConditionsStep {

    private MembershipTermsAndConditionsFlow membershipTermsAndConditionsFlow;

    public MembershipTermsAndConditionsStep() {
        membershipTermsAndConditionsFlow = new MembershipTermsAndConditionsFlow();
    }

    @Then("^the user in the Membership terms and conditions screen$")
    public void isTermsAndConditionsTitleDisplayed() {
        boolean expected = true;
        boolean actual = membershipTermsAndConditionsFlow.isTermsAndConditionsTitleDisplayed();
        String reason = "the Membership terms and conditions screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to (see|not see) email input box in the Membership terms and conditions screen$")
    public void isEmailInputBoxDisplayed(String item) {
        boolean expected;
        boolean actual = membershipTermsAndConditionsFlow.isEmailInputBoxDisplayed();
        String reason;
        switch (item) {
            case "see":
                expected = true;
                reason = "the email input box is not displayed in Membership terms and conditions screen";
                break;
            case "not see":
                expected = false;
                reason = "the email input box is displayed in Membership terms and conditions screen";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see Agree button is (enabled|disabled) in the Membership terms and conditions screen$")
    public void isAgreeButtonClickable(String item) {
        boolean expected;
        boolean actual = membershipTermsAndConditionsFlow.isAgreeButtonClickable();
        String reason;
        switch (item) {
            case "enabled":
                expected = true;
                reason = "the Agree button is disabled in Membership terms and conditions screen";
                break;
            case "disabled":
                expected = false;
                reason = "the Agree button is enabled in Membership terms and conditions screen";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user input \"([^\"]*)\" in the Membership terms and conditions screen email address input box$")
    public void swipeToLeftClickNextButton(String emailAddress) {
        membershipTermsAndConditionsFlow.inputEmailAddress(emailAddress);
    }

    @When("^the user click (Agree|Disagree) button in the Membership terms and conditions screen$")
    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Agree":
                membershipTermsAndConditionsFlow.clickAgreeButton();
                break;
            case "Disagree":
                membershipTermsAndConditionsFlow.clickDisagreeButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
    }

    @When("^the user swipe up until Agree button is enabled in the Membership terms and conditions screen$")
    public void swipeUntilAgreeButtonEnabled() {
        membershipTermsAndConditionsFlow.swipeUntilAgreeButtonEnabled();
    }

    @Then("^the user in the Membership terms and conditions screen incorrect email format partial modal$")
    public void isIncorrectEmailFormatPartialModalTitleDisplayed() {
        boolean expected = true;
        boolean actual = membershipTermsAndConditionsFlow.isIncorrectEmailFormatPartialModalTitleDisplayed();
        String reason = "the Membership terms and conditions screen incorrect email format partial modal is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click Confirm button in the Membership terms and conditions screen incorrect email format partial modal$")
    public void clickIncorrectEmailFormatPartialModalConfirmButton() {
        membershipTermsAndConditionsFlow.clickIncorrectEmailFormatPartialModalConfirmButton();
    }
}
