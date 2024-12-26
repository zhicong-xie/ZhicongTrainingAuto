package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.SettingPage;

public class SettingFlow extends AppiumHelpers {

    private SettingPage settingPage;

    public SettingFlow() {
        settingPage = new SettingPage();
    }

    public boolean isSettingPageTitleDisplayed() {
        return checkElement(settingPage.settingPageTitle);
    }

    public void clickBackButton() {
        waitForElementToClickable(settingPage.backButton).click();
    }

    public void clickLogoutButton() {
        waitForElementToClickable(settingPage.logoutButton).click();
    }

    public boolean isConfirmLogoutPartialModalTitleDisplayed(){
        return checkElement(settingPage.confirmLogoutPartialModalTitle);
    }

    public void clickConfirmLogoutPartialModalCancelButton() {
        waitForElementToClickable(settingPage.confirmLogoutPartialModalCancelBtn).click();
    }

    public void clickConfirmLogoutPartialModalLogoutButton() {
        waitForElementToClickable(settingPage.confirmLogoutPartialModalLogoutBtn).click();
    }

}
