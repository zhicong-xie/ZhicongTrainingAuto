package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.VerificationSentPartialModalPage;

public class VerificationSentPartialModalFlow extends AppiumHelpers {

    private VerificationSentPartialModalPage verificationSentPartialModalPage;

    public VerificationSentPartialModalFlow() {
        verificationSentPartialModalPage = new VerificationSentPartialModalPage();
    }

    public boolean isVerificationSentPartialModalTitleDisplayed() {
        return checkElement(verificationSentPartialModalPage.verificationSentPartialModalTitle);
    }

    public String getVerificationSentPartialModalEmailAddressField() {
        return waitForElement(verificationSentPartialModalPage.verificationSentPartialModalEmailAddressField).getText().trim();
    }

    public void clickVerificationSentPartialModalDoneButton() {
        waitForElementToClickable(verificationSentPartialModalPage.verificationSentPartialModalDoneButton).click();
    }
}
