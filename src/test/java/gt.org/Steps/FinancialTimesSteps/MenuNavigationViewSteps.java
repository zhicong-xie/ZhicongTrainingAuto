package gt.org.Steps.FinancialTimesSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gt.org.Flow.FinancialTimesFlow.LoginOptionFlow;
import gt.org.Flow.FinancialTimesFlow.MenuNavigationViewFlow;
import org.junit.Assert;

public class MenuNavigationViewSteps {

  private MenuNavigationViewFlow menuNavigationViewFlow;

  public MenuNavigationViewSteps() {
    menuNavigationViewFlow = new MenuNavigationViewFlow();
  }

  @Then("^the user in the Menu navigation view$")
  public void inCookiesFtSites() {
    boolean expected = true;
    boolean actual = menuNavigationViewFlow.isSearchButtonDisplayed();
    String reason = "the Menu navigation view is not displayed";
    Assert.assertEquals(reason, expected, actual);
  }

  @When(
      "^the user click (Search|Login|Subscribe access|my FT|Notifications|Newsletters|News Feed) button in FT login option screen$")
  public void clickButtonInMenuNavigationView(String item) {
    switch (item) {
      case "Search":
        menuNavigationViewFlow.clickSearchButton();
        break;
      case "Login":
        menuNavigationViewFlow.clickLoginButton();
        break;
      case "Subscribe access":
        menuNavigationViewFlow.clickSubscribeAccessButton();
        break;
      case "my FT":
        menuNavigationViewFlow.clickMyFtButton();
        break;
      case "Notifications":
        menuNavigationViewFlow.clickNotificationsButton();
        break;
      case "Newsletters":
        menuNavigationViewFlow.clickNewslettersButton();
        break;
      case "News Feed)":
        menuNavigationViewFlow.clickNewsfeedButton();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + item);
    }
  }
}
