package Base;

import Pages.KPHome;
import Pages.KPLogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class KupujemProdajemBase {
    public WebDriver driver;
    public KPHome kphome;
    public KPLogIn kplogin;
    public WebDriverWait wd;
    @BeforeClass
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Master\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        kphome = new KPHome(driver);
        kplogin = new KPLogIn(driver);
        wd = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @AfterClass
    public void Teardown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
