package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public LoginPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frag_login_dialog_v4_header_iv")
    public WebElement loginTitle;

    @FindBy(id = "frag_login_dialog_v4_setting_iv")
    public WebElement settingButton;

    @FindBy(id = "frag_login_dialog_v4_country_btn")
    public WebElement internationalAreaCodeButton;

    @FindBy(xpath = "//*[@text = '請選擇']")
    public WebElement selectAreaCodeTitle;

    @FindBy(id = "frag_login_dialog_v4_mobile_et")
    public WebElement phoneNumberInputBox;

    @FindBy(id = "frag_login_dialog_v4_password_et")
    public WebElement passwordInputBox;

    @FindBy(id = "frag_login_dialog_v4_forget_pw_tv")
    public WebElement forgetPasswordButton;

    @FindBy(id = "frag_login_dialog_v4_confirm_btn")
    public WebElement confirmButton;

    @FindBy(id = "frag_login_dialog_v4_reg_btn_tv")
    public WebElement createProfileButton;

    @FindBy(xpath = "//*[@text = '電話號碼或密碼不正確']")
    public WebElement incorrectInformationTitle;

    @FindBy(id = "dialog_error_dialog_negative_btn")
    public WebElement incorrectInformationConfirmButton;
}
