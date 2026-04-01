import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static data.TestData.BASE_URI;

public class ConstructorSectionTest extends BaseUiTest{

    @Test
    @DisplayName("Кликнуть вкладку Булки на главной странице")
    @Description("Вкладка Булки стала активной после клика на нее")
    public void testActiveSectionsBun() {
        // Открыть сайт
        driver.get(BASE_URI);
        mainConstructorSectionPage.clickButtonSauce();
        mainConstructorSectionPage.clickButtonBun();
        String text = mainConstructorSectionPage.returnActiveSectionsBun();
        Assert.assertEquals("Булки",text);
    }

    @Test
    @DisplayName("Нажать на вкладку Соусы на главной странице")
    @Description("Вкладка Соусы стала активной после клика на нее")
    public void testTransitionSauceButton() {
        // Открыть сайт
        driver.get(BASE_URI);
        mainConstructorSectionPage.clickButtonSauce();
        String text = mainConstructorSectionPage.returnActiveSectionsSauce();
        Assert.assertEquals("Соусы",text);
    }

    @Test
    @DisplayName("Нажать на вкладку Начинки на главной странице")
    @Description("Вкладка Начинки стала активной после клика на нее")
    public void testTransitionStuffingButton() {
        // Открыть сайт
        driver.get(BASE_URI);
        mainConstructorSectionPage.clickButtonStuffing();
        String text = mainConstructorSectionPage.returnActiveSectionsStuffing();
        Assert.assertEquals("Начинки", text);
    }
}
