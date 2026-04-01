package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainConstructorSectionPage {
    private WebDriver driver;

    public MainConstructorSectionPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы
    private final By buttonBun = By.xpath("//span[text()='Булки']");
    private final By buttonSauce = By.xpath("//span[text()='Соусы']");
    private final By buttonStuffing = By.xpath("//span[text()='Начинки']");
    private final By activeSectionsBun = By.xpath("//span[text()='Булки']/parent::div[contains(@class, 'tab_tab_type_current')]");
    private final By activeSectionsSauce = By.xpath("//span[text()='Соусы']/parent::div[contains(@class, 'tab_tab_type_current')]");
    private final By activeSectionsStuffing = By.xpath("//span[text()='Начинки']/parent::div[contains(@class, 'tab_tab_type_current')]");

    // Методы
    @Step("Нажать на вкладку Булки на главной странице")
    public void clickButtonBun() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement buttonBunElement = wait.until(ExpectedConditions.elementToBeClickable(buttonBun));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonBunElement);
    }

    @Step("Проверить, что вкладка Булки стала активной")
    public String returnActiveSectionsBun() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement activeSectionsBunElement = wait.until(ExpectedConditions.visibilityOfElementLocated(activeSectionsBun));
        return activeSectionsBunElement.getText();
    }

    @Step("Нажать на вкладку Соусы на главной странице")
    public void clickButtonSauce() {
        driver.findElement(buttonSauce).click();
    }

    @Step("Проверить, что вкладка Соусы стала активной ")
    public String returnActiveSectionsSauce() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement activeSectionsSauceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(activeSectionsSauce));
        return activeSectionsSauceElement.getText();
    }

    @Step("Нажать на вкладку Начинки на главной странице")
    public void clickButtonStuffing() {
        driver.findElement(buttonStuffing).click();
    }

    @Step("Проверить, что вкладка Начинки стала активной")
    public String returnActiveSectionsStuffing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement activeSectionsStuffingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(activeSectionsStuffing));
        return activeSectionsStuffingElement.getText();
    }

}
