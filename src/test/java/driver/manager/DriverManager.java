package driver.manager;

import driver.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

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
            driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
