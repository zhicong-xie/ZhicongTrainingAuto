package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.ProfilePartialModalPage;

public class ProfilePartialModalFlow extends AppiumHelpers {

    private ProfilePartialModalPage profilePartialModalPage;

    public ProfilePartialModalFlow() {
        profilePartialModalPage = new ProfilePartialModalPage();
    }

    public boolean isProfilePartialModalTitleDisplayed() {
        return checkElement(profilePartialModalPage.profilePartialModalTitle);
    }

    public String getProfilePartialModalName() {
        return waitForElement(profilePartialModalPage.profileNameField).getText().replaceAll("您好，我是", "").trim();
    }

    public void clickSettingButton() {
        waitForElementToClickable(profilePartialModalPage.settingButton).click();
    }

    public boolean isQrCodeViewDisplayed() {
        return checkElement(profilePartialModalPage.qrCodeView);
    }
}
