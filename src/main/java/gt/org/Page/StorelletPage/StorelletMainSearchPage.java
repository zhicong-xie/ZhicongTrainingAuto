package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorelletMainSearchPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public StorelletMainSearchPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "search_src_text")
    public WebElement searchBar;

    public String searchResultHeaderListId = "item_search_result_header";

    public String searchResultBodyListId = "item_search_result_body";

    @FindBy(id = "search_close_btn")
    public WebElement searchBarClearButton;

    @FindBy(id = "item_search_result_container")
    public WebElement firstSearchResultView;
}
