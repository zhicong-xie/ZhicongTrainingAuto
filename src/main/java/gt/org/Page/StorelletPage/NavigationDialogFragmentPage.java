package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationDialogFragmentPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public NavigationDialogFragmentPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "view_navigation_tutor_container")
    public WebElement navigationDialogFragmentView;

    @FindBy(id = "view_navigation_tutor_explore_bubble")//view_navigation_tutor_explore_icon
    public WebElement navigationDialogFragmentExploreBubble;

    @FindBy(id = "view_navigation_tutor_membership_bubble")
    public WebElement navigationDialogFragmentMembershipBubble;

    @FindBy(id = "view_navigation_tutor_wallet_bubble")
    public WebElement navigationDialogFragmentWalletBubble;

    @FindBy(id = "view_navigation_tutor_me_bubble")
    public WebElement navigationDialogFragmentProfileBubble;

    @FindBy(id = "view_navigation_tutor_scanner_bubble")
    public WebElement navigationDialogFragmentScannerBubble;

    @FindBy(id = "view_navigation_tutor_notice_bubble")
    public WebElement navigationDialogFragmentNoticeBubble;
}
