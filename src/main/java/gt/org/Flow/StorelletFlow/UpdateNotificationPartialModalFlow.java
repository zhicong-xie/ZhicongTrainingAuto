package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.UpdateNotificationPartialModalPage;

public class UpdateNotificationPartialModalFlow extends AppiumHelpers {

    private UpdateNotificationPartialModalPage updateNotificationPartialModalPage;

    public UpdateNotificationPartialModalFlow() {
        updateNotificationPartialModalPage = new UpdateNotificationPartialModalPage();
    }

    public boolean isUpdateNotificationPartialModalTitleDisplayed() {
        return checkElement(updateNotificationPartialModalPage.updateNotificationPartialModalTitle, 20);
    }

    public void clickCloseButton() {
        waitForElementToClickable(updateNotificationPartialModalPage.closeButton).click();
    }

    public void clickUpdateNowButton() {
        waitForElementToClickable(updateNotificationPartialModalPage.updateNowButton).click();
    }
}
