package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromotionViewPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public PromotionViewPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@text = 'Close Message']")
    public WebElement promotionViewCloseButton;

    @FindBy(xpath = "//*[@text = '查看詳情']")
    public WebElement promotionViewCheckDetailsButton;


}
