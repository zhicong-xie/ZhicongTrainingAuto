package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StorelletMainPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public StorelletMainPage(){
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@text ='最新推廣']")
    public WebElement mainTitle;

    @FindBy(id = "redemption_center_btn")
    public WebElement redemptionCenterButton;

    @FindBy(id = "fragment_child_discover_feature_toolbar_search_iv")
    public WebElement searchIcon;

    @FindBy(id = "fragment_child_discover_feature_toolbar_notice_iv")
    public WebElement noticeIcon;

    @AndroidBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id = 'com.storellet:id/item_discover_horizon_image_rv'])[1]")
    public WebElement bigPromotionView;

    public String bigPromotionImageXpathString = "(//androidx.recyclerview.widget.RecyclerView[@resource-id = 'com.storellet:id/item_discover_horizon_image_rv'])[1]//android.widget.ImageView[@resource-id ='com.storellet:id/item_discover_image_card_iv']";
}
