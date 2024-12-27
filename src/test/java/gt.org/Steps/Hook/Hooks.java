package gt.org.Steps.Hook;

import gt.org.Base.AppiumHelpers;
import gt.org.utils.DriverManager;
import io.cucumber.java.*;

public class Hooks extends AppiumHelpers {
    private String currentStepName;
    private static DriverManager driverManager;

    public Hooks() {
        driverManager = DriverManager.getInstance();
    }

    @Before
    public void startRecording(Scenario scenario) throws InterruptedException {
        String scenarioName = scenario.getName();
        driverManager.startRecording(scenarioName);
    }

    @After
    public void stopRecording(Scenario scenario) {
        String scenarioName = scenario.getName();
        driverManager.stopScreenRecording(scenarioName);
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
            System.out.println("Scenario failed. Restarting the app...\n");
            driverManager.restartApp();
        }
    }

    @AfterAll
    public static void beautifyCucumberReport() {
        System.out.println("All Scenario execution completed. Quit the app...\n");
        driverManager.quitApp();
    }
}
