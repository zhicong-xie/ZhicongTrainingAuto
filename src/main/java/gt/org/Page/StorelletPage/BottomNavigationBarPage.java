package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigationBarPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public BottomNavigationBarPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "view_main_navibar_v4_explore")
    public WebElement homeButton;

    @AndroidFindBy(id = "view_main_navibar_v4_member")
    public WebElement exploreButton;

    @AndroidFindBy(id = "view_main_navibar_v4_scan")
    public WebElement scanButton;

    @AndroidFindBy(id = "view_main_navibar_v4_wallet")
    public WebElement walletButton;

    @AndroidFindBy(id = "view_main_navibar_v4_me")
    public WebElement profileButton;
}
