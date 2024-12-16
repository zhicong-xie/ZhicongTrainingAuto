package gt.org.Page.FinancialTimesPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopStoriesPage {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public TopStoriesPage() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Front page\"]")
  public WebElement menuNavigationButton;
}
