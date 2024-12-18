package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.BottomNavigationBarPage;
import gt.org.Page.StorelletPage.NavigationDialogFragmentPage;

public class BottomNavigationBarFlow extends AppiumHelpers {

    private BottomNavigationBarPage bottomNavigationBarPage;

    public BottomNavigationBarFlow() {
        bottomNavigationBarPage = new BottomNavigationBarPage();
    }

    public void clickHomeButton(){
        waitForElementToClickable(bottomNavigationBarPage.homeButton).click();
    }

    public void clickExploreButton(){
        waitForElementToClickable(bottomNavigationBarPage.exploreButton).click();
    }

    public void clickScanButton(){
        waitForElementToClickable(bottomNavigationBarPage.scanButton).click();
    }

    public void clickWalletButton(){
        waitForElementToClickable(bottomNavigationBarPage.walletButton).click();
    }

    public void clickProfileButton(){
        waitForElementToClickable(bottomNavigationBarPage.profileButton).click();
    }
}
