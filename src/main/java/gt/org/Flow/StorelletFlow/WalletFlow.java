package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.UpdateNotificationPartialModalPage;
import gt.org.Page.StorelletPage.WalletPage;

public class WalletFlow extends AppiumHelpers {

    private WalletPage walletPage;

    public WalletFlow() {
        walletPage = new WalletPage();
    }

    public boolean isWalletTitlePageDisplayed() {
        return checkElement(walletPage.walletTitle);
    }
}
