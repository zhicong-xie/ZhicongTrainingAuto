package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePartialModalPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public ProfilePartialModalPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "fragment_member_card_title_tv")
    public WebElement profilePartialModalTitle;

    @AndroidFindBy(id = "fragment_member_card_setting_iv")
    public WebElement settingButton;

    @AndroidFindBy(id = "fragment_member_card_name_tv")
    public WebElement profileNameField;

    @AndroidFindBy(id = "fragment_member_card_qrcode_iv")
    public WebElement qrCodeView;
}
