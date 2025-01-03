package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.VerifyEmailAddressPartialModalPage;

public class VerifyEmailAddressPartialModalFlow extends AppiumHelpers {

    private VerifyEmailAddressPartialModalPage verifyEmailAddressPartialModalPage;

    public VerifyEmailAddressPartialModalFlow() {
        verifyEmailAddressPartialModalPage = new VerifyEmailAddressPartialModalPage();
    }

    public boolean isVerifyEmailAddressPartialModalTitleDisplayed() {
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

    public void clickIgnoreButton() {
        waitForElementToClickable(verifyEmailAddressPartialModalPage.ignoreButton).click();
    }
}
