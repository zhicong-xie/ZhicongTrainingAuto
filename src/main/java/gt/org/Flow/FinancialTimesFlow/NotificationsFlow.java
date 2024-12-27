package gt.org.Flow.FinancialTimesFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.FinancialTimesPage.NotificationsPage;

public class NotificationsFlow extends AppiumHelpers {

    private NotificationsPage notificationsPage;

    public NotificationsFlow() {
        notificationsPage = new NotificationsPage();
    }

    public boolean isNotificationsScreenTitleDisplayed() {
        return checkElement(notificationsPage.notificationsScreenTitle);
    }

    public String getCheckBoxStatus(String optionName) {
        switch (optionName.toLowerCase()) {
            case "breaking news":
                return waitForElement(notificationsPage.breakingNewsCheckBox).getDomAttribute("checked");

            case "highlights":
                return waitForElement(notificationsPage.highlightsCheckBox).getDomAttribute("checked");

            case "recommended for you":
                return waitForElement(notificationsPage.recommendedForYouCheckBox).getDomAttribute("checked");

            case "morning briefing":
                return waitForElement(notificationsPage.morningBriefingCheckBox).getDomAttribute("checked");

            case "myft instant alerts":
                return waitForElement(notificationsPage.myFtInstantAlertsCheckBox).getDomAttribute("checked");
            case "ft news briefing podcast":
                return waitForElement(notificationsPage.fTNewsBriefingPodcastCheckBox)
                        .getDomAttribute("checked");

            case "ft weekend podcast":
                return waitForElement(notificationsPage.fTWeekendPodcastCheckBox).getDomAttribute("checked");
            default:
                throw new IllegalArgumentException("Illegal Argument : " + optionName);
        }
    }

    public void turnOnSwitchButton() {
        if (waitForElement(notificationsPage.switchButton).getDomAttribute("checked").equals("false")) {
            waitForElement(notificationsPage.switchButton).click();
        }
    }

    public void clickCheckBox(String optionName) {
        switch (optionName.toLowerCase()) {
            case "breaking news":
                waitForElement(notificationsPage.breakingNewsCheckBox).click();
                break;
            case "highlights":
                waitForElement(notificationsPage.highlightsCheckBox).click();
                break;
            case "recommended for you":
                waitForElement(notificationsPage.recommendedForYouCheckBox).click();
                break;
            case "morning briefing":
                waitForElement(notificationsPage.morningBriefingCheckBox).click();
                break;
            case "myft instant alerts":
                waitForElement(notificationsPage.myFtInstantAlertsCheckBox).click();
                break;
            case "ft news briefing podcast":
                waitForElement(notificationsPage.fTNewsBriefingPodcastCheckBox).click();
                break;
            case "ft weekend podcast":
                waitForElement(notificationsPage.fTWeekendPodcastCheckBox).click();
                break;
            default:
                throw new IllegalArgumentException("Illegal Argument : " + optionName);
        }
    }
}
