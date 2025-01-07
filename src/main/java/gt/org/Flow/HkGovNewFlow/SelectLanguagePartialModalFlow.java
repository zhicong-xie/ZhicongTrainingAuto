package gt.org.Flow.HkGovNewFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.HkGovNewPage.SelectLanguagePartialModalPage;

public class SelectLanguagePartialModalFlow extends AppiumHelpers {

    private SelectLanguagePartialModalPage selectLanguagePartialModalPage;

    public SelectLanguagePartialModalFlow() {
        selectLanguagePartialModalPage = new SelectLanguagePartialModalPage();
    }


    public boolean isSelectLanguagePartialModalTitleDisplayed() {
        return checkElement(selectLanguagePartialModalPage.selectLanguagePartialModalTitle);
    }

    public void clickEnglishButton() {
        waitForElementToClickable(selectLanguagePartialModalPage.englishButton).click();
    }

    public void clickTraditionalChineseButton() {
        waitForElementToClickable(selectLanguagePartialModalPage.traditionalChineseButton).click();
    }

    public void clickSimplifiedChineseButton() {
        waitForElementToClickable(selectLanguagePartialModalPage.simplifiedChineseButton).click();
    }

}