package cms;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static webconfig.WebConfig.BASE_CONFIG;

/**
 * An Class cms service page.
 */
@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyStaticImports", "PMD.TooManyMethods", "PMD.AvoidDuplicateLiterals", "PMD.LawOfDemeter"})
public class CmsServicePage {

    /**
     * Constant SUCCESS.
     */
    private static final int SUCCESS = 200;

    /**
     * Constant FAQ_CMS.
     */
    private static final String FAQ_CMS = "/api/cms/v1/faq/";

    /**
     * Constant baseUrl. For the RestAssured.baseUrl.
     */
    private final transient String baseUrl;


    /**
     * Default Constructor.
     */
    public CmsServicePage() {
        this.baseUrl = BASE_CONFIG.getUrl();
    }

    /**
     * Method assert faq cms main.
     *
     * @return this.
     */
    public CmsServicePage assertFaqCmsMain() {
        final RequestSpecification request = given();
        final Response response = request.get(baseUrl + FAQ_CMS + "main");
        final List<String> mainTitleCollection = response.jsonPath().getList("title");
        request.then()
                .log().ifError().statusCode(SUCCESS)
                .body("title", hasItems(mainTitleCollection.toArray()));

        return this;
    }

    /**
     * Method assert category of questions in faq.
     *
     * @return this.
     */
    public CmsServicePage assertCategoryOfQuestionsInFaq() {
        final RequestSpecification request = given();
        final Response response = request.get(baseUrl + FAQ_CMS);
        final List<String> faqTitleCollection = response.jsonPath().getList("title");
        request
                .then()
                .log().ifError().statusCode(SUCCESS)
                .body("title", hasItems(faqTitleCollection.toArray()));

        return this;
    }


}
