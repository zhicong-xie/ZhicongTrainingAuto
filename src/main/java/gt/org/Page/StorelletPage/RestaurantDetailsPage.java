package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RestaurantDetailsPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public RestaurantDetailsPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "merchant_header_name_tv")
    public WebElement restaurantName;

    @FindBy(id = "member_header_back_iv")
    public WebElement backButton;

    @FindBy(id = "member_header_newjoin_tv")
    public WebElement newJoinButton;

    @FindBy(id = "merchant_header_point_expiry_more_tv")
    public WebElement moreDetailsButton;

    @FindBy(id = "merchant_header_score_tv")
    public WebElement restaurantPoints;

    @FindBy(id = "view_merchant_shoploc_map_showall_btn")
    public WebElement showAllShopsButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"概要\"]")
    public WebElement summaryButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"我的錢包\"]")
    public WebElement walletButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"可兌換\"]")
    public WebElement redeemButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"迎新禮物\"]")
    public WebElement welcomeGiftButton;

    public String restaurantCouponDescriptionListXpath = "//*[contains(@resource-id , 'item_coupon_view_cardview')]//*[contains(@resource-id , 'item_coupon_view_description_tv')]";

    public String restaurantCouponTipsListXpath = "//*[contains(@resource-id , 'item_coupon_view_cardview')]//*[contains(@resource-id , 'item_coupon_view_tips_tv')]";
}
