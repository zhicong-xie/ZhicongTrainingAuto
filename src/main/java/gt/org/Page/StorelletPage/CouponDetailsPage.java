package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CouponDetailsPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public CouponDetailsPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.storellet:id/dialog_coupon_list_fill_screen_dialog_rv")
    public WebElement couponDetailsView;

    @AndroidFindBy(id = "com.storellet:id/item_coupon_fullscreen_title_tv")
    public WebElement couponTitle;

    @AndroidFindBy(id = "com.storellet:id/item_coupon_fullscreen_coupon_expire_tv")
    public WebElement couponExpireField;

    @AndroidFindBy(id = "com.storellet:id/item_coupon_fullscreen_coupon_reminder_btn")
    public WebElement couponReminderButton;

    @AndroidFindBy(id = "com.storellet:id/item_coupon_fullscreen_qr_iv")
    public WebElement couponQrCodeView;

    @AndroidFindBy(id = "com.storellet:id/item_coupon_fullscreen_redeem_point_tv")
    public WebElement couponRedeemPointField;

    @AndroidFindBy(id = "com.storellet:id/item_coupon_fullscreen_redeem_cv")
    public WebElement couponRedeemButton;


    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_title")
    public WebElement redeemConfirmPartialModalTitle;

    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    public WebElement redeemConfirmPartialModalCancelButton;

    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_positive_btn")
    public WebElement redeemConfirmPartialModalConfirmButton;

    @AndroidFindBys({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_content"),
            @AndroidBy(xpath = "//*[@text='你沒有足夠的積分兌換此項目']")
    })
    public WebElement redemptionFailedPartialModalTitle;

    @AndroidBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    public WebElement redemptionFailedPartialModalConfirmButton;

    @AndroidFindBys({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_content"),
            @AndroidBy(xpath = "//*[@text='兌換成功']")
    })
    public WebElement redemptionSuccessPartialModalTitle;

    @AndroidBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    public WebElement redemptionSuccessPartialModalConfirmButton;

}
