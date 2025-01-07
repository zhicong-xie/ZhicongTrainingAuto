package gt.org.Flow.HkGovNewFlow;

import gt.org.Base.AppiumHelpers;
import gt.org.Page.HkGovNewPage.HomePage;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class HomeFlow extends AppiumHelpers {

    private HomePage homePage;

    public HomeFlow() {
        homePage = new HomePage();
    }

    public boolean isHomePageTopBarDisplayed() {
        waitForSecond(10);
        return checkElement(homePage.topBarView);
    }

    public String getTopBarHomeButtonImageText() throws TesseractException, IOException {
        /*
         *
         *  在自己macbook终端输入"brew install tesseract" 安装
         *  完成上述后在终端输入"brew install tesseract-lang" 获取除英文以外的全部语言包
         *  或者在 "https://github.com/tesseract-ocr/tessdata" 手动下载'.traineddata'后缀的语言包并手动添加到该目录下'/usr/local/Cellar/tesseract/<tesseract version>/share/tessdata'
         *
         * iTesseract.setDatapath("path")        设置 Tess4J 数据路径
         * iTesseract.setLanguage("language");   设置识别的语言(eng:英文; chi_sim:简中; chi_tra:繁中. 如果有字体混合组合可用'+')
         */

        ITesseract iTesseract = new Tesseract();
        iTesseract.setDatapath("/usr/local/Cellar/tesseract/5.5.0/share/tessdata");
        iTesseract.setLanguage("eng+chi_sim+chi_tra");

        String result = iTesseract.doOCR(getElementScreenshot(waitForElement(homePage.topBarViewHomeOptionImage))).replaceAll(" ", "");
        System.out.println("\nTop bar home button image text is : " + result + "\n");
        return result;
    }
}

