package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstNameInput = By.id("firstname");
    By lastNameInput = By.id("lastname");
    By emailInput = By.id("email_address");
    By passwordInput = By.id("password");
    By confirmPasswordInput = By.id("password-confirmation");
    By createAccountButton = By.cssSelector("button[title='Create an Account']");

    // Actions
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }
}
