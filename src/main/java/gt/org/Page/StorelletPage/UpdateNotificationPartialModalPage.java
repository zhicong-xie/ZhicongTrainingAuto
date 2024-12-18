package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateNotificationPartialModalPage {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public UpdateNotificationPartialModalPage() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//*[contains(@text , 'Storellet 提提你')]")
  public WebElement updateNotificationPartialModalTitle;

  @FindBy(xpath = "//*[contains(@text , 'Close Message')]")
  public WebElement closeButton;

  @FindBy(xpath = "//*[contains(@text , '立即更新')]")
  public WebElement updateNowButton;
}
