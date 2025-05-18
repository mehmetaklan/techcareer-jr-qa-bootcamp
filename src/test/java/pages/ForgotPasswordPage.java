package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    WebDriver driver;
    WebDriverWait wait;

    private By emailInput = By.id("email_address");
    private By submitButton = By.cssSelector("button.action.submit.primary");
    private By confirmationMessage = By.cssSelector("div.message-success");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateTo() {
        // Şifre sıfırlama sayfası URL'si
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void submitRequest() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
    }
}
