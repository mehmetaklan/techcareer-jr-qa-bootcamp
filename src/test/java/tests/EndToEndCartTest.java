package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductDetailPage;
import utils.BaseTest;

@Feature("Sepet İşlemleri - Tüm İşlemler(E2E)")
public class EndToEndCartTest extends BaseTest {

    @Test(description = "Bir ürün sepete eklenir, aynı ürün sepette görüntülenir ve sepetten silinir.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Kullanıcı ürün ekler, sepete gider, ürünün sepette olduğunu doğrular ve sonra ürünü siler.")
    public void testAddViewAndRemoveProductFromCart() {
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");

        // Ürün detay işlemleri
        ProductDetailPage productPage = new ProductDetailPage(driver);
        productPage.selectFirstProduct();
        productPage.selectSizeAndColor();
        productPage.addToCart();
        screenshot();

        // Sepete eklendi doğrulama
        String successMsg = productPage.getSuccessMessage();
        Assert.assertTrue(successMsg.toLowerCase().contains("added"),
                "Ürün sepete eklenemedi! Mesaj: " + successMsg);
        screenshot();

        // Sepete gitme ve doğrulama
        CartPage cartPage = new CartPage(driver);
        cartPage.openCartDropdown();
        cartPage.clickViewAndEditCart();


        Assert.assertTrue(driver.getCurrentUrl().contains("/checkout/cart"),
                "Sepet sayfasına yönlendirme başarısız!");
        screenshot();
        // Ürünü silme ve doğrulama
        cartPage.removeItemFromCart();

        Assert.assertTrue(cartPage.isCartEmpty(),
                "Sepet boş değil, ürün silinemedi!");
        screenshot();
    }
}
