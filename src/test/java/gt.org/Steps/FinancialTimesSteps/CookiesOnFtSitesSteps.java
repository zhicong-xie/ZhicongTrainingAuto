package gt.org.Steps.FinancialTimesSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gt.org.Flow.FinancialTimesFlow.CookiesOnFtSitesFlow;
import org.junit.Assert;

public class CookiesOnFtSitesSteps {

  private CookiesOnFtSitesFlow cookiesOnFtSitesFlow;

  public CookiesOnFtSitesSteps() {
    cookiesOnFtSitesFlow = new CookiesOnFtSitesFlow();
  }

  @Then("^the user in the Cookies on FT sites screen$")
  public void inCookiesFtSites() {
    boolean expected = true;
    boolean actual = cookiesOnFtSitesFlow.isCookiesOnFtSitesTitleDisplayed();
    String reason = "the Cookies on FT sites screen is not displayed";
    Assert.assertEquals(reason, expected, actual);
  }

  @When("^the user click (Manage Cookies|Accept Cookies) button in the Cookies on FT sites screen$")
  public void clickButtonInCookiesFtSites(String item) {
    switch (item) {
      case "Manage Cookies":
        cookiesOnFtSitesFlow.clickManageCookiesButton();
        break;
      case "Accept Cookies":
        cookiesOnFtSitesFlow.clickAcceptCookiesButton();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + item);
    }
  }
}
