package gt.org.Flow.FinancialTimesFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.FinancialTimesPage.TopStoriesPage;

public class TopStoriesFlow extends AppiumHelpers {

  private TopStoriesPage topStoriesPage;

  public TopStoriesFlow() {
    topStoriesPage = new TopStoriesPage();
  }

  public boolean isTopStoriesScreenDisplayed() {
    return checkElement(topStoriesPage.menuNavigationButton, 300);
  }

  public void selectStories(String storiesName) throws Exception {
    swipeToUpFindWebElementXpath(elementTextXpathString(storiesName), 8, 15).click();
  }

  public void clickMenuNavigationButton() {
    waitForElementToClickable(topStoriesPage.menuNavigationButton).click();
  }
}
