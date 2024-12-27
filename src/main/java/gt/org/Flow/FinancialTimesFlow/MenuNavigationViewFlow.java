package gt.org.Flow.FinancialTimesFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.FinancialTimesPage.MenuNavigationViewPage;
import gt.org.Page.FinancialTimesPage.StoriesDetailsPage;

public class MenuNavigationViewFlow extends AppiumHelpers {

    private MenuNavigationViewPage menuNavigationViewPage;

    public MenuNavigationViewFlow() {
        menuNavigationViewPage = new MenuNavigationViewPage();
    }

    public boolean isSearchButtonDisplayed() {
        return checkElement(menuNavigationViewPage.searchButton);
    }

    public void clickSearchButton() {
        waitForElementToClickable(menuNavigationViewPage.searchButton).click();
    }

    public void clickLoginButton() {
        waitForElementToClickable(menuNavigationViewPage.loginButton).click();
    }

    public void clickSubscribeAccessButton() {
        waitForElementToClickable(menuNavigationViewPage.subscribeAccessButton).click();
    }

    public void clickMyFtButton() {
        waitForElementToClickable(menuNavigationViewPage.myFtButton).click();
    }

    public void clickNotificationsButton() {
        waitForElementToClickable(menuNavigationViewPage.notificationsButton).click();
    }

    public void clickNewslettersButton() {
        waitForElementToClickable(menuNavigationViewPage.newslettersButton).click();
    }

    public void clickNewsfeedButton() {
        waitForElementToClickable(menuNavigationViewPage.newsfeedButton).click();
    }
}
