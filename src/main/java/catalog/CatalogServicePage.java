package catalog;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static webconfig.WebConfig.BASE_CONFIG;

/**
 * An Class cms service page.
 */
@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyStaticImports", "PMD.TooManyMethods", "PMD.AvoidDuplicateLiterals", "PMD.LawOfDemeter"})
public class CatalogServicePage {

    /**
     * Constant FAMILY_CATEGORY.
     */
    private static final String FAMILY_CATEGORY = "family";

    /**
     * Constant PASSPORT_CATEGORY.
     */
    private static final String PASSPORT_CATEGORY = "passport";

    /**
     * Constant PROPERTY_CATEGORY.
     */
    private static final String PROPERTY_CATEGORY = "property";

    /**
     * Constant MOSCOW_REGION.
     */
    private static final String MOSCOW_REGION = "45000000000";

    /**
     * Constant SUCCESS.
     */
    private static final int SUCCESS = 200;

    /**
     * Constant SUCCESS.
     */
    private static final String MAIN_LINK_CATALOG = "/api/catalog/v3/";

    /**
     * Constant baseUrl. For the RestAssured.baseUrl.
     */
    private final transient String baseUrl;

    /**
     * Default Constructor.
     */
    public CatalogServicePage() {
        this.baseUrl = BASE_CONFIG.getUrl();
    }

    /**
     * Method assert the list of categories without authorization.
     */
    public void assertTheListOfCategories() {
        final RequestSpecification request = given();
        final Response response = request.get(baseUrl + MAIN_LINK_CATALOG + "categories?_&platform=EPGU_V3&userType=");
        final List<String> codeCatalogService = response.jsonPath().getList("code");
        final List<String> titleCatalogService = response.jsonPath().getList("title");
        final List<String> descriptionCatalogService = response.jsonPath().getList("description");
        final List<String> passportsTitle = response.jsonPath().getList("passports.title");
        final List<String> passportsShortTitle = response.jsonPath().getList("passports.shortTitle");
        response.then()
                .log().ifError().statusCode(SUCCESS)
                .body("id", notNullValue())
                .body("code", hasItems(codeCatalogService.toArray()))
                .body("title", hasItems(titleCatalogService.toArray()))
                .body("description", hasItems(descriptionCatalogService.toArray()))
                .body("icons.path", notNullValue())
                .body("icons.iconType", hasItems(hasItems("small")))
                .body("passports.id", notNullValue())
                .body("passports.epguId", notNullValue())
                .body("passports.title", hasItems(passportsTitle.toArray()))
                .body("passports.shortTitle", hasItems(passportsShortTitle.toArray()))
                .body("passports.descr", notNullValue())
                .body("passports.stateStructureId", notNullValue())
                .body("passports.stateStructure", notNullValue());
    }


    /**
     * Method assert the category detail.
     *
     * @param codeCategory code of category.
     * @param codeRegion   code of region.
     */
    public void assertCategoryDetail(final String codeCategory, final String codeRegion) {
        if (FAMILY_CATEGORY.equals(codeCategory) && MOSCOW_REGION.equals(codeRegion)) {
            final RequestSpecification request = given();
            final Response response = request.get(baseUrl + MAIN_LINK_CATALOG + "categories/" + codeCategory + "?_platform=EPGU_V3&region=" + codeRegion);
            final String codeCatalogService = response.jsonPath().getString("code");
            final String titleCatalogService = response.jsonPath().getString("title");
            final String descriptionCatalogService = response.jsonPath().getString("description");
            given().get(baseUrl + MAIN_LINK_CATALOG + "categories/" + codeCategory + "?_platform=EPGU_V3&region=" + codeRegion).then()
                    .log().ifError().statusCode(SUCCESS)
                    .body("id", notNullValue())
                    .body("code", equalTo(codeCatalogService))
                    .body("title", equalTo(titleCatalogService))
                    .body("description", equalTo(descriptionCatalogService))
                    .body("icons.path", notNullValue())
                    .body("icons.iconType", notNullValue());
        } else if (PASSPORT_CATEGORY.equals(codeCategory) && MOSCOW_REGION.equals(codeRegion)) {
            final RequestSpecification request = given();
            final Response response = request.get(baseUrl + MAIN_LINK_CATALOG + "categories/" + codeCategory + "?_platform=EPGU_V3&region=" + codeRegion);
            final String codeCatalogService = response.jsonPath().getString("code");
            final String titleCatalogService = response.jsonPath().getString("title");
            final String descriptionCatalogService = response.jsonPath().getString("description");
            given().get(baseUrl + MAIN_LINK_CATALOG + "categories/" + codeCategory + "?_platform=EPGU_V3&region=" + codeRegion).then()
                    .log().ifError().statusCode(SUCCESS)
                    .body("id", notNullValue())
                    .body("code", equalTo(codeCatalogService))
                    .body("title", equalTo(titleCatalogService))
                    .body("description", equalTo(descriptionCatalogService))
                    .body("icons.path", notNullValue())
                    .body("icons.iconType", notNullValue());
        } else if (PROPERTY_CATEGORY.equals(codeCategory) && MOSCOW_REGION.equals(codeRegion)) {
            final RequestSpecification request = given();
            final Response response = request.get(baseUrl + MAIN_LINK_CATALOG + "categories/" + codeCategory + "?_platform=EPGU_V3&region=" + codeRegion);
            final String codeCatalogService = response.jsonPath().getString("code");
            final String titleCatalogService = response.jsonPath().getString("title");
            final String descriptionCatalogService = response.jsonPath().getString("description");
            given().get(baseUrl + MAIN_LINK_CATALOG + "categories/" + codeCategory + "?_platform=EPGU_V3&region=" + codeRegion).then()
                    .log().ifError().statusCode(SUCCESS)
                    .body("id", notNullValue())
                    .body("code", equalTo(codeCatalogService))
                    .body("title", equalTo(titleCatalogService))
                    .body("description", equalTo(descriptionCatalogService))
                    .body("icons.path", notNullValue())
                    .body("icons.iconType", notNullValue());
        } else {
            throw new IllegalStateException("Данная услуга " + codeCategory + " или код региона " + codeRegion + " отсутствует в списке");
        }
    }

    /**
     * Method assert list Of passports for mobile devices.
     *
     * @param namePlatform name platform (ios or android and version)
     */
    public void assertListOfPassportsForMobileDevices(final String namePlatform) {
        switch (namePlatform) {
            case "ios_3.3.1":
                given()
                        .header("mobVersion", namePlatform)
                        .when()
                        .get(baseUrl + MAIN_LINK_CATALOG + "mobile/catalog")
                        .then()
                        .assertThat()
                        .body("category.name", hasItems("biz_main", "main", "catalog"))
                        .body("category.passports", notNullValue())
                        .log().ifError().statusCode(SUCCESS);
                break;
            case "android_7.0.0":
                given()
                        .header("mobVersion", namePlatform)
                        .when()
                        .get(baseUrl + MAIN_LINK_CATALOG + "mobile/catalog")
                        .then()
                        .assertThat()
                        .body("category.name", hasItems("biz_main", "main", "catalog"))
                        .body("category.passports", notNullValue())
                        .log().ifError().statusCode(SUCCESS);
                break;
            default:
                throw new IllegalStateException("Данная версия мобильной платформы " + namePlatform + "отсуствует в списке");
        }
    }


}


