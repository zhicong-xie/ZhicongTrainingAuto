package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationSentPartialModalPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public VerificationSentPartialModalPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_verification_sent_title_tv")
    public WebElement verificationSentPartialModalTitle;

    @FindBy(id = "email_verification_sent_email_tv")
    public WebElement verificationSentPartialModalEmailAddressField;

    @FindBy(id = "item_email_verification_sent_success_btn")
    public WebElement verificationSentPartialModalDoneButton;
}
