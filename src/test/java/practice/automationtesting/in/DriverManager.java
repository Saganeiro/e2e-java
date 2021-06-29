package practice.automationtesting.in;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class DriverManager {

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            WebDriverManager.getInstance(CHROME).setup();
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
