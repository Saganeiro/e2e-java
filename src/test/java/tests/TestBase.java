package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driver.manager.DriverManager;
import practice.automationtesting.in.DriverUtilities;

import static url.AppURLs.APPLICATION_URL;

public class TestBase {


    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtilities.setInitialConfiguration();
        DriverUtilities.navigateToPage(APPLICATION_URL);
    }


    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
