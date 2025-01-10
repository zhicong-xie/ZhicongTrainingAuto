package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CouponDetailsPage {

    private DriverManager driverManager;
    private WebDriver driver;

    public CouponDetailsPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getWebDecoratorDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.storellet:id/dialog_coupon_list_fill_screen_dialog_rv")
    public WebElement couponDetailsView;

    @FindBy(id = "com.storellet:id/dialog_coupon_list_fill_screen_dialog_close_iv")
    public WebElement closeButton;

    @FindBy(id = "com.storellet:id/item_coupon_fullscreen_title_tv")
    public WebElement couponTitle;

    @FindBy(id = "com.storellet:id/item_coupon_fullscreen_coupon_expire_tv")
    public WebElement couponExpireField;

    @FindBy(id = "com.storellet:id/item_coupon_fullscreen_coupon_reminder_btn")
    public WebElement couponReminderButton;

    @FindBy(id = "com.storellet:id/item_coupon_fullscreen_qr_iv")
    public WebElement couponQrCodeView;

    @FindBy(id = "com.storellet:id/item_coupon_fullscreen_redeem_point_tv")
    public WebElement couponRedeemPointField;

    @FindBy(id = "com.storellet:id/item_coupon_fullscreen_redeem_cv")
    public WebElement couponRedeemButton;


    @FindBy(id = "com.storellet:id/dialog_error_dialog_title")
    public WebElement redeemConfirmPartialModalTitle;

    @FindBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    public WebElement redeemConfirmPartialModalCancelButton;

    @FindBy(id = "com.storellet:id/dialog_error_dialog_positive_btn")
    public WebElement redeemConfirmPartialModalConfirmButton;

    @FindAll({
            @FindBy(id = "com.storellet:id/dialog_error_dialog_content"),
            @FindBy(xpath = "//*[@text='你沒有足夠的積分兌換此項目']")
    })
    public WebElement redemptionFailedPartialModalTitle;

    @FindBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    public WebElement redemptionFailedPartialModalConfirmButton;

    @FindAll({
            @FindBy(id = "com.storellet:id/dialog_error_dialog_content"),
            @FindBy(xpath = "//*[@text='兌換成功']")
    })
    public WebElement redemptionSuccessPartialModalTitle;

    @FindBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    public WebElement redemptionSuccessPartialModalConfirmButton;

}
