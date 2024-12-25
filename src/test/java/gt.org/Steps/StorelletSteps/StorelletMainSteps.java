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
        boolean actual = storelletMainFlow.isStorelletMainSearchIconDisplayed();
        String reason = "the Storellet main screen is not displayed";
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

    @When("^the user save the Storellet main screen big promotion image to local folder$")
    public void saveBigPromotionImageToLocalFolder() throws IOException {
       storelletMainFlow.saveBigPromotionImageToLocalFolder();
    }

    @When("^the user select \"([^\"]*)\" restaurant in the Storellet main screen$")
    public void selectrestaurant(String info) {
        storelletMainFlow.selectrestaurant(info);
    }
}
