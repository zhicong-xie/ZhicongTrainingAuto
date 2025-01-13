package gt.org.Steps.StorelletSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.StorelletFlow.StorelletMainFlow;
import net.sourceforge.tess4j.TesseractException;
import org.testng.Assert;

import java.io.IOException;

public class StorelletMainSteps {

    private StorelletMainFlow storelletMainFlow;

    public StorelletMainSteps() {
        storelletMainFlow = new StorelletMainFlow();
    }

    @Then("^the user in the Storellet main screen$")
    public void isStorelletMainTitleDisplayed() {
        boolean expected = true;
        boolean actual = storelletMainFlow.isStorelletMainSearchIconDisplayed();
        String reason = "the Storellet main screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click (Redemption center button|Search icon|Notice icon) in the Storellet main screen$")
    public void clickButton(String item) {
        switch (item) {
            case "Redemption center button":
                storelletMainFlow.clickRedemptionCenterButton();
                break;
            case "Search icon":
                storelletMainFlow.clickSearchIcon();
                break;
            case "Notice icon":
                storelletMainFlow.clickNoticeIcon();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }

    @When("^the user save the Storellet main screen big promotion image to local folder$")
    public void saveBigPromotionImageToLocalFolder() throws IOException {
        storelletMainFlow.saveBigPromotionImageToLocalFolder();
    }

    @When("^the user select \"([^\"]*)\" restaurant in the Storellet main screen$")
    public void selectrestaurant(String info) {
        storelletMainFlow.selectRestaurant(info);
    }

    @When("^the user click Join button in the Storellet main screen$")
    public void clickJoinButton() {
        storelletMainFlow.clickJoinButton();
    }

    @Then("^the user able to see First big promotion image text contains \"([^\"]*)\" in the Storellet main screen$")
    public void getFirstBigPromotionImageText(String expected) throws TesseractException, IOException {
        String actual = storelletMainFlow.getFirstBigPromotionImageText();
        String reason = String.format("the First big promotion image text displayed wrong; expected : %s, actual : %s", expected, actual);
        Assert.assertEquals(actual.contains(expected), true, reason);
    }

    @Then("^the user able to see First big promotion image consistent with local images$")
    public void verifyFirstBigPromotionImage() {
        boolean expected = true;
        boolean actual = storelletMainFlow.isFirstBigPromotionImageConsistentWithLocalImages();
        String reason = "the Storellet main screen first big promotion image not consistent with local images,Please see image compare.";
        Assert.assertEquals(actual, expected, reason);
    }
}
