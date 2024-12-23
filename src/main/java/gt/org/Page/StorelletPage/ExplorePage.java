package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public ExplorePage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fragment_membership_tab_all_search_view")
    public WebElement searchBar;

    @FindBy(id = "search_close_btn")
    public WebElement searchBarClearButton;
}
