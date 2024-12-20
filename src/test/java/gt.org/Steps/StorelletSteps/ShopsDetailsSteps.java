package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.NavigationDialogFragmentFlow;
import gt.org.Flow.StorelletFlow.ShopsDetailsFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ShopsDetailsSteps {

    private ShopsDetailsFlow shopsDetailsFlow;

    public ShopsDetailsSteps() {
        shopsDetailsFlow = new ShopsDetailsFlow();
    }

    @Then("^the user in the Storellet shops details screen$")
    public void isShopNameDisplayed() {
        boolean expected = true;
        boolean actual = shopsDetailsFlow.isShopNameDisplayed();
        String reason = "the Storellet shops details screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see shops name displayed (.*) in the Storellet shops details screen$")
    public void checkShopName(String expected) {
        String actual = shopsDetailsFlow.getShopName();
        String reason = String.format("the shops name displayed wrong; expected : %s; actual: %s", expected, actual);
        Assert.assertEquals(actual.contains(expected), true, reason);
    }

    @When("^the user click (Back|New join|More details) button in the Storellet shops details screen$")
    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Back":
                shopsDetailsFlow.clickBackButton();
                break;
            case "New join":
                shopsDetailsFlow.clickNewJointButton();
                break;
            case "More details":
                shopsDetailsFlow.clickMoreDetailsButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
    }

    @Then("^the user able to (see|not see) (New join|More details) button in the Storellet shops details screen$")
    public void checkButton(String item, String buttonName) {
        boolean expected;
        boolean actual;
        String reason;
        switch (item) {
            case "see":
                expected = true;
                reason = String.format("the %s button is not displayed", buttonName);
                break;
            case "not see":
                expected = false;
                reason = String.format("the %s button is displayed", buttonName);
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        switch (buttonName) {
            case "New join":
                actual = shopsDetailsFlow.isNewJoinButtonDisplayed();
                break;
            case "More details":
                actual = shopsDetailsFlow.isMoreDetailsButtonDisplayed();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
        Assert.assertEquals(actual, expected, reason);
    }
}
