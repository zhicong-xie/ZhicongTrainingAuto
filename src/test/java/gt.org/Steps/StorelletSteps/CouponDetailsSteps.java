package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.CouponDetailsFlow;
import gt.org.Flow.StorelletFlow.ExploreFlow;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CouponDetailsSteps {

    private CouponDetailsFlow couponDetailsFlow;

    public CouponDetailsSteps() {
        couponDetailsFlow = new CouponDetailsFlow();
    }

    @Then("^the user in the (Storellet coupon details|Redeem confirm partial modal|Redemption failed partial modal|Redemption success partial modal) screen$")
    public void isPageDisplayed(String pageName) {
        boolean expected = true;
        boolean actual;
        String reason = String.format("the %s screen is not displayed", pageName);
        switch (pageName) {
            case "Storellet coupon details":
                actual = couponDetailsFlow.isCouponDetailsViewDisplayed();
                break;
            case "Redeem confirm partial modal":
                actual = couponDetailsFlow.isRedeemConfirmPartialModalTitleDisplayed();
                break;
            case "Redemption failed partial modal":
                actual = couponDetailsFlow.isRedemptionFailedPartialModalTitleDisplayed();
                break;
            case "Redemption success partial modal":
                actual = couponDetailsFlow.isRedemptionSuccessPartialModalTitleDisplayed();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + pageName);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see Coupon (title|expire) field displayed \"([^\"]*)\" in the Storellet coupon details screen$")
    public void getCouponInfo(String item, String expected) {
        String actual;
        switch (item) {
            case "title":
                actual = couponDetailsFlow.getCouponTitle();
                break;
            case "expire":
                actual = couponDetailsFlow.getCouponExpire();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        String reason = String.format("the %s field displayed wrong; expected : %s, actual : %s", item, expected, actual);
        Assert.assertEquals(actual.contains(expected),true, reason);
    }

    @When("^the user click (Reminder|Redeem) button in the Storellet coupon details screen$")
    public void clickButton(String item) {
        switch (item) {
            case "Reminder":
                couponDetailsFlow.clickCouponReminderButton();
                break;
            case "Redeem":
                couponDetailsFlow.clickCouponRedeemButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }

    @Then("^the user able to (see|not see) QR code displayed in the Storellet coupon details screen$")
    public void isCouponQrCodeDisplayed(String item) {
        boolean expected;
        boolean actual = couponDetailsFlow.isCouponQrCodeDisplayed();
        String reason;
        switch (item){
            case "see":
                expected = true;
                reason = String.format("the %s QR code is not displayed", item);
                break;
            case "not see":
                expected = false;
                reason = String.format("the %s QR code is displayed", item);
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
        Assert.assertEquals(actual, expected, reason);
    }

    @Then("^the user able to see Coupon redeem point field displayed \"([^\"]*)\" in the Storellet coupon details screen$")
    public void checkCouponRedeemPoint(String expected) {
        String actual = couponDetailsFlow.getCouponRedeemPointField();
        String reason = String.format("the Coupon redeem point field displayed wrong; expected : %s, actual : %s", expected, actual);
        Assert.assertEquals(actual,expected,reason);
    }

    @When("^the user click (Cancel|Confirm) button in the Coupon redeem confirm partial modal screen$")
    public void clickBtn1(String item) {
        switch (item) {
            case "Cancel":
                couponDetailsFlow.clickRedeemConfirmPartialModalCancelButton();
                break;
            case "Confirm":
                couponDetailsFlow.clickRedeemConfirmPartialModalConfirmButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }

    @When("^the user click Confirm button in the Coupon redemption (failed|success) partial modal screen$")
    public void clickBtn2(String item) {
        switch (item) {
            case "failed":
                couponDetailsFlow.clickRedemptionFailedPartialModalConfirmButton();
                break;
            case "success":
                couponDetailsFlow.clickRedemptionSuccessPartialModalConfirmButton();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + item);
        }
    }
}
