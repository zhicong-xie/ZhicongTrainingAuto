package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WalletPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public WalletPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fragment_membership_tab_my_title_tv")
    public WebElement walletTitle;

    @FindBy(id = "my_membership_redemption_center_btn")
    public WebElement redemptionCenterButton;

    @FindBy(id = "item_section_header_action_btn")
    public WebElement showAllRestaurantButton;

    //我的会籍
    @FindBy(id = "item_recycler_view_retry_rv")
    public WebElement membershipRestaurantSwipeView;

    public String membershipRestaurantNameXpath = "//*[contains(@resource-id , 'item_large_image_portrait_tv') and contains(@text ,'%s')]";

    //优惠券
    public String myCouponsViewOfRestaurantNameXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]";

    public String allCouponsButtonXpath  = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/../*[contains(@resource-id, 'item_brand_coupon_rv_scroll_all_tv')]";

    public String couponsSwipeViewXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/../*[contains(@resource-id, 'item_brand_coupon_rv_scroll_rv')]";

    public String couponsDescribeXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/..//*[contains(@resource-id, 'item_coupon_portrait_body_tv') and contains(@text ,'%s')]]";

    public String couponsExpirationXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/..//*[contains(@resource-id, 'item_coupon_portrait_body2_tv') and contains(@text ,'%s')]]";
}
