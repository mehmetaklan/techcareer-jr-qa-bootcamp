package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By accountMenu = By.cssSelector("button.action.switch"); // Profil dropdown
    private By signOutLink = By.linkText("Sign Out"); // "Sign Out" link
    private By logoutMessage = By.cssSelector("div.message-success"); // Başarı mesajı

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(accountMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
    }

    public boolean isLoggedOut() {

        return wait.until(ExpectedConditions.urlContains("/customer/account/logoutSuccess/")) ||
                driver.getPageSource().contains("You are signed out");
    }
}
