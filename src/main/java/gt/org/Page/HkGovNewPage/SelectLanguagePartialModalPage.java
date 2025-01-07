package gt.org.Page.HkGovNewPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SelectLanguagePartialModalPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public SelectLanguagePartialModalPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '語言']")
    public WebElement selectLanguagePartialModalTitle;

    @AndroidFindBy(id = "com.igpsd.govnews_2_1:id/english")
    public WebElement englishButton;

    @AndroidFindBy(id = "com.igpsd.govnews_2_1:id/hk")
    public WebElement traditionalChineseButton;

    @AndroidFindBy(id = "com.igpsd.govnews_2_1:id/cn")
    public WebElement simplifiedChineseButton;
}
