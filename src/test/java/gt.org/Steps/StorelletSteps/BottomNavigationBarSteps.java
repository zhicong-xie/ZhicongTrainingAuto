package gt.org.Steps.StorelletSteps;

import io.cucumber.java.en.When;
import gt.org.Flow.StorelletFlow.BottomNavigationBarFlow;

public class BottomNavigationBarSteps {

  private BottomNavigationBarFlow bottomNavigationBarFlow;

  public BottomNavigationBarSteps() {
    bottomNavigationBarFlow = new BottomNavigationBarFlow();
  }

  @When(
      "^the user click (Home|Explore|Scan|Wallet|Profile) button in the Storellet bottom navigation bar$")
  public void clickButton(String item) {
    switch (item) {
      case "Home":
        bottomNavigationBarFlow.clickHomeButton();
        break;
      case "Explore":
        bottomNavigationBarFlow.clickExploreButton();
        break;
      case "Scan":
        bottomNavigationBarFlow.clickScanButton();
        break;
      case "Wallet":
        bottomNavigationBarFlow.clickWalletButton();
        break;
      case "Profile":
        bottomNavigationBarFlow.clickProfileButton();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + item);
    }
  }
}
