package stepDefinitions;

import driver.WebDriverInitiate;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utilities.CommonAPI;

import java.io.ByteArrayInputStream;

public class StepDefForTestProj extends CommonAPI {

    WebDriver driver = null;
    WebDriverInitiate webDriverInitiate = new WebDriverInitiate();

    @Before
    public void browserSetup() {
        driver = webDriverInitiate.initiateWebDriver();
        driver.get("https://example.testproject.io/web/");
    }

    @Given("user enters {string} and {string} in the input field")
    public void user_enters_and_in_the_input_field(String user, String password) throws InterruptedException {
        enterText(driver, By.id("name"), user);
        enterText(driver, By.id("password"), password);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        clickElement(driver, By.id("login"));
    }
    @Then("verify user is on the the home page with {string} message")
    public void verify_user_is_on_the_the_home_page_with(String user) throws InterruptedException {
        String expectedMessage = "Hello " +user+ ", let's complete the test form:";
       String actualMessage = getTextMethod(driver, By.id("greetings"));
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("this test should fail")
    public void this_test_should_fail() {
        Assert.assertEquals("a", "b");
    }


    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed screenshot", new ByteArrayInputStream(screenshot));
        }
        driver.close();
    }
}
