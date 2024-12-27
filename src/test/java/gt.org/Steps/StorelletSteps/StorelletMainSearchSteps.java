package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.StorelletMainSearchFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StorelletMainSearchSteps {

    private StorelletMainSearchFlow storelletMainSearchFlow;

    public StorelletMainSearchSteps() {
        storelletMainSearchFlow = new StorelletMainSearchFlow();
    }

    @Then("^the user in the Storellet main search screen$")
    public void isMainSearchBarDisplayed() {
        boolean expected = true;
        boolean actual = storelletMainSearchFlow.isMainSearchBarDisplayed();
        String reason = "the Storellet introduction screen is not displayed";
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user input \"([^\"]*)\" in the Storellet main search screen Search bar$")
    public void isMainSearchBarDisplayed(String data) {
        storelletMainSearchFlow.inputSearchBar(data);
    }

    @Then("^the Search result is contain \"([^\"]*)\" data in the Storellet main search screen$")
    public void isResultContainSearchData(String data) {
        boolean expected = true;
        boolean actual = storelletMainSearchFlow.isResultContainSearchData(data);
        String reason = String.format("the Search result is not contain \"([^\"]*)\" data in the Storellet main search screen", data);
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click Search bar clear button in the Storellet main search screen$")
    public void clickSearchBarClearButton() {
        storelletMainSearchFlow.clickSearchBarClearButton();
    }

    @When("^the user select first search result view in the Storellet main search screen$")
    public void selectFirstSearchResultView() {
        storelletMainSearchFlow.selectFirstSearchResultView();
    }
}
