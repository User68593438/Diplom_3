import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MainConstructorSectionPage;
import page.MainLoginPage;
import page.MainRegistrationPage;
import java.time.Duration;

public class BaseUiTest {
    WebDriver driver;
    protected MainRegistrationPage mainRegistrationPage;
    protected MainLoginPage mainLoginPage;
    protected MainConstructorSectionPage mainConstructorSectionPage;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome");

        if ("yandex".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Users/olya-/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        mainRegistrationPage = new MainRegistrationPage(driver);
        mainLoginPage = new MainLoginPage(driver);
        mainConstructorSectionPage = new MainConstructorSectionPage(driver);
    }

    // Закрыть браузер
    @After
    public void tearDown() {
        driver.quit();
    }
}


