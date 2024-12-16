package gt.org.Steps.FinancialTimesSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gt.org.Flow.FinancialTimesFlow.TopStoriesFlow;
import org.junit.Assert;

public class TopStoriesSteps {

  private TopStoriesFlow topStoriesFlow;

  public TopStoriesSteps() {
    topStoriesFlow = new TopStoriesFlow();
  }

  @Then("^the user in the FT Top Stories screen$")
  public void inCookiesFtSites() {
    boolean expected = true;
    boolean actual = topStoriesFlow.isTopStoriesScreenDisplayed();
    String reason = "the FT Top Stories screen is not displayed";
    Assert.assertEquals(reason, expected, actual);
  }

  @When("^the user select (.*) stories in the FT Top Stories screen$")
  public void selectStories(String storiesName) throws Exception {
    topStoriesFlow.selectStories(storiesName);
  }

  @When("^the user click Menu navigation button in the FT Top Stories screen$")
  public void selectStories() {
    topStoriesFlow.clickMenuNavigationButton();
  }
}
