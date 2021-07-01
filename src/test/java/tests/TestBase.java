package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.manager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import practice.automationtesting.in.DriverUtilities;

import java.util.Properties;

import static url.AppURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

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
