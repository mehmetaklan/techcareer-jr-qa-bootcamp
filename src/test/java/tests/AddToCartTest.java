package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;

@Feature("Sepete Ürün Ekleme")
public class AddToCartTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test (description = "Bir Ürün sepete eklendiğinde başarılı mesajı alınmalı ve sağ üstteki sepet sayısı artmalı")
    @Description("Test senaryosu: Ürün detay sayfasından beden ve renk seçilip sepete eklenmeli")
    public void testAddProductToCartWithWait() {
        HomePage home = new HomePage(driver);
        home.goToJacketsSection();

        ProductDetailPage pdp = new ProductDetailPage(driver);
        pdp.selectFirstProduct();
        pdp.selectSizeAndColor();
        pdp.addToCart();

        String message = pdp.getSuccessMessage();
        Assert.assertTrue(message.contains("You added"), "Başarı mesajı görüntülenmedi: " + message);
        screenshot();
    }

}
