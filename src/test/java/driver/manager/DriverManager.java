package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;
import static driver.BrowserType.FIREFOX;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserThread = new ThreadLocal<>();


    private DriverManager() {
    }

    public static void setWebDriver(BrowserType browserType) {
        WebDriver browser = null;

        if (browserType == null) {
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

        browserThread.set(browserType);
        driverThread.set(browser);
    }

    public static WebDriver getWebDriver() {

        if (driverThread.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }
        return driverThread.get();
    }

    public static void disposeDriver() {
        driverThread.get().close();
        if (!browserThread.get().equals(FIREFOX)) {
            driverThread.get().quit();
        }
        driverThread.remove();
        browserThread.remove();
    }
}