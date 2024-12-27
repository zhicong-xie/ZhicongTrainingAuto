package gt.org.Flow.StorelletFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.StorelletPage.CouponDetailsPage;

public class CouponDetailsFlow extends AppiumHelpers {

    private CouponDetailsPage couponDetailsPage;

    public CouponDetailsFlow() {
        couponDetailsPage = new CouponDetailsPage();
    }

    public boolean isCouponDetailsViewDisplayed() {
        return checkElement(couponDetailsPage.couponDetailsView);
    }

    public void clickCloseButton() {
        waitForElementToClickable(couponDetailsPage.closeButton).click();
    }

    public String getCouponTitle() {
        return waitForElement(couponDetailsPage.couponTitle).getText().trim();
    }

    public String getCouponExpire() {
        return waitForElement(couponDetailsPage.couponExpireField).getText().trim();
    }

    public void clickCouponReminderButton() {
        waitForElementToClickable(couponDetailsPage.couponReminderButton).click();
    }

    public boolean isCouponQrCodeDisplayed() {
        return elementIsDisplayedWhenSwipe("up", couponDetailsPage.couponQrCodeView, 1, 3);
    }

    public String getCouponRedeemPointField() {
        return waitForElement(couponDetailsPage.couponRedeemPointField).getText().trim();
    }

    public void clickCouponRedeemButton() {
        waitForElement(couponDetailsPage.couponRedeemButton).click();
    }

    public boolean isRedeemConfirmPartialModalTitleDisplayed() {
        return checkElement(couponDetailsPage.redeemConfirmPartialModalTitle);
    }

    public void clickRedeemConfirmPartialModalCancelButton() {
        waitForElementToClickable(couponDetailsPage.redeemConfirmPartialModalCancelButton).click();
    }

    public void clickRedeemConfirmPartialModalConfirmButton() {
        waitForElementToClickable(couponDetailsPage.redeemConfirmPartialModalConfirmButton).click();
    }

    public boolean isRedemptionFailedPartialModalTitleDisplayed() {
        return checkElement(couponDetailsPage.redemptionFailedPartialModalTitle);
    }

    public void clickRedemptionFailedPartialModalConfirmButton() {
        waitForElementToClickable(couponDetailsPage.redemptionFailedPartialModalConfirmButton).click();
    }

    public boolean isRedemptionSuccessPartialModalTitleDisplayed() {
        return checkElement(couponDetailsPage.redemptionSuccessPartialModalTitle);
    }

    public void clickRedemptionSuccessPartialModalConfirmButton() {
        waitForElementToClickable(couponDetailsPage.redemptionSuccessPartialModalConfirmButton).click();
    }
}
