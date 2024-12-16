package gt.org.TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@Test
@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
      "pretty",
      "html:target/cucumber-report/",
      "json:target/cucumber-report/cucumber.json"
    },
    glue = {"gt.org.Steps"},
    //            tags = "@AC2",
    features = {"src/test/Resources/Financial Times.feature"})
public class TestRunner extends AbstractTestNGCucumberTests {}
