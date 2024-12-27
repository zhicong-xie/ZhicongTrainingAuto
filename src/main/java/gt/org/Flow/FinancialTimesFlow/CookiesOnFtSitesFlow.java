package gt.org.Flow.FinancialTimesFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.FinancialTimesPage.CookiesOnFtSitesPage;

public class CookiesOnFtSitesFlow extends AppiumHelpers {

    private CookiesOnFtSitesPage cookiesOnFtSitesPage;

    public CookiesOnFtSitesFlow() {
        cookiesOnFtSitesPage = new CookiesOnFtSitesPage();
    }

    public boolean isCookiesOnFtSitesTitleDisplayed() {
        return checkElement(cookiesOnFtSitesPage.currentPageTitle, 300);
    }

    public void clickManageCookiesButton() {
        waitForElementToClickable(cookiesOnFtSitesPage.manageCookiesButton).click();
    }

    public void clickAcceptCookiesButton() {
        waitForElementToClickable(cookiesOnFtSitesPage.acceptCookiesButton).click();
    }
}
