package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/demoLogin.feature",
        glue = "stepDefinitions"
)
public class TestProjRunner extends AbstractTestNGCucumberTests {
}
