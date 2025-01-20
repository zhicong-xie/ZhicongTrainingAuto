import gt.org.CucumberReport.PrettyCucumberReport;
import gt.org.utils.AppiumServerGui;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/*Storellet*/
@CucumberOptions(
        features = "src/test/java/gt.org/resources/Storellet",
        glue = {"gt.org.Steps"},
//        tags = "not @email",
        tags = "@AC1",
        plugin = {
                "pretty",
                "html:target/cucumber-report/report.html",
                "json:target/cucumber-report/cucumber.json"
        },
        monochrome = true)

/*HK Gov New*/
//@CucumberOptions(
//        features = "src/test/java/gt.org/resources/HkGovNew",
//        glue = {"gt.org.Steps"},
//        tags = "@AC1.2",
//        plugin = {
//                "pretty",
//                "html:target/cucumber-report/report.html",
//                "json:target/cucumber-report/cucumber.json"
//        },
//        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
    private AppiumServerGui appiumServerGui = new AppiumServerGui();

    @BeforeSuite
    public void startAppiumServer() throws IOException, InterruptedException {

        if (appiumServerGui.isAppiumServicePortOccupancy(4723)) {
            System.out.println("Appium Server Port occupied, Close port...");
            appiumServerGui.stopPort(4723);
        }

        System.out.println("Appium Server Port start ...");
        appiumServerGui.startAppiumService(4723);
    }

    @AfterSuite
    public void generateReport() {
        PrettyCucumberReport prettyCucumberReport = new PrettyCucumberReport();
        prettyCucumberReport.generateReports();

        AppiumServerGui appiumServerGui = new AppiumServerGui();
        if (appiumServerGui.isAppiumServicePortOccupancy(4723)) {
            System.out.println("Appium Server stop...");
            appiumServerGui.stopAppiumService();
        }
    }
}
