# 🧪 Test Automation Project – Magento Demo Site

Bu proje, [Magento Demo Site](https://magento.softwaretestingboard.com/) üzerinde **Selenium WebDriver**, **TestNG**, **Allure** ve **Page Object Model (POM)** kullanılarak UI test otomasyonu senaryoları geliştirmek amacıyla oluşturulmuştur.

---

## 🚀 Kullanılan Teknolojiler

- Java 21 (JDK)
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager
- Allure Report

---


---

## ✅ Test Senaryoları

| Test Adı              | Açıklama                                                                 |
|-----------------------|--------------------------------------------------------------------------|
| **LoginTest**         | Geçerli kullanıcı bilgileri ile giriş yapılmasını test eder.            |
| **LogoutTest**        | Kullanıcının başarılı şekilde çıkış yapmasını test eder.                |
| **AddToCartTest**     | Ürün sepete eklendikten sonra başarılı mesaj kontrol edilir.            |
| **EndToEndCartTest**  | Ürün eklenip sepete gidilir ve ürün silme işlemi gerçekleştirilir.      |
| **SearchTest**        | Ürün arama işlemi gerçekleştirilir ve sonuçlar kontrol edilir.          |
| **FilterTest**        | Kadın > Ceket kategorisinde siyah renk filtresi uygulanır.              |
| **RegisterTest**      | Yeni bir kullanıcı başarılı şekilde kayıt olur.                          |
| **ForgotPasswordTest**| Şifre sıfırlama işlemi gerçekleştirilir.                                |
| **CheckoutTest**      | Misafir kullanıcı ürün ekler ve ödeme adımına ulaşır.                    |

---


---

## 🔧 Proje Kurulumu

1. **Gerekli Bağımlılıkların Yüklenmesi**

   Maven yüklü değilse:  
   - [Maven İndir](https://maven.apache.org/download.cgi)  
   - İndirdikten sonra, Maven’in `bin` klasörünü sistem PATH değişkenine ekleyin.

2. Proje dizininde terminal açarak aşağıdaki komutu çalıştırın:

   ```bash
   mvn clean install

   🚀 Testleri Çalıştırma
Testleri çalıştırmak için terminalden aşağıdaki komutu kullanın:

mvn clean test

Allure Raporunu Görüntüleme
Test çalıştıktan sonra Allure raporunu açmak için şu komutu kullanabilirsiniz:

allure serve target/allure-results

📂 Proje Yapısı


```
TestAutomation/
├── pom.xml
├── testng.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/         # Page Object Model sınıfları
│   └── test/
│       └── java/
│           └── tests/         # Test senaryoları
├── target/
│   └── allure-results/        # Allure test çıktıları
```



📌 Önemli Notlar

Tüm testlerde WebDriverWait ile beklemeler yönetilmektedir.

Testler testng.xml üzerinden organize edilmiştir.

Allure raporları testler sonunda otomatik olarak oluşturulmaktadır.

İlerleyen versiyonlarda ekran görüntüsü alma ve diğer iyileştirmeler eklenebilir.

Proje Tarihi: Mayıs 2025

