package gt.org.Page.FinancialTimesPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationsPage {

  private DriverManager driverManager;
  private AndroidDriver driver;

  public NotificationsPage() {
    driverManager = DriverManager.getInstance();
    driver = driverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//*[@text = 'Notifications']")
  public WebElement notificationsScreenTitle;

  @FindBy(id = "master_switch")
  public WebElement switchButton;

  @FindBy(xpath = "//*[@text = 'Breaking news']/../..//android.widget.CheckBox")
  public WebElement breakingNewsCheckBox;

  @FindBy(xpath = "//*[@text = 'Highlights']/../..//android.widget.CheckBox")
  public WebElement highlightsCheckBox;

  @FindBy(xpath = "//*[@text = 'Recommended for you']/../..//android.widget.CheckBox")
  public WebElement recommendedForYouCheckBox;

  @FindBy(xpath = "//*[@text = 'Morning briefing']/../..//android.widget.CheckBox")
  public WebElement morningBriefingCheckBox;

  @FindBy(xpath = "//*[@text = 'myFT Instant Alerts']/../..//android.widget.CheckBox")
  public WebElement myFtInstantAlertsCheckBox;

  @FindBy(xpath = "//*[@text = 'FT News Briefing podcast']/../..//android.widget.CheckBox")
  public WebElement fTNewsBriefingPodcastCheckBox;

  @FindBy(xpath = "//*[@text = 'FT Weekend podcast']/../..//android.widget.CheckBox")
  public WebElement fTWeekendPodcastCheckBox;
}
