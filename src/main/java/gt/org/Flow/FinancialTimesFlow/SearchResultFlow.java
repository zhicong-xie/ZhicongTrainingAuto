package gt.org.Flow.FinancialTimesFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.FinancialTimesPage.MenuNavigationViewPage;
import gt.org.Page.FinancialTimesPage.SearchResultPage;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchResultFlow extends AppiumHelpers {

  private SearchResultPage searchResultPage;

  public SearchResultFlow() {
    searchResultPage = new SearchResultPage();
  }

  public boolean isSearchResultPageDefaultTitleDisplayed() {
    return checkElement(searchResultPage.searchInputBoxDefaultTitle);
  }

  public boolean isAfterInputSearchResultTitleDisplayed() {
    return checkElement(searchResultPage.searchInputBox);
  }

  public void clickBackButton() {
    waitForElementToClickable(searchResultPage.backButton).click();
  }

  public void clickVoiceInputButton() {
    waitForElementToClickable(searchResultPage.voiceInputButton).click();
  }

  public void clickClearInputBoxButtonButton() {
    waitForElementToClickable(searchResultPage.clearInputBoxButton).click();
  }

  public void inputSearchTextInInputBox(String data) {
    waitForElementToClickable(searchResultPage.searchInputBox).click();
    waitForElement(searchResultPage.searchInputBox).sendKeys(data);
    //        dismissKeyboard(); NOT WORKING
    coordinateClick(1172, 2595);
  }

  public void selectFirstSearchResult() {
    waitForElementToClickable(searchResultPage.searchResultTime).click();
  }

  public void selectFirstSearchHistory() {
    waitForElementToClickable(searchResultPage.searchHistoryView).click();
  }

  public boolean isSearchHistoryDisplayed() {
    return checkElement(searchResultPage.searchHistoryView, 3);
  }

  public boolean isSearchResultDisplayed() {
    return checkElement(searchResultPage.searchResultTime);
  }

  public LinkedHashMap<String, String> getSearchResultData() {
    LinkedHashMap<String, String> searchResultData = new LinkedHashMap<>();
    waitForElement(searchResultPage.searchResultTime);
    List<WebElement> describeList = searchResultPage.searchResultDescribeList;
    List<WebElement> detailsList = searchResultPage.searchResultDetailsList;
    for (int i = 0; i < describeList.size(); i++) {
      searchResultData.put(
          describeList.get(i).getText().trim(), detailsList.get(i).getText().trim());
    }
    return searchResultData;
  }
}
