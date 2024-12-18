package gt.org.Steps.FinancialTimesSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.FinancialTimesFlow.StoriesDetailsFlow;
import org.testng.Assert;

public class StoriesDetailsSteps {

  private StoriesDetailsFlow storiesDetailsFlow;

  public StoriesDetailsSteps() {
    storiesDetailsFlow = new StoriesDetailsFlow();
  }

  @Then("^the user in the FT Stories details screen$")
  public void inCookiesFtSites() {
    boolean expected = true;
    boolean actual = storiesDetailsFlow.isStoriesDetailsScreenDisplayed();
    String reason = "the FT Stories details screen is not displayed";
    Assert.assertEquals(actual,expected,reason);
  }

  @Then("^the user able to (.*) text content in the FT Stories details screen$")
  public void checkTextContent(String textContent) {
    boolean expected = true;
    boolean actual = storiesDetailsFlow.checkTextContent(textContent);
    String reason = String.format("the %s text content is not displayed", textContent);
    Assert.assertEquals(actual,expected,reason);
  }

  @When("^the user click (Back|Share|Collection) in the FT Stories details screen$")
  public void clickButton(String buttonName) {
    switch (buttonName) {
      case "Back":
        storiesDetailsFlow.clickBackButton();
        break;
      case "Share":
        storiesDetailsFlow.clickShareButton();
        break;
      case "Collection":
        storiesDetailsFlow.clickCollectionButton();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + buttonName);
    }
  }
}
