package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.StorelletIntroductionPage;

public class StorelletIntroductionFlow extends AppiumHelpers {

    private StorelletIntroductionPage storelletIntroductionPage;

    public StorelletIntroductionFlow() {
        storelletIntroductionPage = new StorelletIntroductionPage();
    }

    public boolean isStorelletIntroductionFootBarDisplayed(){
       return checkElement(storelletIntroductionPage.introductionFootBar);
    }

    public void swipeToLeftClickNextButton(){
        swipeToFindElement("left",storelletIntroductionPage.nextButton,1,4).click();
    }

}
