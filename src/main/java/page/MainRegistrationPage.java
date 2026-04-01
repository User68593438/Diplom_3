package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainRegistrationPage {
    private WebDriver driver;

    public MainRegistrationPage (WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    // Кнопка "Личный кабинет"
    private final By buttonPersonalAccount = By.xpath(".//*[text()='Личный Кабинет']");
    // Кнопка перехода в форму "Регистрация"
    private final By buttonFormRegistration = By.xpath(".//*[text()='Зарегистрироваться']");
    // Для проверки видимости формы "Регистрация"
    private final By formRegistration = By.xpath(".//*[text()='Регистрация']");
    // Поле для ввода "Имя"
    private final By textFieldName = By.xpath(".//label[text()='Имя']/following-sibling::input[@name='name']");
    // Поле для ввода "Email"
    private final By textFieldEmail = By.xpath(".//label[text()='Email']/following-sibling::input[@name='name']");
    // Поле для ввода "Пароль"
    private final By textFieldPassword = By.xpath(".//label[text()='Пароль']/following-sibling::input[@name='Пароль']");
    // Кнопка "Зарегистрироваться"
    private final By buttonRegister = By.cssSelector("button.button_button__33qZ0");
    // Для проверки видимости кнопки "Вход" после успешной регистрации
    private final By buttonLogin   = By.xpath(".//h2[text()='Вход']");
    // Для проверки видимости текста "Некорректный пароль"
    private final By errorIncorrectPassword = By.className("input__error");

    // Методы
    @Step ("Кликнуть по кнопке Личный кабинет")
    public void clickButtonPersonalAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement buttonPersonalAccountElement = wait.until(ExpectedConditions.elementToBeClickable(buttonPersonalAccount));
        buttonPersonalAccountElement.click();
    }

    @Step ("Кликнуть по кнопке перехода в форму Регистрация")
    public void clickButtonFormRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement buttonFormRegistrationElement = wait.until(ExpectedConditions.elementToBeClickable(buttonFormRegistration));
        buttonFormRegistrationElement.click();
    }

    @Step ("Проверить видимость формы регистрации")
    public String visibilityFormRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement formRegistrationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(formRegistration));
        return formRegistrationElement.getText();
    }

    @Step ("Заполнить форму регистрации")
    public void fillingFormRegistration(String name, String email, String password) {
        driver.findElement(textFieldName).sendKeys(name);
        driver.findElement(textFieldEmail).sendKeys(email);
        driver.findElement(textFieldPassword).sendKeys(password);
    }

    @Step ("Нажать на кнопку зарегистрироваться в форме регистрации")
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    @Step ("Проверить видимость кнопки Войти")
    public String visibilityButtonLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement buttonLoginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return buttonLoginElement.getText();
    }

    @Step ("Проверить видимость текста Некорректный пароль, при вводе пароля менее 6 символов")
    public String visibilityErrorIncorrectPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement errorIncorrectPasswordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorIncorrectPassword));
        return errorIncorrectPasswordElement.getText();
    }
}
