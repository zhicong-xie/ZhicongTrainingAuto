package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.NavigationDialogFragmentPage;
import gt.org.Page.StorelletPage.ShopsDetailsPage;

public class ShopsDetailsFlow extends AppiumHelpers {

    private ShopsDetailsPage shopsDetailsPage;

    public ShopsDetailsFlow() {
        shopsDetailsPage = new ShopsDetailsPage();
    }

    public boolean isShopNameDisplayed(){
        return checkElement(shopsDetailsPage.shopsName);
    }

    public String getShopName(){
        return waitForElement(shopsDetailsPage.shopsName).getText().trim();
    }

    public void clickBackButton(){
        waitForElementToClickable(shopsDetailsPage.backButton).click();
    }

    public void clickNewJointButton(){
        waitForElementToClickable(shopsDetailsPage.newJoinButton).click();
    }

    public void clickMoreDetailsButton(){
        waitForElementToClickable(shopsDetailsPage.moreDetailsButton).click();
    }

    public boolean isNewJoinButtonDisplayed(){
        return checkElement(shopsDetailsPage.newJoinButton,5);
    }

    public boolean isMoreDetailsButtonDisplayed(){
        return checkElement(shopsDetailsPage.moreDetailsButton,5);
    }
}
