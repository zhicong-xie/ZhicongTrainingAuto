package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.LoginPage;

public class LoginFlow extends AppiumHelpers {


    private LoginPage loginPage;

    public LoginFlow() {
        loginPage = new LoginPage();
    }

    public boolean isLoginTitleDisplayed(){
        return checkElement(loginPage.loginTitle);
    }

    public void clickSettingButton(){
        waitForElementToClickable(loginPage.settingButton).click();
    }

    public void clickInternationalAreaCodeButton(){
        waitForElementToClickable(loginPage.internationalAreaCodeButton).click();
    }

    public void selectInternationalAreaCode (String internationalAreaCode){
        findElementByText(internationalAreaCode).click();
    }

    public boolean isSelectAreaCodeTitleDisplayed(){
        return checkElement(loginPage.selectAreaCodeTitle);
    }

    public void inputPhoneNumber (String phoneNumber){
        waitForElement(loginPage.phoneNumberInputBox).sendKeys(phoneNumber);
    }

    public void inputPassword (String password){
        waitForElement(loginPage.passwordInputBox).sendKeys(password);
    }

    public void clickForgetPasswordButton(){
        waitForElementToClickable(loginPage.forgetPasswordButton).click();
    }

    public void clickConfirmButton(){
        waitForElementToClickable(loginPage.confirmButton).click();
    }

    public void clickCreateProfileButton(){
        waitForElementToClickable(loginPage.createProfileButton).click();
    }

    public String getInternationalAreaCode(){
        return waitForElement(loginPage.internationalAreaCodeButton).getText().trim();
    }

    public boolean isIncorrectInformationTitleDisplayed(){
        return checkElement(loginPage.incorrectInformationTitle);
    }

    public void clickIncorrectInformationConfirmButton(){
        waitForElementToClickable(loginPage.incorrectInformationConfirmButton).click();
    }
}
