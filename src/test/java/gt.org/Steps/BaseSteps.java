package gt.org.Steps;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.When;

public class BaseSteps {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public BaseSteps() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
  }

  @When("^the user (restart|quit) the APP$")
  public void driverAction(String item) {
    switch (item) {
      case "restart":
        driverManager.restartApp();
        break;
      case "quit":
        driverManager.quitApp();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + item);
    }
  }

  @When("^the user dismiss keyboard$")
  public void dismissKeyboard() {
    driver.hideKeyboard();
  }

  @When("^the user click navigate back button$")
  public void navigateBack() {
    driver.navigate().back();
  }
}
