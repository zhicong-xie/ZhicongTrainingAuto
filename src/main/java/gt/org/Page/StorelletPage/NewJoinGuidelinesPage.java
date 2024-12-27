package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewJoinGuidelinesPage {

    private DriverManager driverManager;
    private AndroidDriver driver;

    public NewJoinGuidelinesPage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "image1")
    public WebElement newJoinGuidelinesTitle;

    @FindBy(id = "image1")
    public WebElement skipButton;
}
