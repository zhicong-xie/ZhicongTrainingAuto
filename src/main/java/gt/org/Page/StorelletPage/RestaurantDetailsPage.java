package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestaurantDetailsPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public RestaurantDetailsPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "merchant_header_name_tv")
    public WebElement restaurantName;

    @FindBy(id = "member_header_back_iv")
    public WebElement backButton;

    @FindBy(id = "member_header_newjoin_tv")
    public WebElement newJoinButton;

    @FindBy(id = "merchant_header_point_expiry_more_tv")
    public WebElement moreDetailsButton;
}
