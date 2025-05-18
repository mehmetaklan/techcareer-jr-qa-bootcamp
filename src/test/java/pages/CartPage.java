package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    private By cartIcon = By.cssSelector("a.showcart");
    private By viewAndEditCartLink = By.linkText("View and Edit Cart");
    private By removeItemLink = By.cssSelector("a.action.action-delete");
    private By emptyCartMessage = By.cssSelector("div.cart-empty");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openCartDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public void clickViewAndEditCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAndEditCartLink)).click();
    }

    public void removeItemFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemLink)).click();

    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)).isDisplayed();
    }
}
