package gt.org.Flow.FinancialTimesFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.FinancialTimesPage.LoginOptionPage;

public class LoginOptionFlow extends AppiumHelpers {

  private LoginOptionPage loginOptionPage;

  public LoginOptionFlow() {
    loginOptionPage = new LoginOptionPage();
  }

  public boolean isLoginOptionViewDisplayed() {
    return checkElement(loginOptionPage.loginOptionView, 300);
  }

  public void clickSubscribeTodayButton() {
    waitForSecond(3);
    waitForElementToClickable(loginOptionPage.subscribeTodayButton).click();
  }

  public void clickSignInButton() {
    waitForSecond(3);
    waitForElementToClickable(loginOptionPage.signInButton).click();
  }

  public void clickNotNowButton() {
    waitForSecond(3);
    waitForElementToClickable(loginOptionPage.notNowButton).click();
  }
}
