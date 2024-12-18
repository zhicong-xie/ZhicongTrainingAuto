package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigationBarPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public BottomNavigationBarPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "view_main_navibar_v4_explore")
    public WebElement homeButton;

    @FindBy(id = "view_main_navibar_v4_member")
    public WebElement exploreButton;

    @FindBy(id = "view_main_navibar_v4_scan")
    public WebElement scanButton;

    @FindBy(id = "view_main_navibar_v4_wallet")
    public WebElement walletButton;

    @FindBy(id = "view_main_navibar_v4_me")
    public WebElement profileButton;
}
