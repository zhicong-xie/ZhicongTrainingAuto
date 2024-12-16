package gt.org.Page.FinancialTimesPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesOnFtSitesPage {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public CookiesOnFtSitesPage() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//*[@text = 'Cookies on FT Sites']")
  public WebElement currentPageTitle;

  @FindBy(xpath = "//*[@text = 'Manage Cookies']")
  public WebElement manageCookiesButton;

  @FindBy(xpath = "//*[@text = 'Accept Cookies']")
  public WebElement acceptCookiesButton;
}
