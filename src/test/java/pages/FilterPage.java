package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {
    WebDriver driver;
    WebDriverWait wait;

    By womenTopsMenu = By.linkText("Women");
    By jacketsSubCategory = By.linkText("Jackets");

    By colorFilterTitle = By.xpath("//div[@id='narrow-by-list']//div[contains(@class,'filter-options-title') and text()='Color']");
    By colorBlackCheckbox = By.xpath("//div[@id='narrow-by-list']//a[contains(text(),'Black')]");

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToWomenJacketsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(womenTopsMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(jacketsSubCategory)).click();
    }

    public void openColorFilterDropdown() {
        WebElement colorTitle = wait.until(ExpectedConditions.elementToBeClickable(colorFilterTitle));
        colorTitle.click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectBlackColorFilter() {
        WebElement blackCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(colorBlackCheckbox));

        try {
            blackCheckbox.click();
        } catch (Exception e) {
            Actions actions = new Actions(driver);
            actions.moveToElement(blackCheckbox).click().perform();
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
