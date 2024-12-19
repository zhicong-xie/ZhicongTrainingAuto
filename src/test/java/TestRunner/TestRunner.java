package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/java/gt.org/resources/Storellet",
    glue = {"gt.org.Steps"},
        tags = "@AC2.2",
    plugin = {
      "pretty",
      "html:target/cucumber-report/report.html",
      "json:target/cucumber-report/cucumber.json"
    },
    monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {}
