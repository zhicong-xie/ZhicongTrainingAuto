package gt.org.Page.FinancialTimesPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public SearchResultPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@text = 'Search']")
    public WebElement searchInputBoxDefaultTitle;

    @FindBy(id = "fsv_search_action_navigation")
    public WebElement backButton;

    @FindBy(id = "fsv_search_action_menu")
    public WebElement voiceInputButton;

    @FindBy(id = "text")
    public WebElement searchHistoryView;

    @FindBy(id = "clear")
    public WebElement clearInputBoxButton;

    @FindBy(id = "fsv_search_text")
    public WebElement searchInputBox;

    @FindBy(id = "time")
    public WebElement searchResultTime;

    @FindBy(id = "title")
    public List<WebElement> searchResultDescribeList;

    @FindBy(id = "snippet")
    public List<WebElement> searchResultDetailsList;
}
