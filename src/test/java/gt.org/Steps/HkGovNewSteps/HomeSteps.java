package gt.org.Steps.HkGovNewSteps;

import gt.org.Flow.HkGovNewFlow.HomeFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import org.testng.Assert;

import java.io.IOException;

public class HomeSteps {

    private HomeFlow homeFlow;

    public HomeSteps() {
        homeFlow = new HomeFlow();
    }

    @Then("^the user in the HK Gov New Home screen$")
    public void isHomePageTopBarDisplayed() {
        boolean expected = true;
        boolean actual = homeFlow.isHomePageIdentificationDisplayed();
        String reason = "the HK Gov New Home screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see Top bar view Home button Image contains \"([^\"]*)\" in the HK Gov New Home screen$")
    public void isHomePageTopBarDisplayed(String expected) throws TesseractException, IOException {
        String actual = homeFlow.getTopBarHomeButtonImageText();
        String reason = String.format("the Tor bar view Home button image actual text is %s, but expected text is %s", actual, expected);
        Assert.assertEquals(actual.contains(expected), true, reason);
    }

    @Then("^the user able to (not see|see) Top bar view Home button Image is consistent with local images in the HK Gov New Home screen$")
    public void isTopBarViewHomeButtonConsistentWithLocalImages(String item) throws IOException {
        boolean expected;
        boolean actual = homeFlow.isTopBarViewHomeButtonConsistentWithLocalImages();
        String reason;
        switch (item) {
            case "see":
                expected = true;
                reason = "tTop bar view Home button Image is not consistent with local images";
                break;
            case "not see":
                expected = false;
                reason = "Top bar view Home button Image is consistent with local images";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user swipe to bottom in the HK Gov New Home screen$")
    public void swipeToBottom() {
        homeFlow.swipeToBottom();
    }
}
