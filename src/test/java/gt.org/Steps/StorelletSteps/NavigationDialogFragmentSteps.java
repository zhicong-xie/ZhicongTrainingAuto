package gt.org.Steps.StorelletSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.StorelletFlow.NavigationDialogFragmentFlow;
import org.testng.Assert;

public class NavigationDialogFragmentSteps {

    private NavigationDialogFragmentFlow navigationDialogFragmentFlow;

    public NavigationDialogFragmentSteps() {
        navigationDialogFragmentFlow = new NavigationDialogFragmentFlow();
    }

    @Then("^the user able to (see|not see) the Storellet navigation dialog fragment view$")
    public void isNavigationDialogFragmentViewDisplayed(String item) {
        boolean expected;
        boolean actual;
        String reason;
        switch (item) {
            case "see":
                expected = true;
                actual = navigationDialogFragmentFlow.isNavigationDialogFragmentViewDisplayed(30);
                reason = "the Storellet navigation dialog fragment view is not displayed";
                break;
            case "not see":
                expected = false;
                actual = navigationDialogFragmentFlow.isNavigationDialogFragmentViewDisplayed(3);
                reason = "the Storellet navigation dialog fragment view is displayed";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @When(
            "^the user click (Explore|Membership|Wallet|Profile|Scanner|Notice) bubble in the Storellet navigation dialog fragment view$")
    public void clickBubble(String item) {
        switch (item) {
            case "Explore":
                navigationDialogFragmentFlow.clickExploreBubble();
                break;
            case "Membership":
                navigationDialogFragmentFlow.clickMembershipBubble();
                break;
            case "Wallet":
                navigationDialogFragmentFlow.clickWalletBubble();
                break;
            case "Profile":
                navigationDialogFragmentFlow.clickProfileBubble();
                break;
            case "Scanner":
                navigationDialogFragmentFlow.clickScannerBubble();
                break;
            case "Notice":
                navigationDialogFragmentFlow.clickNoticeBubble();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }
}
