package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.NavigationDialogFragmentPage;

public class NavigationDialogFragmentFlow extends AppiumHelpers {

    private NavigationDialogFragmentPage navigationDialogFragmentPage;

    public NavigationDialogFragmentFlow() {
        navigationDialogFragmentPage = new NavigationDialogFragmentPage();
    }

    public boolean isNavigationDialogFragmentViewDisplayed(Integer time) {
        return checkElement(navigationDialogFragmentPage.navigationDialogFragmentView, time);
    }

    public void clickExploreBubble() {
        waitForElementToClickable(navigationDialogFragmentPage.navigationDialogFragmentExploreBubble).click();
    }

    public void clickMembershipBubble() {
        waitForElementToClickable(navigationDialogFragmentPage.navigationDialogFragmentMembershipBubble).click();
    }

    public void clickWalletBubble() {
        waitForElementToClickable(navigationDialogFragmentPage.navigationDialogFragmentWalletBubble).click();
    }

    public void clickProfileBubble() {
        waitForElementToClickable(navigationDialogFragmentPage.navigationDialogFragmentProfileBubble).click();
    }

    public void clickScannerBubble() {
        waitForElementToClickable(navigationDialogFragmentPage.navigationDialogFragmentScannerBubble).click();
    }

    public void clickNoticeBubble() {
        waitForElementToClickable(navigationDialogFragmentPage.navigationDialogFragmentNoticeBubble).click();
    }
}
