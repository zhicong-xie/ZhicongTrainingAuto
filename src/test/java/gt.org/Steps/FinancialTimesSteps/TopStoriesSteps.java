package gt.org.Steps.FinancialTimesSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.FinancialTimesFlow.TopStoriesFlow;
import org.testng.Assert;

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
        Assert.assertEquals(actual, expected, reason);
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
