package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateEmailAddressPartialModalPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public UpdateEmailAddressPartialModalPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_verification_renew_title_tv")
    public WebElement updateEmailAddressPartialModalTitle;

    @FindBy(id = "email_verification_renew_email_et")
    public WebElement emailAddressInputBox;

    @FindBy(id = "item_email_verification_renew_btn")
    public WebElement updateButton;
}
