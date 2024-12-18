package gt.org.Steps.StorelletSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.StorelletFlow.StorelletMainFlow;
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
        boolean actual = storelletMainFlow.isStorelletMainTitleDisplayed();
        String reason = "the Storellet introduction screen is not displayed";
        Assert.assertEquals(actual,expected,reason);
    }

    @When("^the user click (Redemption center button|Search icon|Notice icon) in the Storellet main screen$")
    public void clickButton(String item) {
        switch (item){
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

    @Then("^the first big promotion image is not null in the Storellet main screen$")
    public void isFirstBigPromotionImageNotNull() throws IOException {
        boolean expected = true;
        boolean actual = storelletMainFlow.isFirstBigPromotionImageNotNull();
        String reason = "the big promotion image is null in the Storellet main screen";
        Assert.assertEquals(actual,expected,reason);
    }

    @When("^the user save the Storellet main screen first big promotion image to local folder$")
    public void saveFirstBigPromotionImageToLocalFolder() throws IOException {
       storelletMainFlow.saveFirstBigPromotionImageToLocalFolder();
    }
}
