package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverInitiate {

    public WebDriver initiateWebDriver () {
//        WebDriver driver = WebDriverManager.firefoxdriver().create();

          WebDriverManager.firefoxdriver().setup();
        FirefoxOptions fo = new FirefoxOptions();
        fo.setHeadless(true);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("window-size=1400,800");
//        options.addArguments("headless");
//        WebDriver driver = new ChromeDriver(options);
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver(fo);


//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver initiateChromeDriver () {
        WebDriver driver = WebDriverManager.chromedriver().create();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("window-size=1400,800");
//        options.addArguments("headless");
//        WebDriver driver = new ChromeDriver(options);
//        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        return driver;
    }
}
