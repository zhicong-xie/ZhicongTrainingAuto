package gt.org.Steps.FinancialTimesSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.FinancialTimesFlow.LoginOptionFlow;
import org.testng.Assert;

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
    Assert.assertEquals(actual,expected,reason);
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
