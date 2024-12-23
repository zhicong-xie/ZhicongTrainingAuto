package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembershipTermsAndConditionsPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public MembershipTermsAndConditionsPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dialog_error_dialog_title")
    public WebElement termsAndConditionsTitle;

    @FindBy(id = "view_member_tnc_et")
    public WebElement emailInputBox;

    @FindBy(id = "message_dialog_positive_btn")
    public WebElement agreeButton;

    @FindBy(id = "message_dialog_negative_btn")
    public WebElement disagreeButton;

    @FindBy(xpath = "//*[@text = '電郵格式不正確']")
    public WebElement incorrectEmailFormatPartialModalTitle;

    @FindBy(id = "dialog_error_dialog_negative_btn")
    public WebElement incorrectEmailFormatPartialModalConfirmButton;
}
