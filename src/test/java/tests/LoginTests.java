package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

@Feature("Giriş İşlemleri")
public class LoginTests extends BaseTest {

    @Test(description = "Yanlış kullanıcı bilgileri ile giriş başarısız olmalı")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Geçersiz giriş bilgileri ile hata mesajı gösterilir.")

    public void testInvalidPasswordLogin() throws InterruptedException {

        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("error@gmail.com");
        loginPage.enterPassword("test123456");
        loginPage.clickSignIn();

        Assert.assertTrue(loginPage.getErrorMessage().contains("The account sign-in was incorrect"),
                "Beklenen hata mesajı görüntülenmedi.");
        screenshot();
        Thread.sleep(3000);
    }

    @Test(description = "Doğru kullanıcı bilgileri ile giriş yapılmalı")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Geçerli kullanıcı maili ve şifresi ile giriş yapılır, başarılı giriş kontrol edilir.")

    public void testSuccessfulLogin() {

        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("Test1234@mail.com");
        loginPage.enterPassword("Test1234!");
        loginPage.clickSignIn();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Başarılı giriş yapılamadı.");
        screenshot();
    }
}
