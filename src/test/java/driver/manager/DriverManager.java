package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class DriverManager {

    private static final BrowserType BROWSER_TYPE = BrowserType.CHROME;
    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)){
            driver.quit();
        }
        driver = null;
    }
}
