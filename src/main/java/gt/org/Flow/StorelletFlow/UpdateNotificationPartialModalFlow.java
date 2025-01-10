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
        if (checkElement(updateNotificationPartialModalPage.updateNotificationPartialModalTitle, 5)) {
            waitForElementToClickable(updateNotificationPartialModalPage.closeButton).click();
        }
    }

    public void closeUpdateNotificationPartialModal(int waitTime) {
        if (checkElement(updateNotificationPartialModalPage.updateNotificationPartialModalTitle, waitTime)) {
            System.out.println("----------------   Appium Event Listener   -----------------\nUpdate notification partial modal screen displayed...");
            System.out.println("Click close button...");
            waitForElementToClickable(updateNotificationPartialModalPage.closeButton).click();
        }
    }

    public void clickUpdateNowButton() {
        if (checkElement(updateNotificationPartialModalPage.updateNotificationPartialModalTitle, 5)) {
            waitForElementToClickable(updateNotificationPartialModalPage.updateNowButton).click();
        }
    }
}
