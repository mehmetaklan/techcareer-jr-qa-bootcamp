package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By menMenu = By.linkText("Men");
    By topsMenu = By.linkText("Tops");
    By jacketsLink = By.linkText("Jackets");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToJacketsSection() {
        Actions actions = new Actions(driver);

        WebElement men = wait.until(ExpectedConditions.visibilityOfElementLocated(menMenu));
        actions.moveToElement(men).perform();

        WebElement tops = wait.until(ExpectedConditions.visibilityOfElementLocated(topsMenu));
        actions.moveToElement(tops).perform();

        WebElement jackets = wait.until(ExpectedConditions.elementToBeClickable(jacketsLink));
        jackets.click();
    }
}
