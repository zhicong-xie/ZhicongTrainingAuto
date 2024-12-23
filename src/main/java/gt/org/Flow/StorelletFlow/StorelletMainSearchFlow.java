package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.StorelletMainSearchPage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StorelletMainSearchFlow extends AppiumHelpers {

    private StorelletMainSearchPage storelletMainSearchPage;

    public StorelletMainSearchFlow() {
        storelletMainSearchPage = new StorelletMainSearchPage();
    }

    public boolean isMainSearchBarDisplayed() {
        return checkElement(storelletMainSearchPage.searchBar);
    }

    public void inputSearchBar(String searchData) {
        waitForElement(storelletMainSearchPage.searchBar).click();
        waitForElement(storelletMainSearchPage.searchBar).sendKeys(searchData);
        dismissKeyboard();
    }

    public List<String> getSearchResult() {
        List<String> searchResult = new ArrayList<>();
        List<WebElement> headerElementList = waitForElementsById(storelletMainSearchPage.searchResultHeaderListId);
        List<WebElement> bodyElementList = waitForElementsById(storelletMainSearchPage.searchResultBodyListId);

        if (headerElementList.size() != bodyElementList.size()) {
            System.out.println("The lengths of the header list and body list are inconsistent");
        } else {
            for (int i = 0; i < headerElementList.size(); i++) {
                searchResult.add(headerElementList.get(i).getText().trim() + bodyElementList.get(i).getText().trim());
            }
            System.out.println("\nAll search result data : " + searchResult+"\n");
        }

        return searchResult;
    }

    public boolean isResultContainSearchData(String data) {
        List<String> searchResult = getSearchResult();
        for (String s : searchResult) {
            if (!s.contains(data)) {
                return false;
            }
        }
        return true;
    }

    public void clickSearchBarClearButton(){
        waitForElement(storelletMainSearchPage.searchBarClearButton).click();
        dismissKeyboard();
    }

    public void selectFirstSearchResultView(){
        waitForElement(storelletMainSearchPage.firstSearchResultView).click();
    }
}
