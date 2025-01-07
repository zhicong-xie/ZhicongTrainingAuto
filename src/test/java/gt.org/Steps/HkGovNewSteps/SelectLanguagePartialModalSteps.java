package gt.org.Steps.HkGovNewSteps;

import gt.org.Flow.HkGovNewFlow.SelectLanguagePartialModalFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SelectLanguagePartialModalSteps {

    private SelectLanguagePartialModalFlow selectLanguagePartialModalFlow;

    public SelectLanguagePartialModalSteps() {
        selectLanguagePartialModalFlow = new SelectLanguagePartialModalFlow();
    }

    @Then("^the user in the HK Gov New Select language partial modal screen$")
    public void isSelectLanguagePartialModalTitleDisplayed() {
        boolean expected = true;
        boolean actual = selectLanguagePartialModalFlow.isSelectLanguagePartialModalTitleDisplayed();
        String reason = "the HK Gov New Select language partial modal screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click (English|Traditional chinese|Simplified chinese) button in the HK Gov New Select language partial modal screen$")
    public void clickButton(String item) {
        switch (item) {
            case "English":
                selectLanguagePartialModalFlow.clickEnglishButton();
                break;
            case "Traditional chinese":
                selectLanguagePartialModalFlow.clickTraditionalChineseButton();
                break;
            case "Simplified chinese":
                selectLanguagePartialModalFlow.clickSimplifiedChineseButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }
}
