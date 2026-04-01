package page;

import io.qameta.allure.Step;
import model.UserLoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainLoginPage {
    private WebDriver driver;

    // Локаторы
    // Кнопка "Личны кабинет" будет применяться из class MainRegistrationPage
    // Кнопка «Войти в аккаунт» на главной
    private final By buttonLoginAccountMain = By.xpath( ".//*[text()='Войти в аккаунт']");
    // Для проверки видимости формы Вход
    private final By formLogin = By.xpath( ".//*[text()='Вход']");
    // Поле для ввода "Email" в форме входа
    private final By textFieldEmailFormLogin = By.xpath(".//label[text()='Email']/following-sibling::input[@name='name']");
    // Поле для ввода "Пароль" в форме входа
    private final By textFieldPasswordFormLogin = By.xpath(".//label[text()='Пароль']/following-sibling::input[@name='Пароль']");
    // Кнопка "Войти" в форме Вход
    private final By buttonLoginFormLogin = By.xpath(".//*[text()='Войти']");
    // Кнопка для перехода в форму регистрации "Зарегистрироваться" будет применяться локатор buttonFormRegistration class MainRegistrationPage
    // Для проверки видимости формы "Регистрация" будет применен локатор formRegistration class MainRegistrationPage
    // Кнопка "Войти" для перехода в форму Вход
    private final  By buttonLoginGoLoginForm = By.className("Auth_link__1fOlj");
    // Кнопка "Восстановить пароль" в форме Вход;
    private final By buttonRestorePasswordFormLogin = By.xpath( ".//*[text()='Восстановить пароль']");
    // Для проверки видимости формы "Восстановление пароля"
    private final By formPasswordRecovery = By.xpath(".//*[text()='Восстановление пароля']");
    // Для проверки успешного входа в аккаунт
    private final By buttonCheckout = By.xpath(".//*[text()='Оформить заказ']");

    public MainLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы
    @Step("Кликнуть по кнопке «Войти в аккаунт» на главной")
    public void clickButtonLoginAccountMain() {
        driver.findElement(buttonLoginAccountMain).click();
    }

    @Step("Проверить видимость формы Вход")
    public String  visibilityFormLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement formLoginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(formLogin));
        return formLoginElement.getText();
    }

    @Step("Заполнить поля Email и Пароль в форме Вход")
    public void fillFieldsFormLogin(UserLoginModel user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textFieldEmailFormLogin))
                .sendKeys(user.getEmail());
        wait.until(ExpectedConditions.visibilityOfElementLocated(textFieldPasswordFormLogin))
                .sendKeys(user.getPassword());
    }

    @Step("Кликнуть по кнопке «Войти» в форме Вход")
    public void clickButtonLoginFormLogin() {
        driver.findElement(buttonLoginFormLogin).click();
    }

    @Step("Кликнуть по кнопке Войти для перехода в форму Вход")
    public void clickButtonLoginGoLoginForm() {
        driver.findElement(buttonLoginGoLoginForm).click();
    }
    @Step("Кликнуть по кнопке Восстановить пароль в форме Вход")
    public void clickButtonRestorePasswordFormLogin() {
        driver.findElement(buttonRestorePasswordFormLogin).click();
    }

    @Step("Проверить видимость формы Восстановление пароля")
    public String visibilityFormPasswordRecovery() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement formPasswordRecoveryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(formPasswordRecovery));
        return formPasswordRecoveryElement.getText();
    }

    @Step("Проверить успешный вход в аккаунт (Видимость кнопки Оформить заказ)")
    public String visibilityButtonCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement buttonCheckoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCheckout));
        return buttonCheckoutElement.getText();
    }
}
