import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import static data.TestData.*;

public class RegistrationTest extends BaseUiTest {

    @Test
    @DisplayName("Проверить успешную регистрацию пользователя")
    @Description("проверить что пользователь может зарегистрироваться если введет валидные данные")
    public void testSuccessfulRegistrationUser() {
        // Открыть сайт
        driver.get(BASE_URI);
        // Кликнуть по кнопке "Личный кабинет" в хейдере страницы
        mainRegistrationPage.clickButtonPersonalAccount();
        // Кликнуть по кнопке "Зарегистрироваться" в форме "Вход"
        mainRegistrationPage.clickButtonFormRegistration();
        // Проверить видимость формы регистрации
        mainRegistrationPage.visibilityFormRegistration();
        // Заполнить поля в форме регистрации
        mainRegistrationPage.fillingFormRegistration(NAME, EMAIL, PASSWORD);
        // Нажать на кнопку "Зарегистрироваться" в форме регистрации
        mainRegistrationPage.clickButtonRegister();
        //Проверить видимость кнопки Войти
        String text = mainRegistrationPage.visibilityButtonLogin();
        Assert.assertEquals("Вход", text);
    }

    @Test
    @DisplayName("Проверить успешную регистрацию пользователя")
    @Description("проверить что пользователь может зарегистрироваться если введет валидные данные")
    public void testErrorIncorrectPasswordRegistrationUser() {
        // Открыть сайт
        driver.get(BASE_URI);
        // Кликнуть по кнопке "Личный кабинет" в хейдере страницы
        mainRegistrationPage.clickButtonPersonalAccount();
        // Кликнуть по кнопке "Зарегистрироваться" в форме "Вход"
        mainRegistrationPage.clickButtonFormRegistration();
        // Проверить видимость формы регистрации
        mainRegistrationPage.visibilityFormRegistration();
        // Заполнить поля в форме регистрации
        mainRegistrationPage.fillingFormRegistration(NAME, EMAIL, INVALID_PASSWORD);
        // Нажать на кнопку "Зарегистрироваться" в форме регистрации
        mainRegistrationPage.clickButtonRegister();
        //Проверить видимость текста "Некорректный пароль"
        String text = mainRegistrationPage.visibilityErrorIncorrectPassword();
        Assert.assertEquals("Некорректный пароль", text);
    }
}
