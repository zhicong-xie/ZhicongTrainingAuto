package gt.org.Page.HkGovNewPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public HomePage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.igpsd.govnews_2_1:id/horizontalScrollView1")
    public WebElement topBarView;

    @AndroidFindBy(id = "com.igpsd.govnews_2_1:id/listView1")
    public WebElement newListView;

    @AndroidFindBy(id = "com.igpsd.govnews_2_1:id/item1")
    public WebElement topBarViewHomeOptionImage;
}
