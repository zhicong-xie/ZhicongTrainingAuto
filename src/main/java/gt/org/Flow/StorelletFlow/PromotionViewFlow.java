package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.PromotionViewPage;

public class PromotionViewFlow extends AppiumHelpers {

    private PromotionViewPage promotionViewPage;

    public PromotionViewFlow() {
        promotionViewPage = new PromotionViewPage();
    }

    public boolean isPromotionViewDisplayed(){
        return checkElement(promotionViewPage.promotionViewCloseButton,20);
    }

    public void clickCloseButton(){
        waitForElementToClickable(promotionViewPage.promotionViewCloseButton).click();
    }

    public void clickCheckDetailsButton(){
        waitForElementToClickable(promotionViewPage.promotionViewCheckDetailsButton).click();
    }
}
