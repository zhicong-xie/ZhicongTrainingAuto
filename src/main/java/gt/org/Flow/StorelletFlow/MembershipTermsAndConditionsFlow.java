package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.MembershipTermsAndConditionsPage;

public class MembershipTermsAndConditionsFlow extends AppiumHelpers {

    private MembershipTermsAndConditionsPage membershipTermsAndConditionsPage;

    public MembershipTermsAndConditionsFlow() {
        membershipTermsAndConditionsPage = new MembershipTermsAndConditionsPage();
    }

    public boolean isTermsAndConditionsTitleDisplayed() {
        return checkElement(membershipTermsAndConditionsPage.termsAndConditionsTitle);
    }

    public boolean isEmailInputBoxDisplayed() {
        return checkElement(membershipTermsAndConditionsPage.emailInputBox, 5);
    }

    public void inputEmailAddress(String email) {
        waitForElement(membershipTermsAndConditionsPage.emailInputBox).click();
        waitForElement(membershipTermsAndConditionsPage.emailInputBox).sendKeys(email);
        dismissKeyboard();
    }

    public void inputEmailAddressIfExist(String email) {
        if (isEmailInputBoxDisplayed()) {
            waitForElement(membershipTermsAndConditionsPage.emailInputBox).click();
            waitForElement(membershipTermsAndConditionsPage.emailInputBox).sendKeys(email);
            dismissKeyboard();
        }
    }

    public boolean isAgreeButtonClickable() {
        return checkElementClickable(membershipTermsAndConditionsPage.agreeButton, 3);
    }

    public void clickAgreeButton() {
        waitForElementToClickable(membershipTermsAndConditionsPage.agreeButton).click();
    }

    public void clickDisagreeButton() {
        waitForElementToClickable(membershipTermsAndConditionsPage.disagreeButton).click();
    }

    public void swipeUntilAgreeButtonEnabled() {
        while (true) {
            if (!isAgreeButtonClickable()) {
                swipeFunction("up");
            } else {
                break;
            }
        }
    }

    public boolean isIncorrectEmailFormatPartialModalTitleDisplayed() {
        return checkElement(membershipTermsAndConditionsPage.incorrectEmailFormatPartialModalTitle, 5);
    }

    public void clickIncorrectEmailFormatPartialModalConfirmButton() {
        waitForElementToClickable(membershipTermsAndConditionsPage.incorrectEmailFormatPartialModalConfirmButton).click();
    }
}
