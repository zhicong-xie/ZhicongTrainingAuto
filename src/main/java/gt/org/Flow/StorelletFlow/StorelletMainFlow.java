package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.NavigationDialogFragmentPage;
import gt.org.Page.StorelletPage.StorelletMainPage;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorelletMainFlow extends AppiumHelpers {

    private StorelletMainPage storelletMainPage;

    public StorelletMainFlow() {
        storelletMainPage = new StorelletMainPage();
    }

    public boolean isStorelletMainTitleDisplayed() {
        return checkElement(storelletMainPage.mainTitle);
    }

    public void clickRedemptionCenterButton() {
        waitForElementToClickable(storelletMainPage.redemptionCenterButton).click();
    }

    public void clickSearchIcon() {
        waitForElementToClickable(storelletMainPage.searchIcon).click();
    }

    public void clickNoticeIcon() {
        waitForElementToClickable(storelletMainPage.noticeIcon).click();
    }

    public boolean isFirstBigPromotionImageNotNull() throws IOException {
        return isImageViewNotNull(waitForElements(storelletMainPage.bigPromotionImageXpathString).get(0));
    }

    public void saveFirstBigPromotionImageToLocalFolder() throws IOException {
        List<WebElement> images = waitForElements(storelletMainPage.bigPromotionImageXpathString);
        saveElementScreenshot(images.get(0),"FirstBigPromotionImage");
    }
}
