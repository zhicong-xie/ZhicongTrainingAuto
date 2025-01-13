package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.PromotionViewPage;

public class PromotionViewFlow extends AppiumHelpers {

    private PromotionViewPage promotionViewPage;

    public PromotionViewFlow() {
        promotionViewPage = new PromotionViewPage();
    }

    public boolean isPromotionViewDisplayed() {
        return checkElement(promotionViewPage.promotionViewCloseButton, 20);
    }

    public void clickCloseButton() {
        if (checkElement(promotionViewPage.promotionViewCloseButton, 5)) {
            waitForElementToClickable(promotionViewPage.promotionViewCloseButton).click();
        }
    }

    public void closePromotionViewPartialModal(int waitTime) {
        if (checkElement(promotionViewPage.promotionViewCloseButton, waitTime)) {
            System.out.println("Promotion view partial modal screen displayed...");
            System.out.println("Click close button...");
            waitForElementToClickable(promotionViewPage.promotionViewCloseButton).click();
        }
    }

    public void clickCheckDetailsButton() {
        if (checkElement(promotionViewPage.promotionViewCloseButton, 5)) {
            waitForElementToClickable(promotionViewPage.promotionViewCheckDetailsButton).click();
        }
    }
}
