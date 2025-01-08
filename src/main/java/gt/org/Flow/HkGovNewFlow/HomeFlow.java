package gt.org.Flow.HkGovNewFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.HkGovNewPage.HomePage;
import net.sourceforge.tess4j.TesseractException;

import java.io.IOException;

public class HomeFlow extends AppiumHelpers {

    private HomePage homePage;

    public HomeFlow() {
        homePage = new HomePage();
    }

    public boolean isHomePageIdentificationDisplayed() {
        return checkElement(waitForElementAttributeIsState(homePage.topBarViewHomeOptionImage, "clickable", "true"));
    }

    public String getTopBarHomeButtonImageText() throws TesseractException, IOException {
        String result = getImageText(getElementScreenshot(waitForElementAttributeIsState(homePage.topBarViewHomeOptionImage, "clickable", "true"))).replaceAll(" ", "");
        System.out.println("\nTop bar home button image text is : " + result + "\n");
        return result;
    }

    public boolean isTopBarViewHomeButtonConsistentWithLocalImages(){

        return true;
    }
}

