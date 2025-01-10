package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyEmailAddressPartialModalPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public VerifyEmailAddressPartialModalPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_verification_title_tv")
    public WebElement verifyEmailAddressPartialModalTitle;

    @FindBy(id = "email_verification_email_et")
    public WebElement emailAddressField;

    @FindBy(id = "item_email_verification_sent_btn")
    public WebElement verificationSendButton;

    @FindBy(id = "item_email_verification_change_btn")
    public WebElement changeEmailButton;

    @FindBy(id = "item_email_verification_ignore_btn")
    public WebElement ignoreButton;
}
