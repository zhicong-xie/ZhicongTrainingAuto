package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.NewJoinGuidelinesPage;

public class NewJoinGuidelinesFlow extends AppiumHelpers {

    private NewJoinGuidelinesPage newJoinGuidelinesPage;

    public NewJoinGuidelinesFlow() {
        newJoinGuidelinesPage = new NewJoinGuidelinesPage();
    }


    public boolean isNewJoinGuidelinesTitleDisplayed() {
        return checkElement(newJoinGuidelinesPage.newJoinGuidelinesTitle);
    }

    public void clickSkipButton() {
        if (isNewJoinGuidelinesTitleDisplayed()) {
            waitForElement(newJoinGuidelinesPage.skipButton).click();
        }
    }

    public void closeNewJoinGuideScreen(int waitTime) {
        if (checkElement(newJoinGuidelinesPage.newJoinGuidelinesTitle, waitTime)) {
            System.out.println("----------------   Appium Event Listener   -----------------\nRestaurant points screen displayed");
            System.out.println("Close Restaurant points screen ...");
            waitForElement(newJoinGuidelinesPage.skipButton).click();
        }
    }
}
