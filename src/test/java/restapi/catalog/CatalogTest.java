package restapi.catalog;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import catalog.CatalogServicePage;

public class CatalogTest {

    @Test(description = "Каталог.Список категории. Без авторизации. Регион РФ.")
    public void getCatalogService() {
        CatalogServicePage catalogServicePage = new CatalogServicePage();
        catalogServicePage.assertTheListOfCategories();
    }

    @Test(description = "Каталог.Детализация категории family, регион Москва.")
    public void getDetailCategoryFamilyMoscowRegion() {
        CatalogServicePage catalogServicePage = new CatalogServicePage();
        catalogServicePage.assertCategoryDetail("family", "45000000000");
    }

    @Test(description = "Каталог.Детализация категории passport, регион Москва.")
    public void getDetailCategoryPassportMoscowRegion() {
        CatalogServicePage catalogServicePage = new CatalogServicePage();
        catalogServicePage.assertCategoryDetail("passport", "45000000000");
    }

    @Test(description = "Каталог.Детализация категории property, регион Москва.")
    public void getDetailCategoryPropertyMoscowRegion() {
        CatalogServicePage catalogServicePage = new CatalogServicePage();
        catalogServicePage.assertCategoryDetail("property", "45000000000");
    }


    @Test(description = "Каталог. Список паспортов для мобильных устройств. Ios")
    @Severity(SeverityLevel.CRITICAL)
    public void getListPassportsMobileDevicesIos() {
        CatalogServicePage catalogServicePage = new CatalogServicePage();
        catalogServicePage.assertListOfPassportsForMobileDevices("ios_3.3.1");
    }

    @Test(description = "Каталог. Список паспортов для мобильных устройств.Android")
    @Severity(SeverityLevel.CRITICAL)
    public void getListPassportsMobileDevicesAndroid() {
        CatalogServicePage catalogServicePage = new CatalogServicePage();
        catalogServicePage.assertListOfPassportsForMobileDevices("android_7.0.0");
    }
}
