package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.BaseTest;

@Feature("Kayıt İşlemleri")
public class RegisterTest extends BaseTest {

    @Test(description = "Yeni kullanıcı kayıt formu doldurulup başarı ile kayıt olmalı")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanıcı kayıt sayfasına gider, formu doldurur, kayıt olur ve doğrulama yapılır.")

    public void testUserCanRegisterSuccessfully() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        RegisterPage registerPage = new RegisterPage(driver);

        String randomEmail = "user" + System.currentTimeMillis() + "@gmail.com";

        registerPage.enterFirstName("Test");
        registerPage.enterLastName("User");
        registerPage.enterEmail(randomEmail);
        registerPage.enterPassword("Test1234!");
        registerPage.enterConfirmPassword("Test1234!");
        registerPage.clickCreateAccount();

        // Assertion: Kullanıcı "My Account" sayfasına gitti mi?
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Kayıt başarılı.");
        Thread.sleep(5000);
        screenshot();
    }
}
