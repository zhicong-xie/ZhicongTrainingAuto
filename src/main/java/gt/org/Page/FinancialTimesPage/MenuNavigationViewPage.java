package gt.org.Page.FinancialTimesPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuNavigationViewPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public MenuNavigationViewPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_card_view")
    public WebElement searchButton;

    @FindBy(id = "menu_login")
    public WebElement loginButton;

    @FindBy(id = "menu_subscribe")
    public WebElement subscribeAccessButton;

    @FindBy(id = "menu_myft")
    public WebElement myFtButton;

    @FindBy(id = "menu_notifications")
    public WebElement notificationsButton;

    @FindBy(id = "menu_newsletters")
    public WebElement newslettersButton;

    @FindBy(id = "menu_newsfeed")
    public WebElement newsfeedButton;
}
