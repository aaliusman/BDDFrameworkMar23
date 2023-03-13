package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonAPI;

public class HomePage {

    CommonAPI commonAPI = new CommonAPI();

    By productDropDown = By.id("popDropdown");
    By zipCodeInputField = By.xpath("//input[@id='quote-main-zip-code-input']");
    By startQuoteButton = By.cssSelector("#quote-main-zip-btn");


    public void selectProduct (WebDriver driver) {
        commonAPI.selectElement(driver, productDropDown, "Homeowners");
    }

    public void enterZipCode (WebDriver driver) {
        commonAPI.enterText(driver,zipCodeInputField, "19047" );
    }

    public void clickStartQuote (WebDriver driver) {
        commonAPI.clickElement(driver, startQuoteButton);
    }
}
