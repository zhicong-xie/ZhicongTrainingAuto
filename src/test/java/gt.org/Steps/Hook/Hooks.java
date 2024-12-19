package gt.org.Steps.Hook;

import gt.org.Base.AppiumHelpers;
import gt.org.CucumberReport.PrettyCucumberReport;
import gt.org.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends AppiumHelpers {
    private String currentStepName;
    private static DriverManager driverManager;

    public Hooks(){
        driverManager = DriverManager.getInstance();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            currentStepName = scenario.getName();
            byte[] screenshot = takeFailScreenshot();
            scenario.attach(screenshot, "image/png", currentStepName + "_" + System.currentTimeMillis());
        }
    }

    @After
    public void restartAppOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed. Restarting the app...");
            driverManager.restartApp();
        }
    }

    @AfterAll
    public static void beautifyCucumberReport() {
        System.out.println("All Scenario execution completed. Quit the app...");
        driverManager.quitApp();
    }
}
