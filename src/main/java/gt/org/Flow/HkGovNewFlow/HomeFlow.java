package gt.org.Flow.HkGovNewFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.HkGovNewPage.HomePage;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Mat;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomeFlow extends AppiumHelpers {

    private HomePage homePage;

    public HomeFlow() {
        homePage = new HomePage();
    }

    public boolean isHomePageIdentificationDisplayed() {
        return checkElement(waitForElementAttributeIsState(homePage.topBarViewHomeOptionImage, "clickable", "true"));
    }

    public String getTopBarHomeButtonImageText() throws TesseractException, IOException {
        String result = getImageText(getElementScreenshot(
                waitForElementAttributeIsState(homePage.topBarViewHomeOptionImage, "clickable", "true")))
                .replaceAll(" ", "");
        System.out.println("\nTop bar home button image text is : " + result + "\n");
        return result;
    }

    public boolean isTopBarViewHomeButtonConsistentWithLocalImages() {
        boolean actualResult = false;
        Mat expectedMat = loadImageAsMat("LocalImage/Home button image.png");
        Mat actualMat = loadImageAsMat(takeDeviceScreenshot());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        String outputPath = String.format("LocalImage/CompareResult/matched_result_%s.png", formattedDate);

        actualResult = matchImagesAndDraw(actualMat, expectedMat, outputPath,35);

        System.out.println("Home page Top bar Home button compare image saved successfully at: " + outputPath);
        return actualResult;
    }
}