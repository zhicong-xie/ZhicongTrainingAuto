package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.NavigationDialogFragmentPage;
import gt.org.Page.StorelletPage.UpdateEmailAddressPartialModalPage;

public class UpdateEmailAddressPartialModalFlow extends AppiumHelpers {
    private UpdateEmailAddressPartialModalPage updateEmailAddressPartialModalPage;

    public UpdateEmailAddressPartialModalFlow() {
        updateEmailAddressPartialModalPage = new UpdateEmailAddressPartialModalPage();
    }

    public boolean isUpdateEmailAddressPartialModalTitle(){
        return checkElement(updateEmailAddressPartialModalPage.updateEmailAddressPartialModalTitle);
    }

    public String getEmailAddressField(){
      return  waitForElement(updateEmailAddressPartialModalPage.emailAddressInputBox).getText().trim();
    }

    public void inputEmailAddress(String emailAddress){
        waitForElement(updateEmailAddressPartialModalPage.emailAddressInputBox).click();
        waitForElement(updateEmailAddressPartialModalPage.emailAddressInputBox).sendKeys(emailAddress);
        dismissKeyboard();
    }

    public boolean isUpdateButtonClickable(){
        return checkElementClickable(updateEmailAddressPartialModalPage.updateButton,3);
    }

    public void clickUpdateButton(){
        waitForElementToClickable(updateEmailAddressPartialModalPage.updateButton).click();
    }
}
