package gt.org.Steps.FinancialTimesSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gt.org.Flow.FinancialTimesFlow.LoginOptionFlow;
import org.junit.Assert;

public class LoginOptionSteps {

  private LoginOptionFlow loginOptionFlow;

  public LoginOptionSteps() {
    loginOptionFlow = new LoginOptionFlow();
  }

  @Then("^the user in the FT login option screen$")
  public void inCookiesFtSites() {
    boolean expected = true;
    boolean actual = loginOptionFlow.isLoginOptionViewDisplayed();
    String reason = "the FT login option screen is not displayed";
    Assert.assertEquals(reason, expected, actual);
  }

  @When("^the user click (Subscribe today|Sign in|Not now) button in FT login option screen$")
  public void clickButtonInCookiesFtSites(String item) {
    switch (item) {
      case "Subscribe today":
        loginOptionFlow.clickSubscribeTodayButton();
        break;
      case "Sign in":
        loginOptionFlow.clickSignInButton();
        break;
      case "Not now":
        loginOptionFlow.clickNotNowButton();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + item);
    }
  }
}
