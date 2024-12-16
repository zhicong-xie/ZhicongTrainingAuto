package gt.org.Page.FinancialTimesPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOptionPage {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public LoginOptionPage() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//*[@text = 'Not now']/..")
  public WebElement loginOptionView;

  @FindBy(xpath = "//*[@text = 'Subscribe today']")
  public WebElement subscribeTodayButton;

  @FindBy(xpath = "//*[@text = 'Sign in']")
  public WebElement signInButton;

  @FindBy(xpath = "//*[@text = 'Not now']")
  public WebElement notNowButton;
}
