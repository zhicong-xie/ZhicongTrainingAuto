package TestRunner;

import gt.org.CucumberReport.PrettyCucumberReport;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
        features = "src/test/java/gt.org/resources/Storellet",
        glue = {"gt.org.Steps"},
//        tags = "@AC2.1 and not @Skip",
        tags = "not @Skip",
        plugin = {
                "pretty",
                "html:target/cucumber-report/report.html",
                "json:target/cucumber-report/cucumber.json"
        },
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void generateReport() {
        PrettyCucumberReport prettyCucumberReport = new PrettyCucumberReport();
        prettyCucumberReport.generateReports();
    }
}
