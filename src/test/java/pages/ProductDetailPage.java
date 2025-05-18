package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    WebDriver driver;
    WebDriverWait wait;

    By firstProduct = By.cssSelector("li.product-item a.product-item-link");
    By sizeOption = By.cssSelector(".swatch-attribute.size .swatch-option");
    By colorOption = By.cssSelector(".swatch-attribute.color .swatch-option");
    By addToCartButton = By.id("product-addtocart-button");
    By successMessage = By.cssSelector("div.message-success div");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFirstProduct() {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        product.click();
    }

    public void selectSizeAndColor() {
        WebElement size = wait.until(ExpectedConditions.elementToBeClickable(sizeOption));
        size.click();

        WebElement color = wait.until(ExpectedConditions.elementToBeClickable(colorOption));
        color.click();
    }

    public void addToCart() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
    }

    public String getSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText();
    }
}
