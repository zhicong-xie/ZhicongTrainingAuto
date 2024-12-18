package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public WalletPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fragment_membership_tab_my_title_tv")
    public WebElement walletTitle;

    @FindBy(id = "my_membership_redemption_center_btn")
    public WebElement redemptionCenterButton;

    @FindBy(id = "item_section_header_action_btn")
    public WebElement showAllButton;
}
