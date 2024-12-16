package gt.org.Steps;

import cucumber.api.java.en.When;
import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;

public class BaseSteps {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public BaseSteps() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
  }

  @When("^the user (reset|restart) the APP$")
  public void driverAction(String item) {
    switch (item) {
      case "reset":
        driver.resetApp();
        break;
      case "restart":
        driverManager.restartApp();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + item);
    }
  }
}
