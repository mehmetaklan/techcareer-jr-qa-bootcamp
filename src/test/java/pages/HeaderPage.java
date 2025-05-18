package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
    WebDriver driver;
    WebDriverWait wait;

    private By accountMenu = By.cssSelector("button[data-action='customer-menu-toggle']");
    private By signOutLink = By.linkText("Sign Out");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openAccountMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(accountMenu)).click();
    }

    public void clickSignOut() {
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
    }

    public void logout() {
        openAccountMenu();
        clickSignOut();
    }
}
