package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonAPI {

    public void waitUntilClickAble(WebDriver driver, By locator) {
        int waitInSeconds = 20;
        Duration durationInSeconds = Duration.ofSeconds(waitInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilVisible(WebDriver driver, By locator) {
        int waitInSeconds = 20;
        Duration durationInSeconds = Duration.ofSeconds(waitInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement (WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    public void enterText (WebDriver driver, By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void selectElement (WebDriver driver, By locator, String visibleText) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }
}
