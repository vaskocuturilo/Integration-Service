package restapi.cms;

import org.testng.annotations.Test;
import cms.CmsServicePage;

public class CmsTest {

    @Test(description = "Проверка категории частые вопросы. Вопросы отдельной категории, список категорий, топ категориий")
    public void getCmsFaq() {
        CmsServicePage cmsServicePage = new CmsServicePage();
        cmsServicePage.assertFaqCmsMain();
    }

    @Test(description = "Проверка категории частые вопросы. Вопросы отдельной категории.")
    public void getCategoryOfQuestions() {
        CmsServicePage cmsServicePage = new CmsServicePage();
        cmsServicePage.assertCategoryOfQuestionsInFaq();
    }

}
