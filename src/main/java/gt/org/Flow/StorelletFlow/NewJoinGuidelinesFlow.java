package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.NewJoinGuidelinesPage;

public class NewJoinGuidelinesFlow extends AppiumHelpers {

    private NewJoinGuidelinesPage newJoinGuidelinesPage;

    public NewJoinGuidelinesFlow() {
        newJoinGuidelinesPage = new NewJoinGuidelinesPage();
    }


    public boolean isNewJoinGuidelinesTitleDisplayed(){
        return checkElement(newJoinGuidelinesPage.newJoinGuidelinesTitle,5);
    }

    public void clickSkipButton(){
        if (isNewJoinGuidelinesTitleDisplayed()){
            waitForElement(newJoinGuidelinesPage.skipButton).click();
        }
    }

}
