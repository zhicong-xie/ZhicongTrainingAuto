package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public SettingPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text = '設定']")
    public WebElement settingPageTitle;

    @AndroidFindBy(id = "fragment_setting_main_back_iv")
    public WebElement backButton;

    @AndroidFindBy(id = "fragment_setting_main_logout_tv")
    public WebElement logoutButton;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.storellet:id/dialog_error_dialog_content' and @text = '確定要退出 Storellet 帳戶？']")
    public WebElement confirmLogoutPartialModalTitle;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.storellet:id/dialog_error_dialog_negative_btn' and @text = '取消']")
    public WebElement confirmLogoutPartialModalCancelBtn;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.storellet:id/dialog_error_dialog_positive_btn' and @text = '登出']")
    public WebElement confirmLogoutPartialModalLogoutBtn;
}
