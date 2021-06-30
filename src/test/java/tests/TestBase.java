package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driver.manager.DriverManager;
import practice.automationtesting.in.DriverUtilities;

public class TestBase {


    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtilities.setInitialConfiguration();
        DriverUtilities.navigateToPage("http://practice.automationtesting.in/");
    }


    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
