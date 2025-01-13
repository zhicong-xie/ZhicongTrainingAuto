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

    @FindBy(id = "item_merchant_row_container")
    public WebElement restaurantView;

    @FindBy(id = "fragment_membership_tab_all_search_view")
    public WebElement searchBar;

    @FindBy(id = "item_recycler_view_retry_rv")
    public WebElement newArrivalsView;

    public String newArrivalsLastRestaurantNameListXpath = "(//*[@resource-id = 'com.storellet:id/item_large_image_landscape_header'])[last()]";

    public String newArrivalsRestaurantName = "//*[contains(@resource-id, 'item_recycler_view_retry_rv')]//android.widget.TextView[contains(@text , '%s')]";

    public String restaurantPointsXpath = "//*[contains(@resource-id , 'item_merchant_row_title_tv') and contains(@text , '%s')]/..//*[contains(@resource-id , 'item_merchant_row_value1_txt')]";

    public String restaurantCouponsXpath = "//*[contains(@resource-id , 'item_merchant_row_title_tv') and contains(@text , '%s')]/..//*[contains(@resource-id , 'item_merchant_row_value2_txt')]";

    public String allRestaurantViewLastNameXpath = "(//*[@resource-id = 'com.storellet:id/item_merchant_row_title_tv'])[last()]";

    @FindBy(id = "com.storellet:id/item_merchant_row_right_button")
    public WebElement becomeMemberButton;
}
