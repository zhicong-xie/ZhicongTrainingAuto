package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorelletIntroductionPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public StorelletIntroductionPage(){
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "activity_introduction_indicator")
    public WebElement introductionFootBar;

    @FindBy(id = "item_introduction_5_nothanks_tv")
    public WebElement nextButton;

}
