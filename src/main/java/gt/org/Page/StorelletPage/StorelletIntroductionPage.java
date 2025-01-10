package gt.org.Page.StorelletPage;

import gt.org.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorelletIntroductionPage {

    private DriverManager driverManager;
    private WebDriver webDriver;

    public StorelletIntroductionPage() {
        driverManager = DriverManager.getInstance();
        webDriver = driverManager.getWebDecoratorDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "activity_introduction_indicator")
    public WebElement introductionFootBar;

    @FindBy(id = "item_introduction_5_nothanks_tv")
    public WebElement nextButton;

}
