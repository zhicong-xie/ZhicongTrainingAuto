package gt.org.Steps.StorelletSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.StorelletFlow.StorelletIntroductionFlow;
import org.testng.Assert;

public class StorelletIntroductionSteps {

  private StorelletIntroductionFlow storelletIntroductionFlow;

  public StorelletIntroductionSteps() {
    storelletIntroductionFlow = new StorelletIntroductionFlow();
  }

    @Then("^the user in the Storellet introduction screen$")
    public void isStorelletIntroductionFootBarDisplayed() {
        boolean expected = true;
        boolean actual = storelletIntroductionFlow.isStorelletIntroductionFootBarDisplayed();
        String reason = "the Storellet introduction screen is not displayed";
        Assert.assertEquals(actual,expected,reason);
    }

    @When("^the user swipe to left click next button in the Storellet introduction screen$")
    public void swipeToLeftClickNextButton() {
        storelletIntroductionFlow.swipeToLeftClickNextButton();
    }
}
