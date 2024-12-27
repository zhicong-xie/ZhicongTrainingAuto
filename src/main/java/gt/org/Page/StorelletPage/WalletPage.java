package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WalletPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public WalletPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/item_large_image_portrait_bg_iv"),
            @AndroidBy(id = "com.storellet:id/item_coupon_portrait_card_view")
    })
    public WebElement walletIdentification;

    @AndroidFindBy(id = "my_membership_redemption_center_btn")
    public WebElement redemptionCenterButton;

    @AndroidFindBy(id = "item_section_header_action_btn")
    public WebElement showAllRestaurantButton;

    //我的会籍
    @AndroidFindBy(id = "item_recycler_view_retry_rv")
    public WebElement membershipRestaurantSwipeView;

    public String membershipRestaurantNameXpath = "//*[contains(@resource-id , 'item_large_image_portrait_tv') and contains(@text ,'%s')]";

    //优惠券
    public String myCouponsViewOfRestaurantNameXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]";

    public String allCouponsButtonXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/../*[contains(@resource-id, 'item_brand_coupon_rv_scroll_all_tv')]";

    public String couponsSwipeViewXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/../*[contains(@resource-id, 'item_brand_coupon_rv_scroll_rv')]";

    public String couponsDescribeXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/..//*[contains(@resource-id, 'item_coupon_portrait_body_tv') and contains(@text ,'%s')]";

    public String couponsExpirationXpath = "//*[contains(@resource-id, 'item_brand_coupon_rv_scroll_title_tv') and contains(@text ,'%s')]/..//*[contains(@resource-id, 'item_coupon_portrait_body2_tv') and contains(@text ,'%s')]";
}
