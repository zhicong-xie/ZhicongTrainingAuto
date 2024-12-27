package gt.org.Steps.FinancialTimesSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.FinancialTimesFlow.NotificationsFlow;
import org.testng.Assert;

public class NotificationsSteps {

    private NotificationsFlow notificationsFlow;

    public NotificationsSteps() {
        notificationsFlow = new NotificationsFlow();
    }

    @Then("^the user in the Notifications screen$")
    public void inCookiesFtSites() {
        boolean expected = true;
        boolean actual = notificationsFlow.isNotificationsScreenTitleDisplayed();
        String reason = "the Notifications screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user turn on switch button in the Notifications screen if is off state$")
    public void turnOnSwitchButton() {
        notificationsFlow.turnOnSwitchButton();
    }

    @Then(
            "^the user able to see (.*) check box status is (checked|not checked) in the Notifications screen$")
    public void verificationCheckbox(String item, String status) {
        String expected;
        String actual = notificationsFlow.getCheckBoxStatus(item);
        String reason;
        switch (status) {
            case "checked":
                expected = "true";
                reason = String.format("the %s checkbox is not checked", item);
                break;
            case "not checked":
                expected = "false";
                reason = String.format("the %s checkbox is checked", item);
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click (.*) check box in the Notifications screen$")
    public void isSearchHistoryDisplayed(String item) {
        notificationsFlow.clickCheckBox(item);
    }
}
