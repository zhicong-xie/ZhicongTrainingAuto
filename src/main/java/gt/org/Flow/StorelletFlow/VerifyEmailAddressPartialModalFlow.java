package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.VerifyEmailAddressPartialModalPage;

public class VerifyEmailAddressPartialModalFlow extends AppiumHelpers {

    private VerifyEmailAddressPartialModalPage verifyEmailAddressPartialModalPage;

    public VerifyEmailAddressPartialModalFlow() {
        verifyEmailAddressPartialModalPage = new VerifyEmailAddressPartialModalPage();
    }

    public boolean isVerifyEmailAddressPartialModalTitleDisplayed() {
        waitForSecond(3);
        return checkElement(verifyEmailAddressPartialModalPage.verifyEmailAddressPartialModalTitle);
    }

    public String getEmailField() {
        return waitForElement(verifyEmailAddressPartialModalPage.emailAddressField).getText().trim();
    }

    public void clickVerificationSendButton() {
        waitForElementToClickable(verifyEmailAddressPartialModalPage.verificationSendButton).click();
    }

    public void clickChangeEmailAddressButton() {
        waitForElementToClickable(verifyEmailAddressPartialModalPage.changeEmailButton).click();
    }

    public void closeEmailAddressPartialModalPage(int waitTime) {
        if (checkElement(verifyEmailAddressPartialModalPage.verifyEmailAddressPartialModalTitle, waitTime)) {
            System.out.println("Email address partial modal screen displayed");
            System.out.println("Close Ignore points screen ...");
            waitForElementToClickable(verifyEmailAddressPartialModalPage.ignoreButton).click();
        }
    }

    public void clickIgnoreButton() {
        waitForElementToClickable(verifyEmailAddressPartialModalPage.ignoreButton).click();
    }
}
