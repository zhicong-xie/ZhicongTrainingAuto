package gt.org.Page.FinancialTimesPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoriesDetailsPage {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public StoriesDetailsPage() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//*[@content-desc=\"Top Stories\"]")
  public WebElement storiesDetailsTitle;

  @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Top Stories\"]")
  public WebElement backButton;

  @FindBy(id = "menu_save")
  public WebElement collectionButton;

  @FindBy(id = "menu_share")
  public WebElement shareButton;
}
