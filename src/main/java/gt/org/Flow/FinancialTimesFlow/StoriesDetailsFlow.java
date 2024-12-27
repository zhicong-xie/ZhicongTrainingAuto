package gt.org.Flow.FinancialTimesFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.FinancialTimesPage.StoriesDetailsPage;

public class StoriesDetailsFlow extends AppiumHelpers {

    private StoriesDetailsPage storiesDetailsPage;

    public StoriesDetailsFlow() {
        storiesDetailsPage = new StoriesDetailsPage();
    }

    public boolean isStoriesDetailsScreenDisplayed() {
        return checkElement(storiesDetailsPage.storiesDetailsTitle, 40);
    }

    public void clickBackButton() {
        waitForElementToClickable(storiesDetailsPage.backButton).click();
    }

    public void clickCollectionButton() {
        waitForElementToClickable(storiesDetailsPage.collectionButton).click();
    }

    public void clickShareButton() {
        waitForElementToClickable(storiesDetailsPage.shareButton).click();
    }

    public boolean checkTextContent(String textContent) {
        return checkElementByText(textContent, 2);
    }
}
