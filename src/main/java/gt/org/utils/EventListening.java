package gt.org.utils;

import gt.org.Flow.StorelletFlow.NewJoinGuidelinesFlow;
import gt.org.Flow.StorelletFlow.PromotionViewFlow;
import gt.org.Flow.StorelletFlow.UpdateNotificationPartialModalFlow;
import gt.org.Flow.StorelletFlow.VerifyEmailAddressPartialModalFlow;
import org.openqa.selenium.support.events.WebDriverListener;


public class EventListening implements WebDriverListener {

    @Override
    public void beforeAnyCall(Object target, java.lang.reflect.Method method, Object[] args) {
        PromotionViewFlow promotionViewFlow = new PromotionViewFlow();
        UpdateNotificationPartialModalFlow updateNotificationPartialModalFlow = new UpdateNotificationPartialModalFlow();
        NewJoinGuidelinesFlow newJoinGuidelinesFlow = new NewJoinGuidelinesFlow();
        VerifyEmailAddressPartialModalFlow verifyEmailAddressPartialModalFlow = new VerifyEmailAddressPartialModalFlow();

        promotionViewFlow.closePromotionViewPartialModal(0);
        updateNotificationPartialModalFlow.closeUpdateNotificationPartialModal(0);
        newJoinGuidelinesFlow.closeNewJoinGuideScreen(0);
        verifyEmailAddressPartialModalFlow.closeEmailAddressPartialModalPage(0);
    }
}
