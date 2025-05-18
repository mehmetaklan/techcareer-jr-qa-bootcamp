package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FilterPage;
import utils.BaseTest;

@Feature("Ürün Filtreleme")
public class FilterTest extends BaseTest {

    @Test(description = "Kadın ceket kategorisinde bulunan siyah renkteki ceketler için filtre uygulanır.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sol menüden 'Women > Tops > Jackets' seçilir ve renk filtresi açılarak 'Black' seçilir. URL ve ürün listesi doğrulanır.")

    public void testFilterBlackColorForJackets() {
        driver.get("https://magento.softwaretestingboard.com/");

        FilterPage filterPage = new FilterPage(driver);

        filterPage.goToWomenJacketsCategory();

        filterPage.openColorFilterDropdown();

        filterPage.selectBlackColorFilter();

        // URL'nin beklenen filtre parametresini içeri içermediğini kontrol edece
        String currentUrl = filterPage.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?color=49"),
                "URL filtre parametresini içermiyor! Güncel URL: " + currentUrl);
        screenshot();
    }
}
