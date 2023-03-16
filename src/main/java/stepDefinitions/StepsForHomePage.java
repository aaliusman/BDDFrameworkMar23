package stepDefinitions;

import driver.WebDriverInitiate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonAPI;

import java.time.Duration;

public class StepsForHomePage {

    WebDriver driver = null;
    String expectedCityName = "LANGHORNE";

    CommonAPI commonAPI = new CommonAPI();
    WebDriverInitiate  webDriverInitiate = new WebDriverInitiate();

    public void initiateWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = webDriverInitiate.initiateWebDriver();

    }

    @Given("navigate to statefarm homepage")
    public void navigate_to_statefarm_homepage() {
        initiateWebDriver();
        driver.get("https://www.statefarm.com/");
    }

    @When("user select Homeowners from product dropdown")
    public void user_select_auto_from_product_dropdown() {
//        Select select = new Select(driver.findElement(By.id("popDropdown")));
//        select.selectByVisibleText("Homeowners");
        commonAPI.selectElement(driver, By.id("popDropdown"), "Homeowners");
    }

    @When("user enters zipcode in the input field")
    public void user_enters_zipcode_in_the_input_field() {
//        driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("19047");
        commonAPI.enterText(driver, By.id("quote-main-zip-code-input"), "19047");
    }

    @When("user clicks start a quote button")
    public void user_clicks_start_a_quote_button() {
//        driver.findElement(By.id("quote-main-zip-btn")).click();
        commonAPI.clickElement(driver, By.id("quote-main-zip-btn"));
    }

    @Then("user verifies city matches with zipcode")
    public void user_verifies_city_matches_with_zipcode() throws InterruptedException {
        //Explicit wait
//        int waitInSeconds = 10;
//        Duration durationInSeconds = Duration.ofSeconds(waitInSeconds);
//        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#city")));
        commonAPI.waitUntilVisible(driver, By.cssSelector("#city"));
        String actualCityName = driver.findElement(By.cssSelector("#city")).getAttribute("value");
        Assert.assertEquals(actualCityName, expectedCityName);
        driver.quit();
    }
}