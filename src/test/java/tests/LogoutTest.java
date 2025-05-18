package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import utils.BaseTest;

@Feature("Çıkış İşlemleri")
public class LogoutTest extends BaseTest {

    @Test(description = "Giriş yapılmış kullanıcı çıkış yapabilmeli")
    @Severity(SeverityLevel.NORMAL)
    @Description("Giriş yapan kullanıcı profil menüsünden çıkış yapar ve giriş sayfasına yönlendirilir.")

    public void testLogout() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("Test1234@mail.com");
        loginPage.enterPassword("Test1234!");
        loginPage.clickSignIn();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Giriş başarısız!");

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickLogout();

        Assert.assertTrue(logoutPage.isLoggedOut(), "Çıkış işlemi başarısız!");
        screenshot();
    }
}
