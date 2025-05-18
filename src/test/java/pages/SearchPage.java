package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.id("search");
    By searchButton = By.cssSelector("button.action.search");
    By firstProductName = By.cssSelector("li.product-item .product-item-link");

    public void searchForProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getFirstProductName() {
        return driver.findElement(firstProductName).getText();
    }
}
