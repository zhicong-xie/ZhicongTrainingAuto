package gt.org.CucumberReport;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PrettyCucumberReport {

    public void generateReports() {
        System.out.println("The cucumber report is being generated. . .");
        File reportOutputDirectory = new File("target/cucumberReport");
        List<String> jsonFiles = new ArrayList();
        jsonFiles.add("target/cucumber-report/cucumber.json");
        String buildNumber = "v1.0";
        String projectName = "Zhicong cucumber Report";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
        System.out.println(
                "The cucumber report generated! Save in 'ZhicongTrainingAuto/target/cucumberReport/cucumber-html-reports' folder");
    }

  public static void main(String[] args) {
    PrettyCucumberReport prettyCucumberReport = new PrettyCucumberReport();
    prettyCucumberReport.generateReports();
  }
}
