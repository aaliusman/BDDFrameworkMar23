package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/homePage.feature",
        glue = "stepDefinitions"
)
public class HomePageRunner extends AbstractTestNGCucumberTests {

}
