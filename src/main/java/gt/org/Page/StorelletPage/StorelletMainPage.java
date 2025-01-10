package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorelletMainPage {

    private DriverManager driverManager;
    private WebDriver driver;

    public StorelletMainPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getWebDecoratorDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@resource-id = 'com.storellet:id/fragment_child_discover_feature_toolbar_search_iv' or @resource-id = 'com.storellet:id/item_payload_action_row_subheader_tv']")
    public WebElement mainPageIdentification;

    @FindBy(id = "redemption_center_btn")
    public WebElement redemptionCenterButton;

    @FindBy(id = "fragment_child_discover_feature_toolbar_search_iv")
    public WebElement searchIcon;

    @FindBy(id = "fragment_child_discover_feature_toolbar_notice_iv")
    public WebElement noticeIcon;

    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id = 'com.storellet:id/item_discover_horizon_image_rv'])[1]")
    public WebElement bigPromotionView;

    public String bigPromotionImageXpathString = "(//androidx.recyclerview.widget.RecyclerView[@resource-id = 'com.storellet:id/item_discover_horizon_image_rv'])[1]//android.widget.ImageView[@resource-id ='com.storellet:id/item_discover_image_card_iv']";

    @FindBy(id = "view_main_navibar_v4_container")
    public WebElement bottomBar;

    @FindBy(xpath = "//*[@resource-id = 'com.storellet:id/item_payload_action_row_right_button_txt' and @text = '加入']")
    public WebElement jointButton;

    public String restaurantNameId = "com.storellet:id/item_payload_action_row_subheader_tv";
}
