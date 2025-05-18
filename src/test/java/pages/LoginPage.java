package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By emailInput = By.id("email");
    By passwordInput = By.id("pass");
    By signInButton = By.id("send2");

    // Başarılı loginlocator
    By welcomeMessage = By.cssSelector("li.greet.welcome");

    // Başarısız login locator
    By errorMessage = By.cssSelector("div.message-error");

    // Actions
    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isLoginSuccessful() {
        try {
            return driver.findElement(welcomeMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
