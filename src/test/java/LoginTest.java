import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserLoginModel;
import model.UserModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.MainLoginPage;
import page.MainRegistrationPage;

import static Steps.UserApiSteps.createUser;
import static Steps.UserApiSteps.deleteUser;
import static data.TestData.*;

public class LoginTest extends BaseUiTest{
    private String token;
    private UserLoginModel user;
    protected MainRegistrationPage mainRegistrationPage;
    protected MainLoginPage mainLoginPage;

    @Before
    public void setUp() {
        mainRegistrationPage = new MainRegistrationPage(driver);
        mainLoginPage = new MainLoginPage(driver);

        UserModel newUser = new UserModel(EMAIL, PASSWORD, NAME);
        Response response = createUser(newUser);
        token = response.jsonPath().getString("accessToken");
        user = new UserLoginModel(EMAIL, PASSWORD);
       //createUser(user);
    }

    @Test
    @DisplayName("Проверить вход по кнопке «Личный кабинет» в шапке главной странице")
    @Description("Пользователь может авторизоваться через кнопку «Личный кабинет» в шапке главной странице")
    public void testButtonPersonalAccount() {
        // Открыть сайт
        driver.get(BASE_URI);
        // Кликнуть по кнопке "Личный кабинет" в хейдере страницы
        mainRegistrationPage.clickButtonPersonalAccount();
        //Проверить видимость формы Вход
        mainLoginPage.visibilityFormLogin();
        // Заполнить поля Email и Пароль в форме Вход
        mainLoginPage.fillFieldsFormLogin(user);
        // Кликнуть по кнопке «Войти» в форме Вход
        mainLoginPage.clickButtonLoginFormLogin();
        // Проверить успешный вход в аккаунт (Видимость кнопки Оформить заказ)
        String text = mainLoginPage.visibilityButtonCheckout();
        Assert.assertEquals("Оформить заказ", text);
    }

    @Test
    @DisplayName("Проверить вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("Пользователь может авторизоваться через кнопку «Войти в аккаунт» на главной странице")
    public void testButtonLoginAccountMain() {
        // Открыть сайт
        driver.get(BASE_URI);
        // Кликнуть по кнопке "Войти в аккаунт" в хейдере страницы
        //mainRegistrationPage.clickButtonPersonalAccount();
        mainLoginPage.clickButtonLoginAccountMain();
        //Проверить видимость формы Вход
        mainLoginPage.visibilityFormLogin();
        // Заполнить поля Email и Пароль в форме Вход
        mainLoginPage.fillFieldsFormLogin(user);
        // Кликнуть по кнопке «Войти» в форме Вход
        mainLoginPage.clickButtonLoginFormLogin();
        // Проверить успешный вход в аккаунт (Видимость кнопки Оформить заказ)
        String text = mainLoginPage.visibilityButtonCheckout();
        Assert.assertEquals("Оформить заказ", text);
    }

    @Test
    @DisplayName("Проверить вход по кнопке «Войти» в форме регистрации пользователя")
    @Description("Пользователь может авторизоваться через кнопку «Войти» в форме регистрации пользователя")
    public void testButtonLoginFormRegistration() {
        // Открыть сайт
        driver.get(BASE_URI);
        // Кликнуть по кнопке "Войти в аккаунт" в хейдере страницы
        mainLoginPage.clickButtonLoginAccountMain();
        //Проверить видимость формы Вход
        mainLoginPage.visibilityFormLogin();
        // Кликнуть по кнопке "Зарегистрироваться" в форме "Вход"
        mainRegistrationPage.clickButtonFormRegistration();
        // Проверить видимость формы регистрации
        mainRegistrationPage.visibilityFormRegistration();
        // Кликнуть по кнопке "Войти" для перехода в форму Вход
        mainLoginPage.clickButtonLoginGoLoginForm();
        // Заполнить поля Email и Пароль в форме Вход
        mainLoginPage.fillFieldsFormLogin(user);
        // Кликнуть по кнопке «Войти» в форме Вход
        mainLoginPage.clickButtonLoginFormLogin();
        // Проверить успешный вход в аккаунт (Видимость кнопки Оформить заказ)
        String text = mainLoginPage.visibilityButtonCheckout();
        Assert.assertEquals("Оформить заказ", text);
    }

    @Test
    @DisplayName("Проверить вход по кнопке «Войти» в форме восстановления пароля")
    @Description("Пользователь может авторизоваться через кнопку «Войти» в форме восстановления пароля")
    public void testButtonLoginFormPasswordRecovery() {
        // Открыть сайт
        driver.get(BASE_URI);
        // Кликнуть по кнопке "Войти в аккаунт" в хейдере страницы
        mainLoginPage.clickButtonLoginAccountMain();
        //Проверить видимость формы Вход
        mainLoginPage.visibilityFormLogin();
        // Кликнуть по кнопке "Зарегистрироваться" в форме "Вход"
        mainLoginPage.clickButtonRestorePasswordFormLogin();
        // Проверить видимость формы регистрации
        mainLoginPage.visibilityFormPasswordRecovery();
        // Кликнуть по кнопке "Войти" для перехода в форму Вход
        mainLoginPage.clickButtonLoginGoLoginForm();
        // Заполнить поля Email и Пароль в форме Вход
        mainLoginPage.fillFieldsFormLogin(user);
        // Кликнуть по кнопке «Войти» в форме Вход
        mainLoginPage.clickButtonLoginFormLogin();
        // Проверить успешный вход в аккаунт (Видимость кнопки Оформить заказ)
        String text = mainLoginPage.visibilityButtonCheckout();
        Assert.assertEquals("Оформить заказ", text);
    }

    @After
    public void cleanUp() {
        if (token != null) {
            deleteUser(token);
        }
    }

}
