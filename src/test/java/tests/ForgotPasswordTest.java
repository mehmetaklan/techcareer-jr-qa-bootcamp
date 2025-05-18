package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import utils.BaseTest;

@Feature("Şifre Sıfırlama")
public class ForgotPasswordTest extends BaseTest {

    @Test(description = "Geçerli mail adresi girildiğinde şifre sıfırlama linki gönderilmeli")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanıcı forgot password sayfasına gider, mail adresini girer ve link gönderildiği doğrulanır.")

    public void testPasswordReset() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        forgotPasswordPage.navigateTo();
        forgotPasswordPage.enterEmail("Test1234@mail.com");
        forgotPasswordPage.submitRequest();

        String confirmation = forgotPasswordPage.getConfirmationMessage();
        Assert.assertTrue(confirmation.toLowerCase().contains("email has been sent"),
                "Şifre sıfırlama onay mesajı bulunamadı: " + confirmation);
        screenshot();
    }
}
