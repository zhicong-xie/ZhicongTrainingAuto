package gt.org.Steps.FinancialTimesSteps;

import gt.org.Flow.FinancialTimesFlow.SearchResultFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.LinkedHashMap;

public class SearchResultSteps {

    private SearchResultFlow searchResultFlow;

    public SearchResultSteps() {
        searchResultFlow = new SearchResultFlow();
    }

    @Then("^the user in the Search result (default|after input) screen$")
    public void isSearchResultScreen(String item) {
        boolean expected = true;
        boolean actual;
        String reason = String.format("the %s is not displayed", item);
        switch (item) {
            case "default":
                actual = searchResultFlow.isSearchResultPageDefaultTitleDisplayed();
                break;
            case "after input":
                actual = searchResultFlow.isAfterInputSearchResultTitleDisplayed();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to (see|not see) search history in the Search result screen$")
    public void isSearchHistoryDisplayed(String item) {
        boolean expected;
        boolean actual = searchResultFlow.isSearchHistoryDisplayed();
        String reason;
        switch (item) {
            case "see":
                expected = true;
                reason = "the search history is not displayed";
                break;
            case "not see":
                expected = false;
                reason = "the search history is displayed";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to (see|not see) search result in the Search result screen$")
    public void isSearchResultDisplayed(String item) {
        boolean expected;
        boolean actual = searchResultFlow.isSearchResultDisplayed();
        String reason;
        switch (item) {
            case "see":
                expected = true;
                reason = "the search result is not displayed";
                break;
            case "not see":
                expected = false;
                reason = "the search result is displayed";
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @When("^the user click (Back|Voice input|Clear input box) in the Search result screen$")
    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Back":
                searchResultFlow.clickBackButton();
                break;
            case "Voice input":
                searchResultFlow.clickVoiceInputButton();
                break;
            case "Clear input box":
                searchResultFlow.clickClearInputBoxButtonButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + buttonName);
        }
    }

    @When("^the user input (.*) in the Search result screen Search input box$")
    public void inputSearchBar(String searchData) {
        searchResultFlow.inputSearchTextInInputBox(searchData);
    }

    @When("^the user select first search (result|history) in the Search result screen$")
    public void selectFirstOption(String item) {
        switch (item) {
            case "result":
                searchResultFlow.selectFirstSearchResult();
                break;
            case "history":
                searchResultFlow.selectFirstSearchHistory();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }

    @Then("^the user verification search result contains (.*) in the Search result screen$")
    public void verificationResult(String searchData) {
        boolean expected = true;
        boolean actual = true;
        String reason = "";
        LinkedHashMap<String, String> result = searchResultFlow.getSearchResultData();
        System.out.println("actual result : " + result + "\n");
        for (String key : result.keySet()) {
            if (!(key.toLowerCase().contains(searchData.toLowerCase())
                    || result.get(key).toLowerCase().contains(searchData.toLowerCase()))) {
                System.out.println("incorrect describe : " + key + "\n");
                System.out.println("incorrect details : " + result.get(key) + "\n");
                actual = false;
                reason =
                        String.format(
                                "Search result incorrect:\n expected search data :%s \n actual describe : %s\nactual details : %s",
                                searchData, key, result.get(key));
                break;
            }
        }
        Assert.assertEquals(actual, expected, reason);
    }
}
