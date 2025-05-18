package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.BaseTest;

@Feature("Arama Fonksiyonu")
public class SearchTest extends BaseTest {

    @Test(description = "Ana sayfadan arama yapıldığında ilgili sonuçlar gelmeli")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ana sayfadaki arama çubuğuna ürün adı girilir ve sonuçların listelendiği doğrulanır.")
    public void testProductSearch() {
        driver.get("https://magento.softwaretestingboard.com/");
        SearchPage searchPage = new SearchPage(driver);

        String productToSearch = "jacket";
        searchPage.searchForProduct(productToSearch);

        String foundProduct = searchPage.getFirstProductName().toLowerCase();
        Assert.assertTrue(foundProduct.contains("jacket"),
                "Arama sonucu ürün adında beklenen kelime yok: " + foundProduct);
        screenshot();
    }
}
